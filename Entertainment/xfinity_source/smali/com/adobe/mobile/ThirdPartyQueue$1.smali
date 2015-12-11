.class Lcom/adobe/mobile/ThirdPartyQueue$1;
.super Ljava/lang/Object;
.source "ThirdPartyQueue.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/ThirdPartyQueue;->workerThread()Ljava/lang/Runnable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mobile/ThirdPartyQueue;


# direct methods
.method constructor <init>(Lcom/adobe/mobile/ThirdPartyQueue;)V
    .locals 0
    .param p1, "this$0"    # Lcom/adobe/mobile/ThirdPartyQueue;

    .prologue
    .line 199
    iput-object p1, p0, Lcom/adobe/mobile/ThirdPartyQueue$1;->this$0:Lcom/adobe/mobile/ThirdPartyQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 18

    .prologue
    .line 202
    invoke-static {}, Lcom/adobe/mobile/ThirdPartyQueue;->sharedInstance()Lcom/adobe/mobile/ThirdPartyQueue;

    move-result-object v15

    .line 205
    .local v15, "worker":Lcom/adobe/mobile/ThirdPartyQueue;
    const/16 v2, 0xa

    invoke-static {v2}, Landroid/os/Process;->setThreadPriority(I)V

    .line 207
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mobile/MobileConfig;->getOfflineTrackingEnabled()Z

    move-result v14

    .line 210
    .local v14, "offlineEnabled":Z
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 212
    .local v4, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "Accept-Language"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getDefaultAcceptLanguage()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v4, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 213
    const-string v2, "User-Agent"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getDefaultUserAgent()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v4, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 216
    :cond_0
    :goto_0
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mobile/MobileConfig;->getPrivacyStatus()Lcom/adobe/mobile/MobilePrivacyStatus;

    move-result-object v2

    sget-object v3, Lcom/adobe/mobile/MobilePrivacyStatus;->MOBILE_PRIVACY_STATUS_OPT_IN:Lcom/adobe/mobile/MobilePrivacyStatus;

    if-ne v2, v3, :cond_1

    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mobile/MobileConfig;->networkConnectivity()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 218
    invoke-virtual {v15}, Lcom/adobe/mobile/ThirdPartyQueue;->selectOldestHit()Lcom/adobe/mobile/AbstractHitDatabase$Hit;

    move-result-object v12

    .line 221
    .local v12, "hit":Lcom/adobe/mobile/AbstractHitDatabase$Hit;
    if-eqz v12, :cond_1

    iget-object v2, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->urlFragment:Ljava/lang/String;

    if-nez v2, :cond_2

    .line 298
    .end local v12    # "hit":Lcom/adobe/mobile/AbstractHitDatabase$Hit;
    :cond_1
    :goto_1
    const/4 v2, 0x0

    iput-boolean v2, v15, Lcom/adobe/mobile/ThirdPartyQueue;->bgThreadActive:Z

    .line 299
    return-void

    .line 226
    .restart local v12    # "hit":Lcom/adobe/mobile/AbstractHitDatabase$Hit;
    :cond_2
    if-nez v14, :cond_3

    iget-wide v2, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->timestamp:J

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getTimeSince1970()J

    move-result-wide v6

    const-wide/16 v16, 0x3c

    sub-long v6, v6, v16

    cmp-long v2, v2, v6

    if-gez v2, :cond_3

    .line 228
    :try_start_0
    iget-object v2, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->identifier:Ljava/lang/String;

    invoke-virtual {v15, v2}, Lcom/adobe/mobile/ThirdPartyQueue;->deleteHit(Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 230
    :catch_0
    move-exception v11

    .line 231
    .local v11, "ex":Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;
    invoke-virtual {v15, v11}, Lcom/adobe/mobile/ThirdPartyQueue;->resetDatabase(Ljava/lang/Exception;)V

    goto :goto_1

    .line 238
    .end local v11    # "ex":Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;
    :cond_3
    iget-object v2, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->postBody:Ljava/lang/String;

    if-eqz v2, :cond_4

    iget-object v2, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->postBody:Ljava/lang/String;

    :goto_2
    iput-object v2, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->postBody:Ljava/lang/String;

    .line 239
    iget-object v2, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->postType:Ljava/lang/String;

    if-eqz v2, :cond_5

    iget-object v2, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->postType:Ljava/lang/String;

    :goto_3
    iput-object v2, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->postType:Ljava/lang/String;

    .line 242
    iget v2, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->timeout:I

    const/4 v3, 0x2

    if-ge v2, v3, :cond_6

    const/16 v2, 0x7d0

    :goto_4
    iput v2, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->timeout:I

    .line 247
    iget-object v2, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->urlFragment:Ljava/lang/String;

    iget-object v3, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->postBody:Ljava/lang/String;

    iget v5, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->timeout:I

    iget-object v6, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->postType:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/adobe/mobile/ThirdPartyQueue$1;->this$0:Lcom/adobe/mobile/ThirdPartyQueue;

    iget-object v7, v7, Lcom/adobe/mobile/ThirdPartyQueue;->logPrefix:Ljava/lang/String;

    invoke-static/range {v2 .. v7}, Lcom/adobe/mobile/RequestHandler;->sendThirdPartyRequest(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 251
    :try_start_1
    iget-object v2, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->identifier:Ljava/lang/String;

    invoke-virtual {v15, v2}, Lcom/adobe/mobile/ThirdPartyQueue;->deleteHit(Ljava/lang/String;)V
    :try_end_1
    .catch Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException; {:try_start_1 .. :try_end_1} :catch_1

    .line 258
    iget-wide v2, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->timestamp:J

    iput-wide v2, v15, Lcom/adobe/mobile/ThirdPartyQueue;->lastHitTimestamp:J

    goto :goto_0

    .line 238
    :cond_4
    const-string v2, ""

    goto :goto_2

    .line 239
    :cond_5
    const-string v2, ""

    goto :goto_3

    .line 242
    :cond_6
    iget v2, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->timeout:I

    mul-int/lit16 v2, v2, 0x3e8

    goto :goto_4

    .line 253
    :catch_1
    move-exception v11

    .line 254
    .restart local v11    # "ex":Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;
    invoke-virtual {v15, v11}, Lcom/adobe/mobile/ThirdPartyQueue;->resetDatabase(Ljava/lang/Exception;)V

    goto :goto_1

    .line 264
    .end local v11    # "ex":Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;
    :cond_7
    const-string v2, "%s - Unable to forward hit (%s)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/adobe/mobile/ThirdPartyQueue$1;->this$0:Lcom/adobe/mobile/ThirdPartyQueue;

    iget-object v6, v6, Lcom/adobe/mobile/ThirdPartyQueue;->logPrefix:Ljava/lang/String;

    aput-object v6, v3, v5

    const/4 v5, 0x1

    iget-object v6, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->urlFragment:Ljava/lang/String;

    aput-object v6, v3, v5

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 266
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mobile/MobileConfig;->getOfflineTrackingEnabled()Z

    move-result v2

    if-eqz v2, :cond_8

    .line 269
    const-wide/16 v8, 0x1e

    .line 270
    .local v8, "delay":J
    const-string v2, "%s - Network error, imposing internal cooldown (%d seconds)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/adobe/mobile/ThirdPartyQueue$1;->this$0:Lcom/adobe/mobile/ThirdPartyQueue;

    iget-object v6, v6, Lcom/adobe/mobile/ThirdPartyQueue;->logPrefix:Ljava/lang/String;

    aput-object v6, v3, v5

    const/4 v5, 0x1

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v3, v5

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 288
    const/4 v13, 0x0

    .local v13, "i":I
    :goto_5
    int-to-long v2, v13

    cmp-long v2, v2, v8

    if-gez v2, :cond_0

    :try_start_2
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mobile/MobileConfig;->networkConnectivity()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 289
    const-wide/16 v2, 0x3e8

    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_3

    .line 288
    add-int/lit8 v13, v13, 0x1

    goto :goto_5

    .line 275
    .end local v8    # "delay":J
    .end local v13    # "i":I
    :cond_8
    :try_start_3
    iget-object v2, v12, Lcom/adobe/mobile/AbstractHitDatabase$Hit;->identifier:Ljava/lang/String;

    invoke-virtual {v15, v2}, Lcom/adobe/mobile/ThirdPartyQueue;->deleteHit(Ljava/lang/String;)V
    :try_end_3
    .catch Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException; {:try_start_3 .. :try_end_3} :catch_2

    goto/16 :goto_0

    .line 277
    :catch_2
    move-exception v11

    .line 278
    .restart local v11    # "ex":Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;
    invoke-virtual {v15, v11}, Lcom/adobe/mobile/ThirdPartyQueue;->resetDatabase(Ljava/lang/Exception;)V

    goto/16 :goto_1

    .line 292
    .end local v11    # "ex":Lcom/adobe/mobile/AbstractDatabaseBacking$CorruptedDatabaseException;
    .restart local v8    # "delay":J
    .restart local v13    # "i":I
    :catch_3
    move-exception v10

    .line 293
    .local v10, "e":Ljava/lang/Exception;
    const-string v2, "%s - Background Thread Interrupted (%s)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/adobe/mobile/ThirdPartyQueue$1;->this$0:Lcom/adobe/mobile/ThirdPartyQueue;

    iget-object v6, v6, Lcom/adobe/mobile/ThirdPartyQueue;->logPrefix:Ljava/lang/String;

    aput-object v6, v3, v5

    const/4 v5, 0x1

    invoke-virtual {v10}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v3, v5

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0
.end method
