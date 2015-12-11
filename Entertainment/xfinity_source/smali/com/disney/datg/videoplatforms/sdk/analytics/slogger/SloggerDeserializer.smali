.class public Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerDeserializer;
.super Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;
.source "SloggerDeserializer.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer",
        "<[B>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, [B

    invoke-direct {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;-><init>(Ljava/lang/Class;)V

    .line 19
    return-void
.end method

.method public constructor <init>(Lorg/springframework/http/converter/HttpMessageConverter;Ljava/lang/Class;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/springframework/http/converter/HttpMessageConverter",
            "<[B>;",
            "Ljava/lang/Class",
            "<[B>;)V"
        }
    .end annotation

    .prologue
    .line 22
    .local p1, "messageConverter":Lorg/springframework/http/converter/HttpMessageConverter;, "Lorg/springframework/http/converter/HttpMessageConverter<[B>;"
    .local p2, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<[B>;"
    invoke-direct {p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;-><init>(Lorg/springframework/http/converter/HttpMessageConverter;Ljava/lang/Class;)V

    .line 23
    return-void
.end method


# virtual methods
.method public executeAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
    .locals 1
    .param p2, "timeout"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<[B>;I",
            "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
            "<[B>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lorg/springframework/http/ResponseEntity",
            "<[B>;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .line 31
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<[B>;"
    .local p3, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;, "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler<[B>;"
    invoke-super {p0, p1, p2, p3}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->executeAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public getForObjectAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
    .locals 1
    .param p2, "timeout"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<[B>;I",
            "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
            "<[B>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lorg/springframework/http/ResponseEntity",
            "<[B>;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .line 36
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<[B>;"
    .local p3, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;, "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler<[B>;"
    invoke-super {p0, p1, p2, p3}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->getForObjectAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
