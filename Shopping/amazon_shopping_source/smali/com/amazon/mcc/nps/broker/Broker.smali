.class public Lcom/amazon/mcc/nps/broker/Broker;
.super Ljava/lang/Object;
.source "Broker.java"


# static fields
.field private static instance:Lcom/amazon/mcc/nps/broker/Broker;


# instance fields
.field private final container:Lcom/amazon/mcc/nps/broker/container/ObserverContainer;

.field private final dispatcher:Lcom/amazon/mcc/nps/broker/dispatch/MessageDispatcher;

.field private final log:Lcom/amazon/logging/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 68
    invoke-static {}, Lcom/amazon/mcc/nps/broker/Broker;->createDefaultBroker()Lcom/amazon/mcc/nps/broker/Broker;

    move-result-object v0

    sput-object v0, Lcom/amazon/mcc/nps/broker/Broker;->instance:Lcom/amazon/mcc/nps/broker/Broker;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/mcc/nps/broker/dispatch/MessageDispatcher;Lcom/amazon/mcc/nps/broker/container/ObserverContainer;)V
    .locals 3
    .param p1, "dispatcher"    # Lcom/amazon/mcc/nps/broker/dispatch/MessageDispatcher;
    .param p2, "container"    # Lcom/amazon/mcc/nps/broker/container/ObserverContainer;

    .prologue
    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 70
    const-class v0, Lcom/amazon/mcc/nps/broker/Broker;

    invoke-static {v0}, Lcom/amazon/logging/Logger;->getLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mcc/nps/broker/Broker;->log:Lcom/amazon/logging/Logger;

    .line 85
    if-nez p1, :cond_0

    .line 86
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "MessageDispatcher must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 89
    :cond_0
    if-nez p2, :cond_1

    .line 90
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "ObserverContainer must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 93
    :cond_1
    iget-object v0, p0, Lcom/amazon/mcc/nps/broker/Broker;->log:Lcom/amazon/logging/Logger;

    const-string/jumbo v1, "Constructing new Broker"

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    .line 94
    iget-object v0, p0, Lcom/amazon/mcc/nps/broker/Broker;->log:Lcom/amazon/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Dispatcher type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    .line 95
    iget-object v0, p0, Lcom/amazon/mcc/nps/broker/Broker;->log:Lcom/amazon/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Container type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    .line 97
    iput-object p1, p0, Lcom/amazon/mcc/nps/broker/Broker;->dispatcher:Lcom/amazon/mcc/nps/broker/dispatch/MessageDispatcher;

    .line 98
    iput-object p2, p0, Lcom/amazon/mcc/nps/broker/Broker;->container:Lcom/amazon/mcc/nps/broker/container/ObserverContainer;

    .line 99
    return-void
.end method

.method public static createDefaultBroker()Lcom/amazon/mcc/nps/broker/Broker;
    .locals 3

    .prologue
    .line 124
    new-instance v0, Lcom/amazon/mcc/nps/broker/Broker;

    new-instance v1, Lcom/amazon/mcc/nps/broker/dispatch/ImmediateDispatcher;

    invoke-direct {v1}, Lcom/amazon/mcc/nps/broker/dispatch/ImmediateDispatcher;-><init>()V

    new-instance v2, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;

    invoke-direct {v2}, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;-><init>()V

    invoke-direct {v0, v1, v2}, Lcom/amazon/mcc/nps/broker/Broker;-><init>(Lcom/amazon/mcc/nps/broker/dispatch/MessageDispatcher;Lcom/amazon/mcc/nps/broker/container/ObserverContainer;)V

    return-object v0
.end method


# virtual methods
.method public publish(Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Message;)V
    .locals 4
    .param p1, "topic"    # Lcom/amazon/mcc/nps/Topic;
    .param p2, "message"    # Lcom/amazon/mcc/nps/Message;

    .prologue
    .line 138
    invoke-virtual {p0, p1}, Lcom/amazon/mcc/nps/broker/Broker;->validateTopic(Lcom/amazon/mcc/nps/Topic;)V

    .line 139
    invoke-virtual {p0, p2}, Lcom/amazon/mcc/nps/broker/Broker;->validateMessage(Lcom/amazon/mcc/nps/Message;)V

    .line 143
    iget-object v1, p0, Lcom/amazon/mcc/nps/broker/Broker;->log:Lcom/amazon/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Publish: T: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/amazon/mcc/nps/Topic;->getIdentifier()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ", M: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    .line 144
    iget-object v1, p0, Lcom/amazon/mcc/nps/broker/Broker;->container:Lcom/amazon/mcc/nps/broker/container/ObserverContainer;

    invoke-interface {v1, p1}, Lcom/amazon/mcc/nps/broker/container/ObserverContainer;->getObserversForTopic(Lcom/amazon/mcc/nps/Topic;)Ljava/util/List;

    move-result-object v0

    .line 146
    .local v0, "observers":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mcc/nps/Observer;>;"
    if-eqz v0, :cond_0

    .line 147
    iget-object v1, p0, Lcom/amazon/mcc/nps/broker/Broker;->log:Lcom/amazon/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Notifying "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " observers"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    .line 150
    :cond_0
    iget-object v1, p0, Lcom/amazon/mcc/nps/broker/Broker;->dispatcher:Lcom/amazon/mcc/nps/broker/dispatch/MessageDispatcher;

    invoke-interface {v1, v0, p1, p2}, Lcom/amazon/mcc/nps/broker/dispatch/MessageDispatcher;->notifyObservers(Ljava/util/List;Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Message;)V

    .line 151
    return-void
.end method

.method public register(Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Observer;)Z
    .locals 1
    .param p1, "topic"    # Lcom/amazon/mcc/nps/Topic;
    .param p2, "observer"    # Lcom/amazon/mcc/nps/Observer;

    .prologue
    .line 165
    new-instance v0, Lcom/amazon/mcc/nps/ObserverProperties;

    invoke-direct {v0}, Lcom/amazon/mcc/nps/ObserverProperties;-><init>()V

    invoke-virtual {p0, p1, p2, v0}, Lcom/amazon/mcc/nps/broker/Broker;->register(Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Observer;Lcom/amazon/mcc/nps/ObserverProperties;)Z

    move-result v0

    return v0
.end method

.method public register(Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Observer;Lcom/amazon/mcc/nps/ObserverProperties;)Z
    .locals 3
    .param p1, "topic"    # Lcom/amazon/mcc/nps/Topic;
    .param p2, "observer"    # Lcom/amazon/mcc/nps/Observer;
    .param p3, "properties"    # Lcom/amazon/mcc/nps/ObserverProperties;

    .prologue
    .line 183
    invoke-virtual {p0, p1}, Lcom/amazon/mcc/nps/broker/Broker;->validateTopic(Lcom/amazon/mcc/nps/Topic;)V

    .line 184
    invoke-virtual {p0, p2}, Lcom/amazon/mcc/nps/broker/Broker;->validateObserver(Lcom/amazon/mcc/nps/Observer;)V

    .line 186
    iget-object v0, p0, Lcom/amazon/mcc/nps/broker/Broker;->log:Lcom/amazon/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Observer register: T: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/mcc/nps/Topic;->getIdentifier()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", Observer: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    .line 187
    iget-object v0, p0, Lcom/amazon/mcc/nps/broker/Broker;->container:Lcom/amazon/mcc/nps/broker/container/ObserverContainer;

    invoke-interface {v0, p1, p2, p3}, Lcom/amazon/mcc/nps/broker/container/ObserverContainer;->addObserverForTopic(Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Observer;Lcom/amazon/mcc/nps/ObserverProperties;)Z

    move-result v0

    return v0
.end method

.method public unregister(Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Observer;)Z
    .locals 3
    .param p1, "topic"    # Lcom/amazon/mcc/nps/Topic;
    .param p2, "observer"    # Lcom/amazon/mcc/nps/Observer;

    .prologue
    .line 202
    invoke-virtual {p0, p1}, Lcom/amazon/mcc/nps/broker/Broker;->validateTopic(Lcom/amazon/mcc/nps/Topic;)V

    .line 203
    invoke-virtual {p0, p2}, Lcom/amazon/mcc/nps/broker/Broker;->validateObserver(Lcom/amazon/mcc/nps/Observer;)V

    .line 205
    iget-object v0, p0, Lcom/amazon/mcc/nps/broker/Broker;->log:Lcom/amazon/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Observer unregister: T: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/mcc/nps/Topic;->getIdentifier()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", Observer: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    .line 206
    iget-object v0, p0, Lcom/amazon/mcc/nps/broker/Broker;->container:Lcom/amazon/mcc/nps/broker/container/ObserverContainer;

    invoke-interface {v0, p1, p2}, Lcom/amazon/mcc/nps/broker/container/ObserverContainer;->removeObserverForTopic(Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Observer;)Z

    move-result v0

    return v0
.end method

.method protected validateMessage(Lcom/amazon/mcc/nps/Message;)V
    .locals 2
    .param p1, "message"    # Lcom/amazon/mcc/nps/Message;

    .prologue
    .line 246
    if-nez p1, :cond_0

    .line 247
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Message must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 249
    :cond_0
    return-void
.end method

.method protected validateObserver(Lcom/amazon/mcc/nps/Observer;)V
    .locals 2
    .param p1, "observer"    # Lcom/amazon/mcc/nps/Observer;

    .prologue
    .line 218
    if-nez p1, :cond_0

    .line 219
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Observer must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 221
    :cond_0
    return-void
.end method

.method protected validateTopic(Lcom/amazon/mcc/nps/Topic;)V
    .locals 2
    .param p1, "topic"    # Lcom/amazon/mcc/nps/Topic;

    .prologue
    .line 232
    if-nez p1, :cond_0

    .line 233
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Topic must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 235
    :cond_0
    return-void
.end method
