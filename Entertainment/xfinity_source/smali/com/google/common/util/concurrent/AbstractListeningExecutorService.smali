.class abstract Lcom/google/common/util/concurrent/AbstractListeningExecutorService;
.super Ljava/lang/Object;
.source "AbstractListeningExecutorService.java"

# interfaces
.implements Lcom/google/common/util/concurrent/ListeningExecutorService;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private doInvokeAny(Ljava/util/Collection;ZJ)Ljava/lang/Object;
    .locals 23
    .param p2, "timed"    # Z
    .param p3, "nanos"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection",
            "<+",
            "Ljava/util/concurrent/Callable",
            "<TT;>;>;ZJ)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/ExecutionException;,
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    .line 65
    .local p1, "tasks":Ljava/util/Collection;, "Ljava/util/Collection<+Ljava/util/concurrent/Callable<TT;>;>;"
    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->size()I

    move-result v13

    .line 66
    .local v13, "ntasks":I
    if-lez v13, :cond_1

    const/16 v19, 0x1

    :goto_0
    invoke-static/range {v19 .. v19}, Lcom/google/common/base/Preconditions;->checkArgument(Z)V

    .line 67
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10, v13}, Ljava/util/ArrayList;-><init>(I)V

    .line 68
    .local v10, "futures":Ljava/util/List;, "Ljava/util/List<Ljava/util/concurrent/Future<TT;>;>;"
    new-instance v5, Ljava/util/concurrent/ExecutorCompletionService;

    move-object/from16 v0, p0

    invoke-direct {v5, v0}, Ljava/util/concurrent/ExecutorCompletionService;-><init>(Ljava/util/concurrent/Executor;)V

    .line 79
    .local v5, "ecs":Ljava/util/concurrent/ExecutorCompletionService;, "Ljava/util/concurrent/ExecutorCompletionService<TT;>;"
    const/4 v6, 0x0

    .line 80
    .local v6, "ee":Ljava/util/concurrent/ExecutionException;
    if-eqz p2, :cond_2

    :try_start_0
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v14

    .line 81
    .local v14, "lastTime":J
    :goto_1
    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v12

    .line 84
    .local v12, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<+Ljava/util/concurrent/Callable<TT;>;>;"
    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/util/concurrent/Callable;

    move-object/from16 v0, v19

    invoke-virtual {v5, v0}, Ljava/util/concurrent/ExecutorCompletionService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-interface {v10, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 85
    add-int/lit8 v13, v13, -0x1

    .line 86
    const/4 v4, 0x1

    .local v4, "active":I
    move-object v7, v6

    .line 89
    .end local v6    # "ee":Ljava/util/concurrent/ExecutionException;
    .local v7, "ee":Ljava/util/concurrent/ExecutionException;
    :goto_2
    :try_start_1
    invoke-virtual {v5}, Ljava/util/concurrent/ExecutorCompletionService;->poll()Ljava/util/concurrent/Future;

    move-result-object v9

    .line 90
    .local v9, "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    if-nez v9, :cond_0

    .line 91
    if-lez v13, :cond_3

    .line 92
    add-int/lit8 v13, v13, -0x1

    .line 93
    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/util/concurrent/Callable;

    move-object/from16 v0, v19

    invoke-virtual {v5, v0}, Ljava/util/concurrent/ExecutorCompletionService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-interface {v10, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 94
    add-int/lit8 v4, v4, 0x1

    .line 109
    :cond_0
    :goto_3
    if-eqz v9, :cond_a

    .line 110
    add-int/lit8 v4, v4, -0x1

    .line 112
    :try_start_2
    invoke-interface {v9}, Ljava/util/concurrent/Future;->get()Ljava/lang/Object;
    :try_end_2
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v19

    .line 126
    invoke-interface {v10}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .local v11, "i$":Ljava/util/Iterator;
    :goto_4
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_8

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    .end local v9    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    check-cast v9, Ljava/util/concurrent/Future;

    .line 127
    .restart local v9    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    const/16 v20, 0x1

    move/from16 v0, v20

    invoke-interface {v9, v0}, Ljava/util/concurrent/Future;->cancel(Z)Z

    goto :goto_4

    .line 66
    .end local v4    # "active":I
    .end local v5    # "ecs":Ljava/util/concurrent/ExecutorCompletionService;, "Ljava/util/concurrent/ExecutorCompletionService<TT;>;"
    .end local v7    # "ee":Ljava/util/concurrent/ExecutionException;
    .end local v9    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    .end local v10    # "futures":Ljava/util/List;, "Ljava/util/List<Ljava/util/concurrent/Future<TT;>;>;"
    .end local v11    # "i$":Ljava/util/Iterator;
    .end local v12    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<+Ljava/util/concurrent/Callable<TT;>;>;"
    .end local v14    # "lastTime":J
    :cond_1
    const/16 v19, 0x0

    goto :goto_0

    .line 80
    .restart local v5    # "ecs":Ljava/util/concurrent/ExecutorCompletionService;, "Ljava/util/concurrent/ExecutorCompletionService<TT;>;"
    .restart local v6    # "ee":Ljava/util/concurrent/ExecutionException;
    .restart local v10    # "futures":Ljava/util/List;, "Ljava/util/List<Ljava/util/concurrent/Future<TT;>;>;"
    :cond_2
    const-wide/16 v14, 0x0

    goto :goto_1

    .line 95
    .end local v6    # "ee":Ljava/util/concurrent/ExecutionException;
    .restart local v4    # "active":I
    .restart local v7    # "ee":Ljava/util/concurrent/ExecutionException;
    .restart local v9    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    .restart local v12    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<+Ljava/util/concurrent/Callable<TT;>;>;"
    .restart local v14    # "lastTime":J
    :cond_3
    if-nez v4, :cond_4

    .line 121
    if-nez v7, :cond_9

    .line 122
    :try_start_3
    new-instance v6, Ljava/util/concurrent/ExecutionException;

    const/16 v19, 0x0

    move-object/from16 v0, v19

    invoke-direct {v6, v0}, Ljava/util/concurrent/ExecutionException;-><init>(Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 124
    .end local v7    # "ee":Ljava/util/concurrent/ExecutionException;
    .restart local v6    # "ee":Ljava/util/concurrent/ExecutionException;
    :goto_5
    :try_start_4
    throw v6
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 126
    .end local v4    # "active":I
    .end local v9    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    .end local v12    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<+Ljava/util/concurrent/Callable<TT;>;>;"
    .end local v14    # "lastTime":J
    :catchall_0
    move-exception v19

    :goto_6
    invoke-interface {v10}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .restart local v11    # "i$":Ljava/util/Iterator;
    :goto_7
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_7

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/concurrent/Future;

    .line 127
    .restart local v9    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    const/16 v20, 0x1

    move/from16 v0, v20

    invoke-interface {v9, v0}, Ljava/util/concurrent/Future;->cancel(Z)Z

    goto :goto_7

    .line 97
    .end local v6    # "ee":Ljava/util/concurrent/ExecutionException;
    .end local v11    # "i$":Ljava/util/Iterator;
    .restart local v4    # "active":I
    .restart local v7    # "ee":Ljava/util/concurrent/ExecutionException;
    .restart local v12    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<+Ljava/util/concurrent/Callable<TT;>;>;"
    .restart local v14    # "lastTime":J
    :cond_4
    if-eqz p2, :cond_6

    .line 98
    :try_start_5
    sget-object v19, Ljava/util/concurrent/TimeUnit;->NANOSECONDS:Ljava/util/concurrent/TimeUnit;

    move-wide/from16 v0, p3

    move-object/from16 v2, v19

    invoke-virtual {v5, v0, v1, v2}, Ljava/util/concurrent/ExecutorCompletionService;->poll(JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/Future;

    move-result-object v9

    .line 99
    if-nez v9, :cond_5

    .line 100
    new-instance v19, Ljava/util/concurrent/TimeoutException;

    invoke-direct/range {v19 .. v19}, Ljava/util/concurrent/TimeoutException;-><init>()V

    throw v19

    .line 126
    .end local v9    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    :catchall_1
    move-exception v19

    move-object v6, v7

    .end local v7    # "ee":Ljava/util/concurrent/ExecutionException;
    .restart local v6    # "ee":Ljava/util/concurrent/ExecutionException;
    goto :goto_6

    .line 102
    .end local v6    # "ee":Ljava/util/concurrent/ExecutionException;
    .restart local v7    # "ee":Ljava/util/concurrent/ExecutionException;
    .restart local v9    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    :cond_5
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v16

    .line 103
    .local v16, "now":J
    sub-long v20, v16, v14

    sub-long p3, p3, v20

    .line 104
    move-wide/from16 v14, v16

    .line 105
    goto :goto_3

    .line 106
    .end local v16    # "now":J
    :cond_6
    invoke-virtual {v5}, Ljava/util/concurrent/ExecutorCompletionService;->take()Ljava/util/concurrent/Future;

    move-result-object v9

    goto :goto_3

    .line 113
    :catch_0
    move-exception v8

    .line 114
    .local v8, "eex":Ljava/util/concurrent/ExecutionException;
    move-object v6, v8

    .end local v7    # "ee":Ljava/util/concurrent/ExecutionException;
    .end local v8    # "eex":Ljava/util/concurrent/ExecutionException;
    .restart local v6    # "ee":Ljava/util/concurrent/ExecutionException;
    :goto_8
    move-object v7, v6

    .line 119
    .end local v6    # "ee":Ljava/util/concurrent/ExecutionException;
    .restart local v7    # "ee":Ljava/util/concurrent/ExecutionException;
    goto/16 :goto_2

    .line 115
    :catch_1
    move-exception v18

    .line 116
    .local v18, "rex":Ljava/lang/RuntimeException;
    new-instance v6, Ljava/util/concurrent/ExecutionException;

    move-object/from16 v0, v18

    invoke-direct {v6, v0}, Ljava/util/concurrent/ExecutionException;-><init>(Ljava/lang/Throwable;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .end local v7    # "ee":Ljava/util/concurrent/ExecutionException;
    .restart local v6    # "ee":Ljava/util/concurrent/ExecutionException;
    goto :goto_8

    .line 127
    .end local v4    # "active":I
    .end local v9    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    .end local v12    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<+Ljava/util/concurrent/Callable<TT;>;>;"
    .end local v14    # "lastTime":J
    .end local v18    # "rex":Ljava/lang/RuntimeException;
    .restart local v11    # "i$":Ljava/util/Iterator;
    :cond_7
    throw v19

    .end local v6    # "ee":Ljava/util/concurrent/ExecutionException;
    .restart local v4    # "active":I
    .restart local v7    # "ee":Ljava/util/concurrent/ExecutionException;
    .restart local v9    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    .restart local v12    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<+Ljava/util/concurrent/Callable<TT;>;>;"
    .restart local v14    # "lastTime":J
    :cond_8
    return-object v19

    .end local v11    # "i$":Ljava/util/Iterator;
    :cond_9
    move-object v6, v7

    .end local v7    # "ee":Ljava/util/concurrent/ExecutionException;
    .restart local v6    # "ee":Ljava/util/concurrent/ExecutionException;
    goto :goto_5

    .end local v6    # "ee":Ljava/util/concurrent/ExecutionException;
    .restart local v7    # "ee":Ljava/util/concurrent/ExecutionException;
    :cond_a
    move-object v6, v7

    .end local v7    # "ee":Ljava/util/concurrent/ExecutionException;
    .restart local v6    # "ee":Ljava/util/concurrent/ExecutionException;
    goto :goto_8
.end method


# virtual methods
.method public invokeAll(Ljava/util/Collection;)Ljava/util/List;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection",
            "<+",
            "Ljava/util/concurrent/Callable",
            "<TT;>;>;)",
            "Ljava/util/List",
            "<",
            "Ljava/util/concurrent/Future",
            "<TT;>;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .local p1, "tasks":Ljava/util/Collection;, "Ljava/util/Collection<+Ljava/util/concurrent/Callable<TT;>;>;"
    const/4 v8, 0x1

    .line 149
    if-nez p1, :cond_0

    .line 150
    new-instance v6, Ljava/lang/NullPointerException;

    invoke-direct {v6}, Ljava/lang/NullPointerException;-><init>()V

    throw v6

    .line 152
    :cond_0
    new-instance v3, Ljava/util/ArrayList;

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v6

    invoke-direct {v3, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 153
    .local v3, "futures":Ljava/util/List;, "Ljava/util/List<Ljava/util/concurrent/Future<TT;>;>;"
    const/4 v0, 0x0

    .line 155
    .local v0, "done":Z
    :try_start_0
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/concurrent/Callable;

    .line 156
    .local v5, "t":Ljava/util/concurrent/Callable;, "Ljava/util/concurrent/Callable<TT;>;"
    invoke-static {v5}, Lcom/google/common/util/concurrent/ListenableFutureTask;->create(Ljava/util/concurrent/Callable;)Lcom/google/common/util/concurrent/ListenableFutureTask;

    move-result-object v1

    .line 157
    .local v1, "f":Lcom/google/common/util/concurrent/ListenableFutureTask;, "Lcom/google/common/util/concurrent/ListenableFutureTask<TT;>;"
    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 158
    invoke-virtual {p0, v1}, Lcom/google/common/util/concurrent/AbstractListeningExecutorService;->execute(Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 172
    .end local v1    # "f":Lcom/google/common/util/concurrent/ListenableFutureTask;, "Lcom/google/common/util/concurrent/ListenableFutureTask<TT;>;"
    .end local v4    # "i$":Ljava/util/Iterator;
    .end local v5    # "t":Ljava/util/concurrent/Callable;, "Ljava/util/concurrent/Callable<TT;>;"
    :catchall_0
    move-exception v6

    if-nez v0, :cond_4

    .line 173
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .restart local v4    # "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/concurrent/Future;

    .line 174
    .local v2, "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    invoke-interface {v2, v8}, Ljava/util/concurrent/Future;->cancel(Z)Z

    goto :goto_1

    .line 160
    .end local v2    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    :cond_1
    :try_start_1
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_2
    :goto_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/concurrent/Future;

    .line 161
    .restart local v2    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    invoke-interface {v2}, Ljava/util/concurrent/Future;->isDone()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v6

    if-nez v6, :cond_2

    .line 163
    :try_start_2
    invoke-interface {v2}, Ljava/util/concurrent/Future;->get()Ljava/lang/Object;
    :try_end_2
    .catch Ljava/util/concurrent/CancellationException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    .line 164
    :catch_0
    move-exception v6

    goto :goto_2

    .line 169
    .end local v2    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    :cond_3
    const/4 v0, 0x1

    .line 172
    if-nez v0, :cond_5

    .line 173
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_3
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_5

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/concurrent/Future;

    .line 174
    .restart local v2    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    invoke-interface {v2, v8}, Ljava/util/concurrent/Future;->cancel(Z)Z

    goto :goto_3

    .end local v2    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    .end local v4    # "i$":Ljava/util/Iterator;
    :cond_4
    throw v6

    .line 165
    .restart local v2    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    .restart local v4    # "i$":Ljava/util/Iterator;
    :catch_1
    move-exception v6

    goto :goto_2

    .line 174
    .end local v2    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    :cond_5
    return-object v3
.end method

.method public invokeAll(Ljava/util/Collection;JLjava/util/concurrent/TimeUnit;)Ljava/util/List;
    .locals 20
    .param p2, "timeout"    # J
    .param p4, "unit"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection",
            "<+",
            "Ljava/util/concurrent/Callable",
            "<TT;>;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/util/concurrent/Future",
            "<TT;>;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 183
    .local p1, "tasks":Ljava/util/Collection;, "Ljava/util/Collection<+Ljava/util/concurrent/Callable<TT;>;>;"
    if-eqz p1, :cond_0

    if-nez p4, :cond_1

    .line 184
    :cond_0
    new-instance v17, Ljava/lang/NullPointerException;

    invoke-direct/range {v17 .. v17}, Ljava/lang/NullPointerException;-><init>()V

    throw v17

    .line 186
    :cond_1
    move-object/from16 v0, p4

    move-wide/from16 v1, p2

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/TimeUnit;->toNanos(J)J

    move-result-wide v12

    .line 187
    .local v12, "nanos":J
    new-instance v6, Ljava/util/ArrayList;

    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->size()I

    move-result v17

    move/from16 v0, v17

    invoke-direct {v6, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 188
    .local v6, "futures":Ljava/util/List;, "Ljava/util/List<Ljava/util/concurrent/Future<TT;>;>;"
    const/4 v4, 0x0

    .line 190
    .local v4, "done":Z
    :try_start_0
    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_2

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/concurrent/Callable;

    .line 191
    .local v9, "t":Ljava/util/concurrent/Callable;, "Ljava/util/concurrent/Callable<TT;>;"
    invoke-static {v9}, Lcom/google/common/util/concurrent/ListenableFutureTask;->create(Ljava/util/concurrent/Callable;)Lcom/google/common/util/concurrent/ListenableFutureTask;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-interface {v6, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 229
    .end local v7    # "i$":Ljava/util/Iterator;
    .end local v9    # "t":Ljava/util/concurrent/Callable;, "Ljava/util/concurrent/Callable<TT;>;"
    :catchall_0
    move-exception v17

    if-nez v4, :cond_8

    .line 230
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .restart local v7    # "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v18

    if-eqz v18, :cond_8

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/concurrent/Future;

    .line 231
    .local v5, "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    const/16 v18, 0x1

    move/from16 v0, v18

    invoke-interface {v5, v0}, Ljava/util/concurrent/Future;->cancel(Z)Z

    goto :goto_1

    .line 194
    .end local v5    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    :cond_2
    :try_start_1
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v10

    .line 198
    .local v10, "lastTime":J
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .line 199
    .local v8, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/concurrent/Future<TT;>;>;"
    :cond_3
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_4

    .line 200
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/Runnable;

    check-cast v17, Ljava/lang/Runnable;

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/google/common/util/concurrent/AbstractListeningExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 201
    invoke-static {}, Ljava/lang/System;->nanoTime()J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-wide v14

    .line 202
    .local v14, "now":J
    sub-long v18, v14, v10

    sub-long v12, v12, v18

    .line 203
    move-wide v10, v14

    .line 204
    const-wide/16 v18, 0x0

    cmp-long v17, v12, v18

    if-gtz v17, :cond_3

    .line 229
    if-nez v4, :cond_9

    .line 230
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_2
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_9

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/concurrent/Future;

    .line 231
    .restart local v5    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    const/16 v17, 0x1

    move/from16 v0, v17

    invoke-interface {v5, v0}, Ljava/util/concurrent/Future;->cancel(Z)Z

    goto :goto_2

    .line 209
    .end local v5    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    .end local v14    # "now":J
    :cond_4
    :try_start_2
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_5
    :goto_3
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_7

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/concurrent/Future;

    .line 210
    .restart local v5    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    invoke-interface {v5}, Ljava/util/concurrent/Future;->isDone()Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result v17

    if-nez v17, :cond_5

    .line 211
    const-wide/16 v18, 0x0

    cmp-long v17, v12, v18

    if-gtz v17, :cond_6

    .line 229
    if-nez v4, :cond_9

    .line 230
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_4
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_9

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    .end local v5    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    check-cast v5, Ljava/util/concurrent/Future;

    .line 231
    .restart local v5    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    const/16 v17, 0x1

    move/from16 v0, v17

    invoke-interface {v5, v0}, Ljava/util/concurrent/Future;->cancel(Z)Z

    goto :goto_4

    .line 215
    :cond_6
    :try_start_3
    sget-object v17, Ljava/util/concurrent/TimeUnit;->NANOSECONDS:Ljava/util/concurrent/TimeUnit;

    move-object/from16 v0, v17

    invoke-interface {v5, v12, v13, v0}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    :try_end_3
    .catch Ljava/util/concurrent/CancellationException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 221
    :goto_5
    :try_start_4
    invoke-static {}, Ljava/lang/System;->nanoTime()J
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-result-wide v14

    .line 222
    .restart local v14    # "now":J
    sub-long v18, v14, v10

    sub-long v12, v12, v18

    .line 223
    move-wide v10, v14

    goto :goto_3

    .line 218
    .end local v14    # "now":J
    :catch_0
    move-exception v16

    .line 229
    .local v16, "toe":Ljava/util/concurrent/TimeoutException;
    if-nez v4, :cond_9

    .line 230
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_6
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_9

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    .end local v5    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    check-cast v5, Ljava/util/concurrent/Future;

    .line 231
    .restart local v5    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    const/16 v17, 0x1

    move/from16 v0, v17

    invoke-interface {v5, v0}, Ljava/util/concurrent/Future;->cancel(Z)Z

    goto :goto_6

    .line 226
    .end local v5    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    .end local v16    # "toe":Ljava/util/concurrent/TimeoutException;
    :cond_7
    const/4 v4, 0x1

    .line 229
    if-nez v4, :cond_9

    .line 230
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_7
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_9

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/concurrent/Future;

    .line 231
    .restart local v5    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    const/16 v17, 0x1

    move/from16 v0, v17

    invoke-interface {v5, v0}, Ljava/util/concurrent/Future;->cancel(Z)Z

    goto :goto_7

    .end local v5    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    .end local v7    # "i$":Ljava/util/Iterator;
    .end local v8    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/concurrent/Future<TT;>;>;"
    .end local v10    # "lastTime":J
    :cond_8
    throw v17

    .restart local v7    # "i$":Ljava/util/Iterator;
    .restart local v8    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/concurrent/Future<TT;>;>;"
    .restart local v10    # "lastTime":J
    :cond_9
    return-object v6

    .line 217
    .restart local v5    # "f":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<TT;>;"
    :catch_1
    move-exception v17

    goto :goto_5

    .line 216
    :catch_2
    move-exception v17

    goto :goto_5
.end method

.method public invokeAny(Ljava/util/Collection;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection",
            "<+",
            "Ljava/util/concurrent/Callable",
            "<TT;>;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/ExecutionException;
        }
    .end annotation

    .prologue
    .line 135
    .local p1, "tasks":Ljava/util/Collection;, "Ljava/util/Collection<+Ljava/util/concurrent/Callable<TT;>;>;"
    const/4 v1, 0x0

    const-wide/16 v2, 0x0

    :try_start_0
    invoke-direct {p0, p1, v1, v2, v3}, Lcom/google/common/util/concurrent/AbstractListeningExecutorService;->doInvokeAny(Ljava/util/Collection;ZJ)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    .line 136
    :catch_0
    move-exception v0

    .line 137
    .local v0, "cannotHappen":Ljava/util/concurrent/TimeoutException;
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1}, Ljava/lang/AssertionError;-><init>()V

    throw v1
.end method

.method public invokeAny(Ljava/util/Collection;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    .locals 4
    .param p2, "timeout"    # J
    .param p4, "unit"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection",
            "<+",
            "Ljava/util/concurrent/Callable",
            "<TT;>;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/ExecutionException;,
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    .line 144
    .local p1, "tasks":Ljava/util/Collection;, "Ljava/util/Collection<+Ljava/util/concurrent/Callable<TT;>;>;"
    const/4 v0, 0x1

    invoke-virtual {p4, p2, p3}, Ljava/util/concurrent/TimeUnit;->toNanos(J)J

    move-result-wide v2

    invoke-direct {p0, p1, v0, v2, v3}, Lcom/google/common/util/concurrent/AbstractListeningExecutorService;->doInvokeAny(Ljava/util/Collection;ZJ)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public submit(Ljava/lang/Runnable;)Lcom/google/common/util/concurrent/ListenableFuture;
    .locals 2
    .param p1, "task"    # Ljava/lang/Runnable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Runnable;",
            ")",
            "Lcom/google/common/util/concurrent/ListenableFuture",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 43
    const/4 v1, 0x0

    invoke-static {p1, v1}, Lcom/google/common/util/concurrent/ListenableFutureTask;->create(Ljava/lang/Runnable;Ljava/lang/Object;)Lcom/google/common/util/concurrent/ListenableFutureTask;

    move-result-object v0

    .line 44
    .local v0, "ftask":Lcom/google/common/util/concurrent/ListenableFutureTask;, "Lcom/google/common/util/concurrent/ListenableFutureTask<Ljava/lang/Void;>;"
    invoke-virtual {p0, v0}, Lcom/google/common/util/concurrent/AbstractListeningExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 45
    return-object v0
.end method

.method public submit(Ljava/lang/Runnable;Ljava/lang/Object;)Lcom/google/common/util/concurrent/ListenableFuture;
    .locals 1
    .param p1, "task"    # Ljava/lang/Runnable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Runnable;",
            "TT;)",
            "Lcom/google/common/util/concurrent/ListenableFuture",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 49
    .local p2, "result":Ljava/lang/Object;, "TT;"
    invoke-static {p1, p2}, Lcom/google/common/util/concurrent/ListenableFutureTask;->create(Ljava/lang/Runnable;Ljava/lang/Object;)Lcom/google/common/util/concurrent/ListenableFutureTask;

    move-result-object v0

    .line 50
    .local v0, "ftask":Lcom/google/common/util/concurrent/ListenableFutureTask;, "Lcom/google/common/util/concurrent/ListenableFutureTask<TT;>;"
    invoke-virtual {p0, v0}, Lcom/google/common/util/concurrent/AbstractListeningExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 51
    return-object v0
.end method

.method public submit(Ljava/util/concurrent/Callable;)Lcom/google/common/util/concurrent/ListenableFuture;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/concurrent/Callable",
            "<TT;>;)",
            "Lcom/google/common/util/concurrent/ListenableFuture",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 55
    .local p1, "task":Ljava/util/concurrent/Callable;, "Ljava/util/concurrent/Callable<TT;>;"
    invoke-static {p1}, Lcom/google/common/util/concurrent/ListenableFutureTask;->create(Ljava/util/concurrent/Callable;)Lcom/google/common/util/concurrent/ListenableFutureTask;

    move-result-object v0

    .line 56
    .local v0, "ftask":Lcom/google/common/util/concurrent/ListenableFutureTask;, "Lcom/google/common/util/concurrent/ListenableFutureTask<TT;>;"
    invoke-virtual {p0, v0}, Lcom/google/common/util/concurrent/AbstractListeningExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 57
    return-object v0
.end method

.method public bridge synthetic submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Runnable;

    .prologue
    .line 41
    invoke-virtual {p0, p1}, Lcom/google/common/util/concurrent/AbstractListeningExecutorService;->submit(Ljava/lang/Runnable;)Lcom/google/common/util/concurrent/ListenableFuture;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic submit(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurrent/Future;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Runnable;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 41
    invoke-virtual {p0, p1, p2}, Lcom/google/common/util/concurrent/AbstractListeningExecutorService;->submit(Ljava/lang/Runnable;Ljava/lang/Object;)Lcom/google/common/util/concurrent/ListenableFuture;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    .locals 1
    .param p1, "x0"    # Ljava/util/concurrent/Callable;

    .prologue
    .line 41
    invoke-virtual {p0, p1}, Lcom/google/common/util/concurrent/AbstractListeningExecutorService;->submit(Ljava/util/concurrent/Callable;)Lcom/google/common/util/concurrent/ListenableFuture;

    move-result-object v0

    return-object v0
.end method
