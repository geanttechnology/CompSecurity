.class public interface abstract Lcom/amazon/mShop/util/mediator/Mediator;
.super Ljava/lang/Object;
.source "Mediator.java"


# virtual methods
.method public abstract addDependency(Lcom/amazon/mShop/util/mediator/Task;Ljava/lang/String;)V
.end method

.method public abstract onFailed(Ljava/lang/String;)V
.end method

.method public abstract onReady(Ljava/lang/String;)V
.end method

.method public abstract register(Lcom/amazon/mShop/util/mediator/Task;)V
.end method
