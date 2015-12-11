.class public Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "MySqliteOpenHelper.java"


# static fields
.field private static dbHelper:Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;


# instance fields
.field private aa:Ljava/lang/String;

.field private defaultSql:Ljava/lang/String;

.field private defaultTableName:Ljava/lang/String;

.field private mContext:Landroid/content/Context;

.field private obj:Ljava/lang/Object;


# direct methods
.method private constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "obj"    # Ljava/lang/Object;
    .param p4, "defaultTableName"    # Ljava/lang/String;
    .param p5, "defaultSql"    # Ljava/lang/String;

    .prologue
    .line 51
    const/4 v0, 0x0

    const/4 v1, 0x2

    invoke-direct {p0, p1, p2, v0, v1}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 125
    const-string v0, " ALTER TABLE downloadtask2 ADD COLUMN is_official text"

    iput-object v0, p0, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->aa:Ljava/lang/String;

    .line 52
    iput-object p1, p0, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->mContext:Landroid/content/Context;

    .line 53
    iput-object p3, p0, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->obj:Ljava/lang/Object;

    .line 54
    iput-object p4, p0, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->defaultTableName:Ljava/lang/String;

    .line 55
    iput-object p5, p0, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->defaultSql:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public static declared-synchronized create(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "obj"    # Ljava/lang/Object;
    .param p3, "defaultTableName"    # Ljava/lang/String;
    .param p4, "defaultSql"    # Ljava/lang/String;

    .prologue
    .line 68
    const-class v6, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;

    monitor-enter v6

    :try_start_0
    sget-object v0, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->dbHelper:Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;

    if-nez v0, :cond_0

    .line 69
    new-instance v0, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->dbHelper:Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;

    .line 72
    :cond_0
    sget-object v0, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->dbHelper:Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v6

    return-object v0

    .line 68
    :catchall_0
    move-exception v0

    monitor-exit v6

    throw v0
.end method

.method private isExistField(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 12
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "strTableName"    # Ljava/lang/String;
    .param p3, "strFieldName"    # Ljava/lang/String;

    .prologue
    const/4 v11, 0x0

    .line 161
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    .line 162
    .local v8, "builder":Ljava/lang/StringBuilder;
    const-string v0, "name = \'"

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 163
    const-string v1, "\' AND sql LIKE \'%"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "%\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 164
    const/4 v9, 0x0

    .line 166
    .local v9, "cursor":Landroid/database/Cursor;
    :try_start_0
    const-string v1, "sqlite_master"

    const/4 v2, 0x0

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    .line 167
    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p1

    .line 166
    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 168
    invoke-interface {v9}, Landroid/database/Cursor;->getCount()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-lez v0, :cond_1

    const/4 v0, 0x1

    .line 172
    :goto_0
    if-eqz v9, :cond_0

    .line 173
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 176
    :cond_0
    :goto_1
    return v0

    :cond_1
    move v0, v11

    .line 168
    goto :goto_0

    .line 169
    :catch_0
    move-exception v10

    .line 170
    .local v10, "e":Ljava/lang/Exception;
    :try_start_1
    invoke-virtual {v10}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 172
    if-eqz v9, :cond_2

    .line 173
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    :cond_2
    move v0, v11

    .line 176
    goto :goto_1

    .line 171
    .end local v10    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    .line 172
    if-eqz v9, :cond_3

    .line 173
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 175
    :cond_3
    throw v0
.end method


# virtual methods
.method public getDb()Landroid/database/sqlite/SQLiteDatabase;
    .locals 1

    .prologue
    .line 180
    invoke-virtual {p0}, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    return-object v0
.end method

.method public initDB(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 111
    iget-object v0, p0, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->defaultTableName:Ljava/lang/String;

    iget-object v1, p0, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->obj:Ljava/lang/Object;

    invoke-static {v0, p1, v1}, Lnet/tsz/afinal/UtilChen;->addTab(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/Object;)V

    .line 113
    return-void
.end method

.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 83
    iget-object v0, p0, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->defaultSql:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 87
    iget-object v0, p0, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->defaultSql:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 100
    :cond_0
    :goto_0
    return-void

    .line 91
    :cond_1
    iget-object v0, p0, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->obj:Ljava/lang/Object;

    if-eqz v0, :cond_0

    .line 93
    invoke-virtual {p0, p1}, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->initDB(Landroid/database/sqlite/SQLiteDatabase;)V

    goto :goto_0
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 2
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldversion"    # I
    .param p3, "newversion"    # I

    .prologue
    .line 140
    :try_start_0
    const-string v0, "downloadtask2"

    const-string v1, "is_official"

    invoke-direct {p0, p1, v0, v1}, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->isExistField(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 141
    iget-object v0, p0, Lnet/tsz/afinal/db/sqlite/MySqliteOpenHelper;->aa:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 147
    :cond_0
    :goto_0
    return-void

    .line 143
    :catch_0
    move-exception v0

    goto :goto_0
.end method
