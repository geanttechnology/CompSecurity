.class public Lcom/flow/android/engine/library/impl/servermatch/threads/MetricsReporter;
.super Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;
.source "MetricsReporter.java"


# static fields
.field private static mMetricsReportingLock:Ljava/lang/Object;


# instance fields
.field private mEngineMetrics:Lcom/flow/android/engine/library/FlowStateEngineMetrics;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 56
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/flow/android/engine/library/impl/servermatch/threads/MetricsReporter;->mMetricsReportingLock:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;Ljava/io/ByteArrayInputStream;Lcom/flow/android/engine/library/FlowStateEngineMetrics;)V
    .locals 10
    .param p1, "httpManagerInterface"    # Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;
    .param p2, "threadPoolManagerInterface"    # Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;
    .param p3, "a_deviceInfo"    # Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;
    .param p4, "a_applicationURL"    # Ljava/lang/String;
    .param p5, "a_responseType"    # Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    .param p6, "a_inputStream"    # Ljava/io/ByteArrayInputStream;
    .param p7, "a_engineMetrics"    # Lcom/flow/android/engine/library/FlowStateEngineMetrics;

    .prologue
    .line 59
    const/4 v8, 0x0

    const/4 v9, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    move-object/from16 v7, p6

    invoke-direct/range {v1 .. v9}, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;-><init>(Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;Ljava/io/ByteArrayInputStream;Ljava/util/Map;Ljava/util/Map;)V

    .line 60
    move-object/from16 v0, p7

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/MetricsReporter;->mEngineMetrics:Lcom/flow/android/engine/library/FlowStateEngineMetrics;

    .line 61
    return-void
.end method

.method private sendMetricsToServer()V
    .locals 18

    .prologue
    .line 73
    :try_start_0
    new-instance v10, Lorg/json/JSONObject;

    invoke-direct {v10}, Lorg/json/JSONObject;-><init>()V

    .line 74
    .local v10, "jObj":Lorg/json/JSONObject;
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 75
    .local v3, "counters":Lorg/json/JSONObject;
    new-instance v14, Lorg/json/JSONObject;

    invoke-direct {v14}, Lorg/json/JSONObject;-><init>()V

    .line 78
    .local v14, "timing":Lorg/json/JSONObject;
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/flow/android/engine/library/impl/servermatch/threads/MetricsReporter;->mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    invoke-virtual {v15}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getClientVersion()Ljava/lang/String;

    move-result-object v2

    .line 79
    .local v2, "appVersion":Ljava/lang/String;
    const-string/jumbo v15, "DEVICE_ID"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/flow/android/engine/library/impl/servermatch/threads/MetricsReporter;->mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getClientDeviceId()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v10, v15, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 80
    const-string/jumbo v15, "MODEL"

    sget-object v16, Landroid/os/Build;->MODEL:Ljava/lang/String;

    move-object/from16 v0, v16

    invoke-virtual {v10, v15, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 81
    const-string/jumbo v15, "PLATFORM_VERSION"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v17, ""

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    sget v17, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v10, v15, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 82
    const-string/jumbo v15, "PLATFORM"

    const-string/jumbo v16, "Android"

    move-object/from16 v0, v16

    invoke-virtual {v10, v15, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 83
    const-string/jumbo v15, "Marketplace"

    const/16 v16, 0x1

    move/from16 v0, v16

    invoke-virtual {v10, v15, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 84
    const-string/jumbo v15, "SESSION_ID"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/flow/android/engine/library/impl/servermatch/threads/MetricsReporter;->mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getClientId()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v10, v15, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 85
    const-string/jumbo v15, "APP_VERSION"

    invoke-virtual {v10, v15, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 86
    const-string/jumbo v15, "Program"

    const-string/jumbo v16, "Amazon"

    move-object/from16 v0, v16

    invoke-virtual {v10, v15, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 87
    const-string/jumbo v15, "TIMESTAMP"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v16

    move-wide/from16 v0, v16

    invoke-virtual {v10, v15, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 88
    const-string/jumbo v15, "Operation"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v17, "Amazon"

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string/jumbo v17, "Metrics"

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string/jumbo v17, "Android"

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v10, v15, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 91
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/flow/android/engine/library/impl/servermatch/threads/MetricsReporter;->mEngineMetrics:Lcom/flow/android/engine/library/FlowStateEngineMetrics;

    if-eqz v15, :cond_0

    .line 92
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/flow/android/engine/library/impl/servermatch/threads/MetricsReporter;->mEngineMetrics:Lcom/flow/android/engine/library/FlowStateEngineMetrics;

    invoke-virtual {v15}, Lcom/flow/android/engine/library/FlowStateEngineMetrics;->getCounters()Ljava/util/Map;

    move-result-object v4

    .line 93
    .local v4, "engineCounters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    invoke-interface {v4}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v15

    invoke-interface {v15}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_1

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    .line 94
    .local v11, "key":Ljava/lang/String;
    invoke-interface {v4, v11}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    invoke-virtual {v3, v11, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_0

    .line 128
    .end local v2    # "appVersion":Ljava/lang/String;
    .end local v3    # "counters":Lorg/json/JSONObject;
    .end local v4    # "engineCounters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    .end local v9    # "i$":Ljava/util/Iterator;
    .end local v10    # "jObj":Lorg/json/JSONObject;
    .end local v11    # "key":Ljava/lang/String;
    .end local v14    # "timing":Lorg/json/JSONObject;
    :catch_0
    move-exception v15

    .line 137
    :cond_0
    :goto_1
    return-void

    .line 96
    .restart local v2    # "appVersion":Ljava/lang/String;
    .restart local v3    # "counters":Lorg/json/JSONObject;
    .restart local v4    # "engineCounters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    .restart local v9    # "i$":Ljava/util/Iterator;
    .restart local v10    # "jObj":Lorg/json/JSONObject;
    .restart local v14    # "timing":Lorg/json/JSONObject;
    :cond_1
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/flow/android/engine/library/impl/servermatch/threads/MetricsReporter;->mEngineMetrics:Lcom/flow/android/engine/library/FlowStateEngineMetrics;

    invoke-virtual {v15}, Lcom/flow/android/engine/library/FlowStateEngineMetrics;->getTiming()Ljava/util/Map;

    move-result-object v5

    .line 97
    .local v5, "engineTiming":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Double;>;"
    invoke-interface {v5}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v15

    invoke-interface {v15}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_2
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_2

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    .line 98
    .restart local v11    # "key":Ljava/lang/String;
    invoke-interface {v5, v11}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    invoke-virtual {v14, v11, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_2

    .line 130
    .end local v2    # "appVersion":Ljava/lang/String;
    .end local v3    # "counters":Lorg/json/JSONObject;
    .end local v4    # "engineCounters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    .end local v5    # "engineTiming":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Double;>;"
    .end local v9    # "i$":Ljava/util/Iterator;
    .end local v10    # "jObj":Lorg/json/JSONObject;
    .end local v11    # "key":Ljava/lang/String;
    .end local v14    # "timing":Lorg/json/JSONObject;
    :catch_1
    move-exception v15

    goto :goto_1

    .line 100
    .restart local v2    # "appVersion":Ljava/lang/String;
    .restart local v3    # "counters":Lorg/json/JSONObject;
    .restart local v4    # "engineCounters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    .restart local v5    # "engineTiming":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Double;>;"
    .restart local v9    # "i$":Ljava/util/Iterator;
    .restart local v10    # "jObj":Lorg/json/JSONObject;
    .restart local v14    # "timing":Lorg/json/JSONObject;
    :cond_2
    invoke-virtual {v3}, Lorg/json/JSONObject;->length()I

    move-result v15

    if-eqz v15, :cond_3

    .line 101
    const-string/jumbo v15, "counters"

    invoke-virtual {v10, v15, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 103
    :cond_3
    invoke-virtual {v14}, Lorg/json/JSONObject;->length()I

    move-result v15

    if-eqz v15, :cond_4

    .line 104
    const-string/jumbo v15, "timing"

    invoke-virtual {v10, v15, v14}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 112
    :cond_4
    new-instance v6, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v6}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 115
    .local v6, "httpParameters":Lorg/apache/http/params/HttpParams;
    const/16 v13, 0x1388

    .line 116
    .local v13, "timeoutConnection":I
    invoke-static {v6, v13}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 119
    new-instance v7, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v7, v6}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/params/HttpParams;)V

    .line 120
    .local v7, "httpclient":Lorg/apache/http/client/HttpClient;
    new-instance v8, Lorg/apache/http/client/methods/HttpPost;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/flow/android/engine/library/impl/servermatch/threads/MetricsReporter;->mApplicationURL:Ljava/lang/String;

    invoke-direct {v8, v15}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 122
    .local v8, "httppost":Lorg/apache/http/client/methods/HttpPost;
    new-instance v12, Ljava/util/ArrayList;

    const/4 v15, 0x1

    invoke-direct {v12, v15}, Ljava/util/ArrayList;-><init>(I)V

    .line 123
    .local v12, "nameValuePairs":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    new-instance v15, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v16, "DATA"

    invoke-virtual {v10}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-direct/range {v15 .. v17}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v12, v15}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 124
    new-instance v15, Lorg/apache/http/client/entity/UrlEncodedFormEntity;

    invoke-direct {v15, v12}, Lorg/apache/http/client/entity/UrlEncodedFormEntity;-><init>(Ljava/util/List;)V

    invoke-virtual {v8, v15}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 127
    invoke-interface {v7, v8}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3

    goto :goto_1

    .line 132
    .end local v2    # "appVersion":Ljava/lang/String;
    .end local v3    # "counters":Lorg/json/JSONObject;
    .end local v4    # "engineCounters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    .end local v5    # "engineTiming":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Double;>;"
    .end local v6    # "httpParameters":Lorg/apache/http/params/HttpParams;
    .end local v7    # "httpclient":Lorg/apache/http/client/HttpClient;
    .end local v8    # "httppost":Lorg/apache/http/client/methods/HttpPost;
    .end local v9    # "i$":Ljava/util/Iterator;
    .end local v10    # "jObj":Lorg/json/JSONObject;
    .end local v12    # "nameValuePairs":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    .end local v13    # "timeoutConnection":I
    .end local v14    # "timing":Lorg/json/JSONObject;
    :catch_2
    move-exception v15

    goto :goto_1

    .line 134
    :catch_3
    move-exception v15

    goto :goto_1
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 65
    sget-object v1, Lcom/flow/android/engine/library/impl/servermatch/threads/MetricsReporter;->mMetricsReportingLock:Ljava/lang/Object;

    monitor-enter v1

    .line 66
    :try_start_0
    invoke-direct {p0}, Lcom/flow/android/engine/library/impl/servermatch/threads/MetricsReporter;->sendMetricsToServer()V

    .line 67
    monitor-exit v1

    .line 68
    return-void

    .line 67
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
