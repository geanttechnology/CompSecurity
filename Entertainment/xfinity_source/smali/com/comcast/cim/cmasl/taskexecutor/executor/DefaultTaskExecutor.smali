.class public Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;
.super Ljava/lang/Object;
.source "DefaultTaskExecutor.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$1;,
        Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;,
        Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
        "<TT;>;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final backgroundExecutor:Ljava/util/concurrent/Executor;

.field private final foregroundExecutor:Ljava/util/concurrent/Executor;

.field private final pendingListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field private final task:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V
    .locals 1
    .param p2, "backgroundExecutor"    # Ljava/util/concurrent/Executor;
    .param p3, "foregroundExecutor"    # Ljava/util/concurrent/Executor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT;>;",
            "Ljava/util/concurrent/Executor;",
            "Ljava/util/concurrent/Executor;",
            ")V"
        }
    .end annotation

    .prologue
    .line 23
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor<TT;>;"
    .local p1, "task":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->pendingListeners:Ljava/util/Set;

    .line 24
    iput-object p1, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->task:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 25
    iput-object p2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->backgroundExecutor:Ljava/util/concurrent/Executor;

    .line 26
    iput-object p3, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->foregroundExecutor:Ljava/util/concurrent/Executor;

    .line 27
    return-void
.end method

.method static synthetic access$200(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->task:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method static synthetic access$300()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$500(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;)Ljava/util/Set;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->pendingListeners:Ljava/util/Set;

    return-object v0
.end method

.method static synthetic access$600(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;)Ljava/util/concurrent/Executor;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->backgroundExecutor:Ljava/util/concurrent/Executor;

    return-object v0
.end method

.method static synthetic access$700(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;)Ljava/util/concurrent/Executor;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->foregroundExecutor:Ljava/util/concurrent/Executor;

    return-object v0
.end method


# virtual methods
.method public cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 126
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor<TT;>;"
    .local p1, "executionListener":Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->pendingListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 127
    return-void
.end method

.method public execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<",
            "L::Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<TT;>;>(T",
            "L;",
            ")T",
            "L;"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor<TT;>;"
    .local p1, "executionListener":Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;, "TL;"
    const/4 v5, 0x0

    .line 31
    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->task:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    .line 32
    .local v0, "cachedResult":Ljava/lang/Object;, "TT;"
    if-eqz v0, :cond_0

    .line 33
    sget-object v2, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Result is cached in task {}, calling listener synchronously"

    iget-object v4, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->task:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v2, v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 34
    invoke-interface {p1, v0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;->onPostExecute(Ljava/lang/Object;)V

    .line 51
    :goto_0
    return-object p1

    .line 36
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->task:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v1

    .line 37
    .local v1, "staleResultIfAvailable":Ljava/lang/Object;, "TT;"
    if-nez v1, :cond_1

    .line 38
    sget-object v2, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Stale result is unavailable from task {}, fetch second level stale result asynchronously"

    iget-object v4, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->task:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v2, v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 39
    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->pendingListeners:Ljava/util/Set;

    invoke-interface {v2, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 40
    invoke-interface {p1}, Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;->onPreAsynchronousExecute()V

    .line 41
    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->backgroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v3, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;

    invoke-direct {v3, p0, p1, v5}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$1;)V

    invoke-interface {v2, v3}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 43
    :cond_1
    sget-object v2, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Stale result is available from task {}, calling listener synchronously and fetching up to date result"

    iget-object v4, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->task:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v2, v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 44
    invoke-interface {p1, v1}, Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;->onStaleResultAvailable(Ljava/lang/Object;)V

    .line 46
    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->pendingListeners:Ljava/util/Set;

    invoke-interface {v2, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 47
    invoke-interface {p1}, Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;->onPreAsynchronousExecute()V

    .line 48
    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->backgroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v3, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;

    invoke-direct {v3, p0, p1, v5}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$1;)V

    invoke-interface {v2, v3}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    goto :goto_0
.end method
