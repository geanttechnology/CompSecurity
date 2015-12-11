.class public interface abstract Ltv/freewheel/utils/http/ISimpleHttpClient;
.super Ljava/lang/Object;
.source "ISimpleHttpClient.java"

# interfaces
.implements Lorg/apache/http/client/HttpClient;


# virtual methods
.method public abstract close()V
.end method

.method public abstract removeRequestInterceptorByClass(Ljava/lang/Class;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<",
            "Lorg/apache/http/client/protocol/RequestAddCookies;",
            ">;)V"
        }
    .end annotation
.end method
