.class Lcom/livemixtapes/AsyncHttp$AsyncGet;
.super Lcom/livemixtapes/AsyncHttp$AsyncRequest;
.source "AsyncHttp.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/AsyncHttp;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AsyncGet"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/AsyncHttp;


# direct methods
.method public constructor <init>(Lcom/livemixtapes/AsyncHttp;Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V
    .locals 0
    .param p2, "url"    # Ljava/lang/String;
    .param p4, "callback"    # Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
    .param p5, "json"    # Ljava/lang/Boolean;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;",
            "Ljava/lang/Boolean;",
            ")V"
        }
    .end annotation

    .prologue
    .line 113
    .local p3, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/livemixtapes/AsyncHttp$AsyncGet;->this$0:Lcom/livemixtapes/AsyncHttp;

    .line 114
    invoke-direct {p0, p2, p3, p4, p5}, Lcom/livemixtapes/AsyncHttp$AsyncRequest;-><init>(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V

    .line 115
    return-void
.end method

.method private getParamUrl(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    .locals 7
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 154
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p2, :cond_0

    invoke-interface {p2}, Ljava/util/Map;->size()I

    move-result v3

    if-nez v3, :cond_1

    :cond_0
    move-object v2, p1

    .line 176
    .end local p1    # "url":Ljava/lang/String;
    .local v2, "url":Ljava/lang/String;
    :goto_0
    return-object v2

    .line 157
    .end local v2    # "url":Ljava/lang/String;
    .restart local p1    # "url":Ljava/lang/String;
    :cond_1
    const-string v1, ""

    .line 160
    .local v1, "parameters":Ljava/lang/String;
    :try_start_0
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    if-nez v3, :cond_3

    .line 167
    :goto_2
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_2

    .line 168
    const-string v3, "?"

    invoke-virtual {p1, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 169
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "?"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    :cond_2
    :goto_3
    move-object v2, p1

    .line 176
    .end local p1    # "url":Ljava/lang/String;
    .restart local v2    # "url":Ljava/lang/String;
    goto :goto_0

    .line 160
    .end local v2    # "url":Ljava/lang/String;
    .restart local p1    # "url":Ljava/lang/String;
    :cond_3
    :try_start_1
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 161
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "&"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    const-string v6, "UTF-8"

    invoke-static {v3, v6}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 162
    const-string v5, "="

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    const-string v6, "UTF-8"

    invoke-static {v3, v6}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 161
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v1

    goto :goto_1

    .line 172
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_4
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_3

    .line 164
    :catch_0
    move-exception v3

    goto :goto_2
.end method


# virtual methods
.method protected varargs doInBackground([Ljava/lang/Void;)Lcom/livemixtapes/AsyncHttp$HttpResponseData;
    .locals 15
    .param p1, "n"    # [Ljava/lang/Void;

    .prologue
    .line 120
    const/4 v0, 0x0

    .line 125
    .local v0, "client":Lorg/apache/http/client/HttpClient;
    sget-object v11, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual {v11}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    const v12, 0x7f070001

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v5

    .line 126
    .local v5, "in":Ljava/io/InputStream;
    const-string v7, "api42829"

    .line 128
    .local v7, "password":Ljava/lang/String;
    :try_start_0
    const-string v11, "BKS"

    invoke-static {v11}, Ljava/security/KeyStore;->getInstance(Ljava/lang/String;)Ljava/security/KeyStore;

    move-result-object v6

    .line 129
    .local v6, "keyStore":Ljava/security/KeyStore;
    invoke-virtual {v7}, Ljava/lang/String;->toCharArray()[C

    move-result-object v11

    invoke-virtual {v6, v5, v11}, Ljava/security/KeyStore;->load(Ljava/io/InputStream;[C)V

    .line 131
    new-instance v4, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v4}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 132
    .local v4, "httpParams":Lorg/apache/http/params/HttpParams;
    new-instance v10, Lorg/apache/http/conn/scheme/SchemeRegistry;

    invoke-direct {v10}, Lorg/apache/http/conn/scheme/SchemeRegistry;-><init>()V

    .line 133
    .local v10, "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    new-instance v11, Lorg/apache/http/conn/scheme/Scheme;

    const-string v12, "https"

    new-instance v13, Lorg/apache/http/conn/ssl/SSLSocketFactory;

    invoke-direct {v13, v6}, Lorg/apache/http/conn/ssl/SSLSocketFactory;-><init>(Ljava/security/KeyStore;)V

    const/16 v14, 0x1bb

    invoke-direct {v11, v12, v13, v14}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v10, v11}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 134
    new-instance v2, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;

    invoke-direct {v2, v4, v10}, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;-><init>(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V

    .line 135
    .local v2, "clientMan":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    new-instance v1, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v1, v2, v4}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .end local v0    # "client":Lorg/apache/http/client/HttpClient;
    .local v1, "client":Lorg/apache/http/client/HttpClient;
    move-object v0, v1

    .line 140
    .end local v1    # "client":Lorg/apache/http/client/HttpClient;
    .end local v2    # "clientMan":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    .end local v4    # "httpParams":Lorg/apache/http/params/HttpParams;
    .end local v6    # "keyStore":Ljava/security/KeyStore;
    .end local v10    # "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    .restart local v0    # "client":Lorg/apache/http/client/HttpClient;
    :goto_0
    new-instance v8, Lorg/apache/http/client/methods/HttpGet;

    iget-object v11, p0, Lcom/livemixtapes/AsyncHttp$AsyncGet;->url:Ljava/lang/String;

    iget-object v12, p0, Lcom/livemixtapes/AsyncHttp$AsyncGet;->params:Ljava/util/Map;

    invoke-direct {p0, v11, v12}, Lcom/livemixtapes/AsyncHttp$AsyncGet;->getParamUrl(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v8, v11}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 141
    .local v8, "request":Lorg/apache/http/client/methods/HttpGet;
    const-string v11, "X-Api-Key"

    const-string v12, "bJGpttXhgbjsLEpbI9VPFj1pvizPrfLh"

    invoke-virtual {v8, v11, v12}, Lorg/apache/http/client/methods/HttpGet;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 142
    const-string v11, "User-Agent"

    const-string v12, "LiveMixtapes Android/1.0.84 BETA"

    invoke-virtual {v8, v11, v12}, Lorg/apache/http/client/methods/HttpGet;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 143
    const/4 v9, 0x0

    .line 146
    .local v9, "response":Lorg/apache/http/HttpResponse;
    :try_start_1
    invoke-interface {v0, v8}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v9

    .line 150
    invoke-virtual {p0, v9}, Lcom/livemixtapes/AsyncHttp$AsyncGet;->getDataResponse(Lorg/apache/http/HttpResponse;)Lcom/livemixtapes/AsyncHttp$HttpResponseData;

    move-result-object v11

    :goto_1
    return-object v11

    .line 136
    .end local v8    # "request":Lorg/apache/http/client/methods/HttpGet;
    .end local v9    # "response":Lorg/apache/http/HttpResponse;
    :catch_0
    move-exception v3

    .line 137
    .local v3, "e":Ljava/lang/Exception;
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 147
    .end local v3    # "e":Ljava/lang/Exception;
    .restart local v8    # "request":Lorg/apache/http/client/methods/HttpGet;
    .restart local v9    # "response":Lorg/apache/http/HttpResponse;
    :catch_1
    move-exception v3

    .line 148
    .restart local v3    # "e":Ljava/lang/Exception;
    invoke-virtual {p0, v3}, Lcom/livemixtapes/AsyncHttp$AsyncGet;->getExceptionResponse(Ljava/lang/Exception;)Lcom/livemixtapes/AsyncHttp$HttpResponseData;

    move-result-object v11

    goto :goto_1
.end method
