.class public final Lcom/a/a/a/b/x;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static final synthetic f:Z


# instance fields
.field final a:I

.field final b:Lcom/a/a/a/b/q;

.field public c:J

.field d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public final e:Lcom/a/a/a/b/y;

.field private final g:I

.field private final h:I

.field private i:I

.field private final j:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final k:Lcom/a/a/a/b/z;

.field private l:Lcom/a/a/a/b/a;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const-class v0, Lcom/a/a/a/b/x;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/a/a/a/b/x;->f:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method constructor <init>(ILcom/a/a/a/b/q;ZZIILjava/util/List;Lcom/a/a/a/b/k;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/a/a/a/b/q;",
            "ZZII",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/a/a/a/b/k;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a/a/a/b/x;->c:J

    .line 57
    new-instance v0, Lcom/a/a/a/b/y;

    invoke-direct {v0, p0, v2}, Lcom/a/a/a/b/y;-><init>(Lcom/a/a/a/b/x;B)V

    iput-object v0, p0, Lcom/a/a/a/b/x;->e:Lcom/a/a/a/b/y;

    .line 58
    new-instance v0, Lcom/a/a/a/b/z;

    invoke-direct {v0, p0, v2}, Lcom/a/a/a/b/z;-><init>(Lcom/a/a/a/b/x;B)V

    iput-object v0, p0, Lcom/a/a/a/b/x;->k:Lcom/a/a/a/b/z;

    .line 65
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/a/a/a/b/x;->l:Lcom/a/a/a/b/a;

    .line 69
    if-nez p2, :cond_0

    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "connection == null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 70
    :cond_0
    if-nez p7, :cond_1

    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "requestHeaders == null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 71
    :cond_1
    iput p1, p0, Lcom/a/a/a/b/x;->a:I

    .line 72
    iput-object p2, p0, Lcom/a/a/a/b/x;->b:Lcom/a/a/a/b/q;

    .line 73
    iget-object v0, p0, Lcom/a/a/a/b/x;->e:Lcom/a/a/a/b/y;

    invoke-static {v0, p4}, Lcom/a/a/a/b/y;->a(Lcom/a/a/a/b/y;Z)Z

    .line 74
    iget-object v0, p0, Lcom/a/a/a/b/x;->k:Lcom/a/a/a/b/z;

    invoke-static {v0, p3}, Lcom/a/a/a/b/z;->a(Lcom/a/a/a/b/z;Z)Z

    .line 75
    iput p5, p0, Lcom/a/a/a/b/x;->g:I

    .line 76
    iput p6, p0, Lcom/a/a/a/b/x;->h:I

    .line 77
    iput-object p7, p0, Lcom/a/a/a/b/x;->j:Ljava/util/List;

    .line 79
    invoke-virtual {p0, p8}, Lcom/a/a/a/b/x;->a(Lcom/a/a/a/b/k;)V

    .line 80
    return-void
.end method

.method static synthetic a(Lcom/a/a/a/b/x;)I
    .locals 1

    .prologue
    .line 31
    iget v0, p0, Lcom/a/a/a/b/x;->a:I

    return v0
.end method

.method static synthetic b(Lcom/a/a/a/b/x;)Lcom/a/a/a/b/q;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/a/a/a/b/x;->b:Lcom/a/a/a/b/q;

    return-object v0
.end method

.method static synthetic c(Lcom/a/a/a/b/x;)J
    .locals 2

    .prologue
    .line 31
    iget-wide v0, p0, Lcom/a/a/a/b/x;->c:J

    return-wide v0
.end method

.method static synthetic d(Lcom/a/a/a/b/x;)Lcom/a/a/a/b/a;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/a/a/a/b/x;->l:Lcom/a/a/a/b/a;

    return-object v0
.end method

.method private d(Lcom/a/a/a/b/a;)Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 228
    sget-boolean v1, Lcom/a/a/a/b/x;->f:Z

    if-nez v1, :cond_0

    invoke-static {p0}, Ljava/lang/Thread;->holdsLock(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 229
    :cond_0
    monitor-enter p0

    .line 230
    :try_start_0
    iget-object v1, p0, Lcom/a/a/a/b/x;->l:Lcom/a/a/a/b/a;

    if-eqz v1, :cond_1

    .line 231
    monitor-exit p0

    .line 240
    :goto_0
    return v0

    .line 233
    :cond_1
    iget-object v1, p0, Lcom/a/a/a/b/x;->e:Lcom/a/a/a/b/y;

    invoke-static {v1}, Lcom/a/a/a/b/y;->a(Lcom/a/a/a/b/y;)Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/a/a/a/b/x;->k:Lcom/a/a/a/b/z;

    invoke-static {v1}, Lcom/a/a/a/b/z;->a(Lcom/a/a/a/b/z;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 234
    monitor-exit p0

    goto :goto_0

    .line 238
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 236
    :cond_2
    :try_start_1
    iput-object p1, p0, Lcom/a/a/a/b/x;->l:Lcom/a/a/a/b/a;

    .line 237
    invoke-virtual {p0}, Ljava/lang/Object;->notifyAll()V

    .line 238
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 239
    iget-object v0, p0, Lcom/a/a/a/b/x;->b:Lcom/a/a/a/b/q;

    iget v1, p0, Lcom/a/a/a/b/x;->a:I

    invoke-virtual {v0, v1}, Lcom/a/a/a/b/q;->a(I)Lcom/a/a/a/b/x;

    .line 240
    const/4 v0, 0x1

    goto :goto_0
.end method

.method static synthetic e(Lcom/a/a/a/b/x;)V
    .locals 2

    .prologue
    .line 31
    sget-boolean v0, Lcom/a/a/a/b/x;->f:Z

    if-nez v0, :cond_0

    invoke-static {p0}, Ljava/lang/Thread;->holdsLock(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :cond_0
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/b/x;->e:Lcom/a/a/a/b/y;

    invoke-static {v0}, Lcom/a/a/a/b/y;->a(Lcom/a/a/a/b/y;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/a/a/a/b/x;->e:Lcom/a/a/a/b/y;

    invoke-static {v0}, Lcom/a/a/a/b/y;->b(Lcom/a/a/a/b/y;)Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/a/a/a/b/x;->k:Lcom/a/a/a/b/z;

    invoke-static {v0}, Lcom/a/a/a/b/z;->a(Lcom/a/a/a/b/z;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/a/a/a/b/x;->k:Lcom/a/a/a/b/z;

    invoke-static {v0}, Lcom/a/a/a/b/z;->b(Lcom/a/a/a/b/z;)Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_1
    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p0}, Lcom/a/a/a/b/x;->a()Z

    move-result v1

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_4

    sget-object v0, Lcom/a/a/a/b/a;->l:Lcom/a/a/a/b/a;

    invoke-virtual {p0, v0}, Lcom/a/a/a/b/x;->a(Lcom/a/a/a/b/a;)V

    :cond_2
    :goto_1
    return-void

    :cond_3
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :cond_4
    if-nez v1, :cond_2

    iget-object v0, p0, Lcom/a/a/a/b/x;->b:Lcom/a/a/a/b/q;

    iget v1, p0, Lcom/a/a/a/b/x;->a:I

    invoke-virtual {v0, v1}, Lcom/a/a/a/b/q;->a(I)Lcom/a/a/a/b/x;

    goto :goto_1
.end method

.method static synthetic f(Lcom/a/a/a/b/x;)Lcom/a/a/a/b/z;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/a/a/a/b/x;->k:Lcom/a/a/a/b/z;

    return-object v0
.end method

.method static synthetic g(Lcom/a/a/a/b/x;)I
    .locals 1

    .prologue
    .line 31
    iget v0, p0, Lcom/a/a/a/b/x;->i:I

    return v0
.end method


# virtual methods
.method final declared-synchronized a(I)V
    .locals 1

    .prologue
    .line 322
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/b/x;->k:Lcom/a/a/a/b/z;

    invoke-static {v0, p1}, Lcom/a/a/a/b/z;->a(Lcom/a/a/a/b/z;I)I

    .line 323
    invoke-virtual {p0}, Ljava/lang/Object;->notifyAll()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 324
    monitor-exit p0

    return-void

    .line 322
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final a(Lcom/a/a/a/b/a;)V
    .locals 2

    .prologue
    .line 209
    invoke-direct {p0, p1}, Lcom/a/a/a/b/x;->d(Lcom/a/a/a/b/a;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 213
    :goto_0
    return-void

    .line 212
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/b/x;->b:Lcom/a/a/a/b/q;

    iget v1, p0, Lcom/a/a/a/b/x;->a:I

    invoke-virtual {v0, v1, p1}, Lcom/a/a/a/b/q;->b(ILcom/a/a/a/b/a;)V

    goto :goto_0
.end method

.method final a(Lcom/a/a/a/b/k;)V
    .locals 2

    .prologue
    const/high16 v0, 0x10000

    .line 309
    sget-boolean v1, Lcom/a/a/a/b/x;->f:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/a/a/a/b/x;->b:Lcom/a/a/a/b/q;

    invoke-static {v1}, Ljava/lang/Thread;->holdsLock(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 310
    :cond_0
    if-eqz p1, :cond_1

    iget v1, p1, Lcom/a/a/a/b/k;->a:I

    and-int/lit16 v1, v1, 0x80

    if-eqz v1, :cond_1

    iget-object v0, p1, Lcom/a/a/a/b/k;->d:[I

    const/4 v1, 0x7

    aget v0, v0, v1

    :cond_1
    iput v0, p0, Lcom/a/a/a/b/x;->i:I

    .line 313
    return-void
.end method

.method public final declared-synchronized a()Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 93
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/a/a/a/b/x;->l:Lcom/a/a/a/b/a;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_1

    .line 99
    :cond_0
    :goto_0
    monitor-exit p0

    return v0

    .line 96
    :cond_1
    :try_start_1
    iget-object v1, p0, Lcom/a/a/a/b/x;->e:Lcom/a/a/a/b/y;

    invoke-static {v1}, Lcom/a/a/a/b/y;->a(Lcom/a/a/a/b/y;)Z

    move-result v1

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/a/a/a/b/x;->e:Lcom/a/a/a/b/y;

    invoke-static {v1}, Lcom/a/a/a/b/y;->b(Lcom/a/a/a/b/y;)Z

    move-result v1

    if-eqz v1, :cond_4

    :cond_2
    iget-object v1, p0, Lcom/a/a/a/b/x;->k:Lcom/a/a/a/b/z;

    invoke-static {v1}, Lcom/a/a/a/b/z;->a(Lcom/a/a/a/b/z;)Z

    move-result v1

    if-nez v1, :cond_3

    iget-object v1, p0, Lcom/a/a/a/b/x;->k:Lcom/a/a/a/b/z;

    invoke-static {v1}, Lcom/a/a/a/b/z;->b(Lcom/a/a/a/b/z;)Z

    move-result v1

    if-eqz v1, :cond_4

    :cond_3
    iget-object v1, p0, Lcom/a/a/a/b/x;->d:Ljava/util/List;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v1, :cond_0

    .line 99
    :cond_4
    const/4 v0, 0x1

    goto :goto_0

    .line 93
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final b(Lcom/a/a/a/b/a;)V
    .locals 2

    .prologue
    .line 220
    invoke-direct {p0, p1}, Lcom/a/a/a/b/x;->d(Lcom/a/a/a/b/a;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 224
    :goto_0
    return-void

    .line 223
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/b/x;->b:Lcom/a/a/a/b/q;

    iget v1, p0, Lcom/a/a/a/b/x;->a:I

    invoke-virtual {v0, v1, p1}, Lcom/a/a/a/b/q;->a(ILcom/a/a/a/b/a;)V

    goto :goto_0
.end method

.method public final b()Z
    .locals 4

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 104
    iget v0, p0, Lcom/a/a/a/b/x;->a:I

    rem-int/lit8 v0, v0, 0x2

    if-ne v0, v1, :cond_0

    move v0, v1

    .line 105
    :goto_0
    iget-object v3, p0, Lcom/a/a/a/b/x;->b:Lcom/a/a/a/b/q;

    iget-boolean v3, v3, Lcom/a/a/a/b/q;->c:Z

    if-ne v3, v0, :cond_1

    :goto_1
    return v1

    :cond_0
    move v0, v2

    .line 104
    goto :goto_0

    :cond_1
    move v1, v2

    .line 105
    goto :goto_1
.end method

.method public final declared-synchronized c()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 122
    monitor-enter p0

    :goto_0
    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/b/x;->d:Ljava/util/List;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/a/a/a/b/x;->l:Lcom/a/a/a/b/a;

    if-nez v0, :cond_0

    .line 123
    invoke-virtual {p0}, Ljava/lang/Object;->wait()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 129
    :catch_0
    move-exception v0

    .line 130
    :try_start_1
    new-instance v1, Ljava/io/InterruptedIOException;

    invoke-direct {v1}, Ljava/io/InterruptedIOException;-><init>()V

    .line 131
    invoke-virtual {v1, v0}, Ljava/io/InterruptedIOException;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    .line 132
    throw v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 122
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 125
    :cond_0
    :try_start_2
    iget-object v0, p0, Lcom/a/a/a/b/x;->d:Ljava/util/List;

    if-eqz v0, :cond_1

    .line 126
    iget-object v0, p0, Lcom/a/a/a/b/x;->d:Ljava/util/List;
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    monitor-exit p0

    return-object v0

    .line 128
    :cond_1
    :try_start_3
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "stream was reset: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/a/a/a/b/x;->l:Lcom/a/a/a/b/a;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_3
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0
.end method

.method final declared-synchronized c(Lcom/a/a/a/b/a;)V
    .locals 1

    .prologue
    .line 300
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/b/x;->l:Lcom/a/a/a/b/a;

    if-nez v0, :cond_0

    .line 301
    iput-object p1, p0, Lcom/a/a/a/b/x;->l:Lcom/a/a/a/b/a;

    .line 302
    invoke-virtual {p0}, Ljava/lang/Object;->notifyAll()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 304
    :cond_0
    monitor-exit p0

    return-void

    .line 300
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final d()Ljava/io/OutputStream;
    .locals 2

    .prologue
    .line 196
    monitor-enter p0

    .line 197
    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/b/x;->d:Ljava/util/List;

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/a/a/a/b/x;->b()Z

    move-result v0

    if-nez v0, :cond_0

    .line 198
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "reply before requesting the output stream"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 200
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_0
    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 201
    iget-object v0, p0, Lcom/a/a/a/b/x;->k:Lcom/a/a/a/b/z;

    return-object v0
.end method

.method final e()V
    .locals 2

    .prologue
    .line 287
    sget-boolean v0, Lcom/a/a/a/b/x;->f:Z

    if-nez v0, :cond_0

    invoke-static {p0}, Ljava/lang/Thread;->holdsLock(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 289
    :cond_0
    monitor-enter p0

    .line 290
    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/b/x;->e:Lcom/a/a/a/b/y;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/a/a/a/b/y;->a(Lcom/a/a/a/b/y;Z)Z

    .line 291
    invoke-virtual {p0}, Lcom/a/a/a/b/x;->a()Z

    move-result v0

    .line 292
    invoke-virtual {p0}, Ljava/lang/Object;->notifyAll()V

    .line 293
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 294
    if-nez v0, :cond_1

    .line 295
    iget-object v0, p0, Lcom/a/a/a/b/x;->b:Lcom/a/a/a/b/q;

    iget v1, p0, Lcom/a/a/a/b/x;->a:I

    invoke-virtual {v0, v1}, Lcom/a/a/a/b/q;->a(I)Lcom/a/a/a/b/x;

    .line 297
    :cond_1
    return-void

    .line 293
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method
