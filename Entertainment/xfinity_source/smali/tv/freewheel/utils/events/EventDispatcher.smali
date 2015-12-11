.class public Ltv/freewheel/utils/events/EventDispatcher;
.super Ljava/lang/Object;
.source "EventDispatcher.java"


# instance fields
.field protected _listenersMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/interfaces/IEventListener;",
            ">;>;"
        }
    .end annotation
.end field

.field private logger:Ltv/freewheel/utils/Logger;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    const/4 v0, 0x1

    invoke-static {p0, v0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;Z)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/utils/events/EventDispatcher;->logger:Ltv/freewheel/utils/Logger;

    .line 24
    invoke-virtual {p0}, Ltv/freewheel/utils/events/EventDispatcher;->removeAllListeners()V

    .line 25
    return-void
.end method


# virtual methods
.method public addEventListener(Ljava/lang/String;Ltv/freewheel/ad/interfaces/IEventListener;)V
    .locals 4
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "listener"    # Ltv/freewheel/ad/interfaces/IEventListener;

    .prologue
    .line 28
    iget-object v1, p0, Ltv/freewheel/utils/events/EventDispatcher;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "addEventListener(type="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", listener="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 29
    if-nez p2, :cond_0

    .line 39
    :goto_0
    return-void

    .line 31
    :cond_0
    invoke-virtual {p0, p1, p2}, Ltv/freewheel/utils/events/EventDispatcher;->removeEventListener(Ljava/lang/String;Ltv/freewheel/ad/interfaces/IEventListener;)V

    .line 32
    iget-object v1, p0, Ltv/freewheel/utils/events/EventDispatcher;->_listenersMap:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 33
    .local v0, "listeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/IEventListener;>;"
    if-nez v0, :cond_1

    .line 34
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "listeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/IEventListener;>;"
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 35
    .restart local v0    # "listeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/IEventListener;>;"
    iget-object v1, p0, Ltv/freewheel/utils/events/EventDispatcher;->_listenersMap:Ljava/util/HashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 38
    :cond_1
    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 9
    .param p1, "event"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 68
    iget-object v6, p0, Ltv/freewheel/utils/events/EventDispatcher;->logger:Ltv/freewheel/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "dispatchEvent(event="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IEvent;->getType()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ")"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 69
    iget-object v6, p0, Ltv/freewheel/utils/events/EventDispatcher;->_listenersMap:Ljava/util/HashMap;

    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IEvent;->getType()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/ArrayList;

    .line 70
    .local v5, "listeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/IEventListener;>;"
    if-eqz v5, :cond_0

    .line 71
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v6

    new-array v1, v6, [Ltv/freewheel/ad/interfaces/IEventListener;

    .line 72
    .local v1, "array":[Ltv/freewheel/ad/interfaces/IEventListener;
    invoke-virtual {v5, v1}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 73
    move-object v0, v1

    .local v0, "arr$":[Ltv/freewheel/ad/interfaces/IEventListener;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v4, :cond_0

    aget-object v3, v0, v2

    .line 74
    .local v3, "item":Ltv/freewheel/ad/interfaces/IEventListener;
    invoke-interface {v3, p1}, Ltv/freewheel/ad/interfaces/IEventListener;->run(Ltv/freewheel/ad/interfaces/IEvent;)V

    .line 73
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 77
    .end local v0    # "arr$":[Ltv/freewheel/ad/interfaces/IEventListener;
    .end local v1    # "array":[Ltv/freewheel/ad/interfaces/IEventListener;
    .end local v2    # "i$":I
    .end local v3    # "item":Ltv/freewheel/ad/interfaces/IEventListener;
    .end local v4    # "len$":I
    :cond_0
    return-void
.end method

.method public removeAllListeners()V
    .locals 3

    .prologue
    .line 63
    iget-object v0, p0, Ltv/freewheel/utils/events/EventDispatcher;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "removeAllListeners for "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 64
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/utils/events/EventDispatcher;->_listenersMap:Ljava/util/HashMap;

    .line 65
    return-void
.end method

.method public removeEventListener(Ljava/lang/String;Ltv/freewheel/ad/interfaces/IEventListener;)V
    .locals 4
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "listener"    # Ltv/freewheel/ad/interfaces/IEventListener;

    .prologue
    .line 42
    iget-object v1, p0, Ltv/freewheel/utils/events/EventDispatcher;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "removeEventListener(type="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", listener="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 43
    iget-object v1, p0, Ltv/freewheel/utils/events/EventDispatcher;->_listenersMap:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 44
    .local v0, "listeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/IEventListener;>;"
    if-eqz v0, :cond_0

    .line 45
    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 46
    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 47
    iget-object v1, p0, Ltv/freewheel/utils/events/EventDispatcher;->_listenersMap:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    :cond_0
    return-void
.end method
