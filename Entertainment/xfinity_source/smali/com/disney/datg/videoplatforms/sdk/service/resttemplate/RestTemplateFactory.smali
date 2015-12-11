.class public Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateFactory;
.super Ljava/lang/Object;
.source "RestTemplateFactory.java"


# direct methods
.method public static createAsyncRestTemplate(Lorg/springframework/http/client/ClientHttpRequestFactory;Lorg/springframework/http/converter/HttpMessageConverter;)Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;
    .locals 2
    .param p0, "requestFactory"    # Lorg/springframework/http/client/ClientHttpRequestFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/springframework/http/client/ClientHttpRequestFactory;",
            "Lorg/springframework/http/converter/HttpMessageConverter",
            "<*>;)",
            "Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;"
        }
    .end annotation

    .prologue
    .line 20
    .local p1, "messageConverter":Lorg/springframework/http/converter/HttpMessageConverter;, "Lorg/springframework/http/converter/HttpMessageConverter<*>;"
    new-instance v0, Lorg/springframework/web/client/RestTemplate;

    invoke-direct {v0, p0}, Lorg/springframework/web/client/RestTemplate;-><init>(Lorg/springframework/http/client/ClientHttpRequestFactory;)V

    .line 21
    .local v0, "restTemplate":Lorg/springframework/web/client/RestTemplate;
    invoke-virtual {v0}, Lorg/springframework/web/client/RestTemplate;->getMessageConverters()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 22
    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;

    invoke-direct {v1, v0}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;-><init>(Lorg/springframework/web/client/RestTemplate;)V

    return-object v1
.end method
