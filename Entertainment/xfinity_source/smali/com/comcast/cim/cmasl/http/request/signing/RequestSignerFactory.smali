.class public interface abstract Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;
.super Ljava/lang/Object;
.source "RequestSignerFactory.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation
.end method
