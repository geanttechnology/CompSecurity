.class final Lcom/a/a/a/b/v;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/a/a/a/b/c;
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/a/a/a/b/q;


# direct methods
.method private constructor <init>(Lcom/a/a/a/b/q;)V
    .locals 0

    .prologue
    .line 417
    iput-object p1, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/a/a/a/b/q;B)V
    .locals 0

    .prologue
    .line 417
    invoke-direct {p0, p1}, Lcom/a/a/a/b/v;-><init>(Lcom/a/a/a/b/q;)V

    return-void
.end method


# virtual methods
.method public final a(I)V
    .locals 4

    .prologue
    .line 552
    iget-object v2, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    monitor-enter v2

    .line 553
    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v0}, Lcom/a/a/a/b/q;->f(Lcom/a/a/a/b/q;)Z

    .line 556
    iget-object v0, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v0}, Lcom/a/a/a/b/q;->c(Lcom/a/a/a/b/q;)Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 557
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 558
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 559
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 560
    if-le v1, p1, :cond_0

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/a/a/a/b/x;

    invoke-virtual {v1}, Lcom/a/a/a/b/x;->b()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 561
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/a/a/b/x;

    sget-object v1, Lcom/a/a/a/b/a;->k:Lcom/a/a/a/b/a;

    invoke-virtual {v0, v1}, Lcom/a/a/a/b/x;->c(Lcom/a/a/a/b/a;)V

    .line 562
    invoke-interface {v3}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 565
    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_1
    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-void
.end method

.method public final a(II)V
    .locals 1

    .prologue
    .line 569
    if-nez p1, :cond_1

    .line 579
    :cond_0
    :goto_0
    return-void

    .line 575
    :cond_1
    iget-object v0, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v0, p1}, Lcom/a/a/a/b/q;->a(Lcom/a/a/a/b/q;I)Lcom/a/a/a/b/x;

    move-result-object v0

    .line 576
    if-eqz v0, :cond_0

    .line 577
    invoke-virtual {v0, p2}, Lcom/a/a/a/b/x;->a(I)V

    goto :goto_0
.end method

.method public final a(ILcom/a/a/a/b/a;)V
    .locals 1

    .prologue
    .line 503
    iget-object v0, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-virtual {v0, p1}, Lcom/a/a/a/b/q;->a(I)Lcom/a/a/a/b/x;

    move-result-object v0

    .line 504
    if-eqz v0, :cond_0

    .line 505
    invoke-virtual {v0, p2}, Lcom/a/a/a/b/x;->c(Lcom/a/a/a/b/a;)V

    .line 507
    :cond_0
    return-void
.end method

.method public final a(ILjava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 496
    iget-object v0, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v0, p1}, Lcom/a/a/a/b/q;->a(Lcom/a/a/a/b/q;I)Lcom/a/a/a/b/x;

    move-result-object v1

    .line 497
    if-eqz v1, :cond_1

    .line 498
    sget-boolean v0, Lcom/a/a/a/b/x;->f:Z

    if-nez v0, :cond_0

    invoke-static {v1}, Ljava/lang/Thread;->holdsLock(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :cond_0
    const/4 v0, 0x0

    monitor-enter v1

    :try_start_0
    iget-object v2, v1, Lcom/a/a/a/b/x;->d:Ljava/util/List;

    if-eqz v2, :cond_2

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iget-object v3, v1, Lcom/a/a/a/b/x;->d:Ljava/util/List;

    invoke-interface {v2, v3}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    invoke-interface {v2, p2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    iput-object v2, v1, Lcom/a/a/a/b/x;->d:Ljava/util/List;

    :goto_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_1

    sget-object v0, Lcom/a/a/a/b/a;->b:Lcom/a/a/a/b/a;

    invoke-virtual {v1, v0}, Lcom/a/a/a/b/x;->b(Lcom/a/a/a/b/a;)V

    .line 500
    :cond_1
    return-void

    .line 498
    :cond_2
    const/4 v0, 0x1

    goto :goto_0

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public final a(ZII)V
    .locals 6

    .prologue
    const-wide/16 v4, -0x1

    .line 540
    if-eqz p1, :cond_3

    .line 541
    iget-object v0, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v0, p2}, Lcom/a/a/a/b/q;->c(Lcom/a/a/a/b/q;I)Lcom/a/a/a/b/j;

    move-result-object v0

    .line 542
    if-eqz v0, :cond_2

    .line 543
    iget-wide v2, v0, Lcom/a/a/a/b/j;->c:J

    cmp-long v1, v2, v4

    if-nez v1, :cond_0

    iget-wide v2, v0, Lcom/a/a/a/b/j;->b:J

    cmp-long v1, v2, v4

    if-nez v1, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    :cond_1
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    iput-wide v2, v0, Lcom/a/a/a/b/j;->c:J

    iget-object v0, v0, Lcom/a/a/a/b/j;->a:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 549
    :cond_2
    :goto_0
    return-void

    .line 547
    :cond_3
    iget-object v0, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v0, p2, p3}, Lcom/a/a/a/b/q;->a(Lcom/a/a/a/b/q;II)V

    goto :goto_0
.end method

.method public final a(ZILjava/io/InputStream;I)V
    .locals 10

    .prologue
    const/4 v0, 0x0

    .line 439
    iget-object v1, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v1, p2}, Lcom/a/a/a/b/q;->a(Lcom/a/a/a/b/q;I)Lcom/a/a/a/b/x;

    move-result-object v3

    .line 440
    if-nez v3, :cond_1

    .line 441
    iget-object v0, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    sget-object v1, Lcom/a/a/a/b/a;->c:Lcom/a/a/a/b/a;

    invoke-virtual {v0, p2, v1}, Lcom/a/a/a/b/q;->a(ILcom/a/a/a/b/a;)V

    .line 442
    int-to-long v0, p4

    invoke-static {p3, v0, v1}, Lcom/a/a/a/u;->a(Ljava/io/InputStream;J)J

    .line 449
    :cond_0
    :goto_0
    return-void

    .line 445
    :cond_1
    sget-boolean v1, Lcom/a/a/a/b/x;->f:Z

    if-nez v1, :cond_2

    invoke-static {v3}, Ljava/lang/Thread;->holdsLock(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :cond_2
    iget-object v4, v3, Lcom/a/a/a/b/x;->e:Lcom/a/a/a/b/y;

    sget-boolean v1, Lcom/a/a/a/b/y;->e:Z

    if-nez v1, :cond_3

    iget-object v1, v4, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    invoke-static {v1}, Ljava/lang/Thread;->holdsLock(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :cond_3
    if-eqz p4, :cond_4

    iget-object v5, v4, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    monitor-enter v5

    :try_start_0
    iget-boolean v6, v4, Lcom/a/a/a/b/y;->d:Z

    iget v7, v4, Lcom/a/a/a/b/y;->b:I

    iget v8, v4, Lcom/a/a/a/b/y;->c:I

    iget v1, v4, Lcom/a/a/a/b/y;->c:I

    iget-object v2, v4, Lcom/a/a/a/b/y;->a:[B

    array-length v2, v2

    invoke-virtual {v4}, Lcom/a/a/a/b/y;->available()I

    move-result v9

    sub-int/2addr v2, v9

    if-le p4, v2, :cond_5

    const/4 v2, 0x1

    :goto_1
    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v2, :cond_6

    int-to-long v0, p4

    invoke-static {p3, v0, v1}, Lcom/a/a/a/u;->a(Ljava/io/InputStream;J)J

    iget-object v0, v4, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    sget-object v1, Lcom/a/a/a/b/a;->h:Lcom/a/a/a/b/a;

    invoke-virtual {v0, v1}, Lcom/a/a/a/b/x;->b(Lcom/a/a/a/b/a;)V

    .line 446
    :cond_4
    :goto_2
    if-eqz p1, :cond_0

    .line 447
    invoke-virtual {v3}, Lcom/a/a/a/b/x;->e()V

    goto :goto_0

    :cond_5
    move v2, v0

    .line 445
    goto :goto_1

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :cond_6
    if-eqz v6, :cond_7

    int-to-long v0, p4

    invoke-static {p3, v0, v1}, Lcom/a/a/a/u;->a(Ljava/io/InputStream;J)J

    goto :goto_2

    :cond_7
    if-ge v7, v1, :cond_a

    iget-object v2, v4, Lcom/a/a/a/b/y;->a:[B

    array-length v2, v2

    sub-int/2addr v2, v1

    invoke-static {p4, v2}, Ljava/lang/Math;->min(II)I

    move-result v2

    iget-object v5, v4, Lcom/a/a/a/b/y;->a:[B

    invoke-static {p3, v5, v1, v2}, Lcom/a/a/a/u;->a(Ljava/io/InputStream;[BII)V

    add-int/2addr v1, v2

    sub-int/2addr p4, v2

    iget-object v2, v4, Lcom/a/a/a/b/y;->a:[B

    array-length v2, v2

    if-ne v1, v2, :cond_a

    :goto_3
    if-lez p4, :cond_8

    iget-object v1, v4, Lcom/a/a/a/b/y;->a:[B

    invoke-static {p3, v1, v0, p4}, Lcom/a/a/a/u;->a(Ljava/io/InputStream;[BII)V

    add-int/2addr v0, p4

    :cond_8
    iget-object v1, v4, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    monitor-enter v1

    :try_start_2
    iput v0, v4, Lcom/a/a/a/b/y;->c:I

    iget v0, v4, Lcom/a/a/a/b/y;->b:I

    const/4 v2, -0x1

    if-ne v0, v2, :cond_9

    iput v8, v4, Lcom/a/a/a/b/y;->b:I

    iget-object v0, v4, Lcom/a/a/a/b/y;->f:Lcom/a/a/a/b/x;

    invoke-virtual {v0}, Ljava/lang/Object;->notifyAll()V

    :cond_9
    monitor-exit v1

    goto :goto_2

    :catchall_1
    move-exception v0

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v0

    :cond_a
    move v0, v1

    goto :goto_3
.end method

.method public final a(ZILjava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ZI",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 483
    iget-object v0, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v0, p2}, Lcom/a/a/a/b/q;->a(Lcom/a/a/a/b/q;I)Lcom/a/a/a/b/x;

    move-result-object v2

    .line 484
    if-nez v2, :cond_1

    .line 485
    iget-object v0, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    sget-object v1, Lcom/a/a/a/b/a;->c:Lcom/a/a/a/b/a;

    invoke-virtual {v0, p2, v1}, Lcom/a/a/a/b/q;->a(ILcom/a/a/a/b/a;)V

    .line 492
    :cond_0
    :goto_0
    return-void

    .line 488
    :cond_1
    sget-boolean v0, Lcom/a/a/a/b/x;->f:Z

    if-nez v0, :cond_2

    invoke-static {v2}, Ljava/lang/Thread;->holdsLock(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :cond_2
    monitor-enter v2

    :try_start_0
    invoke-virtual {v2}, Lcom/a/a/a/b/x;->b()Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, v2, Lcom/a/a/a/b/x;->d:Ljava/util/List;

    if-nez v0, :cond_4

    iput-object p3, v2, Lcom/a/a/a/b/x;->d:Ljava/util/List;

    invoke-virtual {v2}, Lcom/a/a/a/b/x;->a()Z

    move-result v0

    invoke-virtual {v2}, Ljava/lang/Object;->notifyAll()V

    :goto_1
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_5

    sget-object v0, Lcom/a/a/a/b/a;->e:Lcom/a/a/a/b/a;

    invoke-virtual {v2, v0}, Lcom/a/a/a/b/x;->b(Lcom/a/a/a/b/a;)V

    .line 489
    :cond_3
    :goto_2
    if-eqz p1, :cond_0

    .line 490
    invoke-virtual {v2}, Lcom/a/a/a/b/x;->e()V

    goto :goto_0

    .line 488
    :cond_4
    const/4 v0, 0x1

    move v3, v1

    move v1, v0

    move v0, v3

    goto :goto_1

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :cond_5
    if-nez v0, :cond_3

    iget-object v0, v2, Lcom/a/a/a/b/x;->b:Lcom/a/a/a/b/q;

    iget v1, v2, Lcom/a/a/a/b/x;->a:I

    invoke-virtual {v0, v1}, Lcom/a/a/a/b/q;->a(I)Lcom/a/a/a/b/x;

    goto :goto_2
.end method

.method public final a(ZLcom/a/a/a/b/k;)V
    .locals 9

    .prologue
    const/4 v4, 0x1

    const/4 v1, 0x0

    .line 510
    const/4 v0, 0x0

    .line 511
    iget-object v6, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    monitor-enter v6

    .line 512
    :try_start_0
    iget-object v2, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    iget-object v2, v2, Lcom/a/a/a/b/q;->f:Lcom/a/a/a/b/k;

    if-eqz v2, :cond_0

    if-eqz p1, :cond_2

    .line 513
    :cond_0
    iget-object v2, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    iput-object p2, v2, Lcom/a/a/a/b/q;->f:Lcom/a/a/a/b/k;

    .line 517
    :cond_1
    iget-object v2, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v2}, Lcom/a/a/a/b/q;->c(Lcom/a/a/a/b/q;)Ljava/util/Map;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Map;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_a

    .line 518
    iget-object v0, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v0}, Lcom/a/a/a/b/q;->c(Lcom/a/a/a/b/q;)Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    iget-object v2, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v2}, Lcom/a/a/a/b/q;->c(Lcom/a/a/a/b/q;)Ljava/util/Map;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Map;->size()I

    move-result v2

    new-array v2, v2, [Lcom/a/a/a/b/x;

    invoke-interface {v0, v2}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/a/a/a/b/x;

    move-object v2, v0

    .line 520
    :goto_0
    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    .line 521
    if-eqz v2, :cond_9

    .line 522
    array-length v3, v2

    move v0, v1

    :goto_1
    if-ge v0, v3, :cond_9

    aget-object v1, v2, v0

    .line 527
    monitor-enter v1

    .line 528
    :try_start_1
    iget-object v4, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    monitor-enter v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 529
    :try_start_2
    iget-object v5, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    iget-object v5, v5, Lcom/a/a/a/b/q;->f:Lcom/a/a/a/b/k;

    sget-boolean v6, Lcom/a/a/a/b/x;->f:Z

    if-nez v6, :cond_8

    invoke-static {v1}, Ljava/lang/Thread;->holdsLock(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_8

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 530
    :catchall_0
    move-exception v0

    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v0

    .line 531
    :catchall_1
    move-exception v0

    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v0

    .line 515
    :cond_2
    :try_start_4
    iget-object v2, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    iget-object v7, v2, Lcom/a/a/a/b/q;->f:Lcom/a/a/a/b/k;

    move v5, v1

    :goto_2
    const/16 v2, 0xa

    if-ge v5, v2, :cond_1

    shl-int v2, v4, v5

    iget v3, p2, Lcom/a/a/a/b/k;->a:I

    and-int/2addr v2, v3

    if-eqz v2, :cond_5

    move v2, v4

    :goto_3
    if-eqz v2, :cond_4

    shl-int v2, v4, v5

    iget v3, p2, Lcom/a/a/a/b/k;->c:I

    and-int/2addr v2, v3

    if-eqz v2, :cond_6

    move v2, v4

    :goto_4
    if-eqz v2, :cond_b

    const/4 v2, 0x2

    :goto_5
    shl-int v3, v4, v5

    iget v8, p2, Lcom/a/a/a/b/k;->b:I

    and-int/2addr v3, v8

    if-eqz v3, :cond_7

    move v3, v4

    :goto_6
    if-eqz v3, :cond_3

    or-int/lit8 v2, v2, 0x1

    :cond_3
    iget-object v3, p2, Lcom/a/a/a/b/k;->d:[I

    aget v3, v3, v5

    invoke-virtual {v7, v5, v2, v3}, Lcom/a/a/a/b/k;->a(III)V

    :cond_4
    add-int/lit8 v2, v5, 0x1

    move v5, v2

    goto :goto_2

    :cond_5
    move v2, v1

    goto :goto_3

    :cond_6
    move v2, v1

    goto :goto_4

    :cond_7
    move v3, v1

    goto :goto_6

    .line 520
    :catchall_2
    move-exception v0

    monitor-exit v6
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    throw v0

    .line 529
    :cond_8
    :try_start_5
    invoke-virtual {v1, v5}, Lcom/a/a/a/b/x;->a(Lcom/a/a/a/b/k;)V

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 530
    monitor-exit v4
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 531
    :try_start_6
    monitor-exit v1
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 522
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 534
    :cond_9
    return-void

    :cond_a
    move-object v2, v0

    goto :goto_0

    :cond_b
    move v2, v1

    goto :goto_5
.end method

.method public final a(ZZIIILjava/util/List;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ZZIII",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 455
    iget-object v9, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    monitor-enter v9

    .line 456
    :try_start_0
    new-instance v0, Lcom/a/a/a/b/x;

    iget-object v2, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    iget-object v1, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    iget-object v8, v1, Lcom/a/a/a/b/q;->f:Lcom/a/a/a/b/k;

    move v1, p3

    move v3, p1

    move v4, p2

    move v5, p4

    move v6, p5

    move-object/from16 v7, p6

    invoke-direct/range {v0 .. v8}, Lcom/a/a/a/b/x;-><init>(ILcom/a/a/a/b/q;ZZIILjava/util/List;Lcom/a/a/a/b/k;)V

    .line 458
    iget-object v1, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v1}, Lcom/a/a/a/b/q;->b(Lcom/a/a/a/b/q;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 459
    monitor-exit v9

    .line 479
    :goto_0
    return-void

    .line 461
    :cond_0
    iget-object v1, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v1, p3}, Lcom/a/a/a/b/q;->b(Lcom/a/a/a/b/q;I)I

    .line 462
    iget-object v1, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v1}, Lcom/a/a/a/b/q;->c(Lcom/a/a/a/b/q;)Ljava/util/Map;

    move-result-object v1

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/a/a/a/b/x;

    .line 463
    monitor-exit v9
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 464
    if-eqz v1, :cond_1

    .line 465
    sget-object v0, Lcom/a/a/a/b/a;->b:Lcom/a/a/a/b/a;

    invoke-virtual {v1, v0}, Lcom/a/a/a/b/x;->b(Lcom/a/a/a/b/a;)V

    .line 466
    iget-object v0, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-virtual {v0, p3}, Lcom/a/a/a/b/q;->a(I)Lcom/a/a/a/b/x;

    goto :goto_0

    .line 463
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v9
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    .line 470
    :cond_1
    invoke-static {}, Lcom/a/a/a/b/q;->d()Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    new-instance v2, Lcom/a/a/a/b/w;

    const-string v3, "OkHttp SPDY Callback %s stream %d"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v6}, Lcom/a/a/a/b/q;->d(Lcom/a/a/a/b/q;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-direct {v2, p0, v3, v4, v0}, Lcom/a/a/a/b/w;-><init>(Lcom/a/a/a/b/v;Ljava/lang/String;[Ljava/lang/Object;Lcom/a/a/a/b/x;)V

    invoke-interface {v1, v2}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    goto :goto_0
.end method

.method public final run()V
    .locals 5

    .prologue
    .line 419
    sget-object v0, Lcom/a/a/a/b/a;->g:Lcom/a/a/a/b/a;

    .line 420
    sget-object v2, Lcom/a/a/a/b/a;->g:Lcom/a/a/a/b/a;

    .line 422
    :cond_0
    :try_start_0
    iget-object v1, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v1}, Lcom/a/a/a/b/q;->a(Lcom/a/a/a/b/q;)Lcom/a/a/a/b/b;

    move-result-object v1

    invoke-interface {v1, p0}, Lcom/a/a/a/b/b;->a(Lcom/a/a/a/b/c;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 424
    sget-object v0, Lcom/a/a/a/b/a;->a:Lcom/a/a/a/b/a;

    .line 425
    sget-object v1, Lcom/a/a/a/b/a;->l:Lcom/a/a/a/b/a;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 431
    :try_start_1
    iget-object v2, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v2, v0, v1}, Lcom/a/a/a/b/q;->a(Lcom/a/a/a/b/q;Lcom/a/a/a/b/a;Lcom/a/a/a/b/a;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3

    .line 434
    :goto_0
    return-void

    .line 427
    :catch_0
    move-exception v1

    :try_start_2
    sget-object v1, Lcom/a/a/a/b/a;->b:Lcom/a/a/a/b/a;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 428
    :try_start_3
    sget-object v0, Lcom/a/a/a/b/a;->b:Lcom/a/a/a/b/a;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 431
    :try_start_4
    iget-object v2, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v2, v1, v0}, Lcom/a/a/a/b/q;->a(Lcom/a/a/a/b/q;Lcom/a/a/a/b/a;Lcom/a/a/a/b/a;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_0

    .line 434
    :catch_1
    move-exception v0

    goto :goto_0

    .line 430
    :catchall_0
    move-exception v1

    move-object v4, v1

    move-object v1, v0

    move-object v0, v4

    .line 431
    :goto_1
    :try_start_5
    iget-object v3, p0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v3, v1, v2}, Lcom/a/a/a/b/q;->a(Lcom/a/a/a/b/q;Lcom/a/a/a/b/a;Lcom/a/a/a/b/a;)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_2

    .line 433
    :goto_2
    throw v0

    :catch_2
    move-exception v1

    goto :goto_2

    .line 430
    :catchall_1
    move-exception v0

    goto :goto_1

    .line 434
    :catch_3
    move-exception v0

    goto :goto_0
.end method
