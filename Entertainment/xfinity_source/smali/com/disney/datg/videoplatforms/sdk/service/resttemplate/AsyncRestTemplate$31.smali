.class Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;
.super Ljava/lang/Object;
.source "AsyncRestTemplate.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;->exchange(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Lorg/springframework/http/ResponseEntity",
        "<TT;>;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;

.field final synthetic val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

.field final synthetic val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;Lcom/disney/datg/videoplatforms/sdk/service/Request;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V
    .locals 0

    .prologue
    .line 345
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;

    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    iput-object p3, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 345
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->call()Lorg/springframework/http/ResponseEntity;

    move-result-object v0

    return-object v0
.end method

.method public call()Lorg/springframework/http/ResponseEntity;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lorg/springframework/http/ResponseEntity",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 347
    const/4 v1, 0x0

    .line 350
    .local v1, "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    :try_start_0
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$35;->$SwitchMap$org$springframework$http$HttpMethod:[I

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    invoke-interface {v3}, Lcom/disney/datg/videoplatforms/sdk/service/Request;->getHttpMethod()Lorg/springframework/http/HttpMethod;

    move-result-object v3

    invoke-virtual {v3}, Lorg/springframework/http/HttpMethod;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 358
    :goto_0
    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;->restTemplate:Lorg/springframework/web/client/RestTemplate;
    invoke-static {v2}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;->access$000(Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;)Lorg/springframework/web/client/RestTemplate;

    move-result-object v3

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    invoke-interface {v2}, Lcom/disney/datg/videoplatforms/sdk/service/Request;->getServiceUri()Ljava/net/URI;

    move-result-object v4

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    invoke-interface {v2}, Lcom/disney/datg/videoplatforms/sdk/service/Request;->getHttpMethod()Lorg/springframework/http/HttpMethod;

    move-result-object v5

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    check-cast v2, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->createHttpEntity()Lorg/springframework/http/HttpEntity;

    move-result-object v2

    iget-object v6, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    invoke-interface {v6}, Lcom/disney/datg/videoplatforms/sdk/service/Request;->getResponseType()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v3, v4, v5, v2, v6}, Lorg/springframework/web/client/RestTemplate;->exchange(Ljava/net/URI;Lorg/springframework/http/HttpMethod;Lorg/springframework/http/HttpEntity;Ljava/lang/Class;)Lorg/springframework/http/ResponseEntity;

    move-result-object v1

    .line 359
    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    invoke-interface {v2, v3, v1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onResponse(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lorg/springframework/http/ResponseEntity;)V

    .line 369
    :goto_1
    return-object v1

    .line 352
    :pswitch_0
    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;->restTemplate:Lorg/springframework/web/client/RestTemplate;
    invoke-static {v2}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;->access$000(Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;)Lorg/springframework/web/client/RestTemplate;

    move-result-object v2

    invoke-virtual {v2}, Lorg/springframework/web/client/RestTemplate;->getMessageConverters()Ljava/util/List;

    move-result-object v2

    new-instance v3, Lorg/springframework/http/converter/FormHttpMessageConverter;

    invoke-direct {v3}, Lorg/springframework/http/converter/FormHttpMessageConverter;-><init>()V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/springframework/web/client/HttpStatusCodeException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/springframework/web/client/ResourceAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lorg/springframework/web/client/RestClientException; {:try_start_0 .. :try_end_0} :catch_2

    goto :goto_0

    .line 361
    :catch_0
    move-exception v0

    .line 362
    .local v0, "e":Lorg/springframework/web/client/HttpStatusCodeException;
    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    invoke-interface {v2, v3, v0}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_1

    .line 363
    .end local v0    # "e":Lorg/springframework/web/client/HttpStatusCodeException;
    :catch_1
    move-exception v0

    .line 364
    .local v0, "e":Lorg/springframework/web/client/ResourceAccessException;
    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    invoke-interface {v2, v3, v0}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_1

    .line 365
    .end local v0    # "e":Lorg/springframework/web/client/ResourceAccessException;
    :catch_2
    move-exception v0

    .line 366
    .local v0, "e":Lorg/springframework/web/client/RestClientException;
    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    invoke-interface {v2, v3, v0}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_1

    .line 350
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
