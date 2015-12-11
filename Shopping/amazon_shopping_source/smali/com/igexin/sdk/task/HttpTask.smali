.class public abstract Lcom/igexin/sdk/task/HttpTask;
.super Ljava/lang/Thread;
.source "HttpTask.java"


# static fields
.field public static httpClient:Lorg/apache/http/client/HttpClient;


# instance fields
.field protected callbackListener:Lcom/igexin/sdk/CallbackListener;

.field private data:[B

.field private isEncrypt:Z

.field public request:Lorg/apache/http/client/methods/HttpRequestBase;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;[BLcom/igexin/sdk/CallbackListener;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "data"    # [B
    .param p3, "callbackListener"    # Lcom/igexin/sdk/CallbackListener;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 24
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/igexin/sdk/task/HttpTask;->isEncrypt:Z

    .line 25
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/igexin/sdk/task/HttpTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    .line 28
    iput-object p1, p0, Lcom/igexin/sdk/task/HttpTask;->url:Ljava/lang/String;

    .line 29
    iput-object p2, p0, Lcom/igexin/sdk/task/HttpTask;->data:[B

    .line 30
    iput-object p3, p0, Lcom/igexin/sdk/task/HttpTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    .line 31
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[BLcom/igexin/sdk/CallbackListener;Z)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "data"    # [B
    .param p3, "callbackListener"    # Lcom/igexin/sdk/CallbackListener;
    .param p4, "isEncrypt"    # Z

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 24
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/igexin/sdk/task/HttpTask;->isEncrypt:Z

    .line 25
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/igexin/sdk/task/HttpTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    .line 34
    iput-object p1, p0, Lcom/igexin/sdk/task/HttpTask;->url:Ljava/lang/String;

    .line 35
    iput-object p2, p0, Lcom/igexin/sdk/task/HttpTask;->data:[B

    .line 36
    iput-object p3, p0, Lcom/igexin/sdk/task/HttpTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    .line 37
    iput-boolean p4, p0, Lcom/igexin/sdk/task/HttpTask;->isEncrypt:Z

    .line 38
    return-void
.end method


# virtual methods
.method public httpExecuteData()V
    .locals 9

    .prologue
    const/4 v8, 0x2

    .line 80
    new-instance v4, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v4}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>()V

    sput-object v4, Lcom/igexin/sdk/task/HttpTask;->httpClient:Lorg/apache/http/client/HttpClient;

    .line 83
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    const/4 v4, 0x3

    if-ge v1, v4, :cond_0

    .line 85
    :try_start_0
    sget-object v4, Lcom/igexin/sdk/task/HttpTask;->httpClient:Lorg/apache/http/client/HttpClient;

    iget-object v5, p0, Lcom/igexin/sdk/task/HttpTask;->request:Lorg/apache/http/client/methods/HttpRequestBase;

    invoke-interface {v4, v5}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v2

    .line 87
    .local v2, "response":Lorg/apache/http/HttpResponse;
    invoke-interface {v2}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v4

    invoke-interface {v4}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v4

    const/16 v5, 0xc8

    if-ne v4, v5, :cond_1

    .line 88
    invoke-interface {v2}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v4

    invoke-static {v4}, Lorg/apache/http/util/EntityUtils;->toByteArray(Lorg/apache/http/HttpEntity;)[B

    move-result-object v3

    .line 90
    .local v3, "rtData":[B
    invoke-virtual {p0, v3}, Lcom/igexin/sdk/task/HttpTask;->parseData([B)V

    .line 105
    .end local v2    # "response":Lorg/apache/http/HttpResponse;
    .end local v3    # "rtData":[B
    :cond_0
    return-void

    .line 93
    .restart local v2    # "response":Lorg/apache/http/HttpResponse;
    :cond_1
    if-ne v1, v8, :cond_2

    iget-object v4, p0, Lcom/igexin/sdk/task/HttpTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    if-eqz v4, :cond_2

    .line 94
    iget-object v4, p0, Lcom/igexin/sdk/task/HttpTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    new-instance v5, Ljava/lang/Exception;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "Http response code is : "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-interface {v2}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v7

    invoke-interface {v7}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    invoke-interface {v4, v5}, Lcom/igexin/sdk/CallbackListener;->exceptionHandler(Ljava/lang/Exception;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 83
    .end local v2    # "response":Lorg/apache/http/HttpResponse;
    :cond_2
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 97
    :catch_0
    move-exception v0

    .line 98
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 100
    if-ne v1, v8, :cond_2

    iget-object v4, p0, Lcom/igexin/sdk/task/HttpTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    if-eqz v4, :cond_2

    .line 101
    iget-object v4, p0, Lcom/igexin/sdk/task/HttpTask;->callbackListener:Lcom/igexin/sdk/CallbackListener;

    invoke-interface {v4, v0}, Lcom/igexin/sdk/CallbackListener;->exceptionHandler(Ljava/lang/Exception;)V

    goto :goto_1
.end method

.method public abstract parseData([B)V
.end method

.method public final run()V
    .locals 8

    .prologue
    .line 45
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 46
    const/16 v4, 0xa

    invoke-static {v4}, Landroid/os/Process;->setThreadPriority(I)V

    .line 50
    iget-object v4, p0, Lcom/igexin/sdk/task/HttpTask;->data:[B

    if-nez v4, :cond_0

    .line 51
    new-instance v0, Lorg/apache/http/client/methods/HttpGet;

    iget-object v4, p0, Lcom/igexin/sdk/task/HttpTask;->url:Ljava/lang/String;

    invoke-direct {v0, v4}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 52
    .local v0, "getRequest":Lorg/apache/http/client/methods/HttpGet;
    iput-object v0, p0, Lcom/igexin/sdk/task/HttpTask;->request:Lorg/apache/http/client/methods/HttpRequestBase;

    .line 53
    invoke-virtual {p0}, Lcom/igexin/sdk/task/HttpTask;->httpExecuteData()V

    .line 74
    .end local v0    # "getRequest":Lorg/apache/http/client/methods/HttpGet;
    :goto_0
    return-void

    .line 56
    :cond_0
    new-instance v3, Lorg/apache/http/client/methods/HttpPost;

    iget-object v4, p0, Lcom/igexin/sdk/task/HttpTask;->url:Ljava/lang/String;

    invoke-direct {v3, v4}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 57
    .local v3, "requestPost":Lorg/apache/http/client/methods/HttpPost;
    iput-object v3, p0, Lcom/igexin/sdk/task/HttpTask;->request:Lorg/apache/http/client/methods/HttpRequestBase;

    .line 62
    iget-boolean v4, p0, Lcom/igexin/sdk/task/HttpTask;->isEncrypt:Z

    if-eqz v4, :cond_1

    .line 63
    iget-object v4, p0, Lcom/igexin/sdk/task/HttpTask;->request:Lorg/apache/http/client/methods/HttpRequestBase;

    const-string/jumbo v5, "EncryptType"

    const-string/jumbo v6, "RC4"

    invoke-virtual {v4, v5, v6}, Lorg/apache/http/client/methods/HttpRequestBase;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    iget-object v4, p0, Lcom/igexin/sdk/task/HttpTask;->request:Lorg/apache/http/client/methods/HttpRequestBase;

    const-string/jumbo v5, "AppKey"

    sget-object v6, Lcom/igexin/sdk/Consts;->VPUSH_APPKEY:Ljava/lang/String;

    invoke-virtual {v4, v5, v6}, Lorg/apache/http/client/methods/HttpRequestBase;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    iget-object v4, p0, Lcom/igexin/sdk/task/HttpTask;->data:[B

    sget-object v5, Lcom/igexin/sdk/Consts;->VPUSH_APPSECRET:Ljava/lang/String;

    invoke-static {v4, v5}, Lcom/igexin/sdk/encrypt/RC4Carder;->Encrypt([BLjava/lang/String;)[B

    move-result-object v4

    iput-object v4, p0, Lcom/igexin/sdk/task/HttpTask;->data:[B

    .line 67
    sget-object v4, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "isEncrypt...data = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    new-instance v6, Ljava/lang/String;

    iget-object v7, p0, Lcom/igexin/sdk/task/HttpTask;->data:[B

    invoke-direct {v6, v7}, Ljava/lang/String;-><init>([B)V

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 69
    :cond_1
    new-instance v2, Ljava/io/ByteArrayInputStream;

    iget-object v4, p0, Lcom/igexin/sdk/task/HttpTask;->data:[B

    invoke-direct {v2, v4}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 70
    .local v2, "instream":Ljava/io/InputStream;
    new-instance v1, Lorg/apache/http/entity/InputStreamEntity;

    iget-object v4, p0, Lcom/igexin/sdk/task/HttpTask;->data:[B

    array-length v4, v4

    int-to-long v4, v4

    invoke-direct {v1, v2, v4, v5}, Lorg/apache/http/entity/InputStreamEntity;-><init>(Ljava/io/InputStream;J)V

    .line 71
    .local v1, "inputStreamEntity":Lorg/apache/http/entity/InputStreamEntity;
    invoke-virtual {v3, v1}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 72
    invoke-virtual {p0}, Lcom/igexin/sdk/task/HttpTask;->httpExecuteData()V

    goto :goto_0
.end method
