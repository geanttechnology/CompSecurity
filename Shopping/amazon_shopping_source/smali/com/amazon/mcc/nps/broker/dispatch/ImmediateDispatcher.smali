.class public Lcom/amazon/mcc/nps/broker/dispatch/ImmediateDispatcher;
.super Ljava/lang/Object;
.source "ImmediateDispatcher.java"

# interfaces
.implements Lcom/amazon/mcc/nps/broker/dispatch/MessageDispatcher;


# instance fields
.field private final log:Lcom/amazon/logging/Logger;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    const-class v0, Lcom/amazon/mcc/nps/broker/dispatch/ImmediateDispatcher;

    invoke-static {v0}, Lcom/amazon/logging/Logger;->getLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mcc/nps/broker/dispatch/ImmediateDispatcher;->log:Lcom/amazon/logging/Logger;

    return-void
.end method


# virtual methods
.method public notifyObservers(Ljava/util/List;Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Message;)V
    .locals 5
    .param p2, "topic"    # Lcom/amazon/mcc/nps/Topic;
    .param p3, "message"    # Lcom/amazon/mcc/nps/Message;
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

    .prologue
    .line 34
    .local p1, "observers":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mcc/nps/Observer;>;"
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    if-nez v2, :cond_2

    .line 35
    :cond_0
    iget-object v2, p0, Lcom/amazon/mcc/nps/broker/dispatch/ImmediateDispatcher;->log:Lcom/amazon/logging/Logger;

    const-string/jumbo v3, "Attempted to dispatch message to empty observers"

    invoke-virtual {v2, v3}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    .line 44
    :cond_1
    return-void

    .line 39
    :cond_2
    iget-object v2, p0, Lcom/amazon/mcc/nps/broker/dispatch/ImmediateDispatcher;->log:Lcom/amazon/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Immediately dispatching: T: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p2}, Lcom/amazon/mcc/nps/Topic;->getIdentifier()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " M: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    .line 41
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mcc/nps/Observer;

    .line 42
    .local v1, "observer":Lcom/amazon/mcc/nps/Observer;
    invoke-interface {v1, p2, p3}, Lcom/amazon/mcc/nps/Observer;->onUpdate(Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Message;)V

    goto :goto_0
.end method
