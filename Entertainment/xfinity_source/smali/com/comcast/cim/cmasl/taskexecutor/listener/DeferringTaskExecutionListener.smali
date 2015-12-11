.class public abstract Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "DeferringTaskExecutionListener.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private final delegate:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener<TT;>;"
    .local p1, "delegate":Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener<TT;>;"
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    .line 13
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->LOG:Lorg/slf4j/Logger;

    .line 17
    iput-object p1, p0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->delegate:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 18
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;

    .prologue
    .line 12
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->delegate:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method


# virtual methods
.method protected abstract onDefer(Ljava/lang/Runnable;)V
.end method

.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 2
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 36
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener<TT;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->shouldDefer()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 37
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Deferring onError"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->info(Ljava/lang/String;)V

    .line 38
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$2;

    invoke-direct {v0, p0, p1}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$2;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V

    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->onDefer(Ljava/lang/Runnable;)V

    .line 46
    :goto_0
    return-void

    .line 44
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->delegate:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, p1}, Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;->onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V

    goto :goto_0
.end method

.method public onPostExecute(Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 22
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener<TT;>;"
    .local p1, "result":Ljava/lang/Object;, "TT;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->shouldDefer()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 23
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Deferring onPostExecute"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->info(Ljava/lang/String;)V

    .line 24
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$1;

    invoke-direct {v0, p0, p1}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$1;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;Ljava/lang/Object;)V

    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->onDefer(Ljava/lang/Runnable;)V

    .line 32
    :goto_0
    return-void

    .line 30
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->delegate:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, p1}, Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;->onPostExecute(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected abstract shouldDefer()Z
.end method
