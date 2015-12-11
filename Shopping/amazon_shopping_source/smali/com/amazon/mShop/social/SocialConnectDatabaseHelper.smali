.class public Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;
.super Lcom/amazon/mShop/util/DatabaseHelper;
.source "SocialConnectDatabaseHelper.java"


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sInstance:Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->TAG:Ljava/lang/String;

    .line 35
    new-instance v0, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;

    invoke-direct {v0}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;-><init>()V

    sput-object v0, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->sInstance:Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;

    return-void
.end method

.method private constructor <init>()V
    .locals 3

    .prologue
    .line 38
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    const-string/jumbo v1, "social.db"

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/mShop/util/DatabaseHelper;-><init>(Landroid/content/Context;Ljava/lang/String;I)V

    .line 39
    return-void
.end method

.method public static getInstance()Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;
    .locals 1

    .prologue
    .line 256
    sget-object v0, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->sInstance:Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;

    return-object v0
.end method

.method private getSecureId(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "currentAccount"    # Ljava/lang/String;

    .prologue
    .line 260
    new-instance v0, Ljava/lang/String;

    invoke-static {p1}, Lorg/apache/commons/codec/digest/DigestUtils;->md5(Ljava/lang/String;)[B

    move-result-object v1

    invoke-static {v1}, Lorg/apache/commons/codec/binary/Hex;->encodeHex([B)[C

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>([C)V

    return-object v0
.end method

.method private getSocialCursorInfo(Ljava/lang/String;)Landroid/database/Cursor;
    .locals 9
    .param p1, "currentAccount"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    const/4 v5, 0x0

    .line 141
    invoke-virtual {p0}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 144
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-direct {p0, p1}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getSecureId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 145
    .local v8, "userId":Ljava/lang/String;
    const/4 v1, 0x3

    new-array v2, v1, [Ljava/lang/String;

    const-string/jumbo v1, "showedTimes"

    aput-object v1, v2, v6

    const-string/jumbo v1, "lastShown"

    aput-object v1, v2, v7

    const/4 v1, 0x2

    const-string/jumbo v3, "doNotShowAgain"

    aput-object v3, v2, v1

    .line 146
    .local v2, "columns":[Ljava/lang/String;
    new-array v4, v7, [Ljava/lang/String;

    aput-object v8, v4, v6

    .line 147
    .local v4, "selectionArgs":[Ljava/lang/String;
    const-string/jumbo v1, "socialConnect"

    const-string/jumbo v3, "currentAccountHash =? "

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method public clearDatabase()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 266
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 267
    invoke-virtual {p0}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 268
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string/jumbo v1, "socialConnect"

    invoke-virtual {v0, v1, v2, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 270
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_0
    return-void
.end method

.method public getDoNotShowAgain(Ljava/lang/String;)Z
    .locals 4
    .param p1, "currentAccount"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 100
    invoke-direct {p0, p1}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getSocialCursorInfo(Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 101
    .local v0, "cursor":Landroid/database/Cursor;
    const/4 v1, 0x0

    .line 102
    .local v1, "doNotShowAgain":I
    if-eqz v0, :cond_1

    .line 104
    :try_start_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 105
    const-string/jumbo v3, "doNotShowAgain"

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getInt(I)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    .line 108
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 111
    :cond_1
    if-ne v1, v2, :cond_2

    :goto_0
    return v2

    .line 108
    :catchall_0
    move-exception v2

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    throw v2

    .line 111
    :cond_2
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public getLastShown(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "currentAccount"    # Ljava/lang/String;

    .prologue
    .line 81
    invoke-direct {p0, p1}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getSocialCursorInfo(Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 82
    .local v0, "cursor":Landroid/database/Cursor;
    const-string/jumbo v1, "never"

    .line 83
    .local v1, "lastShown":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 85
    :try_start_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 86
    const-string/jumbo v2, "lastShown"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 89
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 92
    :cond_1
    return-object v1

    .line 89
    :catchall_0
    move-exception v2

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    throw v2
.end method

.method public getNumberTimesShown(Ljava/lang/String;)I
    .locals 3
    .param p1, "currentAccount"    # Ljava/lang/String;

    .prologue
    .line 120
    invoke-direct {p0, p1}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getSocialCursorInfo(Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 121
    .local v0, "cursor":Landroid/database/Cursor;
    const/4 v1, 0x0

    .line 122
    .local v1, "showedTimes":I
    if-eqz v0, :cond_1

    .line 124
    :try_start_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 125
    const-string/jumbo v2, "showedTimes"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getInt(I)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    .line 128
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 131
    :cond_1
    return v1

    .line 128
    :catchall_0
    move-exception v2

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    throw v2
.end method

.method public increaseDisplayCounter(Ljava/lang/String;)V
    .locals 10
    .param p1, "currentAccount"    # Ljava/lang/String;

    .prologue
    .line 213
    invoke-direct {p0, p1}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getSecureId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 214
    .local v4, "userId":Ljava/lang/String;
    invoke-direct {p0, p1}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getSocialCursorInfo(Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 215
    .local v0, "cursor":Landroid/database/Cursor;
    const/4 v3, 0x0

    .line 217
    .local v3, "userExists":Z
    if-eqz v0, :cond_0

    :try_start_0
    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v6

    if-lez v6, :cond_0

    .line 218
    const/4 v3, 0x1

    .line 223
    :cond_0
    if-eqz v0, :cond_1

    .line 224
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 228
    :cond_1
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 229
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 231
    if-nez v3, :cond_3

    .line 232
    :try_start_1
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    .line 233
    .local v5, "values":Landroid/content/ContentValues;
    const-string/jumbo v6, "currentAccountHash"

    invoke-virtual {v5, v6, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 234
    const-string/jumbo v6, "showedTimes"

    const/4 v7, 0x1

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 235
    const-string/jumbo v6, "socialConnect"

    const/4 v7, 0x0

    invoke-virtual {v1, v6, v7, v5}, Landroid/database/sqlite/SQLiteDatabase;->insertOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 237
    const-string/jumbo v6, "socialConnect"

    const-string/jumbo v7, "id NOT IN (SELECT id FROM socialConnect ORDER BY id DESC limit 10 )"

    const/4 v8, 0x0

    invoke-virtual {v1, v6, v7, v8}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 243
    .end local v5    # "values":Landroid/content/ContentValues;
    :goto_1
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catch Landroid/database/SQLException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 251
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 253
    :goto_2
    return-void

    .line 220
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catch_0
    move-exception v2

    .line 221
    .local v2, "e":Ljava/lang/Exception;
    :try_start_2
    iget-object v6, p0, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->mContext:Landroid/content/Context;

    invoke-static {v6, v2}, Lcom/amazon/mShop/util/AmazonErrorUtils;->postExceptionToServer(Landroid/content/Context;Ljava/lang/Exception;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 223
    if-eqz v0, :cond_1

    .line 224
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 223
    .end local v2    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v6

    if-eqz v0, :cond_2

    .line 224
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v6

    .line 240
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_3
    :try_start_3
    const-string/jumbo v6, "UPDATE %1$s SET %2$s=%2$s+1 WHERE %3$s=\'%4$s\'"

    const/4 v7, 0x4

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    const-string/jumbo v9, "socialConnect"

    aput-object v9, v7, v8

    const/4 v8, 0x1

    const-string/jumbo v9, "showedTimes"

    aput-object v9, v7, v8

    const/4 v8, 0x2

    const-string/jumbo v9, "currentAccountHash"

    aput-object v9, v7, v8

    const/4 v8, 0x3

    aput-object v4, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    :try_end_3
    .catch Landroid/database/SQLException; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_1

    .line 244
    :catch_1
    move-exception v2

    .line 245
    .local v2, "e":Landroid/database/SQLException;
    :try_start_4
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v6

    if-eqz v6, :cond_4

    .line 246
    sget-object v6, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "incrementDisplayCounter user failed :"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 247
    invoke-virtual {v2}, Landroid/database/SQLException;->printStackTrace()V

    .line 249
    :cond_4
    iget-object v6, p0, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->mContext:Landroid/content/Context;

    invoke-static {v6, v2}, Lcom/amazon/mShop/util/AmazonErrorUtils;->postExceptionToServer(Landroid/content/Context;Ljava/lang/Exception;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 251
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    goto :goto_2

    .end local v2    # "e":Landroid/database/SQLException;
    :catchall_1
    move-exception v6

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v6
.end method

.method public markDoNotShowAgain(Ljava/lang/String;)V
    .locals 7
    .param p1, "currentAccount"    # Ljava/lang/String;

    .prologue
    .line 168
    invoke-virtual {p0}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 169
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-direct {p0, p1}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getSecureId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 171
    .local v2, "userId":Ljava/lang/String;
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 173
    :try_start_0
    const-string/jumbo v3, "UPDATE %1$s SET %2$s=%3$d WHERE %4$s=\'%5$s\'"

    const/4 v4, 0x5

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string/jumbo v6, "socialConnect"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const-string/jumbo v6, "doNotShowAgain"

    aput-object v6, v4, v5

    const/4 v5, 0x2

    const/4 v6, 0x1

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x3

    const-string/jumbo v6, "currentAccountHash"

    aput-object v6, v4, v5

    const/4 v5, 0x4

    aput-object v2, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 175
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 184
    :goto_0
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 185
    return-void

    .line 177
    :catch_0
    move-exception v1

    .line 178
    .local v1, "e":Landroid/database/SQLException;
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 179
    sget-object v3, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "markDoNotShowAgain user failed :"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 180
    invoke-virtual {v1}, Landroid/database/SQLException;->printStackTrace()V

    .line 182
    :cond_0
    iget-object v3, p0, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->mContext:Landroid/content/Context;

    invoke-static {v3, v1}, Lcom/amazon/mShop/util/AmazonErrorUtils;->postExceptionToServer(Landroid/content/Context;Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 3
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 43
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "CREATE TABLE socialConnect(id INTEGER PRIMARY KEY AUTOINCREMENT "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 44
    .local v0, "sb":Ljava/lang/StringBuilder;
    const-string/jumbo v1, ", currentAccountHash TEXT UNIQUE "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", showedTimes INTEGER DEFAULT 0 "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", lastShown TEXT "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", doNotShowAgain INTEGER DEFAULT 0 "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 50
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 51
    return-void
.end method

.method public onDowngrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 4
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 60
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 61
    sget-object v1, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->TAG:Ljava/lang/String;

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

    .line 66
    :cond_0
    :try_start_0
    const-string/jumbo v1, "DROP TABLE IF EXISTS socialConnect"

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 68
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 73
    :goto_0
    return-void

    .line 70
    :catch_0
    move-exception v0

    .line 71
    .local v0, "e":Landroid/database/SQLException;
    sget-object v1, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->TAG:Ljava/lang/String;

    invoke-virtual {v0}, Landroid/database/SQLException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 0
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 56
    return-void
.end method

.method public recordInteraction(Ljava/lang/String;JZ)V
    .locals 0
    .param p1, "currentAccount"    # Ljava/lang/String;
    .param p2, "lastShownMs"    # J
    .param p4, "doNotShowAgain"    # Z

    .prologue
    .line 159
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->increaseDisplayCounter(Ljava/lang/String;)V

    .line 160
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->updateLastShown(Ljava/lang/String;J)V

    .line 162
    if-eqz p4, :cond_0

    .line 163
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->markDoNotShowAgain(Ljava/lang/String;)V

    .line 165
    :cond_0
    return-void
.end method

.method public updateLastShown(Ljava/lang/String;J)V
    .locals 7
    .param p1, "currentAccount"    # Ljava/lang/String;
    .param p2, "lastShownMs"    # J

    .prologue
    .line 188
    invoke-virtual {p0}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 189
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-direct {p0, p1}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getSecureId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 191
    .local v2, "userId":Ljava/lang/String;
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 193
    :try_start_0
    const-string/jumbo v3, "UPDATE %1$s SET %2$s=%3$d WHERE %4$s=\'%5$s\'"

    const/4 v4, 0x5

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string/jumbo v6, "socialConnect"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const-string/jumbo v6, "lastShown"

    aput-object v6, v4, v5

    const/4 v5, 0x2

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x3

    const-string/jumbo v6, "currentAccountHash"

    aput-object v6, v4, v5

    const/4 v5, 0x4

    aput-object v2, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 195
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 204
    :goto_0
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 205
    return-void

    .line 197
    :catch_0
    move-exception v1

    .line 198
    .local v1, "e":Landroid/database/SQLException;
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 199
    sget-object v3, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "updateLastShown user failed :"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 200
    invoke-virtual {v1}, Landroid/database/SQLException;->printStackTrace()V

    .line 202
    :cond_0
    iget-object v3, p0, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->mContext:Landroid/content/Context;

    invoke-static {v3, v1}, Lcom/amazon/mShop/util/AmazonErrorUtils;->postExceptionToServer(Landroid/content/Context;Ljava/lang/Exception;)V

    goto :goto_0
.end method
