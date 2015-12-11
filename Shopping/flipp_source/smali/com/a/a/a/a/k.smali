.class final Lcom/a/a/a/a/k;
.super Lcom/a/a/a/a/a;
.source "SourceFile"


# instance fields
.field private final d:Lcom/a/a/a/a/j;

.field private e:I

.field private f:Z


# direct methods
.method constructor <init>(Ljava/io/InputStream;Ljava/net/CacheRequest;Lcom/a/a/a/a/j;)V
    .locals 1

    .prologue
    .line 428
    iget-object v0, p3, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    invoke-direct {p0, p1, v0, p2}, Lcom/a/a/a/a/a;-><init>(Ljava/io/InputStream;Lcom/a/a/a/a/h;Ljava/net/CacheRequest;)V

    .line 423
    const/4 v0, -0x1

    iput v0, p0, Lcom/a/a/a/a/k;->e:I

    .line 424
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/a/a/k;->f:Z

    .line 429
    iput-object p3, p0, Lcom/a/a/a/a/k;->d:Lcom/a/a/a/a/j;

    .line 430
    return-void
.end method


# virtual methods
.method public final available()I
    .locals 2

    .prologue
    .line 480
    invoke-virtual {p0}, Lcom/a/a/a/a/k;->a()V

    .line 481
    iget-boolean v0, p0, Lcom/a/a/a/a/k;->f:Z

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/a/a/a/a/k;->e:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    .line 482
    :cond_0
    const/4 v0, 0x0

    .line 484
    :goto_0
    return v0

    :cond_1
    iget-object v0, p0, Lcom/a/a/a/a/k;->a:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->available()I

    move-result v0

    iget v1, p0, Lcom/a/a/a/a/k;->e:I

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    goto :goto_0
.end method

.method public final close()V
    .locals 1

    .prologue
    .line 488
    iget-boolean v0, p0, Lcom/a/a/a/a/k;->c:Z

    if-eqz v0, :cond_0

    .line 495
    :goto_0
    return-void

    .line 491
    :cond_0
    iget-boolean v0, p0, Lcom/a/a/a/a/k;->f:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/a/a/a/a/k;->b:Lcom/a/a/a/a/h;

    invoke-static {v0, p0}, Lcom/a/a/a/a/j;->a(Lcom/a/a/a/a/h;Ljava/io/InputStream;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 492
    invoke-virtual {p0}, Lcom/a/a/a/a/k;->c()V

    .line 494
    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/a/a/k;->c:Z

    goto :goto_0
.end method

.method public final read([BII)I
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v0, -0x1

    .line 433
    array-length v1, p1

    invoke-static {v1, p2, p3}, Lcom/a/a/a/u;->a(III)V

    .line 434
    invoke-virtual {p0}, Lcom/a/a/a/a/k;->a()V

    .line 436
    iget-boolean v1, p0, Lcom/a/a/a/a/k;->f:Z

    if-nez v1, :cond_1

    .line 452
    :cond_0
    :goto_0
    return v0

    .line 439
    :cond_1
    iget v1, p0, Lcom/a/a/a/a/k;->e:I

    if-eqz v1, :cond_2

    iget v1, p0, Lcom/a/a/a/a/k;->e:I

    if-ne v1, v0, :cond_6

    .line 440
    :cond_2
    iget v1, p0, Lcom/a/a/a/a/k;->e:I

    if-eq v1, v0, :cond_3

    iget-object v1, p0, Lcom/a/a/a/a/k;->a:Ljava/io/InputStream;

    invoke-static {v1}, Lcom/a/a/a/u;->c(Ljava/io/InputStream;)Ljava/lang/String;

    :cond_3
    iget-object v1, p0, Lcom/a/a/a/a/k;->a:Ljava/io/InputStream;

    invoke-static {v1}, Lcom/a/a/a/u;->c(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v1

    const-string v2, ";"

    invoke-virtual {v1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    if-eq v2, v0, :cond_4

    invoke-virtual {v1, v4, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    :cond_4
    :try_start_0
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x10

    invoke-static {v2, v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lcom/a/a/a/a/k;->e:I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    iget v1, p0, Lcom/a/a/a/a/k;->e:I

    if-nez v1, :cond_5

    iput-boolean v4, p0, Lcom/a/a/a/a/k;->f:Z

    iget-object v1, p0, Lcom/a/a/a/a/k;->b:Lcom/a/a/a/a/h;

    iget-object v1, v1, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    iget-object v1, v1, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    iget-object v2, p0, Lcom/a/a/a/a/k;->d:Lcom/a/a/a/a/j;

    iget-object v2, v2, Lcom/a/a/a/a/j;->b:Ljava/io/InputStream;

    invoke-static {v2, v1}, Lcom/a/a/a/a/v;->a(Ljava/io/InputStream;Lcom/a/a/a/a/v;)V

    iget-object v2, p0, Lcom/a/a/a/a/k;->b:Lcom/a/a/a/a/h;

    invoke-virtual {v2, v1}, Lcom/a/a/a/a/h;->a(Lcom/a/a/a/a/v;)V

    invoke-virtual {p0}, Lcom/a/a/a/a/k;->b()V

    .line 441
    :cond_5
    iget-boolean v1, p0, Lcom/a/a/a/a/k;->f:Z

    if-eqz v1, :cond_0

    .line 445
    :cond_6
    iget-object v1, p0, Lcom/a/a/a/a/k;->a:Ljava/io/InputStream;

    iget v2, p0, Lcom/a/a/a/a/k;->e:I

    invoke-static {p3, v2}, Ljava/lang/Math;->min(II)I

    move-result v2

    invoke-virtual {v1, p1, p2, v2}, Ljava/io/InputStream;->read([BII)I

    move-result v1

    .line 446
    if-ne v1, v0, :cond_7

    .line 447
    invoke-virtual {p0}, Lcom/a/a/a/a/k;->c()V

    .line 448
    new-instance v0, Ljava/io/IOException;

    const-string v1, "unexpected end of stream"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 440
    :catch_0
    move-exception v0

    new-instance v0, Ljava/net/ProtocolException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Expected a hex chunk size but was "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 450
    :cond_7
    iget v0, p0, Lcom/a/a/a/a/k;->e:I

    sub-int/2addr v0, v1

    iput v0, p0, Lcom/a/a/a/a/k;->e:I

    .line 451
    invoke-virtual {p0, p1, p2, v1}, Lcom/a/a/a/a/k;->a([BII)V

    move v0, v1

    .line 452
    goto/16 :goto_0
.end method
