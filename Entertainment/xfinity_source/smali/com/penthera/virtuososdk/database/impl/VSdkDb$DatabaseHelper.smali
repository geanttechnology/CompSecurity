.class public Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;
.super Ljava/lang/Object;
.source "VSdkDb.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/database/impl/VSdkDb;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DatabaseHelper"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;
    }
.end annotation


# instance fields
.field private iCloseHandler:Landroid/os/Handler;

.field private iDatabaseCloser:Ljava/lang/Runnable;

.field private iInternalhelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;

.field private iRequestClose:Z


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "aContext"    # Landroid/content/Context;

    .prologue
    .line 111
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 109
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iInternalhelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;

    .line 164
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iCloseHandler:Landroid/os/Handler;

    .line 165
    new-instance v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$1;

    invoke-direct {v0, p0}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$1;-><init>(Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;)V

    iput-object v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iDatabaseCloser:Ljava/lang/Runnable;

    .line 180
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iRequestClose:Z

    .line 113
    new-instance v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;

    invoke-direct {v0, p1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iInternalhelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;

    .line 114
    invoke-direct {p0}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->resetCloseHandler()V

    .line 115
    invoke-direct {p0}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->createDatabase()V

    .line 116
    return-void
.end method

.method static synthetic access$0(Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;)Z
    .locals 1

    .prologue
    .line 180
    iget-boolean v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iRequestClose:Z

    return v0
.end method

.method static synthetic access$1(Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 164
    iget-object v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iCloseHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$2(Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;)Ljava/lang/Runnable;
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iDatabaseCloser:Ljava/lang/Runnable;

    return-object v0
.end method

.method private declared-synchronized createDatabase()V
    .locals 2

    .prologue
    .line 158
    monitor-enter p0

    :try_start_0
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iDb:Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$3()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    if-eqz v0, :cond_0

    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iDb:Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$3()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->isOpen()Z

    move-result v0

    if-nez v0, :cond_1

    .line 159
    :cond_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iInternalhelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    invoke-static {v0}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$4(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 160
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Database opened"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 162
    :cond_1
    monitor-exit p0

    return-void

    .line 158
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized resetCloseHandler()V
    .locals 4

    .prologue
    .line 151
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iCloseHandler:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 152
    iget-object v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iCloseHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iDatabaseCloser:Ljava/lang/Runnable;

    const-wide/32 v2, 0x927c0

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 153
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iRequestClose:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 154
    monitor-exit p0

    return-void

    .line 151
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public closeDatabase()V
    .locals 3

    .prologue
    .line 188
    :try_start_0
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iLock:Ljava/util/concurrent/locks/Lock;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$2()Ljava/util/concurrent/locks/Lock;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 189
    iget-object v1, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iInternalhelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$InternalDatabaseHelper;->close()V

    .line 190
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$0()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Database closed"

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 191
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iLock:Ljava/util/concurrent/locks/Lock;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$2()Ljava/util/concurrent/locks/Lock;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 197
    :goto_0
    return-void

    .line 193
    :catch_0
    move-exception v0

    .line 195
    .local v0, "e":Ljava/lang/Exception;
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$0()Ljava/lang/String;

    move-result-object v1

    const-string v2, "exception while closing database"

    invoke-static {v1, v2, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    .locals 1

    .prologue
    .line 120
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iLock:Ljava/util/concurrent/locks/Lock;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$2()Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 121
    invoke-direct {p0}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->resetCloseHandler()V

    .line 122
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iDb:Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$3()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    if-eqz v0, :cond_0

    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iDb:Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$3()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->isOpen()Z

    move-result v0

    if-nez v0, :cond_1

    .line 123
    :cond_0
    invoke-direct {p0}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->createDatabase()V

    .line 125
    :cond_1
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iDb:Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$3()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    return-object v0
.end method

.method public getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    .locals 1

    .prologue
    .line 130
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iLock:Ljava/util/concurrent/locks/Lock;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$2()Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 131
    invoke-direct {p0}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->resetCloseHandler()V

    .line 132
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iDb:Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$3()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    if-eqz v0, :cond_0

    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iDb:Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$3()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->isOpen()Z

    move-result v0

    if-nez v0, :cond_1

    .line 133
    :cond_0
    invoke-direct {p0}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->createDatabase()V

    .line 135
    :cond_1
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iDb:Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$3()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    return-object v0
.end method

.method public releaseDatabase()V
    .locals 3

    .prologue
    .line 141
    :try_start_0
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iLock:Ljava/util/concurrent/locks/Lock;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$2()Ljava/util/concurrent/locks/Lock;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 147
    :goto_0
    return-void

    .line 143
    :catch_0
    move-exception v0

    .line 145
    .local v0, "e":Ljava/lang/Exception;
    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->access$0()Ljava/lang/String;

    move-result-object v1

    const-string v2, "exception while unlocking database"

    invoke-static {v1, v2, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public setCloseRequested(Z)V
    .locals 0
    .param p1, "b"    # Z

    .prologue
    .line 183
    iput-boolean p1, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iRequestClose:Z

    .line 184
    return-void
.end method
