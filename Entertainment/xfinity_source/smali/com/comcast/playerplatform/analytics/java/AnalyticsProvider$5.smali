.class Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;
.super Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;
.source "AnalyticsProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)V
    .locals 0

    .prologue
    .line 404
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;-><init>()V

    return-void
.end method


# virtual methods
.method public messagesFailed(Ljava/lang/String;Ljava/util/Collection;)V
    .locals 5
    .param p1, "errorMessage"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Collection",
            "<",
            "Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 459
    .local p2, "messages":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->listeners:Ljava/util/Vector;
    invoke-static {v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$400(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Ljava/util/Vector;

    move-result-object v3

    monitor-enter v3

    .line 460
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->listeners:Ljava/util/Vector;
    invoke-static {v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$400(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Ljava/util/Vector;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;

    .line 461
    .local v0, "event":Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;
    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;->messagesFailed(Ljava/lang/String;Ljava/util/Collection;)V

    goto :goto_0

    .line 463
    .end local v0    # "event":Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;
    .end local v1    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 465
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # operator++ for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->serverRetries:I
    invoke-static {v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$508(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)I

    .line 467
    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$300()Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "messagesFailed"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 468
    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$300()Lorg/slf4j/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p2}, Ljava/util/Collection;->size()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " messages failed to send"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 469
    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$300()Lorg/slf4j/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "there are "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;
    invoke-static {v4}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$000(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->size()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " messages remaining in the queue"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 470
    return-void
.end method

.method public messagesSent(Ljava/util/Collection;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 422
    .local p1, "messages":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->listeners:Ljava/util/Vector;
    invoke-static {v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$400(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Ljava/util/Vector;

    move-result-object v3

    monitor-enter v3

    .line 423
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->listeners:Ljava/util/Vector;
    invoke-static {v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$400(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Ljava/util/Vector;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;

    .line 424
    .local v0, "event":Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;
    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;->messagesSent(Ljava/util/Collection;)V

    goto :goto_0

    .line 426
    .end local v0    # "event":Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;
    .end local v1    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 428
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    const/4 v3, 0x0

    # setter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->serverRetries:I
    invoke-static {v2, v3}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$502(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;I)I

    .line 430
    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$300()Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "messagesSent callback"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 431
    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$300()Lorg/slf4j/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " messages were sent successfully"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 433
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;
    invoke-static {v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$000(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->removeAll(Ljava/util/Collection;)Z

    .line 434
    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$300()Lorg/slf4j/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "there are "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;
    invoke-static {v4}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$000(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->size()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " messages remaining in the queue"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 436
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->xuaMessageFileIo:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;
    invoke-static {v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$100(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 438
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->scheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    invoke-static {v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$600(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    move-result-object v2

    new-instance v3, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5$1;

    invoke-direct {v3, p0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5$1;-><init>(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;)V

    invoke-virtual {v2, v3}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    .line 449
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->offlineStorageEnabled:Z
    invoke-static {v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$700(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Z

    move-result v2

    if-nez v2, :cond_1

    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->xuaMessageFileIo:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;
    invoke-static {v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$100(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->hasSavedItems()Z

    move-result v2

    if-nez v2, :cond_1

    .line 452
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    const/4 v3, 0x0

    # setter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->xuaMessageFileIo:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;
    invoke-static {v2, v3}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$102(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;)Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;

    .line 455
    :cond_1
    return-void
.end method
