.class final Lcom/a/a/a/b/y;
.super Ljava/io/InputStream;
.source "SourceFile"


# static fields
.field static final synthetic e:Z


# instance fields
.field final a:[B

.field b:I

.field c:I

.field d:Z

.field final synthetic f:Lcom/a/a/a/b/x;

.field private g:Z

.field private h:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 339
    const-class v0, Lcom/a/a/a/b/x;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/a/a/a/b/y;->e:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private constructor <init>(Lcom/a/a/a/b/x;)V
    .locals 1

    .prologue
    .line 339
    iput-object p1, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    .line 352
    const/high16 v0, 0x10000

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/a/a/a/b/y;->a:[B

    .line 355
    const/4 v0, -0x1

    iput v0, p0, Lcom/a/a/a/b/y;->b:I

    .line 374
    const/4 v0, 0x0

    iput v0, p0, Lcom/a/a/a/b/y;->h:I

    return-void
.end method

.method synthetic constructor <init>(Lcom/a/a/a/b/x;B)V
    .locals 0

    .prologue
    .line 339
    invoke-direct {p0, p1}, Lcom/a/a/a/b/y;-><init>(Lcom/a/a/a/b/x;)V

    return-void
.end method

.method private a()V
    .locals 3

    .prologue
    .line 537
    iget-boolean v0, p0, Lcom/a/a/a/b/y;->g:Z

    if-eqz v0, :cond_0

    .line 538
    new-instance v0, Ljava/io/IOException;

    const-string v1, "stream closed"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 540
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    invoke-static {v0}, Lcom/a/a/a/b/x;->d(Lcom/a/a/a/b/x;)Lcom/a/a/a/b/a;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 541
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "stream was reset: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    invoke-static {v2}, Lcom/a/a/a/b/x;->d(Lcom/a/a/a/b/x;)Lcom/a/a/a/b/a;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 543
    :cond_1
    return-void
.end method

.method static synthetic a(Lcom/a/a/a/b/y;)Z
    .locals 1

    .prologue
    .line 339
    iget-boolean v0, p0, Lcom/a/a/a/b/y;->d:Z

    return v0
.end method

.method static synthetic a(Lcom/a/a/a/b/y;Z)Z
    .locals 0

    .prologue
    .line 339
    iput-boolean p1, p0, Lcom/a/a/a/b/y;->d:Z

    return p1
.end method

.method static synthetic b(Lcom/a/a/a/b/y;)Z
    .locals 1

    .prologue
    .line 339
    iget-boolean v0, p0, Lcom/a/a/a/b/y;->g:Z

    return v0
.end method


# virtual methods
.method public final available()I
    .locals 4

    .prologue
    .line 377
    iget-object v1, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    monitor-enter v1

    .line 378
    :try_start_0
    invoke-direct {p0}, Lcom/a/a/a/b/y;->a()V

    .line 379
    iget v0, p0, Lcom/a/a/a/b/y;->b:I

    const/4 v2, -0x1

    if-ne v0, v2, :cond_0

    .line 380
    const/4 v0, 0x0

    monitor-exit v1

    .line 384
    :goto_0
    return v0

    .line 381
    :cond_0
    iget v0, p0, Lcom/a/a/a/b/y;->c:I

    iget v2, p0, Lcom/a/a/a/b/y;->b:I

    if-le v0, v2, :cond_1

    .line 382
    iget v0, p0, Lcom/a/a/a/b/y;->c:I

    iget v2, p0, Lcom/a/a/a/b/y;->b:I

    sub-int/2addr v0, v2

    monitor-exit v1

    goto :goto_0

    .line 386
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 384
    :cond_1
    :try_start_1
    iget v0, p0, Lcom/a/a/a/b/y;->c:I

    iget-object v2, p0, Lcom/a/a/a/b/y;->a:[B

    array-length v2, v2

    iget v3, p0, Lcom/a/a/a/b/y;->b:I

    sub-int/2addr v2, v3

    add-int/2addr v0, v2

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method public final close()V
    .locals 2

    .prologue
    .line 529
    iget-object v1, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    monitor-enter v1

    .line 530
    const/4 v0, 0x1

    :try_start_0
    iput-boolean v0, p0, Lcom/a/a/a/b/y;->g:Z

    .line 531
    iget-object v0, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    invoke-virtual {v0}, Ljava/lang/Object;->notifyAll()V

    .line 532
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 533
    iget-object v0, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    invoke-static {v0}, Lcom/a/a/a/b/x;->e(Lcom/a/a/a/b/x;)V

    .line 534
    return-void

    .line 532
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public final read()I
    .locals 1

    .prologue
    .line 390
    invoke-static {p0}, Lcom/a/a/a/u;->a(Ljava/io/InputStream;)I

    move-result v0

    return v0
.end method

.method public final read([BII)I
    .locals 11

    .prologue
    .line 394
    iget-object v7, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    monitor-enter v7

    .line 395
    :try_start_0
    array-length v0, p1

    invoke-static {v0, p2, p3}, Lcom/a/a/a/u;->a(III)V

    .line 396
    const-wide/16 v2, 0x0

    const-wide/16 v0, 0x0

    iget-object v4, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    invoke-static {v4}, Lcom/a/a/a/b/x;->c(Lcom/a/a/a/b/x;)J

    move-result-wide v4

    const-wide/16 v8, 0x0

    cmp-long v4, v4, v8

    if-eqz v4, :cond_0

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    const-wide/32 v2, 0xf4240

    div-long v2, v0, v2

    iget-object v0, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    invoke-static {v0}, Lcom/a/a/a/b/x;->c(Lcom/a/a/a/b/x;)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v0

    :cond_0
    :goto_0
    :try_start_1
    iget v4, p0, Lcom/a/a/a/b/y;->b:I

    const/4 v5, -0x1

    if-ne v4, v5, :cond_3

    iget-boolean v4, p0, Lcom/a/a/a/b/y;->d:Z

    if-nez v4, :cond_3

    iget-boolean v4, p0, Lcom/a/a/a/b/y;->g:Z

    if-nez v4, :cond_3

    iget-object v4, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    invoke-static {v4}, Lcom/a/a/a/b/x;->d(Lcom/a/a/a/b/x;)Lcom/a/a/a/b/a;

    move-result-object v4

    if-nez v4, :cond_3

    iget-object v4, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    invoke-static {v4}, Lcom/a/a/a/b/x;->c(Lcom/a/a/a/b/x;)J

    move-result-wide v4

    const-wide/16 v8, 0x0

    cmp-long v4, v4, v8

    if-nez v4, :cond_1

    iget-object v4, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    invoke-virtual {v4}, Ljava/lang/Object;->wait()V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catch_0
    move-exception v0

    :try_start_2
    new-instance v0, Ljava/io/InterruptedIOException;

    invoke-direct {v0}, Ljava/io/InterruptedIOException;-><init>()V

    throw v0

    .line 437
    :catchall_0
    move-exception v0

    monitor-exit v7
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    .line 396
    :cond_1
    const-wide/16 v4, 0x0

    cmp-long v4, v0, v4

    if-lez v4, :cond_2

    :try_start_3
    iget-object v4, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    invoke-virtual {v4, v0, v1}, Ljava/lang/Object;->wait(J)V

    iget-object v0, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    invoke-static {v0}, Lcom/a/a/a/b/x;->c(Lcom/a/a/a/b/x;)J

    move-result-wide v0

    add-long/2addr v0, v2

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v4

    const-wide/32 v8, 0xf4240

    div-long/2addr v4, v8

    sub-long/2addr v0, v4

    goto :goto_0

    :cond_2
    new-instance v0, Ljava/net/SocketTimeoutException;

    invoke-direct {v0}, Ljava/net/SocketTimeoutException;-><init>()V

    throw v0
    :try_end_3
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 397
    :cond_3
    :try_start_4
    invoke-direct {p0}, Lcom/a/a/a/b/y;->a()V

    .line 399
    iget v0, p0, Lcom/a/a/a/b/y;->b:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_4

    .line 400
    const/4 v0, -0x1

    monitor-exit v7

    .line 436
    :goto_1
    return v0

    .line 403
    :cond_4
    const/4 v6, 0x0

    .line 406
    iget v0, p0, Lcom/a/a/a/b/y;->c:I

    iget v1, p0, Lcom/a/a/a/b/y;->b:I

    if-gt v0, v1, :cond_5

    .line 407
    iget-object v0, p0, Lcom/a/a/a/b/y;->a:[B

    array-length v0, v0

    iget v1, p0, Lcom/a/a/a/b/y;->b:I

    sub-int/2addr v0, v1

    invoke-static {p3, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 408
    iget-object v1, p0, Lcom/a/a/a/b/y;->a:[B

    iget v2, p0, Lcom/a/a/a/b/y;->b:I

    invoke-static {v1, v2, p1, p2, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 409
    iget v1, p0, Lcom/a/a/a/b/y;->b:I

    add-int/2addr v1, v0

    iput v1, p0, Lcom/a/a/a/b/y;->b:I

    .line 410
    add-int/lit8 v6, v0, 0x0

    .line 411
    iget v0, p0, Lcom/a/a/a/b/y;->b:I

    iget-object v1, p0, Lcom/a/a/a/b/y;->a:[B

    array-length v1, v1

    if-ne v0, v1, :cond_5

    .line 412
    const/4 v0, 0x0

    iput v0, p0, Lcom/a/a/a/b/y;->b:I

    .line 417
    :cond_5
    if-ge v6, p3, :cond_6

    .line 418
    iget v0, p0, Lcom/a/a/a/b/y;->c:I

    iget v1, p0, Lcom/a/a/a/b/y;->b:I

    sub-int/2addr v0, v1

    sub-int v1, p3, v6

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 419
    iget-object v1, p0, Lcom/a/a/a/b/y;->a:[B

    iget v2, p0, Lcom/a/a/a/b/y;->b:I

    add-int v3, p2, v6

    invoke-static {v1, v2, p1, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 420
    iget v1, p0, Lcom/a/a/a/b/y;->b:I

    add-int/2addr v1, v0

    iput v1, p0, Lcom/a/a/a/b/y;->b:I

    .line 421
    add-int/2addr v6, v0

    .line 425
    :cond_6
    iget v0, p0, Lcom/a/a/a/b/y;->h:I

    add-int/2addr v0, v6

    iput v0, p0, Lcom/a/a/a/b/y;->h:I

    .line 426
    iget v0, p0, Lcom/a/a/a/b/y;->h:I

    const v1, 0x8000

    if-lt v0, v1, :cond_7

    .line 427
    iget-object v0, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    invoke-static {v0}, Lcom/a/a/a/b/x;->b(Lcom/a/a/a/b/x;)Lcom/a/a/a/b/q;

    move-result-object v1

    iget-object v0, p0, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    invoke-static {v0}, Lcom/a/a/a/b/x;->a(Lcom/a/a/a/b/x;)I

    move-result v4

    iget v5, p0, Lcom/a/a/a/b/y;->h:I

    sget-object v8, Lcom/a/a/a/b/q;->a:Ljava/util/concurrent/ExecutorService;

    new-instance v0, Lcom/a/a/a/b/s;

    const-string v2, "OkHttp SPDY Writer %s stream %d"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget-object v10, v1, Lcom/a/a/a/b/q;->e:Ljava/lang/String;

    aput-object v10, v3, v9

    const/4 v9, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v3, v9

    invoke-direct/range {v0 .. v5}, Lcom/a/a/a/b/s;-><init>(Lcom/a/a/a/b/q;Ljava/lang/String;[Ljava/lang/Object;II)V

    invoke-interface {v8, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    .line 428
    const/4 v0, 0x0

    iput v0, p0, Lcom/a/a/a/b/y;->h:I

    .line 431
    :cond_7
    iget v0, p0, Lcom/a/a/a/b/y;->b:I

    iget v1, p0, Lcom/a/a/a/b/y;->c:I

    if-ne v0, v1, :cond_8

    .line 432
    const/4 v0, -0x1

    iput v0, p0, Lcom/a/a/a/b/y;->b:I

    .line 433
    const/4 v0, 0x0

    iput v0, p0, Lcom/a/a/a/b/y;->c:I

    .line 436
    :cond_8
    monitor-exit v7
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move v0, v6

    goto/16 :goto_1
.end method
