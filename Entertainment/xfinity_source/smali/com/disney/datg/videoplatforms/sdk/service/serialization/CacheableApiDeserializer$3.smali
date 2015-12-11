.class Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;
.super Ljava/lang/Object;
.source "CacheableApiDeserializer.java"

# interfaces
.implements Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;


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
        "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
        "<TT;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;

.field final synthetic val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

.field final synthetic val$key:Ljava/lang/Object;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;Ljava/lang/Object;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V
    .locals 0

    .prologue
    .line 175
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer.3;"
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;

    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;->val$key:Ljava/lang/Object;

    iput-object p3, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V
    .locals 1
    .param p2, "e"    # Ljava/lang/Exception;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<TT;>;",
            "Ljava/lang/Exception;",
            ")V"
        }
    .end annotation

    .prologue
    .line 199
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer.3;"
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<TT;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    if-eqz v0, :cond_0

    .line 200
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    invoke-interface {v0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    .line 202
    :cond_0
    return-void
.end method

.method public onRequest(Lcom/disney/datg/videoplatforms/sdk/service/Request;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 191
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer.3;"
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<TT;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    if-eqz v0, :cond_0

    .line 192
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    invoke-interface {v0, p1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onRequest(Lcom/disney/datg/videoplatforms/sdk/service/Request;)V

    .line 194
    :cond_0
    return-void
.end method

.method public onResponse(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lorg/springframework/http/ResponseEntity;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<TT;>;",
            "Lorg/springframework/http/ResponseEntity",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 180
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer.3;"
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<TT;>;"
    .local p2, "res":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->cache:Lcom/disney/datg/videoplatforms/sdk/cache/Cache;

    if-eqz v0, :cond_0

    .line 181
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->cache:Lcom/disney/datg/videoplatforms/sdk/cache/Cache;

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;->val$key:Ljava/lang/Object;

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;

    iget v2, v2, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->timeToLive:I

    invoke-virtual {v0, v1, p2, v2}, Lcom/disney/datg/videoplatforms/sdk/cache/Cache;->put(Ljava/lang/Object;Ljava/lang/Object;I)V

    .line 183
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    if-eqz v0, :cond_1

    .line 184
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    invoke-interface {v0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onResponse(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lorg/springframework/http/ResponseEntity;)V

    .line 187
    :cond_1
    return-void
.end method
