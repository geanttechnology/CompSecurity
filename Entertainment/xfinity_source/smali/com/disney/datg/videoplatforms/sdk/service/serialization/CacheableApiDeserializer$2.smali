.class Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;
.super Ljava/lang/Object;
.source "CacheableApiDeserializer.java"

# interfaces
.implements Ljava/util/concurrent/Future;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->executeAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Future",
        "<",
        "Lorg/springframework/http/ResponseEntity",
        "<TT;>;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;

.field final synthetic val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

.field final synthetic val$dataResponse:Lorg/springframework/http/ResponseEntity;

.field final synthetic val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;Lcom/disney/datg/videoplatforms/sdk/service/Request;Lorg/springframework/http/ResponseEntity;)V
    .locals 0

    .prologue
    .line 130
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer.2;"
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;

    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    iput-object p3, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    iput-object p4, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;->val$dataResponse:Lorg/springframework/http/ResponseEntity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public cancel(Z)Z
    .locals 1
    .param p1, "mayInterruptIfRunning"    # Z

    .prologue
    .line 134
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer.2;"
    const/4 v0, 0x0

    return v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/ExecutionException;
        }
    .end annotation

    .prologue
    .line 130
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer.2;"
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;->get()Lorg/springframework/http/ResponseEntity;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # J
    .param p3, "x1"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/ExecutionException;,
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    .line 130
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer.2;"
    invoke-virtual {p0, p1, p2, p3}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;->get(JLjava/util/concurrent/TimeUnit;)Lorg/springframework/http/ResponseEntity;

    move-result-object v0

    return-object v0
.end method

.method public get()Lorg/springframework/http/ResponseEntity;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lorg/springframework/http/ResponseEntity",
            "<TT;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/ExecutionException;,
            Ljava/util/concurrent/RejectedExecutionException;
        }
    .end annotation

    .prologue
    .line 141
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer.2;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    if-eqz v0, :cond_0

    .line 142
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;->val$dataResponse:Lorg/springframework/http/ResponseEntity;

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onResponse(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lorg/springframework/http/ResponseEntity;)V

    .line 144
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;->val$dataResponse:Lorg/springframework/http/ResponseEntity;

    return-object v0
.end method

.method public get(JLjava/util/concurrent/TimeUnit;)Lorg/springframework/http/ResponseEntity;
    .locals 3
    .param p1, "timeout"    # J
    .param p3, "unit"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/concurrent/TimeUnit;",
            ")",
            "Lorg/springframework/http/ResponseEntity",
            "<TT;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/ExecutionException;,
            Ljava/util/concurrent/RejectedExecutionException;,
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    .line 151
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer.2;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    if-eqz v0, :cond_0

    .line 152
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;->val$dataResponse:Lorg/springframework/http/ResponseEntity;

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onResponse(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lorg/springframework/http/ResponseEntity;)V

    .line 154
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;->val$dataResponse:Lorg/springframework/http/ResponseEntity;

    return-object v0
.end method

.method public isCancelled()Z
    .locals 1

    .prologue
    .line 159
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer.2;"
    const/4 v0, 0x0

    return v0
.end method

.method public isDone()Z
    .locals 1

    .prologue
    .line 164
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer.2;"
    const/4 v0, 0x0

    return v0
.end method
