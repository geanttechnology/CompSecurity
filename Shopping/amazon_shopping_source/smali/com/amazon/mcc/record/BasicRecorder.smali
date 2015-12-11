.class public Lcom/amazon/mcc/record/BasicRecorder;
.super Ljava/lang/Object;
.source "BasicRecorder.java"

# interfaces
.implements Lcom/amazon/mcc/record/Recorder;


# static fields
.field static final BROKER:Lcom/amazon/mcc/nps/broker/Broker;


# instance fields
.field private final context:Lcom/amazon/mcc/record/RecordableContext;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    invoke-static {}, Lcom/amazon/mcc/record/BasicRecorder;->createBroker()Lcom/amazon/mcc/nps/broker/Broker;

    move-result-object v0

    sput-object v0, Lcom/amazon/mcc/record/BasicRecorder;->BROKER:Lcom/amazon/mcc/nps/broker/Broker;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 54
    new-instance v0, Lcom/amazon/mcc/record/BasicContext;

    invoke-direct {v0}, Lcom/amazon/mcc/record/BasicContext;-><init>()V

    invoke-direct {p0, v0}, Lcom/amazon/mcc/record/BasicRecorder;-><init>(Lcom/amazon/mcc/record/RecordableContext;)V

    .line 55
    return-void
.end method

.method public constructor <init>(Lcom/amazon/mcc/record/RecordableContext;)V
    .locals 0
    .param p1, "context"    # Lcom/amazon/mcc/record/RecordableContext;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    iput-object p1, p0, Lcom/amazon/mcc/record/BasicRecorder;->context:Lcom/amazon/mcc/record/RecordableContext;

    .line 65
    return-void
.end method

.method private static createBroker()Lcom/amazon/mcc/nps/broker/Broker;
    .locals 7

    .prologue
    .line 43
    new-instance v0, Ljava/util/concurrent/ThreadPoolExecutor;

    const/4 v1, 0x5

    const/16 v2, 0x64

    const-wide/16 v3, 0xc8

    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v6, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v6}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    invoke-direct/range {v0 .. v6}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    .line 47
    .local v0, "executor":Ljava/util/concurrent/ThreadPoolExecutor;
    new-instance v1, Lcom/amazon/mcc/nps/broker/Broker;

    new-instance v2, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;

    invoke-direct {v2, v0}, Lcom/amazon/mcc/nps/broker/dispatch/ConcurrentDispatcher;-><init>(Ljava/util/concurrent/ExecutorService;)V

    new-instance v3, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;

    invoke-direct {v3}, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;-><init>()V

    invoke-direct {v1, v2, v3}, Lcom/amazon/mcc/nps/broker/Broker;-><init>(Lcom/amazon/mcc/nps/broker/dispatch/MessageDispatcher;Lcom/amazon/mcc/nps/broker/container/ObserverContainer;)V

    return-object v1
.end method


# virtual methods
.method public record(Lcom/amazon/mcc/record/Recordable;)V
    .locals 3
    .param p1, "record"    # Lcom/amazon/mcc/record/Recordable;

    .prologue
    .line 73
    new-instance v0, Lcom/amazon/mcc/record/RecordableMessage;

    iget-object v1, p0, Lcom/amazon/mcc/record/BasicRecorder;->context:Lcom/amazon/mcc/record/RecordableContext;

    invoke-direct {v0, p1, v1}, Lcom/amazon/mcc/record/RecordableMessage;-><init>(Lcom/amazon/mcc/record/Recordable;Lcom/amazon/mcc/record/RecordableContext;)V

    .line 74
    .local v0, "message":Lcom/amazon/mcc/record/RecordableMessage;
    sget-object v1, Lcom/amazon/mcc/record/BasicRecorder;->BROKER:Lcom/amazon/mcc/nps/broker/Broker;

    sget-object v2, Lcom/amazon/mcc/record/RecordConstants;->RECORD_TOPIC:Ljava/lang/String;

    invoke-static {v2}, Lcom/amazon/mcc/nps/Topic;->of(Ljava/lang/String;)Lcom/amazon/mcc/nps/Topic;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/amazon/mcc/nps/broker/Broker;->publish(Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Message;)V

    .line 75
    return-void
.end method
