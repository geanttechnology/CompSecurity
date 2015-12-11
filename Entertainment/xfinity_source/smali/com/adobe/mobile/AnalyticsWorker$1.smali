.class Lcom/adobe/mobile/AnalyticsWorker$1;
.super Ljava/lang/Object;
.source "AnalyticsWorker.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/AnalyticsWorker;->workerThread()Ljava/lang/Runnable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mobile/AnalyticsWorker;


# direct methods
.method constructor <init>(Lcom/adobe/mobile/AnalyticsWorker;)V
    .locals 0
    .param p1, "this$0"    # Lcom/adobe/mobile/AnalyticsWorker;

    .prologue
    .line 217
    iput-object p1, p0, Lcom/adobe/mobile/AnalyticsWorker$1;->this$0:Lcom/adobe/mobile/AnalyticsWorker;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 26

    .prologue
    .line 220
    invoke-static {}, Lcom/adobe/mobile/AnalyticsWorker;->sharedInstance()Lcom/adobe/mobile/AnalyticsWorker;

    move-result-object v18

    .line 223
    .local v18, "worker":Lcom/adobe/mobile/AnalyticsWorker;
    const/16 v19, 0xa

    invoke-static/range {v19 .. v19}, Landroid/os/Process;->setThreadPriority(I)V

    .line 226
    new-instance v10, Ljava/util/HashMap;

    invoke-direct {v10}, Ljava/util/HashMap;-><init>()V

    .line 228
    .local v10, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v19, "Accept-Language"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getDefaultAcceptLanguage()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-interface {v10, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 229
    const-string v19, "User-Agent"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getDefaultUserAgent()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-interface {v10, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 232
    :cond_0
    :goto_0
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/adobe/mobile/MobileConfig;->getPrivacyStatus()Lcom/adobe/mobile/MobilePrivacyStatus;

    move-result-object v19

    sget-object v20, Lcom/adobe/mobile/MobilePrivacyStatus;->MOBILE_PRIVACY_STATUS_OPT_IN:Lcom/adobe/mobile/MobilePrivacyStatus;

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    if-ne v0, v1, :cond_1

    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/adobe/mobile/MobileConfig;->networkConnectivity()Z

    move-result v19

    if-eqz v19, :cond_1

    .line 234
    invoke-virtual/range {v18 .. v18}, Lcom/adobe/mobile/AnalyticsWorker;->selectOldestHit()Lcom/adobe/mobile/AbstractHitDatabase$Hit;

    move-result-object v11

    .line 236
    .local v11, "hit":Lcom/adobe/mobile/AbstractHitDatabase$Hit;
    if-nez v11, :cond_2

    .line 334
    .end local v11    # "hit":Lcom/adobe/mobile/AbstractHitDatabase$Hit;
    :cond_1
    :goto_1
    const/16 v19, 0x0

    move/from16 v0, v19

    move-object/from16 v1, v18

    iput-boolean v0, v1, Lcom/adobe/mobile/AnalyticsWorker;->bgThreadActive:Z

    .line 335
    return-void

    .line 241
    .restart local v11    # "hit":Lcom/adobe/mobile/AbstractHitDatabase$Hit;
    :cond_2
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/adobe/mobile/MobileConfig;->getOfflineTrackingEnabled()Z

    move-result v19

    if-eqz v19, :cond_4

    .line 243
    iget-wide v0, v11, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->timestamp:J

    move-wide/from16 v20, v0

    move-object/from16 v0, v18

    iget-wide v0, v0, Lcom/adobe/mobile/AnalyticsWorker;->lastHitTimestamp:J

    move-wide/from16 v22, v0

    sub-long v6, v20, v22

    .line 246
    .local v6, "delta":J
    const-wide/16 v20, 0x0

    cmp-long v19, v6, v20

    if-gez v19, :cond_3

    .line 248
    move-object/from16 v0, v18

    iget-wide v0, v0, Lcom/adobe/mobile/AnalyticsWorker;->lastHitTimestamp:J

    move-wide/from16 v20, v0

    const-wide/16 v22, 0x1

    add-long v14, v20, v22

    .line 249
    .local v14, "newTimestamp":J
    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "&ts="

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    iget-wide v0, v11, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->timestamp:J

    move-wide/from16 v20, v0

    invoke-static/range {v20 .. v21}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    .line 250
    .local v16, "oldTSString":Ljava/lang/String;
    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "&ts="

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-static {v14, v15}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 252
    .local v13, "newTSString":Ljava/lang/String;
    iget-object v0, v11, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->urlFragment:Ljava/lang/String;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    move-object/from16 v1, v16

    invoke-virtual {v0, v1, v13}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    iput-object v0, v11, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->urlFragment:Ljava/lang/String;

    .line 254
    const-string v19, "Analytics - Adjusting out of order hit timestamp(%d->%d)"

    const/16 v20, 0x2

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    iget-wide v0, v11, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->timestamp:J

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v22

    aput-object v22, v20, v21

    const/16 v21, 0x1

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 256
    iput-wide v14, v11, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->timestamp:J

    .line 281
    .end local v6    # "delta":J
    .end local v13    # "newTSString":Ljava/lang/String;
    .end local v14    # "newTimestamp":J
    .end local v16    # "oldTSString":Ljava/lang/String;
    :cond_3
    iget-object v0, v11, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->urlFragment:Ljava/lang/String;

    move-object/from16 v19, v0

    const-string v20, "ndh"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_5

    iget-object v0, v11, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->urlFragment:Ljava/lang/String;

    move-object/from16 v17, v0

    .line 283
    .local v17, "postBody":Ljava/lang/String;
    :goto_2
    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    # invokes: Lcom/adobe/mobile/AnalyticsWorker;->getBaseURL()Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mobile/AnalyticsWorker;->access$000()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    # getter for: Lcom/adobe/mobile/AnalyticsWorker;->randomGen:Ljava/security/SecureRandom;
    invoke-static {}, Lcom/adobe/mobile/AnalyticsWorker;->access$100()Ljava/security/SecureRandom;

    move-result-object v20

    const v21, 0x5f5e100

    invoke-virtual/range {v20 .. v21}, Ljava/security/SecureRandom;->nextInt(I)I

    move-result v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    const/16 v20, 0x1388

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/AnalyticsWorker$1;->this$0:Lcom/adobe/mobile/AnalyticsWorker;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-object v0, v0, Lcom/adobe/mobile/AnalyticsWorker;->logPrefix:Ljava/lang/String;

    move-object/from16 v21, v0

    move-object/from16 v0, v19

    move-object/from16 v1, v17

    move/from16 v2, v20

    move-object/from16 v3, v21

    invoke-static {v0, v1, v10, v2, v3}, Lcom/adobe/mobile/RequestHandler;->sendAnalyticsRequest(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_6

    .line 287
    :try_start_0
    iget-object v0, v11, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->identifier:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/adobe/mobile/AnalyticsWorker;->deleteHit(Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException; {:try_start_0 .. :try_end_0} :catch_1

    .line 294
    iget-wide v0, v11, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->timestamp:J

    move-wide/from16 v20, v0

    move-wide/from16 v0, v20

    move-object/from16 v2, v18

    iput-wide v0, v2, Lcom/adobe/mobile/AnalyticsWorker;->lastHitTimestamp:J

    goto/16 :goto_0

    .line 260
    .end local v17    # "postBody":Ljava/lang/String;
    :cond_4
    iget-wide v0, v11, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->timestamp:J

    move-wide/from16 v20, v0

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getTimeSince1970()J

    move-result-wide v22

    const-wide/16 v24, 0x3c

    sub-long v22, v22, v24

    cmp-long v19, v20, v22

    if-gez v19, :cond_3

    .line 266
    :try_start_1
    iget-object v0, v11, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->identifier:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/adobe/mobile/AnalyticsWorker;->deleteHit(Ljava/lang/String;)V
    :try_end_1
    .catch Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0

    .line 268
    :catch_0
    move-exception v9

    .line 269
    .local v9, "ex":Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;
    invoke-static {}, Lcom/adobe/mobile/AnalyticsWorker;->sharedInstance()Lcom/adobe/mobile/AnalyticsWorker;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v9}, Lcom/adobe/mobile/AnalyticsWorker;->resetDatabase(Ljava/lang/Exception;)V

    goto/16 :goto_1

    .line 281
    .end local v9    # "ex":Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;
    :cond_5
    iget-object v0, v11, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->urlFragment:Ljava/lang/String;

    move-object/from16 v19, v0

    iget-object v0, v11, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->urlFragment:Ljava/lang/String;

    move-object/from16 v20, v0

    const/16 v21, 0x3f

    invoke-virtual/range {v20 .. v21}, Ljava/lang/String;->indexOf(I)I

    move-result v20

    add-int/lit8 v20, v20, 0x1

    invoke-virtual/range {v19 .. v20}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v17

    goto/16 :goto_2

    .line 289
    .restart local v17    # "postBody":Ljava/lang/String;
    :catch_1
    move-exception v9

    .line 290
    .restart local v9    # "ex":Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;
    invoke-static {}, Lcom/adobe/mobile/AnalyticsWorker;->sharedInstance()Lcom/adobe/mobile/AnalyticsWorker;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v9}, Lcom/adobe/mobile/AnalyticsWorker;->resetDatabase(Ljava/lang/Exception;)V

    goto/16 :goto_1

    .line 300
    .end local v9    # "ex":Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;
    :cond_6
    const-string v19, "Analytics - Unable to send hit"

    const/16 v20, 0x0

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    invoke-static/range {v19 .. v20}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 302
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/adobe/mobile/MobileConfig;->getOfflineTrackingEnabled()Z

    move-result v19

    if-eqz v19, :cond_7

    .line 305
    const-wide/16 v4, 0x1e

    .line 306
    .local v4, "delay":J
    const-string v19, "Analytics - Network error, imposing internal cooldown(%d seconds)"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 324
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_3
    int-to-long v0, v12

    move-wide/from16 v20, v0

    cmp-long v19, v20, v4

    if-gez v19, :cond_0

    :try_start_2
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/adobe/mobile/MobileConfig;->networkConnectivity()Z

    move-result v19

    if-eqz v19, :cond_0

    .line 325
    const-wide/16 v20, 0x3e8

    invoke-static/range {v20 .. v21}, Ljava/lang/Thread;->sleep(J)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_3

    .line 324
    add-int/lit8 v12, v12, 0x1

    goto :goto_3

    .line 311
    .end local v4    # "delay":J
    .end local v12    # "i":I
    :cond_7
    :try_start_3
    iget-object v0, v11, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->identifier:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/adobe/mobile/AnalyticsWorker;->deleteHit(Ljava/lang/String;)V
    :try_end_3
    .catch Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException; {:try_start_3 .. :try_end_3} :catch_2

    goto/16 :goto_0

    .line 313
    :catch_2
    move-exception v9

    .line 314
    .restart local v9    # "ex":Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;
    invoke-static {}, Lcom/adobe/mobile/AnalyticsWorker;->sharedInstance()Lcom/adobe/mobile/AnalyticsWorker;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v9}, Lcom/adobe/mobile/AnalyticsWorker;->resetDatabase(Ljava/lang/Exception;)V

    goto/16 :goto_1

    .line 328
    .end local v9    # "ex":Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;
    .restart local v4    # "delay":J
    .restart local v12    # "i":I
    :catch_3
    move-exception v8

    .line 329
    .local v8, "e":Ljava/lang/Exception;
    const-string v19, "Analytics - Background Thread Interrupted(%s)"

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    invoke-virtual {v8}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0
.end method
