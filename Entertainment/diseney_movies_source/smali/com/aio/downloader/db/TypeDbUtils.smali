.class public Lcom/aio/downloader/db/TypeDbUtils;
.super Ljava/lang/Object;
.source "TypeDbUtils.java"

# interfaces
.implements Lcom/aio/downloader/mydownload/ContentValue;


# static fields
.field public static mNotificationManager:Landroid/app/NotificationManager;


# instance fields
.field private db:Lcom/aio/downloader/db/TypeDb;

.field private finalDBChen:Lnet/tsz/afinal/FinalDBChen;

.field private mContext:Landroid/content/Context;

.field private packageInfo:Landroid/content/pm/PackageInfo;

.field public puTools:Lcom/aio/downloader/utils/publicTools;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "mContext"    # Landroid/content/Context;

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/db/TypeDbUtils;->packageInfo:Landroid/content/pm/PackageInfo;

    .line 43
    new-instance v0, Lcom/aio/downloader/db/TypeDb;

    invoke-direct {v0, p1}, Lcom/aio/downloader/db/TypeDb;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/db/TypeDbUtils;->db:Lcom/aio/downloader/db/TypeDb;

    .line 44
    iput-object p1, p0, Lcom/aio/downloader/db/TypeDbUtils;->mContext:Landroid/content/Context;

    .line 46
    const-string v0, "notification"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 45
    check-cast v0, Landroid/app/NotificationManager;

    sput-object v0, Lcom/aio/downloader/db/TypeDbUtils;->mNotificationManager:Landroid/app/NotificationManager;

    .line 47
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    .line 48
    const-string v1, "download2.db"

    invoke-virtual {p1, v1}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p1, v1}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 47
    iput-object v0, p0, Lcom/aio/downloader/db/TypeDbUtils;->finalDBChen:Lnet/tsz/afinal/FinalDBChen;

    .line 49
    new-instance v0, Lcom/aio/downloader/utils/publicTools;

    invoke-direct {v0, p1}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/db/TypeDbUtils;->puTools:Lcom/aio/downloader/utils/publicTools;

    .line 50
    return-void
.end method


# virtual methods
.method public deleteall()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 83
    iget-object v1, p0, Lcom/aio/downloader/db/TypeDbUtils;->db:Lcom/aio/downloader/db/TypeDb;

    invoke-virtual {v1}, Lcom/aio/downloader/db/TypeDb;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 84
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "file_list"

    invoke-virtual {v0, v1, v2, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 85
    return-void
.end method

.method public deleteallfile(Ljava/lang/String;)V
    .locals 7
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 78
    iget-object v1, p0, Lcom/aio/downloader/db/TypeDbUtils;->db:Lcom/aio/downloader/db/TypeDb;

    invoke-virtual {v1}, Lcom/aio/downloader/db/TypeDb;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 79
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "file_list"

    const-string v2, "typ=?"

    .line 80
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 79
    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 81
    return-void
.end method

.method public deletefile(Ljava/lang/String;)V
    .locals 7
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 72
    iget-object v1, p0, Lcom/aio/downloader/db/TypeDbUtils;->db:Lcom/aio/downloader/db/TypeDb;

    invoke-virtual {v1}, Lcom/aio/downloader/db/TypeDb;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 73
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "file_list"

    const-string v2, "id=?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 75
    return-void
.end method

.method public insertApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Ljava/lang/String;)V
    .locals 4
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "title"    # Ljava/lang/String;
    .param p4, "icon"    # Ljava/lang/String;
    .param p5, "size"    # Ljava/lang/String;
    .param p6, "path"    # Ljava/lang/String;
    .param p7, "serial"    # I
    .param p8, "create_time"    # Ljava/lang/Long;
    .param p9, "mVersion"    # Ljava/lang/String;

    .prologue
    .line 55
    iget-object v2, p0, Lcom/aio/downloader/db/TypeDbUtils;->db:Lcom/aio/downloader/db/TypeDb;

    invoke-virtual {v2}, Lcom/aio/downloader/db/TypeDb;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 56
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 57
    .local v1, "values":Landroid/content/ContentValues;
    const-string v2, "id"

    invoke-virtual {v1, v2, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 58
    const-string v2, "typ"

    invoke-virtual {v1, v2, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    const-string v2, "title"

    invoke-virtual {v1, v2, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    const-string v2, "icon"

    invoke-virtual {v1, v2, p4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    const-string v2, "size"

    invoke-virtual {v1, v2, p5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    const-string v2, "path"

    invoke-virtual {v1, v2, p6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    const-string v2, "serial"

    invoke-static {p7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 64
    const-string v2, "create_time"

    invoke-virtual {v1, v2, p8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 65
    const-string v2, "file_list"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3, v1}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 66
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 67
    return-void
.end method

.method public myqueryfile()Ljava/util/List;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 174
    iget-object v1, p0, Lcom/aio/downloader/db/TypeDbUtils;->db:Lcom/aio/downloader/db/TypeDb;

    invoke-virtual {v1}, Lcom/aio/downloader/db/TypeDb;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 175
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v8, 0x0

    .line 176
    .local v8, "cursor":Landroid/database/Cursor;
    const-string v1, "file_list"

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    move-object v6, v2

    move-object v7, v2

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 178
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 180
    .local v9, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    if-eqz v8, :cond_0

    .line 182
    :goto_0
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-nez v1, :cond_1

    .line 208
    :cond_0
    :goto_1
    if-nez v8, :cond_2

    .line 220
    :goto_2
    return-object v2

    .line 183
    :cond_1
    new-instance v10, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 185
    .local v10, "mDownloadMovieItem":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    const-string v1, "id"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 184
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFile_id(Ljava/lang/String;)V

    .line 187
    const-string v1, "typ"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 186
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setType(Ljava/lang/String;)V

    .line 189
    const-string v1, "title"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 188
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieName(Ljava/lang/String;)V

    .line 191
    const-string v1, "icon"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 190
    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieHeadImagePath(Ljava/lang/String;)V

    .line 193
    const-string v1, "size"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 192
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFileSize(Ljava/lang/String;)V

    .line 195
    const-string v1, "path"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 194
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFilePath(Ljava/lang/String;)V

    .line 197
    const-string v1, "serial"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 196
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 199
    const-string v1, "create_time"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 198
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCreate_time(Ljava/lang/Long;)V

    .line 200
    invoke-interface {v9, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 203
    .end local v10    # "mDownloadMovieItem":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :catch_0
    move-exception v1

    goto :goto_1

    .line 212
    :cond_2
    :try_start_1
    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-nez v1, :cond_3

    .line 213
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    goto/16 :goto_2

    .line 217
    :catch_1
    move-exception v1

    :goto_3
    move-object v2, v9

    .line 220
    goto/16 :goto_2

    .line 216
    :cond_3
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_3
.end method

.method public queryApk(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 11
    .param p1, "typ"    # Ljava/lang/String;
    .param p2, "typesort"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 117
    iget-object v1, p0, Lcom/aio/downloader/db/TypeDbUtils;->db:Lcom/aio/downloader/db/TypeDb;

    invoke-virtual {v1}, Lcom/aio/downloader/db/TypeDb;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 118
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v8, 0x0

    .line 119
    .local v8, "cursor":Landroid/database/Cursor;
    const-string v1, "timesort"

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 120
    const-string v1, "file_list"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "typ=\'"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 121
    const-string v4, "\'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v7, "create_time DESC"

    move-object v4, v2

    move-object v5, v2

    move-object v6, v2

    .line 120
    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 126
    :cond_0
    :goto_0
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 128
    .local v9, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    if-eqz v8, :cond_1

    .line 130
    :goto_1
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    if-nez v1, :cond_3

    .line 156
    :cond_1
    :goto_2
    if-nez v8, :cond_4

    .line 169
    :goto_3
    return-object v2

    .line 122
    .end local v9    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    :cond_2
    const-string v1, "zimusort"

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 123
    const-string v1, "file_list"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "typ=\'"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 124
    const-string v4, "\'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v7, "title ASC"

    move-object v4, v2

    move-object v5, v2

    move-object v6, v2

    .line 123
    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    goto :goto_0

    .line 131
    .restart local v9    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    :cond_3
    :try_start_1
    new-instance v10, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 133
    .local v10, "mDownloadMovieItem":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    const-string v1, "id"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 132
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFile_id(Ljava/lang/String;)V

    .line 135
    const-string v1, "typ"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 134
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setType(Ljava/lang/String;)V

    .line 137
    const-string v1, "title"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 136
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieName(Ljava/lang/String;)V

    .line 139
    const-string v1, "icon"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 138
    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieHeadImagePath(Ljava/lang/String;)V

    .line 141
    const-string v1, "size"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 140
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFileSize(Ljava/lang/String;)V

    .line 143
    const-string v1, "path"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 142
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFilePath(Ljava/lang/String;)V

    .line 145
    const-string v1, "serial"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 144
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 147
    const-string v1, "create_time"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 146
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCreate_time(Ljava/lang/Long;)V

    .line 148
    invoke-interface {v9, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1

    .line 151
    .end local v10    # "mDownloadMovieItem":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :catch_0
    move-exception v1

    goto/16 :goto_2

    .line 160
    :cond_4
    :try_start_2
    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-nez v1, :cond_5

    .line 161
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    goto/16 :goto_3

    .line 165
    :catch_1
    move-exception v1

    :goto_4
    move-object v2, v9

    .line 169
    goto/16 :goto_3

    .line 164
    :cond_5
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_4
.end method

.method public querydownloading(Ljava/lang/String;)Ljava/lang/String;
    .locals 11
    .param p1, "downloading_id"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 322
    iget-object v1, p0, Lcom/aio/downloader/db/TypeDbUtils;->finalDBChen:Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {v1}, Lnet/tsz/afinal/FinalDBChen;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 326
    .local v0, "mydatabase":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v8, 0x0

    .line 327
    .local v8, "cursor":Landroid/database/Cursor;
    const-string v1, "downloadtask"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "file_id=\'"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 328
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

    .line 327
    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 329
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 331
    .local v9, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    if-eqz v8, :cond_0

    .line 332
    :goto_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-nez v1, :cond_1

    .line 340
    :cond_0
    if-nez v8, :cond_2

    .line 348
    :goto_1
    return-object v2

    .line 333
    :cond_1
    new-instance v10, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 335
    .local v10, "mDownloadMovieItem":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    const-string v1, "file_id"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 334
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFile_id(Ljava/lang/String;)V

    .line 336
    invoke-interface {v9, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 343
    .end local v10    # "mDownloadMovieItem":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_2
    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-nez v1, :cond_3

    .line 344
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    goto :goto_1

    .line 347
    :cond_3
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 348
    const/4 v1, 0x0

    invoke-interface {v9, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v2

    goto :goto_1
.end method

.method public queryfile(Ljava/lang/String;)Ljava/lang/String;
    .locals 11
    .param p1, "fileid"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 88
    iget-object v1, p0, Lcom/aio/downloader/db/TypeDbUtils;->db:Lcom/aio/downloader/db/TypeDb;

    invoke-virtual {v1}, Lcom/aio/downloader/db/TypeDb;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 89
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v8, 0x0

    .line 90
    .local v8, "cursor":Landroid/database/Cursor;
    const-string v1, "file_list"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "id=\'"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 91
    const-string v4, "\'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    move-object v4, v2

    move-object v5, v2

    move-object v6, v2

    move-object v7, v2

    .line 90
    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 92
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 94
    .local v9, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    if-eqz v8, :cond_0

    .line 95
    :goto_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-nez v1, :cond_1

    .line 103
    :cond_0
    if-nez v8, :cond_2

    .line 111
    :goto_1
    return-object v2

    .line 96
    :cond_1
    new-instance v10, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 98
    .local v10, "mDownloadMovieItem":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    const-string v1, "id"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 97
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFile_id(Ljava/lang/String;)V

    .line 99
    invoke-interface {v9, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 106
    .end local v10    # "mDownloadMovieItem":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_2
    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-nez v1, :cond_3

    .line 107
    iget-object v1, p0, Lcom/aio/downloader/db/TypeDbUtils;->db:Lcom/aio/downloader/db/TypeDb;

    invoke-virtual {v1}, Lcom/aio/downloader/db/TypeDb;->close()V

    goto :goto_1

    .line 111
    :cond_3
    const/4 v1, 0x0

    invoke-interface {v9, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v2

    goto :goto_1
.end method

.method public queryfile2()Ljava/util/List;
    .locals 19
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 226
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/db/TypeDbUtils;->db:Lcom/aio/downloader/db/TypeDb;

    invoke-virtual {v2}, Lcom/aio/downloader/db/TypeDb;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 227
    .local v1, "database":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v10, 0x0

    .line 228
    .local v10, "cursor":Landroid/database/Cursor;
    const-string v2, "file_list"

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    .line 229
    const/4 v7, 0x0

    const/4 v8, 0x0

    .line 228
    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 230
    new-instance v13, Ljava/util/ArrayList;

    invoke-direct {v13}, Ljava/util/ArrayList;-><init>()V

    .line 232
    .local v13, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    if-eqz v10, :cond_0

    .line 233
    :goto_0
    invoke-interface {v10}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-nez v2, :cond_1

    .line 308
    :cond_0
    if-nez v10, :cond_3

    .line 309
    const/4 v2, 0x0

    .line 315
    :goto_1
    return-object v2

    .line 234
    :cond_1
    new-instance v14, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v14}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 236
    .local v14, "mDownloadMovieItem":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    const-string v2, "id"

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    .line 235
    invoke-interface {v10, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v14, v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFile_id(Ljava/lang/String;)V

    .line 238
    const-string v2, "title"

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    .line 237
    invoke-interface {v10, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v14, v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 240
    const-string v2, "serial"

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    .line 239
    invoke-interface {v10, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-virtual {v14, v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 242
    const-string v2, "typ"

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    .line 241
    invoke-interface {v10, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v14, v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setType(Ljava/lang/String;)V

    .line 245
    const-string v2, "icon"

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    .line 244
    invoke-interface {v10, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v14, v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setIcon(Ljava/lang/String;)V

    .line 247
    :try_start_0
    const-string v2, "vfvf"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "/////"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v14}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 248
    const-string v4, "//////"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v14}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 249
    const-string v4, "////////"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v14}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 247
    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 250
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/db/TypeDbUtils;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 251
    invoke-virtual {v14}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    .line 250
    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/db/TypeDbUtils;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 257
    :goto_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/db/TypeDbUtils;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v2, :cond_2

    .line 260
    invoke-virtual {v14}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v2

    const-string v3, "app"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 261
    new-instance v15, Landroid/app/Notification;

    invoke-direct {v15}, Landroid/app/Notification;-><init>()V

    .line 262
    .local v15, "notification":Landroid/app/Notification;
    const/16 v2, 0x10

    iput v2, v15, Landroid/app/Notification;->flags:I

    .line 263
    const v2, 0x7f0200ec

    iput v2, v15, Landroid/app/Notification;->icon:I

    .line 265
    new-instance v12, Landroid/content/Intent;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/db/TypeDbUtils;->mContext:Landroid/content/Context;

    .line 266
    const-class v3, Lcom/aio/downloader/activity/MyDownloaderList;

    .line 265
    invoke-direct {v12, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 267
    .local v12, "intent1":Landroid/content/Intent;
    const/high16 v2, 0x10000000

    invoke-virtual {v12, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 269
    new-instance v9, Landroid/os/Bundle;

    invoke-direct {v9}, Landroid/os/Bundle;-><init>()V

    .line 270
    .local v9, "bundle":Landroid/os/Bundle;
    const-string v2, "saomiao"

    const-string v3, "ok"

    invoke-virtual {v9, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 271
    invoke-virtual {v12, v9}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 274
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/db/TypeDbUtils;->mContext:Landroid/content/Context;

    .line 275
    invoke-virtual {v14}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v3

    .line 277
    const/high16 v4, 0x8000000

    .line 274
    invoke-static {v2, v3, v12, v4}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v17

    .line 278
    .local v17, "pendingIntent":Landroid/app/PendingIntent;
    move-object/from16 v0, v17

    iput-object v0, v15, Landroid/app/Notification;->contentIntent:Landroid/app/PendingIntent;

    .line 279
    new-instance v18, Landroid/widget/RemoteViews;

    .line 280
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/db/TypeDbUtils;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    .line 281
    const v3, 0x7f030092

    .line 279
    move-object/from16 v0, v18

    invoke-direct {v0, v2, v3}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 282
    .local v18, "rv":Landroid/widget/RemoteViews;
    const v2, 0x7f070334

    .line 283
    invoke-virtual {v14}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v3

    .line 282
    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 285
    const v2, 0x7f070335

    .line 286
    const-string v3, "kk:mm"

    .line 287
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 286
    invoke-static {v3, v4, v5}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;

    move-result-object v3

    .line 284
    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 288
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 289
    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "com.ywh.imgcache"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 290
    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "allicon"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 291
    const-string v3, "com.ywh.imgcache"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 292
    const-string v3, "allicon"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 293
    invoke-virtual {v14}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/aio/downloader/utils/MD5;->enlode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 288
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    .line 295
    .local v16, "path":Ljava/lang/String;
    const v2, 0x7f070277

    .line 296
    invoke-static/range {v16 .. v16}, Lcom/aio/downloader/utils/Myutils;->getImage(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v3

    .line 295
    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 298
    move-object/from16 v0, v18

    iput-object v0, v15, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 299
    sget-object v2, Lcom/aio/downloader/db/TypeDbUtils;->mNotificationManager:Landroid/app/NotificationManager;

    .line 300
    invoke-virtual {v14}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v3

    .line 299
    invoke-virtual {v2, v3, v15}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 304
    .end local v9    # "bundle":Landroid/os/Bundle;
    .end local v12    # "intent1":Landroid/content/Intent;
    .end local v15    # "notification":Landroid/app/Notification;
    .end local v16    # "path":Ljava/lang/String;
    .end local v17    # "pendingIntent":Landroid/app/PendingIntent;
    .end local v18    # "rv":Landroid/widget/RemoteViews;
    :cond_2
    invoke-interface {v13, v14}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 252
    :catch_0
    move-exception v11

    .line 253
    .local v11, "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/db/TypeDbUtils;->packageInfo:Landroid/content/pm/PackageInfo;

    .line 254
    invoke-virtual {v11}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_2

    .line 311
    .end local v11    # "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    .end local v14    # "mDownloadMovieItem":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_3
    invoke-interface {v10}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-nez v2, :cond_4

    .line 312
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/db/TypeDbUtils;->db:Lcom/aio/downloader/db/TypeDb;

    invoke-virtual {v2}, Lcom/aio/downloader/db/TypeDb;->close()V

    .line 313
    const/4 v2, 0x0

    goto/16 :goto_1

    .line 315
    :cond_4
    const/4 v2, 0x0

    goto/16 :goto_1
.end method
