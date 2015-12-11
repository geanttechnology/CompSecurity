.class public abstract Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;
.super Ljava/lang/Thread;
.source "FlowServerRequestThread.java"


# instance fields
.field protected mApplicationURL:Ljava/lang/String;

.field protected mCustomParamsPair:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

.field protected mHttpManagerInterface:Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;

.field protected mId:I

.field protected mInputStream:Ljava/io/ByteArrayInputStream;

.field protected mMetadataParamsPair:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected mResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

.field mThreadIdAssigner:Ljava/util/concurrent/atomic/AtomicInteger;

.field protected mThreadPoolManagerInterface:Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;

.field protected m_isCancelled:Z


# direct methods
.method public constructor <init>(Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;Ljava/io/ByteArrayInputStream;Ljava/util/Map;Ljava/util/Map;)V
    .locals 2
    .param p1, "httpManagerInterface"    # Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;
    .param p2, "threadPoolManagerInterface"    # Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;
    .param p3, "deviceInfo"    # Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;
    .param p4, "applicationURL"    # Ljava/lang/String;
    .param p5, "responseType"    # Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    .param p6, "inputStream"    # Ljava/io/ByteArrayInputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;",
            "Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;",
            "Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;",
            "Ljava/lang/String;",
            "Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;",
            "Ljava/io/ByteArrayInputStream;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p7, "customParamsPair":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p8, "metadataParamsPair":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v1, 0x0

    .line 70
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 61
    iput-boolean v1, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->m_isCancelled:Z

    .line 62
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mThreadIdAssigner:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 71
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mHttpManagerInterface:Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;

    .line 72
    iput-object p3, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    .line 73
    iput-object p4, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mApplicationURL:Ljava/lang/String;

    .line 74
    iput-object p5, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 75
    iput-object p6, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mInputStream:Ljava/io/ByteArrayInputStream;

    .line 76
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mThreadIdAssigner:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v0

    iput v0, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mId:I

    .line 77
    iput-object p2, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mThreadPoolManagerInterface:Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;

    .line 78
    iput-object p7, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mCustomParamsPair:Ljava/util/Map;

    .line 79
    iput-object p8, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mMetadataParamsPair:Ljava/util/Map;

    .line 80
    return-void
.end method


# virtual methods
.method public cancelRequest()V
    .locals 1

    .prologue
    .line 83
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->m_isCancelled:Z

    .line 84
    return-void
.end method

.method protected getCommonPOSTData()Lorg/json/JSONObject;
    .locals 5

    .prologue
    .line 89
    :try_start_0
    new-instance v2, Lorg/json/JSONObject;

    iget-object v3, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mMetadataParamsPair:Ljava/util/Map;

    invoke-direct {v2, v3}, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V

    .line 91
    .local v2, "metadataJsonObject":Lorg/json/JSONObject;
    const-string/jumbo v3, "clientVersion"

    iget-object v4, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    invoke-virtual {v4}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getClientVersion()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 92
    const-string/jumbo v3, "clientDeviceId"

    iget-object v4, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    invoke-virtual {v4}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getClientDeviceId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 93
    const-string/jumbo v3, "clientId"

    iget-object v4, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    invoke-virtual {v4}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getClientId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 94
    const-string/jumbo v3, "clientDevice"

    iget-object v4, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    invoke-virtual {v4}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getClientDevice()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 95
    const-string/jumbo v3, "clientDeviceVersion"

    iget-object v4, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    invoke-virtual {v4}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getDeviceVersion()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 97
    iget-object v3, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    invoke-virtual {v3}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getConnectionType()Lcom/flow/android/engine/library/constants/ConnectionType;

    move-result-object v0

    .line 98
    .local v0, "connectionType":Lcom/flow/android/engine/library/constants/ConnectionType;
    const-string/jumbo v3, "connectionType"

    invoke-virtual {v0}, Lcom/flow/android/engine/library/constants/ConnectionType;->getNetworkName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 99
    const-string/jumbo v3, "connectionCellularGeneration"

    invoke-virtual {v0}, Lcom/flow/android/engine/library/constants/ConnectionType;->getNetworkType()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 100
    const-string/jumbo v3, "connectionCellularRadioTechnology"

    iget-object v4, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    invoke-virtual {v4}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getRawNetworkSubTypeId()I

    move-result v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 106
    .end local v0    # "connectionType":Lcom/flow/android/engine/library/constants/ConnectionType;
    .end local v2    # "metadataJsonObject":Lorg/json/JSONObject;
    :goto_0
    return-object v2

    .line 103
    :catch_0
    move-exception v1

    .line 104
    .local v1, "e":Ljava/lang/Exception;
    const-string/jumbo v3, "FlowServerRequestThread"

    const-string/jumbo v4, "Error "

    invoke-static {v3, v4, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 106
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    goto :goto_0
.end method

.method protected getResponseFromServer(Ljava/lang/String;Z)Ljava/lang/String;
    .locals 24
    .param p1, "requestMethodType"    # Ljava/lang/String;
    .param p2, "isGzipStream"    # Z

    .prologue
    .line 112
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mApplicationURL:Ljava/lang/String;

    move-object/from16 v19, v0

    .line 113
    .local v19, "urlString":Ljava/lang/String;
    const/4 v5, 0x0

    .line 114
    .local v5, "baos":Ljava/io/ByteArrayOutputStream;
    const/4 v12, 0x0

    .line 117
    .local v12, "is":Ljava/io/InputStream;
    :try_start_0
    new-instance v18, Ljava/net/URL;

    invoke-direct/range {v18 .. v19}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 118
    .local v18, "url":Ljava/net/URL;
    invoke-virtual/range {v18 .. v18}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v8

    check-cast v8, Ljava/net/HttpURLConnection;

    .line 119
    .local v8, "con":Ljava/net/HttpURLConnection;
    move-object/from16 v0, p1

    invoke-virtual {v8, v0}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 120
    const/16 v20, 0x1

    move/from16 v0, v20

    invoke-virtual {v8, v0}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 121
    const/16 v20, 0x1

    move/from16 v0, v20

    invoke-virtual {v8, v0}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    .line 122
    const/16 v20, 0x0

    move/from16 v0, v20

    invoke-virtual {v8, v0}, Ljava/net/HttpURLConnection;->setUseCaches(Z)V

    .line 123
    const/16 v20, 0x0

    move/from16 v0, v20

    invoke-virtual {v8, v0}, Ljava/net/HttpURLConnection;->setDefaultUseCaches(Z)V

    .line 124
    const/16 v20, 0x5dc

    move/from16 v0, v20

    invoke-virtual {v8, v0}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 126
    invoke-static {}, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->createBoundary()Ljava/lang/String;

    move-result-object v7

    .line 127
    .local v7, "boundary":Ljava/lang/String;
    const-string/jumbo v20, "Accept"

    const-string/jumbo v21, "*/*"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v8, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 128
    const-string/jumbo v20, "Content-Type"

    invoke-static {v7}, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->getContentType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v8, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    const-string/jumbo v20, "Connection"

    const-string/jumbo v21, "Keep-Alive"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v8, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    const-string/jumbo v20, "Cache-Control"

    const-string/jumbo v21, "no-cache"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v8, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    if-eqz p2, :cond_0

    .line 132
    const-string/jumbo v20, "Accept-Encoding"

    const-string/jumbo v21, "gzip"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v8, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 134
    :cond_0
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->connect()V

    .line 136
    new-instance v15, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;

    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-direct {v15, v0, v7}, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;-><init>(Ljava/io/OutputStream;Ljava/lang/String;)V

    .line 137
    .local v15, "mpout":Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;
    const-string/jumbo v20, "username"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getKey()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v15, v0, v1}, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->writeField(Ljava/lang/String;Ljava/lang/String;)V

    .line 138
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getTimestampInEpochSeconds()Ljava/lang/String;

    move-result-object v17

    .line 139
    .local v17, "timestamp":Ljava/lang/String;
    const-string/jumbo v20, "authtoken"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getAuthtoken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v15, v0, v1}, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->writeField(Ljava/lang/String;Ljava/lang/String;)V

    .line 140
    const-string/jumbo v20, "ts"

    move-object/from16 v0, v20

    move-object/from16 v1, v17

    invoke-virtual {v15, v0, v1}, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->writeField(Ljava/lang/String;Ljava/lang/String;)V

    .line 141
    const-string/jumbo v20, "application"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getApplication()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v15, v0, v1}, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->writeField(Ljava/lang/String;Ljava/lang/String;)V

    .line 142
    const-string/jumbo v20, "disableImageStorage"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mDeviceInfo:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->isDataCollectionDisabled()Z

    move-result v21

    move-object/from16 v0, v20

    move/from16 v1, v21

    invoke-virtual {v15, v0, v1}, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->writeField(Ljava/lang/String;Z)V

    .line 145
    invoke-virtual/range {p0 .. p0}, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->getCommonPOSTData()Lorg/json/JSONObject;

    move-result-object v14

    .line 146
    .local v14, "jsonObject":Lorg/json/JSONObject;
    const-string/jumbo v20, "query_metadata"

    invoke-virtual {v14}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v15, v0, v1}, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->writeField(Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mCustomParamsPair:Ljava/util/Map;

    move-object/from16 v20, v0

    if-eqz v20, :cond_1

    .line 150
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mCustomParamsPair:Ljava/util/Map;

    move-object/from16 v20, v0

    invoke-interface/range {v20 .. v20}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .local v11, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_1

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/util/Map$Entry;

    .line 151
    .local v10, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v10}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/String;

    invoke-interface {v10}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v21

    check-cast v21, Ljava/lang/String;

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v15, v0, v1}, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->writeField(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 173
    .end local v7    # "boundary":Ljava/lang/String;
    .end local v8    # "con":Ljava/net/HttpURLConnection;
    .end local v10    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v11    # "i$":Ljava/util/Iterator;
    .end local v14    # "jsonObject":Lorg/json/JSONObject;
    .end local v15    # "mpout":Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;
    .end local v17    # "timestamp":Ljava/lang/String;
    .end local v18    # "url":Ljava/net/URL;
    :catch_0
    move-exception v9

    .line 174
    .local v9, "e":Ljava/lang/Exception;
    :goto_1
    :try_start_1
    const-string/jumbo v20, "FlowServerRequestThread"

    const-string/jumbo v21, "Error "

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-static {v0, v1, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 176
    invoke-static {v5}, Lcom/flow/android/engine/library/impl/servermatch/StreamHelper;->closeOutputStream(Ljava/io/OutputStream;)V

    .line 177
    invoke-static {v12}, Lcom/flow/android/engine/library/impl/servermatch/StreamHelper;->closeInputStream(Ljava/io/InputStream;)V

    .line 179
    const-string/jumbo v16, ""

    .end local v9    # "e":Ljava/lang/Exception;
    :goto_2
    return-object v16

    .line 155
    .restart local v7    # "boundary":Ljava/lang/String;
    .restart local v8    # "con":Ljava/net/HttpURLConnection;
    .restart local v14    # "jsonObject":Lorg/json/JSONObject;
    .restart local v15    # "mpout":Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;
    .restart local v17    # "timestamp":Ljava/lang/String;
    .restart local v18    # "url":Ljava/net/URL;
    :cond_1
    :try_start_2
    const-string/jumbo v20, "file"

    const-string/jumbo v21, "image/jpeg"

    const-string/jumbo v22, "image.jpg"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->mInputStream:Ljava/io/ByteArrayInputStream;

    move-object/from16 v23, v0

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    move-object/from16 v3, v23

    invoke-virtual {v15, v0, v1, v2, v3}, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->writeFile(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V

    .line 156
    invoke-virtual {v15}, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->flush()V

    .line 157
    invoke-virtual {v15}, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->close()V

    .line 159
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v12

    .line 160
    new-instance v6, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v6}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 161
    .end local v5    # "baos":Ljava/io/ByteArrayOutputStream;
    .local v6, "baos":Ljava/io/ByteArrayOutputStream;
    if-eqz p2, :cond_2

    :try_start_3
    const-string/jumbo v20, "gzip"

    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->getContentEncoding()Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_2

    .line 162
    new-instance v13, Ljava/util/zip/GZIPInputStream;

    invoke-direct {v13, v12}, Ljava/util/zip/GZIPInputStream;-><init>(Ljava/io/InputStream;)V

    .end local v12    # "is":Ljava/io/InputStream;
    .local v13, "is":Ljava/io/InputStream;
    move-object v12, v13

    .line 165
    .end local v13    # "is":Ljava/io/InputStream;
    .restart local v12    # "is":Ljava/io/InputStream;
    :cond_2
    :goto_3
    invoke-virtual {v12}, Ljava/io/InputStream;->read()I

    move-result v4

    .local v4, "b":I
    const/16 v20, -0x1

    move/from16 v0, v20

    if-eq v4, v0, :cond_3

    .line 166
    invoke-virtual {v6, v4}, Ljava/io/ByteArrayOutputStream;->write(I)V

    goto :goto_3

    .line 173
    .end local v4    # "b":I
    :catch_1
    move-exception v9

    move-object v5, v6

    .end local v6    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v5    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_1

    .line 168
    .end local v5    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v4    # "b":I
    .restart local v6    # "baos":Ljava/io/ByteArrayOutputStream;
    :cond_3
    invoke-virtual {v6}, Ljava/io/ByteArrayOutputStream;->flush()V

    .line 170
    invoke-virtual {v6}, Ljava/io/ByteArrayOutputStream;->toString()Ljava/lang/String;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-result-object v16

    .line 176
    .local v16, "response":Ljava/lang/String;
    invoke-static {v6}, Lcom/flow/android/engine/library/impl/servermatch/StreamHelper;->closeOutputStream(Ljava/io/OutputStream;)V

    .line 177
    invoke-static {v12}, Lcom/flow/android/engine/library/impl/servermatch/StreamHelper;->closeInputStream(Ljava/io/InputStream;)V

    move-object v5, v6

    .end local v6    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v5    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_2

    .line 176
    .end local v4    # "b":I
    .end local v7    # "boundary":Ljava/lang/String;
    .end local v8    # "con":Ljava/net/HttpURLConnection;
    .end local v14    # "jsonObject":Lorg/json/JSONObject;
    .end local v15    # "mpout":Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;
    .end local v16    # "response":Ljava/lang/String;
    .end local v17    # "timestamp":Ljava/lang/String;
    .end local v18    # "url":Ljava/net/URL;
    :catchall_0
    move-exception v20

    :goto_4
    invoke-static {v5}, Lcom/flow/android/engine/library/impl/servermatch/StreamHelper;->closeOutputStream(Ljava/io/OutputStream;)V

    .line 177
    invoke-static {v12}, Lcom/flow/android/engine/library/impl/servermatch/StreamHelper;->closeInputStream(Ljava/io/InputStream;)V

    throw v20

    .line 176
    .end local v5    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v6    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v7    # "boundary":Ljava/lang/String;
    .restart local v8    # "con":Ljava/net/HttpURLConnection;
    .restart local v14    # "jsonObject":Lorg/json/JSONObject;
    .restart local v15    # "mpout":Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;
    .restart local v17    # "timestamp":Ljava/lang/String;
    .restart local v18    # "url":Ljava/net/URL;
    :catchall_1
    move-exception v20

    move-object v5, v6

    .end local v6    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v5    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_4
.end method
