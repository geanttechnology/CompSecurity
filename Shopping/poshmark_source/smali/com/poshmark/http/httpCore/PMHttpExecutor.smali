.class public Lcom/poshmark/http/httpCore/PMHttpExecutor;
.super Ljava/lang/Object;
.source "PMHttpExecutor.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/http/httpCore/PMHttpExecutor$2;,
        Lcom/poshmark/http/httpCore/PMHttpExecutor$MakeRequestTask;
    }
.end annotation


# static fields
.field private static final RESPONSE_MESSAGE:I = 0x1


# instance fields
.field handler:Landroid/os/Handler;

.field httpRequest:Lorg/apache/http/client/methods/HttpUriRequest;

.field final pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;


# direct methods
.method public constructor <init>(Lcom/poshmark/http/PMHttpRequest;)V
    .locals 1
    .param p1, "pmHttpRequest"    # Lcom/poshmark/http/PMHttpRequest;

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->httpRequest:Lorg/apache/http/client/methods/HttpUriRequest;

    .line 43
    iput-object p1, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    .line 44
    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/http/httpCore/PMHttpExecutor;Lcom/poshmark/http/PMHttpResponse;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/http/httpCore/PMHttpExecutor;
    .param p1, "x1"    # Lcom/poshmark/http/PMHttpResponse;

    .prologue
    .line 32
    invoke-direct {p0, p1}, Lcom/poshmark/http/httpCore/PMHttpExecutor;->sendResponseMessage(Lcom/poshmark/http/PMHttpResponse;)V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/http/httpCore/PMHttpExecutor;Landroid/os/Message;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/http/httpCore/PMHttpExecutor;
    .param p1, "x1"    # Landroid/os/Message;

    .prologue
    .line 32
    invoke-direct {p0, p1}, Lcom/poshmark/http/httpCore/PMHttpExecutor;->handleMessage(Landroid/os/Message;)V

    return-void
.end method

.method private handleMessage(Landroid/os/Message;)V
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 179
    iget v1, p1, Landroid/os/Message;->what:I

    packed-switch v1, :pswitch_data_0

    .line 184
    :goto_0
    return-void

    .line 181
    :pswitch_0
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/http/PMHttpResponse;

    .line 182
    .local v0, "pmHttpResponse":Lcom/poshmark/http/PMHttpResponse;
    invoke-virtual {p0, v0}, Lcom/poshmark/http/httpCore/PMHttpExecutor;->callResponseHandler(Lcom/poshmark/http/PMHttpResponse;)V

    goto :goto_0

    .line 179
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method private obtainMessage(Lcom/poshmark/http/PMHttpResponse;)Landroid/os/Message;
    .locals 3
    .param p1, "response"    # Lcom/poshmark/http/PMHttpResponse;

    .prologue
    .line 188
    const/4 v1, 0x1

    .line 189
    .local v1, "responseMessageType":I
    const/4 v0, 0x0

    .line 190
    .local v0, "msg":Landroid/os/Message;
    iget-object v2, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->handler:Landroid/os/Handler;

    if-eqz v2, :cond_0

    .line 191
    iget-object v2, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->handler:Landroid/os/Handler;

    invoke-virtual {v2, v1, p1}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 197
    :goto_0
    return-object v0

    .line 193
    :cond_0
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v0

    .line 194
    iput v1, v0, Landroid/os/Message;->what:I

    .line 195
    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    goto :goto_0
.end method

.method private sendResponseMessage(Lcom/poshmark/http/PMHttpResponse;)V
    .locals 2
    .param p1, "pmHttpResponse"    # Lcom/poshmark/http/PMHttpResponse;

    .prologue
    .line 169
    invoke-direct {p0, p1}, Lcom/poshmark/http/httpCore/PMHttpExecutor;->obtainMessage(Lcom/poshmark/http/PMHttpResponse;)Landroid/os/Message;

    move-result-object v0

    .line 170
    .local v0, "msg":Landroid/os/Message;
    iget-object v1, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->handler:Landroid/os/Handler;

    if-eqz v1, :cond_0

    .line 171
    iget-object v1, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->handler:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 175
    :goto_0
    return-void

    .line 173
    :cond_0
    invoke-direct {p0, v0}, Lcom/poshmark/http/httpCore/PMHttpExecutor;->handleMessage(Landroid/os/Message;)V

    goto :goto_0
.end method

.method private setupHandlerForCallingThread()V
    .locals 1

    .prologue
    .line 157
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 158
    new-instance v0, Lcom/poshmark/http/httpCore/PMHttpExecutor$1;

    invoke-direct {v0, p0}, Lcom/poshmark/http/httpCore/PMHttpExecutor$1;-><init>(Lcom/poshmark/http/httpCore/PMHttpExecutor;)V

    iput-object v0, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->handler:Landroid/os/Handler;

    .line 165
    :cond_0
    return-void
.end method


# virtual methods
.method protected callResponseHandler(Lcom/poshmark/http/PMHttpResponse;)V
    .locals 1
    .param p1, "pmHttpResponse"    # Lcom/poshmark/http/PMHttpResponse;

    .prologue
    .line 116
    iget-object v0, p1, Lcom/poshmark/http/PMHttpResponse;->httpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget-object v0, v0, Lcom/poshmark/http/PMHttpRequest;->responseHandler:Lcom/poshmark/http/PMBaseHttpResponseHandler;

    if-eqz v0, :cond_0

    .line 117
    iget-object v0, p1, Lcom/poshmark/http/PMHttpResponse;->httpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget-object v0, v0, Lcom/poshmark/http/PMHttpRequest;->responseHandler:Lcom/poshmark/http/PMBaseHttpResponseHandler;

    check-cast v0, Lcom/poshmark/http/PMHttpResponseHandler;

    invoke-interface {v0, p1}, Lcom/poshmark/http/PMHttpResponseHandler;->handleResponse(Lcom/poshmark/http/PMHttpResponse;)V

    .line 118
    :cond_0
    return-void
.end method

.method public execute()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 49
    iget-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget-object v4, v4, Lcom/poshmark/http/PMHttpRequest;->responseHandler:Lcom/poshmark/http/PMBaseHttpResponseHandler;

    if-eqz v4, :cond_0

    .line 50
    invoke-direct {p0}, Lcom/poshmark/http/httpCore/PMHttpExecutor;->setupHandlerForCallingThread()V

    .line 54
    :cond_0
    iget-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget-object v4, v4, Lcom/poshmark/http/PMHttpRequest;->url:Ljava/lang/String;

    iget-object v5, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget-object v5, v5, Lcom/poshmark/http/PMHttpRequest;->queryParams:Ljava/util/Map;

    invoke-static {v4, v5}, Lcom/poshmark/http/httpUtils/PMHttpUtils;->getUrlWithQueryString(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v3

    .line 58
    .local v3, "url":Ljava/lang/String;
    sget-object v4, Lcom/poshmark/http/httpCore/PMHttpExecutor$2;->$SwitchMap$com$poshmark$http$PMHttpRequest$REQUEST_TYPE:[I

    iget-object v5, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget-object v5, v5, Lcom/poshmark/http/PMHttpRequest;->requestType:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    invoke-virtual {v5}, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    .line 74
    :goto_0
    iget-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget-object v4, v4, Lcom/poshmark/http/PMHttpRequest;->headers:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 75
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v6, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->httpRequest:Lorg/apache/http/client/methods/HttpUriRequest;

    new-instance v7, Lorg/apache/http/message/BasicHeader;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-direct {v7, v4, v5}, Lorg/apache/http/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v6, v7}, Lorg/apache/http/client/methods/HttpUriRequest;->addHeader(Lorg/apache/http/Header;)V

    goto :goto_1

    .line 60
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v2    # "i$":Ljava/util/Iterator;
    :pswitch_0
    new-instance v4, Lorg/apache/http/client/methods/HttpGet;

    invoke-direct {v4, v3}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    iput-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->httpRequest:Lorg/apache/http/client/methods/HttpUriRequest;

    goto :goto_0

    .line 63
    :pswitch_1
    new-instance v4, Lorg/apache/http/client/methods/HttpPost;

    invoke-direct {v4, v3}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    iput-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->httpRequest:Lorg/apache/http/client/methods/HttpUriRequest;

    goto :goto_0

    .line 66
    :pswitch_2
    new-instance v4, Lorg/apache/http/client/methods/HttpPut;

    invoke-direct {v4, v3}, Lorg/apache/http/client/methods/HttpPut;-><init>(Ljava/lang/String;)V

    iput-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->httpRequest:Lorg/apache/http/client/methods/HttpUriRequest;

    goto :goto_0

    .line 69
    :pswitch_3
    new-instance v4, Lorg/apache/http/client/methods/HttpDelete;

    invoke-direct {v4, v3}, Lorg/apache/http/client/methods/HttpDelete;-><init>(Ljava/lang/String;)V

    iput-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->httpRequest:Lorg/apache/http/client/methods/HttpUriRequest;

    goto :goto_0

    .line 79
    .restart local v2    # "i$":Ljava/util/Iterator;
    :cond_1
    iget-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget-object v4, v4, Lcom/poshmark/http/PMHttpRequest;->formData:Ljava/util/Map;

    if-eqz v4, :cond_2

    iget-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget-object v4, v4, Lcom/poshmark/http/PMHttpRequest;->formData:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->size()I

    move-result v4

    if-gtz v4, :cond_4

    :cond_2
    iget-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget-object v4, v4, Lcom/poshmark/http/PMHttpRequest;->nestedFormData:Lcom/poshmark/utils/view_holders/MultiMap;

    if-eqz v4, :cond_3

    iget-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget-object v4, v4, Lcom/poshmark/http/PMHttpRequest;->nestedFormData:Lcom/poshmark/utils/view_holders/MultiMap;

    invoke-virtual {v4}, Lcom/poshmark/utils/view_holders/MultiMap;->size()I

    move-result v4

    if-gtz v4, :cond_4

    :cond_3
    iget-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget-object v4, v4, Lcom/poshmark/http/PMHttpRequest;->multipartData:Ljava/util/Map;

    if-eqz v4, :cond_5

    iget-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget-object v4, v4, Lcom/poshmark/http/PMHttpRequest;->multipartData:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->size()I

    move-result v4

    if-lez v4, :cond_5

    .line 82
    :cond_4
    iget-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->httpRequest:Lorg/apache/http/client/methods/HttpUriRequest;

    instance-of v4, v4, Lorg/apache/http/client/methods/HttpEntityEnclosingRequestBase;

    if-eqz v4, :cond_5

    .line 83
    iget-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->httpRequest:Lorg/apache/http/client/methods/HttpUriRequest;

    check-cast v4, Lorg/apache/http/client/methods/HttpEntityEnclosingRequestBase;

    iget-object v5, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    invoke-static {v5}, Lcom/poshmark/http/httpUtils/PMHttpUtils;->getEntityForRequest(Lcom/poshmark/http/PMHttpRequest;)Lorg/apache/http/HttpEntity;

    move-result-object v5

    invoke-virtual {v4, v5}, Lorg/apache/http/client/methods/HttpEntityEnclosingRequestBase;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 88
    :cond_5
    new-instance v1, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v1}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 89
    .local v1, "httpParameters":Lorg/apache/http/params/HttpParams;
    const-string v4, "http.protocol.handle-redirects"

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-interface {v1, v4, v5}, Lorg/apache/http/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/http/params/HttpParams;

    .line 91
    iget-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget v4, v4, Lcom/poshmark/http/PMHttpRequest;->timeoutMilliSeconds:I

    const/4 v5, -0x1

    if-eq v4, v5, :cond_6

    .line 93
    iget-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget v4, v4, Lcom/poshmark/http/PMHttpRequest;->timeoutMilliSeconds:I

    invoke-static {v1, v4}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 96
    :cond_6
    iget-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->httpRequest:Lorg/apache/http/client/methods/HttpUriRequest;

    invoke-interface {v4, v1}, Lorg/apache/http/client/methods/HttpUriRequest;->setParams(Lorg/apache/http/params/HttpParams;)V

    .line 99
    new-instance v4, Lcom/poshmark/http/httpCore/PMHttpExecutor$MakeRequestTask;

    const/4 v5, 0x0

    invoke-direct {v4, p0, v5}, Lcom/poshmark/http/httpCore/PMHttpExecutor$MakeRequestTask;-><init>(Lcom/poshmark/http/httpCore/PMHttpExecutor;Lcom/poshmark/http/httpCore/PMHttpExecutor$1;)V

    sget-object v5, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    new-array v6, v8, [Ljava/lang/Void;

    instance-of v7, v4, Landroid/os/AsyncTask;

    if-nez v7, :cond_7

    invoke-virtual {v4, v5, v6}, Lcom/poshmark/http/httpCore/PMHttpExecutor$MakeRequestTask;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 101
    :goto_2
    return-void

    .line 99
    :cond_7
    check-cast v4, Landroid/os/AsyncTask;

    invoke-static {v4, v5, v6}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->executeOnExecutor(Landroid/os/AsyncTask;Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_2

    .line 58
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method protected prepareResponse(I[Lorg/apache/http/Header;Ljava/lang/String;Ljava/lang/Throwable;)Lcom/poshmark/http/PMHttpResponse;
    .locals 6
    .param p1, "httpCode"    # I
    .param p2, "headerArray"    # [Lorg/apache/http/Header;
    .param p3, "responseString"    # Ljava/lang/String;
    .param p4, "exception"    # Ljava/lang/Throwable;

    .prologue
    .line 107
    const/4 v5, 0x0

    .line 108
    .local v5, "pmHttpError":Lcom/poshmark/http/PMHttpError;
    if-eqz p4, :cond_0

    .line 109
    new-instance v5, Lcom/poshmark/http/PMHttpError;

    .end local v5    # "pmHttpError":Lcom/poshmark/http/PMHttpError;
    invoke-direct {v5, p4}, Lcom/poshmark/http/PMHttpError;-><init>(Ljava/lang/Throwable;)V

    .line 111
    .restart local v5    # "pmHttpError":Lcom/poshmark/http/PMHttpError;
    :cond_0
    new-instance v0, Lcom/poshmark/http/PMHttpResponse;

    iget-object v4, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    move v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-direct/range {v0 .. v5}, Lcom/poshmark/http/PMHttpResponse;-><init>(I[Lorg/apache/http/Header;Ljava/lang/String;Lcom/poshmark/http/PMHttpRequest;Lcom/poshmark/http/PMHttpError;)V

    return-object v0
.end method
