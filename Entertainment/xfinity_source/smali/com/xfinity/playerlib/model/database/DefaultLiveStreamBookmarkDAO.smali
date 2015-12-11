.class public Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;
.super Ljava/lang/Object;
.source "DefaultLiveStreamBookmarkDAO.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private db:Landroid/database/sqlite/SQLiteDatabase;

.field private playNowDB:Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

.field private userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/database/PlayNowDatabase;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V
    .locals 1
    .param p1, "db"    # Lcom/xfinity/playerlib/model/database/PlayNowDatabase;
    .param p2, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .prologue
    .line 92
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 93
    iput-object p1, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->playNowDB:Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

    .line 94
    iput-object p2, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 95
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->playNowDB:Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/database/PlayNowDatabase;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    .line 96
    return-void
.end method

.method private getBookmarkWithId(Ljava/lang/Long;)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    .locals 7
    .param p1, "id"    # Ljava/lang/Long;

    .prologue
    .line 363
    const/4 v0, 0x0

    .line 364
    .local v0, "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    const/4 v1, 0x0

    .line 365
    .local v1, "cursor":Landroid/database/Cursor;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->playNowDB:Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/database/PlayNowDatabase;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 367
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    const-string v3, "SELECT * FROM live_stream_bookmark WHERE _id = ? AND user_key = ?;"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-virtual {p1}, Ljava/lang/Long;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->getUserKey()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 368
    if-eqz v1, :cond_0

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v3

    if-lez v3, :cond_0

    .line 369
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    .line 370
    new-instance v0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;

    .end local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    invoke-direct {v0, p0, v1}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;-><init>(Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;Landroid/database/Cursor;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 373
    .restart local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    :cond_0
    if-eqz v1, :cond_1

    .line 374
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 378
    :cond_1
    return-object v0

    .line 373
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    :catchall_0
    move-exception v3

    if-eqz v1, :cond_2

    .line 374
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v3
.end method

.method private getUserKey()Ljava/lang/String;
    .locals 2

    .prologue
    .line 354
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    .line 355
    .local v0, "user":Lcom/xfinity/playerlib/model/user/PlayNowUser;
    if-eqz v0, :cond_0

    .line 356
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getUserName()Ljava/lang/String;

    move-result-object v1

    .line 359
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p0, "database"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 104
    const-string v0, "CREATE TABLE live_stream_bookmark (_id INTEGER PRIMARY KEY AUTOINCREMENT, user_key TEXT NOT NULL, stream_id INTEGER, network_id INTEGER, is_favorite INTEGER, is_adult_content INTEGER, title TEXT, artwork_url TEXT, position INTEGER, duration INTEGER, expiration_date INTEGER, created INTEGER, timestamp INTEGER);"

    invoke-virtual {p0, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 105
    return-void
.end method

.method public static onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 1
    .param p0, "database"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "oldVersion"    # I
    .param p2, "newVersion"    # I

    .prologue
    .line 108
    const/4 v0, 0x2

    if-ge p1, v0, :cond_0

    .line 109
    invoke-static {p0}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 111
    :cond_0
    return-void
.end method


# virtual methods
.method public addFavorite(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    .locals 3
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    const/4 v2, 0x0

    .line 308
    invoke-virtual {p0, p1, v2}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->getOrCreateBookmarkWithLiveStream(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Z)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    move-result-object v0

    .line 309
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    if-eqz v0, :cond_0

    .line 310
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->setCreatedTime(Ljava/util/Date;)V

    .line 311
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->setIsFavorite(Z)V

    .line 312
    invoke-virtual {p0, v0, v2}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->saveBookmark(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;Z)Z

    .line 315
    :cond_0
    return-object v0
.end method

.method public deleteBookmark(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)Z
    .locals 8
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .prologue
    .line 273
    instance-of v4, p1, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;

    if-nez v4, :cond_0

    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Bookmark not an instance of SQLiteBookmark"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    :cond_0
    move-object v0, p1

    .line 275
    check-cast v0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;

    .line 277
    .local v0, "bm":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->getDbId()J

    move-result-wide v4

    const-wide/16 v6, -0x1

    cmp-long v4, v4, v6

    if-nez v4, :cond_1

    new-instance v4, Landroid/database/sqlite/SQLiteException;

    const-string v5, "Bookmark has no SQLite ID (It\'s not in the database)"

    invoke-direct {v4, v5}, Landroid/database/sqlite/SQLiteException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 280
    :cond_1
    iget-object v4, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->playNowDB:Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/database/PlayNowDatabase;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 282
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v4, "live_stream_bookmark"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "_id="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->getDbId()J

    move-result-wide v6

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v1, v4, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    .line 284
    .local v2, "rows":I
    if-gtz v2, :cond_2

    .line 285
    new-instance v4, Landroid/database/sqlite/SQLiteException;

    const-string v5, "Could not delete any rows from the database"

    invoke-direct {v4, v5}, Landroid/database/sqlite/SQLiteException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 287
    :cond_2
    const/4 v3, 0x1

    .line 290
    .local v3, "success":Z
    return v3
.end method

.method public deleteFavorite(Ljava/lang/String;)Z
    .locals 4
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 320
    const/4 v1, 0x0

    .line 321
    .local v1, "success":Z
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->getBookmarkByStreamId(Ljava/lang/String;)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    move-result-object v0

    .line 322
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    if-eqz v0, :cond_0

    .line 323
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getTimestamp()Ljava/util/Date;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 324
    invoke-virtual {v0, v3}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->setIsFavorite(Z)V

    .line 325
    invoke-virtual {p0, v0, v3}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->saveBookmark(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;Z)Z

    move-result v1

    .line 331
    :cond_0
    :goto_0
    return v1

    .line 327
    :cond_1
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->deleteBookmark(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)Z

    move-result v1

    goto :goto_0
.end method

.method public finalize()V
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 101
    return-void
.end method

.method public getBookmarkByStreamId(Ljava/lang/String;)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    .locals 7
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 174
    const/4 v0, 0x0

    .line 175
    .local v0, "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    const/4 v1, 0x0

    .line 177
    .local v1, "cursor":Landroid/database/Cursor;
    :try_start_0
    iget-object v2, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "SELECT * FROM live_stream_bookmark WHERE stream_id = ? AND user_key = ?;"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const/4 v5, 0x1

    .line 179
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->getUserKey()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    .line 177
    invoke-virtual {v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 180
    if-eqz v1, :cond_0

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-lez v2, :cond_0

    .line 181
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    .line 182
    new-instance v0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;

    .end local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    invoke-direct {v0, p0, v1}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;-><init>(Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;Landroid/database/Cursor;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 185
    .restart local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    :cond_0
    if-eqz v1, :cond_1

    .line 186
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 190
    :cond_1
    return-object v0

    .line 185
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    :catchall_0
    move-exception v2

    if-eqz v1, :cond_2

    .line 186
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v2
.end method

.method public getBookmarks()Ljava/util/Map;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 135
    const/4 v2, 0x0

    .line 136
    .local v2, "cursor":Landroid/database/Cursor;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 138
    .local v1, "bookmarks":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;>;"
    :try_start_0
    iget-object v3, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "SELECT * FROM live_stream_bookmark WHERE user_key = ?;"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->getUserKey()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 139
    :goto_0
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 140
    new-instance v0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;

    invoke-direct {v0, p0, v2}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;-><init>(Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;Landroid/database/Cursor;)V

    .line 141
    .local v0, "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 144
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    :catchall_0
    move-exception v3

    if-eqz v2, :cond_0

    .line 145
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    :cond_0
    throw v3

    .line 144
    :cond_1
    if-eqz v2, :cond_2

    .line 145
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 149
    :cond_2
    return-object v1
.end method

.method public getFavorites()Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 336
    const/4 v2, 0x0

    .line 337
    .local v2, "cursor":Landroid/database/Cursor;
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 339
    .local v1, "bookmarks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;>;"
    :try_start_0
    iget-object v3, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "SELECT * FROM live_stream_bookmark WHERE is_favorite = ? AND user_key = ?;"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    const-string v7, "1"

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->getUserKey()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 340
    :goto_0
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 341
    new-instance v0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;

    invoke-direct {v0, p0, v2}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;-><init>(Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;Landroid/database/Cursor;)V

    .line 342
    .local v0, "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 345
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    :catchall_0
    move-exception v3

    if-eqz v2, :cond_0

    .line 346
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    :cond_0
    throw v3

    .line 345
    :cond_1
    if-eqz v2, :cond_2

    .line 346
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 350
    :cond_2
    return-object v1
.end method

.method public getLastWatchedBookmark()Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    .locals 9

    .prologue
    .line 115
    const/4 v3, 0x0

    .line 116
    .local v3, "lastWatched":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    const/4 v2, 0x0

    .line 118
    .local v2, "cursor":Landroid/database/Cursor;
    :try_start_0
    iget-object v4, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "SELECT * FROM live_stream_bookmark WHERE timestamp IS NOT NULL AND user_key = ? ORDER BY timestamp DESC LIMIT 1"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->getUserKey()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v4, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 119
    if-eqz v2, :cond_0

    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v4

    if-lez v4, :cond_0

    .line 120
    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    .line 121
    const-string v4, "_id"

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    .line 122
    .local v0, "bookmarkId":J
    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->getBookmarkWithId(Ljava/lang/Long;)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v3

    .line 125
    .end local v0    # "bookmarkId":J
    :cond_0
    if-eqz v2, :cond_1

    .line 126
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 130
    :cond_1
    return-object v3

    .line 125
    :catchall_0
    move-exception v4

    if-eqz v2, :cond_2

    .line 126
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v4
.end method

.method public getOrCreateBookmarkWithLiveStream(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Z)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    .locals 4
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .param p2, "asRecent"    # Z

    .prologue
    .line 195
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->getBookmarkByStreamId(Ljava/lang/String;)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;

    .line 197
    .local v0, "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    if-nez v0, :cond_0

    .line 199
    new-instance v0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;

    .end local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    invoke-direct {v0, p0, p1}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;-><init>(Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V

    .line 200
    .restart local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    invoke-virtual {p0, v0, p2}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->saveBookmark(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;Z)Z

    move-result v1

    .line 201
    .local v1, "success":Z
    sget-object v2, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Successfully upgraded legacy bookmark"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->info(Ljava/lang/String;)V

    .line 206
    :goto_0
    if-eqz v1, :cond_1

    .end local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    :goto_1
    return-object v0

    .line 203
    .end local v1    # "success":Z
    .restart local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    :cond_0
    invoke-virtual {p0, v0, p2}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->saveBookmark(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;Z)Z

    move-result v1

    .restart local v1    # "success":Z
    goto :goto_0

    .line 206
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public getRecentBookmarks()Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 155
    const/4 v2, 0x0

    .line 156
    .local v2, "cursor":Landroid/database/Cursor;
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 158
    .local v1, "bookmarks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;>;"
    :try_start_0
    iget-object v3, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "SELECT * FROM live_stream_bookmark WHERE timestamp IS NOT NULL AND user_key = ?;"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->getUserKey()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 159
    :goto_0
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 160
    new-instance v0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;

    invoke-direct {v0, p0, v2}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;-><init>(Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;Landroid/database/Cursor;)V

    .line 161
    .local v0, "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 164
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    :catchall_0
    move-exception v3

    if-eqz v2, :cond_0

    .line 165
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    :cond_0
    throw v3

    .line 164
    :cond_1
    if-eqz v2, :cond_2

    .line 165
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 169
    :cond_2
    return-object v1
.end method

.method public removeHistoryItem(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)Z
    .locals 2
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .prologue
    .line 296
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->isFavorite()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 297
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->setTimestamp(Ljava/util/Date;)V

    .line 298
    const/4 v1, 0x0

    invoke-virtual {p0, p1, v1}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->saveBookmark(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;Z)Z

    move-result v0

    .line 303
    .local v0, "success":Z
    :goto_0
    return v0

    .line 300
    .end local v0    # "success":Z
    :cond_0
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->deleteBookmark(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)Z

    move-result v0

    .restart local v0    # "success":Z
    goto :goto_0
.end method

.method public saveBookmark(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;Z)Z
    .locals 13
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    .param p2, "updateTimeStamp"    # Z

    .prologue
    .line 211
    instance-of v5, p1, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;

    if-nez v5, :cond_0

    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v8, "Bookmark not an instance of SQLiteBookmark"

    invoke-direct {v5, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 213
    :cond_0
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 214
    .local v2, "cv":Landroid/content/ContentValues;
    const-string v5, "user_key"

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->getUserKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v2, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 215
    const-string v5, "stream_id"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v2, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 216
    const-string v5, "network_id"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getCompanyId()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v2, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 217
    const-string v5, "title"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getTitle()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v2, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 218
    const-string v5, "artwork_url"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getArtworkUrl()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v2, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 219
    const-string v5, "position"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getPosition()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v2, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 220
    const-string v5, "duration"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getDuration()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v2, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 221
    const-string v8, "is_favorite"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->isFavorite()Z

    move-result v5

    if-eqz v5, :cond_2

    const/4 v5, 0x1

    :goto_0
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v2, v8, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 222
    const-string v8, "is_adult_content"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->isAdultContent()Z

    move-result v5

    if-eqz v5, :cond_3

    const/4 v5, 0x1

    :goto_1
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v2, v8, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 224
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getExpirationDate()Ljava/util/Date;

    move-result-object v3

    .line 225
    .local v3, "expDate":Ljava/util/Date;
    if-eqz v3, :cond_4

    .line 226
    const-string v5, "expiration_date"

    invoke-virtual {v3}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v2, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 231
    :goto_2
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getCreatedTime()Ljava/util/Date;

    move-result-object v1

    .line 232
    .local v1, "created":Ljava/util/Date;
    if-eqz v1, :cond_5

    .line 233
    const-string v5, "created"

    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v2, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 238
    :goto_3
    if-eqz p2, :cond_6

    .line 239
    const-string v5, "timestamp"

    new-instance v8, Ljava/util/Date;

    invoke-direct {v8}, Ljava/util/Date;-><init>()V

    invoke-virtual {v8}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v2, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    :cond_1
    :goto_4
    move-object v0, p1

    .line 244
    check-cast v0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;

    .line 245
    .local v0, "bm":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->getDbId()J

    move-result-wide v8

    const-wide/16 v10, -0x1

    cmp-long v5, v8, v10

    if-eqz v5, :cond_8

    .line 246
    iget-object v5, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v8, "live_stream_bookmark"

    const-string v9, "stream_id = ?"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/String;

    const/4 v11, 0x0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-virtual {v5, v8, v2, v9, v10}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v4

    .line 247
    .local v4, "numRows":I
    const/4 v5, 0x1

    if-ne v4, v5, :cond_7

    .line 248
    const/4 v5, 0x1

    .line 260
    .end local v4    # "numRows":I
    .end local p1    # "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :goto_5
    return v5

    .line 221
    .end local v0    # "bm":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    .end local v1    # "created":Ljava/util/Date;
    .end local v3    # "expDate":Ljava/util/Date;
    .restart local p1    # "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :cond_2
    const/4 v5, 0x0

    goto :goto_0

    .line 222
    :cond_3
    const/4 v5, 0x0

    goto :goto_1

    .line 228
    .restart local v3    # "expDate":Ljava/util/Date;
    :cond_4
    const-string v5, "expiration_date"

    invoke-virtual {v2, v5}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    goto :goto_2

    .line 235
    .restart local v1    # "created":Ljava/util/Date;
    :cond_5
    const-string v5, "created"

    new-instance v8, Ljava/util/Date;

    invoke-direct {v8}, Ljava/util/Date;-><init>()V

    invoke-virtual {v8}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v2, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    goto :goto_3

    .line 240
    :cond_6
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getTimestamp()Ljava/util/Date;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 241
    const-string v5, "timestamp"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getTimestamp()Ljava/util/Date;

    move-result-object v8

    invoke-virtual {v8}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v2, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    goto :goto_4

    .line 250
    .restart local v0    # "bm":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
    .restart local v4    # "numRows":I
    :cond_7
    const/4 v5, 0x0

    goto :goto_5

    .line 253
    .end local v4    # "numRows":I
    :cond_8
    iget-object v5, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v8, "live_stream_bookmark"

    const/4 v9, 0x0

    invoke-virtual {v5, v8, v9, v2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v6

    .line 255
    .local v6, "row":J
    const-wide/16 v8, -0x1

    cmp-long v5, v6, v8

    if-eqz v5, :cond_9

    move-object v5, p1

    .line 256
    check-cast v5, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;

    invoke-virtual {v5, v6, v7}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->setDbId(J)V

    .line 257
    check-cast p1, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;

    .end local p1    # "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->getUserKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1, v5}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->setUserKey(Ljava/lang/String;)V

    .line 258
    const/4 v5, 0x1

    goto :goto_5

    .line 260
    .restart local p1    # "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :cond_9
    const/4 v5, 0x0

    goto :goto_5
.end method
