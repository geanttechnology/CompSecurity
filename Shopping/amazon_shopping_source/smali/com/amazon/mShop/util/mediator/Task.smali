.class public interface abstract Lcom/amazon/mShop/util/mediator/Task;
.super Ljava/lang/Object;
.source "Task.java"


# virtual methods
.method public abstract end(Ljava/lang/String;)V
.end method

.method public abstract getId()Ljava/lang/String;
.end method

.method public abstract getInputDependency()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public abstract removeInputDependency(Ljava/lang/String;)V
.end method

.method public abstract start()V
.end method
