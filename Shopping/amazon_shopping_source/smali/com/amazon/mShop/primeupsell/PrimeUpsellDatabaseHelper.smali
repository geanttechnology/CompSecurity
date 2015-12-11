.class public Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;
.super Lcom/amazon/mShop/util/DatabaseHelper;
.source "PrimeUpsellDatabaseHelper.java"


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sInstance:Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->TAG:Ljava/lang/String;

    .line 33
    new-instance v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;

    invoke-direct {v0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;-><init>()V

    sput-object v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->sInstance:Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;

    return-void
.end method

.method private constructor <init>()V
    .locals 3

    .prologue
    .line 36
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    const-string/jumbo v1, "prime.db"

    const/4 v2, 0x2

    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/mShop/util/DatabaseHelper;-><init>(Landroid/content/Context;Ljava/lang/String;I)V

    .line 37
    return-void
.end method

.method public static getInstance()Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;
    .locals 1

    .prologue
    .line 184
    sget-object v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->sInstance:Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;

    return-object v0
.end method

.method private getPrimeCounterInfo(Ljava/lang/String;)Landroid/database/Cursor;
    .locals 10
    .param p1, "username"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x1

    const/4 v3, 0x0

    const/4 v5, 0x0

    .line 125
    invoke-virtual {p0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 127
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-direct {p0, p1}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->getUserIdFromName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 128
    .local v9, "userId":Ljava/lang/String;
    const/4 v1, 0x2

    new-array v2, v1, [Ljava/lang/String;

    const-string/jumbo v1, "showedTimes"

    aput-object v1, v2, v3

    const-string/jumbo v1, "errorRetryCount"

    aput-object v1, v2, v6

    .line 129
    .local v2, "columns":[Ljava/lang/String;
    new-array v4, v6, [Ljava/lang/String;

    aput-object v9, v4, v3

    .line 130
    .local v4, "selectionArgs":[Ljava/lang/String;
    const-string/jumbo v1, "primeUpsell"

    const-string/jumbo v3, "usernameHash =? "

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 131
    .local v8, "result":Landroid/database/Cursor;
    return-object v8
.end method

.method private getUserIdFromName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "username"    # Ljava/lang/String;

    .prologue
    .line 188
    new-instance v0, Ljava/lang/String;

    invoke-static {p1}, Lorg/apache/commons/codec/digest/DigestUtils;->md5(Ljava/lang/String;)[B

    move-result-object v1

    invoke-static {v1}, Lorg/apache/commons/codec/binary/Hex;->encodeHex([B)[C

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>([C)V

    return-object v0
.end method


# virtual methods
.method public clearDatabase()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 194
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 195
    invoke-virtual {p0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 196
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string/jumbo v1, "primeUpsell"

    invoke-virtual {v0, v1, v2, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 198
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_0
    return-void
.end method

.method public notExceedMaxCount(Ljava/lang/String;II)Z
    .locals 6
    .param p1, "username"    # Ljava/lang/String;
    .param p2, "maxShowed"    # I
    .param p3, "maxRetry"    # I

    .prologue
    .line 94
    const/4 v3, 0x0

    .line 95
    .local v3, "result":Z
    invoke-direct {p0, p1}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->getPrimeCounterInfo(Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 97
    .local v0, "counter":Landroid/database/Cursor;
    const/4 v4, 0x0

    .line 98
    .local v4, "showedTimes":I
    const/4 v2, 0x0

    .line 100
    .local v2, "errorCount":I
    if-eqz v0, :cond_2

    :try_start_0
    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v5

    if-lez v5, :cond_2

    .line 101
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 102
    const-string/jumbo v5, "showedTimes"

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    .line 103
    const-string/jumbo v5, "errorRetryCount"

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getInt(I)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    .line 104
    if-ge v4, p2, :cond_1

    if-ge v2, p3, :cond_1

    const/4 v3, 0x1

    .line 111
    :goto_0
    if-eqz v0, :cond_0

    .line 112
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 116
    :cond_0
    :goto_1
    return v3

    .line 104
    :cond_1
    const/4 v3, 0x0

    goto :goto_0

    .line 106
    :cond_2
    const/4 v3, 0x1

    goto :goto_0

    .line 108
    :catch_0
    move-exception v1

    .line 109
    .local v1, "e":Ljava/lang/Exception;
    :try_start_1
    iget-object v5, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->mContext:Landroid/content/Context;

    invoke-static {v5, v1}, Lcom/amazon/mShop/util/AmazonErrorUtils;->postExceptionToServer(Landroid/content/Context;Ljava/lang/Exception;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 111
    if-eqz v0, :cond_0

    .line 112
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 111
    .end local v1    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v5

    if-eqz v0, :cond_3

    .line 112
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_3
    throw v5
.end method

.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 3
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 41
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "CREATE TABLE primeUpsell(id INTEGER PRIMARY KEY AUTOINCREMENT "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 42
    .local v0, "sb":Ljava/lang/StringBuilder;
    const-string/jumbo v1, ", usernameHash TEXT UNIQUE "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", showedTimes INTEGER DEFAULT 0 "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", errorRetryCount INTEGER DEFAULT 0"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 47
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 48
    return-void
.end method

.method public onDowngrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 4
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 70
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 71
    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "onDowngrade old: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " new: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 77
    :cond_0
    :try_start_0
    const-string/jumbo v1, "DROP TABLE IF EXISTS primeUpsell"

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 82
    :goto_0
    return-void

    .line 79
    :catch_0
    move-exception v0

    .line 80
    .local v0, "e":Landroid/database/SQLException;
    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->TAG:Ljava/lang/String;

    invoke-virtual {v0}, Landroid/database/SQLException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 4
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 52
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 53
    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "onUpgrade old: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " new: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 55
    :cond_0
    const/4 v1, 0x1

    if-ne p2, v1, :cond_1

    const/4 v1, 0x2

    if-ne p3, v1, :cond_1

    .line 60
    :try_start_0
    const-string/jumbo v1, "UPDATE primeUpsell SET showedTimes=0, errorRetryCount=0 "

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 66
    :cond_1
    :goto_0
    return-void

    .line 62
    :catch_0
    move-exception v0

    .line 63
    .local v0, "e":Landroid/database/SQLException;
    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->TAG:Ljava/lang/String;

    invoke-virtual {v0}, Landroid/database/SQLException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public showedPrimeTo(Ljava/lang/String;Z)V
    .locals 11
    .param p1, "username"    # Ljava/lang/String;
    .param p2, "encounteredError"    # Z

    .prologue
    .line 141
    invoke-direct {p0, p1}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->getUserIdFromName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 142
    .local v5, "userId":Ljava/lang/String;
    if-eqz p2, :cond_2

    const-string/jumbo v3, "errorRetryCount"

    .line 143
    .local v3, "updateColumn":Ljava/lang/String;
    :goto_0
    invoke-direct {p0, p1}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->getPrimeCounterInfo(Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 144
    .local v0, "counter":Landroid/database/Cursor;
    const/4 v4, 0x0

    .line 146
    .local v4, "userExists":Z
    if-eqz v0, :cond_0

    :try_start_0
    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v7

    if-lez v7, :cond_0

    .line 147
    const/4 v4, 0x1

    .line 152
    :cond_0
    if-eqz v0, :cond_1

    .line 153
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 157
    :cond_1
    :goto_1
    invoke-virtual {p0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 158
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 160
    if-nez v4, :cond_4

    .line 161
    :try_start_1
    new-instance v6, Landroid/content/ContentValues;

    invoke-direct {v6}, Landroid/content/ContentValues;-><init>()V

    .line 162
    .local v6, "values":Landroid/content/ContentValues;
    const-string/jumbo v7, "usernameHash"

    invoke-virtual {v6, v7, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 163
    const/4 v7, 0x1

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v6, v3, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 164
    const-string/jumbo v7, "primeUpsell"

    const/4 v8, 0x0

    invoke-virtual {v1, v7, v8, v6}, Landroid/database/sqlite/SQLiteDatabase;->insertOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 166
    const-string/jumbo v7, "primeUpsell"

    const-string/jumbo v8, "id NOT IN (SELECT id FROM primeUpsell ORDER BY id DESC limit 10 )"

    const/4 v9, 0x0

    invoke-virtual {v1, v7, v8, v9}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 172
    .end local v6    # "values":Landroid/content/ContentValues;
    :goto_2
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catch Landroid/database/SQLException; {:try_start_1 .. :try_end_1} :catch_1

    .line 180
    :goto_3
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 181
    return-void

    .line 142
    .end local v0    # "counter":Landroid/database/Cursor;
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v3    # "updateColumn":Ljava/lang/String;
    .end local v4    # "userExists":Z
    :cond_2
    const-string/jumbo v3, "showedTimes"

    goto :goto_0

    .line 149
    .restart local v0    # "counter":Landroid/database/Cursor;
    .restart local v3    # "updateColumn":Ljava/lang/String;
    .restart local v4    # "userExists":Z
    :catch_0
    move-exception v2

    .line 150
    .local v2, "e":Ljava/lang/Exception;
    :try_start_2
    iget-object v7, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->mContext:Landroid/content/Context;

    invoke-static {v7, v2}, Lcom/amazon/mShop/util/AmazonErrorUtils;->postExceptionToServer(Landroid/content/Context;Ljava/lang/Exception;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 152
    if-eqz v0, :cond_1

    .line 153
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 152
    .end local v2    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v7

    if-eqz v0, :cond_3

    .line 153
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_3
    throw v7

    .line 169
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_4
    :try_start_3
    const-string/jumbo v7, "UPDATE %1$s SET %2$s=%2$s+1 WHERE %3$s=\'%4$s\'"

    const/4 v8, 0x4

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    const-string/jumbo v10, "primeUpsell"

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v3, v8, v9

    const/4 v9, 0x2

    const-string/jumbo v10, "usernameHash"

    aput-object v10, v8, v9

    const/4 v9, 0x3

    aput-object v5, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v7}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    :try_end_3
    .catch Landroid/database/SQLException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_2

    .line 173
    :catch_1
    move-exception v2

    .line 174
    .local v2, "e":Landroid/database/SQLException;
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v7

    if-eqz v7, :cond_5

    .line 175
    sget-object v7, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "showedPrimeTo user failed :"

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 176
    invoke-virtual {v2}, Landroid/database/SQLException;->printStackTrace()V

    .line 178
    :cond_5
    iget-object v7, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->mContext:Landroid/content/Context;

    invoke-static {v7, v2}, Lcom/amazon/mShop/util/AmazonErrorUtils;->postExceptionToServer(Landroid/content/Context;Ljava/lang/Exception;)V

    goto :goto_3
.end method
