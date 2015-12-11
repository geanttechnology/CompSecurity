.class public Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;
.super Ljava/lang/Object;
.source "LocalDataStorageV2.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;
    }
.end annotation


# static fields
.field static final ACCOUNTS_COLUMN_DIRECTED_ID:Ljava/lang/String; = "directed_id"

.field static final ACCOUNTS_COLUMN_DISPLAY_NAME:Ljava/lang/String; = "display_name"

.field static final ACCOUNT_DATA_COLUMN_DATA_KEY:Ljava/lang/String; = "account_data_key"

.field static final ACCOUNT_DATA_COLUMN_DATA_VALUE:Ljava/lang/String; = "account_data_value"

.field static final ACCOUNT_DATA_COLUMN_DIRECTED_ID:Ljava/lang/String; = "account_data_directed_id"

.field static final COLUMN_ID:Ljava/lang/String; = "_id"

.field static final DEVICE_DATA_COLUMN_DEVICE_DATA_KEY:Ljava/lang/String; = "device_data_key"

.field static final DEVICE_DATA_COLUMN_DEVICE_DATA_NAMESPACE:Ljava/lang/String; = "device_data_namespace"

.field static final DEVICE_DATA_COLUMN_DEVICE_DATA_VALUE:Ljava/lang/String; = "device_data_value"

.field static final LOCAL_DATA_STORAGE_DB_NAME:Ljava/lang/String; = "map_data_storage_v2"

.field static final LOCAL_DATA_STORAGE_DB_VERSION:I = 0x1

.field static final TABLE_ACCOUNTS:Ljava/lang/String; = "accounts"

.field static final TABLE_ACCOUNT_DATA:Ljava/lang/String; = "account_data"

.field static final TABLE_DEVICE_DATA:Ljava/lang/String; = "device_data"

.field private static final TAG:Ljava/lang/String;

.field private static sLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;


# instance fields
.field private mAESCipher:Lcom/amazon/identity/auth/device/framework/AESCipher;

.field private mAccountCache:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/AccountInfoV2;",
            ">;"
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
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private final mKeyValueStore:Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

.field private final mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 58
    const-class v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 164
    const-string/jumbo v0, "map_data_storage_v2"

    const/4 v1, 0x1

    invoke-direct {p0, p1, v0, v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;-><init>(Landroid/content/Context;Ljava/lang/String;I)V

    .line 165
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Ljava/lang/String;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "dbName"    # Ljava/lang/String;
    .param p3, "dbVersion"    # I

    .prologue
    .line 168
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 169
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mContext:Landroid/content/Context;

    .line 171
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "com.amazon.identity.auth.device.storage.LocalOnlySQLDB.encryption.namespace"

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mKeyValueStore:Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    .line 173
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mKeyValueStore:Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    invoke-direct {v0, p1, p2, p3, v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;-><init>(Landroid/content/Context;Ljava/lang/String;ILcom/amazon/identity/auth/device/storage/LocalKeyValueStore;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    .line 175
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mAESCipher:Lcom/amazon/identity/auth/device/framework/AESCipher;

    .line 176
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->TAG:Ljava/lang/String;

    return-object v0
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
    .line 1101
    .local p1, "projectionMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p2, p3, p4}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getAliasColumnName(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, p4, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1102
    return-void
.end method

.method public static cleanDb(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1106
    const-string/jumbo v0, "map_data_storage_v2"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->cleanDb(Landroid/content/Context;Ljava/lang/String;)V

    .line 1107
    return-void
.end method

.method public static cleanDb(Landroid/content/Context;Ljava/lang/String;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "dbName"    # Ljava/lang/String;

    .prologue
    .line 1111
    if-nez p0, :cond_0

    .line 1119
    :goto_0
    return-void

    .line 1116
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ".db"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Landroid/content/Context;->deleteDatabase(Ljava/lang/String;)Z

    move-result v1

    .line 1117
    if-eqz v1, :cond_1

    const-string/jumbo v0, "successful"

    .line 1118
    .local v0, "result":Ljava/lang/String;
    :goto_1
    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "cleanDb "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 1117
    .end local v0    # "result":Ljava/lang/String;
    :cond_1
    const-string/jumbo v0, "failed"

    goto :goto_1
.end method

.method private decode([B)Ljava/lang/String;
    .locals 6
    .param p1, "value"    # [B

    .prologue
    const/4 v2, 0x0

    .line 790
    if-nez p1, :cond_0

    .line 798
    :goto_0
    return-object v2

    .line 797
    :cond_0
    const/4 v3, 0x1

    :try_start_0
    invoke-direct {p0, v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->getCipher(Z)Lcom/amazon/identity/auth/device/framework/AESCipher;

    move-result-object v3

    if-eqz v3, :cond_1

    if-nez p1, :cond_3

    :cond_1
    move-object v0, v2

    .line 798
    .local v0, "decryptedData":[B
    :cond_2
    new-instance v2, Ljava/lang/String;

    const-string/jumbo v3, "UTF-8"

    invoke-direct {v2, v0, v3}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 800
    .end local v0    # "decryptedData":[B
    :catch_0
    move-exception v1

    .line 802
    .local v1, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2

    .line 797
    .end local v1    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_3
    :try_start_1
    invoke-virtual {v3, p1}, Lcom/amazon/identity/auth/device/framework/AESCipher;->decryptCBCMode([B)[B

    move-result-object v0

    if-nez v0, :cond_2

    sget-object v2, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "The decrypt result is null. This should not happen!"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v2, "DecryptionFailure"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string/jumbo v5, "decryptCBCModeReturnNull"

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mContext:Landroid/content/Context;

    const-string/jumbo v3, "map_data_storage_v2"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->cleanDb(Landroid/content/Context;Ljava/lang/String;)V

    new-instance v2, Ljava/lang/IllegalStateException;

    const-string/jumbo v3, "decryptCBCMode returns null. Something wrong with the decryption"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_0
.end method

.method private encode(Ljava/lang/String;)[B
    .locals 7
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 772
    if-nez p1, :cond_1

    .line 780
    :cond_0
    :goto_0
    return-object v2

    .line 779
    :cond_1
    :try_start_0
    const-string/jumbo v3, "UTF-8"

    invoke-virtual {p1, v3}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v1

    .line 780
    .local v1, "encodedData":[B
    const/4 v3, 0x0

    invoke-direct {p0, v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->getCipher(Z)Lcom/amazon/identity/auth/device/framework/AESCipher;

    move-result-object v3

    if-eqz v3, :cond_0

    if-eqz v1, :cond_0

    invoke-virtual {v3, v1}, Lcom/amazon/identity/auth/device/framework/AESCipher;->encryptCBCMode([B)[B

    move-result-object v2

    if-nez v2, :cond_0

    sget-object v3, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "The encrypt result is null. This should not happen!"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v3, "EncryptionFailure"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string/jumbo v6, "encryptCBCModeReturnNull"

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 782
    .end local v1    # "encodedData":[B
    :catch_0
    move-exception v0

    .line 784
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method

.method private fetchCachedAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/AccountInfoV2;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 660
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mAccountCache:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 662
    const/4 v0, 0x0

    .line 665
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mAccountCache:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;

    goto :goto_0
.end method

.method private getAccountDataFromDB(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/util/Map;
    .locals 13
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/sqlite/SQLiteDatabase;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 903
    new-instance v12, Ljava/util/HashMap;

    invoke-direct {v12}, Ljava/util/HashMap;-><init>()V

    .line 905
    .local v12, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v8, 0x0

    .line 908
    .local v8, "cursor":Landroid/database/Cursor;
    :try_start_0
    const-string/jumbo v1, "account_data"

    const/4 v0, 0x3

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string/jumbo v3, "account_data_directed_id"

    aput-object v3, v2, v0

    const/4 v0, 0x1

    const-string/jumbo v3, "account_data_key"

    aput-object v3, v2, v0

    const/4 v0, 0x2

    const-string/jumbo v3, "account_data_value"

    aput-object v3, v2, v0

    const-string/jumbo v0, "%s = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string/jumbo v5, "account_data_directed_id"

    aput-object v5, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object p2, v4, v0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p1

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 919
    if-eqz v8, :cond_0

    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_1

    .line 940
    :cond_0
    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    :goto_0
    return-object v12

    .line 924
    :cond_1
    :try_start_1
    const-string/jumbo v0, "account_data_key"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v10

    .line 925
    .local v10, "dataKeyColumn":I
    const-string/jumbo v0, "account_data_value"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v11

    .line 929
    .local v11, "dataValueColumn":I
    :cond_2
    invoke-interface {v8, v10}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 930
    .local v9, "dataKey":Ljava/lang/String;
    if-eqz v9, :cond_3

    .line 932
    invoke-interface {v8, v11}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->decode([B)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v12, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 935
    :cond_3
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    if-nez v0, :cond_2

    .line 940
    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    goto :goto_0

    .end local v9    # "dataKey":Ljava/lang/String;
    .end local v10    # "dataKeyColumn":I
    .end local v11    # "dataValueColumn":I
    :catchall_0
    move-exception v0

    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    throw v0
.end method

.method private getAndCacheAllAccounts()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/AccountInfoV2;",
            ">;"
        }
    .end annotation

    .prologue
    .line 486
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mAccountCache:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 488
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->populateAccountCache()Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mAccountCache:Ljava/util/Map;

    .line 491
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mAccountCache:Ljava/util/Map;

    return-object v0
.end method

.method private declared-synchronized getCipher(Z)Lcom/amazon/identity/auth/device/framework/AESCipher;
    .locals 6
    .param p1, "isDecryption"    # Z

    .prologue
    .line 846
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mAESCipher:Lcom/amazon/identity/auth/device/framework/AESCipher;

    if-nez v2, :cond_2

    .line 848
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mKeyValueStore:Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    const-string/jumbo v3, "com.amazon.identity.auth.device.storage.LocalOnlySQLDB.encrypt.key"

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 849
    .local v1, "encryptionKeyStr":Ljava/lang/String;
    if-nez v1, :cond_1

    .line 851
    if-eqz p1, :cond_0

    .line 853
    sget-object v2, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Cannot get the encryption key from SharedPreferences before decrypt. This should not happen!"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 855
    const-string/jumbo v2, "DecryptionFailure"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string/jumbo v5, "EncryptionKeyNotFound"

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 857
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mContext:Landroid/content/Context;

    const-string/jumbo v3, "map_data_storage_v2"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->cleanDb(Landroid/content/Context;Ljava/lang/String;)V

    .line 858
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string/jumbo v3, "The encryption key is null!"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 846
    .end local v1    # "encryptionKeyStr":Ljava/lang/String;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 862
    .restart local v1    # "encryptionKeyStr":Ljava/lang/String;
    :cond_0
    :try_start_1
    sget-object v2, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Cannot get the encryption key from SharedPreferences before encrypt. Gonna create a new key. This should not happen!"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 864
    const-string/jumbo v2, "EncryptionFailure"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string/jumbo v5, "EncryptionKeyNotFound"

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 868
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mKeyValueStore:Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    const-string/jumbo v3, "com.amazon.identity.auth.device.storage.LocalOnlySQLDB.encrypt.key"

    invoke-static {}, Lcom/amazon/identity/auth/device/framework/AESCipher;->generateAesSecureStorageKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->setValue(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    .line 870
    if-eqz v2, :cond_3

    .line 872
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mKeyValueStore:Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    const-string/jumbo v3, "com.amazon.identity.auth.device.storage.LocalOnlySQLDB.encrypt.key"

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 884
    :cond_1
    const/4 v2, 0x0

    invoke-static {v1, v2}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v0

    .line 885
    .local v0, "encryptionKey":[B
    new-instance v2, Lcom/amazon/identity/auth/device/framework/AESCipher;

    invoke-direct {v2, v0}, Lcom/amazon/identity/auth/device/framework/AESCipher;-><init>([B)V

    iput-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mAESCipher:Lcom/amazon/identity/auth/device/framework/AESCipher;

    .line 887
    .end local v0    # "encryptionKey":[B
    .end local v1    # "encryptionKeyStr":Ljava/lang/String;
    :cond_2
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mAESCipher:Lcom/amazon/identity/auth/device/framework/AESCipher;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :goto_0
    monitor-exit p0

    return-object v2

    .line 876
    .restart local v1    # "encryptionKeyStr":Ljava/lang/String;
    :cond_3
    :try_start_2
    sget-object v2, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Try to re-generate the encryption key and save it into shared preferences failed!"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 878
    const-string/jumbo v2, "EncryptionFailure"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string/jumbo v5, "TryToRegenerateEncryptionKeyFailure"

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 880
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 180
    const-class v1, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->sLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    if-nez v0, :cond_0

    .line 182
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->sLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    .line 185
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->sLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 180
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private hasAccount(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "directedId"    # Ljava/lang/String;

    .prologue
    .line 651
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mAccountCache:Ljava/util/Map;

    if-nez v0, :cond_0

    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->populateAccountCache(Landroid/database/sqlite/SQLiteDatabase;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mAccountCache:Ljava/util/Map;

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mAccountCache:Ljava/util/Map;

    .line 653
    invoke-interface {v0, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;

    .line 655
    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private populateAccountCache()Ljava/util/Map;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/AccountInfoV2;",
            ">;"
        }
    .end annotation

    .prologue
    .line 947
    const/4 v0, 0x0

    .line 950
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 951
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->populateAccountCache(Landroid/database/sqlite/SQLiteDatabase;)Ljava/util/Map;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 955
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V

    return-object v1

    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V

    throw v1
.end method

.method private populateAccountCache(Landroid/database/sqlite/SQLiteDatabase;)Ljava/util/Map;
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
            "Lcom/amazon/identity/auth/device/storage/AccountInfoV2;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1019
    new-instance v10, Ljava/util/HashMap;

    invoke-direct {v10}, Ljava/util/HashMap;-><init>()V

    .line 1021
    .local v10, "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountInfoV2;>;"
    const/4 v11, 0x0

    .line 1024
    .local v11, "cursor":Landroid/database/Cursor;
    :try_start_0
    new-instance v2, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v2}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "accounts"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string/jumbo v4, " LEFT OUTER JOIN account_data ON ("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string/jumbo v4, "accounts"

    const-string/jumbo v5, "directed_id"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getNamespaceColumnName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string/jumbo v4, "account_data"

    const-string/jumbo v5, "account_data_directed_id"

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

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "accounts"

    const-string/jumbo v5, "directed_id"

    const-string/jumbo v6, "directed_id"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "accounts"

    const-string/jumbo v5, "display_name"

    const-string/jumbo v6, "display_name"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "account_data"

    const-string/jumbo v5, "account_data_key"

    const-string/jumbo v6, "account_data_key"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "account_data"

    const-string/jumbo v5, "account_data_value"

    const-string/jumbo v6, "account_data_value"

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->addToProjection(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

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

    move-result-object v11

    .line 1025
    if-eqz v11, :cond_0

    invoke-interface {v11}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    if-nez v2, :cond_1

    .line 1058
    :cond_0
    invoke-static {v11}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    :goto_0
    return-object v10

    .line 1030
    :cond_1
    :try_start_1
    const-string/jumbo v2, "directed_id"

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v16

    .line 1031
    .local v16, "directedIdColumn":I
    const-string/jumbo v2, "display_name"

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v18

    .line 1032
    .local v18, "displayNameColumn":I
    const-string/jumbo v2, "account_data_key"

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v13

    .line 1033
    .local v13, "dataKeyColumn":I
    const-string/jumbo v2, "account_data_value"

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v14

    .line 1037
    .local v14, "dataValueColumn":I
    :cond_2
    move/from16 v0, v16

    invoke-interface {v11, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v15

    .line 1038
    .local v15, "directedId":Ljava/lang/String;
    invoke-interface {v10, v15}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;

    .line 1039
    .local v19, "info":Lcom/amazon/identity/auth/device/storage/AccountInfoV2;
    if-nez v19, :cond_3

    .line 1041
    move/from16 v0, v18

    invoke-interface {v11, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v17

    .line 1042
    .local v17, "displayName":Ljava/lang/String;
    new-instance v19, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;

    .end local v19    # "info":Lcom/amazon/identity/auth/device/storage/AccountInfoV2;
    move-object/from16 v0, v19

    move-object/from16 v1, v17

    invoke-direct {v0, v15, v1}, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 1044
    .restart local v19    # "info":Lcom/amazon/identity/auth/device/storage/AccountInfoV2;
    move-object/from16 v0, v19

    invoke-interface {v10, v15, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1047
    .end local v17    # "displayName":Ljava/lang/String;
    :cond_3
    invoke-interface {v11, v13}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v12

    .line 1048
    .local v12, "dataKey":Ljava/lang/String;
    if-eqz v12, :cond_4

    .line 1050
    move-object/from16 v0, v19

    iget-object v2, v0, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;->accountData:Ljava/util/Map;

    invoke-interface {v11, v14}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v3

    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->decode([B)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v12, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1053
    :cond_4
    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v2

    if-nez v2, :cond_2

    .line 1058
    invoke-static {v11}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    goto :goto_0

    .end local v12    # "dataKey":Ljava/lang/String;
    .end local v13    # "dataKeyColumn":I
    .end local v14    # "dataValueColumn":I
    .end local v15    # "directedId":Ljava/lang/String;
    .end local v16    # "directedIdColumn":I
    .end local v18    # "displayNameColumn":I
    .end local v19    # "info":Lcom/amazon/identity/auth/device/storage/AccountInfoV2;
    :catchall_0
    move-exception v2

    invoke-static {v11}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    throw v2
.end method

.method private populateDeviceData()Ljava/util/Map;
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 961
    new-instance v11, Ljava/util/HashMap;

    invoke-direct {v11}, Ljava/util/HashMap;-><init>()V

    .line 963
    .local v11, "deviceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    const/4 v9, 0x0

    .line 967
    .local v9, "cursor":Landroid/database/Cursor;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 969
    const-string/jumbo v2, "device_data"

    const/4 v3, 0x3

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

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 980
    if-eqz v9, :cond_0

    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_1

    .line 1012
    :cond_0
    invoke-static {v9}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    .line 1013
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V

    :goto_0
    return-object v11

    .line 985
    :cond_1
    :try_start_1
    const-string/jumbo v1, "device_data_namespace"

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v14

    .line 986
    .local v14, "namespaceColumn":I
    const-string/jumbo v1, "device_data_key"

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v12

    .line 987
    .local v12, "keyColumn":I
    const-string/jumbo v1, "device_data_value"

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v16

    .line 991
    .local v16, "valueColumn":I
    :cond_2
    invoke-interface {v9, v14}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v13

    .line 992
    .local v13, "namespace":Ljava/lang/String;
    invoke-interface {v11, v13}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/util/Map;

    .line 993
    .local v15, "namespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez v15, :cond_3

    .line 995
    new-instance v15, Ljava/util/HashMap;

    .end local v15    # "namespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {v15}, Ljava/util/HashMap;-><init>()V

    .line 996
    .restart local v15    # "namespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v11, v13, v15}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 999
    :cond_3
    invoke-interface {v9, v12}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 1001
    .local v10, "deviceDataKey":Ljava/lang/String;
    if-eqz v10, :cond_4

    .line 1003
    move/from16 v0, v16

    invoke-interface {v9, v0}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v1

    move-object/from16 v0, p0

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->decode([B)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v15, v10, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1006
    :cond_4
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v1

    if-nez v1, :cond_2

    .line 1012
    invoke-static {v9}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    .line 1013
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V

    goto :goto_0

    .line 1012
    .end local v10    # "deviceDataKey":Ljava/lang/String;
    .end local v12    # "keyColumn":I
    .end local v13    # "namespace":Ljava/lang/String;
    .end local v14    # "namespaceColumn":I
    .end local v15    # "namespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v16    # "valueColumn":I
    :catchall_0
    move-exception v1

    invoke-static {v9}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    .line 1013
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V

    throw v1
.end method

.method private setAccountDataAndUpdateCache(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 3
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "key"    # Ljava/lang/String;
    .param p4, "value"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 546
    if-eqz p2, :cond_0

    if-nez p3, :cond_1

    .line 569
    :cond_0
    :goto_0
    return v1

    .line 551
    :cond_1
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->hasAccount(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 556
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->setAccountDataInDb(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    .line 558
    if-eqz v2, :cond_0

    .line 563
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->fetchCachedAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/AccountInfoV2;

    move-result-object v0

    .line 564
    .local v0, "info":Lcom/amazon/identity/auth/device/storage/AccountInfoV2;
    if-eqz v0, :cond_2

    .line 566
    iget-object v1, v0, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;->accountData:Ljava/util/Map;

    invoke-interface {v1, p3, p4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 569
    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method

.method private setAccountDataInDb(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 8
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "key"    # Ljava/lang/String;
    .param p4, "value"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 733
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 734
    .local v0, "values":Landroid/content/ContentValues;
    const-string/jumbo v1, "account_data_directed_id"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 735
    const-string/jumbo v1, "account_data_key"

    invoke-virtual {v0, v1, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 736
    const-string/jumbo v1, "account_data_value"

    invoke-direct {p0, p4}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->encode(Ljava/lang/String;)[B

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;[B)V

    .line 738
    const-string/jumbo v1, "account_data"

    const-string/jumbo v2, "%s = ? and %s = ?"

    new-array v3, v7, [Ljava/lang/Object;

    const-string/jumbo v4, "account_data_directed_id"

    aput-object v4, v3, v5

    const-string/jumbo v4, "account_data_key"

    aput-object v4, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    new-array v3, v7, [Ljava/lang/String;

    aput-object p2, v3, v5

    aput-object p3, v3, v6

    invoke-static {p1, v1, v0, v2, v3}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->ifCannotUpdateThenInsert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v1

    .line 746
    return v1
.end method


# virtual methods
.method public declared-synchronized addAccount(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Z
    .locals 10
    .param p1, "displayName"    # Ljava/lang/String;
    .param p2, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .local p3, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 258
    monitor-enter p0

    const/4 v0, 0x0

    .line 261
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 262
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 264
    if-eqz p2, :cond_0

    if-nez p1, :cond_3

    :cond_0
    move v2, v6

    .line 265
    .local v2, "success":Z
    :goto_0
    if-eqz v2, :cond_1

    .line 267
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteConstraintException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 270
    :cond_1
    if-eqz v0, :cond_2

    .line 280
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 281
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 285
    .end local v2    # "success":Z
    :cond_2
    :goto_1
    monitor-exit p0

    return v2

    .line 264
    :cond_3
    :try_start_2
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    const-string/jumbo v4, "directed_id"

    invoke-virtual {v3, v4, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "display_name"

    invoke-virtual {v3, v4, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "accounts"

    invoke-static {v0, v4, v3}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->tryInsert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;)Z

    move-result v3

    if-nez v3, :cond_4

    sget-object v3, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Failed to add account"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v7

    :goto_2
    if-nez v3, :cond_9

    move v2, v6

    goto :goto_0

    :cond_4
    invoke-direct {p0, v0, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->getAccountDataFromDB(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/util/Map;

    move-result-object v8

    if-eqz p3, :cond_7

    invoke-interface {p3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_3
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_7

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-direct {p0, v0, p2, v4, v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->setAccountDataInDb(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_5

    sget-object v3, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Failed to save account because saving token was unsuccessful"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v7

    goto :goto_2

    :cond_5
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v8, v4, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catch Landroid/database/sqlite/SQLiteConstraintException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_3

    .line 272
    :catch_0
    move-exception v1

    .line 274
    .local v1, "e":Landroid/database/sqlite/SQLiteConstraintException;
    :try_start_3
    sget-object v3, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Cannot add account due to "

    invoke-static {v3, v4, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 278
    if-eqz v0, :cond_6

    .line 280
    :try_start_4
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 281
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    :cond_6
    move v2, v6

    .line 285
    goto :goto_1

    .line 264
    .end local v1    # "e":Landroid/database/sqlite/SQLiteConstraintException;
    :cond_7
    :try_start_5
    new-instance v3, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;

    invoke-direct {v3, p2, p1, v8}, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    :try_end_5
    .catch Landroid/database/sqlite/SQLiteConstraintException; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_2

    .line 278
    :catchall_0
    move-exception v3

    if-eqz v0, :cond_8

    .line 280
    :try_start_6
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 281
    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V

    :cond_8
    throw v3
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 258
    :catchall_1
    move-exception v3

    monitor-exit p0

    throw v3

    .line 264
    :cond_9
    :try_start_7
    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mAccountCache:Ljava/util/Map;

    if-eqz v4, :cond_a

    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mAccountCache:Ljava/util/Map;

    invoke-interface {v4, p2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_7
    .catch Landroid/database/sqlite/SQLiteConstraintException; {:try_start_7 .. :try_end_7} :catch_0
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    :cond_a
    const/4 v2, 0x1

    goto/16 :goto_0
.end method

.method public declared-synchronized getAccountData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 317
    monitor-enter p0

    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 328
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v1

    .line 322
    :cond_1
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->getAndCacheAllAccounts()Ljava/util/Map;

    move-result-object v2

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;

    .line 323
    .local v0, "info":Lcom/amazon/identity/auth/device/storage/AccountInfoV2;
    if-eqz v0, :cond_0

    .line 328
    iget-object v1, v0, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;->accountData:Ljava/util/Map;

    invoke-interface {v1, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 317
    .end local v0    # "info":Lcom/amazon/identity/auth/device/storage/AccountInfoV2;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
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
    .line 202
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->getAndCacheAllAccounts()Ljava/util/Map;

    move-result-object v0

    .line 204
    .local v0, "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountInfoV2;>;"
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 205
    .local v1, "accountNames":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;

    .line 207
    .local v2, "entry":Lcom/amazon/identity/auth/device/storage/AccountInfoV2;
    iget-object v4, v2, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;->displayName:Ljava/lang/String;

    invoke-interface {v1, v4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 202
    .end local v0    # "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountInfoV2;>;"
    .end local v1    # "accountNames":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v2    # "entry":Lcom/amazon/identity/auth/device/storage/AccountInfoV2;
    .end local v3    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 209
    .restart local v0    # "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountInfoV2;>;"
    .restart local v1    # "accountNames":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .restart local v3    # "i$":Ljava/util/Iterator;
    :cond_0
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
    .line 190
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->getAndCacheAllAccounts()Ljava/util/Map;

    move-result-object v0

    .line 192
    .local v0, "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountInfoV2;>;"
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 193
    .local v1, "accounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 195
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountInfoV2;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 190
    .end local v0    # "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountInfoV2;>;"
    .end local v1    # "accounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountInfoV2;>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 197
    .restart local v0    # "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountInfoV2;>;"
    .restart local v1    # "accounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .restart local v3    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    invoke-static {v1}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v4

    monitor-exit p0

    return-object v4
.end method

.method public declared-synchronized getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 333
    monitor-enter p0

    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 346
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v1

    .line 338
    :cond_1
    :try_start_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mDeviceData:Ljava/util/Map;

    if-nez v2, :cond_2

    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->populateDeviceData()Ljava/util/Map;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mDeviceData:Ljava/util/Map;

    :cond_2
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mDeviceData:Ljava/util/Map;

    .line 339
    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 341
    .local v0, "deviceNamespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    .line 346
    invoke-interface {v0, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 333
    .end local v0    # "deviceNamespaceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getDirectedId(Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p1, "displayName"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 234
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v4

    if-eqz v4, :cond_1

    .line 251
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v3

    .line 238
    :cond_1
    :try_start_1
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->getAndCacheAllAccounts()Ljava/util/Map;

    move-result-object v1

    .line 239
    .local v1, "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountInfoV2;>;"
    if-eqz v1, :cond_0

    invoke-interface {v1}, Ljava/util/Map;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_0

    .line 244
    invoke-interface {v1}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;

    .line 246
    .local v0, "accountInfo":Lcom/amazon/identity/auth/device/storage/AccountInfoV2;
    iget-object v4, v0, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;->displayName:Ljava/lang/String;

    invoke-static {v4, p1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 248
    iget-object v3, v0, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;->directedId:Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 234
    .end local v0    # "accountInfo":Lcom/amazon/identity/auth/device/storage/AccountInfoV2;
    .end local v1    # "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountInfoV2;>;"
    .end local v2    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized getDisplayName(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 214
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v3

    if-eqz v3, :cond_1

    .line 229
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v2

    .line 218
    :cond_1
    :try_start_1
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->getAndCacheAllAccounts()Ljava/util/Map;

    move-result-object v1

    .line 219
    .local v1, "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountInfoV2;>;"
    if-eqz v1, :cond_0

    invoke-interface {v1}, Ljava/util/Map;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 224
    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;

    .line 225
    .local v0, "accountInfoV2":Lcom/amazon/identity/auth/device/storage/AccountInfoV2;
    if-eqz v0, :cond_0

    .line 229
    iget-object v2, v0, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;->displayName:Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 214
    .end local v0    # "accountInfoV2":Lcom/amazon/identity/auth/device/storage/AccountInfoV2;
    .end local v1    # "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountInfoV2;>;"
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized removeAccount(Ljava/lang/String;)Z
    .locals 9
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 291
    monitor-enter p0

    const/4 v0, 0x0

    .line 294
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 295
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 297
    if-nez p1, :cond_3

    .line 298
    .local v1, "success":Z
    :cond_0
    :goto_0
    if-eqz v1, :cond_1

    .line 300
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 303
    :cond_1
    if-eqz v0, :cond_2

    .line 309
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 310
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :cond_2
    monitor-exit p0

    return v1

    .line 297
    .end local v1    # "success":Z
    :cond_3
    :try_start_2
    const-string/jumbo v3, "%s = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string/jumbo v6, "directed_id"

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const-string/jumbo v5, "accounts"

    invoke-virtual {v0, v5, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v3

    if-lez v3, :cond_5

    move v3, v2

    :goto_1
    const-string/jumbo v4, "account_data"

    const-string/jumbo v5, "%s = ?"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string/jumbo v8, "account_data_directed_id"

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    invoke-virtual {v0, v4, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mAccountCache:Ljava/util/Map;

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mAccountCache:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :cond_4
    move v1, v2

    goto :goto_0

    :cond_5
    move v3, v1

    goto :goto_1

    .line 307
    :catchall_0
    move-exception v2

    if-eqz v0, :cond_6

    .line 309
    :try_start_3
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 310
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V

    :cond_6
    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 291
    :catchall_1
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized removeAccountData(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 456
    monitor-enter p0

    const/4 v0, 0x0

    .line 459
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 460
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 462
    if-eqz p1, :cond_0

    if-nez p2, :cond_3

    .line 463
    .local v1, "success":Z
    :cond_0
    :goto_0
    if-eqz v1, :cond_1

    .line 465
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 468
    :cond_1
    if-eqz v0, :cond_2

    .line 474
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 475
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :cond_2
    monitor-exit p0

    return v1

    .line 462
    .end local v1    # "success":Z
    :cond_3
    :try_start_2
    invoke-direct {p0, v0, p1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->hasAccount(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    const-string/jumbo v3, "%s = ? and %s = ?"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string/jumbo v6, "account_data_directed_id"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const-string/jumbo v6, "account_data_key"

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const/4 v5, 0x1

    aput-object p2, v4, v5

    const-string/jumbo v5, "account_data"

    invoke-virtual {v0, v5, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v3

    if-lez v3, :cond_5

    move v3, v2

    :goto_1
    if-eqz v3, :cond_0

    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->fetchCachedAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/AccountInfoV2;

    move-result-object v3

    if-eqz v3, :cond_4

    iget-object v3, v3, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;->accountData:Ljava/util/Map;

    invoke-interface {v3, p2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :cond_4
    move v1, v2

    goto :goto_0

    :cond_5
    move v3, v1

    goto :goto_1

    .line 472
    :catchall_0
    move-exception v2

    if-eqz v0, :cond_6

    .line 474
    :try_start_3
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 475
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V

    :cond_6
    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 456
    :catchall_1
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized setAccountData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 5
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "token"    # Ljava/lang/String;

    .prologue
    .line 351
    monitor-enter p0

    const/4 v0, 0x0

    .line 354
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 355
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 357
    invoke-direct {p0, v0, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->setAccountDataAndUpdateCache(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    .line 358
    .local v2, "success":Z
    if-eqz v2, :cond_0

    .line 360
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteConstraintException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 363
    :cond_0
    if-eqz v0, :cond_1

    .line 373
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 374
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 378
    .end local v2    # "success":Z
    :cond_1
    :goto_0
    monitor-exit p0

    return v2

    .line 365
    :catch_0
    move-exception v1

    .line 367
    .local v1, "e":Landroid/database/sqlite/SQLiteConstraintException;
    :try_start_2
    sget-object v3, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Cannot set data due to: "

    invoke-static {v3, v4, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 371
    if-eqz v0, :cond_2

    .line 373
    :try_start_3
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 374
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V

    .line 378
    :cond_2
    const/4 v2, 0x0

    goto :goto_0

    .line 371
    .end local v1    # "e":Landroid/database/sqlite/SQLiteConstraintException;
    :catchall_0
    move-exception v3

    if-eqz v0, :cond_3

    .line 373
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 374
    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V

    :cond_3
    throw v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 351
    :catchall_1
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized setAccountData(Ljava/lang/String;Ljava/util/Map;)Z
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 383
    .local p2, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    monitor-enter p0

    const/4 v0, 0x0

    .line 386
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 387
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 389
    const/4 v4, 0x1

    .line 390
    .local v4, "success":Z
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 392
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-direct {p0, v0, p1, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->setAccountDataAndUpdateCache(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 394
    const/4 v4, 0x0

    .line 399
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    if-eqz v4, :cond_2

    .line 401
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteConstraintException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 412
    :cond_2
    if-eqz v0, :cond_3

    .line 414
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 415
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 419
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "success":Z
    :cond_3
    :goto_0
    monitor-exit p0

    return v4

    .line 406
    :catch_0
    move-exception v1

    .line 408
    .local v1, "e":Landroid/database/sqlite/SQLiteConstraintException;
    :try_start_2
    sget-object v5, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Cannot set data due to: "

    invoke-static {v5, v6, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 412
    if-eqz v0, :cond_4

    .line 414
    :try_start_3
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 415
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V

    .line 419
    :cond_4
    const/4 v4, 0x0

    goto :goto_0

    .line 412
    .end local v1    # "e":Landroid/database/sqlite/SQLiteConstraintException;
    :catchall_0
    move-exception v5

    if-eqz v0, :cond_5

    .line 414
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 415
    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V

    :cond_5
    throw v5
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 383
    :catchall_1
    move-exception v5

    monitor-exit p0

    throw v5
.end method

.method public declared-synchronized setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 9
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    const/4 v3, 0x0

    .line 424
    monitor-enter p0

    const/4 v0, 0x0

    .line 427
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 428
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 430
    if-eqz p1, :cond_0

    if-nez p2, :cond_4

    :cond_0
    move v1, v3

    .line 431
    .local v1, "success":Z
    :cond_1
    :goto_0
    if-eqz v1, :cond_2

    .line 433
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteConstraintException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 436
    :cond_2
    if-eqz v0, :cond_3

    .line 446
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 447
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 451
    .end local v1    # "success":Z
    :cond_3
    :goto_1
    monitor-exit p0

    return v1

    .line 430
    :cond_4
    :try_start_2
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    const-string/jumbo v4, "device_data_namespace"

    invoke-virtual {v2, v4, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "device_data_key"

    invoke-virtual {v2, v4, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "device_data_value"

    invoke-direct {p0, p3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->encode(Ljava/lang/String;)[B

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;[B)V

    const-string/jumbo v4, "device_data"

    const-string/jumbo v5, "%s = ? and %s = ?"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string/jumbo v8, "device_data_namespace"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    const-string/jumbo v8, "device_data_key"

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    const/4 v7, 0x1

    aput-object p2, v6, v7

    invoke-static {v0, v4, v2, v5, v6}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->ifCannotUpdateThenInsert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_5

    move v1, v3

    goto :goto_0

    :cond_5
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mDeviceData:Ljava/util/Map;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mDeviceData:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    if-nez v2, :cond_6

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mDeviceData:Ljava/util/Map;

    invoke-interface {v4, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_6
    invoke-interface {v2, p2, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catch Landroid/database/sqlite/SQLiteConstraintException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 440
    :catch_0
    move-exception v2

    :try_start_3
    sget-object v2, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Cannot set device data since it violated a uniqueness constraint"

    invoke-static {v2, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 444
    if-eqz v0, :cond_7

    .line 446
    :try_start_4
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 447
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V

    :cond_7
    move v1, v3

    .line 451
    goto :goto_1

    .line 444
    :catchall_0
    move-exception v2

    if-eqz v0, :cond_8

    .line 446
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 447
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->mLocalDataStorageHelper:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2$LocalDataStorageDBHelper;->close()V

    :cond_8
    throw v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 424
    :catchall_1
    move-exception v2

    monitor-exit p0

    throw v2
.end method
