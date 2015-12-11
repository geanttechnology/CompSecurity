.class final Lcom/a/a/j;
.super Ljava/net/CacheRequest;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/a/a/f;

.field private final b:Lcom/a/a/a/f;

.field private c:Ljava/io/OutputStream;

.field private d:Z

.field private e:Ljava/io/OutputStream;


# direct methods
.method public constructor <init>(Lcom/a/a/f;Lcom/a/a/a/f;)V
    .locals 2

    .prologue
    .line 409
    iput-object p1, p0, Lcom/a/a/j;->a:Lcom/a/a/f;

    invoke-direct {p0}, Ljava/net/CacheRequest;-><init>()V

    .line 410
    iput-object p2, p0, Lcom/a/a/j;->b:Lcom/a/a/a/f;

    .line 411
    const/4 v0, 0x1

    invoke-virtual {p2, v0}, Lcom/a/a/a/f;->a(I)Ljava/io/OutputStream;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/j;->c:Ljava/io/OutputStream;

    .line 412
    new-instance v0, Lcom/a/a/k;

    iget-object v1, p0, Lcom/a/a/j;->c:Ljava/io/OutputStream;

    invoke-direct {v0, p0, v1, p1, p2}, Lcom/a/a/k;-><init>(Lcom/a/a/j;Ljava/io/OutputStream;Lcom/a/a/f;Lcom/a/a/a/f;)V

    iput-object v0, p0, Lcom/a/a/j;->e:Ljava/io/OutputStream;

    .line 431
    return-void
.end method

.method static synthetic a(Lcom/a/a/j;)Z
    .locals 1

    .prologue
    .line 403
    iget-boolean v0, p0, Lcom/a/a/j;->d:Z

    return v0
.end method

.method static synthetic b(Lcom/a/a/j;)Z
    .locals 1

    .prologue
    .line 403
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/j;->d:Z

    return v0
.end method


# virtual methods
.method public final abort()V
    .locals 2

    .prologue
    .line 434
    iget-object v1, p0, Lcom/a/a/j;->a:Lcom/a/a/f;

    monitor-enter v1

    .line 435
    :try_start_0
    iget-boolean v0, p0, Lcom/a/a/j;->d:Z

    if-eqz v0, :cond_0

    .line 436
    monitor-exit v1

    .line 446
    :goto_0
    return-void

    .line 438
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/j;->d:Z

    .line 439
    iget-object v0, p0, Lcom/a/a/j;->a:Lcom/a/a/f;

    invoke-static {v0}, Lcom/a/a/f;->c(Lcom/a/a/f;)I

    .line 440
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 441
    iget-object v0, p0, Lcom/a/a/j;->c:Ljava/io/OutputStream;

    invoke-static {v0}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;)V

    .line 443
    :try_start_1
    iget-object v0, p0, Lcom/a/a/j;->b:Lcom/a/a/a/f;

    invoke-virtual {v0}, Lcom/a/a/a/f;->b()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 446
    :catch_0
    move-exception v0

    goto :goto_0

    .line 440
    :catchall_0
    move-exception v0

    :try_start_2
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0
.end method

.method public final getBody()Ljava/io/OutputStream;
    .locals 1

    .prologue
    .line 449
    iget-object v0, p0, Lcom/a/a/j;->e:Ljava/io/OutputStream;

    return-object v0
.end method
