.class Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;
.super Ljava/lang/Thread;
.source "ADMS_Worker.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/adms/measurement/ADMS_Worker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "WorkerThread"
.end annotation


# instance fields
.field public cancelled:Z

.field private delay:J

.field private worker:Lcom/adobe/adms/measurement/ADMS_Worker;


# direct methods
.method public constructor <init>(Lcom/adobe/adms/measurement/ADMS_Worker;)V
    .locals 2
    .param p1, "worker"    # Lcom/adobe/adms/measurement/ADMS_Worker;

    .prologue
    .line 189
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 185
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;->delay:J

    .line 186
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;->worker:Lcom/adobe/adms/measurement/ADMS_Worker;

    .line 187
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;->cancelled:Z

    .line 190
    iput-object p1, p0, Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;->worker:Lcom/adobe/adms/measurement/ADMS_Worker;

    .line 191
    return-void
.end method


# virtual methods
.method public run()V
    .locals 19

    .prologue
    .line 194
    :goto_0
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;->cancelled:Z

    if-nez v2, :cond_2

    .line 195
    const/4 v15, 0x0

    .line 196
    .local v15, "request":Ljava/lang/String;
    const/4 v14, 0x0

    .line 197
    .local v14, "identifier":Ljava/lang/String;
    const/16 v17, 0x0

    .line 200
    .local v17, "timestamp":Ljava/lang/String;
    sget-object v18, Lcom/adobe/adms/measurement/ADMS_Worker;->dbMutex:Ljava/lang/Object;

    monitor-enter v18

    .line 201
    const/4 v11, 0x0

    .line 203
    .local v11, "cursor":Landroid/database/Cursor;
    :try_start_0
    # getter for: Lcom/adobe/adms/measurement/ADMS_Worker;->_offlineDB:Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {}, Lcom/adobe/adms/measurement/ADMS_Worker;->access$000()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    const-string v3, "HITS"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v6, "ID"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const-string v6, "URL"

    aput-object v6, v4, v5

    const/4 v5, 0x2

    const-string v6, "TIMESTAMP"

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const-string v9, "ID ASC"

    const-string v10, "1"

    invoke-virtual/range {v2 .. v10}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 204
    if-eqz v11, :cond_0

    invoke-interface {v11}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 205
    const/4 v2, 0x0

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v14

    .line 206
    const/4 v2, 0x1

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v15

    .line 207
    const/4 v2, 0x2

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v17

    .line 214
    :cond_0
    if-eqz v11, :cond_1

    :try_start_1
    invoke-interface {v11}, Landroid/database/Cursor;->isClosed()Z

    move-result v2

    if-nez v2, :cond_1

    .line 215
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 218
    :cond_1
    :goto_1
    monitor-exit v18
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 221
    if-nez v15, :cond_4

    .line 253
    .end local v11    # "cursor":Landroid/database/Cursor;
    .end local v14    # "identifier":Ljava/lang/String;
    .end local v15    # "request":Ljava/lang/String;
    .end local v17    # "timestamp":Ljava/lang/String;
    :cond_2
    const/4 v2, 0x1

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;->cancelled:Z

    .line 254
    return-void

    .line 210
    .restart local v11    # "cursor":Landroid/database/Cursor;
    .restart local v14    # "identifier":Ljava/lang/String;
    .restart local v15    # "request":Ljava/lang/String;
    .restart local v17    # "timestamp":Ljava/lang/String;
    :catch_0
    move-exception v12

    .line 211
    .local v12, "e":Landroid/database/SQLException;
    :try_start_2
    invoke-static {}, Lcom/adobe/adms/measurement/ADMS_Measurement;->sharedInstance()Lcom/adobe/adms/measurement/ADMS_Measurement;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "ADMS SDK Error: Unable to read from database -- "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v12}, Landroid/database/SQLException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/adobe/adms/measurement/ADMS_Measurement;->debugLog(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 214
    if-eqz v11, :cond_1

    :try_start_3
    invoke-interface {v11}, Landroid/database/Cursor;->isClosed()Z

    move-result v2

    if-nez v2, :cond_1

    .line 215
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 218
    .end local v12    # "e":Landroid/database/SQLException;
    :catchall_0
    move-exception v2

    monitor-exit v18
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v2

    .line 214
    :catchall_1
    move-exception v2

    if-eqz v11, :cond_3

    :try_start_4
    invoke-interface {v11}, Landroid/database/Cursor;->isClosed()Z

    move-result v3

    if-nez v3, :cond_3

    .line 215
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    :cond_3
    throw v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 226
    :cond_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;->worker:Lcom/adobe/adms/measurement/ADMS_Worker;

    iget-boolean v2, v2, Lcom/adobe/adms/measurement/ADMS_Worker;->trackOffline:Z

    if-nez v2, :cond_5

    invoke-static/range {v17 .. v17}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    const-wide/16 v6, 0x3e8

    div-long/2addr v4, v6

    # getter for: Lcom/adobe/adms/measurement/ADMS_Worker;->TIMESTAMP_DISABLED_WAIT_THRESHOLD:Ljava/lang/Integer;
    invoke-static {}, Lcom/adobe/adms/measurement/ADMS_Worker;->access$100()Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v6

    int-to-long v6, v6

    sub-long/2addr v4, v6

    cmp-long v2, v2, v4

    if-gez v2, :cond_5

    .line 227
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;->worker:Lcom/adobe/adms/measurement/ADMS_Worker;

    invoke-virtual {v2, v14}, Lcom/adobe/adms/measurement/ADMS_Worker;->deleteHit(Ljava/lang/String;)V

    .line 246
    :goto_2
    :try_start_5
    move-object/from16 v0, p0

    iget-wide v2, v0, Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;->delay:J

    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V
    :try_end_5
    .catch Ljava/lang/InterruptedException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 250
    const-wide/16 v2, 0x0

    move-object/from16 v0, p0

    iput-wide v2, v0, Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;->delay:J

    goto/16 :goto_0

    .line 231
    :cond_5
    new-instance v16, Lcom/adobe/adms/measurement/ADMS_RequestProperties;

    move-object/from16 v0, v16

    invoke-direct {v0, v15}, Lcom/adobe/adms/measurement/ADMS_RequestProperties;-><init>(Ljava/lang/String;)V

    .line 232
    .local v16, "requestProps":Lcom/adobe/adms/measurement/ADMS_RequestProperties;
    invoke-virtual/range {v16 .. v16}, Lcom/adobe/adms/measurement/ADMS_RequestProperties;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual/range {v16 .. v16}, Lcom/adobe/adms/measurement/ADMS_RequestProperties;->getHeaders()Ljava/util/Hashtable;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/adobe/adms/measurement/ADMS_RequestHandler;->sendRequest(Ljava/lang/String;Ljava/util/Hashtable;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 233
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;->worker:Lcom/adobe/adms/measurement/ADMS_Worker;

    invoke-virtual {v2, v14}, Lcom/adobe/adms/measurement/ADMS_Worker;->deleteHit(Ljava/lang/String;)V

    goto :goto_2

    .line 236
    :cond_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;->worker:Lcom/adobe/adms/measurement/ADMS_Worker;

    iget-boolean v2, v2, Lcom/adobe/adms/measurement/ADMS_Worker;->trackOffline:Z

    if-eqz v2, :cond_7

    .line 237
    invoke-static {}, Lcom/adobe/adms/measurement/ADMS_Measurement;->sharedInstance()Lcom/adobe/adms/measurement/ADMS_Measurement;

    move-result-object v2

    const-string v3, "ADMS SDK Debug: Error Sending Hit(pausing 30 seconds before retry)"

    invoke-virtual {v2, v3}, Lcom/adobe/adms/measurement/ADMS_Measurement;->debugLog(Ljava/lang/String;)V

    .line 238
    const-wide/16 v2, 0x7530

    move-object/from16 v0, p0

    iput-wide v2, v0, Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;->delay:J

    goto :goto_2

    .line 240
    :cond_7
    invoke-static {}, Lcom/adobe/adms/measurement/ADMS_Measurement;->sharedInstance()Lcom/adobe/adms/measurement/ADMS_Measurement;

    move-result-object v2

    const-string v3, "ADMS SDK Debug: Error Sending Hit(deleting hit)"

    invoke-virtual {v2, v3}, Lcom/adobe/adms/measurement/ADMS_Measurement;->debugLog(Ljava/lang/String;)V

    .line 241
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;->worker:Lcom/adobe/adms/measurement/ADMS_Worker;

    invoke-virtual {v2, v14}, Lcom/adobe/adms/measurement/ADMS_Worker;->deleteHit(Ljava/lang/String;)V

    goto :goto_2

    .line 247
    .end local v16    # "requestProps":Lcom/adobe/adms/measurement/ADMS_RequestProperties;
    :catch_1
    move-exception v13

    .line 248
    .local v13, "ex":Ljava/lang/InterruptedException;
    :try_start_6
    invoke-static {}, Lcom/adobe/adms/measurement/ADMS_Measurement;->sharedInstance()Lcom/adobe/adms/measurement/ADMS_Measurement;

    move-result-object v2

    const-string v3, "ADMS SDK Debug: Background thread interrupted"

    invoke-virtual {v2, v3}, Lcom/adobe/adms/measurement/ADMS_Measurement;->debugLog(Ljava/lang/String;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .line 250
    const-wide/16 v2, 0x0

    move-object/from16 v0, p0

    iput-wide v2, v0, Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;->delay:J

    goto/16 :goto_0

    .end local v13    # "ex":Ljava/lang/InterruptedException;
    :catchall_2
    move-exception v2

    const-wide/16 v4, 0x0

    move-object/from16 v0, p0

    iput-wide v4, v0, Lcom/adobe/adms/measurement/ADMS_Worker$WorkerThread;->delay:J

    throw v2
.end method
