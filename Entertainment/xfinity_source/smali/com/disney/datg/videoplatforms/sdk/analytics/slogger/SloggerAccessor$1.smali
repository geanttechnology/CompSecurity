.class Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor$1;
.super Ljava/lang/Object;
.source "SloggerAccessor.java"

# interfaces
.implements Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getServiceAsync()Ljava/util/concurrent/Future;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
        "<[B>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

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
            "<[B>;",
            "Ljava/lang/Exception;",
            ")V"
        }
    .end annotation

    .prologue
    .line 83
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<[B>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    # invokes: Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->access$500(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 84
    instance-of v0, p2, Lorg/springframework/web/client/HttpStatusCodeException;

    if-eqz v0, :cond_1

    .line 85
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    # invokes: Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->access$600(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SLOGGER_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    invoke-interface {v0, p1, v1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    .line 98
    :cond_0
    :goto_0
    return-void

    .line 86
    :cond_1
    instance-of v0, p2, Lorg/springframework/web/client/ResourceAccessException;

    if-eqz v0, :cond_3

    .line 88
    invoke-virtual {p2}, Ljava/lang/Exception;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    instance-of v0, v0, Ljava/net/SocketTimeoutException;

    if-eqz v0, :cond_2

    .line 89
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    # invokes: Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->access$700(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SLOGGER_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    invoke-interface {v0, p1, v1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_0

    .line 91
    :cond_2
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    # invokes: Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->access$800(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SLOGGER_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    invoke-interface {v0, p1, v1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_0

    .line 95
    :cond_3
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    # invokes: Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->access$900(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

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
            "<[B>;)V"
        }
    .end annotation

    .prologue
    .line 75
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<[B>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    # invokes: Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->access$300(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 76
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    # invokes: Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->access$400(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onRequest(Lcom/disney/datg/videoplatforms/sdk/service/Request;)V

    .line 78
    :cond_0
    return-void
.end method

.method public onResponse(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lorg/springframework/http/ResponseEntity;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<[B>;",
            "Lorg/springframework/http/ResponseEntity",
            "<[B>;)V"
        }
    .end annotation

    .prologue
    .line 63
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<[B>;"
    .local p2, "response":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<[B>;"
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    # invokes: Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    invoke-static {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->access$000(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 64
    invoke-virtual {p2}, Lorg/springframework/http/ResponseEntity;->getStatusCode()Lorg/springframework/http/HttpStatus;

    move-result-object v0

    .line 65
    .local v0, "statusCode":Lorg/springframework/http/HttpStatus;
    sget-object v1, Lorg/springframework/http/HttpStatus;->CREATED:Lorg/springframework/http/HttpStatus;

    if-ne v0, v1, :cond_1

    .line 66
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    # invokes: Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    invoke-static {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->access$100(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v1

    invoke-interface {v1, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onResponse(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lorg/springframework/http/ResponseEntity;)V

    .line 71
    .end local v0    # "statusCode":Lorg/springframework/http/HttpStatus;
    :cond_0
    :goto_0
    return-void

    .line 67
    .restart local v0    # "statusCode":Lorg/springframework/http/HttpStatus;
    :cond_1
    sget-object v1, Lorg/springframework/http/HttpStatus;->NOT_FOUND:Lorg/springframework/http/HttpStatus;

    if-ne v0, v1, :cond_0

    .line 68
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    # invokes: Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    invoke-static {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->access$200(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v1

    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SLOGGER_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    invoke-interface {v1, p1, v2}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    goto :goto_0
.end method
