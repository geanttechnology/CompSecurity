.class abstract Lcom/adobe/mobile/AbstractHitDatabase;
.super Lcom/adobe/mobile/AbstractDatabaseBacking;
.source "AbstractHitDatabase.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mobile/AbstractHitDatabase$ReferrerTimeoutTask;,
        Lcom/adobe/mobile/AbstractHitDatabase$Hit;
    }
.end annotation


# instance fields
.field protected final backgroundMutex:Ljava/lang/Object;

.field protected bgThreadActive:Z

.field protected dbCreateStatement:Ljava/lang/String;

.field protected lastHitTimestamp:J

.field protected numberOfUnsentHits:J

.field private referrerTask:Ljava/util/TimerTask;

.field private referrerTimer:Ljava/util/Timer;

.field private final referrerTimerMutex:Ljava/lang/Object;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/adobe/mobile/AbstractDatabaseBacking;-><init>()V

    .line 24
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/adobe/mobile/AbstractHitDatabase;->bgThreadActive:Z

    .line 25
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/adobe/mobile/AbstractHitDatabase;->backgroundMutex:Ljava/lang/Object;

    .line 26
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/adobe/mobile/AbstractHitDatabase;->referrerTimerMutex:Ljava/lang/Object;

    .line 212
    return-void
.end method


# virtual methods
.method protected bringOnline()V
    .locals 3

    .prologue
    .line 107
    iget-boolean v0, p0, Lcom/adobe/mobile/AbstractHitDatabase;->bgThreadActive:Z

    if-nez v0, :cond_0

    .line 109
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/adobe/mobile/AbstractHitDatabase;->bgThreadActive:Z

    .line 110
    iget-object v1, p0, Lcom/adobe/mobile/AbstractHitDatabase;->backgroundMutex:Ljava/lang/Object;

    monitor-enter v1

    .line 111
    :try_start_0
    new-instance v0, Ljava/lang/Thread;

    invoke-virtual {p0}, Lcom/adobe/mobile/AbstractHitDatabase;->workerThread()Ljava/lang/Runnable;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 112
    monitor-exit v1

    .line 114
    :cond_0
    return-void

    .line 112
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method protected clearTrackingQueue()V
    .locals 6

    .prologue
    .line 87
    iget-object v2, p0, Lcom/adobe/mobile/AbstractHitDatabase;->dbMutex:Ljava/lang/Object;

    monitor-enter v2

    .line 89
    :try_start_0
    iget-object v1, p0, Lcom/adobe/mobile/AbstractHitDatabase;->database:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "HITS"

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {v1, v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 90
    const-wide/16 v4, 0x0

    iput-wide v4, p0, Lcom/adobe/mobile/AbstractHitDatabase;->numberOfUnsentHits:J
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 101
    :goto_0
    :try_start_1
    monitor-exit v2

    .line 102
    return-void

    .line 92
    :catch_0
    move-exception v0

    .line 93
    .local v0, "x":Ljava/lang/NullPointerException;
    const-string v1, "%s - Unable to clear tracking queue due to an unopened database (%s)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/adobe/mobile/AbstractHitDatabase;->logPrefix:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Ljava/lang/NullPointerException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 101
    .end local v0    # "x":Ljava/lang/NullPointerException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1

    .line 95
    :catch_1
    move-exception v0

    .line 96
    .local v0, "x":Landroid/database/SQLException;
    :try_start_2
    const-string v1, "%s - Unable to clear tracking queue due to a sql error (%s)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/adobe/mobile/AbstractHitDatabase;->logPrefix:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Landroid/database/SQLException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 98
    .end local v0    # "x":Landroid/database/SQLException;
    :catch_2
    move-exception v0

    .line 99
    .local v0, "x":Ljava/lang/Exception;
    const-string v1, "%s - Unable to clear tracking queue due to an unexpected error (%s)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/adobe/mobile/AbstractHitDatabase;->logPrefix:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method protected deleteHit(Ljava/lang/String;)V
    .locals 8
    .param p1, "identifier"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v4, 0x0

    .line 62
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_1

    .line 63
    :cond_0
    const-string v1, "%s - Unable to delete hit due to an invalid parameter"

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/adobe/mobile/AbstractHitDatabase;->logPrefix:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 84
    :goto_0
    return-void

    .line 67
    :cond_1
    iget-object v2, p0, Lcom/adobe/mobile/AbstractHitDatabase;->dbMutex:Ljava/lang/Object;

    monitor-enter v2

    .line 69
    :try_start_0
    iget-object v1, p0, Lcom/adobe/mobile/AbstractHitDatabase;->database:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "HITS"

    const-string v4, "ID = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    aput-object p1, v5, v6

    invoke-virtual {v1, v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 70
    iget-wide v4, p0, Lcom/adobe/mobile/AbstractHitDatabase;->numberOfUnsentHits:J

    const-wide/16 v6, 0x1

    sub-long/2addr v4, v6

    iput-wide v4, p0, Lcom/adobe/mobile/AbstractHitDatabase;->numberOfUnsentHits:J
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 83
    :goto_1
    :try_start_1
    monitor-exit v2

    goto :goto_0

    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1

    .line 72
    :catch_0
    move-exception v0

    .line 73
    .local v0, "x":Ljava/lang/NullPointerException;
    :try_start_2
    const-string v1, "%s - Unable to delete hit due to an unopened database (%s)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/adobe/mobile/AbstractHitDatabase;->logPrefix:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Ljava/lang/NullPointerException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 75
    .end local v0    # "x":Ljava/lang/NullPointerException;
    :catch_1
    move-exception v0

    .line 76
    .local v0, "x":Landroid/database/SQLException;
    const-string v1, "%s - Unable to delete hit due to a sql error (%s)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/adobe/mobile/AbstractHitDatabase;->logPrefix:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Landroid/database/SQLException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 77
    new-instance v1, Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to delete, database probably corrupted ("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Landroid/database/SQLException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 79
    .end local v0    # "x":Landroid/database/SQLException;
    :catch_2
    move-exception v0

    .line 80
    .local v0, "x":Ljava/lang/Exception;
    const-string v1, "%s - Unable to delete hit due to an unexpected error (%s)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/adobe/mobile/AbstractHitDatabase;->logPrefix:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 81
    new-instance v1, Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unexpected exception, database probably corrupted ("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0
.end method

.method protected forceKick()V
    .locals 1

    .prologue
    .line 162
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/adobe/mobile/AbstractHitDatabase;->kick(Z)V

    .line 163
    return-void
.end method

.method protected getTrackingQueueSize()J
    .locals 8

    .prologue
    .line 168
    const-wide/16 v0, 0x0

    .line 169
    .local v0, "numRows":J
    iget-object v4, p0, Lcom/adobe/mobile/AbstractHitDatabase;->dbMutex:Ljava/lang/Object;

    monitor-enter v4

    .line 171
    :try_start_0
    iget-object v3, p0, Lcom/adobe/mobile/AbstractHitDatabase;->database:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "HITS"

    invoke-static {v3, v5}, Landroid/database/DatabaseUtils;->queryNumEntries(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)J
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v0

    .line 182
    :goto_0
    :try_start_1
    monitor-exit v4

    .line 183
    return-wide v0

    .line 173
    :catch_0
    move-exception v2

    .line 174
    .local v2, "x":Ljava/lang/NullPointerException;
    const-string v3, "%s - Unable to get tracking queue size due to an unopened database (%s)"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget-object v7, p0, Lcom/adobe/mobile/AbstractHitDatabase;->logPrefix:Ljava/lang/String;

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-virtual {v2}, Ljava/lang/NullPointerException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v3, v5}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 182
    .end local v2    # "x":Ljava/lang/NullPointerException;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v3

    .line 176
    :catch_1
    move-exception v2

    .line 177
    .local v2, "x":Landroid/database/SQLException;
    :try_start_2
    const-string v3, "%s - Unable to get tracking queue size due to a sql error (%s)"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget-object v7, p0, Lcom/adobe/mobile/AbstractHitDatabase;->logPrefix:Ljava/lang/String;

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-virtual {v2}, Landroid/database/SQLException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v3, v5}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 179
    .end local v2    # "x":Landroid/database/SQLException;
    :catch_2
    move-exception v2

    .line 180
    .local v2, "x":Ljava/lang/Exception;
    const-string v3, "%s - Unable to get tracking queue size due to an unexpected error (%s)"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget-object v7, p0, Lcom/adobe/mobile/AbstractHitDatabase;->logPrefix:Ljava/lang/String;

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-virtual {v2}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v3, v5}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method protected initializeDatabase()V
    .locals 6

    .prologue
    const/4 v3, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 48
    :try_start_0
    iget-object v1, p0, Lcom/adobe/mobile/AbstractHitDatabase;->database:Landroid/database/sqlite/SQLiteDatabase;

    iget-object v2, p0, Lcom/adobe/mobile/AbstractHitDatabase;->dbCreateStatement:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    .line 59
    :goto_0
    return-void

    .line 50
    :catch_0
    move-exception v0

    .line 51
    .local v0, "x":Ljava/lang/NullPointerException;
    const-string v1, "%s - Unable to create database due to an invalid path (%s)"

    new-array v2, v3, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/adobe/mobile/AbstractHitDatabase;->logPrefix:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-virtual {v0}, Ljava/lang/NullPointerException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 53
    .end local v0    # "x":Ljava/lang/NullPointerException;
    :catch_1
    move-exception v0

    .line 54
    .local v0, "x":Landroid/database/SQLException;
    const-string v1, "%s - Unable to create database due to a sql error (%s)"

    new-array v2, v3, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/adobe/mobile/AbstractHitDatabase;->logPrefix:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-virtual {v0}, Landroid/database/SQLException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 56
    .end local v0    # "x":Landroid/database/SQLException;
    :catch_2
    move-exception v0

    .line 57
    .local v0, "x":Ljava/lang/Exception;
    const-string v1, "%s - Unable to create database due to an unexpected error (%s)"

    new-array v2, v3, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/adobe/mobile/AbstractHitDatabase;->logPrefix:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected kick(Z)V
    .locals 9
    .param p1, "ignoreBatchLimit"    # Z

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 117
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v0

    .line 120
    .local v0, "cfg":Lcom/adobe/mobile/MobileConfig;
    invoke-static {}, Lcom/adobe/mobile/ReferrerHandler;->getReferrerProcessed()Z

    move-result v4

    if-nez v4, :cond_2

    invoke-virtual {v0}, Lcom/adobe/mobile/MobileConfig;->getReferrerTimeout()I

    move-result v4

    if-lez v4, :cond_2

    .line 122
    iget-object v4, p0, Lcom/adobe/mobile/AbstractHitDatabase;->referrerTimerMutex:Ljava/lang/Object;

    monitor-enter v4

    .line 123
    :try_start_0
    iget-object v3, p0, Lcom/adobe/mobile/AbstractHitDatabase;->referrerTask:Ljava/util/TimerTask;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v3, :cond_0

    .line 125
    :try_start_1
    new-instance v3, Lcom/adobe/mobile/AbstractHitDatabase$ReferrerTimeoutTask;

    invoke-direct {v3, p0, p1}, Lcom/adobe/mobile/AbstractHitDatabase$ReferrerTimeoutTask;-><init>(Lcom/adobe/mobile/AbstractHitDatabase;Z)V

    iput-object v3, p0, Lcom/adobe/mobile/AbstractHitDatabase;->referrerTask:Ljava/util/TimerTask;

    .line 126
    new-instance v3, Ljava/util/Timer;

    invoke-direct {v3}, Ljava/util/Timer;-><init>()V

    iput-object v3, p0, Lcom/adobe/mobile/AbstractHitDatabase;->referrerTimer:Ljava/util/Timer;

    .line 127
    iget-object v3, p0, Lcom/adobe/mobile/AbstractHitDatabase;->referrerTimer:Ljava/util/Timer;

    iget-object v5, p0, Lcom/adobe/mobile/AbstractHitDatabase;->referrerTask:Ljava/util/TimerTask;

    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v6

    invoke-virtual {v6}, Lcom/adobe/mobile/MobileConfig;->getReferrerTimeout()I

    move-result v6

    int-to-long v6, v6

    invoke-virtual {v3, v5, v6, v7}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 132
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v4

    .line 159
    :cond_1
    :goto_1
    return-void

    .line 128
    :catch_0
    move-exception v1

    .line 129
    .local v1, "e":Ljava/lang/Exception;
    const-string v3, "%s - Error creating referrer timer (%s)"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget-object v7, p0, Lcom/adobe/mobile/AbstractHitDatabase;->logPrefix:Ljava/lang/String;

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v3, v5}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 132
    .end local v1    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v3

    .line 135
    :cond_2
    iget-object v4, p0, Lcom/adobe/mobile/AbstractHitDatabase;->referrerTimer:Ljava/util/Timer;

    if-eqz v4, :cond_3

    .line 137
    iget-object v4, p0, Lcom/adobe/mobile/AbstractHitDatabase;->referrerTimerMutex:Ljava/lang/Object;

    monitor-enter v4

    .line 139
    :try_start_3
    iget-object v5, p0, Lcom/adobe/mobile/AbstractHitDatabase;->referrerTimer:Ljava/util/Timer;

    invoke-virtual {v5}, Ljava/util/Timer;->cancel()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 144
    :goto_2
    const/4 v5, 0x0

    :try_start_4
    iput-object v5, p0, Lcom/adobe/mobile/AbstractHitDatabase;->referrerTask:Ljava/util/TimerTask;

    .line 145
    monitor-exit v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 149
    :cond_3
    invoke-virtual {v0}, Lcom/adobe/mobile/MobileConfig;->getPrivacyStatus()Lcom/adobe/mobile/MobilePrivacyStatus;

    move-result-object v4

    sget-object v5, Lcom/adobe/mobile/MobilePrivacyStatus;->MOBILE_PRIVACY_STATUS_OPT_IN:Lcom/adobe/mobile/MobilePrivacyStatus;

    if-ne v4, v5, :cond_1

    .line 154
    invoke-virtual {v0}, Lcom/adobe/mobile/MobileConfig;->getOfflineTrackingEnabled()Z

    move-result v4

    if-eqz v4, :cond_4

    iget-wide v4, p0, Lcom/adobe/mobile/AbstractHitDatabase;->numberOfUnsentHits:J

    invoke-virtual {v0}, Lcom/adobe/mobile/MobileConfig;->getBatchLimit()I

    move-result v6

    int-to-long v6, v6

    cmp-long v4, v4, v6

    if-lez v4, :cond_5

    :cond_4
    move v2, v3

    .line 156
    .local v2, "overBatchLimit":Z
    :cond_5
    if-nez v2, :cond_6

    if-eqz p1, :cond_1

    .line 157
    :cond_6
    invoke-virtual {p0}, Lcom/adobe/mobile/AbstractHitDatabase;->bringOnline()V

    goto :goto_1

    .line 141
    .end local v2    # "overBatchLimit":Z
    :catch_1
    move-exception v1

    .line 142
    .restart local v1    # "e":Ljava/lang/Exception;
    :try_start_5
    const-string v5, "%s - Error cancelling referrer timer (%s)"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v8, p0, Lcom/adobe/mobile/AbstractHitDatabase;->logPrefix:Ljava/lang/String;

    aput-object v8, v6, v7

    const/4 v7, 0x1

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2

    .line 145
    .end local v1    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v3

    monitor-exit v4
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    throw v3
.end method

.method protected postReset()V
    .locals 2

    .prologue
    .line 191
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/adobe/mobile/AbstractHitDatabase;->numberOfUnsentHits:J

    .line 192
    return-void
.end method

.method protected selectOldestHit()Lcom/adobe/mobile/AbstractHitDatabase$Hit;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/UnsupportedOperationException;
        }
    .end annotation

    .prologue
    .line 34
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "getFirstHitInQueue must be overwritten"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected workerThread()Ljava/lang/Runnable;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/UnsupportedOperationException;
        }
    .end annotation

    .prologue
    .line 38
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "workerThread must be overwritten"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
