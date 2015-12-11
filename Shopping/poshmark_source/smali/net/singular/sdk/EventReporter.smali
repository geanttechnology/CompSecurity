.class Lnet/singular/sdk/EventReporter;
.super Ljava/lang/Object;
.source "EventReporter.java"


# instance fields
.field private final log:Lnet/singular/sdk/SingularLog;

.field private final time_helper:Lnet/singular/sdk/TimeHelper;


# direct methods
.method public constructor <init>(Lnet/singular/sdk/SingularLog;Lnet/singular/sdk/TimeHelper;)V
    .locals 0
    .param p1, "log"    # Lnet/singular/sdk/SingularLog;
    .param p2, "timeHelper"    # Lnet/singular/sdk/TimeHelper;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object p2, p0, Lnet/singular/sdk/EventReporter;->time_helper:Lnet/singular/sdk/TimeHelper;

    .line 29
    iput-object p1, p0, Lnet/singular/sdk/EventReporter;->log:Lnet/singular/sdk/SingularLog;

    .line 30
    return-void
.end method

.method private getBasicJsonObject(Lorg/json/JSONObject;)Lorg/json/JSONObject;
    .locals 4
    .param p1, "persistent_identifiers_and_counters"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 132
    new-instance v1, Lorg/json/JSONObject;

    instance-of v1, p1, Lorg/json/JSONObject;

    if-nez v1, :cond_0

    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    .end local p1    # "persistent_identifiers_and_counters":Lorg/json/JSONObject;
    :goto_0
    invoke-static {v1}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 133
    .local v0, "jsonObject":Lorg/json/JSONObject;
    const-string v1, "send_timestamp_s"

    iget-object v2, p0, Lnet/singular/sdk/EventReporter;->time_helper:Lnet/singular/sdk/TimeHelper;

    invoke-virtual {v2}, Lnet/singular/sdk/TimeHelper;->currentTimeSeconds()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 134
    return-object v0

    .line 132
    .end local v0    # "jsonObject":Lorg/json/JSONObject;
    .restart local p1    # "persistent_identifiers_and_counters":Lorg/json/JSONObject;
    :cond_0
    check-cast p1, Lorg/json/JSONObject;

    .end local p1    # "persistent_identifiers_and_counters":Lorg/json/JSONObject;
    invoke-static {p1}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method private sendJsonObject(Ljava/lang/String;Lorg/json/JSONObject;)Landroid/util/Pair;
    .locals 14
    .param p1, "eventUrl"    # Ljava/lang/String;
    .param p2, "params"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            ")",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Integer;",
            "Lorg/json/JSONObject;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lnet/singular/sdk/InvalidArgumentException;
        }
    .end annotation

    .prologue
    .line 66
    new-instance v5, Lorg/apache/http/client/methods/HttpPost;

    invoke-direct {v5, p1}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 71
    .local v5, "httpPost":Lorg/apache/http/client/methods/HttpPost;
    :try_start_0
    new-instance v1, Lorg/apache/http/entity/ByteArrayEntity;

    move-object/from16 v0, p2

    instance-of v11, v0, Lorg/json/JSONObject;

    if-nez v11, :cond_2

    invoke-virtual/range {p2 .. p2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v11

    .end local p2    # "params":Lorg/json/JSONObject;
    :goto_0
    const-string v12, "UTF8"

    invoke-virtual {v11, v12}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v11

    invoke-direct {v1, v11}, Lorg/apache/http/entity/ByteArrayEntity;-><init>([B)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 78
    .local v1, "byteEntity":Lorg/apache/http/entity/ByteArrayEntity;
    invoke-virtual {v5, v1}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 81
    const-string v11, "Accept"

    const-string v12, "application/json"

    invoke-virtual {v5, v11, v12}, Lorg/apache/http/client/methods/HttpPost;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    const-string v11, "Content-type"

    const-string v12, "application/json"

    invoke-virtual {v5, v11, v12}, Lorg/apache/http/client/methods/HttpPost;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    new-instance v4, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v4}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 84
    .local v4, "httpParameters":Lorg/apache/http/params/HttpParams;
    const/16 v11, 0x7530

    invoke-static {v4, v11}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 86
    const v11, 0xea60

    invoke-static {v4, v11}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 88
    new-instance v2, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v2, v4}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/params/HttpParams;)V

    .line 91
    .local v2, "client":Lorg/apache/http/client/HttpClient;
    :try_start_1
    instance-of v11, v2, Lorg/apache/http/client/HttpClient;

    if-nez v11, :cond_3

    invoke-interface {v2, v5}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v7

    .line 92
    .local v7, "response":Lorg/apache/http/HttpResponse;
    :goto_1
    invoke-interface {v7}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v11

    invoke-static {v11}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;)Ljava/lang/String;

    move-result-object v10

    .line 93
    .local v10, "stringResponse":Ljava/lang/String;
    invoke-interface {v7}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v9

    .line 94
    .local v9, "statusLine":Lorg/apache/http/StatusLine;
    invoke-interface {v9}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v8

    .line 95
    .local v8, "statusCode":I
    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6}, Lorg/json/JSONObject;-><init>()V

    .line 96
    .local v6, "jsonResponse":Lorg/json/JSONObject;
    invoke-virtual {v10}, Ljava/lang/String;->length()I
    :try_end_1
    .catch Lorg/apache/http/conn/HttpHostConnectException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/net/UnknownHostException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_5
    .catch Ljava/lang/AssertionError; {:try_start_1 .. :try_end_1} :catch_6
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v11

    if-lez v11, :cond_0

    .line 98
    :try_start_2
    new-instance v11, Lorg/json/JSONObject;

    invoke-static {v10}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONObject;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Lorg/apache/http/conn/HttpHostConnectException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/net/UnknownHostException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_2 .. :try_end_2} :catch_4
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_5
    .catch Ljava/lang/AssertionError; {:try_start_2 .. :try_end_2} :catch_6
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v6

    .line 103
    :cond_0
    :goto_2
    :try_start_3
    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-static {v11, v6}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    :try_end_3
    .catch Lorg/apache/http/conn/HttpHostConnectException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/net/UnknownHostException; {:try_start_3 .. :try_end_3} :catch_3
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_3 .. :try_end_3} :catch_4
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_5
    .catch Ljava/lang/AssertionError; {:try_start_3 .. :try_end_3} :catch_6
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v11

    .line 120
    invoke-interface {v2}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v12

    if-eqz v12, :cond_1

    .line 121
    invoke-interface {v2}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v12

    invoke-interface {v12}, Lorg/apache/http/conn/ClientConnectionManager;->shutdown()V

    .line 125
    .end local v6    # "jsonResponse":Lorg/json/JSONObject;
    .end local v7    # "response":Lorg/apache/http/HttpResponse;
    .end local v8    # "statusCode":I
    .end local v9    # "statusLine":Lorg/apache/http/StatusLine;
    .end local v10    # "stringResponse":Ljava/lang/String;
    :cond_1
    :goto_3
    return-object v11

    .line 71
    .end local v1    # "byteEntity":Lorg/apache/http/entity/ByteArrayEntity;
    .end local v2    # "client":Lorg/apache/http/client/HttpClient;
    .end local v4    # "httpParameters":Lorg/apache/http/params/HttpParams;
    .restart local p2    # "params":Lorg/json/JSONObject;
    :cond_2
    :try_start_4
    check-cast p2, Lorg/json/JSONObject;

    .end local p2    # "params":Lorg/json/JSONObject;
    invoke-static/range {p2 .. p2}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;
    :try_end_4
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_4 .. :try_end_4} :catch_0

    move-result-object v11

    goto :goto_0

    .line 72
    :catch_0
    move-exception v3

    .line 74
    .local v3, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v11, Lnet/singular/sdk/InvalidArgumentException;

    const-string v12, "Invalid JSON in EventReporter"

    invoke-direct {v11, v12, v3}, Lnet/singular/sdk/InvalidArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v11

    .line 91
    .end local v3    # "e":Ljava/io/UnsupportedEncodingException;
    .restart local v1    # "byteEntity":Lorg/apache/http/entity/ByteArrayEntity;
    .restart local v2    # "client":Lorg/apache/http/client/HttpClient;
    .restart local v4    # "httpParameters":Lorg/apache/http/params/HttpParams;
    :cond_3
    :try_start_5
    move-object v0, v2

    check-cast v0, Lorg/apache/http/client/HttpClient;

    move-object v11, v0

    invoke-static {v11, v5}, Lcom/newrelic/agent/android/instrumentation/HttpInstrumentation;->execute(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v7

    goto :goto_1

    .line 99
    .restart local v6    # "jsonResponse":Lorg/json/JSONObject;
    .restart local v7    # "response":Lorg/apache/http/HttpResponse;
    .restart local v8    # "statusCode":I
    .restart local v9    # "statusLine":Lorg/apache/http/StatusLine;
    .restart local v10    # "stringResponse":Ljava/lang/String;
    :catch_1
    move-exception v3

    .line 100
    .local v3, "e":Lorg/json/JSONException;
    iget-object v11, p0, Lnet/singular/sdk/EventReporter;->log:Lnet/singular/sdk/SingularLog;

    const-string v12, "singular_sdk"

    const-string v13, "Invalid JSON response"

    invoke-virtual {v11, v12, v13, v3}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_5
    .catch Lorg/apache/http/conn/HttpHostConnectException; {:try_start_5 .. :try_end_5} :catch_2
    .catch Ljava/net/UnknownHostException; {:try_start_5 .. :try_end_5} :catch_3
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_5 .. :try_end_5} :catch_4
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_5
    .catch Ljava/lang/AssertionError; {:try_start_5 .. :try_end_5} :catch_6
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_2

    .line 104
    .end local v3    # "e":Lorg/json/JSONException;
    .end local v6    # "jsonResponse":Lorg/json/JSONObject;
    .end local v7    # "response":Lorg/apache/http/HttpResponse;
    .end local v8    # "statusCode":I
    .end local v9    # "statusLine":Lorg/apache/http/StatusLine;
    .end local v10    # "stringResponse":Ljava/lang/String;
    :catch_2
    move-exception v3

    .line 106
    .local v3, "e":Lorg/apache/http/conn/HttpHostConnectException;
    :try_start_6
    iget-object v11, p0, Lnet/singular/sdk/EventReporter;->log:Lnet/singular/sdk/SingularLog;

    const-string v12, "singular_sdk"

    const-string v13, "HttpHostConnectException in EventReporter"

    invoke-virtual {v11, v12, v13, v3}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 120
    invoke-interface {v2}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v11

    if-eqz v11, :cond_4

    .line 121
    invoke-interface {v2}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v11

    invoke-interface {v11}, Lorg/apache/http/conn/ClientConnectionManager;->shutdown()V

    .line 125
    .end local v3    # "e":Lorg/apache/http/conn/HttpHostConnectException;
    :cond_4
    :goto_4
    const/4 v11, 0x0

    goto :goto_3

    .line 107
    :catch_3
    move-exception v3

    .line 109
    .local v3, "e":Ljava/net/UnknownHostException;
    :try_start_7
    iget-object v11, p0, Lnet/singular/sdk/EventReporter;->log:Lnet/singular/sdk/SingularLog;

    const-string v12, "singular_sdk"

    const-string v13, "UnknownHostException in EventReporter"

    invoke-virtual {v11, v12, v13, v3}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 120
    invoke-interface {v2}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v11

    if-eqz v11, :cond_4

    .line 121
    invoke-interface {v2}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v11

    invoke-interface {v11}, Lorg/apache/http/conn/ClientConnectionManager;->shutdown()V

    goto :goto_4

    .line 110
    .end local v3    # "e":Ljava/net/UnknownHostException;
    :catch_4
    move-exception v3

    .line 112
    .local v3, "e":Lorg/apache/http/client/ClientProtocolException;
    :try_start_8
    iget-object v11, p0, Lnet/singular/sdk/EventReporter;->log:Lnet/singular/sdk/SingularLog;

    const-string v12, "singular_sdk"

    const-string v13, "ClientProtocolException in EventReporter"

    invoke-virtual {v11, v12, v13, v3}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 120
    invoke-interface {v2}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v11

    if-eqz v11, :cond_4

    .line 121
    invoke-interface {v2}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v11

    invoke-interface {v11}, Lorg/apache/http/conn/ClientConnectionManager;->shutdown()V

    goto :goto_4

    .line 113
    .end local v3    # "e":Lorg/apache/http/client/ClientProtocolException;
    :catch_5
    move-exception v3

    .line 115
    .local v3, "e":Ljava/io/IOException;
    :try_start_9
    iget-object v11, p0, Lnet/singular/sdk/EventReporter;->log:Lnet/singular/sdk/SingularLog;

    const-string v12, "singular_sdk"

    const-string v13, "IOException in EventReporter"

    invoke-virtual {v11, v12, v13, v3}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 120
    invoke-interface {v2}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v11

    if-eqz v11, :cond_4

    .line 121
    invoke-interface {v2}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v11

    invoke-interface {v11}, Lorg/apache/http/conn/ClientConnectionManager;->shutdown()V

    goto :goto_4

    .line 116
    .end local v3    # "e":Ljava/io/IOException;
    :catch_6
    move-exception v3

    .line 118
    .local v3, "e":Ljava/lang/AssertionError;
    :try_start_a
    iget-object v11, p0, Lnet/singular/sdk/EventReporter;->log:Lnet/singular/sdk/SingularLog;

    const-string v12, "singular_sdk"

    const-string v13, "AssertionError in EventReporter"

    invoke-virtual {v11, v12, v13, v3}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    .line 120
    invoke-interface {v2}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v11

    if-eqz v11, :cond_4

    .line 121
    invoke-interface {v2}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v11

    invoke-interface {v11}, Lorg/apache/http/conn/ClientConnectionManager;->shutdown()V

    goto :goto_4

    .line 120
    .end local v3    # "e":Ljava/lang/AssertionError;
    :catchall_0
    move-exception v11

    invoke-interface {v2}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v12

    if-eqz v12, :cond_5

    .line 121
    invoke-interface {v2}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v12

    invoke-interface {v12}, Lorg/apache/http/conn/ClientConnectionManager;->shutdown()V

    :cond_5
    throw v11
.end method


# virtual methods
.method public declared-synchronized sendPostEventsRequest(Lorg/json/JSONObject;Lorg/json/JSONArray;)Landroid/util/Pair;
    .locals 4
    .param p1, "persistent_identifiers_and_counters"    # Lorg/json/JSONObject;
    .param p2, "events"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Lorg/json/JSONArray;",
            ")",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Integer;",
            "Lorg/json/JSONObject;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lnet/singular/sdk/InvalidArgumentException;
        }
    .end annotation

    .prologue
    .line 40
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1}, Lnet/singular/sdk/EventReporter;->getBasicJsonObject(Lorg/json/JSONObject;)Lorg/json/JSONObject;

    move-result-object v1

    .line 41
    .local v1, "params":Lorg/json/JSONObject;
    const-string v2, "events"

    invoke-virtual {v1, v2, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 45
    :try_start_1
    const-string v2, "https://t.singular.net/v2/events"

    invoke-direct {p0, v2, v1}, Lnet/singular/sdk/EventReporter;->sendJsonObject(Ljava/lang/String;Lorg/json/JSONObject;)Landroid/util/Pair;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v2

    monitor-exit p0

    return-object v2

    .line 42
    .end local v1    # "params":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 43
    .local v0, "e":Lorg/json/JSONException;
    :try_start_2
    new-instance v2, Lnet/singular/sdk/InvalidArgumentException;

    const-string v3, "Invalid JSON in sendPostEventsRequest"

    invoke-direct {v2, v3, v0}, Lnet/singular/sdk/InvalidArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 40
    .end local v0    # "e":Lorg/json/JSONException;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized sendVerboseLogsRequest(Lorg/json/JSONObject;Lorg/json/JSONArray;)Landroid/util/Pair;
    .locals 4
    .param p1, "persistent_identifiers_and_counters"    # Lorg/json/JSONObject;
    .param p2, "lines"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Lorg/json/JSONArray;",
            ")",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Integer;",
            "Lorg/json/JSONObject;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lnet/singular/sdk/InvalidArgumentException;
        }
    .end annotation

    .prologue
    .line 53
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1}, Lnet/singular/sdk/EventReporter;->getBasicJsonObject(Lorg/json/JSONObject;)Lorg/json/JSONObject;

    move-result-object v1

    .line 54
    .local v1, "params":Lorg/json/JSONObject;
    const-string v2, "lines"

    invoke-virtual {v1, v2, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 59
    :try_start_1
    const-string v2, "https://t.singular.net/v2/logs"

    invoke-direct {p0, v2, v1}, Lnet/singular/sdk/EventReporter;->sendJsonObject(Ljava/lang/String;Lorg/json/JSONObject;)Landroid/util/Pair;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v2

    monitor-exit p0

    return-object v2

    .line 55
    .end local v1    # "params":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 56
    .local v0, "e":Lorg/json/JSONException;
    :try_start_2
    new-instance v2, Lnet/singular/sdk/InvalidArgumentException;

    const-string v3, "Invalid JSON in sendVerboseLogsRequest"

    invoke-direct {v2, v3, v0}, Lnet/singular/sdk/InvalidArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 53
    .end local v0    # "e":Lorg/json/JSONException;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method
