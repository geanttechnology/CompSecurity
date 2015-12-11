.class Lcom/amazon/device/ads/HttpClientWebRequest;
.super Lcom/amazon/device/ads/WebRequest;
.source "HttpClientWebRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/HttpClientWebRequest$1;
    }
.end annotation


# static fields
.field private static final DEFAULT_SOCKET_BUFFER_SIZE:I = 0x2000

.field private static final LOG_TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 41
    const-class v0, Lcom/amazon/device/ads/HttpClientWebRequest;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/HttpClientWebRequest;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/amazon/device/ads/WebRequest;-><init>()V

    .line 97
    return-void
.end method

.method private prepareFormRequestBody(Lorg/apache/http/client/methods/HttpPost;Ljava/lang/String;)V
    .locals 9
    .param p1, "httpPost"    # Lorg/apache/http/client/methods/HttpPost;
    .param p2, "charset"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/device/ads/WebRequest$WebRequestException;
        }
    .end annotation

    .prologue
    .line 175
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 176
    .local v3, "postParams":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    iget-object v4, p0, Lcom/amazon/device/ads/HttpClientWebRequest;->postParameters:Ljava/util/HashMap;

    invoke-virtual {v4}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 178
    .local v2, "param":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-direct {v6, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 182
    .end local v2    # "param":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    :try_start_0
    new-instance v4, Lorg/apache/http/client/entity/UrlEncodedFormEntity;

    const-string/jumbo v5, "UTF-8"

    invoke-direct {v4, v3, v5}, Lorg/apache/http/client/entity/UrlEncodedFormEntity;-><init>(Ljava/util/List;Ljava/lang/String;)V

    invoke-virtual {p1, v4}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 189
    return-void

    .line 184
    :catch_0
    move-exception v0

    .line 186
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpClientWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "Unsupported character encoding used while creating the request: %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v4, v5, v6}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 187
    new-instance v4, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v5, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->UNSUPPORTED_ENCODING:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    const-string/jumbo v6, "Unsupported character encoding used while creating the request"

    invoke-direct {v4, p0, v5, v6, v0}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v4
.end method

.method private prepareRequestBody(Lorg/apache/http/client/methods/HttpPost;)V
    .locals 3
    .param p1, "httpPost"    # Lorg/apache/http/client/methods/HttpPost;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/device/ads/WebRequest$WebRequestException;
        }
    .end annotation

    .prologue
    .line 123
    iget-object v0, p0, Lcom/amazon/device/ads/HttpClientWebRequest;->charset:Ljava/lang/String;

    .line 124
    .local v0, "charset":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 126
    const-string/jumbo v0, "UTF-8"

    .line 128
    :cond_0
    iget-object v1, p0, Lcom/amazon/device/ads/HttpClientWebRequest;->contentType:Ljava/lang/String;

    .line 129
    .local v1, "contentType":Ljava/lang/String;
    if-nez v1, :cond_1

    .line 131
    const-string/jumbo v1, "text/plain"

    .line 133
    :cond_1
    iget-object v2, p0, Lcom/amazon/device/ads/HttpClientWebRequest;->requestBody:Ljava/lang/String;

    if-eqz v2, :cond_2

    .line 135
    invoke-direct {p0, p1, v1, v0}, Lcom/amazon/device/ads/HttpClientWebRequest;->prepareStringRequestBody(Lorg/apache/http/client/methods/HttpPost;Ljava/lang/String;Ljava/lang/String;)V

    .line 141
    :goto_0
    return-void

    .line 139
    :cond_2
    invoke-direct {p0, p1, v0}, Lcom/amazon/device/ads/HttpClientWebRequest;->prepareFormRequestBody(Lorg/apache/http/client/methods/HttpPost;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private prepareStringRequestBody(Lorg/apache/http/client/methods/HttpPost;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "requestBase"    # Lorg/apache/http/client/methods/HttpPost;
    .param p2, "contentType"    # Ljava/lang/String;
    .param p3, "charset"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/device/ads/WebRequest$WebRequestException;
        }
    .end annotation

    .prologue
    .line 154
    :try_start_0
    new-instance v1, Lorg/apache/http/entity/StringEntity;

    iget-object v2, p0, Lcom/amazon/device/ads/HttpClientWebRequest;->requestBody:Ljava/lang/String;

    invoke-direct {v1, v2, p3}, Lorg/apache/http/entity/StringEntity;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    .local v1, "entity":Lorg/apache/http/entity/StringEntity;
    invoke-virtual {v1, p2}, Lorg/apache/http/entity/StringEntity;->setContentType(Ljava/lang/String;)V

    .line 156
    invoke-virtual {p1, v1}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 163
    return-void

    .line 158
    .end local v1    # "entity":Lorg/apache/http/entity/StringEntity;
    :catch_0
    move-exception v0

    .line 160
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpClientWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Unsupported character encoding used while creating the request. "

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 161
    new-instance v2, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v3, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->UNSUPPORTED_ENCODING:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    const-string/jumbo v4, "Unsupported character encoding used while creating the request."

    invoke-direct {v2, p0, v3, v4, v0}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method


# virtual methods
.method protected createHttpParams()Lorg/apache/http/params/HttpParams;
    .locals 2

    .prologue
    .line 198
    new-instance v0, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v0}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 199
    .local v0, "httpParams":Lorg/apache/http/params/HttpParams;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpClientWebRequest;->getTimeout()I

    move-result v1

    invoke-static {v0, v1}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 200
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpClientWebRequest;->getTimeout()I

    move-result v1

    invoke-static {v0, v1}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 204
    const/16 v1, 0x2000

    invoke-static {v0, v1}, Lorg/apache/http/params/HttpConnectionParams;->setSocketBufferSize(Lorg/apache/http/params/HttpParams;I)V

    .line 205
    return-object v0
.end method

.method protected createHttpRequest(Ljava/net/URL;)Lorg/apache/http/client/methods/HttpRequestBase;
    .locals 10
    .param p1, "url"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/device/ads/WebRequest$WebRequestException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    const/4 v9, 0x0

    .line 77
    const/4 v2, 0x0

    .line 78
    .local v2, "httpRequest":Lorg/apache/http/client/methods/HttpRequestBase;
    const/4 v4, 0x0

    .line 81
    .local v4, "uri":Ljava/net/URI;
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/HttpClientWebRequest;->createURI(Ljava/net/URL;)Ljava/net/URI;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 89
    sget-object v5, Lcom/amazon/device/ads/HttpClientWebRequest$1;->$SwitchMap$com$amazon$device$ads$WebRequest$HttpMethod:[I

    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpClientWebRequest;->getHttpMethod()Lcom/amazon/device/ads/WebRequest$HttpMethod;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/device/ads/WebRequest$HttpMethod;->ordinal()I

    move-result v6

    aget v5, v5, v6

    packed-switch v5, :pswitch_data_0

    .line 100
    :goto_0
    iget-object v5, p0, Lcom/amazon/device/ads/HttpClientWebRequest;->headers:Ljava/util/HashMap;

    invoke-virtual {v5}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 102
    .local v1, "header":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_0

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    const-string/jumbo v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 104
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v2, v5, v6}, Lorg/apache/http/client/methods/HttpRequestBase;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 83
    .end local v1    # "header":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    :catch_0
    move-exception v0

    .line 85
    .local v0, "e":Ljava/net/URISyntaxException;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpClientWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "Problem with URI syntax: %s"

    new-array v7, v7, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/net/URISyntaxException;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v5, v6, v7}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 86
    new-instance v5, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v6, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->MALFORMED_URL:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    const-string/jumbo v7, "Problem with URI syntax"

    invoke-direct {v5, p0, v6, v7, v0}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5

    .line 92
    .end local v0    # "e":Ljava/net/URISyntaxException;
    :pswitch_0
    new-instance v2, Lorg/apache/http/client/methods/HttpGet;

    .end local v2    # "httpRequest":Lorg/apache/http/client/methods/HttpRequestBase;
    invoke-direct {v2, v4}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/net/URI;)V

    .line 93
    .restart local v2    # "httpRequest":Lorg/apache/http/client/methods/HttpRequestBase;
    goto :goto_0

    .line 95
    :pswitch_1
    new-instance v2, Lorg/apache/http/client/methods/HttpPost;

    .end local v2    # "httpRequest":Lorg/apache/http/client/methods/HttpRequestBase;
    invoke-direct {v2, v4}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/net/URI;)V

    .restart local v2    # "httpRequest":Lorg/apache/http/client/methods/HttpRequestBase;
    move-object v5, v2

    .line 96
    check-cast v5, Lorg/apache/http/client/methods/HttpPost;

    invoke-direct {p0, v5}, Lcom/amazon/device/ads/HttpClientWebRequest;->prepareRequestBody(Lorg/apache/http/client/methods/HttpPost;)V

    goto :goto_0

    .line 108
    .restart local v3    # "i$":Ljava/util/Iterator;
    :cond_1
    invoke-virtual {v4}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/amazon/device/ads/HttpClientWebRequest;->logUrl(Ljava/lang/String;)V

    .line 109
    iget-boolean v5, p0, Lcom/amazon/device/ads/HttpClientWebRequest;->logRequestBodyEnabled:Z

    if-eqz v5, :cond_2

    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpClientWebRequest;->getRequestBody()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_2

    .line 111
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpClientWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "Request Body: %s"

    new-array v7, v7, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpClientWebRequest;->getRequestBody()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v5, v6, v7}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 113
    :cond_2
    return-object v2

    .line 89
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected doHttpNetworkCall(Ljava/net/URL;)Lcom/amazon/device/ads/WebRequest$WebResponse;
    .locals 10
    .param p1, "url"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/device/ads/WebRequest$WebRequestException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    const/4 v9, 0x0

    .line 48
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/HttpClientWebRequest;->createHttpRequest(Ljava/net/URL;)Lorg/apache/http/client/methods/HttpRequestBase;

    move-result-object v3

    .line 49
    .local v3, "httpRequest":Lorg/apache/http/client/methods/HttpRequestBase;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpClientWebRequest;->createHttpParams()Lorg/apache/http/params/HttpParams;

    move-result-object v2

    .line 50
    .local v2, "httpParams":Lorg/apache/http/params/HttpParams;
    new-instance v0, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v0, v2}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/params/HttpParams;)V

    .line 51
    .local v0, "client":Lorg/apache/http/client/HttpClient;
    const/4 v4, 0x0

    .line 54
    .local v4, "response":Lorg/apache/http/HttpResponse;
    :try_start_0
    invoke-interface {v0, v3}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    :try_end_0
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v4

    .line 66
    invoke-virtual {p0, v4}, Lcom/amazon/device/ads/HttpClientWebRequest;->parseResponse(Lorg/apache/http/HttpResponse;)Lcom/amazon/device/ads/WebRequest$WebResponse;

    move-result-object v5

    return-object v5

    .line 56
    :catch_0
    move-exception v1

    .line 58
    .local v1, "e":Lorg/apache/http/client/ClientProtocolException;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpClientWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "Invalid client protocol: %s"

    new-array v7, v7, [Ljava/lang/Object;

    invoke-virtual {v1}, Lorg/apache/http/client/ClientProtocolException;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v5, v6, v7}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 59
    new-instance v5, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v6, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->INVALID_CLIENT_PROTOCOL:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    const-string/jumbo v7, "Invalid client protocol"

    invoke-direct {v5, p0, v6, v7, v1}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5

    .line 61
    .end local v1    # "e":Lorg/apache/http/client/ClientProtocolException;
    :catch_1
    move-exception v1

    .line 63
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpClientWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "IOException during client execution: %s"

    new-array v7, v7, [Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v5, v6, v7}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 64
    new-instance v5, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v6, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->NETWORK_FAILURE:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    const-string/jumbo v7, "IOException during client execution"

    invoke-direct {v5, p0, v6, v7, v1}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5
.end method

.method protected getSubLogTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 244
    sget-object v0, Lcom/amazon/device/ads/HttpClientWebRequest;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method protected parseResponse(Lorg/apache/http/HttpResponse;)Lcom/amazon/device/ads/WebRequest$WebResponse;
    .locals 8
    .param p1, "response"    # Lorg/apache/http/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/device/ads/WebRequest$WebRequestException;
        }
    .end annotation

    .prologue
    .line 216
    new-instance v2, Lcom/amazon/device/ads/WebRequest$WebResponse;

    invoke-direct {v2, p0}, Lcom/amazon/device/ads/WebRequest$WebResponse;-><init>(Lcom/amazon/device/ads/WebRequest;)V

    .line 217
    .local v2, "webResponse":Lcom/amazon/device/ads/WebRequest$WebResponse;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpClientWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/WebRequest$WebResponse;->setLogTag(Ljava/lang/String;)V

    .line 218
    iget-boolean v3, p0, Lcom/amazon/device/ads/HttpClientWebRequest;->logResponseEnabled:Z

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/WebRequest$WebResponse;->enableLog(Z)V

    .line 219
    invoke-interface {p1}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v3

    invoke-interface {v3}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v3

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/WebRequest$WebResponse;->setHttpStatusCode(I)V

    .line 220
    invoke-interface {p1}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v3

    invoke-interface {v3}, Lorg/apache/http/StatusLine;->getReasonPhrase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/WebRequest$WebResponse;->setHttpStatus(Ljava/lang/String;)V

    .line 222
    invoke-virtual {v2}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getHttpStatusCode()I

    move-result v3

    const/16 v4, 0xc8

    if-ne v3, v4, :cond_0

    .line 224
    invoke-interface {p1}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v1

    .line 225
    .local v1, "entity":Lorg/apache/http/HttpEntity;
    if-eqz v1, :cond_0

    invoke-interface {v1}, Lorg/apache/http/HttpEntity;->getContentLength()J

    move-result-wide v3

    const-wide/16 v5, 0x0

    cmp-long v3, v3, v5

    if-eqz v3, :cond_0

    .line 229
    :try_start_0
    invoke-interface {v1}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/WebRequest$WebResponse;->setInputStream(Ljava/io/InputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 238
    .end local v1    # "entity":Lorg/apache/http/HttpEntity;
    :cond_0
    return-object v2

    .line 231
    .restart local v1    # "entity":Lorg/apache/http/HttpEntity;
    :catch_0
    move-exception v0

    .line 233
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {p0}, Lcom/amazon/device/ads/HttpClientWebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "IOException while reading the input stream from response: %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v3, v4, v5}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 234
    new-instance v3, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v4, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->NETWORK_FAILURE:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    const-string/jumbo v5, "IOException while reading the input stream from response"

    invoke-direct {v3, p0, v4, v5, v0}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3
.end method
