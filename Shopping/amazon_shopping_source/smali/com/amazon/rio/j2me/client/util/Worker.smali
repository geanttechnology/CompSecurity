.class public Lcom/amazon/rio/j2me/client/util/Worker;
.super Ljava/lang/Thread;
.source "Worker.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/rio/j2me/client/util/Worker$State;
    }
.end annotation


# static fields
.field private static final logger:Lcom/amazon/rio/j2me/client/util/Logger;


# instance fields
.field private final lock:Ljava/lang/Object;

.field private state:Lcom/amazon/rio/j2me/client/util/Worker$State;

.field private task:Ljava/lang/Runnable;

.field private taskName:Ljava/lang/String;

.field private threadStarted:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 10
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    const-class v1, Lcom/amazon/rio/j2me/client/util/Worker;

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->getLogger(Ljava/lang/Class;)Lcom/amazon/rio/j2me/client/util/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/rio/j2me/client/util/Worker;->logger:Lcom/amazon/rio/j2me/client/util/Logger;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 30
    invoke-direct {p0, p1, v0, v0}, Lcom/amazon/rio/j2me/client/util/Worker;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "taskName"    # Ljava/lang/String;
    .param p3, "task"    # Ljava/lang/Runnable;

    .prologue
    .line 32
    invoke-direct {p0, p1}, Ljava/lang/Thread;-><init>(Ljava/lang/String;)V

    .line 24
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/util/Worker;->lock:Ljava/lang/Object;

    .line 26
    sget-object v0, Lcom/amazon/rio/j2me/client/util/Worker$State;->IDLE:Lcom/amazon/rio/j2me/client/util/Worker$State;

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/util/Worker;->state:Lcom/amazon/rio/j2me/client/util/Worker$State;

    .line 33
    iput-object p2, p0, Lcom/amazon/rio/j2me/client/util/Worker;->taskName:Ljava/lang/String;

    .line 34
    iput-object p3, p0, Lcom/amazon/rio/j2me/client/util/Worker;->task:Ljava/lang/Runnable;

    .line 35
    return-void
.end method

.method private setState(Lcom/amazon/rio/j2me/client/util/Worker$State;)V
    .locals 2
    .param p1, "state"    # Lcom/amazon/rio/j2me/client/util/Worker$State;

    .prologue
    .line 158
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/util/Worker;->lock:Ljava/lang/Object;

    monitor-enter v1

    .line 159
    :try_start_0
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/util/Worker;->state:Lcom/amazon/rio/j2me/client/util/Worker$State;

    .line 160
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/util/Worker;->lock:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notifyAll()V

    .line 161
    monitor-exit v1

    .line 162
    return-void

    .line 161
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method public execute(Ljava/lang/String;Ljava/lang/Runnable;)V
    .locals 3
    .param p1, "taskName"    # Ljava/lang/String;
    .param p2, "task"    # Ljava/lang/Runnable;

    .prologue
    .line 120
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/util/Worker;->executeIfIdle(Ljava/lang/String;Ljava/lang/Runnable;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 121
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Worker can\'t execute task, bad state: worker="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 123
    :cond_0
    return-void
.end method

.method public executeIfIdle()Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    .line 88
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/util/Worker;->lock:Ljava/lang/Object;

    monitor-enter v1

    .line 89
    :try_start_0
    iget-object v2, p0, Lcom/amazon/rio/j2me/client/util/Worker;->state:Lcom/amazon/rio/j2me/client/util/Worker$State;

    sget-object v3, Lcom/amazon/rio/j2me/client/util/Worker$State;->IDLE:Lcom/amazon/rio/j2me/client/util/Worker$State;

    if-eq v2, v3, :cond_0

    .line 90
    const/4 v0, 0x0

    monitor-exit v1

    .line 102
    :goto_0
    return v0

    .line 93
    :cond_0
    iget-boolean v2, p0, Lcom/amazon/rio/j2me/client/util/Worker;->threadStarted:Z

    if-nez v2, :cond_1

    .line 95
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/Worker;->start()V

    .line 96
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/amazon/rio/j2me/client/util/Worker;->threadStarted:Z

    .line 99
    :cond_1
    sget-object v2, Lcom/amazon/rio/j2me/client/util/Worker$State;->EXECUTING:Lcom/amazon/rio/j2me/client/util/Worker$State;

    invoke-direct {p0, v2}, Lcom/amazon/rio/j2me/client/util/Worker;->setState(Lcom/amazon/rio/j2me/client/util/Worker$State;)V

    .line 100
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public executeIfIdle(Ljava/lang/String;Ljava/lang/Runnable;)Z
    .locals 3
    .param p1, "taskName"    # Ljava/lang/String;
    .param p2, "task"    # Ljava/lang/Runnable;

    .prologue
    .line 106
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/util/Worker;->lock:Ljava/lang/Object;

    monitor-enter v1

    .line 107
    :try_start_0
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/util/Worker;->state:Lcom/amazon/rio/j2me/client/util/Worker$State;

    sget-object v2, Lcom/amazon/rio/j2me/client/util/Worker$State;->IDLE:Lcom/amazon/rio/j2me/client/util/Worker$State;

    if-eq v0, v2, :cond_0

    .line 108
    const/4 v0, 0x0

    monitor-exit v1

    .line 116
    :goto_0
    return v0

    .line 111
    :cond_0
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/util/Worker;->taskName:Ljava/lang/String;

    .line 112
    iput-object p2, p0, Lcom/amazon/rio/j2me/client/util/Worker;->task:Ljava/lang/Runnable;

    .line 113
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/Worker;->executeIfIdle()Z

    .line 114
    monitor-exit v1

    .line 116
    const/4 v0, 0x1

    goto :goto_0

    .line 114
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getTaskName()Ljava/lang/String;
    .locals 2

    .prologue
    .line 165
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/util/Worker;->lock:Ljava/lang/Object;

    monitor-enter v1

    .line 166
    :try_start_0
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/util/Worker;->taskName:Ljava/lang/String;

    monitor-exit v1

    return-object v0

    .line 167
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getWorkerState()Lcom/amazon/rio/j2me/client/util/Worker$State;
    .locals 2

    .prologue
    .line 38
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/util/Worker;->lock:Ljava/lang/Object;

    monitor-enter v1

    .line 39
    :try_start_0
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/util/Worker;->state:Lcom/amazon/rio/j2me/client/util/Worker$State;

    monitor-exit v1

    return-object v0

    .line 40
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public run()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 182
    const/4 v0, 0x0

    .line 185
    .local v0, "executed":Z
    :goto_0
    iget-object v4, p0, Lcom/amazon/rio/j2me/client/util/Worker;->lock:Ljava/lang/Object;

    monitor-enter v4

    .line 187
    :cond_0
    :goto_1
    :try_start_0
    iget-object v3, p0, Lcom/amazon/rio/j2me/client/util/Worker;->state:Lcom/amazon/rio/j2me/client/util/Worker$State;

    sget-object v5, Lcom/amazon/rio/j2me/client/util/Worker$State;->STOPPED:Lcom/amazon/rio/j2me/client/util/Worker$State;

    if-ne v3, v5, :cond_1

    .line 189
    monitor-exit v4

    return-void

    .line 192
    :cond_1
    iget-object v3, p0, Lcom/amazon/rio/j2me/client/util/Worker;->state:Lcom/amazon/rio/j2me/client/util/Worker$State;

    sget-object v5, Lcom/amazon/rio/j2me/client/util/Worker$State;->EXECUTING:Lcom/amazon/rio/j2me/client/util/Worker$State;

    if-ne v3, v5, :cond_2

    .line 193
    if-eqz v0, :cond_3

    .line 194
    const/4 v0, 0x0

    .line 195
    sget-object v3, Lcom/amazon/rio/j2me/client/util/Worker$State;->IDLE:Lcom/amazon/rio/j2me/client/util/Worker$State;

    invoke-direct {p0, v3}, Lcom/amazon/rio/j2me/client/util/Worker;->setState(Lcom/amazon/rio/j2me/client/util/Worker$State;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 202
    :cond_2
    :try_start_1
    iget-object v3, p0, Lcom/amazon/rio/j2me/client/util/Worker;->lock:Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Object;->wait()V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 203
    :catch_0
    move-exception v1

    .line 204
    .local v1, "ie":Ljava/lang/InterruptedException;
    :try_start_2
    iget-object v3, p0, Lcom/amazon/rio/j2me/client/util/Worker;->state:Lcom/amazon/rio/j2me/client/util/Worker$State;

    sget-object v5, Lcom/amazon/rio/j2me/client/util/Worker$State;->EXECUTING:Lcom/amazon/rio/j2me/client/util/Worker$State;

    if-ne v3, v5, :cond_0

    .line 205
    const/4 v0, 0x1

    goto :goto_1

    .line 209
    .end local v1    # "ie":Ljava/lang/InterruptedException;
    :cond_3
    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 212
    :try_start_3
    iget-object v3, p0, Lcom/amazon/rio/j2me/client/util/Worker;->task:Ljava/lang/Runnable;

    if-eqz v3, :cond_4

    .line 213
    iget-object v3, p0, Lcom/amazon/rio/j2me/client/util/Worker;->task:Ljava/lang/Runnable;

    invoke-interface {v3}, Ljava/lang/Runnable;->run()V
    :try_end_3
    .catch Ljava/lang/RuntimeException; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 223
    :cond_4
    iput-object v6, p0, Lcom/amazon/rio/j2me/client/util/Worker;->task:Ljava/lang/Runnable;

    .line 226
    const/4 v0, 0x1

    goto :goto_0

    .line 209
    :catchall_0
    move-exception v3

    :try_start_4
    monitor-exit v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    throw v3

    .line 216
    :catch_1
    move-exception v2

    .line 217
    .local v2, "re":Ljava/lang/RuntimeException;
    :try_start_5
    sget-object v3, Lcom/amazon/rio/j2me/client/util/Worker;->logger:Lcom/amazon/rio/j2me/client/util/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "uncaught RuntimeExceptiong: exception="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " thread="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/amazon/rio/j2me/client/util/Logger;->error(Ljava/lang/String;)V

    .line 218
    sget-object v3, Lcom/amazon/rio/j2me/client/util/Worker$State;->STOPPED:Lcom/amazon/rio/j2me/client/util/Worker$State;

    invoke-direct {p0, v3}, Lcom/amazon/rio/j2me/client/util/Worker;->setState(Lcom/amazon/rio/j2me/client/util/Worker$State;)V

    .line 219
    throw v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 223
    .end local v2    # "re":Ljava/lang/RuntimeException;
    :catchall_1
    move-exception v3

    iput-object v6, p0, Lcom/amazon/rio/j2me/client/util/Worker;->task:Ljava/lang/Runnable;

    throw v3
.end method

.method public stopWorker()Lcom/amazon/rio/j2me/client/util/Worker$State;
    .locals 3

    .prologue
    .line 141
    iget-object v2, p0, Lcom/amazon/rio/j2me/client/util/Worker;->lock:Ljava/lang/Object;

    monitor-enter v2

    .line 142
    :try_start_0
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/util/Worker;->state:Lcom/amazon/rio/j2me/client/util/Worker$State;

    .line 143
    .local v0, "prevState":Lcom/amazon/rio/j2me/client/util/Worker$State;
    sget-object v1, Lcom/amazon/rio/j2me/client/util/Worker$State;->STOPPED:Lcom/amazon/rio/j2me/client/util/Worker$State;

    invoke-direct {p0, v1}, Lcom/amazon/rio/j2me/client/util/Worker;->setState(Lcom/amazon/rio/j2me/client/util/Worker$State;)V

    .line 144
    monitor-exit v2

    return-object v0

    .line 145
    .end local v0    # "prevState":Lcom/amazon/rio/j2me/client/util/Worker$State;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 171
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 172
    .local v0, "sb":Ljava/lang/StringBuffer;
    const/16 v1, 0x5b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 173
    const-string/jumbo v1, "name="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/Worker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 174
    const-string/jumbo v1, " taskName="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/Worker;->getTaskName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 175
    const-string/jumbo v1, " state="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/Worker;->getWorkerState()Lcom/amazon/rio/j2me/client/util/Worker$State;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 176
    const/16 v1, 0x5d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 178
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
