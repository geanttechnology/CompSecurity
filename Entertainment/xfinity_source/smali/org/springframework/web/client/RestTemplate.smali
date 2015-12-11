.class public Lorg/springframework/web/client/RestTemplate;
.super Lorg/springframework/http/client/support/InterceptingHttpAccessor;
.source "RestTemplate.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/springframework/web/client/RestTemplate$1;,
        Lorg/springframework/web/client/RestTemplate$HeadersExtractor;,
        Lorg/springframework/web/client/RestTemplate$DefaultMessageConverters;,
        Lorg/springframework/web/client/RestTemplate$ResponseEntityResponseExtractor;,
        Lorg/springframework/web/client/RestTemplate$HttpEntityRequestCallback;,
        Lorg/springframework/web/client/RestTemplate$AcceptHeaderRequestCallback;
    }
.end annotation


# instance fields
.field private errorHandler:Lorg/springframework/web/client/ResponseErrorHandler;

.field private final headersExtractor:Lorg/springframework/web/client/ResponseExtractor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/springframework/web/client/ResponseExtractor",
            "<",
            "Lorg/springframework/http/HttpHeaders;",
            ">;"
        }
    .end annotation
.end field

.field private messageConverters:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lorg/springframework/http/converter/HttpMessageConverter",
            "<*>;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 157
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lorg/springframework/web/client/RestTemplate;-><init>(Z)V

    .line 158
    return-void
.end method

.method public constructor <init>(Lorg/springframework/http/client/ClientHttpRequestFactory;)V
    .locals 1
    .param p1, "requestFactory"    # Lorg/springframework/http/client/ClientHttpRequestFactory;

    .prologue
    .line 184
    const/4 v0, 0x0

    invoke-direct {p0, v0, p1}, Lorg/springframework/web/client/RestTemplate;-><init>(ZLorg/springframework/http/client/ClientHttpRequestFactory;)V

    .line 185
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 2
    .param p1, "includeDefaultConverters"    # Z

    .prologue
    .line 168
    invoke-direct {p0}, Lorg/springframework/http/client/support/InterceptingHttpAccessor;-><init>()V

    .line 143
    new-instance v0, Lorg/springframework/web/client/RestTemplate$HeadersExtractor;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lorg/springframework/web/client/RestTemplate$HeadersExtractor;-><init>(Lorg/springframework/web/client/RestTemplate$1;)V

    iput-object v0, p0, Lorg/springframework/web/client/RestTemplate;->headersExtractor:Lorg/springframework/web/client/ResponseExtractor;

    .line 145
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/springframework/web/client/RestTemplate;->messageConverters:Ljava/util/List;

    .line 147
    new-instance v0, Lorg/springframework/web/client/DefaultResponseErrorHandler;

    invoke-direct {v0}, Lorg/springframework/web/client/DefaultResponseErrorHandler;-><init>()V

    iput-object v0, p0, Lorg/springframework/web/client/RestTemplate;->errorHandler:Lorg/springframework/web/client/ResponseErrorHandler;

    .line 169
    if-eqz p1, :cond_0

    .line 170
    iget-object v0, p0, Lorg/springframework/web/client/RestTemplate;->messageConverters:Ljava/util/List;

    invoke-static {v0}, Lorg/springframework/web/client/RestTemplate$DefaultMessageConverters;->init(Ljava/util/List;)V

    .line 172
    :cond_0
    return-void
.end method

.method public constructor <init>(ZLorg/springframework/http/client/ClientHttpRequestFactory;)V
    .locals 0
    .param p1, "includeDefaultConverters"    # Z
    .param p2, "requestFactory"    # Lorg/springframework/http/client/ClientHttpRequestFactory;

    .prologue
    .line 199
    invoke-direct {p0, p1}, Lorg/springframework/web/client/RestTemplate;-><init>(Z)V

    .line 200
    invoke-virtual {p0, p2}, Lorg/springframework/web/client/RestTemplate;->setRequestFactory(Lorg/springframework/http/client/ClientHttpRequestFactory;)V

    .line 201
    return-void
.end method

.method private handleResponseError(Lorg/springframework/http/HttpMethod;Ljava/net/URI;Lorg/springframework/http/client/ClientHttpResponse;)V
    .locals 3
    .param p1, "method"    # Lorg/springframework/http/HttpMethod;
    .param p2, "url"    # Ljava/net/URI;
    .param p3, "response"    # Lorg/springframework/http/client/ClientHttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 513
    const-string v0, "RestTemplate"

    const/4 v1, 0x3

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 515
    :try_start_0
    const-string v0, "RestTemplate"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lorg/springframework/http/HttpMethod;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " request for \""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\" resulted in "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p3}, Lorg/springframework/http/client/ClientHttpResponse;->getStatusCode()Lorg/springframework/http/HttpStatus;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p3}, Lorg/springframework/http/client/ClientHttpResponse;->getStatusText()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "); invoking error handler"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 523
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lorg/springframework/web/client/RestTemplate;->getErrorHandler()Lorg/springframework/web/client/ResponseErrorHandler;

    move-result-object v0

    invoke-interface {v0, p3}, Lorg/springframework/web/client/ResponseErrorHandler;->handleError(Lorg/springframework/http/client/ClientHttpResponse;)V

    .line 524
    return-void

    .line 519
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private logResponseStatus(Lorg/springframework/http/HttpMethod;Ljava/net/URI;Lorg/springframework/http/client/ClientHttpResponse;)V
    .locals 3
    .param p1, "method"    # Lorg/springframework/http/HttpMethod;
    .param p2, "url"    # Ljava/net/URI;
    .param p3, "response"    # Lorg/springframework/http/client/ClientHttpResponse;

    .prologue
    .line 500
    const-string v0, "RestTemplate"

    const/4 v1, 0x3

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 502
    :try_start_0
    const-string v0, "RestTemplate"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lorg/springframework/http/HttpMethod;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " request for \""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\" resulted in "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p3}, Lorg/springframework/http/client/ClientHttpResponse;->getStatusCode()Lorg/springframework/http/HttpStatus;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p3}, Lorg/springframework/http/client/ClientHttpResponse;->getStatusText()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 510
    :cond_0
    :goto_0
    return-void

    .line 506
    :catch_0
    move-exception v0

    goto :goto_0
.end method


# virtual methods
.method protected doExecute(Ljava/net/URI;Lorg/springframework/http/HttpMethod;Lorg/springframework/web/client/RequestCallback;Lorg/springframework/web/client/ResponseExtractor;)Ljava/lang/Object;
    .locals 6
    .param p1, "url"    # Ljava/net/URI;
    .param p2, "method"    # Lorg/springframework/http/HttpMethod;
    .param p3, "requestCallback"    # Lorg/springframework/web/client/RequestCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/net/URI;",
            "Lorg/springframework/http/HttpMethod;",
            "Lorg/springframework/web/client/RequestCallback;",
            "Lorg/springframework/web/client/ResponseExtractor",
            "<TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/springframework/web/client/RestClientException;
        }
    .end annotation

    .prologue
    .line 467
    .local p4, "responseExtractor":Lorg/springframework/web/client/ResponseExtractor;, "Lorg/springframework/web/client/ResponseExtractor<TT;>;"
    const-string v3, "\'url\' must not be null"

    invoke-static {p1, v3}, Lorg/springframework/util/Assert;->notNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 468
    const-string v3, "\'method\' must not be null"

    invoke-static {p2, v3}, Lorg/springframework/util/Assert;->notNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 469
    const/4 v2, 0x0

    .line 471
    .local v2, "response":Lorg/springframework/http/client/ClientHttpResponse;
    :try_start_0
    invoke-virtual {p0, p1, p2}, Lorg/springframework/web/client/RestTemplate;->createRequest(Ljava/net/URI;Lorg/springframework/http/HttpMethod;)Lorg/springframework/http/client/ClientHttpRequest;

    move-result-object v1

    .line 472
    .local v1, "request":Lorg/springframework/http/client/ClientHttpRequest;
    if-eqz p3, :cond_0

    .line 473
    invoke-interface {p3, v1}, Lorg/springframework/web/client/RequestCallback;->doWithRequest(Lorg/springframework/http/client/ClientHttpRequest;)V

    .line 475
    :cond_0
    invoke-interface {v1}, Lorg/springframework/http/client/ClientHttpRequest;->execute()Lorg/springframework/http/client/ClientHttpResponse;

    move-result-object v2

    .line 476
    invoke-virtual {p0}, Lorg/springframework/web/client/RestTemplate;->getErrorHandler()Lorg/springframework/web/client/ResponseErrorHandler;

    move-result-object v3

    invoke-interface {v3, v2}, Lorg/springframework/web/client/ResponseErrorHandler;->hasError(Lorg/springframework/http/client/ClientHttpResponse;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 477
    invoke-direct {p0, p2, p1, v2}, Lorg/springframework/web/client/RestTemplate;->logResponseStatus(Lorg/springframework/http/HttpMethod;Ljava/net/URI;Lorg/springframework/http/client/ClientHttpResponse;)V

    .line 482
    :goto_0
    if-eqz p4, :cond_4

    .line 483
    invoke-interface {p4, v2}, Lorg/springframework/web/client/ResponseExtractor;->extractData(Lorg/springframework/http/client/ClientHttpResponse;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v3

    .line 493
    if-eqz v2, :cond_1

    .line 494
    invoke-interface {v2}, Lorg/springframework/http/client/ClientHttpResponse;->close()V

    :cond_1
    :goto_1
    return-object v3

    .line 480
    :cond_2
    :try_start_1
    invoke-direct {p0, p2, p1, v2}, Lorg/springframework/web/client/RestTemplate;->handleResponseError(Lorg/springframework/http/HttpMethod;Ljava/net/URI;Lorg/springframework/http/client/ClientHttpResponse;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 489
    .end local v1    # "request":Lorg/springframework/http/client/ClientHttpRequest;
    :catch_0
    move-exception v0

    .line 490
    .local v0, "ex":Ljava/io/IOException;
    :try_start_2
    new-instance v3, Lorg/springframework/web/client/ResourceAccessException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "I/O error: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v0}, Lorg/springframework/web/client/ResourceAccessException;-><init>(Ljava/lang/String;Ljava/io/IOException;)V

    throw v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 493
    .end local v0    # "ex":Ljava/io/IOException;
    :catchall_0
    move-exception v3

    if-eqz v2, :cond_3

    .line 494
    invoke-interface {v2}, Lorg/springframework/http/client/ClientHttpResponse;->close()V

    :cond_3
    throw v3

    .line 486
    .restart local v1    # "request":Lorg/springframework/http/client/ClientHttpRequest;
    :cond_4
    const/4 v3, 0x0

    .line 493
    if-eqz v2, :cond_1

    .line 494
    invoke-interface {v2}, Lorg/springframework/http/client/ClientHttpResponse;->close()V

    goto :goto_1
.end method

.method public exchange(Ljava/net/URI;Lorg/springframework/http/HttpMethod;Lorg/springframework/http/HttpEntity;Ljava/lang/Class;)Lorg/springframework/http/ResponseEntity;
    .locals 3
    .param p1, "url"    # Ljava/net/URI;
    .param p2, "method"    # Lorg/springframework/http/HttpMethod;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/net/URI;",
            "Lorg/springframework/http/HttpMethod;",
            "Lorg/springframework/http/HttpEntity",
            "<*>;",
            "Ljava/lang/Class",
            "<TT;>;)",
            "Lorg/springframework/http/ResponseEntity",
            "<TT;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/springframework/web/client/RestClientException;
        }
    .end annotation

    .prologue
    .line 426
    .local p3, "requestEntity":Lorg/springframework/http/HttpEntity;, "Lorg/springframework/http/HttpEntity<*>;"
    .local p4, "responseType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    new-instance v0, Lorg/springframework/web/client/RestTemplate$HttpEntityRequestCallback;

    const/4 v2, 0x0

    invoke-direct {v0, p0, p3, p4, v2}, Lorg/springframework/web/client/RestTemplate$HttpEntityRequestCallback;-><init>(Lorg/springframework/web/client/RestTemplate;Ljava/lang/Object;Ljava/lang/Class;Lorg/springframework/web/client/RestTemplate$1;)V

    .line 427
    .local v0, "requestCallback":Lorg/springframework/web/client/RestTemplate$HttpEntityRequestCallback;
    new-instance v1, Lorg/springframework/web/client/RestTemplate$ResponseEntityResponseExtractor;

    invoke-direct {v1, p0, p4}, Lorg/springframework/web/client/RestTemplate$ResponseEntityResponseExtractor;-><init>(Lorg/springframework/web/client/RestTemplate;Ljava/lang/Class;)V

    .line 428
    .local v1, "responseExtractor":Lorg/springframework/web/client/RestTemplate$ResponseEntityResponseExtractor;, "Lorg/springframework/web/client/RestTemplate$ResponseEntityResponseExtractor<TT;>;"
    invoke-virtual {p0, p1, p2, v0, v1}, Lorg/springframework/web/client/RestTemplate;->execute(Ljava/net/URI;Lorg/springframework/http/HttpMethod;Lorg/springframework/web/client/RequestCallback;Lorg/springframework/web/client/ResponseExtractor;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/springframework/http/ResponseEntity;

    return-object v2
.end method

.method public execute(Ljava/net/URI;Lorg/springframework/http/HttpMethod;Lorg/springframework/web/client/RequestCallback;Lorg/springframework/web/client/ResponseExtractor;)Ljava/lang/Object;
    .locals 1
    .param p1, "url"    # Ljava/net/URI;
    .param p2, "method"    # Lorg/springframework/http/HttpMethod;
    .param p3, "requestCallback"    # Lorg/springframework/web/client/RequestCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/net/URI;",
            "Lorg/springframework/http/HttpMethod;",
            "Lorg/springframework/web/client/RequestCallback;",
            "Lorg/springframework/web/client/ResponseExtractor",
            "<TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/springframework/web/client/RestClientException;
        }
    .end annotation

    .prologue
    .line 452
    .local p4, "responseExtractor":Lorg/springframework/web/client/ResponseExtractor;, "Lorg/springframework/web/client/ResponseExtractor<TT;>;"
    invoke-virtual {p0, p1, p2, p3, p4}, Lorg/springframework/web/client/RestTemplate;->doExecute(Ljava/net/URI;Lorg/springframework/http/HttpMethod;Lorg/springframework/web/client/RequestCallback;Lorg/springframework/web/client/ResponseExtractor;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getErrorHandler()Lorg/springframework/web/client/ResponseErrorHandler;
    .locals 1

    .prologue
    .line 226
    iget-object v0, p0, Lorg/springframework/web/client/RestTemplate;->errorHandler:Lorg/springframework/web/client/ResponseErrorHandler;

    return-object v0
.end method

.method public getForObject(Ljava/net/URI;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 3
    .param p1, "url"    # Ljava/net/URI;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/net/URI;",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/springframework/web/client/RestClientException;
        }
    .end annotation

    .prologue
    .line 247
    .local p2, "responseType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    new-instance v0, Lorg/springframework/web/client/RestTemplate$AcceptHeaderRequestCallback;

    const/4 v2, 0x0

    invoke-direct {v0, p0, p2, v2}, Lorg/springframework/web/client/RestTemplate$AcceptHeaderRequestCallback;-><init>(Lorg/springframework/web/client/RestTemplate;Ljava/lang/Class;Lorg/springframework/web/client/RestTemplate$1;)V

    .line 248
    .local v0, "requestCallback":Lorg/springframework/web/client/RestTemplate$AcceptHeaderRequestCallback;
    new-instance v1, Lorg/springframework/web/client/HttpMessageConverterExtractor;

    invoke-virtual {p0}, Lorg/springframework/web/client/RestTemplate;->getMessageConverters()Ljava/util/List;

    move-result-object v2

    invoke-direct {v1, p2, v2}, Lorg/springframework/web/client/HttpMessageConverterExtractor;-><init>(Ljava/lang/Class;Ljava/util/List;)V

    .line 250
    .local v1, "responseExtractor":Lorg/springframework/web/client/HttpMessageConverterExtractor;, "Lorg/springframework/web/client/HttpMessageConverterExtractor<TT;>;"
    sget-object v2, Lorg/springframework/http/HttpMethod;->GET:Lorg/springframework/http/HttpMethod;

    invoke-virtual {p0, p1, v2, v0, v1}, Lorg/springframework/web/client/RestTemplate;->execute(Ljava/net/URI;Lorg/springframework/http/HttpMethod;Lorg/springframework/web/client/RequestCallback;Lorg/springframework/web/client/ResponseExtractor;)Ljava/lang/Object;

    move-result-object v2

    return-object v2
.end method

.method public getMessageConverters()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lorg/springframework/http/converter/HttpMessageConverter",
            "<*>;>;"
        }
    .end annotation

    .prologue
    .line 215
    iget-object v0, p0, Lorg/springframework/web/client/RestTemplate;->messageConverters:Ljava/util/List;

    return-object v0
.end method
