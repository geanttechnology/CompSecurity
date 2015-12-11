.class public interface abstract Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
.super Ljava/lang/Object;
.source "HttpRequestHandler.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<TT;>;",
            "Ljava/lang/Exception;",
            ")V"
        }
    .end annotation
.end method

.method public abstract onRequest(Lcom/disney/datg/videoplatforms/sdk/service/Request;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<TT;>;)V"
        }
    .end annotation
.end method

.method public abstract onResponse(Lcom/disney/datg/videoplatforms/sdk/service/Request;Lorg/springframework/http/ResponseEntity;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<TT;>;",
            "Lorg/springframework/http/ResponseEntity",
            "<TT;>;)V"
        }
    .end annotation
.end method
