.class public Lcom/amazon/rio/j2me/client/util/ObjectPool;
.super Ljava/lang/Object;
.source "ObjectPool.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private active:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<TT;>;"
        }
    .end annotation
.end field

.field private closed:Z

.field private creationCnt:I

.field private deactivated:Z

.field private free:Ljava/util/Stack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Stack",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final freeSizeLimt:I

.field private final lifecycleManager:Lcom/amazon/rio/j2me/client/util/LifecycleManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/rio/j2me/client/util/LifecycleManager",
            "<TT;>;"
        }
    .end annotation
.end field

.field private maxActiveCnt:I

.field private final name:Ljava/lang/String;

.field private final totalSizeLimit:I


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/amazon/rio/j2me/client/util/LifecycleManager;II)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p3, "freeSizeLimt"    # I
    .param p4, "totalSizeLimit"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/rio/j2me/client/util/LifecycleManager",
            "<TT;>;II)V"
        }
    .end annotation

    .prologue
    .line 25
    .local p0, "this":Lcom/amazon/rio/j2me/client/util/ObjectPool;, "Lcom/amazon/rio/j2me/client/util/ObjectPool<TT;>;"
    .local p2, "lifecycleManager":Lcom/amazon/rio/j2me/client/util/LifecycleManager;, "Lcom/amazon/rio/j2me/client/util/LifecycleManager<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->active:Ljava/util/Vector;

    .line 20
    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->free:Ljava/util/Stack;

    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->name:Ljava/lang/String;

    .line 27
    iput-object p2, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->lifecycleManager:Lcom/amazon/rio/j2me/client/util/LifecycleManager;

    .line 28
    iput p3, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->freeSizeLimt:I

    .line 29
    iput p4, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->totalSizeLimit:I

    .line 30
    return-void
.end method


# virtual methods
.method public declared-synchronized acquireObject()Ljava/lang/Object;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/rio/j2me/client/util/LifecycleException;
        }
    .end annotation

    .prologue
    .line 68
    .local p0, "this":Lcom/amazon/rio/j2me/client/util/ObjectPool;, "Lcom/amazon/rio/j2me/client/util/ObjectPool<TT;>;"
    monitor-enter p0

    :try_start_0
    iget-boolean v2, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->closed:Z

    if-eqz v2, :cond_0

    .line 69
    new-instance v2, Ljava/lang/IllegalStateException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "pool already closed: pool="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/ObjectPool;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 68
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 72
    :cond_0
    const/4 v0, 0x0

    .line 73
    .local v0, "obj":Ljava/lang/Object;, "TT;"
    :try_start_1
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/ObjectPool;->getFreeCnt()I

    move-result v2

    if-nez v2, :cond_3

    .line 74
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/ObjectPool;->getActiveCnt()I

    move-result v2

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/ObjectPool;->getFreeCnt()I

    move-result v3

    add-int v1, v2, v3

    .line 75
    .local v1, "total":I
    iget v2, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->totalSizeLimit:I

    if-lt v1, v2, :cond_1

    .line 76
    new-instance v2, Lcom/amazon/rio/j2me/client/util/LifecycleException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "max allocation size exceeded: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/amazon/rio/j2me/client/util/LifecycleException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 79
    :cond_1
    iget-object v2, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->lifecycleManager:Lcom/amazon/rio/j2me/client/util/LifecycleManager;

    invoke-interface {v2}, Lcom/amazon/rio/j2me/client/util/LifecycleManager;->createInstance()Ljava/lang/Object;

    move-result-object v0

    .line 80
    iget v2, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->creationCnt:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->creationCnt:I

    .line 86
    .end local v1    # "total":I
    :goto_0
    iget-object v2, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->active:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 87
    iget-object v2, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->active:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    iget v3, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->maxActiveCnt:I

    if-le v2, v3, :cond_2

    .line 88
    iget-object v2, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->active:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    iput v2, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->maxActiveCnt:I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 93
    :cond_2
    monitor-exit p0

    return-object v0

    .line 83
    :cond_3
    :try_start_2
    iget-object v2, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->free:Ljava/util/Stack;

    invoke-virtual {v2}, Ljava/util/Stack;->pop()Ljava/lang/Object;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v0

    goto :goto_0
.end method

.method public declared-synchronized destroyObject(Ljava/lang/Object;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 117
    .local p0, "this":Lcom/amazon/rio/j2me/client/util/ObjectPool;, "Lcom/amazon/rio/j2me/client/util/ObjectPool<TT;>;"
    .local p1, "obj":Ljava/lang/Object;, "TT;"
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->active:Ljava/util/Vector;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->active:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->removeElement(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 118
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "object not member of pool: pool="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/ObjectPool;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " obj="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 117
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 121
    :cond_1
    :try_start_1
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->lifecycleManager:Lcom/amazon/rio/j2me/client/util/LifecycleManager;

    invoke-interface {v0, p1}, Lcom/amazon/rio/j2me/client/util/LifecycleManager;->destroyInstance(Ljava/lang/Object;)V

    .line 123
    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->closed:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->active:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v0

    if-nez v0, :cond_2

    .line 124
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->active:Ljava/util/Vector;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 126
    :cond_2
    monitor-exit p0

    return-void
.end method

.method public final declared-synchronized getActiveCnt()I
    .locals 1

    .prologue
    .line 37
    .local p0, "this":Lcom/amazon/rio/j2me/client/util/ObjectPool;, "Lcom/amazon/rio/j2me/client/util/ObjectPool<TT;>;"
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->active:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->size()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getFreeCnt()I
    .locals 1

    .prologue
    .line 39
    .local p0, "this":Lcom/amazon/rio/j2me/client/util/ObjectPool;, "Lcom/amazon/rio/j2me/client/util/ObjectPool<TT;>;"
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->free:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->size()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getFreeSizeLimt()I
    .locals 1

    .prologue
    .line 40
    .local p0, "this":Lcom/amazon/rio/j2me/client/util/ObjectPool;, "Lcom/amazon/rio/j2me/client/util/ObjectPool<TT;>;"
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->freeSizeLimt:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getTotalSizeLimit()I
    .locals 1

    .prologue
    .line 41
    .local p0, "this":Lcom/amazon/rio/j2me/client/util/ObjectPool;, "Lcom/amazon/rio/j2me/client/util/ObjectPool<TT;>;"
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->totalSizeLimit:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized releaseObject(Ljava/lang/Object;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 101
    .local p0, "this":Lcom/amazon/rio/j2me/client/util/ObjectPool;, "Lcom/amazon/rio/j2me/client/util/ObjectPool<TT;>;"
    .local p1, "obj":Ljava/lang/Object;, "TT;"
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->deactivated:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->closed:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->free:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->size()I

    move-result v0

    iget v1, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->freeSizeLimt:I

    if-lt v0, v1, :cond_1

    .line 102
    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/rio/j2me/client/util/ObjectPool;->destroyObject(Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 111
    :goto_0
    monitor-exit p0

    return-void

    .line 106
    :cond_1
    :try_start_1
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->active:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->removeElement(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 107
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "object not member of pool: pool="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/ObjectPool;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " obj="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 101
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 110
    :cond_2
    :try_start_2
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->free:Ljava/util/Stack;

    invoke-virtual {v0, p1}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 49
    .local p0, "this":Lcom/amazon/rio/j2me/client/util/ObjectPool;, "Lcom/amazon/rio/j2me/client/util/ObjectPool<TT;>;"
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 51
    .local v0, "sb":Ljava/lang/StringBuffer;
    const/16 v1, 0x5b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 52
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "name="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 53
    monitor-enter p0

    .line 54
    :try_start_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, ", closed="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->closed:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 55
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, ", activeCnt="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/ObjectPool;->getActiveCnt()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 56
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, ", freeCnt="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/ObjectPool;->getFreeCnt()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 57
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, ", maxActiveCnt="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->maxActiveCnt:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 58
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, ", creationCnt="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/amazon/rio/j2me/client/util/ObjectPool;->creationCnt:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 59
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, ", freeSizeLimt="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/ObjectPool;->getFreeSizeLimt()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 60
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, ", totalSizeLimit="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/ObjectPool;->getTotalSizeLimit()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 61
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 62
    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 64
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 61
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method
