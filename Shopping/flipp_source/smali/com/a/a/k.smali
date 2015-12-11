.class final Lcom/a/a/k;
.super Ljava/io/FilterOutputStream;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/a/a/f;

.field final synthetic b:Lcom/a/a/a/f;

.field final synthetic c:Lcom/a/a/j;


# direct methods
.method constructor <init>(Lcom/a/a/j;Ljava/io/OutputStream;Lcom/a/a/f;Lcom/a/a/a/f;)V
    .locals 0

    .prologue
    .line 412
    iput-object p1, p0, Lcom/a/a/k;->c:Lcom/a/a/j;

    iput-object p3, p0, Lcom/a/a/k;->a:Lcom/a/a/f;

    iput-object p4, p0, Lcom/a/a/k;->b:Lcom/a/a/a/f;

    invoke-direct {p0, p2}, Ljava/io/FilterOutputStream;-><init>(Ljava/io/OutputStream;)V

    return-void
.end method


# virtual methods
.method public final close()V
    .locals 2

    .prologue
    .line 414
    iget-object v0, p0, Lcom/a/a/k;->c:Lcom/a/a/j;

    iget-object v1, v0, Lcom/a/a/j;->a:Lcom/a/a/f;

    monitor-enter v1

    .line 415
    :try_start_0
    iget-object v0, p0, Lcom/a/a/k;->c:Lcom/a/a/j;

    invoke-static {v0}, Lcom/a/a/j;->a(Lcom/a/a/j;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 416
    monitor-exit v1

    .line 423
    :goto_0
    return-void

    .line 418
    :cond_0
    iget-object v0, p0, Lcom/a/a/k;->c:Lcom/a/a/j;

    invoke-static {v0}, Lcom/a/a/j;->b(Lcom/a/a/j;)Z

    .line 419
    iget-object v0, p0, Lcom/a/a/k;->c:Lcom/a/a/j;

    iget-object v0, v0, Lcom/a/a/j;->a:Lcom/a/a/f;

    invoke-static {v0}, Lcom/a/a/f;->b(Lcom/a/a/f;)I

    .line 420
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 421
    invoke-super {p0}, Ljava/io/FilterOutputStream;->close()V

    .line 422
    iget-object v0, p0, Lcom/a/a/k;->b:Lcom/a/a/a/f;

    invoke-virtual {v0}, Lcom/a/a/a/f;->a()V

    goto :goto_0

    .line 420
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public final write([BII)V
    .locals 1

    .prologue
    .line 428
    iget-object v0, p0, Lcom/a/a/k;->out:Ljava/io/OutputStream;

    invoke-virtual {v0, p1, p2, p3}, Ljava/io/OutputStream;->write([BII)V

    .line 429
    return-void
.end method
