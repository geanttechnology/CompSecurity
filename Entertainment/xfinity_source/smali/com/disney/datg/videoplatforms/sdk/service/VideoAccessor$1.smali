.class Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor$1;
.super Ljava/lang/Object;
.source "VideoAccessor.java"

# interfaces
.implements Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getServiceAsync()Ljava/util/concurrent/Future;
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
        "Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;

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
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;",
            ">;",
            "Ljava/lang/Exception;",
            ")V"
        }
    .end annotation

    .prologue
    .line 69
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 70
    instance-of v0, p2, Lorg/springframework/web/client/HttpStatusCodeException;

    if-eqz v0, :cond_1

    .line 71
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    invoke-interface {v0, p1, v1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    .line 84
    :cond_0
    :goto_0
    return-void

    .line 72
    :cond_1
    instance-of v0, p2, Lorg/springframework/web/client/ResourceAccessException;

    if-eqz v0, :cond_3

    .line 74
    invoke-virtual {p2}, Ljava/lang/Exception;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    instance-of v0, v0, Ljava/net/SocketTimeoutException;

    if-eqz v0, :cond_2

    .line 75
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_TIMEOUT:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    invoke-interface {v0, p1, v1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_0

    .line 77
    :cond_2
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_IO_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    invoke-interface {v0, p1, v1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_0

    .line 81
    :cond_3
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

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
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 61
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 62
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onRequest(Lcom/disney/datg/videoplatforms/sdk/service/Request;)V

    .line 63
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
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;",
            ">;",
            "Lorg/springframework/http/ResponseEntity",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 42
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;"
    .local p2, "response":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;"
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 43
    invoke-virtual {p2}, Lorg/springframework/http/ResponseEntity;->hasBody()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 45
    invoke-virtual {p2}, Lorg/springframework/http/ResponseEntity;->getBody()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;

    .line 46
    .local v0, "videos":Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;->getVideo()Ljava/util/ArrayList;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;->getVideo()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_1

    .line 47
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v1

    invoke-interface {v1, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onResponse(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lorg/springframework/http/ResponseEntity;)V

    .line 56
    .end local v0    # "videos":Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;
    :cond_0
    :goto_0
    return-void

    .line 49
    .restart local v0    # "videos":Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;
    :cond_1
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v1

    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    invoke-interface {v1, p1, v2}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_0

    .line 53
    .end local v0    # "videos":Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;
    :cond_2
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v1

    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    invoke-interface {v1, p1, v2}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_0
.end method
