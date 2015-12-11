.class public abstract Lcom/amazon/mShop/util/DatabaseHelper;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "DatabaseHelper.java"


# instance fields
.field protected final mContext:Landroid/content/Context;

.field protected mExecutor:Ljava/util/concurrent/Executor;


# direct methods
.method protected constructor <init>(Landroid/content/Context;Ljava/lang/String;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "databaseName"    # Ljava/lang/String;
    .param p3, "databaseVersion"    # I

    .prologue
    .line 19
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0, p3}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 15
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/util/DatabaseHelper;->mExecutor:Ljava/util/concurrent/Executor;

    .line 20
    iput-object p1, p0, Lcom/amazon/mShop/util/DatabaseHelper;->mContext:Landroid/content/Context;

    .line 21
    return-void
.end method


# virtual methods
.method public declared-synchronized getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    .locals 4

    .prologue
    .line 26
    monitor-enter p0

    :try_start_0
    invoke-super {p0}, Landroid/database/sqlite/SQLiteOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 27
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    monitor-exit p0

    return-object v0

    .line 28
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catch_0
    move-exception v1

    .line 29
    .local v1, "e":Landroid/database/sqlite/SQLiteException;
    :try_start_1
    invoke-static {v1}, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->logMetric(Ljava/lang/Exception;)V

    .line 30
    new-instance v2, Lcom/amazon/mShop/util/DBException;

    const-string/jumbo v3, "Cannot open database"

    invoke-direct {v2, v3}, Lcom/amazon/mShop/util/DBException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 26
    .end local v1    # "e":Landroid/database/sqlite/SQLiteException;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method
