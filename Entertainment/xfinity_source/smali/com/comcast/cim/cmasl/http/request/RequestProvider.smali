.class public interface abstract Lcom/comcast/cim/cmasl/http/request/RequestProvider;
.super Ljava/lang/Object;
.source "RequestProvider.java"


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

.method public abstract addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract createRequest()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation
.end method

.method public abstract setSocketTimeout(J)V
.end method
