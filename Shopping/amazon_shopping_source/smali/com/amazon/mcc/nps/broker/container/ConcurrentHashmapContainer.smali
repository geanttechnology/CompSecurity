.class public Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;
.super Ljava/lang/Object;
.source "ConcurrentHashmapContainer.java"

# interfaces
.implements Lcom/amazon/mcc/nps/broker/container/ObserverContainer;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$1;,
        Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserverComparator;,
        Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;
    }
.end annotation


# instance fields
.field private final comparator:Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserverComparator;

.field private final log:Lcom/amazon/logging/Logger;

.field private final observersMap:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Lcom/amazon/mcc/nps/Topic;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    const-class v0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;

    invoke-static {v0}, Lcom/amazon/logging/Logger;->getLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->log:Lcom/amazon/logging/Logger;

    .line 37
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->observersMap:Ljava/util/concurrent/ConcurrentHashMap;

    .line 38
    new-instance v0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserverComparator;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserverComparator;-><init>(Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$1;)V

    iput-object v0, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->comparator:Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserverComparator;

    .line 161
    return-void
.end method

.method private copyObserversList(Ljava/util/List;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mcc/nps/Observer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 70
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;>;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    invoke-direct {v0, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 71
    .local v0, "copy":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mcc/nps/Observer;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;

    .line 72
    .local v2, "registration":Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;
    invoke-virtual {v2}, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;->getObserver()Lcom/amazon/mcc/nps/Observer;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 75
    .end local v2    # "registration":Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;
    :cond_0
    return-object v0
.end method


# virtual methods
.method public addObserverForTopic(Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Observer;Lcom/amazon/mcc/nps/ObserverProperties;)Z
    .locals 3
    .param p1, "topic"    # Lcom/amazon/mcc/nps/Topic;
    .param p2, "observer"    # Lcom/amazon/mcc/nps/Observer;
    .param p3, "properties"    # Lcom/amazon/mcc/nps/ObserverProperties;

    .prologue
    .line 80
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 81
    :cond_0
    iget-object v1, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->log:Lcom/amazon/logging/Logger;

    const-string/jumbo v2, "Attempted to add null topic or null observer"

    invoke-virtual {v1, v2}, Lcom/amazon/logging/Logger;->w(Ljava/lang/String;)V

    .line 82
    const/4 v1, 0x0

    .line 93
    :goto_0
    return v1

    .line 85
    :cond_1
    iget-object v1, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->observersMap:Ljava/util/concurrent/ConcurrentHashMap;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {v1, p1, v2}, Ljava/util/concurrent/ConcurrentHashMap;->putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    iget-object v1, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->observersMap:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v1, p1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 88
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;>;"
    monitor-enter v0

    .line 89
    :try_start_0
    new-instance v1, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;

    invoke-direct {v1, p2, p3}, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;-><init>(Lcom/amazon/mcc/nps/Observer;Lcom/amazon/mcc/nps/ObserverProperties;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 90
    new-instance v1, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserverComparator;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserverComparator;-><init>(Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$1;)V

    invoke-static {v0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 91
    monitor-exit v0

    .line 93
    const/4 v1, 0x1

    goto :goto_0

    .line 91
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public getObserversForTopic(Lcom/amazon/mcc/nps/Topic;)Ljava/util/List;
    .locals 8
    .param p1, "topic"    # Lcom/amazon/mcc/nps/Topic;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mcc/nps/Topic;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mcc/nps/Observer;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 43
    if-nez p1, :cond_0

    .line 44
    iget-object v4, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->log:Lcom/amazon/logging/Logger;

    const-string/jumbo v5, "GetObserversForTopic called with null topic!"

    invoke-virtual {v4, v5}, Lcom/amazon/logging/Logger;->w(Ljava/lang/String;)V

    .line 65
    :goto_0
    return-object v3

    .line 48
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/mcc/nps/Topic;->getIdentifier()Ljava/lang/String;

    move-result-object v2

    .line 50
    .local v2, "topicName":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->log:Lcom/amazon/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "GetObserversForTopic: T: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    .line 51
    iget-object v4, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->observersMap:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v4, p1}, Ljava/util/concurrent/ConcurrentHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 52
    iget-object v4, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->observersMap:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v4, p1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 53
    .local v1, "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;>;"
    if-eqz v1, :cond_1

    .line 54
    monitor-enter v1

    .line 55
    :try_start_0
    iget-object v3, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->log:Lcom/amazon/logging/Logger;

    const-string/jumbo v4, "Found %d observers for topic: T: "

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    aput-object v2, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    .line 56
    invoke-direct {p0, v1}, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->copyObserversList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 57
    .local v0, "copy":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mcc/nps/Observer;>;"
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    monitor-exit v1

    goto :goto_0

    .line 58
    .end local v0    # "copy":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mcc/nps/Observer;>;"
    :catchall_0
    move-exception v3

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .line 60
    :cond_1
    iget-object v4, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->log:Lcom/amazon/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Found a null list of observers for topic: T: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p1}, Lcom/amazon/mcc/nps/Topic;->getIdentifier()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/logging/Logger;->w(Ljava/lang/String;)V

    goto :goto_0

    .line 64
    .end local v1    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;>;"
    :cond_2
    iget-object v4, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->log:Lcom/amazon/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "No observers found for topic: T: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p1}, Lcom/amazon/mcc/nps/Topic;->getIdentifier()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method public removeObserverForTopic(Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Observer;)Z
    .locals 4
    .param p1, "topic"    # Lcom/amazon/mcc/nps/Topic;
    .param p2, "observer"    # Lcom/amazon/mcc/nps/Observer;

    .prologue
    const/4 v1, 0x0

    .line 98
    if-eqz p1, :cond_0

    if-nez p2, :cond_2

    .line 99
    :cond_0
    iget-object v2, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->log:Lcom/amazon/logging/Logger;

    const-string/jumbo v3, "Attempted to remove null topic or null observer"

    invoke-virtual {v2, v3}, Lcom/amazon/logging/Logger;->w(Ljava/lang/String;)V

    .line 114
    :cond_1
    :goto_0
    return v1

    .line 103
    :cond_2
    iget-object v2, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->observersMap:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v2, p1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 104
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;>;"
    if-eqz v0, :cond_1

    .line 108
    monitor-enter v0

    .line 109
    :try_start_0
    new-instance v2, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;

    new-instance v3, Lcom/amazon/mcc/nps/ObserverProperties;

    invoke-direct {v3}, Lcom/amazon/mcc/nps/ObserverProperties;-><init>()V

    invoke-direct {v2, p2, v3}, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;-><init>(Lcom/amazon/mcc/nps/Observer;Lcom/amazon/mcc/nps/ObserverProperties;)V

    invoke-interface {v0, v2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    move-result v1

    .line 110
    .local v1, "removed":Z
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-nez v2, :cond_3

    .line 111
    iget-object v2, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;->observersMap:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v2, p1}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 114
    :cond_3
    monitor-exit v0

    goto :goto_0

    .line 115
    .end local v1    # "removed":Z
    :catchall_0
    move-exception v2

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method
