.class public Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;
.super Lcom/amazon/mcc/nps/broker/dispatch/ImmediateDispatcher;
.source "ConcurrentDispatcher.java"


# instance fields
.field private final log:Lcom/amazon/logging/Logger;

.field private final service:Ljava/util/concurrent/ExecutorService;


# direct methods
.method public constructor <init>(Ljava/util/concurrent/ExecutorService;)V
    .locals 1
    .param p1, "service"    # Ljava/util/concurrent/ExecutorService;

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/amazon/mcc/nps/broker/dispatch/ImmediateDispatcher;-><init>()V

    .line 34
    const-class v0, Lcom/amazon/mcc/nps/broker/dispatch/ImmediateDispatcher;

    invoke-static {v0}, Lcom/amazon/logging/Logger;->getLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;->log:Lcom/amazon/logging/Logger;

    .line 39
    iput-object p1, p0, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;->service:Ljava/util/concurrent/ExecutorService;

    .line 40
    return-void
.end method

.method static synthetic access$001(Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;Ljava/util/List;Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Message;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;
    .param p1, "x1"    # Ljava/util/List;
    .param p2, "x2"    # Lcom/amazon/mcc/nps/Topic;
    .param p3, "x3"    # Lcom/amazon/mcc/nps/Message;

    .prologue
    .line 33
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mcc/nps/broker/dispatch/ImmediateDispatcher;->notifyObservers(Ljava/util/List;Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Message;)V

    return-void
.end method


# virtual methods
.method public notifyObservers(Ljava/util/List;Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Message;)V
    .locals 3
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
    .line 46
    .local p1, "observers":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mcc/nps/Observer;>;"
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_1

    .line 47
    :cond_0
    iget-object v0, p0, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;->log:Lcom/amazon/logging/Logger;

    const-string/jumbo v1, "Attempted to dispatch message to empty observers"

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->w(Ljava/lang/String;)V

    .line 59
    :goto_0
    return-void

    .line 51
    :cond_1
    iget-object v0, p0, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;->log:Lcom/amazon/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Scheduling dispatch: T: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2}, Lcom/amazon/mcc/nps/Topic;->getIdentifier()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " M: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    .line 52
    iget-object v0, p0, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;->service:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher$1;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher$1;-><init>(Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;Ljava/util/List;Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Message;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    goto :goto_0
.end method
