.class public interface abstract Lcom/amazon/mcc/nps/broker/container/ObserverContainer;
.super Ljava/lang/Object;
.source "ObserverContainer.java"


# virtual methods
.method public abstract addObserverForTopic(Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Observer;Lcom/amazon/mcc/nps/ObserverProperties;)Z
.end method

.method public abstract getObserversForTopic(Lcom/amazon/mcc/nps/Topic;)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mcc/nps/Topic;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mcc/nps/Observer;",
            ">;"
        }
    .end annotation
.end method

.method public abstract removeObserverForTopic(Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Observer;)Z
.end method
