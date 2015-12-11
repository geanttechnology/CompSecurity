.class Lnet/singular/sdk/KeyValueStore;
.super Ljava/lang/Object;
.source "KeyValueStore.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lnet/singular/sdk/KeyValueStore$1;,
        Lnet/singular/sdk/KeyValueStore$Type;
    }
.end annotation


# static fields
.field public static final JSON_VALUE_KEY:Ljava/lang/String; = "value"

.field private static final KEY_COLUMN:Ljava/lang/String; = "key"

.field private static final KEY_VALUE_TABLE:Ljava/lang/String; = "key_value_table"

.field private static final NAMESPACE_COLUMN:Ljava/lang/String; = "namespace"

.field private static final ONLY_VALUE_COLUMN:[Ljava/lang/String;

.field private static final TYPE_COLUMN:Ljava/lang/String; = "type"

.field private static final VALUE_COLUMN:Ljava/lang/String; = "value"


# instance fields
.field private final log:Lnet/singular/sdk/SingularLog;

.field private final namespace:Ljava/lang/String;

.field private final singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 24
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "value"

    aput-object v2, v0, v1

    sput-object v0, Lnet/singular/sdk/KeyValueStore;->ONLY_VALUE_COLUMN:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lnet/singular/sdk/SingularLog;Lnet/singular/sdk/SingularSQLiteHelper;Ljava/lang/String;)V
    .locals 0
    .param p1, "log"    # Lnet/singular/sdk/SingularLog;
    .param p2, "singularSQLiteHelper"    # Lnet/singular/sdk/SingularSQLiteHelper;
    .param p3, "namespace"    # Ljava/lang/String;

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lnet/singular/sdk/KeyValueStore;->log:Lnet/singular/sdk/SingularLog;

    .line 30
    iput-object p3, p0, Lnet/singular/sdk/KeyValueStore;->namespace:Ljava/lang/String;

    .line 31
    iput-object p2, p0, Lnet/singular/sdk/KeyValueStore;->singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

    .line 32
    return-void
.end method

.method private encodeObject(Lnet/singular/sdk/KeyValueStore$Type;Ljava/lang/Object;)Ljava/lang/String;
    .locals 3
    .param p1, "type"    # Lnet/singular/sdk/KeyValueStore$Type;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 151
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 152
    .local v0, "json_object":Lorg/json/JSONObject;
    sget-object v1, Lnet/singular/sdk/KeyValueStore$1;->$SwitchMap$net$singular$sdk$KeyValueStore$Type:[I

    invoke-virtual {p1}, Lnet/singular/sdk/KeyValueStore$Type;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 163
    const/4 v1, 0x0

    .end local v0    # "json_object":Lorg/json/JSONObject;
    .end local p2    # "value":Ljava/lang/Object;
    :goto_0
    return-object v1

    .line 154
    .restart local v0    # "json_object":Lorg/json/JSONObject;
    .restart local p2    # "value":Ljava/lang/Object;
    :pswitch_0
    const-string v1, "value"

    check-cast p2, Ljava/lang/String;

    .end local p2    # "value":Ljava/lang/Object;
    invoke-virtual {v0, v1, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 155
    instance-of v1, v0, Lorg/json/JSONObject;

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    :cond_0
    check-cast v0, Lorg/json/JSONObject;

    .end local v0    # "json_object":Lorg/json/JSONObject;
    invoke-static {v0}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 157
    .restart local v0    # "json_object":Lorg/json/JSONObject;
    .restart local p2    # "value":Ljava/lang/Object;
    :pswitch_1
    const-string v1, "value"

    check-cast p2, Ljava/lang/Long;

    .end local p2    # "value":Ljava/lang/Object;
    invoke-virtual {v0, v1, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 158
    instance-of v1, v0, Lorg/json/JSONObject;

    if-nez v1, :cond_1

    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    :cond_1
    check-cast v0, Lorg/json/JSONObject;

    .end local v0    # "json_object":Lorg/json/JSONObject;
    invoke-static {v0}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 160
    .restart local v0    # "json_object":Lorg/json/JSONObject;
    .restart local p2    # "value":Ljava/lang/Object;
    :pswitch_2
    const-string v1, "value"

    check-cast p2, Ljava/lang/Boolean;

    .end local p2    # "value":Ljava/lang/Object;
    invoke-virtual {v0, v1, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 161
    instance-of v1, v0, Lorg/json/JSONObject;

    if-nez v1, :cond_2

    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    :cond_2
    check-cast v0, Lorg/json/JSONObject;

    .end local v0    # "json_object":Lorg/json/JSONObject;
    invoke-static {v0}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 152
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private exists(Ljava/lang/String;)Z
    .locals 18
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/database/sqlite/SQLiteException;
        }
    .end annotation

    .prologue
    .line 201
    move-object/from16 v0, p0

    iget-object v2, v0, Lnet/singular/sdk/KeyValueStore;->singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

    invoke-virtual {v2}, Lnet/singular/sdk/SingularSQLiteHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 202
    .local v1, "database":Landroid/database/sqlite/SQLiteDatabase;
    const-string v2, "key_value_table"

    sget-object v3, Lnet/singular/sdk/KeyValueStore;->ONLY_VALUE_COLUMN:[Ljava/lang/String;

    const-string v4, "namespace=? AND key=?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    move-object/from16 v0, p0

    iget-object v7, v0, Lnet/singular/sdk/KeyValueStore;->namespace:Ljava/lang/String;

    aput-object v7, v5, v6

    const/4 v6, 0x1

    aput-object p1, v5, v6

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    instance-of v9, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v9, :cond_0

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v17

    .line 210
    .local v17, "cursor":Landroid/database/Cursor;
    :goto_0
    :try_start_0
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->getCount()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    if-eqz v2, :cond_1

    const/4 v2, 0x1

    .line 212
    :goto_1
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->close()V

    return v2

    .end local v17    # "cursor":Landroid/database/Cursor;
    :cond_0
    move-object v9, v1

    .line 202
    check-cast v9, Landroid/database/sqlite/SQLiteDatabase;

    move-object v10, v2

    move-object v11, v3

    move-object v12, v4

    move-object v13, v5

    move-object v14, v6

    move-object v15, v7

    move-object/from16 v16, v8

    invoke-static/range {v9 .. v16}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->query(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v17

    goto :goto_0

    .line 210
    .restart local v17    # "cursor":Landroid/database/Cursor;
    :cond_1
    const/4 v2, 0x0

    goto :goto_1

    .line 212
    :catchall_0
    move-exception v2

    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->close()V

    throw v2
.end method

.method private innerGet(Ljava/lang/String;Lnet/singular/sdk/KeyValueStore$Type;)Ljava/lang/Object;
    .locals 21
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "type"    # Lnet/singular/sdk/KeyValueStore$Type;

    .prologue
    .line 218
    :try_start_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lnet/singular/sdk/KeyValueStore;->singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

    invoke-virtual {v2}, Lnet/singular/sdk/SingularSQLiteHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 219
    .local v1, "database":Landroid/database/sqlite/SQLiteDatabase;
    const-string v2, "key_value_table"

    sget-object v3, Lnet/singular/sdk/KeyValueStore;->ONLY_VALUE_COLUMN:[Ljava/lang/String;

    const-string v4, "namespace=? AND key=? AND type=?"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    move-object/from16 v0, p0

    iget-object v7, v0, Lnet/singular/sdk/KeyValueStore;->namespace:Ljava/lang/String;

    aput-object v7, v5, v6

    const/4 v6, 0x1

    aput-object p1, v5, v6

    const/4 v6, 0x2

    invoke-virtual/range {p2 .. p2}, Lnet/singular/sdk/KeyValueStore$Type;->toString()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    instance-of v9, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v9, :cond_0

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v17

    .line 227
    .local v17, "cursor":Landroid/database/Cursor;
    :goto_0
    :try_start_1
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->getCount()I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v2

    if-nez v2, :cond_1

    .line 228
    const/4 v2, 0x0

    .line 241
    :try_start_2
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->close()V

    .line 245
    .end local v1    # "database":Landroid/database/sqlite/SQLiteDatabase;
    .end local v17    # "cursor":Landroid/database/Cursor;
    :goto_1
    return-object v2

    .line 219
    .restart local v1    # "database":Landroid/database/sqlite/SQLiteDatabase;
    :cond_0
    move-object v0, v1

    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    move-object v9, v0

    move-object v10, v2

    move-object v11, v3

    move-object v12, v4

    move-object v13, v5

    move-object v14, v6

    move-object v15, v7

    move-object/from16 v16, v8

    invoke-static/range {v9 .. v16}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->query(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_2
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_2 .. :try_end_2} :catch_0

    move-result-object v17

    goto :goto_0

    .line 230
    .restart local v17    # "cursor":Landroid/database/Cursor;
    :cond_1
    :try_start_3
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->moveToFirst()Z

    .line 231
    const/4 v2, 0x0

    move-object/from16 v0, v17

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v19

    .line 233
    .local v19, "encoded_value":Ljava/lang/String;
    :try_start_4
    new-instance v2, Lorg/json/JSONObject;

    invoke-static/range {v19 .. v19}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v20

    .line 234
    .local v20, "json_object":Lorg/json/JSONObject;
    const-string v2, "value"

    move-object/from16 v0, v20

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-result-object v2

    .line 241
    :try_start_5
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->close()V
    :try_end_5
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_5 .. :try_end_5} :catch_0

    goto :goto_1

    .line 243
    .end local v1    # "database":Landroid/database/sqlite/SQLiteDatabase;
    .end local v17    # "cursor":Landroid/database/Cursor;
    .end local v19    # "encoded_value":Ljava/lang/String;
    .end local v20    # "json_object":Lorg/json/JSONObject;
    :catch_0
    move-exception v18

    .line 244
    .local v18, "e":Landroid/database/sqlite/SQLiteException;
    move-object/from16 v0, p0

    iget-object v2, v0, Lnet/singular/sdk/KeyValueStore;->log:Lnet/singular/sdk/SingularLog;

    const-string v3, "singular_sdk"

    const-string v4, "KeyValueStoreHelper get failed"

    move-object/from16 v0, v18

    invoke-virtual {v2, v3, v4, v0}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 245
    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    goto :goto_1

    .line 235
    .end local v18    # "e":Landroid/database/sqlite/SQLiteException;
    .restart local v1    # "database":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v17    # "cursor":Landroid/database/Cursor;
    .restart local v19    # "encoded_value":Ljava/lang/String;
    :catch_1
    move-exception v18

    .line 236
    .local v18, "e":Lorg/json/JSONException;
    :try_start_6
    invoke-virtual/range {p0 .. p1}, Lnet/singular/sdk/KeyValueStore;->delete(Ljava/lang/String;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 237
    const/4 v2, 0x0

    .line 241
    :try_start_7
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .end local v18    # "e":Lorg/json/JSONException;
    .end local v19    # "encoded_value":Ljava/lang/String;
    :catchall_0
    move-exception v2

    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->close()V

    throw v2
    :try_end_7
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_7 .. :try_end_7} :catch_0
.end method

.method private innerPut(Ljava/lang/String;Lnet/singular/sdk/KeyValueStore$Type;Ljava/lang/Object;)Z
    .locals 12
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "type"    # Lnet/singular/sdk/KeyValueStore$Type;
    .param p3, "value"    # Ljava/lang/Object;

    .prologue
    .line 171
    :try_start_0
    invoke-direct {p0, p2, p3}, Lnet/singular/sdk/KeyValueStore;->encodeObject(Lnet/singular/sdk/KeyValueStore$Type;Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v5

    .line 175
    .local v5, "value_encoded":Ljava/lang/String;
    :try_start_1
    iget-object v7, p0, Lnet/singular/sdk/KeyValueStore;->singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

    invoke-virtual {v7}, Lnet/singular/sdk/SingularSQLiteHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 176
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v6, Landroid/content/ContentValues;

    invoke-direct {v6}, Landroid/content/ContentValues;-><init>()V

    .line 177
    .local v6, "values":Landroid/content/ContentValues;
    const-string v7, "namespace"

    iget-object v8, p0, Lnet/singular/sdk/KeyValueStore;->namespace:Ljava/lang/String;

    invoke-virtual {v6, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 178
    const-string v7, "type"

    invoke-virtual {p2}, Lnet/singular/sdk/KeyValueStore$Type;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 179
    const-string v7, "key"

    invoke-virtual {v6, v7, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 180
    const-string v7, "value"

    invoke-virtual {v6, v7, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 182
    invoke-direct {p0, p1}, Lnet/singular/sdk/KeyValueStore;->exists(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 184
    const-string v7, "key_value_table"

    const-string v8, "namespace=? AND key=?"

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/String;

    const/4 v10, 0x0

    iget-object v11, p0, Lnet/singular/sdk/KeyValueStore;->namespace:Ljava/lang/String;

    aput-object v11, v9, v10

    const/4 v10, 0x1

    aput-object p1, v9, v10

    instance-of v10, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v10, :cond_0

    invoke-virtual {v0, v7, v6, v8, v9}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v4

    .line 188
    .end local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    .local v4, "rows_affected":I
    :goto_0
    const/4 v7, 0x1

    if-ne v4, v7, :cond_1

    const/4 v7, 0x1

    .line 196
    .end local v4    # "rows_affected":I
    .end local v5    # "value_encoded":Ljava/lang/String;
    .end local v6    # "values":Landroid/content/ContentValues;
    :goto_1
    return v7

    .line 172
    :catch_0
    move-exception v1

    .line 173
    .local v1, "e":Lorg/json/JSONException;
    const/4 v7, 0x0

    goto :goto_1

    .line 184
    .end local v1    # "e":Lorg/json/JSONException;
    .restart local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v5    # "value_encoded":Ljava/lang/String;
    .restart local v6    # "values":Landroid/content/ContentValues;
    :cond_0
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    .end local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v0, v7, v6, v8, v9}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->update(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v4

    goto :goto_0

    .line 188
    .restart local v4    # "rows_affected":I
    :cond_1
    const/4 v7, 0x0

    goto :goto_1

    .line 191
    .end local v4    # "rows_affected":I
    .restart local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    :cond_2
    const-string v7, "key_value_table"

    const/4 v8, 0x0

    instance-of v9, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v9, :cond_3

    invoke-virtual {v0, v7, v8, v6}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v2

    .line 192
    .end local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    .local v2, "ret":J
    :goto_2
    const-wide/16 v8, -0x1

    cmp-long v7, v2, v8

    if-eqz v7, :cond_4

    const/4 v7, 0x1

    goto :goto_1

    .line 191
    .end local v2    # "ret":J
    .restart local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    :cond_3
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    .end local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v0, v7, v8, v6}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->insert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-wide v2

    goto :goto_2

    .line 192
    .restart local v2    # "ret":J
    :cond_4
    const/4 v7, 0x0

    goto :goto_1

    .line 194
    .end local v2    # "ret":J
    .end local v5    # "value_encoded":Ljava/lang/String;
    .end local v6    # "values":Landroid/content/ContentValues;
    :catch_1
    move-exception v1

    .line 195
    .local v1, "e":Landroid/database/sqlite/SQLiteException;
    iget-object v7, p0, Lnet/singular/sdk/KeyValueStore;->log:Lnet/singular/sdk/SingularLog;

    const-string v8, "singular_sdk"

    const-string v9, "KeyValueStoreHelper put failed"

    invoke-virtual {v7, v8, v9, v1}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 196
    const/4 v7, 0x0

    goto :goto_1
.end method

.method public static onCreate(Landroid/database/sqlite/SQLiteDatabase;Lnet/singular/sdk/SingularLog;)V
    .locals 4
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "log"    # Lnet/singular/sdk/SingularLog;

    .prologue
    .line 131
    const-string v1, "singular_sdk"

    const-string v2, "KeyValueStoreHelper onCreate"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    const-string v0, "create table key_value_table(namespace TEXT not null, type INTEGER, key TEXT not null, value TEXT not null);"

    .line 138
    .local v0, "database_create":Ljava/lang/String;
    instance-of v1, p0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v1, :cond_0

    invoke-virtual {p0, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 139
    .end local p0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    return-void

    .line 138
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
    .line 142
    const-string v0, "singular_sdk"

    const-string v1, "KeyValueStoreHelper onUpgrade"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p3, v0, v1}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 143
    if-eq p1, p2, :cond_0

    .line 145
    const-string v1, "DROP TABLE IF EXISTS key_value_table;"

    instance-of v0, p0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_1

    invoke-virtual {p0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 146
    :goto_0
    invoke-static {p0, p3}, Lnet/singular/sdk/KeyValueStore;->onCreate(Landroid/database/sqlite/SQLiteDatabase;Lnet/singular/sdk/SingularLog;)V

    .line 148
    :cond_0
    return-void

    :cond_1
    move-object v0, p0

    .line 145
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public delete(Ljava/lang/String;)V
    .locals 6
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 70
    :try_start_0
    iget-object v1, p0, Lnet/singular/sdk/KeyValueStore;->singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

    invoke-virtual {v1}, Lnet/singular/sdk/SingularSQLiteHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 71
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "key_value_table"

    const-string v2, "namespace=? AND key=?"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    iget-object v5, p0, Lnet/singular/sdk/KeyValueStore;->namespace:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p1, v3, v4

    instance-of v4, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v4, :cond_0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 77
    .end local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    return-void

    .line 71
    .restart local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    :cond_0
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    .end local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v0, v1, v2, v3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->delete(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 74
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public getBoolean(Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lnet/singular/sdk/KeyNotFoundException;
        }
    .end annotation

    .prologue
    .line 122
    sget-object v1, Lnet/singular/sdk/KeyValueStore$Type;->BOOLEAN:Lnet/singular/sdk/KeyValueStore$Type;

    invoke-direct {p0, p1, v1}, Lnet/singular/sdk/KeyValueStore;->innerGet(Ljava/lang/String;Lnet/singular/sdk/KeyValueStore$Type;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 123
    .local v0, "ret":Ljava/lang/Boolean;
    if-nez v0, :cond_0

    .line 124
    new-instance v1, Lnet/singular/sdk/KeyNotFoundException;

    invoke-direct {v1}, Lnet/singular/sdk/KeyNotFoundException;-><init>()V

    throw v1

    .line 126
    :cond_0
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    return v1
.end method

.method public getLong(Ljava/lang/String;)J
    .locals 4
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lnet/singular/sdk/KeyNotFoundException;
        }
    .end annotation

    .prologue
    .line 101
    sget-object v1, Lnet/singular/sdk/KeyValueStore$Type;->LONG:Lnet/singular/sdk/KeyValueStore$Type;

    invoke-direct {p0, p1, v1}, Lnet/singular/sdk/KeyValueStore;->innerGet(Ljava/lang/String;Lnet/singular/sdk/KeyValueStore$Type;)Ljava/lang/Object;

    move-result-object v0

    .line 102
    .local v0, "ret":Ljava/lang/Object;
    if-nez v0, :cond_0

    .line 103
    new-instance v1, Lnet/singular/sdk/KeyNotFoundException;

    invoke-direct {v1}, Lnet/singular/sdk/KeyNotFoundException;-><init>()V

    throw v1

    .line 105
    :cond_0
    instance-of v1, v0, Ljava/lang/Long;

    if-eqz v1, :cond_1

    .line 106
    check-cast v0, Ljava/lang/Long;

    .end local v0    # "ret":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    .line 108
    :goto_0
    return-wide v2

    .line 107
    .restart local v0    # "ret":Ljava/lang/Object;
    :cond_1
    instance-of v1, v0, Ljava/lang/Integer;

    if-eqz v1, :cond_2

    .line 108
    check-cast v0, Ljava/lang/Integer;

    .end local v0    # "ret":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    int-to-long v2, v1

    goto :goto_0

    .line 110
    .restart local v0    # "ret":Ljava/lang/Object;
    :cond_2
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "shouldn\'t happen"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public getString(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lnet/singular/sdk/KeyNotFoundException;
        }
    .end annotation

    .prologue
    .line 86
    sget-object v1, Lnet/singular/sdk/KeyValueStore$Type;->STRING:Lnet/singular/sdk/KeyValueStore$Type;

    invoke-direct {p0, p1, v1}, Lnet/singular/sdk/KeyValueStore;->innerGet(Ljava/lang/String;Lnet/singular/sdk/KeyValueStore$Type;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 87
    .local v0, "ret":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 88
    new-instance v1, Lnet/singular/sdk/KeyNotFoundException;

    invoke-direct {v1}, Lnet/singular/sdk/KeyNotFoundException;-><init>()V

    throw v1

    .line 90
    :cond_0
    return-object v0
.end method

.method public put(Ljava/lang/String;J)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # J

    .prologue
    .line 51
    sget-object v0, Lnet/singular/sdk/KeyValueStore$Type;->LONG:Lnet/singular/sdk/KeyValueStore$Type;

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-direct {p0, p1, v0, v1}, Lnet/singular/sdk/KeyValueStore;->innerPut(Ljava/lang/String;Lnet/singular/sdk/KeyValueStore$Type;Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public put(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 41
    sget-object v0, Lnet/singular/sdk/KeyValueStore$Type;->STRING:Lnet/singular/sdk/KeyValueStore$Type;

    invoke-direct {p0, p1, v0, p2}, Lnet/singular/sdk/KeyValueStore;->innerPut(Ljava/lang/String;Lnet/singular/sdk/KeyValueStore$Type;Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public put(Ljava/lang/String;Z)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Z

    .prologue
    .line 61
    sget-object v0, Lnet/singular/sdk/KeyValueStore$Type;->BOOLEAN:Lnet/singular/sdk/KeyValueStore$Type;

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-direct {p0, p1, v0, v1}, Lnet/singular/sdk/KeyValueStore;->innerPut(Ljava/lang/String;Lnet/singular/sdk/KeyValueStore$Type;Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
