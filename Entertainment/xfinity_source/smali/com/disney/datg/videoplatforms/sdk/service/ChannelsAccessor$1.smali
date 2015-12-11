.class Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor$1;
.super Ljava/lang/Object;
.source "ChannelsAccessor.java"

# interfaces
.implements Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getServiceAsync()Ljava/util/concurrent/Future;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;)V
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V
    .locals 3
    .param p2, "e"    # Ljava/lang/Exception;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;",
            ">;",
            "Ljava/lang/Exception;",
            ")V"
        }
    .end annotation

    .prologue
    .line 78
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 79
    instance-of v0, p2, Lorg/springframework/web/client/HttpStatusCodeException;

    if-eqz v0, :cond_1

    .line 80
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CHANNELS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    invoke-interface {v0, p1, v1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    .line 93
    :cond_0
    :goto_0
    return-void

    .line 81
    :cond_1
    instance-of v0, p2, Lorg/springframework/web/client/ResourceAccessException;

    if-eqz v0, :cond_3

    .line 83
    invoke-virtual {p2}, Ljava/lang/Exception;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    instance-of v0, v0, Ljava/net/SocketTimeoutException;

    if-eqz v0, :cond_2

    .line 84
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CHANNELS_SERVICE_TIMEOUT:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    invoke-interface {v0, p1, v1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_0

    .line 86
    :cond_2
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CHANNELS_SERVICE_IO_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    invoke-interface {v0, p1, v1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_0

    .line 90
    :cond_3
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method public onRequest(Lcom/disney/datg/videoplatforms/sdk/service/Request;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 70
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 71
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onRequest(Lcom/disney/datg/videoplatforms/sdk/service/Request;)V

    .line 73
    :cond_0
    return-void
.end method

.method public onResponse(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lorg/springframework/http/ResponseEntity;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;",
            ">;",
            "Lorg/springframework/http/ResponseEntity",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 51
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;"
    .local p2, "response":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;"
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 52
    invoke-virtual {p2}, Lorg/springframework/http/ResponseEntity;->hasBody()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 54
    invoke-virtual {p2}, Lorg/springframework/http/ResponseEntity;->getBody()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;

    .line 55
    .local v0, "channels":Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;->getChannel()Ljava/util/ArrayList;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 56
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v1

    invoke-interface {v1, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onResponse(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lorg/springframework/http/ResponseEntity;)V

    .line 66
    .end local v0    # "channels":Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;
    :cond_0
    :goto_0
    return-void

    .line 58
    .restart local v0    # "channels":Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;
    :cond_1
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v1

    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CHANNELS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    invoke-interface {v1, p1, v2}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_0

    .line 62
    .end local v0    # "channels":Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;
    :cond_2
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v1

    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CHANNELS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    invoke-interface {v1, p1, v2}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_0
.end method
