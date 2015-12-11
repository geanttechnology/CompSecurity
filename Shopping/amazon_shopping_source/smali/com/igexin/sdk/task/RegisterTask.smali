.class public Lcom/igexin/sdk/task/RegisterTask;
.super Lcom/igexin/sdk/task/HttpTask;
.source "RegisterTask.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;[BLcom/igexin/sdk/CallbackListener;Z)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "data"    # [B
    .param p3, "callbackListener"    # Lcom/igexin/sdk/CallbackListener;
    .param p4, "isEncrypt"    # Z

    .prologue
    .line 21
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/igexin/sdk/task/HttpTask;-><init>(Ljava/lang/String;[BLcom/igexin/sdk/CallbackListener;Z)V

    .line 22
    return-void
.end method


# virtual methods
.method public parseData([B)V
    .locals 9
    .param p1, "data"    # [B

    .prologue
    .line 28
    :try_start_0
    new-instance v4, Ljava/lang/String;

    const-string/jumbo v6, "utf-8"

    invoke-direct {v4, p1, v6}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    .line 29
    .local v4, "result":Ljava/lang/String;
    sget-object v6, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "RegisterTast parseData result:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 30
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, v4}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 31
    .local v1, "json":Lorg/json/JSONObject;
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v6

    invoke-virtual {v6}, Lcom/igexin/sdk/SdkService;->getMetricsFactory()Lcom/amazon/client/metrics/MetricsFactory;

    move-result-object v3

    .line 32
    .local v3, "metricsFactory":Lcom/amazon/client/metrics/MetricsFactory;
    const-string/jumbo v6, "MShopAndroidGetuiLib"

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v3, v6, v7}, Lcom/amazon/client/metrics/MetricsFactory;->createMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v2

    .line 33
    .local v2, "metricEvent":Lcom/amazon/client/metrics/MetricEvent;
    const-string/jumbo v6, "ok"

    const-string/jumbo v7, "result"

    invoke-virtual {v1, v7}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 34
    const-string/jumbo v6, "PUSH:GETUI:VCIDRegister:Succeeded"

    const-wide/high16 v7, 0x3ff0000000000000L    # 1.0

    invoke-interface {v2, v6, v7, v8}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 35
    const-string/jumbo v6, "vcid"

    invoke-virtual {v1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 36
    .local v5, "vcid":Ljava/lang/String;
    iget-object v6, p0, Lcom/igexin/sdk/task/RegisterTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    if-eqz v6, :cond_0

    .line 37
    iget-object v6, p0, Lcom/igexin/sdk/task/RegisterTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    invoke-interface {v6, v5}, Lcom/igexin/sdk/CallbackListener;->getCallbackData(Ljava/lang/Object;)V

    .line 42
    .end local v5    # "vcid":Ljava/lang/String;
    :cond_0
    :goto_0
    invoke-interface {v3, v2}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 48
    .end local v1    # "json":Lorg/json/JSONObject;
    .end local v2    # "metricEvent":Lcom/amazon/client/metrics/MetricEvent;
    .end local v3    # "metricsFactory":Lcom/amazon/client/metrics/MetricsFactory;
    .end local v4    # "result":Ljava/lang/String;
    :goto_1
    return-void

    .line 40
    .restart local v1    # "json":Lorg/json/JSONObject;
    .restart local v2    # "metricEvent":Lcom/amazon/client/metrics/MetricEvent;
    .restart local v3    # "metricsFactory":Lcom/amazon/client/metrics/MetricsFactory;
    .restart local v4    # "result":Ljava/lang/String;
    :cond_1
    const-string/jumbo v6, "PUSH:GETUI:VCIDRegister:Failed"

    const-wide/high16 v7, 0x3ff0000000000000L    # 1.0

    invoke-interface {v2, v6, v7, v8}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 44
    .end local v1    # "json":Lorg/json/JSONObject;
    .end local v2    # "metricEvent":Lcom/amazon/client/metrics/MetricEvent;
    .end local v3    # "metricsFactory":Lcom/amazon/client/metrics/MetricsFactory;
    .end local v4    # "result":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 46
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method
