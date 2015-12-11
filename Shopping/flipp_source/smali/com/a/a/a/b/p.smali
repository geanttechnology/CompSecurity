.class final Lcom/a/a/a/b/p;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/a/a/a/b/d;


# instance fields
.field private final a:Ljava/io/DataOutputStream;

.field private final b:Ljava/io/ByteArrayOutputStream;

.field private final c:Ljava/io/DataOutputStream;

.field private final d:Z


# direct methods
.method constructor <init>(Ljava/io/OutputStream;Z)V
    .locals 4

    .prologue
    .line 365
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 366
    new-instance v0, Ljava/io/DataOutputStream;

    invoke-direct {v0, p1}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    iput-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    .line 367
    iput-boolean p2, p0, Lcom/a/a/a/b/p;->d:Z

    .line 369
    new-instance v0, Ljava/util/zip/Deflater;

    invoke-direct {v0}, Ljava/util/zip/Deflater;-><init>()V

    .line 370
    sget-object v1, Lcom/a/a/a/b/l;->a:[B

    invoke-virtual {v0, v1}, Ljava/util/zip/Deflater;->setDictionary([B)V

    .line 371
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    iput-object v1, p0, Lcom/a/a/a/b/p;->b:Ljava/io/ByteArrayOutputStream;

    .line 372
    new-instance v1, Ljava/io/DataOutputStream;

    invoke-static {}, Lcom/a/a/a/m;->a()Lcom/a/a/a/m;

    move-result-object v2

    iget-object v3, p0, Lcom/a/a/a/b/p;->b:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v2, v3, v0}, Lcom/a/a/a/m;->a(Ljava/io/OutputStream;Ljava/util/zip/Deflater;)Ljava/io/OutputStream;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    iput-object v1, p0, Lcom/a/a/a/b/p;->c:Ljava/io/DataOutputStream;

    .line 374
    return-void
.end method


# virtual methods
.method public final declared-synchronized a()V
    .locals 0

    .prologue
    .line 378
    monitor-enter p0

    monitor-exit p0

    return-void
.end method

.method public final declared-synchronized a(II)V
    .locals 2

    .prologue
    .line 521
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    const v1, -0x7ffcfff7

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 525
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 526
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    invoke-virtual {v0, p1}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 527
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    invoke-virtual {v0, p2}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 528
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 529
    monitor-exit p0

    return-void

    .line 521
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized a(ILcom/a/a/a/b/a;)V
    .locals 2

    .prologue
    .line 432
    monitor-enter p0

    :try_start_0
    iget v0, p2, Lcom/a/a/a/b/a;->p:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 433
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    const v1, -0x7ffcfffd

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 437
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 438
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    const v1, 0x7fffffff

    and-int/2addr v1, p1

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 439
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    iget v1, p2, Lcom/a/a/a/b/a;->p:I

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 440
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 441
    monitor-exit p0

    return-void
.end method

.method public final declared-synchronized a(ZI)V
    .locals 4

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 495
    monitor-enter p0

    :try_start_0
    iget-boolean v3, p0, Lcom/a/a/a/b/p;->d:Z

    rem-int/lit8 v2, p2, 0x2

    if-ne v2, v0, :cond_0

    move v2, v0

    :goto_0
    if-eq v3, v2, :cond_1

    .line 496
    :goto_1
    if-eq p1, v0, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "payload != reply"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 495
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_0
    move v2, v1

    goto :goto_0

    :cond_1
    move v0, v1

    goto :goto_1

    .line 497
    :cond_2
    :try_start_1
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    const v1, -0x7ffcfffa

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 501
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 502
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    invoke-virtual {v0, p2}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 503
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 504
    monitor-exit p0

    return-void
.end method

.method public final declared-synchronized a(ZILjava/util/List;)V
    .locals 5
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

    .line 387
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/b/p;->b:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->reset()V

    invoke-interface {p3}, Ljava/util/List;->size()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    iget-object v2, p0, Lcom/a/a/a/b/p;->c:Ljava/io/DataOutputStream;

    invoke-virtual {v2, v0}, Ljava/io/DataOutputStream;->writeInt(I)V

    invoke-interface {p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v3, p0, Lcom/a/a/a/b/p;->c:Ljava/io/DataOutputStream;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/io/DataOutputStream;->writeInt(I)V

    iget-object v3, p0, Lcom/a/a/a/b/p;->c:Ljava/io/DataOutputStream;

    const-string v4, "UTF-8"

    invoke-virtual {v0, v4}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/io/DataOutputStream;->write([B)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/a/a/a/b/p;->c:Ljava/io/DataOutputStream;

    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V

    .line 388
    iget-object v0, p0, Lcom/a/a/a/b/p;->b:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->size()I

    move-result v0

    add-int/lit8 v2, v0, 0xa

    .line 389
    if-eqz p1, :cond_1

    const/4 v0, 0x1

    :goto_1
    or-int/lit8 v0, v0, 0x0

    .line 392
    iget-object v1, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    const v3, -0x7ffcffff

    invoke-virtual {v1, v3}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 394
    iget-object v1, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    and-int/lit16 v0, v0, 0xff

    shl-int/lit8 v0, v0, 0x18

    const v3, 0xffffff

    and-int/2addr v2, v3

    or-int/2addr v0, v2

    invoke-virtual {v1, v0}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 395
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    const v1, 0x7fffffff

    and-int/2addr v1, p2

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 396
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 397
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeShort(I)V

    .line 398
    iget-object v0, p0, Lcom/a/a/a/b/p;->b:Ljava/io/ByteArrayOutputStream;

    iget-object v1, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->writeTo(Ljava/io/OutputStream;)V

    .line 399
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 400
    monitor-exit p0

    return-void

    :cond_1
    move v0, v1

    .line 389
    goto :goto_1
.end method

.method public final declared-synchronized a(ZI[BI)V
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 450
    monitor-enter p0

    if-eqz p1, :cond_0

    const/4 v0, 0x1

    .line 451
    :cond_0
    :try_start_0
    iget-object v1, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    const v2, 0x7fffffff

    and-int/2addr v2, p2

    invoke-virtual {v1, v2}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 452
    iget-object v1, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    and-int/lit16 v0, v0, 0xff

    shl-int/lit8 v0, v0, 0x18

    const v2, 0xffffff

    and-int/2addr v2, p4

    or-int/2addr v0, v2

    invoke-virtual {v1, v0}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 453
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    const/4 v1, 0x0

    invoke-virtual {v0, p3, v1, p4}, Ljava/io/DataOutputStream;->write([BII)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 454
    monitor-exit p0

    return-void

    .line 450
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized b()V
    .locals 1

    .prologue
    .line 381
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 382
    monitor-exit p0

    return-void

    .line 381
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized b(ILcom/a/a/a/b/a;)V
    .locals 2

    .prologue
    .line 508
    monitor-enter p0

    :try_start_0
    iget v0, p2, Lcom/a/a/a/b/a;->q:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 509
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    const v1, -0x7ffcfff9

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 513
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 514
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    invoke-virtual {v0, p1}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 515
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    iget v1, p2, Lcom/a/a/a/b/a;->q:I

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 516
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 517
    monitor-exit p0

    return-void
.end method

.method public final close()V
    .locals 2

    .prologue
    .line 532
    iget-object v0, p0, Lcom/a/a/a/b/p;->a:Ljava/io/DataOutputStream;

    iget-object v1, p0, Lcom/a/a/a/b/p;->c:Ljava/io/DataOutputStream;

    invoke-static {v0, v1}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;Ljava/io/Closeable;)V

    .line 533
    return-void
.end method
