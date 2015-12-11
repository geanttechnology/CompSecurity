.class public interface abstract Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;
.super Ljava/lang/Object;
.source "RequestProviderFactory.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Lcom/comcast/cim/cmasl/http/request/RequestProvider;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation
.end method

.method public abstract create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation
.end method
