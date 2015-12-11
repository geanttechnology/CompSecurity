.class public final Lcom/a/a/a/b/q;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Closeable;


# static fields
.field static final a:Ljava/util/concurrent/ExecutorService;

.field static final synthetic g:Z


# instance fields
.field final b:Lcom/a/a/a/b/aa;

.field final c:Z

.field public final d:Lcom/a/a/a/b/d;

.field final e:Ljava/lang/String;

.field f:Lcom/a/a/a/b/k;

.field private final h:Lcom/a/a/a/b/h;

.field private final i:Lcom/a/a/a/b/b;

.field private final j:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/a/a/a/b/x;",
            ">;"
        }
    .end annotation
.end field

.field private k:I

.field private l:I

.field private m:Z

.field private n:J

.field private o:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/a/a/a/b/j;",
            ">;"
        }
    .end annotation
.end field

.field private p:I


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v2, 0x0

    .line 44
    const-class v0, Lcom/a/a/a/b/q;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/a/a/a/b/q;->g:Z

    .line 58
    new-instance v1, Ljava/util/concurrent/ThreadPoolExecutor;

    const v3, 0x7fffffff

    const-wide/16 v4, 0x3c

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Ljava/util/concurrent/SynchronousQueue;

    invoke-direct {v7}, Ljava/util/concurrent/SynchronousQueue;-><init>()V

    const-string v0, "OkHttp SpdyConnection"

    invoke-static {v0}, Lcom/a/a/a/u;->b(Ljava/lang/String;)Ljava/util/concurrent/ThreadFactory;

    move-result-object v8

    invoke-direct/range {v1 .. v8}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V

    sput-object v1, Lcom/a/a/a/b/q;->a:Ljava/util/concurrent/ExecutorService;

    return-void

    :cond_0
    move v0, v2

    .line 44
    goto :goto_0
.end method

.method private constructor <init>(Lcom/a/a/a/b/u;)V
    .locals 6

    .prologue
    const/4 v2, 0x2

    const/4 v1, 0x1

    .line 90
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 76
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/a/a/a/b/q;->j:Ljava/util/Map;

    .line 81
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/a/a/a/b/q;->n:J

    .line 91
    iget-object v0, p1, Lcom/a/a/a/b/u;->e:Lcom/a/a/a/b/aa;

    iput-object v0, p0, Lcom/a/a/a/b/q;->b:Lcom/a/a/a/b/aa;

    .line 92
    iget-boolean v0, p1, Lcom/a/a/a/b/u;->f:Z

    iput-boolean v0, p0, Lcom/a/a/a/b/q;->c:Z

    .line 93
    iget-object v0, p1, Lcom/a/a/a/b/u;->d:Lcom/a/a/a/b/h;

    iput-object v0, p0, Lcom/a/a/a/b/q;->h:Lcom/a/a/a/b/h;

    .line 94
    iget-object v0, p0, Lcom/a/a/a/b/q;->b:Lcom/a/a/a/b/aa;

    iget-object v3, p1, Lcom/a/a/a/b/u;->b:Ljava/io/InputStream;

    iget-boolean v4, p0, Lcom/a/a/a/b/q;->c:Z

    invoke-interface {v0, v3, v4}, Lcom/a/a/a/b/aa;->a(Ljava/io/InputStream;Z)Lcom/a/a/a/b/b;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/a/b/q;->i:Lcom/a/a/a/b/b;

    .line 95
    iget-object v0, p0, Lcom/a/a/a/b/q;->b:Lcom/a/a/a/b/aa;

    iget-object v3, p1, Lcom/a/a/a/b/u;->c:Ljava/io/OutputStream;

    iget-boolean v4, p0, Lcom/a/a/a/b/q;->c:Z

    invoke-interface {v0, v3, v4}, Lcom/a/a/a/b/aa;->a(Ljava/io/OutputStream;Z)Lcom/a/a/a/b/d;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/a/b/q;->d:Lcom/a/a/a/b/d;

    .line 96
    iget-boolean v0, p1, Lcom/a/a/a/b/u;->f:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    iput v0, p0, Lcom/a/a/a/b/q;->l:I

    .line 97
    iget-boolean v0, p1, Lcom/a/a/a/b/u;->f:Z

    if-eqz v0, :cond_1

    :goto_1
    iput v1, p0, Lcom/a/a/a/b/q;->p:I

    .line 99
    iget-object v0, p1, Lcom/a/a/a/b/u;->a:Ljava/lang/String;

    iput-object v0, p0, Lcom/a/a/a/b/q;->e:Ljava/lang/String;

    .line 101
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/a/a/a/b/v;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/a/a/a/b/v;-><init>(Lcom/a/a/a/b/q;B)V

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Spdy Reader "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/a/a/a/b/q;->e:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 102
    return-void

    :cond_0
    move v0, v2

    .line 96
    goto :goto_0

    :cond_1
    move v1, v2

    .line 97
    goto :goto_1
.end method

.method public synthetic constructor <init>(Lcom/a/a/a/b/u;B)V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0, p1}, Lcom/a/a/a/b/q;-><init>(Lcom/a/a/a/b/u;)V

    return-void
.end method

.method static synthetic a(Lcom/a/a/a/b/q;)Lcom/a/a/a/b/b;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/a/a/a/b/q;->i:Lcom/a/a/a/b/b;

    return-object v0
.end method

.method static synthetic a(Lcom/a/a/a/b/q;I)Lcom/a/a/a/b/x;
    .locals 1

    .prologue
    .line 44
    invoke-direct {p0, p1}, Lcom/a/a/a/b/q;->b(I)Lcom/a/a/a/b/x;

    move-result-object v0

    return-object v0
.end method

.method private a(Lcom/a/a/a/b/a;Lcom/a/a/a/b/a;)V
    .locals 12

    .prologue
    const-wide/16 v10, -0x1

    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 302
    sget-boolean v0, Lcom/a/a/a/b/q;->g:Z

    if-nez v0, :cond_0

    invoke-static {p0}, Ljava/lang/Thread;->holdsLock(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 305
    :cond_0
    :try_start_0
    iget-object v1, p0, Lcom/a/a/a/b/q;->d:Lcom/a/a/a/b/d;

    monitor-enter v1
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    monitor-enter p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :try_start_2
    iget-boolean v0, p0, Lcom/a/a/a/b/q;->m:Z

    if-eqz v0, :cond_2

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-object v1, v2

    .line 312
    :goto_0
    monitor-enter p0

    .line 313
    :try_start_4
    iget-object v0, p0, Lcom/a/a/a/b/q;->j:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_b

    .line 314
    iget-object v0, p0, Lcom/a/a/a/b/q;->j:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    iget-object v4, p0, Lcom/a/a/a/b/q;->j:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->size()I

    move-result v4

    new-array v4, v4, [Lcom/a/a/a/b/x;

    invoke-interface {v0, v4}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/a/a/a/b/x;

    .line 315
    iget-object v4, p0, Lcom/a/a/a/b/q;->j:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->clear()V

    .line 316
    const/4 v4, 0x0

    invoke-direct {p0, v4}, Lcom/a/a/a/b/q;->a(Z)V

    move-object v5, v0

    .line 318
    :goto_1
    iget-object v0, p0, Lcom/a/a/a/b/q;->o:Ljava/util/Map;

    if-eqz v0, :cond_a

    .line 319
    iget-object v0, p0, Lcom/a/a/a/b/q;->o:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    iget-object v2, p0, Lcom/a/a/a/b/q;->o:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->size()I

    move-result v2

    new-array v2, v2, [Lcom/a/a/a/b/j;

    invoke-interface {v0, v2}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/a/a/a/b/j;

    .line 320
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/a/a/a/b/q;->o:Ljava/util/Map;

    move-object v4, v0

    .line 322
    :goto_2
    monitor-exit p0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 324
    if-eqz v5, :cond_4

    .line 325
    array-length v6, v5

    move v2, v3

    move-object v0, v1

    :goto_3
    if-ge v2, v6, :cond_3

    aget-object v1, v5, v2

    .line 327
    :try_start_5
    invoke-virtual {v1, p2}, Lcom/a/a/a/b/x;->a(Lcom/a/a/a/b/a;)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1

    .line 325
    :cond_1
    :goto_4
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_3

    .line 305
    :cond_2
    const/4 v0, 0x1

    :try_start_6
    iput-boolean v0, p0, Lcom/a/a/a/b/q;->m:Z

    iget v0, p0, Lcom/a/a/a/b/q;->k:I

    monitor-exit p0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    :try_start_7
    iget-object v4, p0, Lcom/a/a/a/b/q;->d:Lcom/a/a/a/b/d;

    invoke-interface {v4, v0, p1}, Lcom/a/a/a/b/d;->b(ILcom/a/a/a/b/a;)V

    monitor-exit v1
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    move-object v1, v2

    goto :goto_0

    :catchall_0
    move-exception v0

    :try_start_8
    monitor-exit p0
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    :try_start_9
    throw v0

    :catchall_1
    move-exception v0

    monitor-exit v1
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    :try_start_a
    throw v0
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_0

    .line 308
    :catch_0
    move-exception v0

    move-object v1, v0

    goto :goto_0

    .line 322
    :catchall_2
    move-exception v0

    :try_start_b
    monitor-exit p0
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_2

    throw v0

    .line 328
    :catch_1
    move-exception v1

    .line 329
    if-eqz v0, :cond_1

    move-object v0, v1

    goto :goto_4

    :cond_3
    move-object v1, v0

    .line 334
    :cond_4
    if-eqz v4, :cond_7

    .line 335
    array-length v2, v4

    move v0, v3

    :goto_5
    if-ge v0, v2, :cond_7

    aget-object v3, v4, v0

    .line 336
    iget-wide v6, v3, Lcom/a/a/a/b/j;->c:J

    cmp-long v5, v6, v10

    if-nez v5, :cond_5

    iget-wide v6, v3, Lcom/a/a/a/b/j;->b:J

    cmp-long v5, v6, v10

    if-nez v5, :cond_6

    :cond_5
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    :cond_6
    iget-wide v6, v3, Lcom/a/a/a/b/j;->b:J

    const-wide/16 v8, 0x1

    sub-long/2addr v6, v8

    iput-wide v6, v3, Lcom/a/a/a/b/j;->c:J

    iget-object v3, v3, Lcom/a/a/a/b/j;->a:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v3}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 335
    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    .line 341
    :cond_7
    :try_start_c
    iget-object v0, p0, Lcom/a/a/a/b/q;->i:Lcom/a/a/a/b/b;

    invoke-interface {v0}, Lcom/a/a/a/b/b;->close()V
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_c} :catch_2

    .line 346
    :goto_6
    :try_start_d
    iget-object v0, p0, Lcom/a/a/a/b/q;->d:Lcom/a/a/a/b/d;

    invoke-interface {v0}, Lcom/a/a/a/b/d;->close()V
    :try_end_d
    .catch Ljava/io/IOException; {:try_start_d .. :try_end_d} :catch_3

    move-object v0, v1

    .line 351
    :cond_8
    :goto_7
    if-eqz v0, :cond_9

    throw v0

    .line 342
    :catch_2
    move-exception v0

    move-object v1, v0

    goto :goto_6

    .line 347
    :catch_3
    move-exception v0

    .line 348
    if-eqz v1, :cond_8

    move-object v0, v1

    goto :goto_7

    .line 352
    :cond_9
    return-void

    :cond_a
    move-object v4, v2

    goto :goto_2

    :cond_b
    move-object v5, v2

    goto/16 :goto_1
.end method

.method static synthetic a(Lcom/a/a/a/b/q;II)V
    .locals 7

    .prologue
    .line 44
    sget-object v6, Lcom/a/a/a/b/q;->a:Ljava/util/concurrent/ExecutorService;

    new-instance v0, Lcom/a/a/a/b/t;

    const-string v2, "OkHttp SPDY Writer %s ping %08x%08x"

    const/4 v1, 0x3

    new-array v3, v1, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v4, p0, Lcom/a/a/a/b/q;->e:Ljava/lang/String;

    aput-object v4, v3, v1

    const/4 v1, 0x1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v1

    const/4 v1, 0x2

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v1

    move-object v1, p0

    move v4, p1

    move v5, p2

    invoke-direct/range {v0 .. v5}, Lcom/a/a/a/b/t;-><init>(Lcom/a/a/a/b/q;Ljava/lang/String;[Ljava/lang/Object;II)V

    invoke-interface {v6, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    return-void
.end method

.method static synthetic a(Lcom/a/a/a/b/q;Lcom/a/a/a/b/a;Lcom/a/a/a/b/a;)V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0, p1, p2}, Lcom/a/a/a/b/q;->a(Lcom/a/a/a/b/a;Lcom/a/a/a/b/a;)V

    return-void
.end method

.method static synthetic a(Lcom/a/a/a/b/q;ZILcom/a/a/a/b/j;)V
    .locals 6

    .prologue
    .line 44
    iget-object v1, p0, Lcom/a/a/a/b/q;->d:Lcom/a/a/a/b/d;

    monitor-enter v1

    if-eqz p3, :cond_1

    :try_start_0
    iget-wide v2, p3, Lcom/a/a/a/b/j;->b:J

    const-wide/16 v4, -0x1

    cmp-long v0, v2, v4

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_0
    :try_start_1
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    iput-wide v2, p3, Lcom/a/a/a/b/j;->b:J

    :cond_1
    iget-object v0, p0, Lcom/a/a/a/b/q;->d:Lcom/a/a/a/b/d;

    invoke-interface {v0, p1, p2}, Lcom/a/a/a/b/d;->a(ZI)V

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-void
.end method

.method private declared-synchronized a(Z)V
    .locals 2

    .prologue
    .line 125
    monitor-enter p0

    if-eqz p1, :cond_0

    :try_start_0
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    :goto_0
    iput-wide v0, p0, Lcom/a/a/a/b/q;->n:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 126
    monitor-exit p0

    return-void

    .line 125
    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method static synthetic b(Lcom/a/a/a/b/q;I)I
    .locals 0

    .prologue
    .line 44
    iput p1, p0, Lcom/a/a/a/b/q;->k:I

    return p1
.end method

.method private declared-synchronized b(I)Lcom/a/a/a/b/x;
    .locals 2

    .prologue
    .line 113
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/b/q;->j:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/a/a/b/x;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method static synthetic b(Lcom/a/a/a/b/q;)Z
    .locals 1

    .prologue
    .line 44
    iget-boolean v0, p0, Lcom/a/a/a/b/q;->m:Z

    return v0
.end method

.method private declared-synchronized c(I)Lcom/a/a/a/b/j;
    .locals 2

    .prologue
    .line 260
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/b/q;->o:Ljava/util/Map;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/a/a/a/b/q;->o:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/a/a/b/j;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :goto_0
    monitor-exit p0

    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method static synthetic c(Lcom/a/a/a/b/q;I)Lcom/a/a/a/b/j;
    .locals 1

    .prologue
    .line 44
    invoke-direct {p0, p1}, Lcom/a/a/a/b/q;->c(I)Lcom/a/a/a/b/j;

    move-result-object v0

    return-object v0
.end method

.method static synthetic c(Lcom/a/a/a/b/q;)Ljava/util/Map;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/a/a/a/b/q;->j:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic d(Lcom/a/a/a/b/q;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/a/a/a/b/q;->e:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic d()Ljava/util/concurrent/ExecutorService;
    .locals 1

    .prologue
    .line 44
    sget-object v0, Lcom/a/a/a/b/q;->a:Ljava/util/concurrent/ExecutorService;

    return-object v0
.end method

.method static synthetic e(Lcom/a/a/a/b/q;)Lcom/a/a/a/b/h;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/a/a/a/b/q;->h:Lcom/a/a/a/b/h;

    return-object v0
.end method

.method static synthetic f(Lcom/a/a/a/b/q;)Z
    .locals 1

    .prologue
    .line 44
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/a/b/q;->m:Z

    return v0
.end method


# virtual methods
.method final declared-synchronized a(I)Lcom/a/a/a/b/x;
    .locals 2

    .prologue
    .line 117
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/b/q;->j:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/a/a/b/x;

    .line 118
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/a/a/a/b/q;->j:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 119
    const/4 v1, 0x1

    invoke-direct {p0, v1}, Lcom/a/a/a/b/q;->a(Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 121
    :cond_0
    monitor-exit p0

    return-object v0

    .line 117
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final a(Ljava/util/List;Z)Lcom/a/a/a/b/x;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;Z)",
            "Lcom/a/a/a/b/x;"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 148
    if-nez p2, :cond_0

    const/4 v3, 0x1

    .line 149
    :cond_0
    iget-object v9, p0, Lcom/a/a/a/b/q;->d:Lcom/a/a/a/b/d;

    monitor-enter v9

    .line 157
    :try_start_0
    monitor-enter p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 158
    :try_start_1
    iget-boolean v0, p0, Lcom/a/a/a/b/q;->m:Z

    if-eqz v0, :cond_1

    .line 159
    new-instance v0, Ljava/io/IOException;

    const-string v1, "shutdown"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 169
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v0

    .line 173
    :catchall_1
    move-exception v0

    monitor-exit v9
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v0

    .line 161
    :cond_1
    :try_start_3
    iget v1, p0, Lcom/a/a/a/b/q;->l:I

    .line 162
    iget v0, p0, Lcom/a/a/a/b/q;->l:I

    add-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/a/a/a/b/q;->l:I

    .line 163
    new-instance v0, Lcom/a/a/a/b/x;

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    iget-object v8, p0, Lcom/a/a/a/b/q;->f:Lcom/a/a/a/b/k;

    move-object v2, p0

    move-object v7, p1

    invoke-direct/range {v0 .. v8}, Lcom/a/a/a/b/x;-><init>(ILcom/a/a/a/b/q;ZZIILjava/util/List;Lcom/a/a/a/b/k;)V

    .line 165
    invoke-virtual {v0}, Lcom/a/a/a/b/x;->a()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 166
    iget-object v2, p0, Lcom/a/a/a/b/q;->j:Ljava/util/Map;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v2, v4, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 167
    const/4 v2, 0x0

    invoke-direct {p0, v2}, Lcom/a/a/a/b/q;->a(Z)V

    .line 169
    :cond_2
    monitor-exit p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 171
    :try_start_4
    iget-object v2, p0, Lcom/a/a/a/b/q;->d:Lcom/a/a/a/b/d;

    invoke-interface {v2, v3, v1, p1}, Lcom/a/a/a/b/d;->a(ZILjava/util/List;)V

    .line 173
    monitor-exit v9
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 175
    return-object v0
.end method

.method final a(ILcom/a/a/a/b/a;)V
    .locals 7

    .prologue
    .line 189
    sget-object v6, Lcom/a/a/a/b/q;->a:Ljava/util/concurrent/ExecutorService;

    new-instance v0, Lcom/a/a/a/b/r;

    const-string v2, "OkHttp SPDY Writer %s stream %d"

    const/4 v1, 0x2

    new-array v3, v1, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v4, p0, Lcom/a/a/a/b/q;->e:Ljava/lang/String;

    aput-object v4, v3, v1

    const/4 v1, 0x1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v1

    move-object v1, p0

    move v4, p1

    move-object v5, p2

    invoke-direct/range {v0 .. v5}, Lcom/a/a/a/b/r;-><init>(Lcom/a/a/a/b/q;Ljava/lang/String;[Ljava/lang/Object;ILcom/a/a/a/b/a;)V

    invoke-interface {v6, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    .line 197
    return-void
.end method

.method public final declared-synchronized a()Z
    .locals 4

    .prologue
    .line 130
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/a/a/a/b/q;->n:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized b()J
    .locals 2

    .prologue
    .line 135
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/a/a/a/b/q;->n:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method final b(ILcom/a/a/a/b/a;)V
    .locals 1

    .prologue
    .line 200
    iget-object v0, p0, Lcom/a/a/a/b/q;->d:Lcom/a/a/a/b/d;

    invoke-interface {v0, p1, p2}, Lcom/a/a/a/b/d;->a(ILcom/a/a/a/b/a;)V

    .line 201
    return-void
.end method

.method public final c()V
    .locals 1

    .prologue
    .line 269
    iget-object v0, p0, Lcom/a/a/a/b/q;->d:Lcom/a/a/a/b/d;

    invoke-interface {v0}, Lcom/a/a/a/b/d;->b()V

    .line 270
    return-void
.end method

.method public final close()V
    .locals 2

    .prologue
    .line 298
    sget-object v0, Lcom/a/a/a/b/a;->a:Lcom/a/a/a/b/a;

    sget-object v1, Lcom/a/a/a/b/a;->l:Lcom/a/a/a/b/a;

    invoke-direct {p0, v0, v1}, Lcom/a/a/a/b/q;->a(Lcom/a/a/a/b/a;Lcom/a/a/a/b/a;)V

    .line 299
    return-void
.end method
