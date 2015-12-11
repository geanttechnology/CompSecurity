.class Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;
.super Landroid/database/sqlite/SQLiteCursor;
.source "VSdkDb.java"


# static fields
.field private static LOG_TAG:Ljava/lang/String;

.field private static counter:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 469
    const-class v0, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;->LOG_TAG:Ljava/lang/String;

    .line 470
    const/4 v0, 0x0

    sput v0, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;->counter:I

    .line 466
    return-void
.end method

.method public constructor <init>(Landroid/database/sqlite/SQLiteDatabase;Landroid/database/sqlite/SQLiteCursorDriver;Ljava/lang/String;Landroid/database/sqlite/SQLiteQuery;)V
    .locals 4
    .param p1, "database"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "driver"    # Landroid/database/sqlite/SQLiteCursorDriver;
    .param p3, "table"    # Ljava/lang/String;
    .param p4, "query"    # Landroid/database/sqlite/SQLiteQuery;

    .prologue
    .line 478
    invoke-direct {p0, p1, p2, p3, p4}, Landroid/database/sqlite/SQLiteCursor;-><init>(Landroid/database/sqlite/SQLiteDatabase;Landroid/database/sqlite/SQLiteCursorDriver;Ljava/lang/String;Landroid/database/sqlite/SQLiteQuery;)V

    .line 479
    invoke-direct {p0}, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;->incCounter()I

    move-result v0

    .line 481
    .local v0, "openCount":I
    const/16 v1, 0x19

    if-le v0, v1, :cond_0

    .line 482
    sget-object v1, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Cursor created, open: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 483
    :cond_0
    return-void
.end method

.method private declared-synchronized decCounter()I
    .locals 2

    .prologue
    .line 505
    monitor-enter p0

    :try_start_0
    sget v0, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;->counter:I

    add-int/lit8 v0, v0, -0x1

    sput v0, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;->counter:I

    .line 506
    sget v0, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;->counter:I

    if-nez v0, :cond_0

    .line 507
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->getHelper()Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 508
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->getHelper()Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->setCloseRequested(Z)V

    .line 511
    :cond_0
    sget v0, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;->counter:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    .line 505
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized incCounter()I
    .locals 2

    .prologue
    .line 498
    monitor-enter p0

    :try_start_0
    sget v0, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;->counter:I

    if-nez v0, :cond_0

    .line 499
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->getHelper()Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->setCloseRequested(Z)V

    .line 500
    :cond_0
    sget v0, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;->counter:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;->counter:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    .line 498
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public declared-synchronized close()V
    .locals 4

    .prologue
    .line 488
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;->isClosed()Z

    move-result v1

    if-nez v1, :cond_0

    .line 489
    invoke-super {p0}, Landroid/database/sqlite/SQLiteCursor;->close()V

    .line 490
    invoke-direct {p0}, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;->decCounter()I

    move-result v0

    .line 492
    .local v0, "openCount":I
    const/16 v1, 0x19

    if-le v0, v1, :cond_0

    .line 493
    sget-object v1, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Cursor closed, open: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 495
    .end local v0    # "openCount":I
    :cond_0
    monitor-exit p0

    return-void

    .line 488
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method
