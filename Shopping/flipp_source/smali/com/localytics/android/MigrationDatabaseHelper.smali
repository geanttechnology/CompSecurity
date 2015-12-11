.class final Lcom/localytics/android/MigrationDatabaseHelper;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "SourceFile"


# static fields
.field private static final CLOSE_EVENT:Ljava/lang/String;

.field private static final EVENTS_SORT_ORDER:Ljava/lang/String;

.field private static final EVENT_FORMAT:Ljava/lang/String; = "%s:%s"

.field private static final FLOW_EVENT:Ljava/lang/String;

.field private static final JOINER_ARG_UPLOAD_EVENTS_COLUMNS:[Ljava/lang/String;

.field private static final OPEN_EVENT:Ljava/lang/String;

.field private static final OPT_IN_EVENT:Ljava/lang/String;

.field private static final OPT_OUT_EVENT:Ljava/lang/String;

.field private static final PROJECTION_UPLOAD_BLOBS:[Ljava/lang/String;

.field private static final PROJECTION_UPLOAD_EVENTS:[Ljava/lang/String;

.field private static final SELECTION_UPLOAD_NULL_BLOBS:Ljava/lang/String;

.field private static final UPLOAD_BLOBS_EVENTS_SORT_ORDER:Ljava/lang/String;


# instance fields
.field private mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 32
    const-string v0, "%s:%s"

    new-array v1, v5, [Ljava/lang/Object;

    const-string v2, "com.localytics.android"

    aput-object v2, v1, v3

    const-string v2, "open"

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/localytics/android/MigrationDatabaseHelper;->OPEN_EVENT:Ljava/lang/String;

    .line 36
    const-string v0, "%s:%s"

    new-array v1, v5, [Ljava/lang/Object;

    const-string v2, "com.localytics.android"

    aput-object v2, v1, v3

    const-string v2, "close"

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/localytics/android/MigrationDatabaseHelper;->CLOSE_EVENT:Ljava/lang/String;

    .line 40
    const-string v0, "%s:%s"

    new-array v1, v5, [Ljava/lang/Object;

    const-string v2, "com.localytics.android"

    aput-object v2, v1, v3

    const-string v2, "opt_in"

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/localytics/android/MigrationDatabaseHelper;->OPT_IN_EVENT:Ljava/lang/String;

    .line 44
    const-string v0, "%s:%s"

    new-array v1, v5, [Ljava/lang/Object;

    const-string v2, "com.localytics.android"

    aput-object v2, v1, v3

    const-string v2, "opt_out"

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/localytics/android/MigrationDatabaseHelper;->OPT_OUT_EVENT:Ljava/lang/String;

    .line 45
    const-string v0, "%s:%s"

    new-array v1, v5, [Ljava/lang/Object;

    const-string v2, "com.localytics.android"

    aput-object v2, v1, v3

    const-string v2, "flow"

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/localytics/android/MigrationDatabaseHelper;->FLOW_EVENT:Ljava/lang/String;

    .line 52
    const-string v0, "CAST(%s as TEXT)"

    new-array v1, v4, [Ljava/lang/Object;

    const-string v2, "_id"

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/localytics/android/MigrationDatabaseHelper;->EVENTS_SORT_ORDER:Ljava/lang/String;

    .line 57
    new-array v0, v4, [Ljava/lang/String;

    const-string v1, "events_key_ref"

    aput-object v1, v0, v3

    sput-object v0, Lcom/localytics/android/MigrationDatabaseHelper;->PROJECTION_UPLOAD_BLOBS:[Ljava/lang/String;

    .line 64
    const-string v0, "CAST(%s AS TEXT)"

    new-array v1, v4, [Ljava/lang/Object;

    const-string v2, "events_key_ref"

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/localytics/android/MigrationDatabaseHelper;->UPLOAD_BLOBS_EVENTS_SORT_ORDER:Ljava/lang/String;

    .line 69
    new-array v0, v4, [Ljava/lang/String;

    const-string v1, "_id"

    aput-object v1, v0, v3

    sput-object v0, Lcom/localytics/android/MigrationDatabaseHelper;->JOINER_ARG_UPLOAD_EVENTS_COLUMNS:[Ljava/lang/String;

    .line 75
    const-string v0, "%s IS NULL"

    new-array v1, v4, [Ljava/lang/Object;

    const-string v2, "processed_in_blob"

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/localytics/android/MigrationDatabaseHelper;->SELECTION_UPLOAD_NULL_BLOBS:Ljava/lang/String;

    .line 80
    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "_id"

    aput-object v1, v0, v3

    const-string v1, "event_name"

    aput-object v1, v0, v4

    const-string v1, "wall_time"

    aput-object v1, v0, v5

    sput-object v0, Lcom/localytics/android/MigrationDatabaseHelper;->PROJECTION_UPLOAD_EVENTS:[Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;ILcom/localytics/android/LocalyticsDao;)V
    .locals 2

    .prologue
    .line 94
    invoke-interface {p3}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, v0, p1, v1, p2}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 95
    iput-object p3, p0, Lcom/localytics/android/MigrationDatabaseHelper;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    .line 96
    return-void
.end method

.method private static convertAttributesToJson(Landroid/database/sqlite/SQLiteDatabase;Landroid/content/Context;J)Lorg/json/JSONObject;
    .locals 10

    .prologue
    const/4 v8, 0x0

    .line 2214
    .line 2217
    :try_start_0
    const-string v1, "attributes"

    const/4 v2, 0x0

    const-string v0, "%s = ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ?"

    const/16 v3, 0xb

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "events_key_ref"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string v5, "attribute_key"

    aput-object v5, v3, v4

    const/4 v4, 0x2

    const-string v5, "attribute_key"

    aput-object v5, v3, v4

    const/4 v4, 0x3

    const-string v5, "attribute_key"

    aput-object v5, v3, v4

    const/4 v4, 0x4

    const-string v5, "attribute_key"

    aput-object v5, v3, v4

    const/4 v4, 0x5

    const-string v5, "attribute_key"

    aput-object v5, v3, v4

    const/4 v4, 0x6

    const-string v5, "attribute_key"

    aput-object v5, v3, v4

    const/4 v4, 0x7

    const-string v5, "attribute_key"

    aput-object v5, v3, v4

    const/16 v4, 0x8

    const-string v5, "attribute_key"

    aput-object v5, v3, v4

    const/16 v4, 0x9

    const-string v5, "attribute_key"

    aput-object v5, v3, v4

    const/16 v4, 0xa

    const-string v5, "attribute_key"

    aput-object v5, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/16 v0, 0xb

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {p2, p3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v0

    const/4 v0, 0x1

    sget-object v5, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_1:Ljava/lang/String;

    aput-object v5, v4, v0

    const/4 v0, 0x2

    sget-object v5, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_2:Ljava/lang/String;

    aput-object v5, v4, v0

    const/4 v0, 0x3

    sget-object v5, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_3:Ljava/lang/String;

    aput-object v5, v4, v0

    const/4 v0, 0x4

    sget-object v5, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_4:Ljava/lang/String;

    aput-object v5, v4, v0

    const/4 v0, 0x5

    sget-object v5, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_5:Ljava/lang/String;

    aput-object v5, v4, v0

    const/4 v0, 0x6

    sget-object v5, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_6:Ljava/lang/String;

    aput-object v5, v4, v0

    const/4 v0, 0x7

    sget-object v5, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_7:Ljava/lang/String;

    aput-object v5, v4, v0

    const/16 v0, 0x8

    sget-object v5, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_8:Ljava/lang/String;

    aput-object v5, v4, v0

    const/16 v0, 0x9

    sget-object v5, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_9:Ljava/lang/String;

    aput-object v5, v4, v0

    const/16 v0, 0xa

    sget-object v5, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_10:Ljava/lang/String;

    aput-object v5, v4, v0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v1

    .line 2219
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    if-nez v0, :cond_2

    .line 2221
    if-eqz v1, :cond_0

    .line 2242
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_0
    move-object v0, v8

    .line 2243
    :cond_1
    :goto_0
    return-object v0

    .line 2224
    :cond_2
    :try_start_2
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 2226
    const-string v2, "attribute_key"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    .line 2227
    const-string v3, "attribute_value"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    .line 2228
    :goto_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v4

    if-eqz v4, :cond_4

    .line 2230
    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 2231
    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 2233
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    add-int/lit8 v6, v6, 0x1

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v7

    invoke-virtual {v4, v6, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 2240
    :catchall_0
    move-exception v0

    move-object v8, v1

    :goto_2
    if-eqz v8, :cond_3

    .line 2242
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 2243
    :cond_3
    throw v0

    .line 2240
    :cond_4
    if-eqz v1, :cond_1

    .line 2242
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 2240
    :catchall_1
    move-exception v0

    goto :goto_2
.end method

.method static convertDatabaseToJson(Landroid/content/Context;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/util/List;
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/database/sqlite/SQLiteDatabase;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lorg/json/JSONObject;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2115
    new-instance v12, Ljava/util/LinkedList;

    invoke-direct {v12}, Ljava/util/LinkedList;-><init>()V

    .line 2116
    const/4 v10, 0x0

    .line 2119
    :try_start_0
    const-string v3, "upload_blobs"

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    move-object/from16 v2, p1

    invoke-virtual/range {v2 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    move-result-object v11

    .line 2121
    :try_start_1
    invoke-static/range {p1 .. p2}, Lcom/localytics/android/MigrationDatabaseHelper;->getApiKeyCreationTime(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)J

    move-result-wide v14

    .line 2123
    const-string v2, "_id"

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v13

    .line 2124
    const-string v2, "uuid"

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v16

    .line 2125
    :cond_0
    :goto_0
    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v2

    if-eqz v2, :cond_1

    .line 2129
    :try_start_2
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 2131
    const-string v3, "dt"

    const-string v4, "h"

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2132
    const-string v3, "pa"

    invoke-virtual {v2, v3, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 2133
    const-string v3, "seq"

    invoke-interface {v11, v13}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    invoke-virtual {v2, v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 2134
    const-string v3, "u"

    move/from16 v0, v16

    invoke-interface {v11, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2135
    invoke-interface {v11, v13}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    move-object/from16 v0, p1

    invoke-static {v0, v4, v5}, Lcom/localytics/android/MigrationDatabaseHelper;->getSessionIdForBlobId(Landroid/database/sqlite/SQLiteDatabase;J)J

    move-result-wide v4

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-static {v0, v1, v4, v5}, Lcom/localytics/android/MigrationDatabaseHelper;->getAttributesFromSession(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;J)Lorg/json/JSONObject;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v3

    .line 2136
    if-nez v3, :cond_3

    .line 2190
    :cond_1
    if-eqz v11, :cond_2

    .line 2192
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 2197
    :cond_2
    const-string v2, "JSON result is %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v12}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 2199
    return-object v12

    .line 2142
    :cond_3
    :try_start_3
    const-string v4, "attrs"

    invoke-virtual {v2, v4, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2145
    invoke-static/range {p1 .. p1}, Lcom/localytics/android/MigrationDatabaseHelper;->getIdentifiers(Landroid/database/sqlite/SQLiteDatabase;)Lorg/json/JSONObject;

    move-result-object v3

    .line 2146
    if-eqz v3, :cond_4

    .line 2148
    const-string v4, "ids"

    invoke-virtual {v2, v4, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2151
    :cond_4
    invoke-interface {v12, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 2153
    invoke-virtual {v12}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 2155
    const/4 v10, 0x0

    .line 2158
    :try_start_4
    const-string v3, "upload_blob_events"

    const/4 v2, 0x2

    new-array v4, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v5, "_id"

    aput-object v5, v4, v2

    const/4 v2, 0x1

    const-string v5, "events_key_ref"

    aput-object v5, v4, v2

    const-string v2, "%s = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    const-string v7, "upload_blobs_key_ref"

    aput-object v7, v5, v6

    invoke-static {v2, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const/4 v2, 0x1

    new-array v6, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-interface {v11, v13}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v2

    const/4 v7, 0x0

    const/4 v8, 0x0

    const-string v9, "events_key_ref"

    move-object/from16 v2, p1

    invoke-virtual/range {v2 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    move-result-object v9

    .line 2160
    :try_start_5
    const-string v2, "events_key_ref"

    invoke-interface {v9, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v10

    .line 2161
    :goto_1
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_7

    .line 2163
    invoke-interface {v12}, Ljava/util/List;->size()I

    move-result v2

    const/16 v3, 0x64

    if-ge v2, v3, :cond_7

    .line 2165
    invoke-interface {v9, v10}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    invoke-interface {v11, v13}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    move-object/from16 v2, p1

    move-object/from16 v3, p0

    move-object/from16 v8, p2

    invoke-static/range {v2 .. v8}, Lcom/localytics/android/MigrationDatabaseHelper;->convertEventToJson(Landroid/database/sqlite/SQLiteDatabase;Landroid/content/Context;JJLjava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    invoke-interface {v12, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 2166
    const-string v2, "upload_blob_events"

    const-string v3, "%s = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string v6, "_id"

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v6, "_id"

    invoke-interface {v9, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v9, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_1

    .line 2176
    :catchall_0
    move-exception v2

    move-object v3, v9

    :goto_2
    if-eqz v3, :cond_5

    .line 2178
    :try_start_6
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    :cond_5
    throw v2
    :try_end_6
    .catch Lorg/json/JSONException; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 2182
    :catch_0
    move-exception v2

    .line 2184
    :try_start_7
    const-string v3, "Caught exception"

    invoke-static {v3, v2}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    goto/16 :goto_0

    .line 2190
    :catchall_1
    move-exception v2

    move-object v3, v11

    :goto_3
    if-eqz v3, :cond_6

    .line 2192
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    .line 2193
    :cond_6
    throw v2

    .line 2176
    :cond_7
    if-eqz v9, :cond_0

    .line 2178
    :try_start_8
    invoke-interface {v9}, Landroid/database/Cursor;->close()V
    :try_end_8
    .catch Lorg/json/JSONException; {:try_start_8 .. :try_end_8} :catch_0
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    goto/16 :goto_0

    .line 2190
    :catchall_2
    move-exception v2

    move-object v3, v10

    goto :goto_3

    .line 2176
    :catchall_3
    move-exception v2

    move-object v3, v10

    goto :goto_2
.end method

.method private static convertEventToJson(Landroid/database/sqlite/SQLiteDatabase;Landroid/content/Context;JJLjava/lang/String;)Lorg/json/JSONObject;
    .locals 18

    .prologue
    .line 1615
    new-instance v14, Lorg/json/JSONObject;

    invoke-direct {v14}, Lorg/json/JSONObject;-><init>()V

    .line 1617
    const/4 v12, 0x0

    .line 1621
    :try_start_0
    const-string v5, "events"

    const/4 v6, 0x0

    const-string v4, "%s = ?"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    const-string v9, "_id"

    aput-object v9, v7, v8

    invoke-static {v4, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    const/4 v4, 0x1

    new-array v8, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static/range {p2 .. p3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v4

    const/4 v9, 0x0

    const/4 v10, 0x0

    const-string v11, "_id"

    move-object/from16 v4, p0

    invoke-virtual/range {v4 .. v11}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_7

    move-result-object v13

    .line 1623
    :try_start_1
    invoke-interface {v13}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_44

    .line 1625
    const-string v4, "event_name"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 1626
    move-object/from16 v0, p0

    move-wide/from16 v1, p2

    invoke-static {v0, v1, v2}, Lcom/localytics/android/MigrationDatabaseHelper;->getSessionIdForEventId(Landroid/database/sqlite/SQLiteDatabase;J)J

    move-result-wide v16

    .line 1627
    move-object/from16 v0, p0

    move-wide/from16 v1, v16

    invoke-static {v0, v1, v2}, Lcom/localytics/android/MigrationDatabaseHelper;->getSessionUuid(Landroid/database/sqlite/SQLiteDatabase;J)Ljava/lang/String;

    move-result-object v5

    .line 1628
    move-object/from16 v0, p0

    move-wide/from16 v1, v16

    invoke-static {v0, v1, v2}, Lcom/localytics/android/MigrationDatabaseHelper;->getSessionStartTime(Landroid/database/sqlite/SQLiteDatabase;J)J

    move-result-wide v6

    .line 1630
    sget-object v8, Lcom/localytics/android/MigrationDatabaseHelper;->OPEN_EVENT:Ljava/lang/String;

    invoke-virtual {v8, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_13

    .line 1632
    const-string v4, "dt"

    const-string v6, "s"

    invoke-virtual {v14, v4, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1633
    const-string v4, "ct"

    const-string v6, "wall_time"

    invoke-interface {v13, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v13, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    long-to-double v6, v6

    const-wide v8, 0x408f400000000000L    # 1000.0

    div-double/2addr v6, v8

    invoke-static {v6, v7}, Ljava/lang/Math;->round(D)J

    move-result-wide v6

    invoke-virtual {v14, v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 1634
    const-string v4, "u"

    invoke-virtual {v14, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1636
    move-object/from16 v0, p0

    move-wide/from16 v1, v16

    invoke-static {v0, v1, v2}, Lcom/localytics/android/MigrationDatabaseHelper;->getElapsedTimeSinceLastSession(Landroid/database/sqlite/SQLiteDatabase;J)J

    move-result-wide v4

    .line 1637
    const-wide/16 v6, 0x0

    cmp-long v6, v4, v6

    if-lez v6, :cond_0

    .line 1639
    const-string v6, "sl"

    const-wide/16 v8, 0x3e8

    div-long/2addr v4, v8

    long-to-float v4, v4

    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v4

    invoke-virtual {v14, v6, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 1645
    :cond_0
    const-string v4, "nth"

    move-wide/from16 v0, v16

    invoke-virtual {v14, v4, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 1650
    const-string v4, "event_lat"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->isNull(I)Z

    move-result v4

    if-nez v4, :cond_1

    const-string v4, "event_lng"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->isNull(I)Z

    move-result v4

    if-nez v4, :cond_1

    .line 1652
    const-string v4, "event_lat"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v4

    .line 1653
    const-string v6, "event_lng"

    invoke-interface {v13, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v13, v6}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v6

    .line 1655
    const-wide/16 v8, 0x0

    cmpl-double v8, v4, v8

    if-eqz v8, :cond_1

    const-wide/16 v8, 0x0

    cmpl-double v8, v6, v8

    if-eqz v8, :cond_1

    .line 1657
    const-string v8, "lat"

    invoke-virtual {v14, v8, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;

    .line 1658
    const-string v4, "lng"

    invoke-virtual {v14, v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;

    .line 1662
    :cond_1
    const-string v4, "customer_id"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->isNull(I)Z

    move-result v4

    if-nez v4, :cond_2

    .line 1664
    const-string v4, "customer_id"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 1665
    const-string v5, "user_type"

    invoke-interface {v13, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v13, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 1667
    const-string v6, "cid"

    invoke-virtual {v14, v6, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1668
    const-string v4, "utp"

    invoke-virtual {v14, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1671
    :cond_2
    const-string v4, "ids"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->isNull(I)Z

    move-result v4

    if-nez v4, :cond_3

    .line 1673
    const-string v4, "ids"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 1674
    const-string v5, "ids"

    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6, v4}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-virtual {v14, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 1680
    :cond_3
    const/4 v12, 0x0

    .line 1683
    :try_start_2
    const-string v5, "attributes"

    const/4 v6, 0x0

    const-string v4, "%s = ?"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    const-string v9, "events_key_ref"

    aput-object v9, v7, v8

    invoke-static {v4, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    const/4 v4, 0x1

    new-array v8, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static/range {p2 .. p3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v4

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    move-object/from16 v4, p0

    invoke-virtual/range {v4 .. v11}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_d

    move-result-object v5

    .line 1685
    :try_start_3
    const-string v4, "attribute_key"

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    .line 1686
    const-string v6, "attribute_value"

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    .line 1687
    :cond_4
    :goto_0
    invoke-interface {v5}, Landroid/database/Cursor;->moveToNext()Z

    move-result v7

    if-eqz v7, :cond_10

    .line 1689
    invoke-interface {v5, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 1690
    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 1692
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_1:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_7

    .line 1694
    const/4 v7, 0x1

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 1736
    :catchall_0
    move-exception v4

    :goto_1
    if-eqz v5, :cond_5

    .line 1738
    :try_start_4
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    .line 1739
    :cond_5
    throw v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 2098
    :catchall_1
    move-exception v4

    move-object v5, v13

    :goto_2
    if-eqz v5, :cond_6

    .line 2100
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    .line 2101
    :cond_6
    throw v4

    .line 1696
    :cond_7
    :try_start_5
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_2:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_8

    .line 1698
    const/4 v7, 0x2

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_0

    .line 1700
    :cond_8
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_3:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_9

    .line 1702
    const/4 v7, 0x3

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_0

    .line 1704
    :cond_9
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_4:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_a

    .line 1706
    const/4 v7, 0x4

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_0

    .line 1708
    :cond_a
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_5:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_b

    .line 1710
    const/4 v7, 0x5

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_0

    .line 1712
    :cond_b
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_6:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_c

    .line 1714
    const/4 v7, 0x6

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_0

    .line 1716
    :cond_c
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_7:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_d

    .line 1718
    const/4 v7, 0x7

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_0

    .line 1720
    :cond_d
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_8:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_e

    .line 1722
    const/16 v7, 0x8

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_0

    .line 1724
    :cond_e
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_9:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_f

    .line 1726
    const/16 v7, 0x9

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_0

    .line 1728
    :cond_f
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_10:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 1730
    const/16 v7, 0xa

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto/16 :goto_0

    .line 1736
    :cond_10
    if-eqz v5, :cond_11

    .line 1738
    :try_start_6
    invoke-interface {v5}, Landroid/database/Cursor;->close()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 2098
    :cond_11
    :goto_3
    if-eqz v13, :cond_12

    .line 2100
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    .line 2105
    :cond_12
    return-object v14

    .line 1743
    :cond_13
    :try_start_7
    sget-object v8, Lcom/localytics/android/MigrationDatabaseHelper;->CLOSE_EVENT:Ljava/lang/String;

    invoke-virtual {v8, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_2a

    .line 1745
    const-string v4, "dt"

    const-string v8, "c"

    invoke-virtual {v14, v4, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1746
    const-string v4, "u"

    const-string v8, "uuid"

    invoke-interface {v13, v8}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v8

    invoke-interface {v13, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v14, v4, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1747
    const-string v4, "su"

    invoke-virtual {v14, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1748
    const-string v4, "ss"

    long-to-double v6, v6

    const-wide v8, 0x408f400000000000L    # 1000.0

    div-double/2addr v6, v8

    invoke-static {v6, v7}, Ljava/lang/Math;->round(D)J

    move-result-wide v6

    invoke-virtual {v14, v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 1749
    const-string v4, "ct"

    const-string v5, "wall_time"

    invoke-interface {v13, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v13, v5}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    long-to-double v6, v6

    const-wide v8, 0x408f400000000000L    # 1000.0

    div-double/2addr v6, v8

    invoke-static {v6, v7}, Ljava/lang/Math;->round(D)J

    move-result-wide v6

    invoke-virtual {v14, v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 1754
    const/4 v12, 0x0

    .line 1757
    :try_start_8
    const-string v5, "sessions"

    const/4 v4, 0x1

    new-array v6, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v7, "session_start_wall_time"

    aput-object v7, v6, v4

    const-string v4, "%s = ?"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    const-string v9, "_id"

    aput-object v9, v7, v8

    invoke-static {v4, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    const/4 v4, 0x1

    new-array v8, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v9, "session_key_ref"

    invoke-interface {v13, v9}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v9

    invoke-interface {v13, v9}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v4

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    move-object/from16 v4, p0

    invoke-virtual/range {v4 .. v11}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_c

    move-result-object v5

    .line 1759
    :try_start_9
    invoke-interface {v5}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_16

    .line 1761
    const-string v4, "ctl"

    const-string v6, "wall_time"

    invoke-interface {v13, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v13, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    long-to-double v6, v6

    const-wide v8, 0x408f400000000000L    # 1000.0

    div-double/2addr v6, v8

    invoke-static {v6, v7}, Ljava/lang/Math;->round(D)J

    move-result-wide v6

    const-string v8, "session_start_wall_time"

    invoke-interface {v5, v8}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v8

    invoke-interface {v5, v8}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    long-to-double v8, v8

    const-wide v10, 0x408f400000000000L    # 1000.0

    div-double/2addr v8, v10

    invoke-static {v8, v9}, Ljava/lang/Math;->round(D)J

    move-result-wide v8

    sub-long/2addr v6, v8

    invoke-virtual {v14, v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_3

    .line 1771
    if-eqz v5, :cond_14

    .line 1773
    :try_start_a
    invoke-interface {v5}, Landroid/database/Cursor;->close()V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    .line 1781
    :cond_14
    const/4 v12, 0x0

    .line 1784
    :try_start_b
    const-string v5, "event_history"

    const/4 v4, 0x1

    new-array v6, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v7, "name"

    aput-object v7, v6, v4

    const-string v4, "%s = ? AND %s = ?"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    const-string v9, "session_key_ref"

    aput-object v9, v7, v8

    const/4 v8, 0x1

    const-string v9, "type"

    aput-object v9, v7, v8

    invoke-static {v4, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    const/4 v4, 0x2

    new-array v8, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v4

    const/4 v4, 0x1

    const/4 v9, 0x1

    invoke-static {v9}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v4

    const/4 v9, 0x0

    const/4 v10, 0x0

    const-string v11, "_id"

    move-object/from16 v4, p0

    invoke-virtual/range {v4 .. v11}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_b

    move-result-object v5

    .line 1786
    :try_start_c
    new-instance v4, Lorg/json/JSONArray;

    invoke-direct {v4}, Lorg/json/JSONArray;-><init>()V

    .line 1787
    :goto_4
    invoke-interface {v5}, Landroid/database/Cursor;->moveToNext()Z

    move-result v6

    if-eqz v6, :cond_18

    .line 1789
    const-string v6, "name"

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_2

    goto :goto_4

    .line 1799
    :catchall_2
    move-exception v4

    :goto_5
    if-eqz v5, :cond_15

    .line 1801
    :try_start_d
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    .line 1802
    :cond_15
    throw v4
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_1

    .line 1766
    :cond_16
    :try_start_e
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v6, "Session didn\'t exist"

    invoke-direct {v4, v6}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_3

    .line 1771
    :catchall_3
    move-exception v4

    :goto_6
    if-eqz v5, :cond_17

    .line 1773
    :try_start_f
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    .line 1774
    :cond_17
    throw v4
    :try_end_f
    .catchall {:try_start_f .. :try_end_f} :catchall_1

    .line 1792
    :cond_18
    :try_start_10
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v6

    if-lez v6, :cond_19

    .line 1794
    const-string v6, "fl"

    invoke-virtual {v14, v6, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_10
    .catchall {:try_start_10 .. :try_end_10} :catchall_2

    .line 1799
    :cond_19
    if-eqz v5, :cond_1a

    .line 1801
    :try_start_11
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    .line 1809
    :cond_1a
    const-string v4, "event_lat"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->isNull(I)Z

    move-result v4

    if-nez v4, :cond_1b

    const-string v4, "event_lng"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->isNull(I)Z

    move-result v4

    if-nez v4, :cond_1b

    .line 1811
    const-string v4, "event_lat"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v4

    .line 1812
    const-string v6, "event_lng"

    invoke-interface {v13, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v13, v6}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v6

    .line 1814
    const-wide/16 v8, 0x0

    cmpl-double v8, v4, v8

    if-eqz v8, :cond_1b

    const-wide/16 v8, 0x0

    cmpl-double v8, v6, v8

    if-eqz v8, :cond_1b

    .line 1816
    const-string v8, "lat"

    invoke-virtual {v14, v8, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;

    .line 1817
    const-string v4, "lng"

    invoke-virtual {v14, v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;

    .line 1821
    :cond_1b
    const-string v4, "customer_id"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->isNull(I)Z

    move-result v4

    if-nez v4, :cond_1c

    .line 1823
    const-string v4, "customer_id"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 1824
    const-string v5, "user_type"

    invoke-interface {v13, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v13, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 1826
    const-string v6, "cid"

    invoke-virtual {v14, v6, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1827
    const-string v4, "utp"

    invoke-virtual {v14, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1830
    :cond_1c
    const-string v4, "ids"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->isNull(I)Z

    move-result v4

    if-nez v4, :cond_1d

    .line 1832
    const-string v4, "ids"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 1833
    const-string v5, "ids"

    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6, v4}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-virtual {v14, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_1

    .line 1839
    :cond_1d
    const/4 v12, 0x0

    .line 1842
    :try_start_12
    const-string v5, "attributes"

    const/4 v6, 0x0

    const-string v4, "%s = ?"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    const-string v9, "events_key_ref"

    aput-object v9, v7, v8

    invoke-static {v4, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    const/4 v4, 0x1

    new-array v8, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static/range {p2 .. p3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v4

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    move-object/from16 v4, p0

    invoke-virtual/range {v4 .. v11}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_12
    .catchall {:try_start_12 .. :try_end_12} :catchall_a

    move-result-object v5

    .line 1844
    :try_start_13
    const-string v4, "attribute_key"

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    .line 1845
    const-string v6, "attribute_value"

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    .line 1846
    :cond_1e
    :goto_7
    invoke-interface {v5}, Landroid/database/Cursor;->moveToNext()Z

    move-result v7

    if-eqz v7, :cond_29

    .line 1848
    invoke-interface {v5, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 1849
    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 1851
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_1:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_20

    .line 1853
    const/4 v7, 0x1

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_13
    .catchall {:try_start_13 .. :try_end_13} :catchall_4

    goto :goto_7

    .line 1895
    :catchall_4
    move-exception v4

    :goto_8
    if-eqz v5, :cond_1f

    .line 1897
    :try_start_14
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    .line 1898
    :cond_1f
    throw v4
    :try_end_14
    .catchall {:try_start_14 .. :try_end_14} :catchall_1

    .line 1855
    :cond_20
    :try_start_15
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_2:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_21

    .line 1857
    const/4 v7, 0x2

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_7

    .line 1859
    :cond_21
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_3:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_22

    .line 1861
    const/4 v7, 0x3

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_7

    .line 1863
    :cond_22
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_4:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_23

    .line 1865
    const/4 v7, 0x4

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_7

    .line 1867
    :cond_23
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_5:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_24

    .line 1869
    const/4 v7, 0x5

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_7

    .line 1871
    :cond_24
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_6:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_25

    .line 1873
    const/4 v7, 0x6

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_7

    .line 1875
    :cond_25
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_7:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_26

    .line 1877
    const/4 v7, 0x7

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_7

    .line 1879
    :cond_26
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_8:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_27

    .line 1881
    const/16 v7, 0x8

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_7

    .line 1883
    :cond_27
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_9:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_28

    .line 1885
    const/16 v7, 0x9

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_7

    .line 1887
    :cond_28
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_10:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1e

    .line 1889
    const/16 v7, 0xa

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_15
    .catchall {:try_start_15 .. :try_end_15} :catchall_4

    goto/16 :goto_7

    .line 1895
    :cond_29
    if-eqz v5, :cond_11

    .line 1897
    :try_start_16
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    goto/16 :goto_3

    .line 1902
    :cond_2a
    sget-object v8, Lcom/localytics/android/MigrationDatabaseHelper;->OPT_IN_EVENT:Ljava/lang/String;

    invoke-virtual {v8, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_2b

    sget-object v8, Lcom/localytics/android/MigrationDatabaseHelper;->OPT_OUT_EVENT:Ljava/lang/String;

    invoke-virtual {v8, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_2d

    .line 1904
    :cond_2b
    const-string v5, "dt"

    const-string v6, "o"

    invoke-virtual {v14, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1905
    const-string v5, "u"

    move-object/from16 v0, p6

    invoke-virtual {v14, v5, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1906
    const-string v5, "out"

    sget-object v6, Lcom/localytics/android/MigrationDatabaseHelper;->OPT_OUT_EVENT:Ljava/lang/String;

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2c

    sget-object v4, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->toString()Ljava/lang/String;

    move-result-object v4

    :goto_9
    invoke-virtual {v14, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1907
    const-string v4, "ct"

    const-string v5, "wall_time"

    invoke-interface {v13, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v13, v5}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    long-to-double v6, v6

    const-wide v8, 0x408f400000000000L    # 1000.0

    div-double/2addr v6, v8

    invoke-static {v6, v7}, Ljava/lang/Math;->round(D)J

    move-result-wide v6

    invoke-virtual {v14, v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    goto/16 :goto_3

    .line 1906
    :cond_2c
    sget-object v4, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_9

    .line 1909
    :cond_2d
    sget-object v8, Lcom/localytics/android/MigrationDatabaseHelper;->FLOW_EVENT:Ljava/lang/String;

    invoke-virtual {v8, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_32

    .line 1911
    const-string v4, "dt"

    const-string v5, "f"

    invoke-virtual {v14, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1912
    const-string v4, "u"

    const-string v5, "uuid"

    invoke-interface {v13, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v13, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v14, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1913
    const-string v4, "ss"

    long-to-double v6, v6

    const-wide v8, 0x408f400000000000L    # 1000.0

    div-double/2addr v6, v8

    invoke-static {v6, v7}, Ljava/lang/Math;->round(D)J

    move-result-wide v6

    invoke-virtual {v14, v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;
    :try_end_16
    .catchall {:try_start_16 .. :try_end_16} :catchall_1

    .line 1922
    const/4 v12, 0x0

    .line 1925
    :try_start_17
    const-string v5, "event_history"

    const/4 v4, 0x3

    new-array v6, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v7, "type"

    aput-object v7, v6, v4

    const/4 v4, 0x1

    const-string v7, "processed_in_blob"

    aput-object v7, v6, v4

    const/4 v4, 0x2

    const-string v7, "name"

    aput-object v7, v6, v4

    const-string v4, "%s = ? AND %s <= ?"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    const-string v9, "session_key_ref"

    aput-object v9, v7, v8

    const/4 v8, 0x1

    const-string v9, "processed_in_blob"

    aput-object v9, v7, v8

    invoke-static {v4, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    const/4 v4, 0x2

    new-array v8, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v4

    const/4 v4, 0x1

    invoke-static/range {p4 .. p5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v4

    const/4 v9, 0x0

    const/4 v10, 0x0

    const-string v11, "_id"

    move-object/from16 v4, p0

    invoke-virtual/range {v4 .. v11}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_17
    .catchall {:try_start_17 .. :try_end_17} :catchall_9

    move-result-object v5

    .line 1927
    :try_start_18
    new-instance v6, Lorg/json/JSONArray;

    invoke-direct {v6}, Lorg/json/JSONArray;-><init>()V

    .line 1928
    new-instance v7, Lorg/json/JSONArray;

    invoke-direct {v7}, Lorg/json/JSONArray;-><init>()V

    .line 1929
    :goto_a
    invoke-interface {v5}, Landroid/database/Cursor;->moveToNext()Z

    move-result v4

    if-eqz v4, :cond_31

    .line 1931
    const-string v4, "name"

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 1933
    const-string v4, "type"

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    if-nez v4, :cond_2f

    .line 1935
    const-string v4, "e"

    .line 1942
    :goto_b
    const-string v9, "processed_in_blob"

    invoke-interface {v5, v9}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v9

    invoke-interface {v5, v9}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v10

    cmp-long v9, p4, v10

    if-nez v9, :cond_30

    .line 1944
    new-instance v9, Lorg/json/JSONObject;

    invoke-direct {v9}, Lorg/json/JSONObject;-><init>()V

    invoke-virtual {v9, v4, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v4

    invoke-virtual {v6, v4}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_18
    .catchall {:try_start_18 .. :try_end_18} :catchall_5

    goto :goto_a

    .line 1957
    :catchall_5
    move-exception v4

    :goto_c
    if-eqz v5, :cond_2e

    .line 1959
    :try_start_19
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    .line 1960
    :cond_2e
    throw v4
    :try_end_19
    .catchall {:try_start_19 .. :try_end_19} :catchall_1

    .line 1939
    :cond_2f
    :try_start_1a
    const-string v4, "s"

    goto :goto_b

    .line 1948
    :cond_30
    new-instance v9, Lorg/json/JSONObject;

    invoke-direct {v9}, Lorg/json/JSONObject;-><init>()V

    invoke-virtual {v9, v4, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v4

    invoke-virtual {v7, v4}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_a

    .line 1952
    :cond_31
    const-string v4, "nw"

    invoke-virtual {v14, v4, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1953
    const-string v4, "od"

    invoke-virtual {v14, v4, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1a
    .catchall {:try_start_1a .. :try_end_1a} :catchall_5

    .line 1957
    if-eqz v5, :cond_11

    .line 1959
    :try_start_1b
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    goto/16 :goto_3

    .line 1969
    :cond_32
    const-string v6, "dt"

    const-string v7, "e"

    invoke-virtual {v14, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1970
    const-string v6, "ct"

    const-string v7, "wall_time"

    invoke-interface {v13, v7}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    invoke-interface {v13, v7}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    long-to-double v8, v8

    const-wide v10, 0x408f400000000000L    # 1000.0

    div-double/2addr v8, v10

    invoke-static {v8, v9}, Ljava/lang/Math;->round(D)J

    move-result-wide v8

    invoke-virtual {v14, v6, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 1971
    const-string v6, "u"

    const-string v7, "uuid"

    invoke-interface {v13, v7}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v7

    invoke-interface {v13, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1972
    const-string v6, "su"

    invoke-virtual {v14, v6, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1973
    const-string v5, "n"

    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    add-int/lit8 v6, v6, 0x1

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v7

    invoke-virtual {v4, v6, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v14, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1978
    const-string v4, "clv_increase"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    .line 1979
    const-wide/16 v6, 0x0

    cmp-long v6, v4, v6

    if-eqz v6, :cond_33

    .line 1981
    const-string v6, "v"

    invoke-virtual {v14, v6, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 1987
    :cond_33
    const-string v4, "event_lat"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->isNull(I)Z

    move-result v4

    if-nez v4, :cond_34

    const-string v4, "event_lng"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->isNull(I)Z

    move-result v4

    if-nez v4, :cond_34

    .line 1989
    const-string v4, "event_lat"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v4

    .line 1990
    const-string v6, "event_lng"

    invoke-interface {v13, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v13, v6}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v6

    .line 1992
    const-wide/16 v8, 0x0

    cmpl-double v8, v4, v8

    if-eqz v8, :cond_34

    const-wide/16 v8, 0x0

    cmpl-double v8, v6, v8

    if-eqz v8, :cond_34

    .line 1994
    const-string v8, "lat"

    invoke-virtual {v14, v8, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;

    .line 1995
    const-string v4, "lng"

    invoke-virtual {v14, v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;

    .line 1999
    :cond_34
    const-string v4, "customer_id"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->isNull(I)Z

    move-result v4

    if-nez v4, :cond_35

    .line 2001
    const-string v4, "customer_id"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 2002
    const-string v5, "user_type"

    invoke-interface {v13, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v13, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 2004
    const-string v6, "cid"

    invoke-virtual {v14, v6, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2005
    const-string v4, "utp"

    invoke-virtual {v14, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2008
    :cond_35
    const-string v4, "ids"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->isNull(I)Z

    move-result v4

    if-nez v4, :cond_36

    .line 2010
    const-string v4, "ids"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 2011
    const-string v5, "ids"

    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6, v4}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-virtual {v14, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1b
    .catchall {:try_start_1b .. :try_end_1b} :catchall_1

    .line 2017
    :cond_36
    const/4 v12, 0x0

    .line 2020
    :try_start_1c
    const-string v5, "attributes"

    const/4 v6, 0x0

    const-string v4, "%s = ?"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    const-string v9, "events_key_ref"

    aput-object v9, v7, v8

    invoke-static {v4, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    const/4 v4, 0x1

    new-array v8, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static/range {p2 .. p3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v4

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    move-object/from16 v4, p0

    invoke-virtual/range {v4 .. v11}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1c
    .catchall {:try_start_1c .. :try_end_1c} :catchall_8

    move-result-object v5

    .line 2022
    :try_start_1d
    const-string v4, "attribute_key"

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    .line 2023
    const-string v6, "attribute_value"

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    .line 2024
    :cond_37
    :goto_d
    invoke-interface {v5}, Landroid/database/Cursor;->moveToNext()Z

    move-result v7

    if-eqz v7, :cond_42

    .line 2026
    invoke-interface {v5, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 2027
    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 2029
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_1:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_39

    .line 2031
    const/4 v7, 0x1

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1d
    .catchall {:try_start_1d .. :try_end_1d} :catchall_6

    goto :goto_d

    .line 2073
    :catchall_6
    move-exception v4

    :goto_e
    if-eqz v5, :cond_38

    .line 2075
    :try_start_1e
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    .line 2076
    :cond_38
    throw v4
    :try_end_1e
    .catchall {:try_start_1e .. :try_end_1e} :catchall_1

    .line 2033
    :cond_39
    :try_start_1f
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_2:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_3a

    .line 2035
    const/4 v7, 0x2

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_d

    .line 2037
    :cond_3a
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_3:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_3b

    .line 2039
    const/4 v7, 0x3

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_d

    .line 2041
    :cond_3b
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_4:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_3c

    .line 2043
    const/4 v7, 0x4

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_d

    .line 2045
    :cond_3c
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_5:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_3d

    .line 2047
    const/4 v7, 0x5

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_d

    .line 2049
    :cond_3d
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_6:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_3e

    .line 2051
    const/4 v7, 0x6

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_d

    .line 2053
    :cond_3e
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_7:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_3f

    .line 2055
    const/4 v7, 0x7

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_d

    .line 2057
    :cond_3f
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_8:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_40

    .line 2059
    const/16 v7, 0x8

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_d

    .line 2061
    :cond_40
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_9:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_41

    .line 2063
    const/16 v7, 0x9

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_d

    .line 2065
    :cond_41
    sget-object v9, Lcom/localytics/android/MigrationDatabaseHelper$AttributesDbColumns;->ATTRIBUTE_CUSTOM_DIMENSION_10:Ljava/lang/String;

    invoke-virtual {v9, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_37

    .line 2067
    const/16 v7, 0xa

    invoke-static {v7}, Lcom/localytics/android/MigrationDatabaseHelper;->getCustomDimensionKey(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1f
    .catchall {:try_start_1f .. :try_end_1f} :catchall_6

    goto/16 :goto_d

    .line 2073
    :cond_42
    if-eqz v5, :cond_43

    .line 2075
    :try_start_20
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    .line 2080
    :cond_43
    invoke-static/range {p0 .. p3}, Lcom/localytics/android/MigrationDatabaseHelper;->convertAttributesToJson(Landroid/database/sqlite/SQLiteDatabase;Landroid/content/Context;J)Lorg/json/JSONObject;

    move-result-object v4

    .line 2082
    if-eqz v4, :cond_11

    .line 2084
    const-string v5, "attrs"

    invoke-virtual {v14, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_3

    .line 2093
    :cond_44
    new-instance v4, Ljava/lang/RuntimeException;

    invoke-direct {v4}, Ljava/lang/RuntimeException;-><init>()V

    throw v4
    :try_end_20
    .catchall {:try_start_20 .. :try_end_20} :catchall_1

    .line 2098
    :catchall_7
    move-exception v4

    move-object v5, v12

    goto/16 :goto_2

    .line 2073
    :catchall_8
    move-exception v4

    move-object v5, v12

    goto/16 :goto_e

    .line 1957
    :catchall_9
    move-exception v4

    move-object v5, v12

    goto/16 :goto_c

    .line 1895
    :catchall_a
    move-exception v4

    move-object v5, v12

    goto/16 :goto_8

    .line 1799
    :catchall_b
    move-exception v4

    move-object v5, v12

    goto/16 :goto_5

    .line 1771
    :catchall_c
    move-exception v4

    move-object v5, v12

    goto/16 :goto_6

    .line 1736
    :catchall_d
    move-exception v4

    move-object v5, v12

    goto/16 :goto_1
.end method

.method private static getApiKeyCreationTime(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)J
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 2258
    .line 2261
    :try_start_0
    const-string v1, "api_keys"

    const/4 v2, 0x0

    const-string v0, "%s = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "api_key"

    aput-object v5, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object p1, v4, v0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v1

    .line 2263
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2265
    const-string v0, "created_time"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    long-to-float v0, v2

    const/high16 v2, 0x447a0000    # 1000.0f

    div-float/2addr v0, v2

    invoke-static {v0}, Ljava/lang/Math;->round(F)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    int-to-long v2, v0

    .line 2275
    if-eqz v1, :cond_0

    .line 2277
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2278
    :cond_0
    return-wide v2

    .line 2271
    :cond_1
    :try_start_2
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v2, "API key entry couldn\'t be found"

    invoke-direct {v0, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 2275
    :catchall_0
    move-exception v0

    :goto_0
    if-eqz v1, :cond_2

    .line 2277
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2278
    :cond_2
    throw v0

    .line 2275
    :catchall_1
    move-exception v0

    move-object v1, v8

    goto :goto_0
.end method

.method private static getAttributesFromSession(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;J)Lorg/json/JSONObject;
    .locals 10

    .prologue
    const/4 v8, 0x0

    .line 2294
    .line 2297
    :try_start_0
    const-string v1, "sessions"

    const/4 v2, 0x0

    const-string v0, "%s = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "_id"

    aput-object v5, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {p2, p3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 2299
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_c

    .line 2301
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 2304
    const-string v2, "av"

    const-string v3, "app_version"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2305
    const-string v2, "dac"

    const-string v3, "network_type"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2306
    const-string v2, "device_android_id_hash"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 2307
    const-string v3, ""

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 2309
    const-string v3, "du"

    invoke-virtual {v0, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2311
    :cond_0
    const-string v2, "dc"

    const-string v3, "device_country"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2312
    const-string v2, "dma"

    const-string v3, "device_manufacturer"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2313
    const-string v2, "dmo"

    const-string v3, "device_model"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2314
    const-string v2, "dov"

    const-string v3, "android_version"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2315
    const-string v2, "dp"

    const-string v3, "Android"

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2316
    const-string v3, "dms"

    const-string v2, "device_serial_number_hash"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->isNull(I)Z

    move-result v2

    if-eqz v2, :cond_9

    sget-object v2, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    :goto_0
    invoke-virtual {v0, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2317
    const-string v2, "dsdk"

    const-string v3, "android_sdk"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2318
    const-string v2, "au"

    invoke-virtual {v0, v2, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2319
    const-string v2, "lv"

    const-string v3, "localytics_library_version"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2320
    const-string v2, "dt"

    const-string v3, "a"

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2321
    const-string v3, "caid"

    const-string v2, "device_android_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->isNull(I)Z

    move-result v2

    if-eqz v2, :cond_a

    sget-object v2, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    :goto_1
    invoke-virtual {v0, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2322
    const-string v3, "gcadid"

    const-string v2, "device_advertising_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->isNull(I)Z

    move-result v2

    if-eqz v2, :cond_b

    sget-object v2, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    :goto_2
    invoke-virtual {v0, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2325
    const-string v2, "iu"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 2326
    if-eqz v2, :cond_1

    .line 2328
    const-string v3, "iu"

    invoke-virtual {v0, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2330
    :cond_1
    const-string v2, "dlc"

    const-string v3, "locale_country"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2331
    const-string v2, "dll"

    const-string v3, "locale_language"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2332
    const-string v2, "nca"

    const-string v3, "network_carrier"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2333
    const-string v2, "nc"

    const-string v3, "network_country"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2336
    const-string v2, "fb_attribution"

    invoke-static {p0, v2}, Lcom/localytics/android/MigrationDatabaseHelper;->getStringFromAppInfo(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 2337
    if-eqz v2, :cond_2

    .line 2339
    const-string v3, "fbat"

    invoke-virtual {v0, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2342
    :cond_2
    const-string v2, "play_attribution"

    invoke-static {p0, v2}, Lcom/localytics/android/MigrationDatabaseHelper;->getStringFromAppInfo(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 2343
    if-eqz v2, :cond_3

    .line 2345
    const-string v3, "aurl"

    invoke-virtual {v0, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2348
    :cond_3
    const-string v2, "registration_id"

    invoke-static {p0, v2}, Lcom/localytics/android/MigrationDatabaseHelper;->getStringFromAppInfo(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 2349
    if-eqz v2, :cond_4

    .line 2351
    const-string v3, "push"

    invoke-virtual {v0, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2354
    :cond_4
    const-string v2, "first_android_id"

    invoke-static {p0, v2}, Lcom/localytics/android/MigrationDatabaseHelper;->getStringFromAppInfo(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 2355
    if-eqz v2, :cond_5

    .line 2357
    const-string v3, "aid"

    invoke-virtual {v0, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2360
    :cond_5
    const-string v2, "first_advertising_id"

    invoke-static {p0, v2}, Lcom/localytics/android/MigrationDatabaseHelper;->getStringFromAppInfo(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 2361
    if-eqz v2, :cond_6

    .line 2363
    const-string v3, "gadid"

    invoke-virtual {v0, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2366
    :cond_6
    const-string v2, "package_name"

    invoke-static {p0, v2}, Lcom/localytics/android/MigrationDatabaseHelper;->getStringFromAppInfo(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 2367
    if-eqz v2, :cond_7

    .line 2369
    const-string v3, "pkg"

    invoke-virtual {v0, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 2379
    :cond_7
    if-eqz v1, :cond_8

    .line 2381
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2382
    :cond_8
    :goto_3
    return-object v0

    .line 2316
    :cond_9
    :try_start_2
    const-string v2, "device_serial_number_hash"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 2321
    :cond_a
    const-string v2, "device_android_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_1

    .line 2322
    :cond_b
    const-string v2, "device_advertising_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v2

    goto/16 :goto_2

    .line 2375
    :cond_c
    if-eqz v1, :cond_d

    .line 2381
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_d
    move-object v0, v8

    .line 2382
    goto :goto_3

    .line 2379
    :catchall_0
    move-exception v0

    :goto_4
    if-eqz v8, :cond_e

    .line 2381
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 2382
    :cond_e
    throw v0

    .line 2379
    :catchall_1
    move-exception v0

    move-object v8, v1

    goto :goto_4
.end method

.method private static getCustomDimensionKey(I)Ljava/lang/String;
    .locals 4

    .prologue
    .line 2668
    const-string v0, "%s%s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "c"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    add-int/lit8 v3, p0, -0x1

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getElapsedTimeSinceLastSession(Landroid/database/sqlite/SQLiteDatabase;J)J
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 2641
    .line 2644
    :try_start_0
    const-string v1, "sessions"

    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v3, "elapsed"

    aput-object v3, v2, v0

    const-string v0, "%s = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "_id"

    aput-object v5, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v1

    .line 2646
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2648
    const-string v0, "elapsed"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getLong(I)J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-wide v2

    .line 2658
    if-eqz v1, :cond_0

    .line 2660
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2661
    :cond_0
    return-wide v2

    .line 2654
    :cond_1
    :try_start_2
    new-instance v0, Ljava/lang/RuntimeException;

    invoke-direct {v0}, Ljava/lang/RuntimeException;-><init>()V

    throw v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 2658
    :catchall_0
    move-exception v0

    :goto_0
    if-eqz v1, :cond_2

    .line 2660
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2661
    :cond_2
    throw v0

    .line 2658
    :catchall_1
    move-exception v0

    move-object v1, v8

    goto :goto_0
.end method

.method private static getIdentifiers(Landroid/database/sqlite/SQLiteDatabase;)Lorg/json/JSONObject;
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 2469
    .line 2472
    :try_start_0
    const-string v1, "identifiers"

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v1

    .line 2476
    :goto_0
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2478
    if-nez v8, :cond_0

    .line 2480
    new-instance v8, Lorg/json/JSONObject;

    invoke-direct {v8}, Lorg/json/JSONObject;-><init>()V

    .line 2483
    :cond_0
    const-string v0, "key"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    const-string v2, "value"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v8, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 2490
    :catchall_0
    move-exception v0

    :goto_1
    if-eqz v1, :cond_1

    .line 2492
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2493
    :cond_1
    throw v0

    .line 2486
    :cond_2
    if-eqz v1, :cond_3

    .line 2492
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2493
    :cond_3
    return-object v8

    .line 2490
    :catchall_1
    move-exception v0

    move-object v1, v8

    goto :goto_1
.end method

.method private static getSessionIdForBlobId(Landroid/database/sqlite/SQLiteDatabase;J)J
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 2400
    .line 2403
    :try_start_0
    const-string v1, "upload_blob_events"

    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v3, "events_key_ref"

    aput-object v3, v2, v0

    const-string v0, "%s = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "upload_blobs_key_ref"

    aput-object v5, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 2405
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2407
    const-string v0, "events_key_ref"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getLong(I)J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    move-result-wide v6

    .line 2420
    if-eqz v1, :cond_0

    .line 2422
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2433
    :cond_0
    :try_start_2
    const-string v1, "events"

    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v3, "session_key_ref"

    aput-object v3, v2, v0

    const-string v0, "%s = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "_id"

    aput-object v5, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 2435
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 2437
    const-string v0, "session_key_ref"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getLong(I)J
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-wide v0

    .line 2449
    if-eqz v8, :cond_1

    .line 2451
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 2457
    :cond_1
    :goto_0
    return-wide v0

    .line 2415
    :cond_2
    if-eqz v1, :cond_3

    .line 2422
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2423
    :cond_3
    const-wide/16 v0, -0x1

    goto :goto_0

    .line 2420
    :catchall_0
    move-exception v0

    move-object v1, v8

    :goto_1
    if-eqz v1, :cond_4

    .line 2422
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2423
    :cond_4
    throw v0

    .line 2444
    :cond_5
    :try_start_3
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "No session associated with event"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 2449
    :catchall_1
    move-exception v0

    if-eqz v8, :cond_6

    .line 2451
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 2452
    :cond_6
    throw v0

    .line 2420
    :catchall_2
    move-exception v0

    goto :goto_1
.end method

.method private static getSessionIdForEventId(Landroid/database/sqlite/SQLiteDatabase;J)J
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 2539
    .line 2542
    :try_start_0
    const-string v1, "events"

    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v3, "session_key_ref"

    aput-object v3, v2, v0

    const-string v0, "%s = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "_id"

    aput-object v5, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v1

    .line 2544
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2546
    const-string v0, "session_key_ref"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getLong(I)J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-wide v2

    .line 2556
    if-eqz v1, :cond_0

    .line 2558
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2559
    :cond_0
    return-wide v2

    .line 2552
    :cond_1
    :try_start_2
    new-instance v0, Ljava/lang/RuntimeException;

    invoke-direct {v0}, Ljava/lang/RuntimeException;-><init>()V

    throw v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 2556
    :catchall_0
    move-exception v0

    :goto_0
    if-eqz v1, :cond_2

    .line 2558
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2559
    :cond_2
    throw v0

    .line 2556
    :catchall_1
    move-exception v0

    move-object v1, v8

    goto :goto_0
.end method

.method private static getSessionStartTime(Landroid/database/sqlite/SQLiteDatabase;J)J
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 2607
    .line 2610
    :try_start_0
    const-string v1, "sessions"

    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v3, "session_start_wall_time"

    aput-object v3, v2, v0

    const-string v0, "%s = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "_id"

    aput-object v5, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v1

    .line 2612
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2614
    const-string v0, "session_start_wall_time"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getLong(I)J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-wide v2

    .line 2624
    if-eqz v1, :cond_0

    .line 2626
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2627
    :cond_0
    return-wide v2

    .line 2620
    :cond_1
    :try_start_2
    new-instance v0, Ljava/lang/RuntimeException;

    invoke-direct {v0}, Ljava/lang/RuntimeException;-><init>()V

    throw v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 2624
    :catchall_0
    move-exception v0

    :goto_0
    if-eqz v1, :cond_2

    .line 2626
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2627
    :cond_2
    throw v0

    .line 2624
    :catchall_1
    move-exception v0

    move-object v1, v8

    goto :goto_0
.end method

.method private static getSessionUuid(Landroid/database/sqlite/SQLiteDatabase;J)Ljava/lang/String;
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 2573
    .line 2576
    :try_start_0
    const-string v1, "sessions"

    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v3, "uuid"

    aput-object v3, v2, v0

    const-string v0, "%s = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "_id"

    aput-object v5, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v1

    .line 2578
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2580
    const-string v0, "uuid"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    .line 2590
    if-eqz v1, :cond_0

    .line 2592
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2593
    :cond_0
    return-object v0

    .line 2586
    :cond_1
    :try_start_2
    new-instance v0, Ljava/lang/RuntimeException;

    invoke-direct {v0}, Ljava/lang/RuntimeException;-><init>()V

    throw v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 2590
    :catchall_0
    move-exception v0

    :goto_0
    if-eqz v1, :cond_2

    .line 2592
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2593
    :cond_2
    throw v0

    .line 2590
    :catchall_1
    move-exception v0

    move-object v1, v8

    goto :goto_0
.end method

.method private static getStringFromAppInfo(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 2507
    .line 2511
    :try_start_0
    const-string v1, "info"

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 2513
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2515
    invoke-interface {v1, p1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v0

    .line 2520
    if-eqz v1, :cond_0

    .line 2522
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2527
    :cond_0
    :goto_0
    return-object v0

    .line 2520
    :cond_1
    if-eqz v1, :cond_2

    .line 2522
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    move-object v0, v8

    .line 2527
    goto :goto_0

    .line 2520
    :catchall_0
    move-exception v0

    :goto_1
    if-eqz v8, :cond_3

    .line 2522
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 2523
    :cond_3
    throw v0

    .line 2520
    :catchall_1
    move-exception v0

    move-object v8, v1

    goto :goto_1
.end method

.method static preUploadBuildBlobs(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 11

    .prologue
    const/4 v8, 0x0

    .line 2689
    new-instance v10, Ljava/util/HashSet;

    invoke-direct {v10}, Ljava/util/HashSet;-><init>()V

    .line 2695
    :try_start_0
    const-string v1, "events"

    sget-object v2, Lcom/localytics/android/MigrationDatabaseHelper;->PROJECTION_UPLOAD_EVENTS:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    sget-object v7, Lcom/localytics/android/MigrationDatabaseHelper;->EVENTS_SORT_ORDER:Ljava/lang/String;

    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v9

    .line 2697
    :try_start_1
    const-string v1, "upload_blob_events"

    sget-object v2, Lcom/localytics/android/MigrationDatabaseHelper;->PROJECTION_UPLOAD_BLOBS:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    sget-object v7, Lcom/localytics/android/MigrationDatabaseHelper;->UPLOAD_BLOBS_EVENTS_SORT_ORDER:Ljava/lang/String;

    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    move-result-object v1

    .line 2699
    :try_start_2
    const-string v0, "_id"

    invoke-interface {v9, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    .line 2700
    new-instance v0, Landroid/database/CursorJoiner;

    sget-object v3, Lcom/localytics/android/MigrationDatabaseHelper;->JOINER_ARG_UPLOAD_EVENTS_COLUMNS:[Ljava/lang/String;

    sget-object v4, Lcom/localytics/android/MigrationDatabaseHelper;->PROJECTION_UPLOAD_BLOBS:[Ljava/lang/String;

    invoke-direct {v0, v9, v3, v1, v4}, Landroid/database/CursorJoiner;-><init>(Landroid/database/Cursor;[Ljava/lang/String;Landroid/database/Cursor;[Ljava/lang/String;)V

    .line 2701
    invoke-virtual {v0}, Landroid/database/CursorJoiner;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/database/CursorJoiner$Result;

    .line 2703
    sget-object v4, Lcom/localytics/android/MigrationDatabaseHelper$1;->$SwitchMap$android$database$CursorJoiner$Result:[I

    invoke-virtual {v0}, Landroid/database/CursorJoiner$Result;->ordinal()I

    move-result v0

    aget v0, v4, v0

    packed-switch v0, :pswitch_data_0

    goto :goto_0

    .line 2707
    :pswitch_0
    sget-object v0, Lcom/localytics/android/MigrationDatabaseHelper;->CLOSE_EVENT:Ljava/lang/String;

    const-string v4, "event_name"

    invoke-interface {v9, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v9, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2709
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    const-string v0, "wall_time"

    invoke-interface {v9, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v9, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    sub-long/2addr v4, v6

    sget-wide v6, Lcom/localytics/android/Constants;->SESSION_EXPIRATION:J

    cmp-long v0, v4, v6

    if-ltz v0, :cond_0

    .line 2711
    :cond_1
    invoke-interface {v9, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-interface {v10, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 2726
    :catchall_0
    move-exception v0

    move-object v8, v9

    :goto_1
    if-eqz v8, :cond_2

    .line 2728
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 2729
    :cond_2
    if-eqz v1, :cond_3

    .line 2734
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2735
    :cond_3
    throw v0

    .line 2726
    :cond_4
    if-eqz v9, :cond_5

    .line 2728
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 2729
    :cond_5
    if-eqz v1, :cond_6

    .line 2734
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2739
    :cond_6
    invoke-interface {v10}, Ljava/util/Set;->size()I

    move-result v0

    if-lez v0, :cond_8

    .line 2742
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 2746
    const-string v0, "uuid"

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2747
    const-string v0, "upload_blobs"

    invoke-virtual {p0, v0, v8, v1}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    .line 2748
    invoke-virtual {v1}, Landroid/content/ContentValues;->clear()V

    .line 2751
    invoke-interface {v10}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    .line 2753
    const-string v4, "upload_blobs_key_ref"

    invoke-virtual {v1, v4, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2754
    const-string v4, "events_key_ref"

    invoke-virtual {v1, v4, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2756
    const-string v0, "upload_blob_events"

    invoke-virtual {p0, v0, v8, v1}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 2758
    invoke-virtual {v1}, Landroid/content/ContentValues;->clear()V

    goto :goto_2

    .line 2761
    :cond_7
    const-string v0, "processed_in_blob"

    invoke-virtual {v1, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2762
    const-string v0, "event_history"

    sget-object v2, Lcom/localytics/android/MigrationDatabaseHelper;->SELECTION_UPLOAD_NULL_BLOBS:Ljava/lang/String;

    invoke-virtual {p0, v0, v1, v2, v8}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2763
    invoke-virtual {v1}, Landroid/content/ContentValues;->clear()V

    .line 2765
    :cond_8
    return-void

    .line 2726
    :catchall_1
    move-exception v0

    move-object v1, v8

    goto :goto_1

    :catchall_2
    move-exception v0

    move-object v1, v8

    move-object v8, v9

    goto :goto_1

    .line 2703
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method


# virtual methods
.method public final onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2

    .prologue
    .line 110
    if-nez p1, :cond_0

    .line 112
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "db cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 114
    :cond_0
    return-void
.end method

.method public final onOpen(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 5

    .prologue
    .line 343
    invoke-super {p0, p1}, Landroid/database/sqlite/SQLiteOpenHelper;->onOpen(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 345
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

    .line 347
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->isReadOnly()Z

    move-result v0

    if-nez v0, :cond_0

    .line 352
    const-string v0, "PRAGMA foreign_keys = ON;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 354
    :cond_0
    return-void
.end method

.method public final onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 11

    .prologue
    .line 123
    const/4 v0, 0x3

    if-ge p2, v0, :cond_0

    .line 125
    const-string v0, "upload_blob_events"

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 126
    const-string v0, "event_history"

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 127
    const-string v0, "upload_blobs"

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 128
    const-string v0, "attributes"

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 129
    const-string v0, "events"

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 130
    const-string v0, "sessions"

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 133
    :cond_0
    const/4 v0, 0x4

    if-ge p2, v0, :cond_1

    .line 137
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "sessions"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "iu"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 140
    :cond_1
    const/4 v0, 0x5

    if-ge p2, v0, :cond_2

    .line 142
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "sessions"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "device_wifi_mac_hash"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 145
    :cond_2
    const/4 v0, 0x6

    if-ge p2, v0, :cond_5

    .line 147
    const/4 v8, 0x0

    .line 150
    :try_start_0
    const-string v1, "attributes"

    const/4 v0, 0x2

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v3, "_id"

    aput-object v3, v2, v0

    const/4 v0, 0x1

    const-string v3, "attribute_key"

    aput-object v3, v2, v0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p1

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_3

    move-result-object v1

    .line 154
    :try_start_1
    const-string v0, "_id"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    .line 155
    const-string v2, "attribute_key"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    .line 157
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 158
    const-string v4, "%s = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    const-string v7, "_id"

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    .line 159
    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    .line 161
    const/4 v6, -0x1

    invoke-interface {v1, v6}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 162
    :goto_0
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v6

    if-eqz v6, :cond_4

    .line 164
    const-string v6, "attribute_key"

    const-string v7, "%s:%s"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget-object v10, p0, Lcom/localytics/android/MigrationDatabaseHelper;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v10}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v10

    invoke-virtual {v10}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 166
    const/4 v6, 0x0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    .line 167
    const-string v6, "attributes"

    invoke-virtual {p1, v6, v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 169
    invoke-virtual {v3}, Landroid/content/ContentValues;->clear()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 174
    :catchall_0
    move-exception v0

    :goto_1
    if-eqz v1, :cond_3

    .line 176
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 177
    :cond_3
    throw v0

    .line 174
    :cond_4
    if-eqz v1, :cond_5

    .line 176
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 182
    :cond_5
    const/4 v0, 0x7

    if-ge p2, v0, :cond_6

    .line 185
    const-string v0, "CREATE TABLE IF NOT EXISTS %s (%s TEXT, %s INTEGER);"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "info"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "fb_attribution"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "first_run"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 186
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 187
    const-string v1, "fb_attribution"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    .line 188
    const-string v1, "first_run"

    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 189
    const-string v1, "info"

    const/4 v2, 0x0

    invoke-virtual {p1, v1, v2, v0}, Landroid/database/sqlite/SQLiteDatabase;->insertOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 192
    :cond_6
    const/16 v0, 0x8

    if-ge p2, v0, :cond_7

    .line 195
    const-string v0, "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT UNIQUE NOT NULL, %s TEXT NOT NULL);"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "identifiers"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "_id"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "key"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "value"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 198
    :cond_7
    const/16 v0, 0x9

    if-ge p2, v0, :cond_8

    .line 201
    const-string v0, "ALTER TABLE %s ADD COLUMN %s INTEGER NOT NULL DEFAULT 0;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "events"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "clv_increase"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 204
    :cond_8
    const/16 v0, 0xa

    if-ge p2, v0, :cond_9

    .line 207
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "info"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "play_attribution"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 210
    :cond_9
    const/16 v0, 0xb

    if-ge p2, v0, :cond_a

    .line 213
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "info"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "registration_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 214
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "info"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "registration_version"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 217
    :cond_a
    const/16 v0, 0xc

    if-ge p2, v0, :cond_b

    .line 220
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "info"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "first_android_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 221
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "info"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "first_telephony_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 222
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "info"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "package_name"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 223
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 224
    const-string v1, "first_android_id"

    iget-object v2, p0, Lcom/localytics/android/MigrationDatabaseHelper;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v2}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/localytics/android/DatapointHelper;->getAndroidIdOrNull(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 225
    const-string v1, "first_telephony_id"

    iget-object v2, p0, Lcom/localytics/android/MigrationDatabaseHelper;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v2}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/localytics/android/DatapointHelper;->getTelephonyDeviceIdOrNull(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 226
    const-string v1, "package_name"

    iget-object v2, p0, Lcom/localytics/android/MigrationDatabaseHelper;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v2}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 227
    const-string v1, "info"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {p1, v1, v0, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 230
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "sessions"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "device_android_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 233
    :cond_b
    const/16 v0, 0xd

    if-ge p2, v0, :cond_c

    .line 236
    const-string v0, "ALTER TABLE %s ADD COLUMN %s REAL;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "events"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "event_lat"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 237
    const-string v0, "ALTER TABLE %s ADD COLUMN %s REAL;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "events"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "event_lng"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 240
    :cond_c
    const/16 v0, 0xe

    if-ge p2, v0, :cond_d

    .line 243
    const-string v0, "CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER, %s INTEGER, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER, %s INTEGER NOT NULL, %s TEXT, %s TEXT UNIQUE NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL)"

    const/16 v1, 0x13

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "amp_rules"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "_id"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "campaign_id"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "expiration"

    aput-object v3, v1, v2

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

    .line 248
    const-string v0, "CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);"

    const/4 v1, 0x6

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "amp_ruleevent"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "_id"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "event_name"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "rule_id_ref"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "amp_rules"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 251
    const-string v0, "CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL DEFAULT 0, %s INTEGER NOT NULL);"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "amp_displayed"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "_id"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "displayed"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "campaign_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 254
    const-string v0, "CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);"

    const/4 v1, 0x7

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "amp_conditions"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "_id"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "attribute_name"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "operator"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "rule_id_ref"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "amp_rules"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string v3, "_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 257
    const-string v0, "CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);"

    const/4 v1, 0x6

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "amp_condition_values"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "_id"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "value"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "condition_id_ref"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "amp_conditions"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 260
    :cond_d
    const/16 v0, 0xf

    if-ge p2, v0, :cond_e

    .line 263
    const-string v0, "CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT UNIQUE NOT NULL, %s TEXT NOT NULL);"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "custom_dimensions"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "_id"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "custom_dimension_key"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "custom_dimension_value"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 266
    :cond_e
    const/16 v0, 0x10

    if-ge p2, v0, :cond_f

    .line 269
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "info"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "first_advertising_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 270
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 271
    iget-object v0, p0, Lcom/localytics/android/MigrationDatabaseHelper;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/DatapointHelper;->getAdvertisingInfo(Landroid/content/Context;)Lcom/localytics/android/DatapointHelper$AdvertisingInfo;

    move-result-object v0

    .line 272
    const-string v2, "first_advertising_id"

    if-nez v0, :cond_12

    const/4 v0, 0x0

    :goto_2
    invoke-virtual {v1, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 273
    const-string v0, "info"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 276
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "sessions"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "device_advertising_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 279
    const-string v0, "ALTER TABLE %s ADD COLUMN %s INTEGER;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "info"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "push_disabled"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 282
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "info"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "sender_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 285
    :cond_f
    const/16 v0, 0x11

    if-ge p2, v0, :cond_10

    .line 288
    const-string v0, "CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s INTEGER)"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "profile"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "_id"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "attribute"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "action"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 291
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "events"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "customer_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 292
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "events"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "user_type"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 293
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "events"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "ids"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 296
    const-string v0, "ALTER TABLE %s ADD COLUMN %s INTEGER"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "info"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "last_session_open_time"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 299
    const-string v0, "ALTER TABLE %s ADD COLUMN %s INTEGER NOT NULL CHECK (%s >= 0) DEFAULT 0"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "sessions"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "elapsed"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "elapsed"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 302
    :cond_10
    const/16 v0, 0x12

    if-ge p2, v0, :cond_14

    .line 304
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "profile"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "customer_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 305
    const/4 v8, 0x0

    .line 306
    new-instance v9, Landroid/content/ContentValues;

    invoke-direct {v9}, Landroid/content/ContentValues;-><init>()V

    .line 311
    :try_start_2
    const-string v1, "profile"

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p1

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    move-result-object v1

    .line 312
    :goto_3
    :try_start_3
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_13

    .line 314
    const-string v0, "_id"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-result-object v0

    .line 317
    :try_start_4
    new-instance v2, Lorg/json/JSONObject;

    const-string v3, "attribute"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 318
    const-string v3, "attribute"

    const-string v4, "attributes"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v9, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 319
    const-string v3, "customer_id"

    const-string v4, "id"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v9, v3, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 320
    const-string v2, "profile"

    const-string v3, "%s = %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string v6, "_id"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    aput-object v0, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {p1, v2, v9, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 321
    invoke-virtual {v9}, Landroid/content/ContentValues;->clear()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    goto :goto_3

    .line 325
    :catch_0
    move-exception v2

    :try_start_5
    const-string v2, "profile"

    const-string v3, "%s = %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string v6, "_id"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    aput-object v0, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const/4 v3, 0x0

    invoke-virtual {p1, v2, v0, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    goto :goto_3

    .line 331
    :catchall_1
    move-exception v0

    :goto_4
    if-eqz v1, :cond_11

    .line 333
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 334
    :cond_11
    throw v0

    .line 272
    :cond_12
    iget-object v0, v0, Lcom/localytics/android/DatapointHelper$AdvertisingInfo;->id:Ljava/lang/String;

    goto/16 :goto_2

    .line 331
    :cond_13
    if-eqz v1, :cond_14

    .line 333
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 338
    :cond_14
    return-void

    .line 331
    :catchall_2
    move-exception v0

    move-object v1, v8

    goto :goto_4

    .line 174
    :catchall_3
    move-exception v0

    move-object v1, v8

    goto/16 :goto_1
.end method
