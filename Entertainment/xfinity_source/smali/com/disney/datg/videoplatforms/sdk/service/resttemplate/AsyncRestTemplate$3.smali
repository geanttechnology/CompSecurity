.class Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;
.super Ljava/lang/Object;
.source "AsyncRestTemplate.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;->getForObject(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
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
    .line 73
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;

    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    iput-object p3, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

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
    .line 73
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;->call()Lorg/springframework/http/ResponseEntity;

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
    .line 75
    const/4 v2, 0x0

    .line 78
    .local v2, "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    :try_start_0
    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$35;->$SwitchMap$org$springframework$http$HttpMethod:[I

    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    invoke-interface {v5}, Lcom/disney/datg/videoplatforms/sdk/service/Request;->getHttpMethod()Lorg/springframework/http/HttpMethod;

    move-result-object v5

    invoke-virtual {v5}, Lorg/springframework/http/HttpMethod;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    .line 86
    :goto_0
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;->restTemplate:Lorg/springframework/web/client/RestTemplate;
    invoke-static {v4}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;->access$000(Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;)Lorg/springframework/web/client/RestTemplate;

    move-result-object v4

    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    invoke-interface {v5}, Lcom/disney/datg/videoplatforms/sdk/service/Request;->getServiceUri()Ljava/net/URI;

    move-result-object v5

    const-class v6, [B

    invoke-virtual {v4, v5, v6}, Lorg/springframework/web/client/RestTemplate;->getForObject(Ljava/net/URI;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [B

    .line 88
    .local v1, "response":[B
    if-eqz v1, :cond_0

    array-length v4, v1

    if-lez v4, :cond_0

    .line 89
    new-instance v3, Lorg/springframework/http/ResponseEntity;

    sget-object v4, Lorg/springframework/http/HttpStatus;->OK:Lorg/springframework/http/HttpStatus;

    invoke-direct {v3, v1, v4}, Lorg/springframework/http/ResponseEntity;-><init>(Ljava/lang/Object;Lorg/springframework/http/HttpStatus;)V
    :try_end_0
    .catch Lorg/springframework/web/client/HttpStatusCodeException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/springframework/web/client/ResourceAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lorg/springframework/web/client/RestClientException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3

    .line 90
    .end local v2    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    .local v3, "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    :try_start_1
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    invoke-interface {v4, v5, v3}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onResponse(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lorg/springframework/http/ResponseEntity;)V
    :try_end_1
    .catch Lorg/springframework/web/client/HttpStatusCodeException; {:try_start_1 .. :try_end_1} :catch_7
    .catch Lorg/springframework/web/client/ResourceAccessException; {:try_start_1 .. :try_end_1} :catch_6
    .catch Lorg/springframework/web/client/RestClientException; {:try_start_1 .. :try_end_1} :catch_5
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_4

    move-object v2, v3

    .line 101
    .end local v1    # "response":[B
    .end local v3    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    .restart local v2    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    :cond_0
    :goto_1
    return-object v2

    .line 80
    :pswitch_0
    :try_start_2
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;->restTemplate:Lorg/springframework/web/client/RestTemplate;
    invoke-static {v4}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;->access$000(Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;)Lorg/springframework/web/client/RestTemplate;

    move-result-object v4

    invoke-virtual {v4}, Lorg/springframework/web/client/RestTemplate;->getMessageConverters()Ljava/util/List;

    move-result-object v4

    new-instance v5, Lorg/springframework/http/converter/FormHttpMessageConverter;

    invoke-direct {v5}, Lorg/springframework/http/converter/FormHttpMessageConverter;-><init>()V

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Lorg/springframework/web/client/HttpStatusCodeException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Lorg/springframework/web/client/ResourceAccessException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Lorg/springframework/web/client/RestClientException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_3

    goto :goto_0

    .line 92
    :catch_0
    move-exception v0

    .line 93
    .local v0, "e":Lorg/springframework/web/client/HttpStatusCodeException;
    :goto_2
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    invoke-interface {v4, v5, v0}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_1

    .line 94
    .end local v0    # "e":Lorg/springframework/web/client/HttpStatusCodeException;
    :catch_1
    move-exception v0

    .line 95
    .local v0, "e":Lorg/springframework/web/client/ResourceAccessException;
    :goto_3
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    invoke-interface {v4, v5, v0}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_1

    .line 96
    .end local v0    # "e":Lorg/springframework/web/client/ResourceAccessException;
    :catch_2
    move-exception v0

    .line 97
    .local v0, "e":Lorg/springframework/web/client/RestClientException;
    :goto_4
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    invoke-interface {v4, v5, v0}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_1

    .line 98
    .end local v0    # "e":Lorg/springframework/web/client/RestClientException;
    :catch_3
    move-exception v0

    .line 99
    .local v0, "e":Ljava/lang/Exception;
    :goto_5
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 98
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v2    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    .restart local v1    # "response":[B
    .restart local v3    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    :catch_4
    move-exception v0

    move-object v2, v3

    .end local v3    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    .restart local v2    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    goto :goto_5

    .line 96
    .end local v2    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    .restart local v3    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    :catch_5
    move-exception v0

    move-object v2, v3

    .end local v3    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    .restart local v2    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    goto :goto_4

    .line 94
    .end local v2    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    .restart local v3    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    :catch_6
    move-exception v0

    move-object v2, v3

    .end local v3    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    .restart local v2    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    goto :goto_3

    .line 92
    .end local v2    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    .restart local v3    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    :catch_7
    move-exception v0

    move-object v2, v3

    .end local v3    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    .restart local v2    # "responseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    goto :goto_2

    .line 78
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
