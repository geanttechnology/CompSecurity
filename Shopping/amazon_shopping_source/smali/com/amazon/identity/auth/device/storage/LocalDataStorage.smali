.class public Lcom/amazon/identity/auth/device/storage/LocalDataStorage;
.super Ljava/lang/Object;
.source "LocalDataStorage.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;,
        Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;
    }
.end annotation


# static fields
.field static final COLUMN_ACCOUNT_DELETED:Ljava/lang/String; = "account_deleted"

.field static final COLUMN_ACCOUNT_DIRTY:Ljava/lang/String; = "account_dirty"

.field static final COLUMN_ACCOUNT_TIMESTAMP:Ljava/lang/String; = "account_timestamp"

.field static final COLUMN_DEVICE_DATA_DELETED:Ljava/lang/String; = "device_data_deleted"

.field static final COLUMN_DEVICE_DATA_DIRTY:Ljava/lang/String; = "device_data_dirty"

.field static final COLUMN_DEVICE_DATA_KEY:Ljava/lang/String; = "device_data_key"

.field static final COLUMN_DEVICE_DATA_NAMESPACE:Ljava/lang/String; = "device_data_namespace"

.field static final COLUMN_DEVICE_DATA_TIMESTAMP:Ljava/lang/String; = "device_data_timestamp"

.field static final COLUMN_DEVICE_DATA_VALUE:Ljava/lang/String; = "device_data_value"

.field static final COLUMN_DIRECTED_ID:Ljava/lang/String; = "directed_id"

.field static final COLUMN_DISPLAY_NAME:Ljava/lang/String; = "display_name"

.field static final COLUMN_ID:Ljava/lang/String; = "_id"

.field static final COLUMN_TOKEN_ACCOUNT_ID:Ljava/lang/String; = "token_account_id"

.field static final COLUMN_TOKEN_DELETED:Ljava/lang/String; = "token_deleted"

.field static final COLUMN_TOKEN_DIRTY:Ljava/lang/String; = "token_dirty"

.field static final COLUMN_TOKEN_KEY:Ljava/lang/String; = "token_key"

.field static final COLUMN_TOKEN_TIMESTAMP:Ljava/lang/String; = "token_timestamp"

.field static final COLUMN_TOKEN_VALUE:Ljava/lang/String; = "token_value"

.field static final COLUMN_USER_DATA_ACCOUNT_ID:Ljava/lang/String; = "userdata_account_id"

.field static final COLUMN_USER_DATA_DELETED:Ljava/lang/String; = "userdata_deleted"

.field static final COLUMN_USER_DATA_DIRTY:Ljava/lang/String; = "userdata_dirty"

.field static final COLUMN_USER_DATA_KEY:Ljava/lang/String; = "userdata_key"

.field static final COLUMN_USER_DATA_TIMESTAMP:Ljava/lang/String; = "userdata_timestamp"

.field static final COLUMN_USER_DATA_VALUE:Ljava/lang/String; = "userdata_value"

.field static final LOCAL_DATA_STORAGE_DB_NAME:Ljava/lang/String; = "map_data_storage"

.field static final LOCAL_DATA_STORAGE_DB_VERSION:I = 0x1

.field static final TABLE_ACCOUNTS:Ljava/lang/String; = "accounts"

.field static final TABLE_DEVICE_DATA:Ljava/lang/String; = "device_data"

.field static final TABLE_TOKENS:Ljava/lang/String; = "tokens"

.field static final TABLE_USER_DATA:Ljava/lang/String; = "userdata"

.field private static final TAG:Ljava/lang/String;

.field private static sLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;


# instance fields
.field private mAccountInfos:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Lcom/amazon/identity/auth/device/storage/AccountInfo;",
            ">;>;"
        }
    .end annotation
.end field

.field private final mContext:Landroid/content/Context;

.field private mDeviceData:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Ljava/lang/String;",
            ">;>;>;"
        }
    .end annotation
.end field

.field private final mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

.field private final mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 84
    const-class v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 194
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 195
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mContext:Landroid/content/Context;

    .line 197
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    const-string/jumbo v1, "map_data_storage"

    const/4 v2, 0x1

    invoke-direct {v0, p1, v1, v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;-><init>(Landroid/content/Context;Ljava/lang/String;I)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    .line 200
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/LambortishClock;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    .line 201
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private addAccount(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;Z)Z
    .locals 13
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "displayName"    # Ljava/lang/String;
    .param p3, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p4, "dateTime"    # Ljava/util/Date;
    .param p5, "isSyncSet"    # Z

    .prologue
    .line 290
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    if-nez p4, :cond_2

    .line 292
    :cond_0
    const/16 p5, 0x0

    .line 308
    .end local p5    # "isSyncSet":Z
    :cond_1
    :goto_0
    return p5

    .line 295
    .restart local p5    # "isSyncSet":Z
    :cond_2
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    const-string/jumbo v2, "directed_id"

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v2, "display_name"

    invoke-virtual {v1, v2, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v2, "account_timestamp"

    invoke-virtual/range {p4 .. p4}, Ljava/util/Date;->getTime()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    const-string/jumbo v2, "account_dirty"

    move/from16 v0, p5

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isSyncSetToDirtyBit(Z)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v2, "account_deleted"

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    if-eqz p5, :cond_4

    const-string/jumbo v2, "accounts"

    const-string/jumbo v3, "%s = ? and %s < ?"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string/jumbo v6, "directed_id"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const-string/jumbo v6, "account_timestamp"

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-virtual/range {p4 .. p4}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {p1, v2, v1, v3, v4}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->ifCannotUpdateThenInsert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v1

    :goto_1
    if-nez v1, :cond_5

    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Failed to add account"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v9, 0x0

    .line 298
    .local v9, "newDatabaseAccountInfo":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    :goto_2
    if-eqz v9, :cond_1

    .line 303
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mAccountInfos:Ljava/util/Map;

    if-eqz v1, :cond_3

    .line 305
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mAccountInfos:Ljava/util/Map;

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 308
    :cond_3
    const/16 p5, 0x1

    goto/16 :goto_0

    .line 295
    .end local v9    # "newDatabaseAccountInfo":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    :cond_4
    const-string/jumbo v2, "accounts"

    const-string/jumbo v3, "%s = ? and %s < ? and %s = 1"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string/jumbo v6, "directed_id"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const-string/jumbo v6, "account_timestamp"

    aput-object v6, v4, v5

    const/4 v5, 0x2

    const-string/jumbo v6, "account_deleted"

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-virtual/range {p4 .. p4}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {p1, v2, v1, v3, v4}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->ifCannotUpdateThenInsert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v1

    goto :goto_1

    :cond_5
    invoke-virtual/range {p3 .. p3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v1

    move-object/from16 v0, p4

    invoke-direct {p0, p1, v1, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getUserdata(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/util/Date;)Ljava/util/Map;

    move-result-object v11

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getUserData()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v12

    :goto_3
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_7

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    move-object v10, v1

    check-cast v10, Ljava/util/Map$Entry;

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v10}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {v10}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    const/4 v6, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object/from16 v7, p4

    move/from16 v8, p5

    invoke-direct/range {v1 .. v8}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->insertUserdata(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Z)Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    move-result-object v1

    if-nez v1, :cond_6

    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Failed to save account because saving userdata was unsuccessful"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v9, 0x0

    goto/16 :goto_2

    :cond_6
    invoke-interface {v10}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v11, v2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_3

    :cond_7
    invoke-virtual/range {p3 .. p3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v1

    move-object/from16 v0, p4

    invoke-direct {p0, p1, v1, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getTokens(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/util/Date;)Ljava/util/Map;

    move-result-object v10

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getTokens()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v12

    :goto_4
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_9

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    move-object v8, v1

    check-cast v8, Ljava/util/Map$Entry;

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v8}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {v8}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    move-object v1, p0

    move-object v2, p1

    move-object/from16 v6, p4

    move/from16 v7, p5

    invoke-direct/range {v1 .. v7}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setTokenInDb(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    move-result-object v1

    if-nez v1, :cond_8

    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Failed to save account because saving token was unsuccessful"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v9, 0x0

    goto/16 :goto_2

    :cond_8
    invoke-interface {v8}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v10, v2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_4

    :cond_9
    new-instance v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v2, v1, p2, v11, v10}, Lcom/amazon/identity/auth/device/storage/AccountInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V

    new-instance v9, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    if-nez p5, :cond_a

    const/4 v1, 0x1

    :goto_5
    const/4 v3, 0x0

    move-object/from16 v0, p4

    invoke-direct {v9, v2, v0, v1, v3}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;-><init>(Ljava/lang/Object;Ljava/util/Date;ZZ)V

    goto/16 :goto_2

    :cond_a
    const/4 v1, 0x0

    goto :goto_5
.end method

.method private addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p2, "tableName"    # Ljava/lang/String;
    .param p3, "columnNameInTable"    # Ljava/lang/String;
    .param p4, "aliasName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 2595
    .local p1, "projectionMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p2, p3, p4}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getAliasColumnName(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, p4, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2596
    return-void
.end method

.method public static cleanDb(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 2638
    if-nez p0, :cond_0

    .line 2644
    :goto_0
    return-void

    .line 2643
    :cond_0
    const-string/jumbo v0, "map_data_storage.db"

    invoke-virtual {p0, v0}, Landroid/content/Context;->deleteDatabase(Ljava/lang/String;)Z

    goto :goto_0
.end method

.method private commonToData(Ljava/util/Map;Lcom/amazon/identity/auth/device/storage/DatabaseValue;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 1058
    .local p1, "data":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p2, "value":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<*>;"
    const-string/jumbo v0, "timestamp_key"

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getDateTime()Ljava/util/Date;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->serialize(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1059
    const-string/jumbo v0, "dirty_key"

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->isDirty()Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1060
    const-string/jumbo v0, "deleted_key"

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->isDeleted()Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1061
    return-void
.end method

.method private expireToken(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z
    .locals 10
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "key"    # Ljava/lang/String;
    .param p4, "dateTime"    # Ljava/util/Date;
    .param p5, "isSyncSet"    # Z

    .prologue
    const/4 v0, 0x0

    const/4 v8, 0x3

    const/4 v9, 0x2

    const/4 v2, 0x0

    const/4 v3, 0x1

    .line 724
    if-eqz p2, :cond_0

    if-eqz p3, :cond_0

    if-nez p4, :cond_2

    :cond_0
    move p5, v2

    .line 741
    .end local p5    # "isSyncSet":Z
    :cond_1
    :goto_0
    return p5

    .line 729
    .restart local p5    # "isSyncSet":Z
    :cond_2
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    const-string/jumbo v5, "token_account_id"

    invoke-virtual {v4, v5, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v5, "token_key"

    invoke-virtual {v4, v5, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v5, "token_value"

    invoke-virtual {v4, v5}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    const-string/jumbo v5, "token_timestamp"

    invoke-virtual {p4}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    const-string/jumbo v5, "token_deleted"

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v5, "token_dirty"

    invoke-direct {p0, p5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isSyncSetToDirtyBit(Z)I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v5, "%s = ? and %s = ? and %s < ? and %s = 0"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/Object;

    const-string/jumbo v7, "token_account_id"

    aput-object v7, v6, v2

    const-string/jumbo v7, "token_key"

    aput-object v7, v6, v3

    const-string/jumbo v7, "token_timestamp"

    aput-object v7, v6, v9

    const-string/jumbo v7, "token_deleted"

    aput-object v7, v6, v8

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    new-array v6, v8, [Ljava/lang/String;

    aput-object p2, v6, v2

    aput-object p3, v6, v3

    invoke-virtual {p4}, Ljava/util/Date;->getTime()J

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v9

    if-eqz p5, :cond_4

    const-string/jumbo v7, "tokens"

    invoke-static {p1, v7, v4, v5, v6}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->ifCannotUpdateThenInsert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v4

    :goto_1
    if-nez v4, :cond_6

    .line 731
    .local v0, "expiredValue":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    :goto_2
    if-eqz v0, :cond_1

    .line 736
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getLocalAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    move-result-object v1

    .line 737
    .local v1, "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    if-eqz v1, :cond_3

    .line 739
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v2, p3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_3
    move p5, v3

    .line 741
    goto/16 :goto_0

    .line 729
    .end local v0    # "expiredValue":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    .end local v1    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    :cond_4
    const-string/jumbo v7, "tokens"

    invoke-virtual {p1, v7, v4, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v4

    if-lez v4, :cond_5

    move v4, v3

    goto :goto_1

    :cond_5
    move v4, v2

    goto :goto_1

    :cond_6
    new-instance v4, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    if-nez p5, :cond_7

    move v2, v3

    :cond_7
    invoke-direct {v4, v0, p4, v2, v3}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;-><init>(Ljava/lang/Object;Ljava/util/Date;ZZ)V

    move-object v0, v4

    goto :goto_2
.end method

.method private getAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/DatabaseValue;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Lcom/amazon/identity/auth/device/storage/AccountInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1504
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAccountInfos()Ljava/util/Map;

    move-result-object v0

    .line 1506
    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    return-object v0
.end method

.method private getAccountInfos()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Lcom/amazon/identity/auth/device/storage/AccountInfo;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 1521
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mAccountInfos:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 1523
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->populateAccountInfo()Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mAccountInfos:Ljava/util/Map;

    .line 1526
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mAccountInfos:Ljava/util/Map;

    return-object v0
.end method

.method private getAllData(Ljava/util/Date;Ljava/util/EnumSet;)Ljava/util/Collection;
    .locals 17
    .param p1, "beforeOrEqualTime"    # Ljava/util/Date;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Date;",
            "Ljava/util/EnumSet",
            "<",
            "Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;",
            ">;)",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 921
    .local p2, "options":Ljava/util/EnumSet;, "Ljava/util/EnumSet<Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;>;"
    new-instance v4, Ljava/util/LinkedList;

    invoke-direct {v4}, Ljava/util/LinkedList;-><init>()V

    .line 923
    .local v4, "columnToDatas":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-direct/range {p0 .. p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAccountInfos()Ljava/util/Map;

    move-result-object v12

    invoke-interface {v12}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v12

    invoke-interface {v12}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_5

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/util/Map$Entry;

    .line 925
    invoke-interface {v12}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 926
    .local v3, "accountInfo":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    .line 928
    .local v8, "info":Lcom/amazon/identity/auth/device/storage/AccountInfo;
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p1

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->includeDatabaseValue(Ljava/util/EnumSet;Ljava/util/Date;Lcom/amazon/identity/auth/device/storage/DatabaseValue;)Z

    move-result v12

    if-eqz v12, :cond_1

    .line 930
    new-instance v13, Ljava/util/HashMap;

    invoke-direct {v13}, Ljava/util/HashMap;-><init>()V

    const-string/jumbo v14, "directedId"

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v12, v12, Lcom/amazon/identity/auth/device/storage/AccountInfo;->directedId:Ljava/lang/String;

    invoke-interface {v13, v14, v12}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string/jumbo v14, "display_name"

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v12, v12, Lcom/amazon/identity/auth/device/storage/AccountInfo;->displayName:Ljava/lang/String;

    invoke-interface {v13, v14, v12}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object/from16 v0, p0

    invoke-direct {v0, v13, v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->commonToData(Ljava/util/Map;Lcom/amazon/identity/auth/device/storage/DatabaseValue;)V

    invoke-interface {v4, v13}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 933
    :cond_1
    iget-object v12, v8, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    invoke-interface {v12}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v12

    invoke-interface {v12}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_3

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/util/Map$Entry;

    .line 935
    .local v11, "userdataEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    invoke-interface {v11}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p1

    invoke-direct {v0, v1, v2, v12}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->includeDatabaseValue(Ljava/util/EnumSet;Ljava/util/Date;Lcom/amazon/identity/auth/device/storage/DatabaseValue;)Z

    move-result v12

    if-eqz v12, :cond_2

    .line 937
    iget-object v14, v8, Lcom/amazon/identity/auth/device/storage/AccountInfo;->directedId:Ljava/lang/String;

    invoke-interface {v11}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    invoke-interface {v11}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    new-instance v15, Ljava/util/HashMap;

    invoke-direct {v15}, Ljava/util/HashMap;-><init>()V

    const-string/jumbo v16, "userdata_account"

    move-object/from16 v0, v16

    invoke-interface {v15, v0, v14}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string/jumbo v14, "userdata_key"

    invoke-interface {v15, v14, v12}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string/jumbo v12, "userdata_value"

    invoke-virtual {v13}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v14

    invoke-interface {v15, v12, v14}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object/from16 v0, p0

    invoke-direct {v0, v15, v13}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->commonToData(Ljava/util/Map;Lcom/amazon/identity/auth/device/storage/DatabaseValue;)V

    invoke-interface {v4, v15}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 941
    .end local v11    # "userdataEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    :cond_3
    iget-object v12, v8, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v12}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v12

    invoke-interface {v12}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_4
    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_0

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/util/Map$Entry;

    .line 943
    .local v10, "tokenEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    invoke-interface {v10}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p1

    invoke-direct {v0, v1, v2, v12}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->includeDatabaseValue(Ljava/util/EnumSet;Ljava/util/Date;Lcom/amazon/identity/auth/device/storage/DatabaseValue;)Z

    move-result v12

    if-eqz v12, :cond_4

    .line 945
    iget-object v14, v8, Lcom/amazon/identity/auth/device/storage/AccountInfo;->directedId:Ljava/lang/String;

    invoke-interface {v10}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    invoke-interface {v10}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    new-instance v15, Ljava/util/HashMap;

    invoke-direct {v15}, Ljava/util/HashMap;-><init>()V

    const-string/jumbo v16, "token_account"

    move-object/from16 v0, v16

    invoke-interface {v15, v0, v14}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string/jumbo v14, "token_key"

    invoke-interface {v15, v14, v12}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string/jumbo v12, "token_value"

    invoke-virtual {v13}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v14

    invoke-interface {v15, v12, v14}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object/from16 v0, p0

    invoke-direct {v0, v15, v13}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->commonToData(Ljava/util/Map;Lcom/amazon/identity/auth/device/storage/DatabaseValue;)V

    invoke-interface {v4, v15}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 950
    .end local v3    # "accountInfo":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    .end local v7    # "i$":Ljava/util/Iterator;
    .end local v8    # "info":Lcom/amazon/identity/auth/device/storage/AccountInfo;
    .end local v10    # "tokenEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    :cond_5
    invoke-direct/range {p0 .. p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getDeviceData()Ljava/util/Map;

    move-result-object v12

    invoke-interface {v12}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v12

    invoke-interface {v12}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_6
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_8

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/Map$Entry;

    .line 952
    .local v9, "namespaceEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;>;"
    invoke-interface {v9}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/util/Map;

    invoke-interface {v12}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v12

    invoke-interface {v12}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .restart local v7    # "i$":Ljava/util/Iterator;
    :cond_7
    :goto_2
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_6

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map$Entry;

    .line 954
    .local v5, "deviceDataEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    invoke-interface {v5}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p1

    invoke-direct {v0, v1, v2, v12}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->includeDatabaseValue(Ljava/util/EnumSet;Ljava/util/Date;Lcom/amazon/identity/auth/device/storage/DatabaseValue;)Z

    move-result v12

    if-eqz v12, :cond_7

    .line 956
    invoke-interface {v9}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    invoke-interface {v5}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    invoke-interface {v5}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    new-instance v15, Ljava/util/HashMap;

    invoke-direct {v15}, Ljava/util/HashMap;-><init>()V

    const-string/jumbo v16, "namespace"

    move-object/from16 v0, v16

    invoke-interface {v15, v0, v12}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string/jumbo v12, "device_data_key"

    invoke-interface {v15, v12, v13}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string/jumbo v12, "device_data_value"

    invoke-virtual {v14}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v13

    invoke-interface {v15, v12, v13}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object/from16 v0, p0

    invoke-direct {v0, v15, v14}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->commonToData(Ljava/util/Map;Lcom/amazon/identity/auth/device/storage/DatabaseValue;)V

    invoke-interface {v4, v15}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 963
    .end local v5    # "deviceDataEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    .end local v7    # "i$":Ljava/util/Iterator;
    .end local v9    # "namespaceEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;>;"
    :cond_8
    invoke-static {v4}, Ljava/util/Collections;->unmodifiableCollection(Ljava/util/Collection;)Ljava/util/Collection;

    move-result-object v12

    return-object v12
.end method

.method private getDeviceData()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Ljava/lang/String;",
            ">;>;>;"
        }
    .end annotation

    .prologue
    .line 1548
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mDeviceData:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 1550
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->populateDeviceData()Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mDeviceData:Ljava/util/Map;

    .line 1553
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mDeviceData:Ljava/util/Map;

    return-object v0
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/LocalDataStorage;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 205
    const-class v1, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->sLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    if-nez v0, :cond_0

    .line 207
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->sLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    .line 210
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->sLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 205
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private getLocalAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/DatabaseValue;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Lcom/amazon/identity/auth/device/storage/AccountInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1511
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mAccountInfos:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 1513
    const/4 v0, 0x0

    .line 1516
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mAccountInfos:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    goto :goto_0
.end method

.method private getTokens(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/util/Date;)Ljava/util/Map;
    .locals 10
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "dateTime"    # Ljava/util/Date;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/sqlite/SQLiteDatabase;",
            "Ljava/lang/String;",
            "Ljava/util/Date;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 2263
    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    .line 2265
    .local v9, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    const/4 v8, 0x0

    .line 2268
    .local v8, "cursor":Landroid/database/Cursor;
    :try_start_0
    const-string/jumbo v1, "tokens"

    const/4 v0, 0x6

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string/jumbo v3, "token_account_id"

    aput-object v3, v2, v0

    const/4 v0, 0x1

    const-string/jumbo v3, "token_key"

    aput-object v3, v2, v0

    const/4 v0, 0x2

    const-string/jumbo v3, "token_value"

    aput-object v3, v2, v0

    const/4 v0, 0x3

    const-string/jumbo v3, "token_timestamp"

    aput-object v3, v2, v0

    const/4 v0, 0x4

    const-string/jumbo v3, "token_deleted"

    aput-object v3, v2, v0

    const/4 v0, 0x5

    const-string/jumbo v3, "token_dirty"

    aput-object v3, v2, v0

    const-string/jumbo v0, "%s = ? and %s >= ? and %s = 0"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string/jumbo v5, "token_account_id"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string/jumbo v5, "token_timestamp"

    aput-object v5, v3, v4

    const/4 v4, 0x2

    const-string/jumbo v5, "token_deleted"

    aput-object v5, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v0, 0x2

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object p2, v4, v0

    const/4 v0, 0x1

    invoke-virtual {p3}, Ljava/util/Date;->getTime()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p1

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 2285
    if-eqz v8, :cond_0

    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_1

    .line 2300
    :cond_0
    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    :goto_0
    return-object v9

    .line 2292
    :cond_1
    :try_start_1
    invoke-direct {p0, v8, v9}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->parseTokens(Landroid/database/Cursor;Ljava/util/Map;)V

    .line 2294
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    if-nez v0, :cond_1

    .line 2300
    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    throw v0
.end method

.method private getUserdata(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/util/Date;)Ljava/util/Map;
    .locals 10
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "dateTime"    # Ljava/util/Date;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/sqlite/SQLiteDatabase;",
            "Ljava/lang/String;",
            "Ljava/util/Date;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 2218
    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    .line 2220
    .local v9, "userdata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    const/4 v8, 0x0

    .line 2223
    .local v8, "cursor":Landroid/database/Cursor;
    :try_start_0
    const-string/jumbo v1, "userdata"

    const/4 v0, 0x6

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string/jumbo v3, "userdata_account_id"

    aput-object v3, v2, v0

    const/4 v0, 0x1

    const-string/jumbo v3, "userdata_key"

    aput-object v3, v2, v0

    const/4 v0, 0x2

    const-string/jumbo v3, "userdata_value"

    aput-object v3, v2, v0

    const/4 v0, 0x3

    const-string/jumbo v3, "userdata_timestamp"

    aput-object v3, v2, v0

    const/4 v0, 0x4

    const-string/jumbo v3, "userdata_deleted"

    aput-object v3, v2, v0

    const/4 v0, 0x5

    const-string/jumbo v3, "userdata_dirty"

    aput-object v3, v2, v0

    const-string/jumbo v0, "%s = ? and %s >= ? and %s = 0"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string/jumbo v5, "userdata_account_id"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string/jumbo v5, "userdata_timestamp"

    aput-object v5, v3, v4

    const/4 v4, 0x2

    const-string/jumbo v5, "userdata_deleted"

    aput-object v5, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v0, 0x2

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object p2, v4, v0

    const/4 v0, 0x1

    invoke-virtual {p3}, Ljava/util/Date;->getTime()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p1

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 2240
    if-eqz v8, :cond_0

    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_1

    .line 2255
    :cond_0
    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    :goto_0
    return-object v9

    .line 2247
    :cond_1
    :try_start_1
    invoke-direct {p0, v8, v9}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->parseUserdata(Landroid/database/Cursor;Ljava/util/Map;)V

    .line 2249
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    if-nez v0, :cond_1

    .line 2255
    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    throw v0
.end method

.method private hasAccount(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    .locals 2
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "directedId"    # Ljava/lang/String;

    .prologue
    .line 1495
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mAccountInfos:Ljava/util/Map;

    if-nez v1, :cond_0

    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->populateAccountInfo(Landroid/database/sqlite/SQLiteDatabase;)Ljava/util/Map;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mAccountInfos:Ljava/util/Map;

    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mAccountInfos:Ljava/util/Map;

    .line 1497
    invoke-interface {v1, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 1499
    .local v0, "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->isDeleted()Z

    move-result v1

    if-nez v1, :cond_1

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private includeDatabaseValue(Ljava/util/EnumSet;Ljava/util/Date;Lcom/amazon/identity/auth/device/storage/DatabaseValue;)Z
    .locals 3
    .param p2, "beforeOrEqualToTime"    # Ljava/util/Date;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/EnumSet",
            "<",
            "Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;",
            ">;",
            "Ljava/util/Date;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<*>;)Z"
        }
    .end annotation

    .prologue
    .local p1, "options":Ljava/util/EnumSet;, "Ljava/util/EnumSet<Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;>;"
    .local p3, "value":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<*>;"
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 970
    sget-object v2, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->DirtyOnly:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    invoke-virtual {p1, v2}, Ljava/util/EnumSet;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {p3}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->isDirty()Z

    move-result v2

    if-nez v2, :cond_0

    move v2, v1

    :goto_0
    if-eqz v2, :cond_6

    if-nez p2, :cond_4

    move v2, v0

    :goto_1
    if-eqz v2, :cond_6

    :goto_2
    return v0

    :cond_0
    sget-object v2, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->NotDirtyOnly:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    invoke-virtual {p1, v2}, Ljava/util/EnumSet;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-virtual {p3}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->isDirty()Z

    move-result v2

    if-eqz v2, :cond_1

    move v2, v1

    goto :goto_0

    :cond_1
    sget-object v2, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->Deleted:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    invoke-virtual {p1, v2}, Ljava/util/EnumSet;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-virtual {p3}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->isDeleted()Z

    move-result v2

    if-nez v2, :cond_2

    move v2, v1

    goto :goto_0

    :cond_2
    sget-object v2, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->NotDeleted:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    invoke-virtual {p1, v2}, Ljava/util/EnumSet;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-virtual {p3}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->isDeleted()Z

    move-result v2

    if-eqz v2, :cond_3

    move v2, v1

    goto :goto_0

    :cond_3
    move v2, v0

    goto :goto_0

    :cond_4
    invoke-virtual {p3, p2}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->isAfter(Ljava/util/Date;)Z

    move-result v2

    if-nez v2, :cond_5

    move v2, v0

    goto :goto_1

    :cond_5
    move v2, v1

    goto :goto_1

    :cond_6
    move v0, v1

    goto :goto_2
.end method

.method private insertTokenNotDirty(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V
    .locals 10
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "key"    # Ljava/lang/String;
    .param p4, "dateTime"    # Ljava/util/Date;

    .prologue
    const/4 v9, 0x3

    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 2030
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 2031
    .local v0, "values":Landroid/content/ContentValues;
    const-string/jumbo v1, "token_dirty"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2033
    const-string/jumbo v1, "tokens"

    const-string/jumbo v2, "%s = ? and %s = ? and %s = ? and %s = 0 and %s = 1"

    const/4 v3, 0x5

    new-array v3, v3, [Ljava/lang/Object;

    const-string/jumbo v4, "token_account_id"

    aput-object v4, v3, v6

    const-string/jumbo v4, "token_key"

    aput-object v4, v3, v7

    const-string/jumbo v4, "token_timestamp"

    aput-object v4, v3, v8

    const-string/jumbo v4, "token_deleted"

    aput-object v4, v3, v9

    const/4 v4, 0x4

    const-string/jumbo v5, "token_dirty"

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    new-array v3, v9, [Ljava/lang/String;

    aput-object p2, v3, v6

    aput-object p3, v3, v7

    invoke-virtual {p4}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v8

    invoke-virtual {p1, v1, v0, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2042
    return-void
.end method

.method private insertUserdata(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Z)Lcom/amazon/identity/auth/device/storage/DatabaseValue;
    .locals 7
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "key"    # Ljava/lang/String;
    .param p4, "value"    # Ljava/lang/String;
    .param p5, "isDeleted"    # Z
    .param p6, "dateTime"    # Ljava/util/Date;
    .param p7, "isSyncSet"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/sqlite/SQLiteDatabase;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Z",
            "Ljava/util/Date;",
            "Z)",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1888
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1889
    .local v0, "values":Landroid/content/ContentValues;
    const-string/jumbo v1, "userdata_account_id"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1890
    const-string/jumbo v1, "userdata_key"

    invoke-virtual {v0, v1, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1891
    const-string/jumbo v1, "userdata_value"

    invoke-virtual {v0, v1, p4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1892
    const-string/jumbo v1, "userdata_timestamp"

    invoke-virtual {p6}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1893
    const-string/jumbo v1, "userdata_dirty"

    invoke-direct {p0, p7}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isSyncSetToDirtyBit(Z)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1894
    const-string/jumbo v2, "userdata_deleted"

    if-eqz p5, :cond_0

    const/4 v1, 0x1

    :goto_0
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1896
    const-string/jumbo v1, "userdata"

    const-string/jumbo v2, "%s = ? and %s = ? and %s < ?"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string/jumbo v5, "userdata_account_id"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string/jumbo v5, "userdata_key"

    aput-object v5, v3, v4

    const/4 v4, 0x2

    const-string/jumbo v5, "userdata_timestamp"

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object p2, v3, v4

    const/4 v4, 0x1

    aput-object p3, v3, v4

    const/4 v4, 0x2

    invoke-virtual {p6}, Ljava/util/Date;->getTime()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {p1, v1, v0, v2, v3}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->ifCannotUpdateThenInsert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v1

    .line 1906
    if-nez v1, :cond_1

    .line 1908
    const/4 v1, 0x0

    .line 1911
    :goto_1
    return-object v1

    .line 1894
    :cond_0
    const/4 v1, 0x0

    goto :goto_0

    .line 1911
    :cond_1
    new-instance v2, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    if-nez p7, :cond_2

    const/4 v1, 0x1

    :goto_2
    invoke-direct {v2, p4, p6, v1, p5}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;-><init>(Ljava/lang/Object;Ljava/util/Date;ZZ)V

    move-object v1, v2

    goto :goto_1

    :cond_2
    const/4 v1, 0x0

    goto :goto_2
.end method

.method private insertUserdataNotDirty(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V
    .locals 9
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "key"    # Ljava/lang/String;
    .param p4, "dateTime"    # Ljava/util/Date;

    .prologue
    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 1962
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1963
    .local v0, "values":Landroid/content/ContentValues;
    const-string/jumbo v1, "userdata_dirty"

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1965
    const-string/jumbo v1, "userdata"

    const-string/jumbo v2, "%s = ? and %s = ? and %s = ? and %s = 1"

    const/4 v3, 0x4

    new-array v3, v3, [Ljava/lang/Object;

    const-string/jumbo v4, "userdata_account_id"

    aput-object v4, v3, v5

    const-string/jumbo v4, "userdata_key"

    aput-object v4, v3, v6

    const-string/jumbo v4, "userdata_timestamp"

    aput-object v4, v3, v7

    const-string/jumbo v4, "userdata_dirty"

    aput-object v4, v3, v8

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    new-array v3, v8, [Ljava/lang/String;

    aput-object p2, v3, v5

    aput-object p3, v3, v6

    invoke-virtual {p4}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-virtual {p1, v1, v0, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1973
    return-void
.end method

.method private isAccountDataRow(Ljava/util/Map;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 1247
    .local p1, "dataItem":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v0, "directedId"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isAccountKnowInvalid(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/util/Date;)Z
    .locals 8
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "dateTime"    # Ljava/util/Date;

    .prologue
    const/4 v7, 0x2

    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 2615
    const-string/jumbo v2, "accounts"

    const-string/jumbo v3, "directed_id"

    const-string/jumbo v4, "%s = ? and %s > ?"

    new-array v5, v7, [Ljava/lang/Object;

    const-string/jumbo v6, "directed_id"

    aput-object v6, v5, v1

    const-string/jumbo v6, "account_timestamp"

    aput-object v6, v5, v0

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    new-array v5, v7, [Ljava/lang/String;

    aput-object p2, v5, v1

    invoke-virtual {p3}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v0

    invoke-static {p1, v2, v3, v4, v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->querySingleResult(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 2623
    if-eqz v2, :cond_0

    :goto_0
    return v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method private isDeviceDataDataRow(Ljava/util/Map;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 1419
    .local p1, "dataItem":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v0, "namespace"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isSyncSetToDirtyBit(Z)I
    .locals 3
    .param p1, "isSyncSet"    # Z

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 2628
    if-nez p1, :cond_0

    move v2, v0

    :goto_0
    if-eqz v2, :cond_1

    :goto_1
    return v0

    :cond_0
    move v2, v1

    goto :goto_0

    :cond_1
    move v0, v1

    goto :goto_1
.end method

.method private isTokenDataRow(Ljava/util/Map;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 1355
    .local p1, "dataItem":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v0, "token_account"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isUserdataDataRow(Ljava/util/Map;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 1298
    .local p1, "dataItem":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v0, "userdata_account"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private locallyRemoveAccounts(Ljava/lang/String;Ljava/util/Date;Z)V
    .locals 12
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "dateTime"    # Ljava/util/Date;
    .param p3, "isSyncSet"    # Z

    .prologue
    const/4 v11, 0x0

    const/4 v8, 0x1

    .line 384
    if-nez p3, :cond_0

    move v3, v8

    .line 385
    .local v3, "isDirty":Z
    :goto_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getLocalAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    move-result-object v2

    .line 386
    .local v2, "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    if-eqz v2, :cond_3

    .line 388
    new-instance v0, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v7, v7, Lcom/amazon/identity/auth/device/storage/AccountInfo;->directedId:Ljava/lang/String;

    invoke-direct {v0, v7, v11}, Lcom/amazon/identity/auth/device/storage/AccountInfo;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 389
    .local v0, "accountInfo":Lcom/amazon/identity/auth/device/storage/AccountInfo;
    new-instance v4, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    invoke-direct {v4, v0, p2, v3, v8}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;-><init>(Ljava/lang/Object;Ljava/util/Date;ZZ)V

    .line 392
    .local v4, "newInfo":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v7, v7, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    invoke-interface {v7}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Map$Entry;

    .line 394
    .local v6, "userdataEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    iget-object v7, v0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    invoke-interface {v6}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v9

    new-instance v10, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    invoke-direct {v10, v11, p2, v3, v8}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;-><init>(Ljava/lang/Object;Ljava/util/Date;ZZ)V

    invoke-interface {v7, v9, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 384
    .end local v0    # "accountInfo":Lcom/amazon/identity/auth/device/storage/AccountInfo;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    .end local v3    # "isDirty":Z
    .end local v4    # "newInfo":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    .end local v6    # "userdataEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    :cond_0
    const/4 v3, 0x0

    goto :goto_0

    .line 400
    .restart local v0    # "accountInfo":Lcom/amazon/identity/auth/device/storage/AccountInfo;
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v2    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    .restart local v3    # "isDirty":Z
    .restart local v4    # "newInfo":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    :cond_1
    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v7, v7, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v7}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map$Entry;

    .line 402
    .local v5, "tokenEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    iget-object v7, v0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v5}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v9

    new-instance v10, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    invoke-direct {v10, v11, p2, v3, v8}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;-><init>(Ljava/lang/Object;Ljava/util/Date;ZZ)V

    invoke-interface {v7, v9, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 405
    .end local v5    # "tokenEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    :cond_2
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAccountInfos()Ljava/util/Map;

    move-result-object v7

    invoke-interface {v7, p1, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 407
    .end local v0    # "accountInfo":Lcom/amazon/identity/auth/device/storage/AccountInfo;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v4    # "newInfo":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    :cond_3
    return-void
.end method

.method private parseTokens(Landroid/database/Cursor;Ljava/util/Map;)V
    .locals 6
    .param p1, "cursor"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/Cursor;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 2488
    .local p2, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    const-string/jumbo v5, "token_key"

    invoke-static {p1, v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 2489
    .local v3, "tokenKey":Ljava/lang/String;
    if-nez v3, :cond_0

    .line 2500
    :goto_0
    return-void

    .line 2494
    :cond_0
    const-string/jumbo v5, "token_value"

    invoke-static {p1, v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 2495
    .local v4, "tokenValue":Ljava/lang/String;
    const-string/jumbo v5, "token_timestamp"

    invoke-static {p1, v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getDate(Landroid/database/Cursor;Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    .line 2496
    .local v0, "tokenDateTime":Ljava/util/Date;
    const-string/jumbo v5, "token_dirty"

    invoke-static {p1, v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getBoolean(Landroid/database/Cursor;Ljava/lang/String;)Z

    move-result v2

    .line 2497
    .local v2, "tokenIsDirty":Z
    const-string/jumbo v5, "token_deleted"

    invoke-static {p1, v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getBoolean(Landroid/database/Cursor;Ljava/lang/String;)Z

    move-result v1

    .line 2499
    .local v1, "tokenIsDeleted":Z
    new-instance v5, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    invoke-direct {v5, v4, v0, v2, v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;-><init>(Ljava/lang/Object;Ljava/util/Date;ZZ)V

    invoke-interface {p2, v3, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method private parseUserdata(Landroid/database/Cursor;Ljava/util/Map;)V
    .locals 6
    .param p1, "cursor"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/Cursor;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 2470
    .local p2, "userdata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    const-string/jumbo v5, "userdata_key"

    invoke-static {p1, v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 2471
    .local v1, "userDataKey":Ljava/lang/String;
    if-nez v1, :cond_0

    .line 2484
    :goto_0
    return-void

    .line 2475
    :cond_0
    const-string/jumbo v5, "userdata_value"

    invoke-static {p1, v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 2476
    .local v2, "userDataValue":Ljava/lang/String;
    const-string/jumbo v5, "userdata_timestamp"

    invoke-static {p1, v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getDate(Landroid/database/Cursor;Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    .line 2477
    .local v0, "columnDateTime":Ljava/util/Date;
    const-string/jumbo v5, "userdata_dirty"

    invoke-static {p1, v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getBoolean(Landroid/database/Cursor;Ljava/lang/String;)Z

    move-result v4

    .line 2478
    .local v4, "userdataIsDirty":Z
    const-string/jumbo v5, "userdata_deleted"

    invoke-static {p1, v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getBoolean(Landroid/database/Cursor;Ljava/lang/String;)Z

    move-result v3

    .line 2480
    .local v3, "userdataIsDeleted":Z
    new-instance v5, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    invoke-direct {v5, v2, v0, v4, v3}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;-><init>(Ljava/lang/Object;Ljava/util/Date;ZZ)V

    invoke-interface {p2, v1, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method private populateAccountInfo()Ljava/util/Map;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Lcom/amazon/identity/auth/device/storage/AccountInfo;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 2360
    const/4 v0, 0x0

    .line 2363
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2364
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->populateAccountInfo(Landroid/database/sqlite/SQLiteDatabase;)Ljava/util/Map;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 2368
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    return-object v1

    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    throw v1
.end method

.method private populateAccountInfo(Landroid/database/sqlite/SQLiteDatabase;)Ljava/util/Map;
    .locals 20
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/sqlite/SQLiteDatabase;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Lcom/amazon/identity/auth/device/storage/AccountInfo;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 2374
    new-instance v11, Ljava/util/HashMap;

    invoke-direct {v11}, Ljava/util/HashMap;-><init>()V

    .line 2376
    .local v11, "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;>;"
    const/4 v14, 0x0

    .line 2379
    .local v14, "cursor":Landroid/database/Cursor;
    :try_start_0
    new-instance v2, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v2}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "accounts LEFT OUTER JOIN "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string/jumbo v4, "userdata"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string/jumbo v4, " ON ("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string/jumbo v4, "accounts"

    const-string/jumbo v5, "directed_id"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getNamespaceColumnName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string/jumbo v4, "userdata"

    const-string/jumbo v5, "userdata_account_id"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getNamespaceColumnName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, ")"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string/jumbo v4, " LEFT OUTER JOIN tokens ON ("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string/jumbo v4, "accounts"

    const-string/jumbo v5, "directed_id"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getNamespaceColumnName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string/jumbo v4, "tokens"

    const-string/jumbo v5, "token_account_id"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getNamespaceColumnName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, ")"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    const-string/jumbo v4, "accounts"

    const-string/jumbo v5, "_id"

    const-string/jumbo v6, "_id"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "accounts"

    const-string/jumbo v5, "directed_id"

    const-string/jumbo v6, "directed_id"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "accounts"

    const-string/jumbo v5, "display_name"

    const-string/jumbo v6, "display_name"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "accounts"

    const-string/jumbo v5, "account_timestamp"

    const-string/jumbo v6, "account_timestamp"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "accounts"

    const-string/jumbo v5, "account_dirty"

    const-string/jumbo v6, "account_dirty"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "accounts"

    const-string/jumbo v5, "account_deleted"

    const-string/jumbo v6, "account_deleted"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "userdata"

    const-string/jumbo v5, "userdata_key"

    const-string/jumbo v6, "userdata_key"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "userdata"

    const-string/jumbo v5, "userdata_value"

    const-string/jumbo v6, "userdata_value"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "userdata"

    const-string/jumbo v5, "userdata_timestamp"

    const-string/jumbo v6, "userdata_timestamp"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "userdata"

    const-string/jumbo v5, "userdata_dirty"

    const-string/jumbo v6, "userdata_dirty"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "userdata"

    const-string/jumbo v5, "userdata_deleted"

    const-string/jumbo v6, "userdata_deleted"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "tokens"

    const-string/jumbo v5, "token_key"

    const-string/jumbo v6, "token_key"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "tokens"

    const-string/jumbo v5, "token_value"

    const-string/jumbo v6, "token_value"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "tokens"

    const-string/jumbo v5, "token_timestamp"

    const-string/jumbo v6, "token_timestamp"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "tokens"

    const-string/jumbo v5, "token_dirty"

    const-string/jumbo v6, "token_dirty"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "tokens"

    const-string/jumbo v5, "token_deleted"

    const-string/jumbo v6, "token_deleted"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setProjectionMap(Ljava/util/Map;)V

    invoke-virtual {v3}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v3

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/String;

    invoke-interface {v3, v4}, Ljava/util/Set;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-virtual/range {v2 .. v9}, Landroid/database/sqlite/SQLiteQueryBuilder;->buildQuery([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v14

    .line 2380
    if-eqz v14, :cond_0

    invoke-interface {v14}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    if-nez v2, :cond_1

    .line 2423
    :cond_0
    invoke-static {v14}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    :goto_0
    return-object v11

    .line 2387
    :cond_1
    :try_start_1
    const-string/jumbo v2, "directed_id"

    invoke-static {v14, v2}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 2388
    .local v15, "directedId":Ljava/lang/String;
    invoke-interface {v11, v15}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 2389
    .local v18, "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    if-nez v18, :cond_2

    .line 2391
    const-string/jumbo v2, "display_name"

    invoke-static {v14, v2}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 2392
    .local v16, "displayName":Ljava/lang/String;
    const-string/jumbo v2, "account_timestamp"

    invoke-static {v14, v2}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getDate(Landroid/database/Cursor;Ljava/lang/String;)Ljava/util/Date;

    move-result-object v10

    .line 2393
    .local v10, "accountDateTime":Ljava/util/Date;
    const-string/jumbo v2, "account_dirty"

    invoke-static {v14, v2}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getBoolean(Landroid/database/Cursor;Ljava/lang/String;)Z

    move-result v13

    .line 2394
    .local v13, "accountIsDirty":Z
    const-string/jumbo v2, "account_deleted"

    invoke-static {v14, v2}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getBoolean(Landroid/database/Cursor;Ljava/lang/String;)Z

    move-result v12

    .line 2396
    .local v12, "accountIsDeleted":Z
    new-instance v19, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    move-object/from16 v0, v19

    move-object/from16 v1, v16

    invoke-direct {v0, v15, v1}, Lcom/amazon/identity/auth/device/storage/AccountInfo;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 2397
    .local v19, "newAccountInfo":Lcom/amazon/identity/auth/device/storage/AccountInfo;
    new-instance v18, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .end local v18    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-direct {v0, v1, v10, v13, v12}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;-><init>(Ljava/lang/Object;Ljava/util/Date;ZZ)V

    .line 2402
    .restart local v18    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    move-object/from16 v0, v18

    invoke-interface {v11, v15, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2405
    .end local v10    # "accountDateTime":Ljava/util/Date;
    .end local v12    # "accountIsDeleted":Z
    .end local v13    # "accountIsDirty":Z
    .end local v16    # "displayName":Ljava/lang/String;
    .end local v19    # "newAccountInfo":Lcom/amazon/identity/auth/device/storage/AccountInfo;
    :cond_2
    invoke-virtual/range {v18 .. v18}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    move-object/from16 v0, p0

    invoke-direct {v0, v14, v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->parseUserdata(Landroid/database/Cursor;Ljava/util/Map;)V

    .line 2406
    invoke-virtual/range {v18 .. v18}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    move-object/from16 v0, p0

    invoke-direct {v0, v14, v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->parseTokens(Landroid/database/Cursor;Ljava/util/Map;)V

    .line 2408
    invoke-interface {v14}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-nez v2, :cond_1

    .line 2412
    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getGreatestTimestamp(Ljava/util/Map;)Ljava/util/Date;

    move-result-object v17

    .line 2413
    .local v17, "greatestTime":Ljava/util/Date;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    move-object/from16 v0, v17

    invoke-virtual {v2, v0}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->markDateSeen(Ljava/util/Date;)Z

    move-result v2

    .line 2414
    if-eqz v2, :cond_3

    .line 2416
    const-string/jumbo v2, "LamportTimestampUpdatedBasedOnDBSnapshot"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2423
    :cond_3
    invoke-static {v14}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    goto/16 :goto_0

    .end local v15    # "directedId":Ljava/lang/String;
    .end local v17    # "greatestTime":Ljava/util/Date;
    .end local v18    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    :catchall_0
    move-exception v2

    invoke-static {v14}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    throw v2
.end method

.method private populateDeviceData()Ljava/util/Map;
    .locals 18
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Ljava/lang/String;",
            ">;>;>;"
        }
    .end annotation

    .prologue
    .line 2504
    new-instance v15, Ljava/util/HashMap;

    invoke-direct {v15}, Ljava/util/HashMap;-><init>()V

    .line 2507
    .local v15, "deviceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;>;"
    const/4 v9, 0x0

    .line 2511
    .local v9, "cursor":Landroid/database/Cursor;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 2513
    const-string/jumbo v2, "device_data"

    const/4 v3, 0x6

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string/jumbo v5, "device_data_namespace"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string/jumbo v5, "device_data_key"

    aput-object v5, v3, v4

    const/4 v4, 0x2

    const-string/jumbo v5, "device_data_value"

    aput-object v5, v3, v4

    const/4 v4, 0x3

    const-string/jumbo v5, "device_data_timestamp"

    aput-object v5, v3, v4

    const/4 v4, 0x4

    const-string/jumbo v5, "device_data_dirty"

    aput-object v5, v3, v4

    const/4 v4, 0x5

    const-string/jumbo v5, "device_data_deleted"

    aput-object v5, v3, v4

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 2521
    if-eqz v9, :cond_0

    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_1

    .line 2553
    :cond_0
    invoke-static {v9}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    .line 2554
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    :goto_0
    return-object v15

    .line 2528
    :cond_1
    :try_start_1
    const-string/jumbo v1, "device_data_namespace"

    invoke-static {v9, v1}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 2529
    .local v16, "namespace":Ljava/lang/String;
    invoke-interface/range {v15 .. v16}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/util/Map;

    .line 2530
    .local v17, "namespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    if-nez v17, :cond_2

    .line 2532
    new-instance v17, Ljava/util/HashMap;

    .end local v17    # "namespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    invoke-direct/range {v17 .. v17}, Ljava/util/HashMap;-><init>()V

    .line 2533
    .restart local v17    # "namespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    invoke-interface/range {v15 .. v17}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2536
    :cond_2
    const-string/jumbo v1, "device_data_key"

    invoke-static {v9, v1}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 2537
    .local v13, "deviceDataKey":Ljava/lang/String;
    const-string/jumbo v1, "device_data_value"

    invoke-static {v9, v1}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 2538
    .local v14, "deviceDataValue":Ljava/lang/String;
    const-string/jumbo v1, "device_data_timestamp"

    invoke-static {v9, v1}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getDate(Landroid/database/Cursor;Ljava/lang/String;)Ljava/util/Date;

    move-result-object v10

    .line 2539
    .local v10, "deviceDataDateTime":Ljava/util/Date;
    const-string/jumbo v1, "device_data_dirty"

    invoke-static {v9, v1}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getBoolean(Landroid/database/Cursor;Ljava/lang/String;)Z

    move-result v12

    .line 2540
    .local v12, "deviceDataIsDirty":Z
    const-string/jumbo v1, "device_data_deleted"

    invoke-static {v9, v1}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getBoolean(Landroid/database/Cursor;Ljava/lang/String;)Z

    move-result v11

    .line 2542
    .local v11, "deviceDataIsDeleted":Z
    new-instance v1, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    invoke-direct {v1, v14, v10, v12, v11}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;-><init>(Ljava/lang/Object;Ljava/util/Date;ZZ)V

    move-object/from16 v0, v17

    invoke-interface {v0, v13, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2547
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v1

    if-nez v1, :cond_1

    .line 2553
    invoke-static {v9}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    .line 2554
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    goto :goto_0

    .line 2553
    .end local v10    # "deviceDataDateTime":Ljava/util/Date;
    .end local v11    # "deviceDataIsDeleted":Z
    .end local v12    # "deviceDataIsDirty":Z
    .end local v13    # "deviceDataKey":Ljava/lang/String;
    .end local v14    # "deviceDataValue":Ljava/lang/String;
    .end local v16    # "namespace":Ljava/lang/String;
    .end local v17    # "namespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    :catchall_0
    move-exception v1

    invoke-static {v9}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    .line 2554
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    throw v1
.end method

.method private removeAccount(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/util/Date;Z)Z
    .locals 11
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "dateTime"    # Ljava/util/Date;
    .param p4, "isSyncSet"    # Z

    .prologue
    const/4 v10, 0x3

    const/4 v9, 0x2

    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 367
    if-eqz p2, :cond_0

    if-nez p3, :cond_2

    :cond_0
    move p4, v2

    .line 379
    .end local p4    # "isSyncSet":Z
    :cond_1
    :goto_0
    return p4

    .line 372
    .restart local p4    # "isSyncSet":Z
    :cond_2
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    const-string/jumbo v3, "directed_id"

    invoke-virtual {v0, v3, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v3, "display_name"

    invoke-virtual {v0, v3}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    const-string/jumbo v3, "account_timestamp"

    invoke-virtual {p3}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    const-string/jumbo v3, "account_dirty"

    invoke-direct {p0, p4}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isSyncSetToDirtyBit(Z)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v3, "account_deleted"

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v3, "%s = ? and %s < ? and %s = 0"

    new-array v4, v10, [Ljava/lang/Object;

    const-string/jumbo v5, "directed_id"

    aput-object v5, v4, v2

    const-string/jumbo v5, "account_timestamp"

    aput-object v5, v4, v1

    const-string/jumbo v5, "account_deleted"

    aput-object v5, v4, v9

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    new-array v4, v9, [Ljava/lang/String;

    aput-object p2, v4, v2

    invoke-virtual {p3}, Ljava/util/Date;->getTime()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v1

    if-eqz p4, :cond_3

    const-string/jumbo v5, "accounts"

    invoke-static {p1, v5, v0, v3, v4}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->ifCannotUpdateThenInsert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v0

    :goto_1
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    const-string/jumbo v4, "userdata_value"

    invoke-virtual {v3, v4}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    const-string/jumbo v4, "userdata_timestamp"

    invoke-virtual {p3}, Ljava/util/Date;->getTime()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    const-string/jumbo v4, "userdata_dirty"

    invoke-direct {p0, p4}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isSyncSetToDirtyBit(Z)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v4, "userdata_deleted"

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v4, "userdata"

    const-string/jumbo v5, "%s = ? and %s < ? and %s = 0"

    new-array v6, v10, [Ljava/lang/Object;

    const-string/jumbo v7, "userdata_account_id"

    aput-object v7, v6, v2

    const-string/jumbo v7, "userdata_timestamp"

    aput-object v7, v6, v1

    const-string/jumbo v7, "userdata_deleted"

    aput-object v7, v6, v9

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    new-array v6, v9, [Ljava/lang/String;

    aput-object p2, v6, v2

    invoke-virtual {p3}, Ljava/util/Date;->getTime()J

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v1

    invoke-virtual {p1, v4, v3, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    const-string/jumbo v4, "token_value"

    invoke-virtual {v3, v4}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    const-string/jumbo v4, "token_timestamp"

    invoke-virtual {p3}, Ljava/util/Date;->getTime()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    const-string/jumbo v4, "token_dirty"

    invoke-direct {p0, p4}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isSyncSetToDirtyBit(Z)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v4, "token_deleted"

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v4, "tokens"

    const-string/jumbo v5, "%s = ? and %s < ? and %s = 0"

    new-array v6, v10, [Ljava/lang/Object;

    const-string/jumbo v7, "token_account_id"

    aput-object v7, v6, v2

    const-string/jumbo v7, "token_timestamp"

    aput-object v7, v6, v1

    const-string/jumbo v7, "token_deleted"

    aput-object v7, v6, v9

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    new-array v6, v9, [Ljava/lang/String;

    aput-object p2, v6, v2

    invoke-virtual {p3}, Ljava/util/Date;->getTime()J

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v6, v1

    invoke-virtual {p1, v4, v3, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 373
    if-eqz v0, :cond_1

    .line 378
    invoke-direct {p0, p2, p3, p4}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->locallyRemoveAccounts(Ljava/lang/String;Ljava/util/Date;Z)V

    move p4, v1

    .line 379
    goto/16 :goto_0

    .line 372
    :cond_3
    const-string/jumbo v5, "accounts"

    invoke-virtual {p1, v5, v0, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    if-lez v0, :cond_4

    move v0, v1

    goto/16 :goto_1

    :cond_4
    move v0, v2

    goto/16 :goto_1
.end method

.method private setAllBeforeTimeNotDirtyInDb(Ljava/util/Date;)Z
    .locals 6
    .param p1, "dateTime"    # Ljava/util/Date;

    .prologue
    .line 2306
    const/4 v1, 0x0

    .line 2309
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 2310
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 2312
    const-string/jumbo v2, "accounts"

    const-string/jumbo v3, "account_timestamp"

    const-string/jumbo v4, "account_dirty"

    move-object v0, p0

    move-object v5, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setTableItemBeforeTimeNotDirty(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V

    .line 2317
    const-string/jumbo v2, "userdata"

    const-string/jumbo v3, "userdata_timestamp"

    const-string/jumbo v4, "userdata_dirty"

    move-object v0, p0

    move-object v5, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setTableItemBeforeTimeNotDirty(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V

    .line 2322
    const-string/jumbo v2, "tokens"

    const-string/jumbo v3, "token_timestamp"

    const-string/jumbo v4, "token_dirty"

    move-object v0, p0

    move-object v5, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setTableItemBeforeTimeNotDirty(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V

    .line 2323
    const-string/jumbo v2, "device_data"

    const-string/jumbo v3, "device_data_timestamp"

    const-string/jumbo v4, "device_data_dirty"

    move-object v0, p0

    move-object v5, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setTableItemBeforeTimeNotDirty(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V

    .line 2328
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2329
    if-eqz v1, :cond_0

    .line 2335
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 2336
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    :cond_0
    const/4 v0, 0x1

    return v0

    .line 2333
    :catchall_0
    move-exception v0

    if-eqz v1, :cond_1

    .line 2335
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 2336
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    :cond_1
    throw v0
.end method

.method private setDeviceData(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Z)Z
    .locals 10
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "namespace"    # Ljava/lang/String;
    .param p3, "key"    # Ljava/lang/String;
    .param p4, "value"    # Ljava/lang/String;
    .param p5, "isDeleted"    # Z
    .param p6, "dateTime"    # Ljava/util/Date;
    .param p7, "isSyncSet"    # Z

    .prologue
    .line 838
    if-eqz p2, :cond_0

    if-eqz p3, :cond_0

    if-nez p6, :cond_2

    .line 840
    :cond_0
    const/16 p7, 0x0

    .line 863
    .end local p7    # "isSyncSet":Z
    :cond_1
    :goto_0
    return p7

    .line 843
    .restart local p7    # "isSyncSet":Z
    :cond_2
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    const-string/jumbo v3, "device_data_namespace"

    invoke-virtual {v4, v3, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v3, "device_data_key"

    invoke-virtual {v4, v3, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v3, "device_data_value"

    invoke-virtual {v4, v3, p4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v3, "device_data_timestamp"

    invoke-virtual/range {p6 .. p6}, Ljava/util/Date;->getTime()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v4, v3, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    const-string/jumbo v5, "device_data_deleted"

    if-eqz p5, :cond_5

    const/4 v3, 0x1

    :goto_1
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v4, v5, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v3, "device_data_dirty"

    move/from16 v0, p7

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isSyncSetToDirtyBit(Z)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v3, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v3, "device_data"

    const-string/jumbo v5, "%s = ? and %s = ? and %s < ?"

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string/jumbo v8, "device_data_namespace"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    const-string/jumbo v8, "device_data_key"

    aput-object v8, v6, v7

    const/4 v7, 0x2

    const-string/jumbo v8, "device_data_timestamp"

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object p2, v6, v7

    const/4 v7, 0x1

    aput-object p3, v6, v7

    const/4 v7, 0x2

    invoke-virtual/range {p6 .. p6}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {p1, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->ifCannotUpdateThenInsert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_6

    const/4 v1, 0x0

    .line 846
    .local v1, "datebaseValue":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    :goto_2
    if-eqz v1, :cond_1

    .line 851
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mDeviceData:Ljava/util/Map;

    if-eqz v3, :cond_4

    .line 853
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mDeviceData:Ljava/util/Map;

    invoke-interface {v3, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    .line 854
    .local v2, "namespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    if-nez v2, :cond_3

    .line 856
    new-instance v2, Ljava/util/HashMap;

    .end local v2    # "namespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 857
    .restart local v2    # "namespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mDeviceData:Ljava/util/Map;

    invoke-interface {v3, p2, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 860
    :cond_3
    invoke-interface {v2, p3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 863
    .end local v2    # "namespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    :cond_4
    const/16 p7, 0x1

    goto/16 :goto_0

    .line 843
    .end local v1    # "datebaseValue":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    :cond_5
    const/4 v3, 0x0

    goto :goto_1

    :cond_6
    new-instance v1, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    if-nez p7, :cond_7

    const/4 v3, 0x1

    :goto_3
    move-object/from16 v0, p6

    invoke-direct {v1, p4, v0, v3, p5}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;-><init>(Ljava/lang/Object;Ljava/util/Date;ZZ)V

    goto :goto_2

    :cond_7
    const/4 v3, 0x0

    goto :goto_3
.end method

.method private setTableItemBeforeTimeNotDirty(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V
    .locals 8
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "table"    # Ljava/lang/String;
    .param p3, "timeColumn"    # Ljava/lang/String;
    .param p4, "dirtyColumn"    # Ljava/lang/String;
    .param p5, "dateTime"    # Ljava/util/Date;

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 2347
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 2348
    .local v0, "accountValues":Landroid/content/ContentValues;
    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, p4, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2350
    const-string/jumbo v2, "%s <= ?"

    new-array v3, v7, [Ljava/lang/Object;

    aput-object p3, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    new-array v3, v7, [Ljava/lang/String;

    invoke-virtual {p5}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-virtual {p1, p2, v0, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 2355
    .local v1, "numRows":I
    sget-object v2, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Update %d items not dirty in table %s."

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v6

    aput-object p2, v3, v7

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 2356
    return-void
.end method

.method private setToken(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z
    .locals 5
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "key"    # Ljava/lang/String;
    .param p4, "token"    # Ljava/lang/String;
    .param p5, "dateTime"    # Ljava/util/Date;
    .param p6, "isSyncSet"    # Z

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 625
    if-eqz p2, :cond_0

    if-eqz p3, :cond_0

    if-nez p5, :cond_2

    :cond_0
    move p6, v2

    .line 648
    .end local p6    # "isSyncSet":Z
    :cond_1
    :goto_0
    return p6

    .line 630
    .restart local p6    # "isSyncSet":Z
    :cond_2
    if-nez p6, :cond_3

    move v4, v3

    :goto_1
    if-eqz v4, :cond_4

    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->hasAccount(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_4

    move p6, v2

    .line 632
    goto :goto_0

    :cond_3
    move v4, v2

    .line 630
    goto :goto_1

    .line 635
    :cond_4
    invoke-direct/range {p0 .. p6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setTokenInDb(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    move-result-object v0

    .line 637
    .local v0, "databaseValue":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    if-eqz v0, :cond_1

    .line 642
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getLocalAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    move-result-object v1

    .line 643
    .local v1, "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    if-eqz v1, :cond_5

    .line 645
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v2, p3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_5
    move p6, v3

    .line 648
    goto :goto_0
.end method

.method private setTokenInDb(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Lcom/amazon/identity/auth/device/storage/DatabaseValue;
    .locals 8
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "key"    # Ljava/lang/String;
    .param p4, "value"    # Ljava/lang/String;
    .param p5, "dateTime"    # Ljava/util/Date;
    .param p6, "isSyncSet"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/sqlite/SQLiteDatabase;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Date;",
            "Z)",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1982
    invoke-direct {p0, p1, p2, p5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isAccountKnowInvalid(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/util/Date;)Z

    move-result v0

    .line 1984
    .local v0, "accountIsKnownDeleted":Z
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 1985
    .local v1, "values":Landroid/content/ContentValues;
    const-string/jumbo v2, "token_account_id"

    invoke-virtual {v1, v2, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1986
    const-string/jumbo v2, "token_key"

    invoke-virtual {v1, v2, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1987
    const-string/jumbo v2, "token_value"

    invoke-virtual {v1, v2, p4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1988
    const-string/jumbo v2, "token_timestamp"

    invoke-virtual {p5}, Ljava/util/Date;->getTime()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1989
    const-string/jumbo v2, "token_dirty"

    invoke-direct {p0, p6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isSyncSetToDirtyBit(Z)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1990
    const-string/jumbo v3, "token_deleted"

    if-eqz v0, :cond_0

    const/4 v2, 0x1

    :goto_0
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v3, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1992
    const-string/jumbo v2, "tokens"

    const-string/jumbo v3, "%s = ? and %s < ? and %s = ?"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string/jumbo v6, "token_account_id"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const-string/jumbo v6, "token_timestamp"

    aput-object v6, v4, v5

    const/4 v5, 0x2

    const-string/jumbo v6, "token_key"

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p2, v4, v5

    const/4 v5, 0x1

    invoke-virtual {p5}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    aput-object p3, v4, v5

    invoke-static {p1, v2, v1, v3, v4}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->ifCannotUpdateThenInsert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v2

    .line 2002
    if-nez v2, :cond_1

    .line 2004
    const/4 v2, 0x0

    .line 2007
    :goto_1
    return-object v2

    .line 1990
    :cond_0
    const/4 v2, 0x0

    goto :goto_0

    .line 2007
    :cond_1
    new-instance v3, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    if-nez p6, :cond_2

    const/4 v2, 0x1

    :goto_2
    invoke-direct {v3, p4, p5, v2, v0}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;-><init>(Ljava/lang/Object;Ljava/util/Date;ZZ)V

    move-object v2, v3

    goto :goto_1

    :cond_2
    const/4 v2, 0x0

    goto :goto_2
.end method

.method private setUserData(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Z)Z
    .locals 11
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "key"    # Ljava/lang/String;
    .param p4, "value"    # Ljava/lang/String;
    .param p5, "deleted"    # Z
    .param p6, "dateTime"    # Ljava/util/Date;
    .param p7, "isSyncSet"    # Z

    .prologue
    .line 538
    if-eqz p2, :cond_0

    if-eqz p3, :cond_0

    if-nez p6, :cond_2

    .line 540
    :cond_0
    const/16 p7, 0x0

    .line 561
    .end local p7    # "isSyncSet":Z
    :cond_1
    :goto_0
    return p7

    .line 543
    .restart local p7    # "isSyncSet":Z
    :cond_2
    if-nez p7, :cond_3

    const/4 v1, 0x1

    :goto_1
    if-eqz v1, :cond_4

    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->hasAccount(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4

    .line 545
    const/16 p7, 0x0

    goto :goto_0

    .line 543
    :cond_3
    const/4 v1, 0x0

    goto :goto_1

    .line 548
    :cond_4
    if-nez p5, :cond_5

    move-object/from16 v0, p6

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isAccountKnowInvalid(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/util/Date;)Z

    move-result v1

    if-eqz v1, :cond_7

    :cond_5
    const/4 v6, 0x1

    :goto_2
    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object/from16 v7, p6

    move/from16 v8, p7

    invoke-direct/range {v1 .. v8}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->insertUserdata(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Z)Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    move-result-object v9

    .line 550
    .local v9, "databaseValue":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    if-eqz v9, :cond_1

    .line 555
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getLocalAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    move-result-object v10

    .line 556
    .local v10, "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    if-eqz v10, :cond_6

    .line 558
    invoke-virtual {v10}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    invoke-interface {v1, p3, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 561
    :cond_6
    const/16 p7, 0x1

    goto :goto_0

    .line 548
    .end local v9    # "databaseValue":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    .end local v10    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    :cond_7
    const/4 v6, 0x0

    goto :goto_2
.end method


# virtual methods
.method public declared-synchronized addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;Z)Z
    .locals 7
    .param p1, "displayName"    # Ljava/lang/String;
    .param p2, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p3, "dateTime"    # Ljava/util/Date;
    .param p4, "isSyncSet"    # Z

    .prologue
    .line 254
    monitor-enter p0

    const/4 v1, 0x0

    .line 257
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 258
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move v5, p4

    .line 260
    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addAccount(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;Z)Z

    move-result v6

    .line 261
    .local v6, "success":Z
    if-eqz v6, :cond_0

    .line 263
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteConstraintException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 266
    :cond_0
    if-eqz v1, :cond_1

    .line 276
    :try_start_1
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 277
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 281
    .end local v6    # "success":Z
    :cond_1
    :goto_0
    monitor-exit p0

    return v6

    .line 270
    :catch_0
    move-exception v0

    :try_start_2
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot add account since it violated a uniqueness constraint"

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 274
    if-eqz v1, :cond_2

    .line 276
    :try_start_3
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 277
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    .line 281
    :cond_2
    const/4 v6, 0x0

    goto :goto_0

    .line 274
    :catchall_0
    move-exception v0

    if-eqz v1, :cond_3

    .line 276
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 277
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    :cond_3
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 254
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized clearBulkData(Ljava/util/Collection;)Z
    .locals 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)Z"
        }
    .end annotation

    .prologue
    .local p1, "removedData":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    const/4 v7, 0x0

    const/4 v8, 0x1

    .line 1133
    monitor-enter p0

    if-nez p1, :cond_0

    .line 1190
    :goto_0
    monitor-exit p0

    return v8

    .line 1138
    :cond_0
    const/4 v2, 0x0

    .line 1141
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 1142
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 1144
    const/4 v4, 0x1

    .line 1145
    .local v4, "success":Z
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_f

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 1147
    .local v0, "dataItem":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v5, "timestamp_key"

    invoke-interface {v0, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-static {v5}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->deserialize(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 1148
    .local v1, "dateTime":Ljava/util/Date;
    const-string/jumbo v5, "deleted_key"

    invoke-interface {v0, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-static {v5}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v5

    .line 1150
    if-nez v5, :cond_3

    .line 1152
    sget-object v5, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Given a row that is not marked deleted. Cannot remove from the database!"

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 1187
    .end local v0    # "dataItem":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "dateTime":Ljava/util/Date;
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "success":Z
    :catchall_0
    move-exception v5

    if-eqz v2, :cond_2

    .line 1189
    :try_start_1
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 1190
    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    :cond_2
    throw v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 1133
    :catchall_1
    move-exception v5

    monitor-exit p0

    throw v5

    .line 1156
    .restart local v0    # "dataItem":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v1    # "dateTime":Ljava/util/Date;
    .restart local v3    # "i$":Ljava/util/Iterator;
    .restart local v4    # "success":Z
    :cond_3
    :try_start_2
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isAccountDataRow(Ljava/util/Map;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 1158
    const-string/jumbo v5, "directedId"

    invoke-interface {v0, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    if-nez v5, :cond_4

    move v5, v7

    :goto_2
    and-int/2addr v4, v5

    .line 1159
    goto :goto_1

    .line 1158
    :cond_4
    const-string/jumbo v6, "%s = ? and %s = ? and %s = 1"

    const/4 v9, 0x3

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    const-string/jumbo v11, "directed_id"

    aput-object v11, v9, v10

    const/4 v10, 0x1

    const-string/jumbo v11, "account_timestamp"

    aput-object v11, v9, v10

    const/4 v10, 0x2

    const-string/jumbo v11, "account_deleted"

    aput-object v11, v9, v10

    invoke-static {v6, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/String;

    const/4 v10, 0x0

    aput-object v5, v9, v10

    const/4 v10, 0x1

    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    move-result-wide v11

    invoke-static {v11, v12}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    const-string/jumbo v10, "accounts"

    invoke-virtual {v2, v10, v6, v9}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    const-string/jumbo v6, "%s = ? and %s = ? and %s = 1"

    const/4 v9, 0x3

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    const-string/jumbo v11, "userdata_account_id"

    aput-object v11, v9, v10

    const/4 v10, 0x1

    const-string/jumbo v11, "userdata_timestamp"

    aput-object v11, v9, v10

    const/4 v10, 0x2

    const-string/jumbo v11, "userdata_deleted"

    aput-object v11, v9, v10

    invoke-static {v6, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/String;

    const/4 v10, 0x0

    aput-object v5, v9, v10

    const/4 v10, 0x1

    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    move-result-wide v11

    invoke-static {v11, v12}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    const-string/jumbo v10, "userdata"

    invoke-virtual {v2, v10, v6, v9}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    const-string/jumbo v6, "%s = ? and %s = ? and %s = 1"

    const/4 v9, 0x3

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    const-string/jumbo v11, "token_account_id"

    aput-object v11, v9, v10

    const/4 v10, 0x1

    const-string/jumbo v11, "token_timestamp"

    aput-object v11, v9, v10

    const/4 v10, 0x2

    const-string/jumbo v11, "token_deleted"

    aput-object v11, v9, v10

    invoke-static {v6, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/String;

    const/4 v10, 0x0

    aput-object v5, v9, v10

    const/4 v10, 0x1

    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    move-result-wide v11

    invoke-static {v11, v12}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    const-string/jumbo v10, "tokens"

    invoke-virtual {v2, v10, v6, v9}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mAccountInfos:Ljava/util/Map;

    if-nez v6, :cond_5

    move v5, v8

    goto/16 :goto_2

    :cond_5
    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mAccountInfos:Ljava/util/Map;

    invoke-interface {v6, v5}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move v5, v8

    goto/16 :goto_2

    .line 1162
    :cond_6
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isUserdataDataRow(Ljava/util/Map;)Z

    move-result v5

    if-eqz v5, :cond_9

    .line 1164
    const-string/jumbo v5, "userdata_account"

    invoke-interface {v0, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    if-nez v5, :cond_7

    move v5, v7

    :goto_3
    and-int/2addr v4, v5

    .line 1165
    goto/16 :goto_1

    .line 1164
    :cond_7
    const-string/jumbo v6, "userdata_key"

    invoke-interface {v0, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    const-string/jumbo v9, "%s = ? and %s = ? and %s = ? and %s = 1"

    const/4 v10, 0x4

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    const-string/jumbo v12, "userdata_account_id"

    aput-object v12, v10, v11

    const/4 v11, 0x1

    const-string/jumbo v12, "userdata_key"

    aput-object v12, v10, v11

    const/4 v11, 0x2

    const-string/jumbo v12, "userdata_timestamp"

    aput-object v12, v10, v11

    const/4 v11, 0x3

    const-string/jumbo v12, "userdata_deleted"

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x3

    new-array v10, v10, [Ljava/lang/String;

    const/4 v11, 0x0

    aput-object v5, v10, v11

    const/4 v11, 0x1

    aput-object v6, v10, v11

    const/4 v11, 0x2

    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    move-result-wide v12

    invoke-static {v12, v13}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const-string/jumbo v11, "userdata"

    invoke-virtual {v2, v11, v9, v10}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    invoke-direct {p0, v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getLocalAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    move-result-object v5

    if-eqz v5, :cond_8

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v5, v5, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    invoke-interface {v5, v6}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    :cond_8
    move v5, v8

    goto :goto_3

    .line 1168
    :cond_9
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isTokenDataRow(Ljava/util/Map;)Z

    move-result v5

    if-eqz v5, :cond_c

    .line 1170
    const-string/jumbo v5, "token_account"

    invoke-interface {v0, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    if-nez v5, :cond_a

    move v5, v7

    :goto_4
    and-int/2addr v4, v5

    .line 1171
    goto/16 :goto_1

    .line 1170
    :cond_a
    const-string/jumbo v6, "token_key"

    invoke-interface {v0, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    const-string/jumbo v9, "%s = ? and %s = ? and %s = ? and %s = 1"

    const/4 v10, 0x4

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    const-string/jumbo v12, "token_account_id"

    aput-object v12, v10, v11

    const/4 v11, 0x1

    const-string/jumbo v12, "token_key"

    aput-object v12, v10, v11

    const/4 v11, 0x2

    const-string/jumbo v12, "token_timestamp"

    aput-object v12, v10, v11

    const/4 v11, 0x3

    const-string/jumbo v12, "token_deleted"

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x3

    new-array v10, v10, [Ljava/lang/String;

    const/4 v11, 0x0

    aput-object v5, v10, v11

    const/4 v11, 0x1

    aput-object v6, v10, v11

    const/4 v11, 0x2

    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    move-result-wide v12

    invoke-static {v12, v13}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const-string/jumbo v11, "tokens"

    invoke-virtual {v2, v11, v9, v10}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    invoke-direct {p0, v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getLocalAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    move-result-object v5

    if-eqz v5, :cond_b

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v5, v5, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v5, v6}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    :cond_b
    move v5, v8

    goto :goto_4

    .line 1174
    :cond_c
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isDeviceDataDataRow(Ljava/util/Map;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 1176
    const-string/jumbo v5, "namespace"

    invoke-interface {v0, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    if-nez v5, :cond_d

    move v5, v7

    :goto_5
    and-int/2addr v4, v5

    .line 1177
    goto/16 :goto_1

    .line 1176
    :cond_d
    const-string/jumbo v6, "device_data_key"

    invoke-interface {v0, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    const-string/jumbo v9, "%s = ? and %s = ? and %s = ?  and %s = 1"

    const/4 v10, 0x4

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    const-string/jumbo v12, "device_data_namespace"

    aput-object v12, v10, v11

    const/4 v11, 0x1

    const-string/jumbo v12, "device_data_key"

    aput-object v12, v10, v11

    const/4 v11, 0x2

    const-string/jumbo v12, "device_data_timestamp"

    aput-object v12, v10, v11

    const/4 v11, 0x3

    const-string/jumbo v12, "device_data_deleted"

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x3

    new-array v10, v10, [Ljava/lang/String;

    const/4 v11, 0x0

    aput-object v5, v10, v11

    const/4 v11, 0x1

    aput-object v6, v10, v11

    const/4 v6, 0x2

    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    move-result-wide v11

    invoke-static {v11, v12}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v11

    aput-object v11, v10, v6

    const-string/jumbo v6, "device_data"

    invoke-virtual {v2, v6, v9, v10}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mDeviceData:Ljava/util/Map;

    if-eqz v6, :cond_e

    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mDeviceData:Ljava/util/Map;

    invoke-interface {v6, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Map;

    if-eqz v6, :cond_e

    invoke-interface {v6, v5}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    :cond_e
    move v5, v8

    goto :goto_5

    .line 1181
    .end local v0    # "dataItem":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "dateTime":Ljava/util/Date;
    :cond_f
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 1187
    if-eqz v2, :cond_10

    .line 1189
    :try_start_3
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 1190
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    :cond_10
    move v8, v4

    goto/16 :goto_0
.end method

.method public declared-synchronized expireToken(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "dateTime"    # Ljava/util/Date;
    .param p4, "isSyncSet"    # Z

    .prologue
    .line 694
    monitor-enter p0

    const/4 v1, 0x0

    .line 697
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 698
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move v5, p4

    .line 700
    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->expireToken(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z

    move-result v6

    .line 701
    .local v6, "success":Z
    if-eqz v6, :cond_0

    .line 703
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 706
    :cond_0
    if-eqz v1, :cond_1

    .line 712
    :try_start_1
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 713
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :cond_1
    monitor-exit p0

    return v6

    .line 710
    .end local v6    # "success":Z
    :catchall_0
    move-exception v0

    if-eqz v1, :cond_2

    .line 712
    :try_start_2
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 713
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    :cond_2
    throw v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 694
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getAccountNames()Ljava/util/Set;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 233
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAccountInfos()Ljava/util/Map;

    move-result-object v0

    .line 235
    .local v0, "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;>;"
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 236
    .local v1, "accountNames":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 238
    .local v2, "entry":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->isDeleted()Z

    move-result v4

    if-nez v4, :cond_0

    .line 240
    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v4, v4, Lcom/amazon/identity/auth/device/storage/AccountInfo;->displayName:Ljava/lang/String;

    invoke-interface {v1, v4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 233
    .end local v0    # "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;>;"
    .end local v1    # "accountNames":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v2    # "entry":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 246
    .restart local v0    # "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;>;"
    .restart local v1    # "accountNames":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .restart local v3    # "i$":Ljava/util/Iterator;
    :cond_1
    monitor-exit p0

    return-object v1
.end method

.method public declared-synchronized getAccounts()Ljava/util/Set;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 215
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAccountInfos()Ljava/util/Map;

    move-result-object v0

    .line 217
    .local v0, "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;>;"
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 218
    .local v1, "accounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 220
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->isDeleted()Z

    move-result v4

    if-nez v4, :cond_0

    .line 222
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 215
    .end local v0    # "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;>;"
    .end local v1    # "accounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 228
    .restart local v0    # "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;>;"
    .restart local v1    # "accounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .restart local v3    # "i$":Ljava/util/Iterator;
    :cond_1
    :try_start_1
    invoke-static {v1}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v4

    monitor-exit p0

    return-object v4
.end method

.method public declared-synchronized getAllDirtyData()Ljava/util/Collection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 905
    monitor-enter p0

    const/4 v0, 0x0

    :try_start_0
    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAllDirtyData(Ljava/util/Date;)Ljava/util/Collection;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getAllDirtyData(Ljava/util/Date;)Ljava/util/Collection;
    .locals 1
    .param p1, "beforeOrEqualTime"    # Ljava/util/Date;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Date;",
            ")",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 910
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->DirtyOnly:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    invoke-static {v0}, Ljava/util/EnumSet;->of(Ljava/lang/Enum;)Ljava/util/EnumSet;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAllData(Ljava/util/Date;Ljava/util/EnumSet;)Ljava/util/Collection;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getAllNonDirtyDeletedData()Ljava/util/Collection;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 915
    monitor-enter p0

    const/4 v0, 0x0

    :try_start_0
    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->NotDirtyOnly:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    sget-object v2, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->Deleted:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    invoke-static {v1, v2}, Ljava/util/EnumSet;->of(Ljava/lang/Enum;Ljava/lang/Enum;)Ljava/util/EnumSet;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAllData(Ljava/util/Date;Ljava/util/EnumSet;)Ljava/util/Collection;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 774
    monitor-enter p0

    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 791
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v2

    .line 779
    :cond_1
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getDeviceData()Ljava/util/Map;

    move-result-object v3

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 780
    .local v0, "deviceNamespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    if-eqz v0, :cond_0

    .line 785
    invoke-interface {v0, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 786
    .local v1, "valueInfo":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->isDeleted()Z

    move-result v3

    if-nez v3, :cond_0

    .line 791
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 774
    .end local v0    # "deviceNamespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    .end local v1    # "valueInfo":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public getGreatestTimestamp(Ljava/util/Map;)Ljava/util/Date;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Lcom/amazon/identity/auth/device/storage/AccountInfo;",
            ">;>;)",
            "Ljava/util/Date;"
        }
    .end annotation

    .prologue
    .line 2429
    .local p1, "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;>;"
    const/4 v2, 0x0

    .line 2430
    .local v2, "greatestTime":Ljava/util/Date;
    invoke-interface {p1}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 2433
    .local v1, "entry":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v7, v7, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    .line 2434
    invoke-interface {v7}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 2436
    invoke-virtual {v7}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getDateTime()Ljava/util/Date;

    move-result-object v6

    .line 2437
    .local v6, "userDataTime":Ljava/util/Date;
    invoke-virtual {p0, v2, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getMaxDateTime(Ljava/util/Date;Ljava/util/Date;)Ljava/util/Date;

    move-result-object v2

    .line 2438
    goto :goto_1

    .line 2441
    .end local v6    # "userDataTime":Ljava/util/Date;
    :cond_0
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v7, v7, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    .line 2442
    invoke-interface {v7}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 2444
    invoke-virtual {v7}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getDateTime()Ljava/util/Date;

    move-result-object v5

    .line 2445
    .local v5, "tokenDataTime":Ljava/util/Date;
    invoke-virtual {p0, v2, v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getMaxDateTime(Ljava/util/Date;Ljava/util/Date;)Ljava/util/Date;

    move-result-object v2

    .line 2446
    goto :goto_2

    .line 2448
    .end local v5    # "tokenDataTime":Ljava/util/Date;
    :cond_1
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getDateTime()Ljava/util/Date;

    move-result-object v0

    .line 2449
    .local v0, "accountDateTime":Ljava/util/Date;
    invoke-virtual {p0, v2, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getMaxDateTime(Ljava/util/Date;Ljava/util/Date;)Ljava/util/Date;

    move-result-object v2

    .line 2450
    goto :goto_0

    .line 2452
    .end local v0    # "accountDateTime":Ljava/util/Date;
    .end local v1    # "entry":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    .end local v4    # "i$":Ljava/util/Iterator;
    :cond_2
    return-object v2
.end method

.method public getMaxDateTime(Ljava/util/Date;Ljava/util/Date;)Ljava/util/Date;
    .locals 1
    .param p1, "greatest"    # Ljava/util/Date;
    .param p2, "current"    # Ljava/util/Date;

    .prologue
    .line 2457
    if-nez p1, :cond_1

    .line 2465
    .end local p2    # "current":Ljava/util/Date;
    :cond_0
    :goto_0
    return-object p2

    .line 2461
    .restart local p2    # "current":Ljava/util/Date;
    :cond_1
    invoke-virtual {p2, p1}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v0

    if-nez v0, :cond_0

    move-object p2, p1

    .line 2465
    goto :goto_0
.end method

.method public declared-synchronized getSnapShotOfData()Ljava/util/Collection;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 900
    monitor-enter p0

    const/4 v0, 0x0

    :try_start_0
    const-class v1, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    invoke-static {v1}, Ljava/util/EnumSet;->noneOf(Ljava/lang/Class;)Ljava/util/EnumSet;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAllData(Ljava/util/Date;Ljava/util/EnumSet;)Ljava/util/Collection;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 589
    monitor-enter p0

    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    :cond_0
    move-object v2, v3

    .line 606
    :goto_0
    monitor-exit p0

    return-object v2

    .line 594
    :cond_1
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    move-result-object v0

    .line 595
    .local v0, "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->isDeleted()Z

    move-result v2

    if-eqz v2, :cond_3

    :cond_2
    move-object v2, v3

    .line 597
    goto :goto_0

    .line 600
    :cond_3
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v2, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 601
    .local v1, "value":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    if-eqz v1, :cond_4

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->isDeleted()Z

    move-result v2

    if-eqz v2, :cond_5

    :cond_4
    move-object v2, v3

    .line 603
    goto :goto_0

    .line 606
    :cond_5
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 589
    .end local v0    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    .end local v1    # "value":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 437
    monitor-enter p0

    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    :cond_0
    move-object v2, v3

    .line 454
    :goto_0
    monitor-exit p0

    return-object v2

    .line 442
    :cond_1
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    move-result-object v0

    .line 443
    .local v0, "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->isDeleted()Z

    move-result v2

    if-eqz v2, :cond_3

    :cond_2
    move-object v2, v3

    .line 445
    goto :goto_0

    .line 448
    :cond_3
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    invoke-interface {v2, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 449
    .local v1, "value":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    if-eqz v1, :cond_4

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->isDeleted()Z

    move-result v2

    if-eqz v2, :cond_5

    :cond_4
    move-object v2, v3

    .line 451
    goto :goto_0

    .line 454
    :cond_5
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 437
    .end local v0    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    .end local v1    # "value":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method declared-synchronized populateInMemoryCache()V
    .locals 1

    .prologue
    .line 1489
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAccountInfos()Ljava/util/Map;

    .line 1490
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getDeviceData()Ljava/util/Map;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1491
    monitor-exit p0

    return-void

    .line 1489
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized removeAccount(Ljava/lang/String;Ljava/util/Date;Z)Z
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "dateTime"    # Ljava/util/Date;
    .param p3, "isSyncSet"    # Z

    .prologue
    .line 338
    monitor-enter p0

    const/4 v0, 0x0

    .line 341
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 342
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 344
    invoke-direct {p0, v0, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->removeAccount(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/util/Date;Z)Z

    move-result v1

    .line 345
    .local v1, "success":Z
    if-eqz v1, :cond_0

    .line 347
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 350
    :cond_0
    if-eqz v0, :cond_1

    .line 356
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 357
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :cond_1
    monitor-exit p0

    return v1

    .line 354
    .end local v1    # "success":Z
    :catchall_0
    move-exception v2

    if-eqz v0, :cond_2

    .line 356
    :try_start_2
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 357
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    :cond_2
    throw v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 338
    :catchall_1
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized setAllBeforeTimeNotDirty(Ljava/util/Date;)Z
    .locals 4
    .param p1, "dateTime"    # Ljava/util/Date;

    .prologue
    .line 1197
    monitor-enter p0

    if-nez p1, :cond_0

    .line 1199
    const/4 v0, 0x0

    .line 1210
    :goto_0
    monitor-exit p0

    return v0

    .line 1202
    :cond_0
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setAllBeforeTimeNotDirtyInDb(Ljava/util/Date;)Z

    .line 1203
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mAccountInfos:Ljava/util/Map;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mAccountInfos:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->setNotDirtyIfIsBeforeOrEqualToTimestamp(Ljava/util/Date;)V

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->setNotDirtyIfIsBeforeOrEqualToTimestamp(Ljava/util/Date;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 1197
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 1203
    :cond_2
    :try_start_1
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->setNotDirtyIfIsBeforeOrEqualToTimestamp(Ljava/util/Date;)V

    goto :goto_2

    :cond_3
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mDeviceData:Ljava/util/Map;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mDeviceData:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_4
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_3
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->setNotDirtyIfIsBeforeOrEqualToTimestamp(Ljava/util/Date;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_3

    .line 1210
    :cond_5
    const/4 v0, 0x1

    goto/16 :goto_0
.end method

.method public declared-synchronized setBulkData(Ljava/util/Collection;)Z
    .locals 23
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)Z"
        }
    .end annotation

    .prologue
    .line 1071
    .local p1, "bulkData":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    monitor-enter p0

    if-nez p1, :cond_1

    .line 1073
    const/16 v22, 0x1

    .line 1122
    :cond_0
    :goto_0
    monitor-exit p0

    return v22

    .line 1076
    :cond_1
    const/4 v3, 0x0

    .line 1079
    .local v3, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v3

    .line 1080
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 1082
    const/16 v22, 0x1

    .line 1083
    .local v22, "success":Z
    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v21

    .local v21, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_c

    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/util/Map;

    .line 1085
    .local v20, "dataItem":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v2, "timestamp_key"

    move-object/from16 v0, v20

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->deserialize(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v6

    .line 1086
    .local v6, "dateTime":Ljava/util/Date;
    const-string/jumbo v2, "deleted_key"

    move-object/from16 v0, v20

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v12

    .line 1088
    .local v12, "deleted":Z
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isAccountDataRow(Ljava/util/Map;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 1090
    const-string/jumbo v2, "directedId"

    move-object/from16 v0, v20

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    if-nez v2, :cond_3

    const/4 v2, 0x0

    :goto_2
    and-int v22, v22, v2

    .line 1091
    goto :goto_1

    .line 1090
    :cond_3
    if-nez v12, :cond_4

    const-string/jumbo v4, "display_name"

    move-object/from16 v0, v20

    invoke-interface {v0, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    new-instance v5, Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-direct {v5, v2, v7, v8}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;-><init>(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V

    const/4 v7, 0x1

    move-object/from16 v2, p0

    invoke-direct/range {v2 .. v7}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addAccount(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;Z)Z

    move-result v2

    goto :goto_2

    :cond_4
    const/4 v4, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v2, v6, v4}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->removeAccount(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/util/Date;Z)Z

    move-result v2

    goto :goto_2

    .line 1094
    :cond_5
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isUserdataDataRow(Ljava/util/Map;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 1096
    const-string/jumbo v2, "userdata_account"

    move-object/from16 v0, v20

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    if-nez v9, :cond_6

    const/4 v2, 0x0

    :goto_3
    and-int v22, v22, v2

    .line 1097
    goto/16 :goto_1

    .line 1096
    :cond_6
    const-string/jumbo v2, "userdata_key"

    move-object/from16 v0, v20

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    const-string/jumbo v2, "userdata_value"

    move-object/from16 v0, v20

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    const/4 v14, 0x1

    move-object/from16 v7, p0

    move-object v8, v3

    move-object v13, v6

    invoke-direct/range {v7 .. v14}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setUserData(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Z)Z

    move-result v2

    goto :goto_3

    .line 1100
    :cond_7
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isTokenDataRow(Ljava/util/Map;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 1102
    const-string/jumbo v2, "token_account"

    move-object/from16 v0, v20

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    if-nez v15, :cond_8

    const/4 v2, 0x0

    :goto_4
    and-int v22, v22, v2

    .line 1103
    goto/16 :goto_1

    .line 1102
    :cond_8
    const-string/jumbo v2, "token_key"

    move-object/from16 v0, v20

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Ljava/lang/String;

    if-nez v12, :cond_9

    const-string/jumbo v2, "token_value"

    move-object/from16 v0, v20

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/String;

    const/16 v19, 0x1

    move-object/from16 v13, p0

    move-object v14, v3

    move-object/from16 v18, v6

    invoke-direct/range {v13 .. v19}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setToken(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z

    move-result v2

    goto :goto_4

    :cond_9
    const/4 v7, 0x1

    move-object/from16 v2, p0

    move-object v4, v15

    move-object/from16 v5, v16

    invoke-direct/range {v2 .. v7}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->expireToken(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z

    move-result v2

    goto :goto_4

    .line 1106
    :cond_a
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->isDeviceDataDataRow(Ljava/util/Map;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1108
    const-string/jumbo v2, "namespace"

    move-object/from16 v0, v20

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    if-nez v9, :cond_b

    const/4 v2, 0x0

    :goto_5
    and-int v22, v22, v2

    .line 1109
    goto/16 :goto_1

    .line 1108
    :cond_b
    const-string/jumbo v2, "device_data_key"

    move-object/from16 v0, v20

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    const-string/jumbo v2, "device_data_value"

    move-object/from16 v0, v20

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    const/4 v14, 0x1

    move-object/from16 v7, p0

    move-object v8, v3

    move-object v13, v6

    invoke-direct/range {v7 .. v14}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setDeviceData(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Z)Z

    move-result v2

    goto :goto_5

    .line 1113
    .end local v6    # "dateTime":Ljava/util/Date;
    .end local v12    # "deleted":Z
    .end local v20    # "dataItem":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_c
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 1119
    if-eqz v3, :cond_0

    .line 1121
    :try_start_1
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 1122
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_0

    .line 1071
    .end local v21    # "i$":Ljava/util/Iterator;
    .end local v22    # "success":Z
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 1119
    :catchall_1
    move-exception v2

    if-eqz v3, :cond_d

    .line 1121
    :try_start_2
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 1122
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    :cond_d
    throw v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0
.end method

.method public declared-synchronized setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;Z)Z
    .locals 12
    .param p1, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p2, "dateTime"    # Ljava/util/Date;
    .param p3, "isSyncSet"    # Z

    .prologue
    const/4 v11, 0x0

    .line 470
    monitor-enter p0

    const/4 v1, 0x0

    .line 473
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 474
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 476
    const/4 v10, 0x1

    .line 478
    .local v10, "success":Z
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getUserData()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/Map$Entry;

    .line 480
    .local v8, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v8}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v8}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    const/4 v5, 0x0

    move-object v0, p0

    move-object v6, p2

    move v7, p3

    invoke-direct/range {v0 .. v7}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setUserData(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Z)Z

    move-result v0

    if-nez v0, :cond_0

    .line 488
    const/4 v10, 0x0

    .line 493
    .end local v8    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getTokens()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_2
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/Map$Entry;

    .line 495
    .restart local v8    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v8}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v8}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    move-object v0, p0

    move-object v5, p2

    move v6, p3

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setToken(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z

    move-result v0

    if-nez v0, :cond_2

    .line 497
    const/4 v10, 0x0

    .line 502
    .end local v8    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_3
    if-eqz v10, :cond_4

    .line 504
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteConstraintException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 515
    :cond_4
    if-eqz v1, :cond_5

    .line 517
    :try_start_1
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 518
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 522
    .end local v9    # "i$":Ljava/util/Iterator;
    .end local v10    # "success":Z
    :cond_5
    :goto_0
    monitor-exit p0

    return v10

    .line 511
    :catch_0
    move-exception v0

    :try_start_2
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot set token since it violated a uniqueness constraint"

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 515
    if-eqz v1, :cond_6

    .line 517
    :try_start_3
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 518
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    :cond_6
    move v10, v11

    .line 522
    goto :goto_0

    .line 515
    :catchall_0
    move-exception v0

    if-eqz v1, :cond_7

    .line 517
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 518
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    :cond_7
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 470
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z
    .locals 10
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;
    .param p4, "dateTime"    # Ljava/util/Date;
    .param p5, "isSyncSet"    # Z

    .prologue
    const/4 v9, 0x0

    .line 800
    monitor-enter p0

    const/4 v1, 0x0

    .line 803
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 804
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 806
    const/4 v5, 0x0

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v6, p4

    move v7, p5

    invoke-direct/range {v0 .. v7}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setDeviceData(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Z)Z

    move-result v8

    .line 807
    .local v8, "success":Z
    if-eqz v8, :cond_0

    .line 809
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteConstraintException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 812
    :cond_0
    if-eqz v1, :cond_1

    .line 822
    :try_start_1
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 823
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 827
    .end local v8    # "success":Z
    :cond_1
    :goto_0
    monitor-exit p0

    return v8

    .line 816
    :catch_0
    move-exception v0

    :try_start_2
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot set device data since it violated a uniqueness constraint"

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 820
    if-eqz v1, :cond_2

    .line 822
    :try_start_3
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 823
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    :cond_2
    move v8, v9

    .line 827
    goto :goto_0

    .line 820
    :catchall_0
    move-exception v0

    if-eqz v1, :cond_3

    .line 822
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 823
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    :cond_3
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 800
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setNotDirtyAddAccount(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;)V
    .locals 10
    .param p1, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p2, "dateTime"    # Ljava/util/Date;

    .prologue
    .line 313
    monitor-enter p0

    :try_start_0
    const-string/jumbo v2, "dateTime"

    invoke-static {p2, v2}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 315
    const/4 v3, 0x0

    :try_start_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v3

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    const-string/jumbo v4, "account_dirty"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v4, "accounts"

    const-string/jumbo v5, "%s = ? and %s = ? and %s = 1 and %s = 0"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string/jumbo v8, "directed_id"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    const-string/jumbo v8, "account_timestamp"

    aput-object v8, v6, v7

    const/4 v7, 0x2

    const-string/jumbo v8, "account_dirty"

    aput-object v8, v6, v7

    const/4 v7, 0x3

    const-string/jumbo v8, "account_deleted"

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x1

    invoke-virtual {p2}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v3, v4, v2, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getUserData()Ljava/util/Map;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-direct {p0, v3, v5, v2, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->insertUserdataNotDirty(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v2

    if-eqz v3, :cond_0

    :try_start_2
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    :cond_0
    throw v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 313
    :catchall_1
    move-exception v2

    monitor-exit p0

    throw v2

    .line 315
    :cond_1
    :try_start_3
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getTokens()Ljava/util/Map;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-direct {p0, v3, v5, v2, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->insertTokenNotDirty(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V

    goto :goto_1

    :cond_2
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    if-eqz v3, :cond_3

    :try_start_4
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    .line 317
    :cond_3
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getLocalAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/DatabaseValue;
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    move-result-object v1

    .line 318
    .local v1, "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    if-nez v1, :cond_5

    .line 334
    :cond_4
    monitor-exit p0

    return-void

    .line 323
    :cond_5
    :try_start_5
    invoke-virtual {v1, p2}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->setNotDirtyIfHasCurrentTimeStamp(Ljava/util/Date;)V

    .line 325
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_6

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 327
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    invoke-virtual {v2, p2}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->setNotDirtyIfHasCurrentTimeStamp(Ljava/util/Date;)V

    goto :goto_2

    .line 330
    :cond_6
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_3
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 332
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    invoke-virtual {v2, p2}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->setNotDirtyIfHasCurrentTimeStamp(Ljava/util/Date;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    goto :goto_3
.end method

.method public declared-synchronized setNotDirtyExpireToken(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V
    .locals 10
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "dateTime"    # Ljava/util/Date;

    .prologue
    .line 746
    monitor-enter p0

    :try_start_0
    const-string/jumbo v2, "directedId"

    invoke-static {p1, v2}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 747
    const-string/jumbo v2, "key"

    invoke-static {p2, v2}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 748
    const-string/jumbo v2, "dateTime"

    invoke-static {p3, v2}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 750
    :try_start_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    const-string/jumbo v4, "token_dirty"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v4, "tokens"

    const-string/jumbo v5, "%s = ? and %s = ? and %s = ? and %s = 1 and %s = 1"

    const/4 v6, 0x5

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string/jumbo v8, "token_account_id"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    const-string/jumbo v8, "token_key"

    aput-object v8, v6, v7

    const/4 v7, 0x2

    const-string/jumbo v8, "token_timestamp"

    aput-object v8, v6, v7

    const/4 v7, 0x3

    const-string/jumbo v8, "token_deleted"

    aput-object v8, v6, v7

    const/4 v7, 0x4

    const-string/jumbo v8, "token_dirty"

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    const/4 v7, 0x1

    aput-object p2, v6, v7

    const/4 v7, 0x2

    invoke-virtual {p3}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v2, v4, v3, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    .line 752
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getLocalAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/DatabaseValue;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v0

    .line 753
    .local v0, "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    if-nez v0, :cond_1

    .line 770
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 750
    .end local v0    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    :catchall_0
    move-exception v2

    :try_start_3
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 746
    :catchall_1
    move-exception v2

    monitor-exit p0

    throw v2

    .line 758
    .restart local v0    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    :cond_1
    :try_start_4
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v2, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 759
    .local v1, "tokenInfo":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    if-eqz v1, :cond_0

    .line 764
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_0

    .line 769
    invoke-virtual {v1, p3}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->setNotDirtyIfHasCurrentTimeStamp(Ljava/util/Date;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    goto :goto_0
.end method

.method public declared-synchronized setNotDirtyRemoveAccount(Ljava/lang/String;Ljava/util/Date;)V
    .locals 10
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "dateTime"    # Ljava/util/Date;

    .prologue
    .line 411
    monitor-enter p0

    :try_start_0
    const-string/jumbo v2, "directedId"

    invoke-static {p1, v2}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 412
    const-string/jumbo v2, "dateTime"

    invoke-static {p2, v2}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 414
    const/4 v3, 0x0

    :try_start_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v3

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    const-string/jumbo v4, "account_dirty"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v4, "accounts"

    const-string/jumbo v5, "%s = ? and %s = ? and %s = 1 and %s = 1"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string/jumbo v8, "directed_id"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    const-string/jumbo v8, "account_timestamp"

    aput-object v8, v6, v7

    const/4 v7, 0x2

    const-string/jumbo v8, "account_deleted"

    aput-object v8, v6, v7

    const/4 v7, 0x3

    const-string/jumbo v8, "account_dirty"

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    const/4 v7, 0x1

    invoke-virtual {p2}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v3, v4, v2, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    const-string/jumbo v4, "userdata_dirty"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v4, "userdata"

    const-string/jumbo v5, "%s = ? and %s = ? and %s = 1 and %s = 1"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string/jumbo v8, "userdata_account_id"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    const-string/jumbo v8, "userdata_timestamp"

    aput-object v8, v6, v7

    const/4 v7, 0x2

    const-string/jumbo v8, "userdata_deleted"

    aput-object v8, v6, v7

    const/4 v7, 0x3

    const-string/jumbo v8, "userdata_dirty"

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    const/4 v7, 0x1

    invoke-virtual {p2}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v3, v4, v2, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    const-string/jumbo v4, "token_dirty"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v4, "tokens"

    const-string/jumbo v5, "%s = ? and %s = ? and %s = 1 and %s = 1"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string/jumbo v8, "token_account_id"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    const-string/jumbo v8, "token_timestamp"

    aput-object v8, v6, v7

    const/4 v7, 0x2

    const-string/jumbo v8, "token_deleted"

    aput-object v8, v6, v7

    const/4 v7, 0x3

    const-string/jumbo v8, "token_dirty"

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    const/4 v7, 0x1

    invoke-virtual {p2}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v3, v4, v2, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-eqz v3, :cond_0

    :try_start_2
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    .line 416
    :cond_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getLocalAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/DatabaseValue;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v1

    .line 417
    .local v1, "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    if-nez v1, :cond_3

    .line 433
    :cond_1
    monitor-exit p0

    return-void

    .line 414
    .end local v1    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    :catchall_0
    move-exception v2

    if-eqz v3, :cond_2

    :try_start_3
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    :cond_2
    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 411
    :catchall_1
    move-exception v2

    monitor-exit p0

    throw v2

    .line 422
    .restart local v1    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    :cond_3
    :try_start_4
    invoke-virtual {v1, p2}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->setNotDirtyIfHasCurrentTimeStamp(Ljava/util/Date;)V

    .line 424
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 426
    invoke-virtual {v2, p2}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->setNotDirtyIfHasCurrentTimeStamp(Ljava/util/Date;)V

    goto :goto_0

    .line 429
    :cond_4
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 431
    invoke-virtual {v2, p2}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->setNotDirtyIfHasCurrentTimeStamp(Ljava/util/Date;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    goto :goto_1
.end method

.method public declared-synchronized setNotDirtySetDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V
    .locals 10
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "dateTime"    # Ljava/util/Date;

    .prologue
    .line 868
    monitor-enter p0

    :try_start_0
    const-string/jumbo v2, "namespace"

    invoke-static {p1, v2}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 869
    const-string/jumbo v2, "key"

    invoke-static {p2, v2}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 870
    const-string/jumbo v2, "dateTime"

    invoke-static {p3, v2}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 872
    :try_start_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    const-string/jumbo v4, "device_data_dirty"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string/jumbo v4, "device_data"

    const-string/jumbo v5, "%s = ? and %s = ? and %s = ? and %s = 0 and %s = 1"

    const/4 v6, 0x5

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string/jumbo v8, "device_data_namespace"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    const-string/jumbo v8, "device_data_key"

    aput-object v8, v6, v7

    const/4 v7, 0x2

    const-string/jumbo v8, "device_data_timestamp"

    aput-object v8, v6, v7

    const/4 v7, 0x3

    const-string/jumbo v8, "device_data_deleted"

    aput-object v8, v6, v7

    const/4 v7, 0x4

    const-string/jumbo v8, "device_data_dirty"

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    const/4 v7, 0x1

    aput-object p2, v6, v7

    const/4 v7, 0x2

    invoke-virtual {p3}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v2, v4, v3, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    .line 874
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mDeviceData:Ljava/util/Map;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    if-nez v2, :cond_1

    .line 892
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 872
    :catchall_0
    move-exception v2

    :try_start_3
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 868
    :catchall_1
    move-exception v2

    monitor-exit p0

    throw v2

    .line 879
    :cond_1
    :try_start_4
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mDeviceData:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    .line 880
    .local v1, "namespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    if-eqz v1, :cond_0

    .line 885
    invoke-interface {v1, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 886
    .local v0, "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    .line 891
    invoke-virtual {v0, p3}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->setNotDirtyIfHasCurrentTimeStamp(Ljava/util/Date;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    goto :goto_0
.end method

.method public declared-synchronized setNotDirtySetToken(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "dateTime"    # Ljava/util/Date;

    .prologue
    .line 668
    monitor-enter p0

    :try_start_0
    const-string/jumbo v2, "directedId"

    invoke-static {p1, v2}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 669
    const-string/jumbo v2, "key"

    invoke-static {p2, v2}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 670
    const-string/jumbo v2, "dateTime"

    invoke-static {p3, v2}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 672
    :try_start_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    invoke-direct {p0, v2, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->insertTokenNotDirty(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    .line 674
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getLocalAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/DatabaseValue;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v0

    .line 675
    .local v0, "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    if-nez v0, :cond_1

    .line 687
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 672
    .end local v0    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    :catchall_0
    move-exception v2

    :try_start_3
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 668
    :catchall_1
    move-exception v2

    monitor-exit p0

    throw v2

    .line 680
    .restart local v0    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    :cond_1
    :try_start_4
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v2, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 681
    .local v1, "token":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    if-eqz v1, :cond_0

    .line 686
    invoke-virtual {v1, p3}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->setNotDirtyIfHasCurrentTimeStamp(Ljava/util/Date;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    goto :goto_0
.end method

.method public declared-synchronized setNotDirtySetUserData(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "dateTime"    # Ljava/util/Date;

    .prologue
    .line 566
    monitor-enter p0

    :try_start_0
    const-string/jumbo v2, "directedId"

    invoke-static {p1, v2}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 567
    const-string/jumbo v2, "key"

    invoke-static {p2, v2}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 568
    const-string/jumbo v2, "dateTime"

    invoke-static {p3, v2}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 570
    const/4 v3, 0x0

    :try_start_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v3

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    invoke-direct {p0, v3, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->insertUserdataNotDirty(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-eqz v3, :cond_0

    :try_start_2
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    .line 572
    :cond_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getLocalAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/DatabaseValue;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v0

    .line 573
    .local v0, "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    if-nez v0, :cond_3

    .line 585
    :cond_1
    :goto_0
    monitor-exit p0

    return-void

    .line 570
    .end local v0    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    :catchall_0
    move-exception v2

    if-eqz v3, :cond_2

    :try_start_3
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$LocalDataStorageDBHelper;->close()V

    :cond_2
    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 566
    :catchall_1
    move-exception v2

    monitor-exit p0

    throw v2

    .line 578
    .restart local v0    # "info":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Lcom/amazon/identity/auth/device/storage/AccountInfo;>;"
    :cond_3
    :try_start_4
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    invoke-interface {v2, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 579
    .local v1, "userdataInfo":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;"
    if-eqz v1, :cond_1

    .line 584
    invoke-virtual {v1, p3}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->setNotDirtyIfHasCurrentTimeStamp(Ljava/util/Date;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    goto :goto_0
.end method

.method public declared-synchronized setSnapshotOfData(Ljava/util/Collection;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)Z"
        }
    .end annotation

    .prologue
    .line 1065
    .local p1, "snapshotData":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->cleanDb(Landroid/content/Context;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mAccountInfos:Ljava/util/Map;

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->mDeviceData:Ljava/util/Map;

    .line 1066
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setBulkData(Ljava/util/Collection;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    .line 1065
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "token"    # Ljava/lang/String;
    .param p4, "dateTime"    # Ljava/util/Date;
    .param p5, "isSyncSet"    # Z

    .prologue
    .line 615
    monitor-enter p0

    :try_start_0
    new-instance v0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    const/4 v1, 0x0

    invoke-static {p2, p3}, Ljava/util/Collections;->singletonMap(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v2

    invoke-direct {v0, p1, v1, v2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;-><init>(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V

    invoke-virtual {p0, v0, p4, p5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;Z)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setTokens(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;Z)Z
    .locals 1
    .param p1, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p2, "dateTime"    # Ljava/util/Date;
    .param p3, "isSyncSet"    # Z

    .prologue
    .line 653
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;Z)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setUserData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;Z)Z
    .locals 1
    .param p1, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p2, "dateTime"    # Ljava/util/Date;
    .param p3, "isSyncSet"    # Z

    .prologue
    .line 527
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;Z)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;
    .param p4, "dateTime"    # Ljava/util/Date;
    .param p5, "isSyncSet"    # Z

    .prologue
    .line 463
    monitor-enter p0

    :try_start_0
    new-instance v0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    invoke-static {p2, p3}, Ljava/util/Collections;->singletonMap(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v1

    const/4 v2, 0x0

    invoke-direct {v0, p1, v1, v2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;-><init>(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V

    invoke-virtual {p0, v0, p4, p5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;Z)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
