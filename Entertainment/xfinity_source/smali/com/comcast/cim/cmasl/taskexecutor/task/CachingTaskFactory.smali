.class public Lcom/comcast/cim/cmasl/taskexecutor/task/CachingTaskFactory;
.super Ljava/lang/Object;
.source "CachingTaskFactory.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "R:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
        "<TT;TR;>;"
    }
.end annotation


# instance fields
.field private final cache:Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap",
            "<TT;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TR;>;>;"
        }
    .end annotation
.end field

.field private final delegate:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<TT;TR;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;I)V
    .locals 1
    .param p2, "maxSize"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<TT;TR;>;I)V"
        }
    .end annotation

    .prologue
    .line 10
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/CachingTaskFactory;, "Lcom/comcast/cim/cmasl/taskexecutor/task/CachingTaskFactory<TT;TR;>;"
    .local p1, "delegate":Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory<TT;TR;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/CachingTaskFactory;->delegate:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 12
    new-instance v0, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;

    invoke-direct {v0, p2}, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/CachingTaskFactory;->cache:Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;

    .line 13
    return-void
.end method


# virtual methods
.method public get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TR;>;"
        }
    .end annotation

    .prologue
    .line 17
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/CachingTaskFactory;, "Lcom/comcast/cim/cmasl/taskexecutor/task/CachingTaskFactory<TT;TR;>;"
    .local p1, "key":Ljava/lang/Object;, "TT;"
    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/CachingTaskFactory;->cache:Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;

    invoke-virtual {v1, p1}, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 18
    .local v0, "task":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TR;>;"
    if-nez v0, :cond_0

    .line 19
    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/CachingTaskFactory;->delegate:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    invoke-interface {v1, p1}, Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;->get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    .line 20
    if-eqz v0, :cond_0

    .line 21
    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/CachingTaskFactory;->cache:Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;

    invoke-virtual {v1, p1, v0}, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 25
    :cond_0
    return-object v0
.end method
