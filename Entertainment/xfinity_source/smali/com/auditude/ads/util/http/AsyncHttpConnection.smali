.class public Lcom/auditude/ads/util/http/AsyncHttpConnection;
.super Ljava/lang/Object;
.source "AsyncHttpConnection.java"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private data:Ljava/lang/String;

.field private handler:Landroid/os/Handler;

.field private httpClient:Lorg/apache/http/client/HttpClient;

.field private isCanceled:Z

.field private method:I

.field private timeout:I

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 56
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    invoke-direct {p0, v0}, Lcom/auditude/ads/util/http/AsyncHttpConnection;-><init>(Landroid/os/Handler;)V

    .line 57
    return-void
.end method

.method public constructor <init>(Landroid/os/Handler;)V
    .locals 1
    .param p1, "_handler"    # Landroid/os/Handler;

    .prologue
    const/4 v0, 0x0

    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    iput v0, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->timeout:I

    .line 52
    iput-boolean v0, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->isCanceled:Z

    .line 61
    iput-object p1, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->handler:Landroid/os/Handler;

    .line 62
    return-void
.end method

.method private processBitmapEntity(Lorg/apache/http/HttpEntity;)V
    .locals 5
    .param p1, "entity"    # Lorg/apache/http/HttpEntity;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 251
    iget-boolean v2, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->isCanceled:Z

    if-eqz v2, :cond_0

    .line 256
    :goto_0
    return-void

    .line 253
    :cond_0
    new-instance v1, Lorg/apache/http/entity/BufferedHttpEntity;

    invoke-direct {v1, p1}, Lorg/apache/http/entity/BufferedHttpEntity;-><init>(Lorg/apache/http/HttpEntity;)V

    .line 254
    .local v1, "bufHttpEntity":Lorg/apache/http/entity/BufferedHttpEntity;
    invoke-virtual {v1}, Lorg/apache/http/entity/BufferedHttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v2

    invoke-static {v2}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 255
    .local v0, "bm":Landroid/graphics/Bitmap;
    iget-object v2, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->handler:Landroid/os/Handler;

    iget-object v3, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->handler:Landroid/os/Handler;

    const/4 v4, 0x2

    invoke-static {v3, v4, v0}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0
.end method

.method private processEntity(Lorg/apache/http/HttpEntity;)V
    .locals 7
    .param p1, "entity"    # Lorg/apache/http/HttpEntity;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 233
    iget-boolean v4, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->isCanceled:Z

    if-eqz v4, :cond_0

    .line 247
    :goto_0
    return-void

    .line 235
    :cond_0
    new-instance v0, Ljava/io/BufferedReader;

    new-instance v4, Ljava/io/InputStreamReader;

    invoke-interface {p1}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v0, v4}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 238
    .local v0, "br":Ljava/io/BufferedReader;
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 239
    .local v1, "buff":Ljava/lang/StringBuffer;
    :goto_1
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    .local v3, "str":Ljava/lang/String;
    if-nez v3, :cond_1

    .line 243
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V

    .line 245
    iget-object v4, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->handler:Landroid/os/Handler;

    const/4 v5, 0x2

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v4, v5, v6}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v2

    .line 246
    .local v2, "message":Landroid/os/Message;
    iget-object v4, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->handler:Landroid/os/Handler;

    invoke-virtual {v4, v2}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0

    .line 241
    .end local v2    # "message":Landroid/os/Message;
    :cond_1
    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .prologue
    .line 131
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->isCanceled:Z

    .line 132
    return-void
.end method

.method public create(ILjava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "method"    # I
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "data"    # Ljava/lang/String;

    .prologue
    .line 76
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/auditude/ads/util/http/AsyncHttpConnection;->create(ILjava/lang/String;Ljava/lang/String;I)V

    .line 77
    return-void
.end method

.method public create(ILjava/lang/String;Ljava/lang/String;I)V
    .locals 1
    .param p1, "method"    # I
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "data"    # Ljava/lang/String;
    .param p4, "timeout"    # I

    .prologue
    .line 66
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->isCanceled:Z

    .line 67
    iput p1, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->method:I

    .line 68
    iput-object p2, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->url:Ljava/lang/String;

    .line 69
    iput-object p3, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->data:Ljava/lang/String;

    .line 70
    iput p4, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->timeout:I

    .line 71
    invoke-static {}, Lcom/auditude/ads/util/http/ConnectionManager;->getInstance()Lcom/auditude/ads/util/http/ConnectionManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/auditude/ads/util/http/ConnectionManager;->push(Ljava/lang/Runnable;)V

    .line 72
    return-void
.end method

.method public get(Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 81
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, p1, v1}, Lcom/auditude/ads/util/http/AsyncHttpConnection;->create(ILjava/lang/String;Ljava/lang/String;)V

    .line 82
    return-void
.end method

.method public get(Ljava/lang/String;I)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "timeout"    # I

    .prologue
    .line 86
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, p1, v1, p2}, Lcom/auditude/ads/util/http/AsyncHttpConnection;->create(ILjava/lang/String;Ljava/lang/String;I)V

    .line 87
    return-void
.end method

.method public head(Ljava/lang/String;I)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "timeout"    # I

    .prologue
    .line 126
    const/4 v0, 0x5

    const/4 v1, 0x0

    invoke-virtual {p0, v0, p1, v1, p2}, Lcom/auditude/ads/util/http/AsyncHttpConnection;->create(ILjava/lang/String;Ljava/lang/String;I)V

    .line 127
    return-void
.end method

.method public post(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "data"    # Ljava/lang/String;
    .param p3, "timeout"    # I

    .prologue
    .line 96
    const/4 v0, 0x1

    invoke-virtual {p0, v0, p1, p2, p3}, Lcom/auditude/ads/util/http/AsyncHttpConnection;->create(ILjava/lang/String;Ljava/lang/String;I)V

    .line 97
    return-void
.end method

.method public run()V
    .locals 15

    .prologue
    const/16 v14, 0x190

    const/4 v13, 0x1

    .line 136
    iget-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->handler:Landroid/os/Handler;

    iget-object v9, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->handler:Landroid/os/Handler;

    const/4 v10, 0x0

    invoke-static {v9, v10}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 138
    new-instance v1, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v1}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 140
    .local v1, "httpParameters":Lorg/apache/http/params/BasicHttpParams;
    iget v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->timeout:I

    invoke-static {v1, v8}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 143
    iget v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->timeout:I

    invoke-static {v1, v8}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 146
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v8

    invoke-virtual {v8}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v8

    invoke-virtual {v8}, Lcom/auditude/ads/core/AdSettings;->getUserAgent()Ljava/lang/String;

    move-result-object v7

    .line 147
    .local v7, "userAgent":Ljava/lang/String;
    invoke-static {v7}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_0

    .line 149
    const-string v8, "http.agent"

    invoke-static {v8}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 152
    :cond_0
    new-instance v8, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v8, v1}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/params/HttpParams;)V

    iput-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->httpClient:Lorg/apache/http/client/HttpClient;

    .line 153
    iget-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->httpClient:Lorg/apache/http/client/HttpClient;

    invoke-interface {v8}, Lorg/apache/http/client/HttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v8

    const-string v9, "http.protocol.allow-circular-redirects"

    invoke-static {v13}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    invoke-interface {v8, v9, v10}, Lorg/apache/http/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/http/params/HttpParams;

    .line 159
    invoke-static {v7}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 161
    iget-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->httpClient:Lorg/apache/http/client/HttpClient;

    invoke-interface {v8}, Lorg/apache/http/client/HttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v8

    const-string v9, "http.useragent"

    invoke-interface {v8, v9, v7}, Lorg/apache/http/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/http/params/HttpParams;

    .line 166
    :cond_1
    const/4 v5, 0x0

    .line 167
    .local v5, "response":Lorg/apache/http/HttpResponse;
    :try_start_0
    iget v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->method:I

    packed-switch v8, :pswitch_data_0

    .line 196
    :goto_0
    invoke-interface {v5}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v8

    invoke-interface {v8}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v6

    .line 198
    .local v6, "statusCode":I
    iget v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->method:I

    const/4 v9, 0x5

    if-ne v8, v9, :cond_4

    .line 201
    if-lt v6, v14, :cond_3

    .line 203
    iget-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->handler:Landroid/os/Handler;

    const/4 v9, 0x2

    const-string v10, "false"

    invoke-static {v8, v9, v10}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v4

    .line 210
    .local v4, "message":Landroid/os/Message;
    :goto_1
    iget-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->handler:Landroid/os/Handler;

    invoke-virtual {v8, v4}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 228
    .end local v4    # "message":Landroid/os/Message;
    .end local v6    # "statusCode":I
    :cond_2
    :goto_2
    invoke-static {}, Lcom/auditude/ads/util/http/ConnectionManager;->getInstance()Lcom/auditude/ads/util/http/ConnectionManager;

    move-result-object v8

    invoke-virtual {v8, p0}, Lcom/auditude/ads/util/http/ConnectionManager;->didComplete(Ljava/lang/Runnable;)V

    .line 229
    return-void

    .line 170
    :pswitch_0
    :try_start_1
    iget-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->httpClient:Lorg/apache/http/client/HttpClient;

    new-instance v9, Lorg/apache/http/client/methods/HttpGet;

    iget-object v10, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->url:Ljava/lang/String;

    invoke-direct {v9, v10}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/auditude/ads/util/http/ConnectionManager;->getInstance()Lcom/auditude/ads/util/http/ConnectionManager;

    move-result-object v10

    new-instance v11, Ljava/net/URL;

    iget-object v12, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->url:Ljava/lang/String;

    invoke-direct {v11, v12}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v11}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Lcom/auditude/ads/util/http/ConnectionManager;->getLocalContext(Ljava/lang/String;)Lorg/apache/http/protocol/HttpContext;

    move-result-object v10

    invoke-interface {v8, v9, v10}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v5

    .line 171
    goto :goto_0

    .line 173
    :pswitch_1
    new-instance v2, Lorg/apache/http/client/methods/HttpPost;

    iget-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->url:Ljava/lang/String;

    invoke-direct {v2, v8}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 174
    .local v2, "httpPost":Lorg/apache/http/client/methods/HttpPost;
    new-instance v8, Lorg/apache/http/entity/StringEntity;

    iget-object v9, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->data:Ljava/lang/String;

    invoke-direct {v8, v9}, Lorg/apache/http/entity/StringEntity;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v8}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 175
    iget-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->httpClient:Lorg/apache/http/client/HttpClient;

    invoke-static {}, Lcom/auditude/ads/util/http/ConnectionManager;->getInstance()Lcom/auditude/ads/util/http/ConnectionManager;

    move-result-object v9

    new-instance v10, Ljava/net/URL;

    iget-object v11, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->url:Ljava/lang/String;

    invoke-direct {v10, v11}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/auditude/ads/util/http/ConnectionManager;->getLocalContext(Ljava/lang/String;)Lorg/apache/http/protocol/HttpContext;

    move-result-object v9

    invoke-interface {v8, v2, v9}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v5

    .line 176
    goto :goto_0

    .line 178
    .end local v2    # "httpPost":Lorg/apache/http/client/methods/HttpPost;
    :pswitch_2
    new-instance v3, Lorg/apache/http/client/methods/HttpPut;

    iget-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->url:Ljava/lang/String;

    invoke-direct {v3, v8}, Lorg/apache/http/client/methods/HttpPut;-><init>(Ljava/lang/String;)V

    .line 179
    .local v3, "httpPut":Lorg/apache/http/client/methods/HttpPut;
    new-instance v8, Lorg/apache/http/entity/StringEntity;

    iget-object v9, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->data:Ljava/lang/String;

    invoke-direct {v8, v9}, Lorg/apache/http/entity/StringEntity;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v8}, Lorg/apache/http/client/methods/HttpPut;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 180
    iget-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->httpClient:Lorg/apache/http/client/HttpClient;

    invoke-interface {v8, v3}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v5

    .line 181
    goto/16 :goto_0

    .line 183
    .end local v3    # "httpPut":Lorg/apache/http/client/methods/HttpPut;
    :pswitch_3
    iget-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->httpClient:Lorg/apache/http/client/HttpClient;

    new-instance v9, Lorg/apache/http/client/methods/HttpDelete;

    iget-object v10, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->url:Ljava/lang/String;

    invoke-direct {v9, v10}, Lorg/apache/http/client/methods/HttpDelete;-><init>(Ljava/lang/String;)V

    invoke-interface {v8, v9}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v5

    .line 184
    goto/16 :goto_0

    .line 186
    :pswitch_4
    iget-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->httpClient:Lorg/apache/http/client/HttpClient;

    new-instance v9, Lorg/apache/http/client/methods/HttpGet;

    iget-object v10, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->url:Ljava/lang/String;

    invoke-direct {v9, v10}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    invoke-interface {v8, v9}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v5

    .line 187
    invoke-interface {v5}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v8

    invoke-direct {p0, v8}, Lcom/auditude/ads/util/http/AsyncHttpConnection;->processBitmapEntity(Lorg/apache/http/HttpEntity;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0

    .line 224
    :catch_0
    move-exception v0

    .line 226
    .local v0, "e":Ljava/lang/Exception;
    iget-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->handler:Landroid/os/Handler;

    iget-object v9, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->handler:Landroid/os/Handler;

    invoke-static {v9, v13, v0}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_2

    .line 190
    .end local v0    # "e":Ljava/lang/Exception;
    :pswitch_5
    :try_start_2
    iget-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->httpClient:Lorg/apache/http/client/HttpClient;

    new-instance v9, Lorg/apache/http/client/methods/HttpHead;

    iget-object v10, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->url:Ljava/lang/String;

    invoke-direct {v9, v10}, Lorg/apache/http/client/methods/HttpHead;-><init>(Ljava/lang/String;)V

    invoke-interface {v8, v9}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v5

    .line 191
    goto/16 :goto_0

    .line 207
    .restart local v6    # "statusCode":I
    :cond_3
    iget-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->handler:Landroid/os/Handler;

    const/4 v9, 0x2

    const-string v10, "true"

    invoke-static {v8, v9, v10}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v4

    .restart local v4    # "message":Landroid/os/Message;
    goto/16 :goto_1

    .line 214
    .end local v4    # "message":Landroid/os/Message;
    :cond_4
    if-lt v6, v14, :cond_5

    .line 216
    iget-object v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->handler:Landroid/os/Handler;

    iget-object v9, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->handler:Landroid/os/Handler;

    const/4 v10, 0x1

    invoke-static {v9, v10}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_2

    .line 218
    :cond_5
    iget v8, p0, Lcom/auditude/ads/util/http/AsyncHttpConnection;->method:I

    const/4 v9, 0x4

    if-ge v8, v9, :cond_2

    .line 220
    invoke-interface {v5}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v8

    invoke-direct {p0, v8}, Lcom/auditude/ads/util/http/AsyncHttpConnection;->processEntity(Lorg/apache/http/HttpEntity;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_2

    .line 167
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method
