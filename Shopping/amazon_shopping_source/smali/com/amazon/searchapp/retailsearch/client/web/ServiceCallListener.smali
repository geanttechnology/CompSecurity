.class public interface abstract Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;
.super Ljava/lang/Object;
.source "ServiceCallListener.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<TResult:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract endRequest()V
.end method

.method public abstract error(Ljava/lang/Exception;)V
.end method

.method public abstract result(Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TTResult;)V"
        }
    .end annotation
.end method

.method public abstract startRequest()V
.end method
