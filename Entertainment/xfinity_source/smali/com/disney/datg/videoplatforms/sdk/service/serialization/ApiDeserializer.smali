.class public abstract Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;
.super Ljava/lang/Object;
.source "ApiDeserializer.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field protected final clazz:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TT;>;"
        }
    .end annotation
.end field

.field protected errorHandler:Lorg/springframework/web/client/ResponseErrorHandler;

.field protected messageConverter:Lorg/springframework/http/converter/HttpMessageConverter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/springframework/http/converter/HttpMessageConverter",
            "<*>;"
        }
    .end annotation
.end field

.field protected requestFactory:Lorg/springframework/http/client/HttpComponentsClientHttpRequestFactory;


# direct methods
.method public constructor <init>(Ljava/lang/Class;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 35
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer<TT;>;"
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;

    invoke-direct {v0}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->requestFactory:Lorg/springframework/http/client/HttpComponentsClientHttpRequestFactory;

    .line 37
    new-instance v0, Lorg/springframework/web/client/DefaultResponseErrorHandler;

    invoke-direct {v0}, Lorg/springframework/web/client/DefaultResponseErrorHandler;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->errorHandler:Lorg/springframework/web/client/ResponseErrorHandler;

    .line 38
    new-instance v0, Lorg/springframework/http/converter/xml/SimpleXmlHttpMessageConverter;

    invoke-direct {v0}, Lorg/springframework/http/converter/xml/SimpleXmlHttpMessageConverter;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->messageConverter:Lorg/springframework/http/converter/HttpMessageConverter;

    .line 39
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->clazz:Ljava/lang/Class;

    .line 40
    return-void
.end method

.method public constructor <init>(Lorg/springframework/http/converter/HttpMessageConverter;Ljava/lang/Class;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/springframework/http/converter/HttpMessageConverter",
            "<TT;>;",
            "Ljava/lang/Class",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 49
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer<TT;>;"
    .local p1, "messageConverter":Lorg/springframework/http/converter/HttpMessageConverter;, "Lorg/springframework/http/converter/HttpMessageConverter<TT;>;"
    .local p2, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;

    invoke-direct {v0}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->requestFactory:Lorg/springframework/http/client/HttpComponentsClientHttpRequestFactory;

    .line 51
    new-instance v0, Lorg/springframework/web/client/DefaultResponseErrorHandler;

    invoke-direct {v0}, Lorg/springframework/web/client/DefaultResponseErrorHandler;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->errorHandler:Lorg/springframework/web/client/ResponseErrorHandler;

    .line 52
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->messageConverter:Lorg/springframework/http/converter/HttpMessageConverter;

    .line 53
    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->clazz:Ljava/lang/Class;

    .line 54
    return-void
.end method


# virtual methods
.method public executeAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
    .locals 3
    .param p2, "timeout"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<TT;>;I",
            "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
            "<TT;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lorg/springframework/http/ResponseEntity",
            "<TT;>;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .line 72
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer<TT;>;"
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<TT;>;"
    .local p3, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;, "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler<TT;>;"
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/service/Request;->getServiceUri()Ljava/net/URI;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/service/Request;->getServiceUri()Ljava/net/URI;

    move-result-object v1

    invoke-virtual {v1}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 74
    :cond_0
    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SERVICE_UNDEFINED_HOST:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    throw v1

    .line 77
    :cond_1
    const/4 v1, -0x1

    if-eq p2, v1, :cond_2

    .line 78
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->requestFactory:Lorg/springframework/http/client/HttpComponentsClientHttpRequestFactory;

    invoke-virtual {v1, p2}, Lorg/springframework/http/client/HttpComponentsClientHttpRequestFactory;->setReadTimeout(I)V

    .line 81
    :cond_2
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->requestFactory:Lorg/springframework/http/client/HttpComponentsClientHttpRequestFactory;

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->messageConverter:Lorg/springframework/http/converter/HttpMessageConverter;

    invoke-static {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateFactory;->createAsyncRestTemplate(Lorg/springframework/http/client/ClientHttpRequestFactory;Lorg/springframework/http/converter/HttpMessageConverter;)Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;

    move-result-object v0

    .line 82
    .local v0, "asyncTemplate":Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;
    invoke-virtual {v0, p1, p3}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;->exchange(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;

    move-result-object v1

    return-object v1
.end method

.method public getForObjectAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
    .locals 3
    .param p2, "timeout"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<TT;>;I",
            "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
            "<TT;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lorg/springframework/http/ResponseEntity",
            "<TT;>;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .line 109
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer<TT;>;"
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<TT;>;"
    .local p3, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;, "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler<TT;>;"
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/service/Request;->getServiceUri()Ljava/net/URI;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/service/Request;->getServiceUri()Ljava/net/URI;

    move-result-object v1

    invoke-virtual {v1}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 111
    :cond_0
    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SERVICE_UNDEFINED_HOST:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    throw v1

    .line 114
    :cond_1
    const/4 v1, -0x1

    if-eq p2, v1, :cond_2

    .line 115
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->requestFactory:Lorg/springframework/http/client/HttpComponentsClientHttpRequestFactory;

    invoke-virtual {v1, p2}, Lorg/springframework/http/client/HttpComponentsClientHttpRequestFactory;->setReadTimeout(I)V

    .line 118
    :cond_2
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->requestFactory:Lorg/springframework/http/client/HttpComponentsClientHttpRequestFactory;

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->messageConverter:Lorg/springframework/http/converter/HttpMessageConverter;

    invoke-static {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateFactory;->createAsyncRestTemplate(Lorg/springframework/http/client/ClientHttpRequestFactory;Lorg/springframework/http/converter/HttpMessageConverter;)Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;

    move-result-object v0

    .line 120
    .local v0, "asyncTemplate":Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;
    invoke-virtual {v0, p1, p3}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;->getForObject(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;

    move-result-object v1

    return-object v1
.end method
