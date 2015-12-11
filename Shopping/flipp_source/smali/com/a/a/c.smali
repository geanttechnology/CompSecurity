.class public final Lcom/a/a/c;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final d:Lcom/a/a/c;


# instance fields
.field public final a:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Lcom/a/a/b;",
            ">;"
        }
    .end annotation
.end field

.field public final b:Ljava/util/concurrent/ExecutorService;

.field public final c:Ljava/util/concurrent/Callable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Callable",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation
.end field

.field private final e:I

.field private final f:J


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 62
    const-string v0, "http.keepAlive"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 63
    const-string v0, "http.keepAliveDuration"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 64
    const-string v1, "http.maxConnections"

    invoke-static {v1}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 65
    if-eqz v0, :cond_0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    .line 67
    :goto_0
    if-eqz v2, :cond_1

    invoke-static {v2}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 68
    new-instance v2, Lcom/a/a/c;

    const/4 v3, 0x0

    invoke-direct {v2, v3, v0, v1}, Lcom/a/a/c;-><init>(IJ)V

    sput-object v2, Lcom/a/a/c;->d:Lcom/a/a/c;

    .line 74
    :goto_1
    return-void

    .line 65
    :cond_0
    const-wide/32 v0, 0x493e0

    goto :goto_0

    .line 69
    :cond_1
    if-eqz v3, :cond_2

    .line 70
    new-instance v2, Lcom/a/a/c;

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    invoke-direct {v2, v3, v0, v1}, Lcom/a/a/c;-><init>(IJ)V

    sput-object v2, Lcom/a/a/c;->d:Lcom/a/a/c;

    goto :goto_1

    .line 72
    :cond_2
    new-instance v2, Lcom/a/a/c;

    const/4 v3, 0x5

    invoke-direct {v2, v3, v0, v1}, Lcom/a/a/c;-><init>(IJ)V

    sput-object v2, Lcom/a/a/c;->d:Lcom/a/a/c;

    goto :goto_1
.end method

.method private constructor <init>(IJ)V
    .locals 12

    .prologue
    const-wide/16 v10, 0x3e8

    .line 120
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 80
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/a/a/c;->a:Ljava/util/LinkedList;

    .line 83
    new-instance v1, Ljava/util/concurrent/ThreadPoolExecutor;

    const/4 v2, 0x0

    const/4 v3, 0x1

    const-wide/16 v4, 0x3c

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v7}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    const-string v0, "OkHttp ConnectionPool"

    invoke-static {v0}, Lcom/a/a/a/u;->b(Ljava/lang/String;)Ljava/util/concurrent/ThreadFactory;

    move-result-object v8

    invoke-direct/range {v1 .. v8}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V

    iput-object v1, p0, Lcom/a/a/c;->b:Ljava/util/concurrent/ExecutorService;

    .line 86
    new-instance v0, Lcom/a/a/d;

    invoke-direct {v0, p0}, Lcom/a/a/d;-><init>(Lcom/a/a/c;)V

    iput-object v0, p0, Lcom/a/a/c;->c:Ljava/util/concurrent/Callable;

    .line 121
    iput p1, p0, Lcom/a/a/c;->e:I

    .line 122
    mul-long v0, p2, v10

    mul-long/2addr v0, v10

    iput-wide v0, p0, Lcom/a/a/c;->f:J

    .line 123
    return-void
.end method

.method public static a()Lcom/a/a/c;
    .locals 1

    .prologue
    .line 152
    sget-object v0, Lcom/a/a/c;->d:Lcom/a/a/c;

    return-object v0
.end method

.method static synthetic a(Lcom/a/a/c;)Ljava/util/LinkedList;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/a/a/c;->a:Ljava/util/LinkedList;

    return-object v0
.end method

.method static synthetic b(Lcom/a/a/c;)J
    .locals 2

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/a/a/c;->f:J

    return-wide v0
.end method

.method static synthetic c(Lcom/a/a/c;)I
    .locals 1

    .prologue
    .line 55
    iget v0, p0, Lcom/a/a/c;->e:I

    return v0
.end method


# virtual methods
.method public final declared-synchronized a(Lcom/a/a/a;)Lcom/a/a/b;
    .locals 8

    .prologue
    .line 180
    monitor-enter p0

    const/4 v2, 0x0

    .line 181
    :try_start_0
    iget-object v0, p0, Lcom/a/a/c;->a:Ljava/util/LinkedList;

    iget-object v1, p0, Lcom/a/a/c;->a:Ljava/util/LinkedList;

    invoke-virtual {v1}, Ljava/util/LinkedList;->size()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/util/LinkedList;->listIterator(I)Ljava/util/ListIterator;

    move-result-object v3

    .line 182
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/ListIterator;->hasPrevious()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 183
    invoke-interface {v3}, Ljava/util/ListIterator;->previous()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/a/b;

    .line 184
    iget-object v1, v0, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v1, v1, Lcom/a/a/v;->a:Lcom/a/a/a;

    invoke-virtual {v1, p1}, Lcom/a/a/a;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Lcom/a/a/b;->a()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v4

    invoke-virtual {v0}, Lcom/a/a/b;->d()J

    move-result-wide v6

    sub-long/2addr v4, v6

    iget-wide v6, p0, Lcom/a/a/c;->f:J

    cmp-long v1, v4, v6

    if-gez v1, :cond_0

    .line 187
    invoke-interface {v3}, Ljava/util/ListIterator;->remove()V

    .line 190
    invoke-virtual {v0}, Lcom/a/a/b;->e()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_1

    .line 192
    :try_start_1
    invoke-static {}, Lcom/a/a/a/m;->a()Lcom/a/a/a/m;

    iget-object v1, v0, Lcom/a/a/b;->e:Ljava/net/Socket;

    invoke-static {}, Lcom/a/a/a/m;->c()V
    :try_end_1
    .catch Ljava/net/SocketException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 201
    :cond_1
    :goto_1
    if-eqz v0, :cond_2

    :try_start_2
    invoke-virtual {v0}, Lcom/a/a/b;->e()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 205
    iget-object v1, p0, Lcom/a/a/c;->a:Ljava/util/LinkedList;

    invoke-virtual {v1, v0}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    .line 208
    :cond_2
    iget-object v1, p0, Lcom/a/a/c;->b:Ljava/util/concurrent/ExecutorService;

    iget-object v2, p0, Lcom/a/a/c;->c:Ljava/util/concurrent/Callable;

    invoke-interface {v1, v2}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 209
    monitor-exit p0

    return-object v0

    .line 193
    :catch_0
    move-exception v1

    .line 194
    :try_start_3
    invoke-static {v0}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;)V

    .line 196
    invoke-static {}, Lcom/a/a/a/m;->a()Lcom/a/a/a/m;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v4, "Unable to tagSocket(): "

    invoke-direct {v0, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/a/a/a/m;->a(Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 180
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_3
    move-object v0, v2

    goto :goto_1
.end method

.method public final a(Lcom/a/a/b;)V
    .locals 3

    .prologue
    .line 219
    invoke-virtual {p1}, Lcom/a/a/b;->e()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 243
    :goto_0
    return-void

    .line 223
    :cond_0
    invoke-virtual {p1}, Lcom/a/a/b;->a()Z

    move-result v0

    if-nez v0, :cond_1

    .line 224
    invoke-static {p1}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;)V

    goto :goto_0

    .line 229
    :cond_1
    :try_start_0
    invoke-static {}, Lcom/a/a/a/m;->a()Lcom/a/a/a/m;

    iget-object v0, p1, Lcom/a/a/b;->e:Ljava/net/Socket;

    invoke-static {}, Lcom/a/a/a/m;->d()V
    :try_end_0
    .catch Ljava/net/SocketException; {:try_start_0 .. :try_end_0} :catch_0

    .line 237
    monitor-enter p0

    .line 238
    :try_start_1
    iget-object v0, p0, Lcom/a/a/c;->a:Ljava/util/LinkedList;

    invoke-virtual {v0, p1}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    .line 239
    iget-object v0, p1, Lcom/a/a/b;->i:Lcom/a/a/a/b/q;

    if-eqz v0, :cond_2

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "spdyConnection != null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 240
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    .line 230
    :catch_0
    move-exception v0

    .line 232
    invoke-static {}, Lcom/a/a/a/m;->a()Lcom/a/a/a/m;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Unable to untagSocket(): "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/a/a/a/m;->a(Ljava/lang/String;)V

    .line 233
    invoke-static {p1}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;)V

    goto :goto_0

    .line 239
    :cond_2
    :try_start_2
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    iput-wide v0, p1, Lcom/a/a/b;->k:J

    .line 240
    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 242
    iget-object v0, p0, Lcom/a/a/c;->b:Ljava/util/concurrent/ExecutorService;

    iget-object v1, p0, Lcom/a/a/c;->c:Ljava/util/concurrent/Callable;

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    goto :goto_0
.end method
