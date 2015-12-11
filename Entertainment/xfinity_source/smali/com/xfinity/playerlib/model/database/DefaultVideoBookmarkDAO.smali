.class public Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;
.super Ljava/lang/Object;
.source "DefaultVideoBookmarkDAO.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private db:Landroid/database/sqlite/SQLiteDatabase;

.field private playNowDB:Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

.field private userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

.field private videoTracker:Lcom/xfinity/playerlib/view/videoplay/VideoTracker;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/database/PlayNowDatabase;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Lcom/xfinity/playerlib/view/videoplay/VideoTracker;)V
    .locals 1
    .param p1, "db"    # Lcom/xfinity/playerlib/model/database/PlayNowDatabase;
    .param p2, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .param p3, "videoTracker"    # Lcom/xfinity/playerlib/view/videoplay/VideoTracker;

    .prologue
    .line 116
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 117
    iput-object p1, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->playNowDB:Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

    .line 118
    iput-object p2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 119
    iput-object p3, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->videoTracker:Lcom/xfinity/playerlib/view/videoplay/VideoTracker;

    .line 120
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->playNowDB:Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/database/PlayNowDatabase;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    .line 121
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;Ljava/lang/Long;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;
    .param p1, "x1"    # Ljava/lang/Long;

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->getCategoriesForBookmark(Ljava/lang/Long;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;)Lcom/xfinity/playerlib/view/videoplay/VideoTracker;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->videoTracker:Lcom/xfinity/playerlib/view/videoplay/VideoTracker;

    return-object v0
.end method

.method private getBookmarkByBookmarkId(Lcom/xfinity/playerlib/bookmarks/BookmarkId;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .locals 8
    .param p1, "bookmarkId"    # Lcom/xfinity/playerlib/bookmarks/BookmarkId;

    .prologue
    .line 218
    const/4 v0, 0x0

    .line 219
    .local v0, "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    const/4 v1, 0x0

    .line 221
    .local v1, "cursor":Landroid/database/Cursor;
    :try_start_0
    iget-object v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "SELECT * FROM bookmark WHERE merlin_id = ? AND video_id = ? AND ( company_id = ? OR network_id = ? ) AND user_key = ? ORDER BY timestamp DESC LIMIT 1"

    const/4 v4, 0x5

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    .line 223
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->getProgramId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v6

    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/MerlinId;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    .line 224
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->getVideoId()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    .line 225
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->getCompanyId()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x3

    .line 226
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->getNetworkId()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x4

    .line 227
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->getUserKey()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    .line 221
    invoke-virtual {v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 228
    if-eqz v1, :cond_0

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-lez v2, :cond_0

    .line 229
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    .line 230
    new-instance v0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;

    .end local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    invoke-direct {v0, p0, v1}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;-><init>(Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;Landroid/database/Cursor;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 233
    .restart local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    :cond_0
    if-eqz v1, :cond_1

    .line 234
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 238
    :cond_1
    return-object v0

    .line 233
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    :catchall_0
    move-exception v2

    if-eqz v1, :cond_2

    .line 234
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v2
.end method

.method private getBookmarkWithId(Ljava/lang/Long;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .locals 7
    .param p1, "id"    # Ljava/lang/Long;

    .prologue
    .line 400
    const/4 v0, 0x0

    .line 401
    .local v0, "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    const/4 v1, 0x0

    .line 402
    .local v1, "cursor":Landroid/database/Cursor;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->playNowDB:Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/database/PlayNowDatabase;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 404
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    const-string v3, "SELECT * FROM bookmark WHERE _id = ? AND user_key = ?;"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-virtual {p1}, Ljava/lang/Long;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->getUserKey()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 405
    if-eqz v1, :cond_0

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v3

    if-lez v3, :cond_0

    .line 406
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    .line 407
    new-instance v0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;

    .end local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    invoke-direct {v0, p0, v1}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;-><init>(Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;Landroid/database/Cursor;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 410
    .restart local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    :cond_0
    if-eqz v1, :cond_1

    .line 411
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 415
    :cond_1
    return-object v0

    .line 410
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    :catchall_0
    move-exception v3

    if-eqz v1, :cond_2

    .line 411
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v3
.end method

.method private getCategoriesForBookmark(Ljava/lang/Long;)Ljava/util/List;
    .locals 8
    .param p1, "id"    # Ljava/lang/Long;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Long;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;",
            ">;"
        }
    .end annotation

    .prologue
    .line 419
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 420
    .local v0, "categories":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;>;"
    const/4 v2, 0x0

    .line 421
    .local v2, "cursor":Landroid/database/Cursor;
    iget-object v4, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->playNowDB:Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/database/PlayNowDatabase;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v3

    .line 423
    .local v3, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    const-string v4, "SELECT category_name FROM bookmark_category WHERE bookmark_id = ?;"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-virtual {p1}, Ljava/lang/Long;->toString()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 424
    if-eqz v2, :cond_2

    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v4

    if-lez v4, :cond_2

    .line 425
    :cond_0
    :goto_0
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 426
    const-string v4, "category_name"

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 427
    .local v1, "category":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 428
    invoke-static {v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;->valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;

    move-result-object v4

    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 433
    .end local v1    # "category":Ljava/lang/String;
    :catchall_0
    move-exception v4

    if-eqz v2, :cond_1

    .line 434
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    :cond_1
    throw v4

    .line 433
    :cond_2
    if-eqz v2, :cond_3

    .line 434
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 438
    :cond_3
    return-object v0
.end method

.method private getUserKey()Ljava/lang/String;
    .locals 2

    .prologue
    .line 391
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    .line 392
    .local v0, "user":Lcom/xfinity/playerlib/model/user/PlayNowUser;
    if-eqz v0, :cond_0

    .line 393
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getUserName()Ljava/lang/String;

    move-result-object v1

    .line 396
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
    .line 129
    const-string v0, "CREATE TABLE bookmark (_id INTEGER PRIMARY KEY AUTOINCREMENT, user_key TEXT NOT NULL, parent_merlin_id TEXT, merlin_id TEXT, video_id INTEGER, network_id INTEGER, company_id INTEGER, title TEXT, position INTEGER, duration INTEGER, expiration_date INTEGER, timestamp INTEGER, season_info INTEGER, episode_info INTEGER,last_tracked_milestone INTEGER);"

    invoke-virtual {p0, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 130
    const-string v0, "CREATE TABLE bookmark_category (_id INTEGER PRIMARY KEY AUTOINCREMENT, bookmark_id INTEGER NOT NULL, category_name TEXT NOT NULL, FOREIGN KEY(bookmark_id) REFERENCES bookmark(_id) ON DELETE CASCADE);"

    invoke-virtual {p0, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 131
    return-void
.end method

.method public static onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 2
    .param p0, "database"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "oldVersion"    # I
    .param p2, "newVersion"    # I

    .prologue
    .line 135
    const/4 v1, 0x2

    if-gt p1, v1, :cond_0

    .line 136
    const-string v0, "ALTER TABLE bookmark ADD COLUMN last_tracked_milestone INTEGER DEFAULT 0"

    .line 137
    .local v0, "query":Ljava/lang/String;
    invoke-virtual {p0, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 140
    .end local v0    # "query":Ljava/lang/String;
    :cond_0
    const/4 v1, 0x3

    if-gt p1, v1, :cond_1

    .line 141
    const-string v0, "ALTER TABLE bookmark ADD COLUMN company_id INTEGER DEFAULT 0"

    .line 142
    .restart local v0    # "query":Ljava/lang/String;
    invoke-virtual {p0, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 144
    .end local v0    # "query":Ljava/lang/String;
    :cond_1
    return-void
.end method


# virtual methods
.method public deleteBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)Z
    .locals 8
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 372
    instance-of v4, p1, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;

    if-nez v4, :cond_0

    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "VideoBookmark not an instance of SQLiteBookmark"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    :cond_0
    move-object v0, p1

    .line 374
    check-cast v0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;

    .line 376
    .local v0, "bm":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->getDbId()J

    move-result-wide v4

    const-wide/16 v6, -0x1

    cmp-long v4, v4, v6

    if-nez v4, :cond_1

    new-instance v4, Landroid/database/sqlite/SQLiteException;

    const-string v5, "VideoBookmark has no SQLite ID (It\'s not in the database)"

    invoke-direct {v4, v5}, Landroid/database/sqlite/SQLiteException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 378
    :cond_1
    const/4 v3, 0x0

    .line 379
    .local v3, "success":Z
    iget-object v4, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->playNowDB:Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/database/PlayNowDatabase;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 381
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v4, "bookmark"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "_id="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->getDbId()J

    move-result-wide v6

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v1, v4, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    .line 383
    .local v2, "rows":I
    if-gtz v2, :cond_2

    .line 384
    new-instance v4, Landroid/database/sqlite/SQLiteException;

    const-string v5, "Could not delete any rows from the database"

    invoke-direct {v4, v5}, Landroid/database/sqlite/SQLiteException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 387
    :cond_2
    return v3
.end method

.method public finalize()V
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 126
    return-void
.end method

.method public getLastWatchedBookmark()Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .locals 10

    .prologue
    .line 162
    const/4 v3, 0x0

    .line 163
    .local v3, "lastWatched":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    const/4 v2, 0x0

    .line 165
    .local v2, "cursor":Landroid/database/Cursor;
    :try_start_0
    iget-object v4, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "SELECT bk.* FROM bookmark bk WHERE bk.user_key = ? AND EXISTS ( SELECT cat.* FROM bookmark_category cat WHERE bk._id = cat.bookmark_id AND cat.category_name = ?) AND (expiration_date > ? OR expiration_date IS NULL) ORDER BY timestamp DESC"

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->getUserKey()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x1

    sget-object v8, Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;->CATEGORY_RECENT:Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;

    invoke-virtual {v8}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x2

    new-instance v8, Ljava/util/Date;

    invoke-direct {v8}, Ljava/util/Date;-><init>()V

    invoke-virtual {v8}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v4, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 166
    if-eqz v2, :cond_0

    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v4

    if-lez v4, :cond_0

    .line 167
    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    .line 168
    const-string v4, "_id"

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    .line 169
    .local v0, "bookmarkId":J
    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->getBookmarkWithId(Ljava/lang/Long;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v3

    .line 172
    .end local v0    # "bookmarkId":J
    :cond_0
    if-eqz v2, :cond_1

    .line 173
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 177
    :cond_1
    return-object v3

    .line 172
    :catchall_0
    move-exception v4

    if-eqz v2, :cond_2

    .line 173
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v4
.end method

.method public getOrCreateBookmarkWithVideo(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .locals 9
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 267
    new-instance v0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;

    invoke-direct {v0, p1}, Lcom/xfinity/playerlib/bookmarks/BookmarkId;-><init>(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->getBookmarkByBookmarkId(Lcom/xfinity/playerlib/bookmarks/BookmarkId;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v8

    check-cast v8, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;

    .line 270
    .local v8, "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    if-nez v8, :cond_0

    .line 271
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getSeriesInfoIfApplicable()Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 272
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getSeriesInfoIfApplicable()Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;

    move-result-object v0

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 273
    new-instance v0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getNetworkId()J

    move-result-wide v2

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v4

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v6

    invoke-direct/range {v0 .. v7}, Lcom/xfinity/playerlib/bookmarks/BookmarkId;-><init>(Lcom/xfinity/playerlib/model/MerlinId;JJJ)V

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->getBookmarkByBookmarkId(Lcom/xfinity/playerlib/bookmarks/BookmarkId;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v8

    .end local v8    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    check-cast v8, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;

    .line 274
    .restart local v8    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    if-eqz v8, :cond_0

    .line 276
    invoke-virtual {v8, p1}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->updateLegacyNonEpisodeBookmarkWithConsumable(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 277
    sget-object v0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Successfully upgraded legacy non-episode bookmark"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->info(Ljava/lang/String;)V

    .line 284
    :cond_0
    if-nez v8, :cond_2

    .line 286
    new-instance v8, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;

    .end local v8    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    invoke-direct {v8, p0, p1, p2}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;-><init>(Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 288
    .restart local v8    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    invoke-virtual {v8}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->getPosition()I

    move-result v0

    if-ltz v0, :cond_1

    .line 289
    invoke-virtual {p0, v8}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->saveBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 290
    sget-object v0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Successfully upgraded legacy bookmark"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->info(Ljava/lang/String;)V

    .line 298
    :cond_1
    :goto_0
    return-object v8

    .line 293
    :cond_2
    invoke-virtual {v8, p1, p2}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->updateWithConsumable(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 294
    invoke-virtual {p0, v8}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->saveBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    goto :goto_0
.end method

.method public getRecentBookmarks()Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 182
    const/4 v2, 0x0

    .line 183
    .local v2, "cursor":Landroid/database/Cursor;
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 185
    .local v1, "bookmarks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    :try_start_0
    iget-object v3, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "SELECT bk.* FROM bookmark bk WHERE bk.user_key = ? AND EXISTS ( SELECT cat.* FROM bookmark_category cat WHERE bk._id = cat.bookmark_id AND cat.category_name = ?) AND (expiration_date > ? OR expiration_date IS NULL) ORDER BY timestamp DESC"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->getUserKey()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    sget-object v7, Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;->CATEGORY_RECENT:Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;->toString()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x2

    new-instance v7, Ljava/util/Date;

    invoke-direct {v7}, Ljava/util/Date;-><init>()V

    invoke-virtual {v7}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 186
    :goto_0
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 187
    new-instance v0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;

    invoke-direct {v0, p0, v2}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;-><init>(Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;Landroid/database/Cursor;)V

    .line 188
    .local v0, "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 191
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    :catchall_0
    move-exception v3

    if-eqz v2, :cond_0

    .line 192
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    :cond_0
    throw v3

    .line 191
    :cond_1
    if-eqz v2, :cond_2

    .line 192
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 196
    :cond_2
    return-object v1
.end method

.method public getResumePointBookmarks()Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 200
    const/4 v2, 0x0

    .line 201
    .local v2, "cursor":Landroid/database/Cursor;
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 203
    .local v1, "bookmarks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    :try_start_0
    iget-object v3, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "SELECT bk.* FROM bookmark bk WHERE bk.user_key = ? AND EXISTS ( SELECT cat.* FROM bookmark_category cat WHERE bk._id = cat.bookmark_id AND cat.category_name = ?) AND (expiration_date > ? OR expiration_date IS NULL) ORDER BY timestamp DESC"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->getUserKey()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    sget-object v7, Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;->CATEGORY_RESUMEPOINT:Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;->toString()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x2

    new-instance v7, Ljava/util/Date;

    invoke-direct {v7}, Ljava/util/Date;-><init>()V

    invoke-virtual {v7}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 204
    :goto_0
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 205
    new-instance v0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;

    invoke-direct {v0, p0, v2}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;-><init>(Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;Landroid/database/Cursor;)V

    .line 206
    .local v0, "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 209
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    :catchall_0
    move-exception v3

    if-eqz v2, :cond_0

    .line 210
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    :cond_0
    throw v3

    .line 209
    :cond_1
    if-eqz v2, :cond_2

    .line 210
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 214
    :cond_2
    return-object v1
.end method

.method public saveBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 13
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    const-wide/16 v10, -0x1

    const/4 v12, 0x0

    .line 310
    instance-of v5, p1, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;

    if-nez v5, :cond_0

    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v8, "VideoBookmark not an instance of SQLiteBookmark"

    invoke-direct {v5, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    :cond_0
    move-object v0, p1

    .line 312
    check-cast v0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;

    .line 313
    .local v0, "bm":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->getDbId()J

    move-result-wide v8

    cmp-long v5, v8, v10

    if-eqz v5, :cond_1

    .line 314
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->deleteBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)Z

    .line 317
    :cond_1
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getCategories()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    if-nez v5, :cond_2

    new-instance v5, Ljava/lang/IllegalStateException;

    const-string v8, "VideoBookmark has no categories associated with it"

    invoke-direct {v5, v8}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 319
    :cond_2
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 320
    .local v3, "cv":Landroid/content/ContentValues;
    const-string v5, "user_key"

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->getUserKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 321
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v5

    if-eqz v5, :cond_3

    .line 322
    const-string v5, "parent_merlin_id"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v8

    invoke-virtual {v8}, Lcom/xfinity/playerlib/model/MerlinId;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 326
    :goto_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v5

    if-eqz v5, :cond_4

    .line 327
    const-string v5, "merlin_id"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v8

    invoke-virtual {v8}, Lcom/xfinity/playerlib/model/MerlinId;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 331
    :goto_1
    const-string v5, "video_id"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getVideoId()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v3, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 332
    const-string v5, "company_id"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getCompanyId()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v3, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 333
    const-string v5, "title"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getTitle()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 334
    const-string v5, "position"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getPosition()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v3, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 335
    const-string v5, "duration"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getDuration()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v3, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 336
    const-string v5, "season_info"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getSeasonNumber()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v3, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 337
    const-string v5, "episode_info"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getEpisodeNumber()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v3, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 338
    const-string v5, "last_tracked_milestone"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getLastTrackedMilestone()Lcom/xfinity/playerlib/tracking/VideoMilestone;

    move-result-object v8

    invoke-virtual {v8}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->ordinal()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v3, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 340
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getExpirationDate()Ljava/util/Date;

    move-result-object v4

    .line 341
    .local v4, "expDate":Ljava/util/Date;
    if-eqz v4, :cond_5

    .line 342
    const-string v5, "expiration_date"

    invoke-virtual {v4}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v3, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 346
    :goto_2
    const-string v5, "timestamp"

    new-instance v8, Ljava/util/Date;

    invoke-direct {v8}, Ljava/util/Date;-><init>()V

    invoke-virtual {v8}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v3, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 348
    iget-object v5, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v8, "bookmark"

    invoke-virtual {v5, v8, v12, v3}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v6

    .line 350
    .local v6, "row":J
    cmp-long v5, v6, v10

    if-eqz v5, :cond_6

    move-object v5, p1

    .line 351
    check-cast v5, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;

    invoke-virtual {v5, v6, v7}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->setDbId(J)V

    move-object v5, p1

    .line 352
    check-cast v5, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->getUserKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->setUserKey(Ljava/lang/String;)V

    .line 353
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getCategories()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_3
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_6

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;

    .line 354
    .local v2, "category":Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 355
    .local v1, "catCV":Landroid/content/ContentValues;
    const-string v9, "bookmark_id"

    move-object v5, p1

    check-cast v5, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->getDbId()J

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v1, v9, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 356
    const-string v5, "category_name"

    invoke-virtual {v2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v5, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 358
    iget-object v5, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v9, "bookmark_category"

    invoke-virtual {v5, v9, v12, v1}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    goto :goto_3

    .line 324
    .end local v1    # "catCV":Landroid/content/ContentValues;
    .end local v2    # "category":Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;
    .end local v4    # "expDate":Ljava/util/Date;
    .end local v6    # "row":J
    :cond_3
    const-string v5, "parent_merlin_id"

    invoke-virtual {v3, v5}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 329
    :cond_4
    const-string v5, "merlin_id"

    invoke-virtual {v3, v5}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 344
    .restart local v4    # "expDate":Ljava/util/Date;
    :cond_5
    const-string v5, "expiration_date"

    invoke-virtual {v3, v5}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    goto :goto_2

    .line 361
    .restart local v6    # "row":J
    :cond_6
    return-void
.end method

.method public updateLastTrackedMilestones()V
    .locals 7

    .prologue
    .line 147
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->getResumePointBookmarks()Ljava/util/List;

    move-result-object v1

    .line 148
    .local v1, "bookmarks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .line 149
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getPosition()I

    move-result v4

    .line 150
    .local v4, "position":I
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getLastTrackedMilestone()Lcom/xfinity/playerlib/tracking/VideoMilestone;

    move-result-object v3

    .line 151
    .local v3, "lastTrackedMilestone":Lcom/xfinity/playerlib/tracking/VideoMilestone;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getDuration()I

    move-result v6

    invoke-static {v4, v6}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->decodePosition(II)Lcom/xfinity/playerlib/tracking/VideoMilestone;

    move-result-object v2

    .line 153
    .local v2, "lastSentMilestone":Lcom/xfinity/playerlib/tracking/VideoMilestone;
    if-eq v3, v2, :cond_0

    .line 154
    invoke-virtual {v0, v2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->setLastTrackedMilestone(Lcom/xfinity/playerlib/tracking/VideoMilestone;)V

    .line 155
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->saveBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    goto :goto_0

    .line 158
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .end local v2    # "lastSentMilestone":Lcom/xfinity/playerlib/tracking/VideoMilestone;
    .end local v3    # "lastTrackedMilestone":Lcom/xfinity/playerlib/tracking/VideoMilestone;
    .end local v4    # "position":I
    :cond_1
    return-void
.end method
