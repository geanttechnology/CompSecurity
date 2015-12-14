.class Lcom/livemixtapes/AsyncHttp$AsyncPost;
.super Lcom/livemixtapes/AsyncHttp$AsyncRequest;
.source "AsyncHttp.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/AsyncHttp;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AsyncPost"
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
    .line 181
    .local p3, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/livemixtapes/AsyncHttp$AsyncPost;->this$0:Lcom/livemixtapes/AsyncHttp;

    .line 182
    invoke-direct {p0, p2, p3, p4, p5}, Lcom/livemixtapes/AsyncHttp$AsyncRequest;-><init>(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V

    .line 183
    return-void
.end method


# virtual methods
.method protected varargs doInBackground([Ljava/lang/Void;)Lcom/livemixtapes/AsyncHttp$HttpResponseData;
    .locals 15
    .param p1, "nothing"    # [Ljava/lang/Void;

    .prologue
    .line 188
    const/4 v0, 0x0

    .line 193
    .local v0, "client":Lorg/apache/http/client/HttpClient;
    sget-object v11, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual {v11}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    const v12, 0x7f070001

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v5

    .line 194
    .local v5, "in":Ljava/io/InputStream;
    const-string v7, "api42829"

    .line 196
    .local v7, "password":Ljava/lang/String;
    :try_start_0
    const-string v11, "BKS"

    invoke-static {v11}, Ljava/security/KeyStore;->getInstance(Ljava/lang/String;)Ljava/security/KeyStore;

    move-result-object v6

    .line 197
    .local v6, "keyStore":Ljava/security/KeyStore;
    invoke-virtual {v7}, Ljava/lang/String;->toCharArray()[C

    move-result-object v11

    invoke-virtual {v6, v5, v11}, Ljava/security/KeyStore;->load(Ljava/io/InputStream;[C)V

    .line 199
    new-instance v4, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v4}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 200
    .local v4, "httpParams":Lorg/apache/http/params/HttpParams;
    new-instance v10, Lorg/apache/http/conn/scheme/SchemeRegistry;

    invoke-direct {v10}, Lorg/apache/http/conn/scheme/SchemeRegistry;-><init>()V

    .line 201
    .local v10, "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    new-instance v11, Lorg/apache/http/conn/scheme/Scheme;

    const-string v12, "https"

    new-instance v13, Lorg/apache/http/conn/ssl/SSLSocketFactory;

    invoke-direct {v13, v6}, Lorg/apache/http/conn/ssl/SSLSocketFactory;-><init>(Ljava/security/KeyStore;)V

    const/16 v14, 0x1bb

    invoke-direct {v11, v12, v13, v14}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v10, v11}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 202
    new-instance v2, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;

    invoke-direct {v2, v4, v10}, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;-><init>(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V

    .line 203
    .local v2, "clientMan":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    new-instance v1, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v1, v2, v4}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .end local v0    # "client":Lorg/apache/http/client/HttpClient;
    .local v1, "client":Lorg/apache/http/client/HttpClient;
    move-object v0, v1

    .line 210
    .end local v1    # "client":Lorg/apache/http/client/HttpClient;
    .end local v2    # "clientMan":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    .end local v4    # "httpParams":Lorg/apache/http/params/HttpParams;
    .end local v6    # "keyStore":Ljava/security/KeyStore;
    .end local v10    # "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    .restart local v0    # "client":Lorg/apache/http/client/HttpClient;
    :goto_0
    iget-object v11, p0, Lcom/livemixtapes/AsyncHttp$AsyncPost;->url:Ljava/lang/String;

    iget-object v12, p0, Lcom/livemixtapes/AsyncHttp$AsyncPost;->params:Ljava/util/Map;

    invoke-virtual {p0, v11, v12}, Lcom/livemixtapes/AsyncHttp$AsyncPost;->getParamRequest(Ljava/lang/String;Ljava/util/Map;)Lorg/apache/http/client/methods/HttpPost;

    move-result-object v8

    .line 211
    .local v8, "request":Lorg/apache/http/client/methods/HttpPost;
    const-string v11, "X-Api-Key"

    const-string v12, "bJGpttXhgbjsLEpbI9VPFj1pvizPrfLh"

    invoke-virtual {v8, v11, v12}, Lorg/apache/http/client/methods/HttpPost;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 212
    const-string v11, "User-Agent"

    const-string v12, "LiveMixtapes Android/1.0.84 BETA"

    invoke-virtual {v8, v11, v12}, Lorg/apache/http/client/methods/HttpPost;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    const/4 v9, 0x0

    .line 216
    .local v9, "response":Lorg/apache/http/HttpResponse;
    :try_start_1
    invoke-interface {v0, v8}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v9

    .line 221
    invoke-virtual {p0, v9}, Lcom/livemixtapes/AsyncHttp$AsyncPost;->getDataResponse(Lorg/apache/http/HttpResponse;)Lcom/livemixtapes/AsyncHttp$HttpResponseData;

    move-result-object v11

    :goto_1
    return-object v11

    .line 205
    .end local v8    # "request":Lorg/apache/http/client/methods/HttpPost;
    .end local v9    # "response":Lorg/apache/http/HttpResponse;
    :catch_0
    move-exception v3

    .line 207
    .local v3, "e":Ljava/lang/Exception;
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 217
    .end local v3    # "e":Ljava/lang/Exception;
    .restart local v8    # "request":Lorg/apache/http/client/methods/HttpPost;
    .restart local v9    # "response":Lorg/apache/http/HttpResponse;
    :catch_1
    move-exception v3

    .line 218
    .restart local v3    # "e":Ljava/lang/Exception;
    invoke-virtual {p0, v3}, Lcom/livemixtapes/AsyncHttp$AsyncPost;->getExceptionResponse(Ljava/lang/Exception;)Lcom/livemixtapes/AsyncHttp$HttpResponseData;

    move-result-object v11

    goto :goto_1
.end method

.method protected getParamRequest(Ljava/lang/String;Ljava/util/Map;)Lorg/apache/http/client/methods/HttpPost;
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
            "Lorg/apache/http/client/methods/HttpPost;"
        }
    .end annotation

    .prologue
    .line 225
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v2, Lorg/apache/http/client/methods/HttpPost;

    invoke-direct {v2, p1}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 227
    .local v2, "request":Lorg/apache/http/client/methods/HttpPost;
    if-eqz p2, :cond_0

    invoke-interface {p2}, Ljava/util/Map;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 228
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 230
    .local v1, "parameters":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/NameValuePair;>;"
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_1

    .line 235
    :try_start_0
    new-instance v3, Lorg/apache/http/client/entity/UrlEncodedFormEntity;

    const-string v4, "UTF-8"

    invoke-direct {v3, v1, v4}, Lorg/apache/http/client/entity/UrlEncodedFormEntity;-><init>(Ljava/util/List;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 240
    .end local v1    # "parameters":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/NameValuePair;>;"
    :cond_0
    :goto_1
    return-object v2

    .line 230
    .restart local v1    # "parameters":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/NameValuePair;>;"
    :cond_1
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 231
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-direct {v6, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 236
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :catch_0
    move-exception v3

    goto :goto_1
.end method
