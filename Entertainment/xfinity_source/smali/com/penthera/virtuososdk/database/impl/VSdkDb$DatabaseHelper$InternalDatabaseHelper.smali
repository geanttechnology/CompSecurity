.class Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "VSdkDb.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "InternalDatabaseHelper"
.end annotation


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 201
    const-string v0, "virtuososdk.db"

    new-instance v1, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKCursorFactory;

    invoke-direct {v1}, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKCursorFactory;-><init>()V

    const/16 v2, 0x9

    invoke-direct {p0, p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 202
    return-void
.end method

.method private createFragmentTable(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 327
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Creating fragment table"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 329
    const-string v0, "CREATE TABLE fragment (_id INTEGER PRIMARY KEY AUTOINCREMENT, parentUuid TEXT, assetUrl TEXT, expectedSize INTEGER, currentSize INTEGER, filePath TEXT, errorType INTEGER, creationTime INTEGER, modifyTime INTEGER, completeTime INTEGER, pending BOOLEAN DEFAULT 1 );"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 342
    return-void
.end method

.method private createProviderTable(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 319
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Creating Provider table"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 320
    const-string v0, "CREATE TABLE providers (_id INTEGER PRIMARY KEY AUTOINCREMENT, provider TEXT UNIQUE NOT NULL );"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 324
    return-void
.end method


# virtual methods
.method createCatalogTable(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 385
    const-string v0, "CREATE TABLE catalog (_id TEXT PRIMARY KEY, accessWindow INTEGER DEFAULT 0, contentRating TEXT, userRating INTEGER DEFAULT 1, catalogExpiry INTEGER DEFAULT 0, completeTime INTEGER DEFAULT 0, creationTime INTEGER DEFAULT 0, modifyTime INTEGER DEFAULT 0, desc TEXT, downloadEnabled BOOLEAN DEFAULT 1, downloadExpiry INTEGER DEFAULT 0, duration INTEGER DEFAULT 0, expiryDate INTEGER DEFAULT 0, genre TEXT, featured BOOLEAN DEFAULT 0, title TEXT, type INTEGER DEFAULT 0, popular BOOLEAN DEFAULT 0, contentUrl TEXT, contentSize INTEGER DEFAULT 0, thumbnail TEXT, image TEXT, category TEXT, parent TEXT, streamUrl TEXT, viewedTime INTEGER DEFAULT 0, filePath TEXT, errorType INTEGER DEFAULT -1, fileUuid TEXT, network TEXT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 447
    return-void
.end method

.method createFileTable(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 345
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Creating file table"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 346
    const-string v0, "CREATE TABLE file (_id INTEGER PRIMARY KEY AUTOINCREMENT, uuid TEXT UNIQUE, parentUuid TEXT, assetUrl TEXT, description TEXT, expectedSize INTEGER, currentSize INTEGER, filePath TEXT, errorType INTEGER, assetId TEXT, mimeType TEXT, fileHash TEXT, errorCount INTEGER, creationTime INTEGER, modifyTime INTEGER, completeTime INTEGER, pending BOOLEAN DEFAULT 1, addedToQueue BOOLEAN DEFAULT 0, clientAuthority TEXT, hlsFragmentCompletedCount INTEGER DEFAULT 0, hlsFragmentCount INTEGER DEFAULT 0, contentType INTEGER, contentState INTEGER DEFAULT 0, hashState BLOB );"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 372
    return-void
.end method

.method createNetworkTable(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 450
    const-string v0, "CREATE TABLE network (_id TEXT PRIMARY KEY, network_name TEXT, network_image_url TEXT, network_image_thumbnail_url TEXT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 461
    return-void
.end method

.method createRegistryTable(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 376
    const-string v0, "CREATE TABLE registry (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT UNIQUE, value TEXT );"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 382
    return-void
.end method

.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 206
    const/4 v0, 0x0

    const/16 v1, 0x9

    invoke-virtual {p0, p1, v0, v1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;->performRecUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)I

    .line 207
    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 3
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 211
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$0()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Upgrading database from version "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " to "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 212
    invoke-virtual {p0, p1, p2, p3}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;->performRecUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)I

    .line 213
    return-void
.end method

.method performRecUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)I
    .locals 6
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    const/16 v3, 0x270f

    const/4 v5, 0x0

    .line 217
    if-eq p3, v3, :cond_0

    if-ne p2, v3, :cond_2

    .line 218
    :cond_0
    const-string v3, "DROP TABLE IF EXISTS file"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 219
    const-string v3, "DROP TABLE IF EXISTS registry"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 220
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    move p2, p3

    .line 315
    .end local p2    # "oldVersion":I
    :cond_1
    :goto_0
    return p2

    .line 225
    .restart local p2    # "oldVersion":I
    :cond_2
    if-le p2, p3, :cond_3

    .line 226
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "Invalid Upgrade - Old version cannot be greater than the new version"

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 228
    :cond_3
    if-eq p2, p3, :cond_1

    .line 229
    move v2, p2

    .line 231
    .local v2, "upgradedVersion":I
    packed-switch v2, :pswitch_data_0

    .line 313
    :goto_1
    invoke-virtual {p0, p1, v2, p3}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;->performRecUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)I

    move-result p2

    goto :goto_0

    .line 235
    :pswitch_0
    const-string v3, "DROP TABLE IF EXISTS file"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 236
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;->createFileTable(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 237
    const-string v3, "DROP TABLE IF EXISTS registry"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 238
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;->createRegistryTable(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 241
    const-string v3, "DROP TABLE IF EXISTS fragment"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 242
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;->createFragmentTable(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 243
    const-string v3, "DROP TABLE IF EXISTS catalog"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 244
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;->createCatalogTable(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 245
    const-string v3, "DROP TABLE IF EXISTS providers"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 246
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;->createProviderTable(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 247
    const-string v3, "DROP TABLE IF EXISTS network"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 248
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;->createNetworkTable(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 249
    const/16 v2, 0x9

    .line 250
    goto :goto_1

    .line 253
    :pswitch_1
    const-string v3, "ALTER TABLE file ADD addedToQueue BOOLEAN DEFAULT 0"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 254
    const-string v3, "ALTER TABLE file ADD contentType INTEGER"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 255
    const-string v3, "ALTER TABLE file ADD parentUuid TEXT"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 256
    const-string v3, "ALTER TABLE file ADD completeTime INTEGER"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 258
    const/4 v0, 0x0

    .line 260
    .local v0, "c":Landroid/database/Cursor;
    :try_start_0
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 261
    .local v1, "cv":Landroid/content/ContentValues;
    const-string v3, "contentType"

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 262
    const-string v3, "file"

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {p1, v3, v1, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 264
    if-eqz v0, :cond_4

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v3

    if-nez v3, :cond_4

    .line 265
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 269
    :cond_4
    const-string v3, "DROP TABLE IF EXISTS fragment"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 270
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;->createFragmentTable(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 271
    const/4 v2, 0x4

    .line 272
    goto :goto_1

    .line 263
    .end local v1    # "cv":Landroid/content/ContentValues;
    :catchall_0
    move-exception v3

    .line 264
    if-eqz v0, :cond_5

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v4

    if-nez v4, :cond_5

    .line 265
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 266
    :cond_5
    throw v3

    .line 274
    .end local v0    # "c":Landroid/database/Cursor;
    :pswitch_2
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;->createProviderTable(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 277
    const-string v3, "ALTER TABLE file ADD clientAuthority TEXT"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 279
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 280
    .restart local v1    # "cv":Landroid/content/ContentValues;
    const-string v3, "clientAuthority"

    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iAuthority:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$1()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 281
    const-string v3, "file"

    invoke-virtual {p1, v3, v1, v5, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 282
    const/4 v2, 0x5

    .line 283
    goto/16 :goto_1

    .line 285
    .end local v1    # "cv":Landroid/content/ContentValues;
    :pswitch_3
    const-string v3, "DROP TABLE IF EXISTS catalog"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 286
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;->createCatalogTable(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 287
    const/4 v2, 0x6

    .line 288
    goto/16 :goto_1

    .line 291
    :pswitch_4
    const-string v3, "DROP TABLE IF EXISTS event"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 292
    const-string v3, "DROP TABLE IF EXISTS network"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 293
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;->createNetworkTable(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 294
    const/4 v2, 0x7

    .line 297
    :pswitch_5
    const-string v3, "ALTER TABLE file ADD hlsFragmentCompletedCount INTEGER DEFAULT 0"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 298
    const-string v3, "ALTER TABLE file ADD hlsFragmentCount INTEGER DEFAULT 0"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 299
    const/16 v2, 0x8

    .line 300
    goto/16 :goto_1

    .line 304
    :pswitch_6
    const-string v3, "ALTER TABLE file ADD contentState INTEGER DEFAULT 0"

    invoke-virtual {p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 305
    const/16 v2, 0x9

    .line 306
    goto/16 :goto_1

    .line 309
    :pswitch_7
    const/16 v2, 0x9

    goto/16 :goto_1

    .line 231
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method
