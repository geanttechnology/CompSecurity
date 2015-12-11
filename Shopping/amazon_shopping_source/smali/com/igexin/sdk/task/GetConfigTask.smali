.class public Lcom/igexin/sdk/task/GetConfigTask;
.super Lcom/igexin/sdk/task/HttpTask;
.source "GetConfigTask.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;[BLcom/igexin/sdk/CallbackListener;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "data"    # [B
    .param p3, "callbackListener"    # Lcom/igexin/sdk/CallbackListener;

    .prologue
    .line 23
    invoke-direct {p0, p1, p2, p3}, Lcom/igexin/sdk/task/HttpTask;-><init>(Ljava/lang/String;[BLcom/igexin/sdk/CallbackListener;)V

    .line 24
    return-void
.end method


# virtual methods
.method public parseData([B)V
    .locals 22
    .param p1, "data"    # [B

    .prologue
    .line 28
    const-string/jumbo v3, ""

    .line 29
    .local v3, "byteData":Ljava/lang/String;
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Lcom/igexin/sdk/SdkService;->getMetricsFactory()Lcom/amazon/client/metrics/MetricsFactory;

    move-result-object v16

    .line 30
    .local v16, "metricsFactory":Lcom/amazon/client/metrics/MetricsFactory;
    const-string/jumbo v18, "MShopAndroidGetuiLib"

    invoke-virtual/range {p0 .. p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v16

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    invoke-interface {v0, v1, v2}, Lcom/amazon/client/metrics/MetricsFactory;->createMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v15

    .line 32
    .local v15, "metricEvent":Lcom/amazon/client/metrics/MetricEvent;
    :try_start_0
    new-instance v4, Ljava/lang/String;

    const-string/jumbo v18, "utf-8"

    move-object/from16 v0, p1

    move-object/from16 v1, v18

    invoke-direct {v4, v0, v1}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 33
    .end local v3    # "byteData":Ljava/lang/String;
    .local v4, "byteData":Ljava/lang/String;
    :try_start_1
    new-instance v11, Lorg/json/JSONObject;

    invoke-direct {v11, v4}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 34
    .local v11, "jsonObject":Lorg/json/JSONObject;
    const-string/jumbo v18, "result"

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_8

    .line 35
    const-string/jumbo v18, "result"

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 37
    .local v17, "result":Ljava/lang/String;
    const-string/jumbo v18, "ok"

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_8

    .line 38
    new-instance v5, Lcom/igexin/sdk/data/DynamicConfig;

    invoke-direct {v5}, Lcom/igexin/sdk/data/DynamicConfig;-><init>()V

    .line 39
    .local v5, "cfg":Lcom/igexin/sdk/data/DynamicConfig;
    const-string/jumbo v18, "config"

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_5

    .line 40
    const-string/jumbo v18, "config"

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 42
    .local v6, "config":Ljava/lang/String;
    if-eqz v6, :cond_5

    const-string/jumbo v18, ""

    move-object/from16 v0, v18

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-nez v18, :cond_5

    const-string/jumbo v18, "null"

    move-object/from16 v0, v18

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-nez v18, :cond_5

    .line 43
    const/4 v10, 0x0

    .line 44
    .local v10, "isEncrypt":Z
    new-instance v7, Lorg/json/JSONObject;

    invoke-direct {v7, v6}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 45
    .local v7, "configJson":Lorg/json/JSONObject;
    const-string/jumbo v18, "sdk.encrypt.enable"

    move-object/from16 v0, v18

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_0

    .line 46
    const-string/jumbo v18, "sdk.encrypt.enable"

    move-object/from16 v0, v18

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v10

    .line 49
    :cond_0
    const/4 v8, 0x0

    .line 50
    .local v8, "downloadUrl":Ljava/lang/String;
    const-string/jumbo v18, "sdk.messagemanager.url"

    move-object/from16 v0, v18

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_1

    .line 51
    const-string/jumbo v18, "sdk.messagemanager.url"

    move-object/from16 v0, v18

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 52
    sget-object v18, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v20, "sdk.messagemanager.url = "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 55
    :cond_1
    const/4 v12, 0x0

    .line 56
    .local v12, "masterAppID":Ljava/lang/String;
    const-string/jumbo v18, "sdk.messagemanager.appid"

    move-object/from16 v0, v18

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_2

    .line 57
    const-string/jumbo v18, "sdk.messagemanager.appid"

    move-object/from16 v0, v18

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 58
    sget-object v18, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v20, "sdk.messagemanager.appid = "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 61
    :cond_2
    const/4 v13, 0x0

    .line 62
    .local v13, "masterPkgName":Ljava/lang/String;
    const-string/jumbo v18, "sdk.messagemanager.pkgname"

    move-object/from16 v0, v18

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_3

    .line 63
    const-string/jumbo v18, "sdk.messagemanager.pkgname"

    move-object/from16 v0, v18

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 64
    sget-object v18, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v20, "sdk.messagemanager.pkgname = "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 67
    :cond_3
    const/4 v14, 0x0

    .line 68
    .local v14, "masterServiceAction":Ljava/lang/String;
    const-string/jumbo v18, "sdk.messagemanager.startaction"

    move-object/from16 v0, v18

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_4

    .line 69
    const-string/jumbo v18, "sdk.messagemanager.startaction"

    move-object/from16 v0, v18

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 70
    sget-object v18, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v20, "sdk.messagemanager.startaction = "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 73
    :cond_4
    invoke-virtual {v5, v10}, Lcom/igexin/sdk/data/DynamicConfig;->setEncrypt(Z)V

    .line 74
    invoke-virtual {v5, v8}, Lcom/igexin/sdk/data/DynamicConfig;->setDownloadUrl(Ljava/lang/String;)V

    .line 75
    invoke-virtual {v5, v12}, Lcom/igexin/sdk/data/DynamicConfig;->setMasterAppID(Ljava/lang/String;)V

    .line 76
    invoke-virtual {v5, v13}, Lcom/igexin/sdk/data/DynamicConfig;->setMasterPkgName(Ljava/lang/String;)V

    .line 77
    invoke-virtual {v5, v14}, Lcom/igexin/sdk/data/DynamicConfig;->setMasterServiceAction(Ljava/lang/String;)V

    .line 81
    .end local v6    # "config":Ljava/lang/String;
    .end local v7    # "configJson":Lorg/json/JSONObject;
    .end local v8    # "downloadUrl":Ljava/lang/String;
    .end local v10    # "isEncrypt":Z
    .end local v12    # "masterAppID":Ljava/lang/String;
    .end local v13    # "masterPkgName":Ljava/lang/String;
    .end local v14    # "masterServiceAction":Ljava/lang/String;
    :cond_5
    const-string/jumbo v18, "PUSH:GETUI:GetConfig:Succeeded"

    const-wide/high16 v19, 0x3ff0000000000000L    # 1.0

    move-object/from16 v0, v18

    move-wide/from16 v1, v19

    invoke-interface {v15, v0, v1, v2}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 82
    move-object/from16 v0, v16

    invoke-interface {v0, v15}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 84
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/igexin/sdk/task/GetConfigTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    move-object/from16 v18, v0

    if-eqz v18, :cond_6

    .line 85
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/igexin/sdk/task/GetConfigTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-interface {v0, v5}, Lcom/igexin/sdk/CallbackListener;->getCallbackData(Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    :cond_6
    move-object v3, v4

    .line 98
    .end local v4    # "byteData":Ljava/lang/String;
    .end local v5    # "cfg":Lcom/igexin/sdk/data/DynamicConfig;
    .end local v11    # "jsonObject":Lorg/json/JSONObject;
    .end local v17    # "result":Ljava/lang/String;
    .restart local v3    # "byteData":Ljava/lang/String;
    :cond_7
    :goto_0
    return-void

    .end local v3    # "byteData":Ljava/lang/String;
    .restart local v4    # "byteData":Ljava/lang/String;
    .restart local v11    # "jsonObject":Lorg/json/JSONObject;
    :cond_8
    move-object v3, v4

    .line 93
    .end local v4    # "byteData":Ljava/lang/String;
    .end local v11    # "jsonObject":Lorg/json/JSONObject;
    .restart local v3    # "byteData":Ljava/lang/String;
    :goto_1
    const-string/jumbo v18, "PUSH:GETUI:GetConfig:Failed"

    const-wide/high16 v19, 0x3ff0000000000000L    # 1.0

    move-object/from16 v0, v18

    move-wide/from16 v1, v19

    invoke-interface {v15, v0, v1, v2}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 94
    move-object/from16 v0, v16

    invoke-interface {v0, v15}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 96
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/igexin/sdk/task/GetConfigTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    move-object/from16 v18, v0

    if-eqz v18, :cond_7

    .line 97
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/igexin/sdk/task/GetConfigTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    move-object/from16 v18, v0

    new-instance v19, Ljava/lang/Exception;

    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v21, "parseData failed! Data is "

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    invoke-direct/range {v19 .. v20}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    invoke-interface/range {v18 .. v19}, Lcom/igexin/sdk/CallbackListener;->exceptionHandler(Ljava/lang/Exception;)V

    goto :goto_0

    .line 89
    :catch_0
    move-exception v9

    .line 90
    .local v9, "e":Ljava/lang/Exception;
    :goto_2
    invoke-virtual {v9}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 89
    .end local v3    # "byteData":Ljava/lang/String;
    .end local v9    # "e":Ljava/lang/Exception;
    .restart local v4    # "byteData":Ljava/lang/String;
    :catch_1
    move-exception v9

    move-object v3, v4

    .end local v4    # "byteData":Ljava/lang/String;
    .restart local v3    # "byteData":Ljava/lang/String;
    goto :goto_2
.end method
