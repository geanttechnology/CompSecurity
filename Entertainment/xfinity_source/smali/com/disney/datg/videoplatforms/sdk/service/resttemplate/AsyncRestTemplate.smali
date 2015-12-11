.class public Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;
.super Ljava/lang/Object;
.source "AsyncRestTemplate.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$35;
    }
.end annotation


# static fields
.field private static TAG:Ljava/lang/String;


# instance fields
.field private restTemplate:Lorg/springframework/web/client/RestTemplate;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const-string v0, "AsyncRestTemplate"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lorg/springframework/web/client/RestTemplate;)V
    .locals 0
    .param p1, "restTemplate"    # Lorg/springframework/web/client/RestTemplate;

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;->restTemplate:Lorg/springframework/web/client/RestTemplate;

    .line 48
    return-void
.end method

.method static synthetic access$000(Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;)Lorg/springframework/web/client/RestTemplate;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;->restTemplate:Lorg/springframework/web/client/RestTemplate;

    return-object v0
.end method


# virtual methods
.method public exchange(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<TT;>;",
            "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
            "<TT;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lorg/springframework/http/ResponseEntity",
            "<TT;>;>;"
        }
    .end annotation

    .prologue
    .line 341
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<TT;>;"
    .local p2, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;, "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler<TT;>;"
    if-eqz p2, :cond_0

    .line 342
    invoke-interface {p2, p1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onRequest(Lcom/disney/datg/videoplatforms/sdk/service/Request;)V

    .line 345
    :cond_0
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->getManager()Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;

    invoke-direct {v1, p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$31;-><init>(Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;Lcom/disney/datg/videoplatforms/sdk/service/Request;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->execute(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method protected finalize()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 408
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 409
    return-void
.end method

.method public getForObject(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<TT;>;",
            "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
            "<TT;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lorg/springframework/http/ResponseEntity",
            "<TT;>;>;"
        }
    .end annotation

    .prologue
    .line 69
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<TT;>;"
    .local p2, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;, "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler<TT;>;"
    if-eqz p2, :cond_0

    .line 70
    invoke-interface {p2, p1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onRequest(Lcom/disney/datg/videoplatforms/sdk/service/Request;)V

    .line 73
    :cond_0
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->getManager()Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;

    invoke-direct {v1, p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate$3;-><init>(Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/AsyncRestTemplate;Lcom/disney/datg/videoplatforms/sdk/service/Request;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->execute(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
