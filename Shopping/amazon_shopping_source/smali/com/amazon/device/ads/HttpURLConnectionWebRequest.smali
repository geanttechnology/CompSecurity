.class Lcom/amazon/device/ads/HttpURLConnectionWebRequest;
.super Lcom/amazon/device/ads/WebRequest;
.source "HttpURLConnectionWebRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/HttpURLConnectionWebRequest$1;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/device/ads/WebRequest;-><init>()V

    .line 105
    return-void
.end method

.method private writePostBody(Ljava/net/HttpURLConnection;)V
    .locals 13
    .param p1, "connection"    # Ljava/net/HttpURLConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/device/ads/WebRequest$WebRequestException;
        }
    .end annotation

    .prologue
    const/4 v12, 0x1

    const/4 v11, 0x0

    .line 116
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 117
    .local v5, "postBody":Ljava/lang/StringBuilder;
    iget-object v6, p0, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->requestBody:Ljava/lang/String;

    if-eqz v6, :cond_3

    .line 119
    iget-object v6, p0, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->requestBody:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 129
    :cond_0
    :goto_0
    iget-boolean v6, p0, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->logRequestBodyEnabled:Z

    if-eqz v6, :cond_1

    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getRequestBody()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_1

    .line 131
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Request Body: %s"

    new-array v8, v12, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getRequestBody()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v11

    invoke-static {v6, v7, v8}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 134
    :cond_1
    const/4 v2, 0x0

    .line 137
    .local v2, "out":Ljava/io/OutputStreamWriter;
    :try_start_0
    new-instance v3, Ljava/io/OutputStreamWriter;

    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v6

    const-string/jumbo v7, "UTF-8"

    invoke-direct {v3, v6, v7}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 138
    .end local v2    # "out":Ljava/io/OutputStreamWriter;
    .local v3, "out":Ljava/io/OutputStreamWriter;
    :try_start_1
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/io/OutputStreamWriter;->write(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 147
    if-eqz v3, :cond_2

    .line 151
    :try_start_2
    invoke-virtual {v3}, Ljava/io/OutputStreamWriter;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 160
    :cond_2
    return-void

    .line 121
    .end local v3    # "out":Ljava/io/OutputStreamWriter;
    :cond_3
    iget-object v6, p0, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->postParameters:Ljava/util/HashMap;

    if-eqz v6, :cond_0

    iget-object v6, p0, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->postParameters:Ljava/util/HashMap;

    invoke-virtual {v6}, Ljava/util/HashMap;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_0

    .line 123
    iget-object v6, p0, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->postParameters:Ljava/util/HashMap;

    invoke-virtual {v6}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map$Entry;

    .line 125
    .local v4, "param":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v4}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface {v4}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-static {v6}, Lcom/amazon/device/ads/Utils;->getURLEncodedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "&"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 127
    .end local v4    # "param":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_4
    const-string/jumbo v6, "&"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->lastIndexOf(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->deleteCharAt(I)Ljava/lang/StringBuilder;

    goto/16 :goto_0

    .line 153
    .end local v1    # "i$":Ljava/util/Iterator;
    .restart local v3    # "out":Ljava/io/OutputStreamWriter;
    :catch_0
    move-exception v0

    .line 155
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Problem while closing output stream writer for request body: %s"

    new-array v8, v12, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v11

    invoke-static {v6, v7, v8}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 156
    new-instance v6, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v7, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->NETWORK_FAILURE:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    const-string/jumbo v8, "Problem while closing output stream writer for request body"

    invoke-direct {v6, p0, v7, v8, v0}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v6

    .line 140
    .end local v0    # "e":Ljava/io/IOException;
    .end local v3    # "out":Ljava/io/OutputStreamWriter;
    .restart local v2    # "out":Ljava/io/OutputStreamWriter;
    :catch_1
    move-exception v0

    .line 142
    .restart local v0    # "e":Ljava/io/IOException;
    :goto_2
    :try_start_3
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Problem while creating output steam for request body: %s"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v6, v7, v8}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 143
    new-instance v6, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v7, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->NETWORK_FAILURE:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    const-string/jumbo v8, "Problem while creating output steam for request body"

    invoke-direct {v6, p0, v7, v8, v0}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v6
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 147
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v6

    :goto_3
    if-eqz v2, :cond_5

    .line 151
    :try_start_4
    invoke-virtual {v2}, Ljava/io/OutputStreamWriter;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    .line 156
    :cond_5
    throw v6

    .line 153
    :catch_2
    move-exception v0

    .line 155
    .restart local v0    # "e":Ljava/io/IOException;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Problem while closing output stream writer for request body: %s"

    new-array v8, v12, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v11

    invoke-static {v6, v7, v8}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 156
    new-instance v6, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v7, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->NETWORK_FAILURE:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    const-string/jumbo v8, "Problem while closing output stream writer for request body"

    invoke-direct {v6, p0, v7, v8, v0}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v6

    .line 147
    .end local v0    # "e":Ljava/io/IOException;
    .end local v2    # "out":Ljava/io/OutputStreamWriter;
    .restart local v3    # "out":Ljava/io/OutputStreamWriter;
    :catchall_1
    move-exception v6

    move-object v2, v3

    .end local v3    # "out":Ljava/io/OutputStreamWriter;
    .restart local v2    # "out":Ljava/io/OutputStreamWriter;
    goto :goto_3

    .line 140
    .end local v2    # "out":Ljava/io/OutputStreamWriter;
    .restart local v3    # "out":Ljava/io/OutputStreamWriter;
    :catch_3
    move-exception v0

    move-object v2, v3

    .end local v3    # "out":Ljava/io/OutputStreamWriter;
    .restart local v2    # "out":Ljava/io/OutputStreamWriter;
    goto :goto_2
.end method


# virtual methods
.method protected doHttpNetworkCall(Ljava/net/URL;)Lcom/amazon/device/ads/WebRequest$WebResponse;
    .locals 7
    .param p1, "url"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/device/ads/WebRequest$WebRequestException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    const/4 v6, 0x0

    .line 27
    const/4 v0, 0x0

    .line 30
    .local v0, "connection":Ljava/net/HttpURLConnection;
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->openConnection(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 41
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->setupRequestProperties(Ljava/net/HttpURLConnection;)V

    .line 45
    :try_start_1
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->connect()V
    :try_end_1
    .catch Ljava/net/SocketTimeoutException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 57
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->prepareResponse(Ljava/net/HttpURLConnection;)Lcom/amazon/device/ads/WebRequest$WebResponse;

    move-result-object v2

    return-object v2

    .line 32
    :catch_0
    move-exception v1

    .line 34
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Problem while opening the URL connection: %s"

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v2, v3, v4}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 35
    new-instance v2, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v3, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->NETWORK_FAILURE:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    const-string/jumbo v4, "Problem while opening the URL connection"

    invoke-direct {v2, p0, v3, v4, v1}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 47
    .end local v1    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v1

    .line 49
    .local v1, "e":Ljava/net/SocketTimeoutException;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Socket timed out while connecting to URL: %s"

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/net/SocketTimeoutException;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v2, v3, v4}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 50
    new-instance v2, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v3, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->NETWORK_TIMEOUT:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    const-string/jumbo v4, "Socket timed out while connecting to URL"

    invoke-direct {v2, p0, v3, v4, v1}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 52
    .end local v1    # "e":Ljava/net/SocketTimeoutException;
    :catch_2
    move-exception v1

    .line 54
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Problem while connecting to URL: %s"

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v2, v3, v4}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 55
    new-instance v2, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v3, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->NETWORK_FAILURE:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    const-string/jumbo v4, "Problem while connecting to URL"

    invoke-direct {v2, p0, v3, v4, v1}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method

.method protected getSubLogTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 206
    sget-object v0, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method protected openConnection(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    .locals 1
    .param p1, "url"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 62
    invoke-virtual {p1}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    return-object v0
.end method

.method protected prepareResponse(Ljava/net/HttpURLConnection;)Lcom/amazon/device/ads/WebRequest$WebResponse;
    .locals 7
    .param p1, "connection"    # Ljava/net/HttpURLConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/device/ads/WebRequest$WebRequestException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    const/4 v6, 0x0

    .line 170
    new-instance v1, Lcom/amazon/device/ads/WebRequest$WebResponse;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/WebRequest$WebResponse;-><init>(Lcom/amazon/device/ads/WebRequest;)V

    .line 171
    .local v1, "webResponse":Lcom/amazon/device/ads/WebRequest$WebResponse;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/WebRequest$WebResponse;->setLogTag(Ljava/lang/String;)V

    .line 172
    iget-boolean v2, p0, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->logResponseEnabled:Z

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/WebRequest$WebResponse;->enableLog(Z)V

    .line 175
    :try_start_0
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/WebRequest$WebResponse;->setHttpStatusCode(I)V

    .line 176
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getResponseMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/WebRequest$WebResponse;->setHttpStatus(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 188
    invoke-virtual {v1}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getHttpStatusCode()I

    move-result v2

    const/16 v3, 0xc8

    if-ne v2, v3, :cond_0

    .line 192
    :try_start_1
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/WebRequest$WebResponse;->setInputStream(Ljava/io/InputStream;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 200
    :cond_0
    return-object v1

    .line 178
    :catch_0
    move-exception v0

    .line 180
    .local v0, "e":Ljava/net/SocketTimeoutException;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Socket Timeout while getting the response status code: %s"

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/net/SocketTimeoutException;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v2, v3, v4}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 181
    new-instance v2, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v3, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->NETWORK_TIMEOUT:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    const-string/jumbo v4, "Socket Timeout while getting the response status code"

    invoke-direct {v2, p0, v3, v4, v0}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 183
    .end local v0    # "e":Ljava/net/SocketTimeoutException;
    :catch_1
    move-exception v0

    .line 185
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "IOException while getting the response status code: %s"

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v2, v3, v4}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 186
    new-instance v2, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v3, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->NETWORK_FAILURE:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    const-string/jumbo v4, "IOException while getting the response status code"

    invoke-direct {v2, p0, v3, v4, v0}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 194
    .end local v0    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v0

    .line 196
    .restart local v0    # "e":Ljava/io/IOException;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "IOException while reading the input stream from response: %s"

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v2, v3, v4}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 197
    new-instance v2, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v3, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->NETWORK_FAILURE:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    const-string/jumbo v4, "IOException while reading the input stream from response"

    invoke-direct {v2, p0, v3, v4, v0}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method

.method protected setupRequestProperties(Ljava/net/HttpURLConnection;)V
    .locals 8
    .param p1, "connection"    # Ljava/net/HttpURLConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/device/ads/WebRequest$WebRequestException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    const/4 v7, 0x0

    .line 74
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getHttpMethod()Lcom/amazon/device/ads/WebRequest$HttpMethod;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/WebRequest$HttpMethod;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/ProtocolException; {:try_start_0 .. :try_end_0} :catch_0

    .line 82
    iget-object v3, p0, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->headers:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 84
    .local v1, "header":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    const-string/jumbo v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 86
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p1, v3, v4}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 76
    .end local v1    # "header":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v2    # "i$":Ljava/util/Iterator;
    :catch_0
    move-exception v0

    .line 78
    .local v0, "e":Ljava/net/ProtocolException;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "Invalid client protocol: %s"

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/net/ProtocolException;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v3, v4, v5}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 79
    new-instance v3, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v4, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->INVALID_CLIENT_PROTOCOL:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    const-string/jumbo v5, "Invalid client protocol"

    invoke-direct {v3, p0, v4, v5, v0}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 90
    .end local v0    # "e":Ljava/net/ProtocolException;
    .restart local v2    # "i$":Ljava/util/Iterator;
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getTimeout()I

    move-result v3

    invoke-virtual {p1, v3}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 91
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getTimeout()I

    move-result v3

    invoke-virtual {p1, v3}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 96
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v3

    invoke-virtual {v3}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->logUrl(Ljava/lang/String;)V

    .line 97
    sget-object v3, Lcom/amazon/device/ads/HttpURLConnectionWebRequest$1;->$SwitchMap$com$amazon$device$ads$WebRequest$HttpMethod:[I

    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->getHttpMethod()Lcom/amazon/device/ads/WebRequest$HttpMethod;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/device/ads/WebRequest$HttpMethod;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 107
    :goto_1
    return-void

    .line 100
    :pswitch_0
    invoke-virtual {p1, v7}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    goto :goto_1

    .line 103
    :pswitch_1
    invoke-virtual {p1, v5}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 104
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;->writePostBody(Ljava/net/HttpURLConnection;)V

    goto :goto_1

    .line 97
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
