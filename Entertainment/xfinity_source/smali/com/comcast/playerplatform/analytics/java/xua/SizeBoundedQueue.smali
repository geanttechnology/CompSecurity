.class public Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;
.super Ljava/lang/Object;
.source "SizeBoundedQueue.java"

# interfaces
.implements Ljava/util/Queue;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/util/Queue",
        "<TT;>;"
    }
.end annotation


# static fields
.field private static final logger:Lorg/slf4j/Logger;


# instance fields
.field private maxSize:I

.field private queue:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 25
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    const/16 v0, 0x64

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;-><init>(I)V

    .line 26
    return-void
.end method

.method public constructor <init>(I)V
    .locals 1
    .param p1, "maxSize"    # I

    .prologue
    .line 29
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    new-instance v0, Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentLinkedQueue;-><init>()V

    invoke-direct {p0, v0, p1}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;-><init>(Ljava/util/Queue;I)V

    .line 30
    return-void
.end method

.method public constructor <init>(Ljava/util/Queue;I)V
    .locals 2
    .param p2, "maxSize"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Queue",
            "<TT;>;I)V"
        }
    .end annotation

    .prologue
    .line 32
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    .local p1, "queue":Ljava/util/Queue;, "Ljava/util/Queue<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    if-gtz p2, :cond_0

    .line 34
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Queue size must be greater than 0."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 37
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "new SizeBoundedQueue created"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 38
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    .line 39
    iput p2, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->maxSize:I

    .line 40
    return-void
.end method

.method private makeRoom(I)V
    .locals 2
    .param p1, "itemsToAdd"    # I

    .prologue
    .line 139
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    iget v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->maxSize:I

    if-lt p1, v0, :cond_1

    .line 140
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->clear()V

    .line 147
    :cond_0
    return-void

    .line 144
    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->size()I

    move-result v0

    add-int/2addr v0, p1

    iget v1, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->maxSize:I

    if-le v0, v1, :cond_0

    .line 145
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->remove()Ljava/lang/Object;

    goto :goto_0
.end method


# virtual methods
.method public add(Ljava/lang/Object;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)Z"
        }
    .end annotation

    .prologue
    .line 62
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    .local p1, "xuaMessage":Ljava/lang/Object;, "TT;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "add"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 63
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->makeRoom(I)V

    .line 64
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public addAll(Ljava/util/Collection;)Z
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<+TT;>;)Z"
        }
    .end annotation

    .prologue
    .line 69
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<+TT;>;"
    if-ne p1, p0, :cond_0

    .line 70
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Cannot add a queue to itself."

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 73
    :cond_0
    sget-object v4, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v5, "addAll"

    invoke-interface {v4, v5}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 74
    const/4 v3, 0x0

    .line 75
    .local v3, "modified":Z
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 76
    .local v2, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<+TT;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget v4, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->maxSize:I

    if-ge v0, v4, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 77
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .line 78
    .local v1, "item":Ljava/lang/Object;, "TT;"
    invoke-virtual {p0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->add(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    if-eqz v3, :cond_2

    :cond_1
    const/4 v3, 0x1

    .line 76
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 78
    :cond_2
    const/4 v3, 0x0

    goto :goto_1

    .line 80
    .end local v1    # "item":Ljava/lang/Object;, "TT;"
    :cond_3
    return v3
.end method

.method public clear()V
    .locals 2

    .prologue
    .line 85
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "clear"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 86
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->clear()V

    .line 87
    return-void
.end method

.method public contains(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    .line 91
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "contains"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 92
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public containsAll(Ljava/util/Collection;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<*>;)Z"
        }
    .end annotation

    .prologue
    .line 97
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "containsAll"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 98
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->containsAll(Ljava/util/Collection;)Z

    move-result v0

    return v0
.end method

.method public element()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 163
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "element"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 164
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->element()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public isEmpty()Z
    .locals 2

    .prologue
    .line 103
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "isEmpty"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 104
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public iterator()Ljava/util/Iterator;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 109
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "iterator"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 110
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->iterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized maxSize()I
    .locals 2

    .prologue
    .line 179
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "maxSize"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 180
    iget v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->maxSize:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    .line 179
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public offer(Ljava/lang/Object;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)Z"
        }
    .end annotation

    .prologue
    .line 133
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    .local p1, "item":Ljava/lang/Object;, "TT;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "offer"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 134
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->makeRoom(I)V

    .line 135
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public peek()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 169
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "peek"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 170
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->peek()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public poll()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 157
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "poll"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 158
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public remove()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 151
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "remove"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 152
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->remove()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public remove(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    .line 115
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "remove"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 116
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->remove(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public removeAll(Ljava/util/Collection;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<*>;)Z"
        }
    .end annotation

    .prologue
    .line 121
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "removeAll"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 122
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->removeAll(Ljava/util/Collection;)Z

    move-result v0

    return v0
.end method

.method public retainAll(Ljava/util/Collection;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<*>;)Z"
        }
    .end annotation

    .prologue
    .line 127
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "retainAll"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 128
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->retainAll(Ljava/util/Collection;)Z

    move-result v0

    return v0
.end method

.method public declared-synchronized setMaxSize(I)V
    .locals 2
    .param p1, "maxSize"    # I

    .prologue
    .line 174
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "setMaxSize"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 175
    iput p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->maxSize:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 176
    monitor-exit p0

    return-void

    .line 174
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public size()I
    .locals 2

    .prologue
    .line 44
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "size"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 45
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->size()I

    move-result v0

    return v0
.end method

.method public toArray()[Ljava/lang/Object;
    .locals 2

    .prologue
    .line 50
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "toArray"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 51
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->toArray()[Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public toArray([Ljava/lang/Object;)[Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;)[TT;"
        }
    .end annotation

    .prologue
    .line 56
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;, "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue<TT;>;"
    .local p1, "array":[Ljava/lang/Object;, "[TT;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->logger:Lorg/slf4j/Logger;

    const-string v1, "toArray"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 57
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->queue:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method
