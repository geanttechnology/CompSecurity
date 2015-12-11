.class public interface abstract Lcom/amazon/mcc/nps/broker/dispatch/MessageDispatcher;
.super Ljava/lang/Object;
.source "MessageDispatcher.java"


# virtual methods
.method public abstract notifyObservers(Ljava/util/List;Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Message;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mcc/nps/Observer;",
            ">;",
            "Lcom/amazon/mcc/nps/Topic;",
            "Lcom/amazon/mcc/nps/Message;",
            ")V"
        }
    .end annotation
.end method
