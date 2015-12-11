.class public interface abstract Lcom/disney/datg/videoplatforms/sdk/service/Request;
.super Ljava/lang/Object;
.source "Request.java"


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
.method public abstract addHeader(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract getHttpMethod()Lorg/springframework/http/HttpMethod;
.end method

.method public abstract getResponseType()Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<TT;>;"
        }
    .end annotation
.end method

.method public abstract getServiceUri()Ljava/net/URI;
.end method

.method public abstract setHeaders(Lorg/springframework/http/HttpHeaders;)V
.end method
