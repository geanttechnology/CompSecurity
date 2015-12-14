.class public Lcom/livemixtapes/database/DBHelper;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "DBHelper.java"


# static fields
.field public static final ALL_MIXTAPE_TABLE_NAME:Ljava/lang/String; = "all_mixtapes"

.field public static final DATABASE_NAME:Ljava/lang/String; = "Mixtape.db"

.field private static final DATABASE_VERSION:I = 0x6

.field public static final DAY_MIXTAPE_TABLE_NAME:Ljava/lang/String; = "day_mixtapes"

.field public static final DOWNLOAD_COLUMN_DURATION:Ljava/lang/String; = "duration"

.field public static final DOWNLOAD_COLUMN_ID:Ljava/lang/String; = "id"

.field public static final DOWNLOAD_COLUMN_IS_DOWNLOADED:Ljava/lang/String; = "isDownloaded"

.field public static final DOWNLOAD_COLUMN_MIXTAPE_ID:Ljava/lang/String; = "albumId"

.field public static final DOWNLOAD_COLUMN_MIXTAPE_IMAGE:Ljava/lang/String; = "albumImage"

.field public static final DOWNLOAD_COLUMN_MIXTAPE_NAME:Ljava/lang/String; = "albumName"

.field public static final DOWNLOAD_COLUMN_TRACK_ID:Ljava/lang/String; = "trackId"

.field public static final DOWNLOAD_COLUMN_TRACK_NAME:Ljava/lang/String; = "trackName"

.field public static final DOWNLOAD_TABLE_NAME:Ljava/lang/String; = "downloads"

.field public static final FAVORITES_COLUMN_ID:Ljava/lang/String; = "id"

.field public static final FAVORITES_COLUMN_MIXTAPE_ID:Ljava/lang/String; = "mixtapeId"

.field public static final FAVORITES_COLUMN_MIXTAPE_IMAGE:Ljava/lang/String; = "mixtapeImage"

.field public static final FAVORITES_COLUMN_MIXTAPE_NAME:Ljava/lang/String; = "mixtapeName"

.field public static final FAVORITES_TABLE_NAME:Ljava/lang/String; = "favorites"

.field public static final MIXTAPE_COLUMN_ARTIST:Ljava/lang/String; = "artist"

.field public static final MIXTAPE_COLUMN_COVER:Ljava/lang/String; = "cover"

.field public static final MIXTAPE_COLUMN_DJ:Ljava/lang/String; = "DJ"

.field public static final MIXTAPE_COLUMN_FEATURED:Ljava/lang/String; = "featured"

.field public static final MIXTAPE_COLUMN_ID:Ljava/lang/String; = "id"

.field public static final MIXTAPE_COLUMN_MIXTAPE_ID:Ljava/lang/String; = "mixtapeId"

.field public static final MIXTAPE_COLUMN_RELEASEDDATE:Ljava/lang/String; = "releasedate"

.field public static final MIXTAPE_COLUMN_SCORE:Ljava/lang/String; = "score"

.field public static final MIXTAPE_COLUMN_SHARE_TEXT:Ljava/lang/String; = "sharetext"

.field public static final MIXTAPE_COLUMN_THUMBNAIL:Ljava/lang/String; = "thumbnail"

.field public static final MIXTAPE_COLUMN_TITLE:Ljava/lang/String; = "title"

.field public static final MIXTAPE_COLUMN_VIEWS:Ljava/lang/String; = "views"

.field public static final MIXTAPE_TABLE_NAME:Ljava/lang/String; = "mixtape"

.field public static final PUSH_TABLE_NAME:Ljava/lang/String; = "push"

.field public static final TRACKS_COLUMN_DOWNLOAD_URL:Ljava/lang/String; = "downloadUrl"

.field public static final TRACKS_COLUMN_DURATION:Ljava/lang/String; = "duration"

.field public static final TRACKS_COLUMN_ID:Ljava/lang/String; = "id"

.field public static final TRACKS_COLUMN_MIXTAPE_ID:Ljava/lang/String; = "mixtapeId"

.field public static final TRACKS_COLUMN_SHARE_TEXT:Ljava/lang/String; = "shareText"

.field public static final TRACKS_COLUMN_TITLE:Ljava/lang/String; = "title"

.field public static final TRACKS_COLUMN_TRACK_ID:Ljava/lang/String; = "trackId"

.field public static final TRACKS_TABLE_NAME:Ljava/lang/String; = "tracks"

.field public static final UNRELEASED_MIXTAPE_TABLE_NAME:Ljava/lang/String; = "unreleased_mixtapes"

.field public static final WEEK_MIXTAPE_TABLE_NAME:Ljava/lang/String; = "week_mixtapes"

.field public static instance:Lcom/livemixtapes/database/DBHelper;


# instance fields
.field private dbReader:Landroid/database/sqlite/SQLiteDatabase;

.field private dbWriter:Landroid/database/sqlite/SQLiteDatabase;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 69
    const/4 v0, 0x0

    sput-object v0, Lcom/livemixtapes/database/DBHelper;->instance:Lcom/livemixtapes/database/DBHelper;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 73
    const-string v0, "Mixtape.db"

    const/4 v1, 0x0

    const/4 v2, 0x6

    invoke-direct {p0, p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 75
    invoke-virtual {p0}, Lcom/livemixtapes/database/DBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/database/DBHelper;->dbWriter:Landroid/database/sqlite/SQLiteDatabase;

    .line 76
    invoke-virtual {p0}, Lcom/livemixtapes/database/DBHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/database/DBHelper;->dbReader:Landroid/database/sqlite/SQLiteDatabase;

    .line 77
    return-void
.end method

.method public static sharedInstance(Landroid/content/Context;)Lcom/livemixtapes/database/DBHelper;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 85
    sget-object v0, Lcom/livemixtapes/database/DBHelper;->instance:Lcom/livemixtapes/database/DBHelper;

    if-nez v0, :cond_0

    .line 86
    new-instance v0, Lcom/livemixtapes/database/DBHelper;

    invoke-direct {v0, p0}, Lcom/livemixtapes/database/DBHelper;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/livemixtapes/database/DBHelper;->instance:Lcom/livemixtapes/database/DBHelper;

    .line 89
    :cond_0
    sget-object v0, Lcom/livemixtapes/database/DBHelper;->instance:Lcom/livemixtapes/database/DBHelper;

    return-object v0
.end method


# virtual methods
.method public checkIfTrackDownloaded(Ljava/lang/String;)Z
    .locals 4
    .param p1, "trackId"    # Ljava/lang/String;

    .prologue
    .line 293
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "select * from downloads where trackId = \'"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 294
    .local v1, "query":Ljava/lang/String;
    iget-object v2, p0, Lcom/livemixtapes/database/DBHelper;->dbReader:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 295
    .local v0, "cursor":Landroid/database/Cursor;
    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-gtz v2, :cond_0

    .line 296
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 297
    const/4 v2, 0x0

    .line 300
    :goto_0
    return v2

    .line 299
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 300
    const/4 v2, 0x1

    goto :goto_0
.end method

.method public clearMixtapeTable(Ljava/lang/String;)V
    .locals 2
    .param p1, "whichTable"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 228
    iget-object v0, p0, Lcom/livemixtapes/database/DBHelper;->dbWriter:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0, p1, v1, v1}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 229
    return-void
.end method

.method public clearTracksTable()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 233
    iget-object v0, p0, Lcom/livemixtapes/database/DBHelper;->dbWriter:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "tracks"

    invoke-virtual {v0, v1, v2, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 234
    return-void
.end method

.method public deleteDownload(Ljava/lang/String;)I
    .locals 5
    .param p1, "trackId"    # Ljava/lang/String;

    .prologue
    .line 320
    iget-object v1, p0, Lcom/livemixtapes/database/DBHelper;->dbWriter:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "downloads"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "trackId=\'"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 321
    .local v0, "count":I
    return v0
.end method

.method public deleteDownloadsAlbum(Landroid/content/Context;Ljava/lang/String;)I
    .locals 8
    .param p1, "ctx"    # Landroid/content/Context;
    .param p2, "albumId"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x0

    .line 305
    iget-object v3, p0, Lcom/livemixtapes/database/DBHelper;->dbWriter:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "select * from downloads where albumId = \'"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4, v7}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 306
    .local v2, "res":Landroid/database/Cursor;
    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    .line 307
    :goto_0
    invoke-interface {v2}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 313
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 314
    iget-object v3, p0, Lcom/livemixtapes/database/DBHelper;->dbWriter:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "downloads"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "albumId=\'"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5, v7}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 315
    .local v0, "count":I
    return v0

    .line 308
    .end local v0    # "count":I
    :cond_0
    const-string v3, "trackId"

    invoke-interface {v2, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v2, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {p1, v3}, Lcom/livemixtapes/Utils;->getLivemixtapesFolder(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    .line 309
    .local v1, "f":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 310
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    .line 311
    :cond_1
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0
.end method

.method public finalize()V
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/livemixtapes/database/DBHelper;->dbWriter:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 81
    iget-object v0, p0, Lcom/livemixtapes/database/DBHelper;->dbReader:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 82
    return-void
.end method

.method public getAllMixtapeData(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 7
    .param p1, "whichTable"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 238
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 240
    .local v2, "mixtapeList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    iget-object v4, p0, Lcom/livemixtapes/database/DBHelper;->dbReader:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "select * from "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v3

    .line 241
    .local v3, "res":Landroid/database/Cursor;
    invoke-interface {v3}, Landroid/database/Cursor;->moveToFirst()Z

    .line 243
    :goto_0
    invoke-interface {v3}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 265
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    .line 266
    return-object v2

    .line 244
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 246
    .local v0, "mixtape":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v4, "mixtapeId"

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 247
    .local v1, "mixtapeId":Ljava/lang/String;
    const-string v4, "id"

    invoke-virtual {v0, v4, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 248
    const-string v4, "title"

    const-string v5, "title"

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 249
    const-string v4, "artist"

    const-string v5, "artist"

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 250
    const-string v4, "thumbnail"

    const-string v5, "thumbnail"

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 251
    const-string v4, "DJ"

    const-string v5, "DJ"

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 252
    const-string v4, "views"

    const-string v5, "views"

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 253
    const-string v4, "score"

    const-string v5, "score"

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 254
    const-string v4, "cover"

    const-string v5, "cover"

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 255
    const-string v4, "sharetext"

    const-string v5, "sharetext"

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 256
    const-string v4, "releasedate"

    const-string v5, "releasedate"

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 257
    const-string v4, "featured"

    const-string v5, "featured"

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 259
    const-string v4, "tracks"

    invoke-virtual {p0, v1}, Lcom/livemixtapes/database/DBHelper;->getTracksOfMixtape(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 261
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 262
    const/4 v0, 0x0

    .line 263
    invoke-interface {v3}, Landroid/database/Cursor;->moveToNext()Z

    goto/16 :goto_0
.end method

.method public getAllTracksData()Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 400
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 403
    .local v0, "array_list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v2, p0, Lcom/livemixtapes/database/DBHelper;->dbReader:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "select * from tracks"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 404
    .local v1, "res":Landroid/database/Cursor;
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    .line 406
    :goto_0
    invoke-interface {v1}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 411
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 412
    return-object v0

    .line 407
    :cond_0
    const-string v2, "title"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 408
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0
.end method

.method public getDownloads()Ljava/util/ArrayList;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 362
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 363
    .local v0, "array_list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    iget-object v3, p0, Lcom/livemixtapes/database/DBHelper;->dbReader:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "select * from downloads where isDownloaded=1"

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 364
    .local v2, "res":Landroid/database/Cursor;
    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    .line 366
    :goto_0
    invoke-interface {v2}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 374
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 375
    return-object v0

    .line 367
    :cond_0
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 368
    .local v1, "hashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v3, "title"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "trackName"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, " - "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "albumName"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 369
    const-string v3, "image"

    const-string v4, "albumImage"

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 370
    const-string v3, "duration"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "duration"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 371
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 372
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0
.end method

.method public getDownloadsGroupedByAlbum()Ljava/util/ArrayList;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 380
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 381
    .local v0, "array_list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    iget-object v3, p0, Lcom/livemixtapes/database/DBHelper;->dbReader:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "select albumId, albumName, albumImage, sum(duration), count(albumId) from downloads where isDownloaded=1 group by albumId"

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 382
    .local v2, "res":Landroid/database/Cursor;
    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    .line 384
    :goto_0
    invoke-interface {v2}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 394
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 395
    return-object v0

    .line 385
    :cond_0
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 386
    .local v1, "hashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v3, "title"

    const-string v4, "albumName"

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 387
    const-string v3, "image"

    const-string v4, "albumImage"

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 388
    const-string v3, "duration"

    new-instance v4, Ljava/lang/StringBuilder;

    const/4 v5, 0x3

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 389
    const-string v3, "count"

    new-instance v4, Ljava/lang/StringBuilder;

    const/4 v5, 0x4

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 390
    const-string v3, "albumId"

    const/4 v4, 0x0

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 391
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 392
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0
.end method

.method public getIncompleteDownloads()Ljava/util/ArrayList;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 342
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 343
    .local v0, "array_list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    iget-object v3, p0, Lcom/livemixtapes/database/DBHelper;->dbReader:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "select * from downloads where isDownloaded=0"

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 344
    .local v2, "res":Landroid/database/Cursor;
    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    .line 346
    :goto_0
    invoke-interface {v2}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 356
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 357
    return-object v0

    .line 347
    :cond_0
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 348
    .local v1, "hashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v3, "track_id"

    const-string v4, "trackId"

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 349
    const-string v3, "mixtape_id"

    const-string v4, "albumId"

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 350
    const-string v3, "title"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "trackName"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, " - "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "albumName"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 351
    const-string v3, "image"

    const-string v4, "albumImage"

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 352
    const-string v3, "duration"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "duration"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 353
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 354
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z

    goto/16 :goto_0
.end method

.method public getMixtapeData(I)Landroid/database/Cursor;
    .locals 4
    .param p1, "id"    # I

    .prologue
    .line 221
    iget-object v1, p0, Lcom/livemixtapes/database/DBHelper;->dbReader:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "select * from mixtape where id="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 222
    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    .line 221
    invoke-virtual {v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 223
    .local v0, "res":Landroid/database/Cursor;
    return-object v0
.end method

.method public getTracksOfMixtape(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 11
    .param p1, "mixTapeId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 271
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    .line 273
    .local v10, "tracksList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    iget-object v0, p0, Lcom/livemixtapes/database/DBHelper;->dbReader:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "tracks"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "mixtapeId=\'"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    move-object v4, v2

    move-object v5, v2

    move-object v6, v2

    move-object v7, v2

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 275
    .local v8, "res":Landroid/database/Cursor;
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    .line 277
    :goto_0
    invoke-interface {v8}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 288
    return-object v10

    .line 278
    :cond_0
    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    .line 280
    .local v9, "track":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v0, "track_id"

    const-string v1, "trackId"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 281
    const-string v0, "track_title"

    const-string v1, "title"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 282
    const-string v0, "track_duration"

    const-string v1, "duration"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 283
    const-string v0, "download_url"

    const-string v1, "downloadUrl"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 284
    const-string v0, "track_sharetext"

    const-string v1, "shareText"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 285
    invoke-virtual {v10, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 286
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0
.end method

.method public insertDownload(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z
    .locals 6
    .param p1, "trackId"    # Ljava/lang/String;
    .param p2, "trackName"    # Ljava/lang/String;
    .param p3, "albumId"    # Ljava/lang/String;
    .param p4, "albumName"    # Ljava/lang/String;
    .param p5, "albumImage"    # Ljava/lang/String;
    .param p6, "duration"    # Ljava/lang/String;
    .param p7, "isDownloaded"    # I

    .prologue
    const/4 v5, 0x1

    .line 198
    new-array v1, v5, [Ljava/lang/Object;

    const/4 v2, 0x0

    .line 187
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "INSERT CALLED: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v1}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 188
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 189
    .local v0, "contentValues":Landroid/content/ContentValues;
    const-string v1, "trackId"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    const-string v1, "trackName"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 191
    const-string v1, "albumId"

    invoke-virtual {v0, v1, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 192
    const-string v1, "albumName"

    invoke-virtual {v0, v1, p4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 193
    const-string v1, "albumImage"

    invoke-virtual {v0, v1, p5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 194
    const-string v1, "duration"

    invoke-static {p6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 195
    const-string v1, "isDownloaded"

    invoke-static {p7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 196
    iget-object v1, p0, Lcom/livemixtapes/database/DBHelper;->dbWriter:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "downloads"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->insertOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 197
    return v5
.end method

.method public insertFavorite(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 4
    .param p1, "mixtapeId"    # Ljava/lang/String;
    .param p2, "mixtapeName"    # Ljava/lang/String;
    .param p3, "mixtapeImage"    # Ljava/lang/String;

    .prologue
    .line 201
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 202
    .local v0, "contentValues":Landroid/content/ContentValues;
    const-string v1, "mixtapeId"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 203
    const-string v1, "mixtapeName"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 204
    const-string v1, "mixtapeImage"

    invoke-virtual {v0, v1, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 205
    iget-object v1, p0, Lcom/livemixtapes/database/DBHelper;->dbWriter:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "favorites"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 206
    const/4 v1, 0x1

    return v1
.end method

.method public insertMixtape(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 5
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "mixtapeId"    # Ljava/lang/String;
    .param p3, "title"    # Ljava/lang/String;
    .param p4, "artist"    # Ljava/lang/String;
    .param p5, "thumbnail"    # Ljava/lang/String;
    .param p6, "DJ"    # Ljava/lang/String;
    .param p7, "views"    # Ljava/lang/String;
    .param p8, "cover"    # Ljava/lang/String;
    .param p9, "score"    # Ljava/lang/String;
    .param p10, "sharetext"    # Ljava/lang/String;
    .param p11, "releaseDate"    # Ljava/lang/String;
    .param p12, "featured"    # Ljava/lang/String;

    .prologue
    .line 148
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 149
    .local v1, "contentValues":Landroid/content/ContentValues;
    const-string v2, "mixtapeId"

    invoke-virtual {v1, v2, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 150
    const-string v2, "title"

    invoke-virtual {v1, v2, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 151
    const-string v2, "artist"

    invoke-virtual {v1, v2, p4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    const-string v2, "thumbnail"

    invoke-virtual {v1, v2, p5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 153
    const-string v2, "DJ"

    invoke-virtual {v1, v2, p6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 154
    const-string v2, "views"

    invoke-virtual {v1, v2, p7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    const-string v2, "cover"

    invoke-virtual {v1, v2, p8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 156
    const-string v2, "score"

    invoke-virtual {v1, v2, p9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    const-string v2, "sharetext"

    invoke-virtual {v1, v2, p10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 158
    const-string v2, "releasedate"

    move-object/from16 v0, p11

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 159
    const-string v2, "featured"

    move-object/from16 v0, p12

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 164
    :try_start_0
    iget-object v2, p0, Lcom/livemixtapes/database/DBHelper;->dbWriter:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v3, 0x0

    invoke-virtual {v2, p1, v3, v1}, Landroid/database/sqlite/SQLiteDatabase;->insertOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 165
    iget-object v2, p0, Lcom/livemixtapes/database/DBHelper;->dbWriter:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "mixtape"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4, v1}, Landroid/database/sqlite/SQLiteDatabase;->replaceOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 171
    :goto_0
    const/4 v2, 0x1

    return v2

    .line 167
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public insertPush(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 4
    .param p1, "id"    # Ljava/lang/Integer;
    .param p2, "device_token"    # Ljava/lang/String;
    .param p3, "device_id"    # Ljava/lang/String;
    .param p4, "device_description"    # Ljava/lang/String;

    .prologue
    .line 210
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 211
    .local v0, "contentValues":Landroid/content/ContentValues;
    const-string v1, "id"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 212
    const-string v1, "device_token"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    const-string v1, "device_id"

    invoke-virtual {v0, v1, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 214
    const-string v1, "device_description"

    invoke-virtual {v0, v1, p4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 216
    iget-object v1, p0, Lcom/livemixtapes/database/DBHelper;->dbWriter:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "push"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 217
    const/4 v1, 0x1

    return v1
.end method

.method public insertTrack(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 4
    .param p1, "mixtapeId"    # Ljava/lang/String;
    .param p2, "trackId"    # Ljava/lang/String;
    .param p3, "title"    # Ljava/lang/String;
    .param p4, "duration"    # Ljava/lang/String;
    .param p5, "downloadUrl"    # Ljava/lang/String;
    .param p6, "shareText"    # Ljava/lang/String;

    .prologue
    .line 175
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 176
    .local v0, "contentValues":Landroid/content/ContentValues;
    const-string v1, "mixtapeId"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 177
    const-string v1, "trackId"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 178
    const-string v1, "title"

    invoke-virtual {v0, v1, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 179
    const-string v1, "duration"

    invoke-virtual {v0, v1, p4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 180
    const-string v1, "downloadUrl"

    invoke-virtual {v0, v1, p5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 181
    const-string v1, "shareText"

    invoke-virtual {v0, v1, p6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 182
    iget-object v1, p0, Lcom/livemixtapes/database/DBHelper;->dbWriter:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "tracks"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->replaceOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 183
    const/4 v1, 0x1

    return v1
.end method

.method public markDownloadComplete(Ljava/lang/String;)I
    .locals 6
    .param p1, "trackId"    # Ljava/lang/String;

    .prologue
    .line 326
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 327
    .local v0, "contentValues":Landroid/content/ContentValues;
    const-string v2, "isDownloaded"

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 328
    iget-object v2, p0, Lcom/livemixtapes/database/DBHelper;->dbWriter:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "downloads"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "trackId=\'"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v0, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 329
    .local v1, "count":I
    return v1
.end method

.method public mixtapeCount(Ljava/lang/String;)I
    .locals 5
    .param p1, "whichTable"    # Ljava/lang/String;

    .prologue
    .line 334
    iget-object v2, p0, Lcom/livemixtapes/database/DBHelper;->dbReader:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "select id from "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 335
    .local v1, "res":Landroid/database/Cursor;
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v0

    .line 336
    .local v0, "count":I
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 337
    return v0
.end method

.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 95
    const-string v0, "create table mixtape (id integer primary key, mixtapeId text UNIQUE, title text, artist text, thumbnail text, DJ text, views text, cover text, score text, sharetext text, releasedate text, featured text)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 98
    const-string v0, "create table all_mixtapes (id integer primary key, mixtapeId text, title text, artist text, thumbnail text, DJ text, views text, cover text, score text, sharetext text, releasedate text, featured text)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 101
    const-string v0, "create table week_mixtapes (id integer primary key, mixtapeId text, title text, artist text, thumbnail text, DJ text, views text, cover text, score text, sharetext text, releasedate text, featured text)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 104
    const-string v0, "create table day_mixtapes (id integer primary key, mixtapeId text, title text, artist text, thumbnail text, DJ text, views text, cover text, score text, sharetext text, releasedate text, featured text)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 107
    const-string v0, "create table unreleased_mixtapes (id integer primary key, mixtapeId text, title text, artist text, thumbnail text, DJ text, views text, cover text, score text, sharetext text, releasedate text, featured text)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 112
    const-string v0, "create table tracks (id integer primary key, mixtapeId text, trackId text UNIQUE, title text, duration text, downloadUrl text, shareText text)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 116
    const-string v0, "create table downloads (id integer primary key, trackId text, trackName text, albumId text, albumName text, albumImage text, duration integer, isDownloaded integer)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 120
    const-string v0, "create table favorites (id integer primary key, mixtapeId text, mixtapeName text, mixtapeImage text)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 124
    const-string v0, "create table push (id integer primary key, device_token text, device_id text, device_description text)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 127
    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 132
    const-string v0, "DROP TABLE IF EXISTS mixtape"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 133
    const-string v0, "DROP TABLE IF EXISTS all_mixtapes"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 134
    const-string v0, "DROP TABLE IF EXISTS week_mixtapes"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 135
    const-string v0, "DROP TABLE IF EXISTS day_mixtapes"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 136
    const-string v0, "DROP TABLE IF EXISTS unreleased_mixtapes"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 139
    const-string v0, "DROP TABLE IF EXISTS push"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 141
    const-string v0, "DROP TABLE IF EXISTS tracks"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 142
    const-string v0, "DROP TABLE IF EXISTS downloads"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 143
    const-string v0, "DROP TABLE IF EXISTS favorites"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 144
    invoke-virtual {p0, p1}, Lcom/livemixtapes/database/DBHelper;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 145
    return-void
.end method
