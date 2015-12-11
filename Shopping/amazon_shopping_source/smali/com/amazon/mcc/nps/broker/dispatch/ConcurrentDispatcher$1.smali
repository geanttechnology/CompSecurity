.class Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher$1;
.super Ljava/lang/Object;
.source "ConcurrentDispatcher.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;->notifyObservers(Ljava/util/List;Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;

.field final synthetic val$message:Lcom/amazon/mcc/nps/Message;

.field final synthetic val$observers:Ljava/util/List;

.field final synthetic val$topic:Lcom/amazon/mcc/nps/Topic;


# direct methods
.method constructor <init>(Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;Ljava/util/List;Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Message;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher$1;->this$0:Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;

    iput-object p2, p0, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher$1;->val$observers:Ljava/util/List;

    iput-object p3, p0, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher$1;->val$topic:Lcom/amazon/mcc/nps/Topic;

    iput-object p4, p0, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher$1;->val$message:Lcom/amazon/mcc/nps/Message;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher$1;->this$0:Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;

    iget-object v1, p0, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher$1;->val$observers:Ljava/util/List;

    iget-object v2, p0, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher$1;->val$topic:Lcom/amazon/mcc/nps/Topic;

    iget-object v3, p0, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher$1;->val$message:Lcom/amazon/mcc/nps/Message;

    # invokes: Lcom/amazon/mcc/nps/broker/dispatch/ImmediateDispatcher;->notifyObservers(Ljava/util/List;Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Message;)V
    invoke-static {v0, v1, v2, v3}, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;->access$001(Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;Ljava/util/List;Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Message;)V

    .line 57
    return-void
.end method
