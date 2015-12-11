.class public Lcom/aio/downloader/db/TypeDbUtilsBackup;
.super Ljava/lang/Object;
.source "TypeDbUtilsBackup.java"

# interfaces
.implements Lcom/aio/downloader/mydownload/ContentValue;


# instance fields
.field private db:Lcom/aio/downloader/db/TypeDbBackup;

.field private finalDBChen:Lnet/tsz/afinal/FinalDBChen;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "mContext"    # Landroid/content/Context;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    new-instance v0, Lcom/aio/downloader/db/TypeDbBackup;

    invoke-direct {v0, p1}, Lcom/aio/downloader/db/TypeDbBackup;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/db/TypeDbUtilsBackup;->db:Lcom/aio/downloader/db/TypeDbBackup;

    .line 25
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    .line 26
    const-string v1, "download2.db"

    invoke-virtual {p1, v1}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p1, v1}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 25
    iput-object v0, p0, Lcom/aio/downloader/db/TypeDbUtilsBackup;->finalDBChen:Lnet/tsz/afinal/FinalDBChen;

    .line 27
    return-void
.end method


# virtual methods
.method public deleteallfile(Ljava/lang/String;)V
    .locals 7
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 90
    iget-object v1, p0, Lcom/aio/downloader/db/TypeDbUtilsBackup;->db:Lcom/aio/downloader/db/TypeDbBackup;

    invoke-virtual {v1}, Lcom/aio/downloader/db/TypeDbBackup;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 91
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "backup"

    const-string v2, "typ=?"

    .line 92
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

    .line 91
    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 93
    return-void
.end method

.method public deletefile(Ljava/lang/String;)V
    .locals 7
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 84
    iget-object v1, p0, Lcom/aio/downloader/db/TypeDbUtilsBackup;->db:Lcom/aio/downloader/db/TypeDbBackup;

    invoke-virtual {v1}, Lcom/aio/downloader/db/TypeDbBackup;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 85
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "backup"

    const-string v2, "package_name=?"

    .line 86
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

    .line 85
    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 87
    return-void
.end method

.method public insertApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "package_name"    # Ljava/lang/String;
    .param p2, "app_name"    # Ljava/lang/String;
    .param p3, "type"    # Ljava/lang/String;
    .param p4, "img"    # Ljava/lang/String;
    .param p5, "size"    # Ljava/lang/String;
    .param p6, "version"    # Ljava/lang/String;

    .prologue
    .line 31
    iget-object v2, p0, Lcom/aio/downloader/db/TypeDbUtilsBackup;->db:Lcom/aio/downloader/db/TypeDbBackup;

    invoke-virtual {v2}, Lcom/aio/downloader/db/TypeDbBackup;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 32
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 33
    .local v1, "values":Landroid/content/ContentValues;
    const-string v2, "package_name"

    invoke-virtual {v1, v2, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 34
    const-string v2, "app_name"

    invoke-virtual {v1, v2, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 35
    const-string v2, "typ"

    invoke-virtual {v1, v2, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 36
    const-string v2, "img"

    invoke-virtual {v1, v2, p4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 37
    const-string v2, "size"

    invoke-virtual {v1, v2, p5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    const-string v2, "version"

    invoke-virtual {v1, v2, p6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 39
    const-string v2, "backup"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3, v1}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 40
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 41
    return-void
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
            "Lcom/aio/downloader/model/BackupModel;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 44
    iget-object v1, p0, Lcom/aio/downloader/db/TypeDbUtilsBackup;->db:Lcom/aio/downloader/db/TypeDbBackup;

    invoke-virtual {v1}, Lcom/aio/downloader/db/TypeDbBackup;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 45
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v8, 0x0

    .line 46
    .local v8, "cursor":Landroid/database/Cursor;
    const-string v1, "timesort"

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 47
    const-string v1, "backup"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "typ=\'"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 48
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

    .line 47
    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 53
    :cond_0
    :goto_0
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 55
    .local v9, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/model/BackupModel;>;"
    if-eqz v8, :cond_1

    .line 56
    :goto_1
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-nez v1, :cond_3

    .line 72
    :cond_1
    if-nez v8, :cond_4

    .line 80
    :goto_2
    return-object v2

    .line 49
    .end local v9    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/model/BackupModel;>;"
    :cond_2
    const-string v1, "zimusort"

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 50
    const-string v1, "backup"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "typ=\'"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 51
    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v7, "title ASC"

    move-object v4, v2

    move-object v5, v2

    move-object v6, v2

    .line 50
    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    goto :goto_0

    .line 57
    .restart local v9    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/model/BackupModel;>;"
    :cond_3
    new-instance v10, Lcom/aio/downloader/model/BackupModel;

    invoke-direct {v10}, Lcom/aio/downloader/model/BackupModel;-><init>()V

    .line 59
    .local v10, "mDownloadMovieItem":Lcom/aio/downloader/model/BackupModel;
    const-string v1, "package_name"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 58
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/model/BackupModel;->setPackage_name(Ljava/lang/String;)V

    .line 61
    const-string v1, "app_name"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 60
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/model/BackupModel;->setApp_name(Ljava/lang/String;)V

    .line 63
    const-string v1, "img"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 62
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/model/BackupModel;->setImg(Ljava/lang/String;)V

    .line 65
    const-string v1, "size"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 64
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/model/BackupModel;->setSize(Ljava/lang/String;)V

    .line 67
    const-string v1, "version"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 66
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/model/BackupModel;->setVersion(Ljava/lang/String;)V

    .line 68
    invoke-interface {v9, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 75
    .end local v10    # "mDownloadMovieItem":Lcom/aio/downloader/model/BackupModel;
    :cond_4
    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-nez v1, :cond_5

    .line 76
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    goto :goto_2

    .line 79
    :cond_5
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    move-object v2, v9

    .line 80
    goto/16 :goto_2
.end method

.method public querydownloading(Ljava/lang/String;)Ljava/lang/String;
    .locals 11
    .param p1, "downloading_id"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 128
    iget-object v1, p0, Lcom/aio/downloader/db/TypeDbUtilsBackup;->finalDBChen:Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {v1}, Lnet/tsz/afinal/FinalDBChen;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 132
    .local v0, "mydatabase":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v8, 0x0

    .line 133
    .local v8, "cursor":Landroid/database/Cursor;
    const-string v1, "downloadtask"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "file_id=\'"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 134
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

    .line 133
    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 135
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 137
    .local v9, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/model/BackupModel;>;"
    if-eqz v8, :cond_0

    .line 138
    :goto_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-nez v1, :cond_1

    .line 146
    :cond_0
    if-nez v8, :cond_2

    .line 154
    :goto_1
    return-object v2

    .line 139
    :cond_1
    new-instance v10, Lcom/aio/downloader/model/BackupModel;

    invoke-direct {v10}, Lcom/aio/downloader/model/BackupModel;-><init>()V

    .line 141
    .local v10, "mDownloadMovieItem":Lcom/aio/downloader/model/BackupModel;
    const-string v1, "package_name"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 140
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/model/BackupModel;->setPackage_name(Ljava/lang/String;)V

    .line 142
    invoke-interface {v9, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 149
    .end local v10    # "mDownloadMovieItem":Lcom/aio/downloader/model/BackupModel;
    :cond_2
    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-nez v1, :cond_3

    .line 150
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    goto :goto_1

    .line 153
    :cond_3
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 154
    const/4 v1, 0x0

    invoke-interface {v9, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/BackupModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/BackupModel;->getPackage_name()Ljava/lang/String;

    move-result-object v2

    goto :goto_1
.end method

.method public queryfile(Ljava/lang/String;)Ljava/lang/String;
    .locals 11
    .param p1, "fileid"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 96
    iget-object v1, p0, Lcom/aio/downloader/db/TypeDbUtilsBackup;->db:Lcom/aio/downloader/db/TypeDbBackup;

    invoke-virtual {v1}, Lcom/aio/downloader/db/TypeDbBackup;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 97
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v8, 0x0

    .line 98
    .local v8, "cursor":Landroid/database/Cursor;
    const-string v1, "backup"

    .line 99
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "package_name=\'"

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

    .line 98
    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 100
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 102
    .local v9, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/model/BackupModel;>;"
    if-eqz v8, :cond_0

    .line 103
    :goto_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-nez v1, :cond_1

    .line 113
    :cond_0
    if-nez v8, :cond_2

    .line 121
    :goto_1
    return-object v2

    .line 104
    :cond_1
    new-instance v10, Lcom/aio/downloader/model/BackupModel;

    invoke-direct {v10}, Lcom/aio/downloader/model/BackupModel;-><init>()V

    .line 106
    .local v10, "mDownloadMovieItem":Lcom/aio/downloader/model/BackupModel;
    const-string v1, "package_name"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 105
    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/aio/downloader/model/BackupModel;->setPackage_name(Ljava/lang/String;)V

    .line 109
    invoke-interface {v9, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 116
    .end local v10    # "mDownloadMovieItem":Lcom/aio/downloader/model/BackupModel;
    :cond_2
    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-nez v1, :cond_3

    .line 117
    iget-object v1, p0, Lcom/aio/downloader/db/TypeDbUtilsBackup;->db:Lcom/aio/downloader/db/TypeDbBackup;

    invoke-virtual {v1}, Lcom/aio/downloader/db/TypeDbBackup;->close()V

    goto :goto_1

    .line 121
    :cond_3
    const/4 v1, 0x0

    invoke-interface {v9, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/BackupModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/BackupModel;->getPackage_name()Ljava/lang/String;

    move-result-object v2

    goto :goto_1
.end method
