.class public Lcom/amazon/analytics/session/PriorityQueue;
.super Ljava/lang/Object;
.source "PriorityQueue.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;
    }
.end annotation


# static fields
.field private static final logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field private config:Lcom/amazon/analytics/AnalyticsConfiguration;

.field private lastMessagePushTime:Ljava/util/concurrent/atomic/AtomicLong;

.field private messageQueue:Ljava/util/concurrent/BlockingQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/BlockingQueue",
            "<",
            "Lcom/amazon/analytics/util/Message;",
            ">;"
        }
    .end annotation
.end field

.field private queueLock:Ljava/util/concurrent/locks/Lock;

.field private sessionObserver:Lcom/amazon/analytics/session/SessionObserver;

.field private sweeperService:Ljava/util/concurrent/ExecutorService;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/amazon/analytics/session/PriorityQueue;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/analytics/session/SessionObserver;Lcom/amazon/analytics/AnalyticsConfiguration;)V
    .locals 3
    .param p1, "sessionObserver"    # Lcom/amazon/analytics/session/SessionObserver;
    .param p2, "config"    # Lcom/amazon/analytics/AnalyticsConfiguration;

    .prologue
    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/session/PriorityQueue;->sweeperService:Ljava/util/concurrent/ExecutorService;

    .line 33
    new-instance v0, Ljava/util/concurrent/atomic/AtomicLong;

    const-wide/16 v1, 0x0

    invoke-direct {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicLong;-><init>(J)V

    iput-object v0, p0, Lcom/amazon/analytics/session/PriorityQueue;->lastMessagePushTime:Ljava/util/concurrent/atomic/AtomicLong;

    .line 35
    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/locks/ReentrantLock;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/analytics/session/PriorityQueue;->queueLock:Ljava/util/concurrent/locks/Lock;

    .line 45
    new-instance v0, Ljava/util/concurrent/PriorityBlockingQueue;

    const/16 v1, 0x10

    new-instance v2, Lcom/amazon/analytics/session/PriorityQueue$1;

    invoke-direct {v2, p0}, Lcom/amazon/analytics/session/PriorityQueue$1;-><init>(Lcom/amazon/analytics/session/PriorityQueue;)V

    invoke-direct {v0, v1, v2}, Ljava/util/concurrent/PriorityBlockingQueue;-><init>(ILjava/util/Comparator;)V

    iput-object v0, p0, Lcom/amazon/analytics/session/PriorityQueue;->messageQueue:Ljava/util/concurrent/BlockingQueue;

    .line 69
    iput-object p1, p0, Lcom/amazon/analytics/session/PriorityQueue;->sessionObserver:Lcom/amazon/analytics/session/SessionObserver;

    .line 70
    iput-object p2, p0, Lcom/amazon/analytics/session/PriorityQueue;->config:Lcom/amazon/analytics/AnalyticsConfiguration;

    .line 71
    iget-object v0, p0, Lcom/amazon/analytics/session/PriorityQueue;->sweeperService:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;-><init>(Lcom/amazon/analytics/session/PriorityQueue;Lcom/amazon/analytics/session/PriorityQueue$1;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 72
    return-void
.end method

.method static synthetic access$100()Lcom/amazon/device/analytics/log/Logger;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/analytics/session/PriorityQueue;)J
    .locals 2
    .param p0, "x0"    # Lcom/amazon/analytics/session/PriorityQueue;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/analytics/session/PriorityQueue;->getSweeperDelay()J

    move-result-wide v0

    return-wide v0
.end method

.method static synthetic access$300(Lcom/amazon/analytics/session/PriorityQueue;)Ljava/util/concurrent/locks/Lock;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/analytics/session/PriorityQueue;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/analytics/session/PriorityQueue;->queueLock:Ljava/util/concurrent/locks/Lock;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/analytics/session/PriorityQueue;)Ljava/util/concurrent/BlockingQueue;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/analytics/session/PriorityQueue;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/analytics/session/PriorityQueue;->messageQueue:Ljava/util/concurrent/BlockingQueue;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/analytics/session/PriorityQueue;Lcom/amazon/analytics/util/Message;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/analytics/session/PriorityQueue;
    .param p1, "x1"    # Lcom/amazon/analytics/util/Message;

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/amazon/analytics/session/PriorityQueue;->doPublish(Lcom/amazon/analytics/util/Message;)V

    return-void
.end method

.method static synthetic access$600(Lcom/amazon/analytics/session/PriorityQueue;)Ljava/util/concurrent/atomic/AtomicLong;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/analytics/session/PriorityQueue;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/analytics/session/PriorityQueue;->lastMessagePushTime:Ljava/util/concurrent/atomic/AtomicLong;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/analytics/session/PriorityQueue;Lcom/amazon/analytics/util/Message;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/analytics/session/PriorityQueue;
    .param p1, "x1"    # Lcom/amazon/analytics/util/Message;

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/amazon/analytics/session/PriorityQueue;->waitForMessageMaturity(Lcom/amazon/analytics/util/Message;)V

    return-void
.end method

.method private doPublish(Lcom/amazon/analytics/util/Message;)V
    .locals 2
    .param p1, "message"    # Lcom/amazon/analytics/util/Message;

    .prologue
    .line 119
    sget-object v0, Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v1, "sending publish to base broker"

    invoke-virtual {v0, v1}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    .line 120
    iget-object v0, p0, Lcom/amazon/analytics/session/PriorityQueue;->sessionObserver:Lcom/amazon/analytics/session/SessionObserver;

    invoke-virtual {v0, p1}, Lcom/amazon/analytics/session/SessionObserver;->onUpdate(Lcom/amazon/analytics/util/Message;)V

    .line 121
    return-void
.end method

.method private final getSweeperDelay()J
    .locals 8

    .prologue
    .line 162
    iget-object v4, p0, Lcom/amazon/analytics/session/PriorityQueue;->config:Lcom/amazon/analytics/AnalyticsConfiguration;

    sget-object v5, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->IgnoreSessionInterval:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    invoke-interface {v4, v5}, Lcom/amazon/analytics/AnalyticsConfiguration;->getInt(Lcom/amazon/analytics/AnalyticsConfiguration$Setting;)I

    move-result v4

    int-to-long v2, v4

    .line 163
    .local v2, "sessionInterval":J
    iget-object v4, p0, Lcom/amazon/analytics/session/PriorityQueue;->config:Lcom/amazon/analytics/AnalyticsConfiguration;

    sget-object v5, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->MaturityDelta:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    invoke-interface {v4, v5}, Lcom/amazon/analytics/AnalyticsConfiguration;->getInt(Lcom/amazon/analytics/AnalyticsConfiguration$Setting;)I

    move-result v4

    int-to-long v0, v4

    .line 164
    .local v0, "maturityDelta":J
    const-wide/16 v4, 0x2

    sub-long v6, v2, v0

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v4

    const-wide/16 v6, 0x3e8

    mul-long/2addr v4, v6

    return-wide v4
.end method

.method private waitForMessageMaturity(Lcom/amazon/analytics/util/Message;)V
    .locals 12
    .param p1, "message"    # Lcom/amazon/analytics/util/Message;

    .prologue
    const-wide/16 v10, 0x0

    .line 131
    invoke-direct {p0}, Lcom/amazon/analytics/session/PriorityQueue;->getSweeperDelay()J

    move-result-wide v3

    .line 132
    .local v3, "sweeperDelay":J
    move-wide v0, v3

    .line 133
    .local v0, "delay":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    .line 134
    .local v5, "timestamp":Ljava/lang/Long;
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v6

    if-eqz v6, :cond_1

    .line 135
    invoke-virtual {p1}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v6

    const-string/jumbo v7, "TimeStamp"

    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    .line 136
    .local v2, "messageTs":Ljava/lang/Long;
    if-eqz v2, :cond_0

    .line 137
    move-object v5, v2

    .line 140
    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    sub-long/2addr v6, v8

    sub-long v6, v3, v6

    invoke-static {v6, v7, v10, v11}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    .line 144
    .end local v2    # "messageTs":Ljava/lang/Long;
    :cond_1
    cmp-long v6, v0, v10

    if-nez v6, :cond_2

    .line 155
    :goto_0
    return-void

    .line 150
    :cond_2
    :try_start_0
    sget-object v6, Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "Waiting for a delay of "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, " based off message timestamp of "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v5}, Ljava/lang/Long;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    .line 151
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 152
    :catch_0
    move-exception v6

    goto :goto_0
.end method


# virtual methods
.method public enqueue(Lcom/amazon/analytics/util/Message;)V
    .locals 5
    .param p1, "message"    # Lcom/amazon/analytics/util/Message;

    .prologue
    .line 82
    if-nez p1, :cond_0

    .line 83
    :try_start_0
    sget-object v1, Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v2, "Message is being dropped because: The message is null"

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    .line 110
    :goto_0
    return-void

    .line 87
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v1

    const-string/jumbo v2, "TimeStamp"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    .line 88
    .local v0, "timestamp":Ljava/lang/Long;
    if-nez v0, :cond_1

    .line 89
    sget-object v1, Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v2, "Message is being dropped because: There is no message timestamp"

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 107
    .end local v0    # "timestamp":Ljava/lang/Long;
    :catch_0
    move-exception v1

    goto :goto_0

    .line 92
    .restart local v0    # "timestamp":Ljava/lang/Long;
    :cond_1
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    iget-object v3, p0, Lcom/amazon/analytics/session/PriorityQueue;->lastMessagePushTime:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v3}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v3

    cmp-long v1, v1, v3

    if-gtz v1, :cond_2

    .line 93
    sget-object v1, Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v2, "Message is being dropped because: The timestamp is too old"

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 98
    :cond_2
    iget-object v1, p0, Lcom/amazon/analytics/session/PriorityQueue;->queueLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->lock()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 101
    :try_start_1
    iget-object v1, p0, Lcom/amazon/analytics/session/PriorityQueue;->messageQueue:Ljava/util/concurrent/BlockingQueue;

    invoke-interface {v1, p1}, Ljava/util/concurrent/BlockingQueue;->put(Ljava/lang/Object;)V

    .line 102
    sget-object v1, Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Enqueing message with timestamp "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " @ the time of "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 104
    :try_start_2
    iget-object v1, p0, Lcom/amazon/analytics/session/PriorityQueue;->queueLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_0

    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/amazon/analytics/session/PriorityQueue;->queueLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v1
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
.end method
