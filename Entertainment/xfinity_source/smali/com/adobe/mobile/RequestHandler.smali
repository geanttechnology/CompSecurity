.class final Lcom/adobe/mobile/RequestHandler;
.super Ljava/lang/Object;
.source "RequestHandler.java"


# static fields
.field private static final BUF_SIZE:I = 0x400

.field private static final CONNECTION_TIMEOUT:I = 0x7d0

.field private static final _hostnameVerifierMutex:Ljava/lang/Object;

.field private static _strictHostnameVerifier:Lorg/apache/http/conn/ssl/StrictHostnameVerifier;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 288
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/adobe/mobile/RequestHandler;->_hostnameVerifierMutex:Ljava/lang/Object;

    .line 289
    const/4 v0, 0x0

    sput-object v0, Lcom/adobe/mobile/RequestHandler;->_strictHostnameVerifier:Lorg/apache/http/conn/ssl/StrictHostnameVerifier;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static requestConnect(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    .locals 7
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 293
    :try_start_0
    new-instance v1, Ljava/net/URL;

    invoke-direct {v1, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 295
    .local v1, "requestURL":Ljava/net/URL;
    invoke-virtual {v1}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v3

    const-string v4, "https"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 297
    sget-object v4, Lcom/adobe/mobile/RequestHandler;->_hostnameVerifierMutex:Ljava/lang/Object;

    monitor-enter v4
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 298
    :try_start_1
    sget-object v3, Lcom/adobe/mobile/RequestHandler;->_strictHostnameVerifier:Lorg/apache/http/conn/ssl/StrictHostnameVerifier;

    if-nez v3, :cond_0

    .line 299
    new-instance v3, Lorg/apache/http/conn/ssl/StrictHostnameVerifier;

    invoke-direct {v3}, Lorg/apache/http/conn/ssl/StrictHostnameVerifier;-><init>()V

    sput-object v3, Lcom/adobe/mobile/RequestHandler;->_strictHostnameVerifier:Lorg/apache/http/conn/ssl/StrictHostnameVerifier;

    .line 301
    :cond_0
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 303
    :try_start_2
    invoke-virtual {v1}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v2

    check-cast v2, Ljavax/net/ssl/HttpsURLConnection;

    .line 304
    .local v2, "secureConnection":Ljavax/net/ssl/HttpsURLConnection;
    sget-object v3, Lcom/adobe/mobile/RequestHandler;->_strictHostnameVerifier:Lorg/apache/http/conn/ssl/StrictHostnameVerifier;

    invoke-virtual {v2, v3}, Ljavax/net/ssl/HttpsURLConnection;->setHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 313
    .end local v1    # "requestURL":Ljava/net/URL;
    .end local v2    # "secureConnection":Ljavax/net/ssl/HttpsURLConnection;
    :goto_0
    return-object v2

    .line 301
    .restart local v1    # "requestURL":Ljava/net/URL;
    :catchall_0
    move-exception v3

    :try_start_3
    monitor-exit v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v3
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    .line 309
    .end local v1    # "requestURL":Ljava/net/URL;
    :catch_0
    move-exception v0

    .line 310
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "Adobe Mobile - Exception opening URL(%s)"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 313
    const/4 v2, 0x0

    goto :goto_0

    .line 307
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v1    # "requestURL":Ljava/net/URL;
    :cond_1
    :try_start_5
    invoke-virtual {v1}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v3

    check-cast v3, Ljava/net/HttpURLConnection;
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0

    move-object v2, v3

    goto :goto_0
.end method

.method protected static retrieveData(Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;)[B
    .locals 12
    .param p0, "url"    # Ljava/lang/String;
    .param p2, "readTimeout"    # I
    .param p3, "source"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;I",
            "Ljava/lang/String;",
            ")[B"
        }
    .end annotation

    .prologue
    .line 35
    .local p1, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 36
    invoke-static {p0, p2}, Lcom/adobe/mobile/WearableFunctionBridge;->retrieveData(Ljava/lang/String;I)[B

    move-result-object v7

    .line 97
    :cond_0
    :goto_0
    return-object v7

    .line 39
    :cond_1
    invoke-static {p0}, Lcom/adobe/mobile/RequestHandler;->requestConnect(Ljava/lang/String;)Ljava/net/HttpURLConnection;

    move-result-object v2

    .line 41
    .local v2, "connection":Ljava/net/HttpURLConnection;
    if-nez v2, :cond_2

    .line 42
    const/4 v7, 0x0

    goto :goto_0

    .line 45
    :cond_2
    const/4 v6, 0x0

    .line 48
    .local v6, "inStream":Ljava/io/InputStream;
    const/16 v7, 0x7d0

    :try_start_0
    invoke-virtual {v2, v7}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 49
    invoke-virtual {v2, p2}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 52
    if-eqz p1, :cond_3

    .line 53
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_1
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_3

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 54
    .local v3, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v2, v7, v8}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/Error; {:try_start_0 .. :try_end_0} :catch_6
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 76
    .end local v3    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :catch_0
    move-exception v5

    .line 77
    .local v5, "ex":Ljava/io/IOException;
    :try_start_1
    const-string v7, "%s - IOException while sending request (%s)"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object p3, v8, v9

    const/4 v9, 0x1

    invoke-virtual {v5}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 78
    const/4 v7, 0x0

    .line 86
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 88
    if-eqz v6, :cond_0

    .line 90
    :try_start_2
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    .line 91
    :catch_1
    move-exception v5

    .line 92
    const-string v8, "%s - Unable to close stream (%s)"

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object p3, v9, v10

    const/4 v10, 0x1

    invoke-virtual {v5}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 58
    .end local v5    # "ex":Ljava/io/IOException;
    :cond_3
    :try_start_3
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v7

    const/16 v8, 0xc8

    if-ne v7, v8, :cond_5

    .line 59
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v6

    .line 61
    const/16 v7, 0x400

    new-array v1, v7, [B

    .line 63
    .local v1, "buffer":[B
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 66
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    :goto_2
    invoke-virtual {v6, v1}, Ljava/io/InputStream;->read([B)I

    move-result v7

    const/4 v8, -0x1

    if-eq v7, v8, :cond_4

    .line 67
    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write([B)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/lang/Error; {:try_start_3 .. :try_end_3} :catch_6
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_2

    .line 79
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v1    # "buffer":[B
    :catch_2
    move-exception v5

    .line 80
    .local v5, "ex":Ljava/lang/Exception;
    :try_start_4
    const-string v7, "%s - Exception while sending request (%s)"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object p3, v8, v9

    const/4 v9, 0x1

    invoke-virtual {v5}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 81
    const/4 v7, 0x0

    .line 86
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 88
    if-eqz v6, :cond_0

    .line 90
    :try_start_5
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_0

    .line 91
    :catch_3
    move-exception v5

    .line 92
    .local v5, "ex":Ljava/io/IOException;
    const-string v8, "%s - Unable to close stream (%s)"

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object p3, v9, v10

    const/4 v10, 0x1

    invoke-virtual {v5}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 71
    .end local v5    # "ex":Ljava/io/IOException;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v1    # "buffer":[B
    :cond_4
    :try_start_6
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V

    .line 74
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_0
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2
    .catch Ljava/lang/Error; {:try_start_6 .. :try_end_6} :catch_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    move-result-object v7

    .line 86
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 88
    if-eqz v6, :cond_0

    .line 90
    :try_start_7
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_4

    goto/16 :goto_0

    .line 91
    :catch_4
    move-exception v5

    .line 92
    .restart local v5    # "ex":Ljava/io/IOException;
    const-string v8, "%s - Unable to close stream (%s)"

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object p3, v9, v10

    const/4 v10, 0x1

    invoke-virtual {v5}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 86
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v1    # "buffer":[B
    .end local v5    # "ex":Ljava/io/IOException;
    :cond_5
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 88
    if-eqz v6, :cond_6

    .line 90
    :try_start_8
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_5

    .line 97
    :cond_6
    :goto_3
    const/4 v7, 0x0

    goto/16 :goto_0

    .line 91
    :catch_5
    move-exception v5

    .line 92
    .restart local v5    # "ex":Ljava/io/IOException;
    const-string v7, "%s - Unable to close stream (%s)"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object p3, v8, v9

    const/4 v9, 0x1

    invoke-virtual {v5}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_3

    .line 82
    .end local v5    # "ex":Ljava/io/IOException;
    :catch_6
    move-exception v4

    .line 83
    .local v4, "er":Ljava/lang/Error;
    :try_start_9
    const-string v7, "%s - Unexpected error while sending request (%s)"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object p3, v8, v9

    const/4 v9, 0x1

    invoke-virtual {v4}, Ljava/lang/Error;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 84
    const/4 v7, 0x0

    .line 86
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 88
    if-eqz v6, :cond_0

    .line 90
    :try_start_a
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_7

    goto/16 :goto_0

    .line 91
    :catch_7
    move-exception v5

    .line 92
    .restart local v5    # "ex":Ljava/io/IOException;
    const-string v8, "%s - Unable to close stream (%s)"

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object p3, v9, v10

    const/4 v10, 0x1

    invoke-virtual {v5}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 86
    .end local v4    # "er":Ljava/lang/Error;
    .end local v5    # "ex":Ljava/io/IOException;
    :catchall_0
    move-exception v7

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 88
    if-eqz v6, :cond_7

    .line 90
    :try_start_b
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V
    :try_end_b
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_8

    .line 93
    :cond_7
    :goto_4
    throw v7

    .line 91
    :catch_8
    move-exception v5

    .line 92
    .restart local v5    # "ex":Ljava/io/IOException;
    const-string v8, "%s - Unable to close stream (%s)"

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object p3, v9, v10

    const/4 v10, 0x1

    invoke-virtual {v5}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_4
.end method

.method protected static sendAnalyticsRequest(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;)Z
    .locals 11
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "postBody"    # Ljava/lang/String;
    .param p3, "timeout"    # I
    .param p4, "logPrefix"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;I",
            "Ljava/lang/String;",
            ")Z"
        }
    .end annotation

    .prologue
    .line 150
    .local p2, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p0, :cond_1

    .line 151
    const/4 v7, 0x0

    .line 213
    :cond_0
    :goto_0
    return v7

    .line 154
    :cond_1
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 155
    invoke-static {p0, p1, p3, p4}, Lcom/adobe/mobile/WearableFunctionBridge;->sendAnalyticsRequest(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Z

    move-result v7

    goto :goto_0

    .line 158
    :cond_2
    invoke-static {p0}, Lcom/adobe/mobile/RequestHandler;->requestConnect(Ljava/lang/String;)Ljava/net/HttpURLConnection;

    move-result-object v1

    .line 160
    .local v1, "connection":Ljava/net/HttpURLConnection;
    if-nez v1, :cond_3

    .line 161
    const/4 v7, 0x0

    goto :goto_0

    .line 166
    :cond_3
    :try_start_0
    invoke-virtual {v1, p3}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 167
    invoke-virtual {v1, p3}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 168
    const-string v7, "POST"

    invoke-virtual {v1, v7}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 170
    const-string v7, "UTF-8"

    invoke-virtual {p1, v7}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v5

    .line 171
    .local v5, "outputBytes":[B
    array-length v7, v5

    invoke-virtual {v1, v7}, Ljava/net/HttpURLConnection;->setFixedLengthStreamingMode(I)V

    .line 172
    const-string v7, "Content-Type"

    const-string v8, "application/x-www-form-urlencoded"

    invoke-virtual {v1, v7, v8}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    if-eqz p2, :cond_4

    .line 176
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_1
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_4

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 177
    .local v3, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v1, v7, v8}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/Error; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 197
    .end local v3    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v5    # "outputBytes":[B
    :catch_0
    move-exception v2

    .line 198
    .local v2, "e":Ljava/net/SocketTimeoutException;
    :try_start_1
    const-string v7, "%s - Timed out sending request(%s)"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object p4, v8, v9

    const/4 v9, 0x1

    aput-object p1, v8, v9

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 199
    const/4 v7, 0x0

    .line 208
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v8

    invoke-virtual {v8}, Lcom/adobe/mobile/MobileConfig;->getSSL()Z

    move-result v8

    if-nez v8, :cond_0

    .line 209
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_0

    .line 182
    .end local v2    # "e":Ljava/net/SocketTimeoutException;
    .restart local v5    # "outputBytes":[B
    :cond_4
    :try_start_2
    new-instance v6, Ljava/io/BufferedOutputStream;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 183
    .local v6, "postBodyStream":Ljava/io/OutputStream;
    invoke-virtual {v6, v5}, Ljava/io/OutputStream;->write([B)V

    .line 184
    invoke-virtual {v6}, Ljava/io/OutputStream;->close()V

    .line 186
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v4

    .line 187
    .local v4, "inputStream":Ljava/io/InputStream;
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v7

    invoke-virtual {v7}, Lcom/adobe/mobile/MobileConfig;->getSSL()Z

    move-result v7

    if-eqz v7, :cond_7

    .line 189
    const/16 v7, 0xa

    new-array v0, v7, [B

    .line 190
    .local v0, "b":[B
    :cond_5
    invoke-virtual {v4, v0}, Ljava/io/InputStream;->read([B)I

    move-result v7

    if-gtz v7, :cond_5

    .line 194
    .end local v0    # "b":[B
    :goto_2
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    .line 196
    const-string v7, "%s - Request Sent(%s)"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object p4, v8, v9

    const/4 v9, 0x1

    aput-object p1, v8, v9

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catch Ljava/net/SocketTimeoutException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/lang/Error; {:try_start_2 .. :try_end_2} :catch_3
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 208
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v7

    invoke-virtual {v7}, Lcom/adobe/mobile/MobileConfig;->getSSL()Z

    move-result v7

    if-nez v7, :cond_6

    .line 209
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 213
    .end local v4    # "inputStream":Ljava/io/InputStream;
    .end local v5    # "outputBytes":[B
    .end local v6    # "postBodyStream":Ljava/io/OutputStream;
    :cond_6
    :goto_3
    const/4 v7, 0x1

    goto/16 :goto_0

    .line 192
    .restart local v4    # "inputStream":Ljava/io/InputStream;
    .restart local v5    # "outputBytes":[B
    .restart local v6    # "postBodyStream":Ljava/io/OutputStream;
    :cond_7
    :try_start_3
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseCode()I
    :try_end_3
    .catch Ljava/net/SocketTimeoutException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/lang/Error; {:try_start_3 .. :try_end_3} :catch_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_2

    .line 200
    .end local v4    # "inputStream":Ljava/io/InputStream;
    .end local v5    # "outputBytes":[B
    .end local v6    # "postBodyStream":Ljava/io/OutputStream;
    :catch_1
    move-exception v2

    .line 201
    .local v2, "e":Ljava/io/IOException;
    :try_start_4
    const-string v7, "%s - IOException while sending request, may retry(%s)"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object p4, v8, v9

    const/4 v9, 0x1

    invoke-virtual {v2}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 202
    const/4 v7, 0x0

    .line 208
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v8

    invoke-virtual {v8}, Lcom/adobe/mobile/MobileConfig;->getSSL()Z

    move-result v8

    if-nez v8, :cond_0

    .line 209
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    goto/16 :goto_0

    .line 203
    .end local v2    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v2

    .line 204
    .local v2, "e":Ljava/lang/Exception;
    :try_start_5
    const-string v7, "%s - Exception while attempting to send hit, will not retry(%s)"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object p4, v8, v9

    const/4 v9, 0x1

    invoke-virtual {v2}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 208
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v7

    invoke-virtual {v7}, Lcom/adobe/mobile/MobileConfig;->getSSL()Z

    move-result v7

    if-nez v7, :cond_6

    .line 209
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_3

    .line 205
    .end local v2    # "e":Ljava/lang/Exception;
    :catch_3
    move-exception v2

    .line 206
    .local v2, "e":Ljava/lang/Error;
    :try_start_6
    const-string v7, "%s - Exception while attempting to send hit, will not retry(%s)"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object p4, v8, v9

    const/4 v9, 0x1

    invoke-virtual {v2}, Ljava/lang/Error;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 208
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v7

    invoke-virtual {v7}, Lcom/adobe/mobile/MobileConfig;->getSSL()Z

    move-result v7

    if-nez v7, :cond_6

    .line 209
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_3

    .line 208
    .end local v2    # "e":Ljava/lang/Error;
    :catchall_0
    move-exception v7

    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v8

    invoke-virtual {v8}, Lcom/adobe/mobile/MobileConfig;->getSSL()Z

    move-result v8

    if-nez v8, :cond_8

    .line 209
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_8
    throw v7
.end method

.method protected static sendGenericRequest(Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;)V
    .locals 11
    .param p0, "url"    # Ljava/lang/String;
    .param p2, "timeout"    # I
    .param p3, "source"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;I",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 102
    if-nez p0, :cond_1

    .line 145
    :cond_0
    :goto_0
    return-void

    .line 106
    :cond_1
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 107
    invoke-static {p0, p2, p3}, Lcom/adobe/mobile/WearableFunctionBridge;->sendGenericRequest(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_0

    .line 113
    :cond_2
    :try_start_0
    invoke-static {p0}, Lcom/adobe/mobile/RequestHandler;->requestConnect(Ljava/lang/String;)Ljava/net/HttpURLConnection;

    move-result-object v0

    .line 114
    .local v0, "connection":Ljava/net/HttpURLConnection;
    if-eqz v0, :cond_0

    .line 115
    invoke-virtual {v0, p2}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 116
    invoke-virtual {v0, p2}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 118
    if-eqz p1, :cond_4

    .line 120
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_3
    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 121
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 122
    .local v4, "value":Ljava/lang/String;
    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_3

    .line 123
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-virtual {v0, v5, v4}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/Error; {:try_start_0 .. :try_end_0} :catch_3

    goto :goto_1

    .line 136
    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v4    # "value":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 137
    .local v1, "e":Ljava/net/SocketTimeoutException;
    const-string v5, "%s - Timed out sending request(%s)"

    new-array v6, v10, [Ljava/lang/Object;

    aput-object p3, v6, v8

    aput-object p0, v6, v9

    invoke-static {v5, v6}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 128
    .end local v1    # "e":Ljava/net/SocketTimeoutException;
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    :cond_4
    :try_start_1
    const-string v5, "%s - Request Sent(%s)"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p3, v6, v7

    const/4 v7, 0x1

    aput-object p0, v6, v7

    invoke-static {v5, v6}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 130
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    .line 132
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v3

    .line 133
    .local v3, "stream":Ljava/io/InputStream;
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V

    .line 134
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_1
    .catch Ljava/net/SocketTimeoutException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/Error; {:try_start_1 .. :try_end_1} :catch_3

    goto :goto_0

    .line 138
    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local v3    # "stream":Ljava/io/InputStream;
    :catch_1
    move-exception v1

    .line 139
    .local v1, "e":Ljava/io/IOException;
    const-string v5, "%s - IOException while sending request, may retry(%s)"

    new-array v6, v10, [Ljava/lang/Object;

    aput-object p3, v6, v8

    invoke-virtual {v1}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v9

    invoke-static {v5, v6}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 140
    .end local v1    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v1

    .line 141
    .local v1, "e":Ljava/lang/Exception;
    const-string v5, "%s - Exception while attempting to send hit, will not retry(%s)"

    new-array v6, v10, [Ljava/lang/Object;

    aput-object p3, v6, v8

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v9

    invoke-static {v5, v6}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 142
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_3
    move-exception v1

    .line 143
    .local v1, "e":Ljava/lang/Error;
    const-string v5, "%s - Exception while attempting to send hit, will not retry(%s)"

    new-array v6, v10, [Ljava/lang/Object;

    aput-object p3, v6, v8

    invoke-virtual {v1}, Ljava/lang/Error;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v9

    invoke-static {v5, v6}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0
.end method

.method protected static sendThirdPartyRequest(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;Ljava/lang/String;)Z
    .locals 18
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "postBody"    # Ljava/lang/String;
    .param p3, "timeout"    # I
    .param p4, "postType"    # Ljava/lang/String;
    .param p5, "logPrefix"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;I",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")Z"
        }
    .end annotation

    .prologue
    .line 218
    .local p2, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p0, :cond_0

    .line 219
    const/4 v14, 0x0

    .line 284
    :goto_0
    return v14

    .line 222
    :cond_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v14

    if-eqz v14, :cond_1

    .line 223
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, p3

    move-object/from16 v3, p4

    move-object/from16 v4, p5

    invoke-static {v0, v1, v2, v3, v4}, Lcom/adobe/mobile/WearableFunctionBridge;->sendThirdPartyRequest(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Z

    move-result v14

    goto :goto_0

    .line 226
    :cond_1
    invoke-static/range {p0 .. p0}, Lcom/adobe/mobile/RequestHandler;->requestConnect(Ljava/lang/String;)Ljava/net/HttpURLConnection;

    move-result-object v6

    .line 228
    .local v6, "connection":Ljava/net/HttpURLConnection;
    if-nez v6, :cond_2

    .line 229
    const/4 v14, 0x0

    goto :goto_0

    .line 234
    :cond_2
    :try_start_0
    move/from16 v0, p3

    invoke-virtual {v6, v0}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 235
    move/from16 v0, p3

    invoke-virtual {v6, v0}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 236
    const-string v14, "GET"

    invoke-virtual {v6, v14}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 239
    if-eqz p2, :cond_3

    .line 240
    invoke-interface/range {p2 .. p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v14

    invoke-interface {v14}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v16

    :goto_1
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_3

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/util/Map$Entry;

    .line 241
    .local v10, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v10}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/lang/String;

    invoke-interface {v10}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    invoke-virtual {v6, v14, v15}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/Error; {:try_start_0 .. :try_end_0} :catch_3

    goto :goto_1

    .line 270
    .end local v10    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :catch_0
    move-exception v9

    .line 271
    .local v9, "e":Ljava/net/SocketTimeoutException;
    const-string v14, "%s - Timed out sending request (%s)"

    const/4 v15, 0x2

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    aput-object p5, v15, v16

    const/16 v16, 0x1

    aput-object p1, v15, v16

    invoke-static {v14, v15}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 272
    const/4 v14, 0x0

    goto :goto_0

    .line 246
    .end local v9    # "e":Ljava/net/SocketTimeoutException;
    :cond_3
    if-eqz p1, :cond_4

    :try_start_1
    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->length()I

    move-result v14

    if-lez v14, :cond_4

    .line 247
    const-string v14, "POST"

    invoke-virtual {v6, v14}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 249
    if-eqz p4, :cond_6

    invoke-virtual/range {p4 .. p4}, Ljava/lang/String;->length()I

    move-result v14

    if-lez v14, :cond_6

    move-object/from16 v8, p4

    .line 251
    .local v8, "contentType":Ljava/lang/String;
    :goto_2
    const-string v14, "UTF-8"

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v12

    .line 252
    .local v12, "outputBytes":[B
    array-length v14, v12

    invoke-virtual {v6, v14}, Ljava/net/HttpURLConnection;->setFixedLengthStreamingMode(I)V

    .line 253
    const-string v14, "Content-Type"

    invoke-virtual {v6, v14, v8}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 256
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v7

    .line 257
    .local v7, "connectionOutputStream":Ljava/io/OutputStream;
    new-instance v13, Ljava/io/BufferedOutputStream;

    invoke-direct {v13, v7}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 258
    .local v13, "postBodyStream":Ljava/io/OutputStream;
    invoke-virtual {v13, v12}, Ljava/io/OutputStream;->write([B)V

    .line 259
    invoke-virtual {v13}, Ljava/io/OutputStream;->close()V

    .line 263
    .end local v7    # "connectionOutputStream":Ljava/io/OutputStream;
    .end local v8    # "contentType":Ljava/lang/String;
    .end local v12    # "outputBytes":[B
    .end local v13    # "postBodyStream":Ljava/io/OutputStream;
    :cond_4
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v11

    .line 264
    .local v11, "inputStream":Ljava/io/InputStream;
    const/16 v14, 0xa

    new-array v5, v14, [B

    .line 265
    .local v5, "b":[B
    :cond_5
    invoke-virtual {v11, v5}, Ljava/io/InputStream;->read([B)I

    move-result v14

    if-gtz v14, :cond_5

    .line 266
    invoke-virtual {v11}, Ljava/io/InputStream;->close()V

    .line 268
    const-string v14, "%s - Successfully forwarded hit (%s body: %s type: %s)"

    const/4 v15, 0x4

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    aput-object p5, v15, v16

    const/16 v16, 0x1

    aput-object p0, v15, v16

    const/16 v16, 0x2

    aput-object p1, v15, v16

    const/16 v16, 0x3

    aput-object p4, v15, v16

    invoke-static {v14, v15}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 284
    .end local v5    # "b":[B
    .end local v11    # "inputStream":Ljava/io/InputStream;
    :goto_3
    const/4 v14, 0x1

    goto/16 :goto_0

    .line 249
    :cond_6
    const-string v8, "application/x-www-form-urlencoded"
    :try_end_1
    .catch Ljava/net/SocketTimeoutException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/Error; {:try_start_1 .. :try_end_1} :catch_3

    goto :goto_2

    .line 274
    :catch_1
    move-exception v9

    .line 275
    .local v9, "e":Ljava/io/IOException;
    const-string v14, "%s - IOException while sending request, will not retry (%s)"

    const/4 v15, 0x2

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    aput-object p5, v15, v16

    const/16 v16, 0x1

    invoke-virtual {v9}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_3

    .line 277
    .end local v9    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v9

    .line 278
    .local v9, "e":Ljava/lang/Exception;
    const-string v14, "%s - Exception while attempting to send hit, will not retry (%s)"

    const/4 v15, 0x2

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    aput-object p5, v15, v16

    const/16 v16, 0x1

    invoke-virtual {v9}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_3

    .line 280
    .end local v9    # "e":Ljava/lang/Exception;
    :catch_3
    move-exception v9

    .line 281
    .local v9, "e":Ljava/lang/Error;
    const-string v14, "%s - Exception while attempting to send hit, will not retry (%s)"

    const/4 v15, 0x2

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    aput-object p5, v15, v16

    const/16 v16, 0x1

    invoke-virtual {v9}, Ljava/lang/Error;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_3
.end method
