.class Lcom/amazon/mcc/record/RecordCollector$RecordObserver;
.super Ljava/lang/Object;
.source "RecordCollector.java"

# interfaces
.implements Lcom/amazon/mcc/nps/Observer;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mcc/record/RecordCollector;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "RecordObserver"
.end annotation


# instance fields
.field private final collectorWeakReference:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/amazon/mcc/record/RecordCollector;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/amazon/mcc/record/RecordCollector;)V
    .locals 1
    .param p1, "collector"    # Lcom/amazon/mcc/record/RecordCollector;

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/amazon/mcc/record/RecordCollector$RecordObserver;->collectorWeakReference:Ljava/lang/ref/WeakReference;

    .line 50
    return-void
.end method


# virtual methods
.method public onUpdate(Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Message;)V
    .locals 4
    .param p1, "topic"    # Lcom/amazon/mcc/nps/Topic;
    .param p2, "message"    # Lcom/amazon/mcc/nps/Message;

    .prologue
    .line 55
    instance-of v2, p2, Lcom/amazon/mcc/record/RecordableMessage;

    if-eqz v2, :cond_0

    .line 56
    iget-object v2, p0, Lcom/amazon/mcc/record/RecordCollector$RecordObserver;->collectorWeakReference:Ljava/lang/ref/WeakReference;

    invoke-virtual {v2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mcc/record/RecordCollector;

    .line 57
    .local v1, "recordCollector":Lcom/amazon/mcc/record/RecordCollector;
    if-eqz v1, :cond_1

    move-object v0, p2

    .line 58
    check-cast v0, Lcom/amazon/mcc/record/RecordableMessage;

    .line 59
    .local v0, "recMessage":Lcom/amazon/mcc/record/RecordableMessage;
    invoke-virtual {v1, v0}, Lcom/amazon/mcc/record/RecordCollector;->handle(Lcom/amazon/mcc/record/PropertyMap;)V

    .line 64
    .end local v0    # "recMessage":Lcom/amazon/mcc/record/RecordableMessage;
    .end local v1    # "recordCollector":Lcom/amazon/mcc/record/RecordCollector;
    :cond_0
    :goto_0
    return-void

    .line 61
    .restart local v1    # "recordCollector":Lcom/amazon/mcc/record/RecordCollector;
    :cond_1
    sget-object v2, Lcom/amazon/mcc/record/BasicRecorder;->BROKER:Lcom/amazon/mcc/nps/broker/Broker;

    sget-object v3, Lcom/amazon/mcc/record/RecordConstants;->RECORD_TOPIC:Ljava/lang/String;

    invoke-static {v3}, Lcom/amazon/mcc/nps/Topic;->of(Ljava/lang/String;)Lcom/amazon/mcc/nps/Topic;

    move-result-object v3

    invoke-virtual {v2, v3, p0}, Lcom/amazon/mcc/nps/broker/Broker;->unregister(Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Observer;)Z

    goto :goto_0
.end method
