.class public Lnet/tsz/afinal/FinalDb;
.super Ljava/lang/Object;
.source "FinalDb.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lnet/tsz/afinal/FinalDb$DaoConfig;,
        Lnet/tsz/afinal/FinalDb$DbUpdateListener;,
        Lnet/tsz/afinal/FinalDb$SqliteDbHelper;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "FinalDb"

.field private static daoMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lnet/tsz/afinal/FinalDb;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private config:Lnet/tsz/afinal/FinalDb$DaoConfig;

.field private db:Landroid/database/sqlite/SQLiteDatabase;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lnet/tsz/afinal/FinalDb;->daoMap:Ljava/util/HashMap;

    return-void
.end method

.method private constructor <init>(Lnet/tsz/afinal/FinalDb$DaoConfig;)V
    .locals 6
    .param p1, "config"    # Lnet/tsz/afinal/FinalDb$DaoConfig;

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    if-nez p1, :cond_0

    .line 49
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "daoConfig is null"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 50
    :cond_0
    invoke-virtual {p1}, Lnet/tsz/afinal/FinalDb$DaoConfig;->getContext()Landroid/content/Context;

    move-result-object v0

    if-nez v0, :cond_1

    .line 51
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "android context is null"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 52
    :cond_1
    new-instance v0, Lnet/tsz/afinal/FinalDb$SqliteDbHelper;

    invoke-virtual {p1}, Lnet/tsz/afinal/FinalDb$DaoConfig;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {p1}, Lnet/tsz/afinal/FinalDb$DaoConfig;->getDbName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Lnet/tsz/afinal/FinalDb$DaoConfig;->getDbVersion()I

    move-result v4

    invoke-virtual {p1}, Lnet/tsz/afinal/FinalDb$DaoConfig;->getDbUpdateListener()Lnet/tsz/afinal/FinalDb$DbUpdateListener;

    move-result-object v5

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lnet/tsz/afinal/FinalDb$SqliteDbHelper;-><init>(Lnet/tsz/afinal/FinalDb;Landroid/content/Context;Ljava/lang/String;ILnet/tsz/afinal/FinalDb$DbUpdateListener;)V

    invoke-virtual {v0}, Lnet/tsz/afinal/FinalDb$SqliteDbHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Lnet/tsz/afinal/FinalDb;->db:Landroid/database/sqlite/SQLiteDatabase;

    .line 53
    iput-object p1, p0, Lnet/tsz/afinal/FinalDb;->config:Lnet/tsz/afinal/FinalDb$DaoConfig;

    .line 54
    return-void
.end method

.method private checkTableExist(Ljava/lang/Class;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 542
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {p1}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v1

    invoke-direct {p0, v1}, Lnet/tsz/afinal/FinalDb;->tableIsExist(Lnet/tsz/afinal/db/table/TableInfo;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 543
    invoke-static {p1}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getCreatTableSQL(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    .line 544
    .local v0, "sql":Ljava/lang/String;
    invoke-direct {p0, v0}, Lnet/tsz/afinal/FinalDb;->debugSql(Ljava/lang/String;)V

    .line 545
    iget-object v1, p0, Lnet/tsz/afinal/FinalDb;->db:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 547
    .end local v0    # "sql":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public static create(Landroid/content/Context;)Lnet/tsz/afinal/FinalDb;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 71
    new-instance v0, Lnet/tsz/afinal/FinalDb$DaoConfig;

    invoke-direct {v0}, Lnet/tsz/afinal/FinalDb$DaoConfig;-><init>()V

    .line 72
    .local v0, "config":Lnet/tsz/afinal/FinalDb$DaoConfig;
    invoke-virtual {v0, p0}, Lnet/tsz/afinal/FinalDb$DaoConfig;->setContext(Landroid/content/Context;)V

    .line 74
    invoke-static {v0}, Lnet/tsz/afinal/FinalDb;->getInstance(Lnet/tsz/afinal/FinalDb$DaoConfig;)Lnet/tsz/afinal/FinalDb;

    move-result-object v1

    return-object v1
.end method

.method public static create(Landroid/content/Context;Ljava/lang/String;)Lnet/tsz/afinal/FinalDb;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "dbName"    # Ljava/lang/String;

    .prologue
    .line 101
    new-instance v0, Lnet/tsz/afinal/FinalDb$DaoConfig;

    invoke-direct {v0}, Lnet/tsz/afinal/FinalDb$DaoConfig;-><init>()V

    .line 102
    .local v0, "config":Lnet/tsz/afinal/FinalDb$DaoConfig;
    invoke-virtual {v0, p0}, Lnet/tsz/afinal/FinalDb$DaoConfig;->setContext(Landroid/content/Context;)V

    .line 103
    invoke-virtual {v0, p1}, Lnet/tsz/afinal/FinalDb$DaoConfig;->setDbName(Ljava/lang/String;)V

    .line 105
    invoke-static {v0}, Lnet/tsz/afinal/FinalDb;->getInstance(Lnet/tsz/afinal/FinalDb$DaoConfig;)Lnet/tsz/afinal/FinalDb;

    move-result-object v1

    return-object v1
.end method

.method public static create(Landroid/content/Context;Ljava/lang/String;Z)Lnet/tsz/afinal/FinalDb;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "dbName"    # Ljava/lang/String;
    .param p2, "isDebug"    # Z

    .prologue
    .line 115
    new-instance v0, Lnet/tsz/afinal/FinalDb$DaoConfig;

    invoke-direct {v0}, Lnet/tsz/afinal/FinalDb$DaoConfig;-><init>()V

    .line 116
    .local v0, "config":Lnet/tsz/afinal/FinalDb$DaoConfig;
    invoke-virtual {v0, p0}, Lnet/tsz/afinal/FinalDb$DaoConfig;->setContext(Landroid/content/Context;)V

    .line 117
    invoke-virtual {v0, p1}, Lnet/tsz/afinal/FinalDb$DaoConfig;->setDbName(Ljava/lang/String;)V

    .line 118
    invoke-virtual {v0, p2}, Lnet/tsz/afinal/FinalDb$DaoConfig;->setDebug(Z)V

    .line 119
    invoke-static {v0}, Lnet/tsz/afinal/FinalDb;->getInstance(Lnet/tsz/afinal/FinalDb$DaoConfig;)Lnet/tsz/afinal/FinalDb;

    move-result-object v1

    return-object v1
.end method

.method public static create(Landroid/content/Context;Ljava/lang/String;ZILnet/tsz/afinal/FinalDb$DbUpdateListener;)Lnet/tsz/afinal/FinalDb;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "dbName"    # Ljava/lang/String;
    .param p2, "isDebug"    # Z
    .param p3, "dbVersion"    # I
    .param p4, "dbUpdateListener"    # Lnet/tsz/afinal/FinalDb$DbUpdateListener;

    .prologue
    .line 132
    new-instance v0, Lnet/tsz/afinal/FinalDb$DaoConfig;

    invoke-direct {v0}, Lnet/tsz/afinal/FinalDb$DaoConfig;-><init>()V

    .line 133
    .local v0, "config":Lnet/tsz/afinal/FinalDb$DaoConfig;
    invoke-virtual {v0, p0}, Lnet/tsz/afinal/FinalDb$DaoConfig;->setContext(Landroid/content/Context;)V

    .line 134
    invoke-virtual {v0, p1}, Lnet/tsz/afinal/FinalDb$DaoConfig;->setDbName(Ljava/lang/String;)V

    .line 135
    invoke-virtual {v0, p2}, Lnet/tsz/afinal/FinalDb$DaoConfig;->setDebug(Z)V

    .line 136
    invoke-virtual {v0, p3}, Lnet/tsz/afinal/FinalDb$DaoConfig;->setDbVersion(I)V

    .line 137
    invoke-virtual {v0, p4}, Lnet/tsz/afinal/FinalDb$DaoConfig;->setDbUpdateListener(Lnet/tsz/afinal/FinalDb$DbUpdateListener;)V

    .line 138
    invoke-static {v0}, Lnet/tsz/afinal/FinalDb;->getInstance(Lnet/tsz/afinal/FinalDb$DaoConfig;)Lnet/tsz/afinal/FinalDb;

    move-result-object v1

    return-object v1
.end method

.method public static create(Landroid/content/Context;Z)Lnet/tsz/afinal/FinalDb;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "isDebug"    # Z

    .prologue
    .line 88
    new-instance v0, Lnet/tsz/afinal/FinalDb$DaoConfig;

    invoke-direct {v0}, Lnet/tsz/afinal/FinalDb$DaoConfig;-><init>()V

    .line 89
    .local v0, "config":Lnet/tsz/afinal/FinalDb$DaoConfig;
    invoke-virtual {v0, p0}, Lnet/tsz/afinal/FinalDb$DaoConfig;->setContext(Landroid/content/Context;)V

    .line 90
    invoke-virtual {v0, p1}, Lnet/tsz/afinal/FinalDb$DaoConfig;->setDebug(Z)V

    .line 91
    invoke-static {v0}, Lnet/tsz/afinal/FinalDb;->getInstance(Lnet/tsz/afinal/FinalDb$DaoConfig;)Lnet/tsz/afinal/FinalDb;

    move-result-object v1

    return-object v1
.end method

.method public static create(Lnet/tsz/afinal/FinalDb$DaoConfig;)Lnet/tsz/afinal/FinalDb;
    .locals 1
    .param p0, "daoConfig"    # Lnet/tsz/afinal/FinalDb$DaoConfig;

    .prologue
    .line 147
    invoke-static {p0}, Lnet/tsz/afinal/FinalDb;->getInstance(Lnet/tsz/afinal/FinalDb$DaoConfig;)Lnet/tsz/afinal/FinalDb;

    move-result-object v0

    return-object v0
.end method

.method private debugSql(Ljava/lang/String;)V
    .locals 3
    .param p1, "sql"    # Ljava/lang/String;

    .prologue
    .line 580
    iget-object v0, p0, Lnet/tsz/afinal/FinalDb;->config:Lnet/tsz/afinal/FinalDb$DaoConfig;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lnet/tsz/afinal/FinalDb;->config:Lnet/tsz/afinal/FinalDb$DaoConfig;

    invoke-virtual {v0}, Lnet/tsz/afinal/FinalDb$DaoConfig;->isDebug()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 581
    const-string v0, "Debug SQL"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, ">>>>>>  "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 582
    :cond_0
    return-void
.end method

.method private exeSqlInfo(Lnet/tsz/afinal/db/sqlite/SqlInfo;)V
    .locals 3
    .param p1, "sqlInfo"    # Lnet/tsz/afinal/db/sqlite/SqlInfo;

    .prologue
    .line 253
    if-eqz p1, :cond_0

    .line 254
    invoke-virtual {p1}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->getSql()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lnet/tsz/afinal/FinalDb;->debugSql(Ljava/lang/String;)V

    .line 255
    iget-object v0, p0, Lnet/tsz/afinal/FinalDb;->db:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p1}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->getSql()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->getBindArgsAsArray()[Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 259
    :goto_0
    return-void

    .line 257
    :cond_0
    const-string v0, "FinalDb"

    const-string v1, "sava error:sqlInfo is null"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private findAllBySql(Ljava/lang/Class;Ljava/lang/String;)Ljava/util/List;
    .locals 6
    .param p2, "strSQL"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const/4 v4, 0x0

    .line 482
    invoke-direct {p0, p1}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 483
    invoke-direct {p0, p2}, Lnet/tsz/afinal/FinalDb;->debugSql(Ljava/lang/String;)V

    .line 484
    iget-object v5, p0, Lnet/tsz/afinal/FinalDb;->db:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v5, p2, v4}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 486
    .local v0, "cursor":Landroid/database/Cursor;
    :try_start_0
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 487
    .local v2, "list":Ljava/util/List;, "Ljava/util/List<TT;>;"
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v5

    if-nez v5, :cond_1

    .line 495
    if-eqz v0, :cond_0

    .line 496
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 497
    :cond_0
    const/4 v0, 0x0

    .line 499
    .end local v2    # "list":Ljava/util/List;, "Ljava/util/List<TT;>;"
    :goto_1
    return-object v2

    .line 488
    .restart local v2    # "list":Ljava/util/List;, "Ljava/util/List<TT;>;"
    :cond_1
    :try_start_1
    invoke-static {v0, p1}, Lnet/tsz/afinal/db/sqlite/CursorUtils;->getEntity(Landroid/database/Cursor;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    .line 489
    .local v3, "t":Ljava/lang/Object;, "TT;"
    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 492
    .end local v2    # "list":Ljava/util/List;, "Ljava/util/List<TT;>;"
    .end local v3    # "t":Ljava/lang/Object;, "TT;"
    :catch_0
    move-exception v1

    .line 493
    .local v1, "e":Ljava/lang/Exception;
    :try_start_2
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 495
    if-eqz v0, :cond_2

    .line 496
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 497
    :cond_2
    const/4 v0, 0x0

    move-object v2, v4

    .line 499
    goto :goto_1

    .line 494
    .end local v1    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v4

    .line 495
    if-eqz v0, :cond_3

    .line 496
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 497
    :cond_3
    const/4 v0, 0x0

    .line 498
    throw v4
.end method

.method private static declared-synchronized getInstance(Lnet/tsz/afinal/FinalDb$DaoConfig;)Lnet/tsz/afinal/FinalDb;
    .locals 4
    .param p0, "daoConfig"    # Lnet/tsz/afinal/FinalDb$DaoConfig;

    .prologue
    .line 58
    const-class v2, Lnet/tsz/afinal/FinalDb;

    monitor-enter v2

    :try_start_0
    sget-object v1, Lnet/tsz/afinal/FinalDb;->daoMap:Ljava/util/HashMap;

    invoke-virtual {p0}, Lnet/tsz/afinal/FinalDb$DaoConfig;->getDbName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lnet/tsz/afinal/FinalDb;

    .line 59
    .local v0, "dao":Lnet/tsz/afinal/FinalDb;
    if-nez v0, :cond_0

    .line 60
    new-instance v0, Lnet/tsz/afinal/FinalDb;

    .end local v0    # "dao":Lnet/tsz/afinal/FinalDb;
    invoke-direct {v0, p0}, Lnet/tsz/afinal/FinalDb;-><init>(Lnet/tsz/afinal/FinalDb$DaoConfig;)V

    .line 61
    .restart local v0    # "dao":Lnet/tsz/afinal/FinalDb;
    sget-object v1, Lnet/tsz/afinal/FinalDb;->daoMap:Ljava/util/HashMap;

    invoke-virtual {p0}, Lnet/tsz/afinal/FinalDb$DaoConfig;->getDbName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 63
    :cond_0
    monitor-exit v2

    return-object v0

    .line 58
    .end local v0    # "dao":Lnet/tsz/afinal/FinalDb;
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method private insertContentValues(Ljava/util/List;Landroid/content/ContentValues;)V
    .locals 4
    .param p2, "cv"    # Landroid/content/ContentValues;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lnet/tsz/afinal/db/table/KeyValue;",
            ">;",
            "Landroid/content/ContentValues;",
            ")V"
        }
    .end annotation

    .prologue
    .line 191
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<Lnet/tsz/afinal/db/table/KeyValue;>;"
    if-eqz p1, :cond_1

    if-eqz p2, :cond_1

    .line 192
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_0

    .line 199
    :goto_1
    return-void

    .line 192
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lnet/tsz/afinal/db/table/KeyValue;

    .line 193
    .local v0, "kv":Lnet/tsz/afinal/db/table/KeyValue;
    invoke-virtual {v0}, Lnet/tsz/afinal/db/table/KeyValue;->getKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Lnet/tsz/afinal/db/table/KeyValue;->getValue()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 196
    .end local v0    # "kv":Lnet/tsz/afinal/db/table/KeyValue;
    :cond_1
    const-string v1, "FinalDb"

    const-string v2, "insertContentValues: List<KeyValue> is empty or ContentValues is empty!"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method

.method private tableIsExist(Lnet/tsz/afinal/db/table/TableInfo;)Z
    .locals 8
    .param p1, "table"    # Lnet/tsz/afinal/db/table/TableInfo;

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 551
    invoke-virtual {p1}, Lnet/tsz/afinal/db/table/TableInfo;->isCheckDatabese()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 575
    :goto_0
    return v4

    .line 554
    :cond_0
    const/4 v1, 0x0

    .line 556
    .local v1, "cursor":Landroid/database/Cursor;
    :try_start_0
    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "SELECT COUNT(*) AS c FROM sqlite_master WHERE type =\'table\' AND name =\'"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lnet/tsz/afinal/db/table/TableInfo;->getTableName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\' "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 557
    .local v3, "sql":Ljava/lang/String;
    invoke-direct {p0, v3}, Lnet/tsz/afinal/FinalDb;->debugSql(Ljava/lang/String;)V

    .line 558
    iget-object v6, p0, Lnet/tsz/afinal/FinalDb;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v7, 0x0

    invoke-virtual {v6, v3, v7}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 559
    if-eqz v1, :cond_4

    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v6

    if-eqz v6, :cond_4

    .line 560
    const/4 v6, 0x0

    invoke-interface {v1, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 561
    .local v0, "count":I
    if-lez v0, :cond_4

    .line 562
    const/4 v6, 0x1

    invoke-virtual {p1, v6}, Lnet/tsz/afinal/db/table/TableInfo;->setCheckDatabese(Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 570
    if-eqz v1, :cond_1

    .line 571
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 572
    :cond_1
    const/4 v1, 0x0

    .line 563
    goto :goto_0

    .line 567
    .end local v0    # "count":I
    .end local v3    # "sql":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 568
    .local v2, "e":Ljava/lang/Exception;
    :try_start_1
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 570
    if-eqz v1, :cond_2

    .line 571
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 572
    :cond_2
    const/4 v1, 0x0

    .end local v2    # "e":Ljava/lang/Exception;
    :goto_1
    move v4, v5

    .line 575
    goto :goto_0

    .line 569
    :catchall_0
    move-exception v4

    .line 570
    if-eqz v1, :cond_3

    .line 571
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 572
    :cond_3
    const/4 v1, 0x0

    .line 573
    throw v4

    .line 570
    .restart local v3    # "sql":Ljava/lang/String;
    :cond_4
    if-eqz v1, :cond_5

    .line 571
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 572
    :cond_5
    const/4 v1, 0x0

    goto :goto_1
.end method


# virtual methods
.method public delete(Ljava/lang/Object;)V
    .locals 1
    .param p1, "entity"    # Ljava/lang/Object;

    .prologue
    .line 225
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-direct {p0, v0}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 226
    invoke-static {p1}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->buildDeleteSql(Ljava/lang/Object;)Lnet/tsz/afinal/db/sqlite/SqlInfo;

    move-result-object v0

    invoke-direct {p0, v0}, Lnet/tsz/afinal/FinalDb;->exeSqlInfo(Lnet/tsz/afinal/db/sqlite/SqlInfo;)V

    .line 227
    return-void
.end method

.method public deleteById(Ljava/lang/Class;Ljava/lang/Object;)V
    .locals 1
    .param p2, "id"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    .prologue
    .line 235
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0, p1}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 236
    invoke-static {p1, p2}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->buildDeleteSql(Ljava/lang/Class;Ljava/lang/Object;)Lnet/tsz/afinal/db/sqlite/SqlInfo;

    move-result-object v0

    invoke-direct {p0, v0}, Lnet/tsz/afinal/FinalDb;->exeSqlInfo(Lnet/tsz/afinal/db/sqlite/SqlInfo;)V

    .line 237
    return-void
.end method

.method public deleteByWhere(Ljava/lang/Class;Ljava/lang/String;)V
    .locals 2
    .param p2, "strWhere"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 245
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0, p1}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 246
    invoke-static {p1, p2}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->buildDeleteSql(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 247
    .local v0, "sql":Ljava/lang/String;
    invoke-direct {p0, v0}, Lnet/tsz/afinal/FinalDb;->debugSql(Ljava/lang/String;)V

    .line 248
    iget-object v1, p0, Lnet/tsz/afinal/FinalDb;->db:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 249
    return-void
.end method

.method public findAll(Ljava/lang/Class;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;)",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 441
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-direct {p0, p1}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 442
    invoke-static {p1}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getSelectSQL(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lnet/tsz/afinal/FinalDb;->findAllBySql(Ljava/lang/Class;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public findAll(Ljava/lang/Class;Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p2, "orderBy"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 451
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-direct {p0, p1}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 452
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {p1}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getSelectSQL(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, " ORDER BY "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " DESC"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lnet/tsz/afinal/FinalDb;->findAllBySql(Ljava/lang/Class;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public findAllByWhere(Ljava/lang/Class;Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p2, "strWhere"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 461
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-direct {p0, p1}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 462
    invoke-static {p1, p2}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getSelectSQLByWhere(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lnet/tsz/afinal/FinalDb;->findAllBySql(Ljava/lang/Class;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public findAllByWhere(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p2, "strWhere"    # Ljava/lang/String;
    .param p3, "orderBy"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 472
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-direct {p0, p1}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 473
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {p1, p2}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getSelectSQLByWhere(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, " ORDER BY \'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\' DESC"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lnet/tsz/afinal/FinalDb;->findAllBySql(Ljava/lang/Class;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public findById(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 6
    .param p1, "id"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Object;",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    .prologue
    .line 267
    .local p2, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-direct {p0, p2}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 268
    invoke-static {p2, p1}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getSelectSqlAsSqlInfo(Ljava/lang/Class;Ljava/lang/Object;)Lnet/tsz/afinal/db/sqlite/SqlInfo;

    move-result-object v2

    .line 269
    .local v2, "sqlInfo":Lnet/tsz/afinal/db/sqlite/SqlInfo;
    if-eqz v2, :cond_0

    .line 270
    invoke-virtual {v2}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->getSql()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v3}, Lnet/tsz/afinal/FinalDb;->debugSql(Ljava/lang/String;)V

    .line 271
    iget-object v3, p0, Lnet/tsz/afinal/FinalDb;->db:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v2}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->getSql()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2}, Lnet/tsz/afinal/db/sqlite/SqlInfo;->getBindArgsAsStringArray()[Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 273
    .local v0, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 274
    invoke-static {v0, p2}, Lnet/tsz/afinal/db/sqlite/CursorUtils;->getEntity(Landroid/database/Cursor;Ljava/lang/Class;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v3

    .line 279
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 282
    .end local v0    # "cursor":Landroid/database/Cursor;
    :goto_0
    return-object v3

    .line 276
    .restart local v0    # "cursor":Landroid/database/Cursor;
    :catch_0
    move-exception v1

    .line 277
    .local v1, "e":Ljava/lang/Exception;
    :try_start_1
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 279
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 282
    .end local v0    # "cursor":Landroid/database/Cursor;
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_0
    :goto_1
    const/4 v3, 0x0

    goto :goto_0

    .line 278
    .restart local v0    # "cursor":Landroid/database/Cursor;
    :catchall_0
    move-exception v3

    .line 279
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 280
    throw v3

    .line 279
    :cond_1
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_1
.end method

.method public findDbModelBySQL(Ljava/lang/String;)Lnet/tsz/afinal/db/sqlite/DbModel;
    .locals 4
    .param p1, "strSQL"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 509
    invoke-direct {p0, p1}, Lnet/tsz/afinal/FinalDb;->debugSql(Ljava/lang/String;)V

    .line 510
    iget-object v3, p0, Lnet/tsz/afinal/FinalDb;->db:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3, p1, v2}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 512
    .local v0, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 513
    invoke-static {v0}, Lnet/tsz/afinal/db/sqlite/CursorUtils;->getDbModel(Landroid/database/Cursor;)Lnet/tsz/afinal/db/sqlite/DbModel;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v2

    .line 518
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 520
    :goto_0
    return-object v2

    .line 515
    :catch_0
    move-exception v1

    .line 516
    .local v1, "e":Ljava/lang/Exception;
    :try_start_1
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 518
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 517
    .end local v1    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v2

    .line 518
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 519
    throw v2

    .line 518
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_0
.end method

.method public findDbModelListBySQL(Ljava/lang/String;)Ljava/util/List;
    .locals 5
    .param p1, "strSQL"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lnet/tsz/afinal/db/sqlite/DbModel;",
            ">;"
        }
    .end annotation

    .prologue
    .line 524
    invoke-direct {p0, p1}, Lnet/tsz/afinal/FinalDb;->debugSql(Ljava/lang/String;)V

    .line 525
    iget-object v3, p0, Lnet/tsz/afinal/FinalDb;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v4, 0x0

    invoke-virtual {v3, p1, v4}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 526
    .local v0, "cursor":Landroid/database/Cursor;
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 528
    .local v1, "dbModelList":Ljava/util/List;, "Ljava/util/List<Lnet/tsz/afinal/db/sqlite/DbModel;>;"
    :goto_0
    :try_start_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v3

    if-nez v3, :cond_0

    .line 534
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 536
    :goto_1
    return-object v1

    .line 529
    :cond_0
    :try_start_1
    invoke-static {v0}, Lnet/tsz/afinal/db/sqlite/CursorUtils;->getDbModel(Landroid/database/Cursor;)Lnet/tsz/afinal/db/sqlite/DbModel;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 531
    :catch_0
    move-exception v2

    .line 532
    .local v2, "e":Ljava/lang/Exception;
    :try_start_2
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 534
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 533
    .end local v2    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v3

    .line 534
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 535
    throw v3
.end method

.method public findWithManyToOneById(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 11
    .param p1, "id"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Object;",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    .prologue
    .line 291
    .local p2, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-direct {p0, p2}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 292
    invoke-static {p2, p1}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getSelectSQL(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    .line 293
    .local v7, "sql":Ljava/lang/String;
    invoke-direct {p0, v7}, Lnet/tsz/afinal/FinalDb;->debugSql(Ljava/lang/String;)V

    .line 294
    invoke-virtual {p0, v7}, Lnet/tsz/afinal/FinalDb;->findDbModelBySQL(Ljava/lang/String;)Lnet/tsz/afinal/db/sqlite/DbModel;

    move-result-object v0

    .line 295
    .local v0, "dbModel":Lnet/tsz/afinal/db/sqlite/DbModel;
    if-eqz v0, :cond_3

    .line 296
    invoke-static {v0, p2}, Lnet/tsz/afinal/db/sqlite/CursorUtils;->dbModel2Entity(Lnet/tsz/afinal/db/sqlite/DbModel;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    .line 297
    .local v2, "entity":Ljava/lang/Object;, "TT;"
    if-eqz v2, :cond_1

    .line 299
    :try_start_0
    invoke-static {p2}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v8

    iget-object v8, v8, Lnet/tsz/afinal/db/table/TableInfo;->manyToOneMap:Ljava/util/HashMap;

    invoke-virtual {v8}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v5

    .line 300
    .local v5, "manys":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    invoke-interface {v5}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_0
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-nez v9, :cond_2

    .line 317
    .end local v2    # "entity":Ljava/lang/Object;, "TT;"
    .end local v5    # "manys":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    :cond_1
    :goto_1
    return-object v2

    .line 300
    .restart local v2    # "entity":Ljava/lang/Object;, "TT;"
    .restart local v5    # "manys":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    :cond_2
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lnet/tsz/afinal/db/table/ManyToOne;

    .line 301
    .local v3, "many":Lnet/tsz/afinal/db/table/ManyToOne;
    invoke-virtual {v3}, Lnet/tsz/afinal/db/table/ManyToOne;->getColumn()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9}, Lnet/tsz/afinal/db/sqlite/DbModel;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    .line 302
    .local v6, "obj":Ljava/lang/Object;
    if-eqz v6, :cond_0

    .line 304
    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v3}, Lnet/tsz/afinal/db/table/ManyToOne;->getDataType()Ljava/lang/Class;

    move-result-object v10

    invoke-virtual {p0, v9, v10}, Lnet/tsz/afinal/FinalDb;->findById(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    .line 305
    .local v4, "manyEntity":Ljava/lang/Object;, "TT;"
    if-eqz v4, :cond_0

    .line 306
    invoke-virtual {v3, v2, v4}, Lnet/tsz/afinal/db/table/ManyToOne;->setValue(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 310
    .end local v3    # "many":Lnet/tsz/afinal/db/table/ManyToOne;
    .end local v4    # "manyEntity":Ljava/lang/Object;, "TT;"
    .end local v5    # "manys":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    .end local v6    # "obj":Ljava/lang/Object;
    :catch_0
    move-exception v1

    .line 311
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 317
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v2    # "entity":Ljava/lang/Object;, "TT;"
    :cond_3
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public varargs findWithManyToOneById(Ljava/lang/Object;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/Object;
    .locals 14
    .param p1, "id"    # Ljava/lang/Object;
    .param p3, "findClass"    # [Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Object;",
            "Ljava/lang/Class",
            "<TT;>;[",
            "Ljava/lang/Class",
            "<*>;)TT;"
        }
    .end annotation

    .prologue
    .line 327
    .local p2, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    move-object/from16 v0, p2

    invoke-direct {p0, v0}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 328
    move-object/from16 v0, p2

    invoke-static {v0, p1}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getSelectSQL(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    .line 329
    .local v9, "sql":Ljava/lang/String;
    invoke-direct {p0, v9}, Lnet/tsz/afinal/FinalDb;->debugSql(Ljava/lang/String;)V

    .line 330
    invoke-virtual {p0, v9}, Lnet/tsz/afinal/FinalDb;->findDbModelBySQL(Ljava/lang/String;)Lnet/tsz/afinal/db/sqlite/DbModel;

    move-result-object v1

    .line 331
    .local v1, "dbModel":Lnet/tsz/afinal/db/sqlite/DbModel;
    if-eqz v1, :cond_5

    .line 332
    move-object/from16 v0, p2

    invoke-static {v1, v0}, Lnet/tsz/afinal/db/sqlite/CursorUtils;->dbModel2Entity(Lnet/tsz/afinal/db/sqlite/DbModel;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    .line 333
    .local v3, "entity":Ljava/lang/Object;, "TT;"
    if-eqz v3, :cond_1

    .line 335
    :try_start_0
    invoke-static/range {p2 .. p2}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v10

    iget-object v10, v10, Lnet/tsz/afinal/db/table/TableInfo;->manyToOneMap:Ljava/util/HashMap;

    invoke-virtual {v10}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v8

    .line 336
    .local v8, "manys":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    invoke-interface {v8}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :cond_0
    :goto_0
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-nez v10, :cond_2

    .line 359
    .end local v3    # "entity":Ljava/lang/Object;, "TT;"
    .end local v8    # "manys":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    :cond_1
    :goto_1
    return-object v3

    .line 336
    .restart local v3    # "entity":Ljava/lang/Object;, "TT;"
    .restart local v8    # "manys":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    :cond_2
    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lnet/tsz/afinal/db/table/ManyToOne;

    .line 337
    .local v6, "many":Lnet/tsz/afinal/db/table/ManyToOne;
    const/4 v4, 0x0

    .line 338
    .local v4, "isFind":Z
    move-object/from16 v0, p3

    array-length v12, v0

    const/4 v10, 0x0

    :goto_2
    if-lt v10, v12, :cond_3

    .line 345
    :goto_3
    if-eqz v4, :cond_0

    .line 347
    invoke-virtual {v6}, Lnet/tsz/afinal/db/table/ManyToOne;->getColumn()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v10}, Lnet/tsz/afinal/db/sqlite/DbModel;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v10

    invoke-virtual {v6}, Lnet/tsz/afinal/db/table/ManyToOne;->getDataType()Ljava/lang/Class;

    move-result-object v12

    invoke-virtual {p0, v10, v12}, Lnet/tsz/afinal/FinalDb;->findById(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v7

    .line 348
    .local v7, "manyEntity":Ljava/lang/Object;, "TT;"
    if-eqz v7, :cond_0

    .line 349
    invoke-virtual {v6, v3, v7}, Lnet/tsz/afinal/db/table/ManyToOne;->setValue(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 353
    .end local v4    # "isFind":Z
    .end local v6    # "many":Lnet/tsz/afinal/db/table/ManyToOne;
    .end local v7    # "manyEntity":Ljava/lang/Object;, "TT;"
    .end local v8    # "manys":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    :catch_0
    move-exception v2

    .line 354
    .local v2, "e":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 338
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v4    # "isFind":Z
    .restart local v6    # "many":Lnet/tsz/afinal/db/table/ManyToOne;
    .restart local v8    # "manys":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    :cond_3
    :try_start_1
    aget-object v5, p3, v10

    .line 339
    .local v5, "mClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v6}, Lnet/tsz/afinal/db/table/ManyToOne;->getManyClass()Ljava/lang/Class;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v13

    if-ne v13, v5, :cond_4

    .line 340
    const/4 v4, 0x1

    .line 341
    goto :goto_3

    .line 338
    :cond_4
    add-int/lit8 v10, v10, 0x1

    goto :goto_2

    .line 359
    .end local v3    # "entity":Ljava/lang/Object;, "TT;"
    .end local v4    # "isFind":Z
    .end local v5    # "mClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v6    # "many":Lnet/tsz/afinal/db/table/ManyToOne;
    .end local v8    # "manys":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/ManyToOne;>;"
    :cond_5
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public findWithOneToManyById(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 11
    .param p1, "id"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Object;",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    .prologue
    .line 369
    .local p2, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-direct {p0, p2}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 370
    invoke-static {p2, p1}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getSelectSQL(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 371
    .local v6, "sql":Ljava/lang/String;
    invoke-direct {p0, v6}, Lnet/tsz/afinal/FinalDb;->debugSql(Ljava/lang/String;)V

    .line 372
    invoke-virtual {p0, v6}, Lnet/tsz/afinal/FinalDb;->findDbModelBySQL(Ljava/lang/String;)Lnet/tsz/afinal/db/sqlite/DbModel;

    move-result-object v0

    .line 373
    .local v0, "dbModel":Lnet/tsz/afinal/db/sqlite/DbModel;
    if-eqz v0, :cond_3

    .line 374
    invoke-static {v0, p2}, Lnet/tsz/afinal/db/sqlite/CursorUtils;->dbModel2Entity(Lnet/tsz/afinal/db/sqlite/DbModel;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    .line 375
    .local v2, "entity":Ljava/lang/Object;, "TT;"
    if-eqz v2, :cond_1

    .line 377
    :try_start_0
    invoke-static {p2}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v7

    iget-object v7, v7, Lnet/tsz/afinal/db/table/TableInfo;->oneToManyMap:Ljava/util/HashMap;

    invoke-virtual {v7}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v5

    .line 378
    .local v5, "ones":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/OneToMany;>;"
    invoke-interface {v5}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_0
    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-nez v8, :cond_2

    .line 391
    .end local v2    # "entity":Ljava/lang/Object;, "TT;"
    .end local v5    # "ones":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/OneToMany;>;"
    :cond_1
    :goto_1
    return-object v2

    .line 378
    .restart local v2    # "entity":Ljava/lang/Object;, "TT;"
    .restart local v5    # "ones":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/OneToMany;>;"
    :cond_2
    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lnet/tsz/afinal/db/table/OneToMany;

    .line 379
    .local v4, "one":Lnet/tsz/afinal/db/table/OneToMany;
    invoke-virtual {v4}, Lnet/tsz/afinal/db/table/OneToMany;->getOneClass()Ljava/lang/Class;

    move-result-object v8

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Lnet/tsz/afinal/db/table/OneToMany;->getColumn()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, "="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {p0, v8, v9}, Lnet/tsz/afinal/FinalDb;->findAllByWhere(Ljava/lang/Class;Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    .line 380
    .local v3, "list":Ljava/util/List;, "Ljava/util/List<*>;"
    if-eqz v3, :cond_0

    .line 381
    invoke-virtual {v4, v2, v3}, Lnet/tsz/afinal/db/table/OneToMany;->setValue(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 384
    .end local v3    # "list":Ljava/util/List;, "Ljava/util/List<*>;"
    .end local v4    # "one":Lnet/tsz/afinal/db/table/OneToMany;
    .end local v5    # "ones":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/OneToMany;>;"
    :catch_0
    move-exception v1

    .line 385
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 391
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v2    # "entity":Ljava/lang/Object;, "TT;"
    :cond_3
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public varargs findWithOneToManyById(Ljava/lang/Object;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/Object;
    .locals 16
    .param p1, "id"    # Ljava/lang/Object;
    .param p3, "findClass"    # [Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Object;",
            "Ljava/lang/Class",
            "<TT;>;[",
            "Ljava/lang/Class",
            "<*>;)TT;"
        }
    .end annotation

    .prologue
    .line 401
    .local p2, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v1}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 402
    move-object/from16 v0, p2

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getSelectSQL(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    .line 403
    .local v10, "sql":Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-direct {v0, v10}, Lnet/tsz/afinal/FinalDb;->debugSql(Ljava/lang/String;)V

    .line 404
    move-object/from16 v0, p0

    invoke-virtual {v0, v10}, Lnet/tsz/afinal/FinalDb;->findDbModelBySQL(Ljava/lang/String;)Lnet/tsz/afinal/db/sqlite/DbModel;

    move-result-object v2

    .line 405
    .local v2, "dbModel":Lnet/tsz/afinal/db/sqlite/DbModel;
    if-eqz v2, :cond_5

    .line 406
    move-object/from16 v0, p2

    invoke-static {v2, v0}, Lnet/tsz/afinal/db/sqlite/CursorUtils;->dbModel2Entity(Lnet/tsz/afinal/db/sqlite/DbModel;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    .line 407
    .local v4, "entity":Ljava/lang/Object;, "TT;"
    if-eqz v4, :cond_1

    .line 409
    :try_start_0
    invoke-static/range {p2 .. p2}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v11

    iget-object v11, v11, Lnet/tsz/afinal/db/table/TableInfo;->oneToManyMap:Ljava/util/HashMap;

    invoke-virtual {v11}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v9

    .line 410
    .local v9, "ones":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/OneToMany;>;"
    invoke-interface {v9}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v12

    :cond_0
    :goto_0
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-nez v11, :cond_2

    .line 433
    .end local v4    # "entity":Ljava/lang/Object;, "TT;"
    .end local v9    # "ones":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/OneToMany;>;"
    :cond_1
    :goto_1
    return-object v4

    .line 410
    .restart local v4    # "entity":Ljava/lang/Object;, "TT;"
    .restart local v9    # "ones":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/OneToMany;>;"
    :cond_2
    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lnet/tsz/afinal/db/table/OneToMany;

    .line 411
    .local v8, "one":Lnet/tsz/afinal/db/table/OneToMany;
    const/4 v5, 0x0

    .line 412
    .local v5, "isFind":Z
    move-object/from16 v0, p3

    array-length v13, v0

    const/4 v11, 0x0

    :goto_2
    if-lt v11, v13, :cond_3

    .line 419
    :goto_3
    if-eqz v5, :cond_0

    .line 420
    invoke-virtual {v8}, Lnet/tsz/afinal/db/table/OneToMany;->getOneClass()Ljava/lang/Class;

    move-result-object v11

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-virtual {v8}, Lnet/tsz/afinal/db/table/OneToMany;->getColumn()Ljava/lang/String;

    move-result-object v14

    invoke-static {v14}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v14

    invoke-direct {v13, v14}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v14, "="

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    move-object/from16 v0, p1

    invoke-virtual {v13, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, p0

    invoke-virtual {v0, v11, v13}, Lnet/tsz/afinal/FinalDb;->findAllByWhere(Ljava/lang/Class;Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 421
    .local v6, "list":Ljava/util/List;, "Ljava/util/List<*>;"
    if-eqz v6, :cond_0

    .line 422
    invoke-virtual {v8, v4, v6}, Lnet/tsz/afinal/db/table/OneToMany;->setValue(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 426
    .end local v5    # "isFind":Z
    .end local v6    # "list":Ljava/util/List;, "Ljava/util/List<*>;"
    .end local v8    # "one":Lnet/tsz/afinal/db/table/OneToMany;
    .end local v9    # "ones":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/OneToMany;>;"
    :catch_0
    move-exception v3

    .line 427
    .local v3, "e":Ljava/lang/Exception;
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 412
    .end local v3    # "e":Ljava/lang/Exception;
    .restart local v5    # "isFind":Z
    .restart local v8    # "one":Lnet/tsz/afinal/db/table/OneToMany;
    .restart local v9    # "ones":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/OneToMany;>;"
    :cond_3
    :try_start_1
    aget-object v7, p3, v11

    .line 413
    .local v7, "mClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v8}, Lnet/tsz/afinal/db/table/OneToMany;->getOneClass()Ljava/lang/Class;

    move-result-object v14

    invoke-virtual {v7}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result v14

    if-eqz v14, :cond_4

    .line 414
    const/4 v5, 0x1

    .line 415
    goto :goto_3

    .line 412
    :cond_4
    add-int/lit8 v11, v11, 0x1

    goto :goto_2

    .line 433
    .end local v4    # "entity":Ljava/lang/Object;, "TT;"
    .end local v5    # "isFind":Z
    .end local v7    # "mClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v8    # "one":Lnet/tsz/afinal/db/table/OneToMany;
    .end local v9    # "ones":Ljava/util/Collection;, "Ljava/util/Collection<Lnet/tsz/afinal/db/table/OneToMany;>;"
    :cond_5
    const/4 v4, 0x0

    goto :goto_1
.end method

.method public save(Ljava/lang/Object;)V
    .locals 1
    .param p1, "entity"    # Ljava/lang/Object;

    .prologue
    .line 157
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-direct {p0, v0}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 158
    invoke-static {p1}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->buildInsertSql(Ljava/lang/Object;)Lnet/tsz/afinal/db/sqlite/SqlInfo;

    move-result-object v0

    invoke-direct {p0, v0}, Lnet/tsz/afinal/FinalDb;->exeSqlInfo(Lnet/tsz/afinal/db/sqlite/SqlInfo;)V

    .line 159
    return-void
.end method

.method public saveBindId(Ljava/lang/Object;)Z
    .locals 9
    .param p1, "entity"    # Ljava/lang/Object;

    .prologue
    const/4 v4, 0x0

    .line 170
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-direct {p0, v5}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 171
    invoke-static {p1}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getSaveKeyValueListByEntity(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    .line 172
    .local v1, "entityKvList":Ljava/util/List;, "Ljava/util/List<Lnet/tsz/afinal/db/table/KeyValue;>;"
    if-eqz v1, :cond_0

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v5

    if-lez v5, :cond_0

    .line 173
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-static {v5}, Lnet/tsz/afinal/db/table/TableInfo;->get(Ljava/lang/Class;)Lnet/tsz/afinal/db/table/TableInfo;

    move-result-object v3

    .line 174
    .local v3, "tf":Lnet/tsz/afinal/db/table/TableInfo;
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 175
    .local v0, "cv":Landroid/content/ContentValues;
    invoke-direct {p0, v1, v0}, Lnet/tsz/afinal/FinalDb;->insertContentValues(Ljava/util/List;Landroid/content/ContentValues;)V

    .line 176
    iget-object v5, p0, Lnet/tsz/afinal/FinalDb;->db:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Lnet/tsz/afinal/db/table/TableInfo;->getTableName()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7, v0}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    .line 177
    .local v2, "id":Ljava/lang/Long;
    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    const-wide/16 v7, -0x1

    cmp-long v5, v5, v7

    if-nez v5, :cond_1

    .line 182
    .end local v0    # "cv":Landroid/content/ContentValues;
    .end local v2    # "id":Ljava/lang/Long;
    .end local v3    # "tf":Lnet/tsz/afinal/db/table/TableInfo;
    :cond_0
    :goto_0
    return v4

    .line 179
    .restart local v0    # "cv":Landroid/content/ContentValues;
    .restart local v2    # "id":Ljava/lang/Long;
    .restart local v3    # "tf":Lnet/tsz/afinal/db/table/TableInfo;
    :cond_1
    invoke-virtual {v3}, Lnet/tsz/afinal/db/table/TableInfo;->getId()Lnet/tsz/afinal/db/table/Id;

    move-result-object v4

    invoke-virtual {v4, p1, v2}, Lnet/tsz/afinal/db/table/Id;->setValue(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 180
    const/4 v4, 0x1

    goto :goto_0
.end method

.method public update(Ljava/lang/Object;)V
    .locals 1
    .param p1, "entity"    # Ljava/lang/Object;

    .prologue
    .line 206
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-direct {p0, v0}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 207
    invoke-static {p1}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getUpdateSqlAsSqlInfo(Ljava/lang/Object;)Lnet/tsz/afinal/db/sqlite/SqlInfo;

    move-result-object v0

    invoke-direct {p0, v0}, Lnet/tsz/afinal/FinalDb;->exeSqlInfo(Lnet/tsz/afinal/db/sqlite/SqlInfo;)V

    .line 208
    return-void
.end method

.method public update(Ljava/lang/Object;Ljava/lang/String;)V
    .locals 1
    .param p1, "entity"    # Ljava/lang/Object;
    .param p2, "strWhere"    # Ljava/lang/String;

    .prologue
    .line 216
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-direct {p0, v0}, Lnet/tsz/afinal/FinalDb;->checkTableExist(Ljava/lang/Class;)V

    .line 217
    invoke-static {p1, p2}, Lnet/tsz/afinal/db/sqlite/SqlBuilder;->getUpdateSqlAsSqlInfo(Ljava/lang/Object;Ljava/lang/String;)Lnet/tsz/afinal/db/sqlite/SqlInfo;

    move-result-object v0

    invoke-direct {p0, v0}, Lnet/tsz/afinal/FinalDb;->exeSqlInfo(Lnet/tsz/afinal/db/sqlite/SqlInfo;)V

    .line 218
    return-void
.end method
