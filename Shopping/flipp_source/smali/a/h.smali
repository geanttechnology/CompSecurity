.class public final La/h;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<TResult:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# static fields
.field public static final a:Ljava/util/concurrent/ExecutorService;

.field public static final b:Ljava/util/concurrent/Executor;

.field public static final c:Ljava/util/concurrent/Executor;


# instance fields
.field private final d:Ljava/lang/Object;

.field private e:Z

.field private f:Z

.field private g:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TTResult;"
        }
    .end annotation
.end field

.field private h:Ljava/lang/Exception;

.field private i:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "La/g",
            "<TTResult;",
            "Ljava/lang/Void;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    invoke-static {}, La/e;->a()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, La/h;->a:Ljava/util/concurrent/ExecutorService;

    .line 38
    invoke-static {}, La/e;->b()Ljava/util/concurrent/Executor;

    move-result-object v0

    sput-object v0, La/h;->b:Ljava/util/concurrent/Executor;

    .line 43
    invoke-static {}, La/a;->b()Ljava/util/concurrent/Executor;

    move-result-object v0

    sput-object v0, La/h;->c:Ljava/util/concurrent/Executor;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, La/h;->d:Ljava/lang/Object;

    .line 53
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, La/h;->i:Ljava/util/List;

    .line 54
    return-void
.end method

.method public static a(Ljava/lang/Exception;)La/h;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<TResult:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Exception;",
            ")",
            "La/h",
            "<TTResult;>;"
        }
    .end annotation

    .prologue
    .line 137
    invoke-static {}, La/h;->a()La/o;

    move-result-object v0

    .line 138
    invoke-virtual {v0, p0}, La/o;->a(Ljava/lang/Exception;)V

    .line 139
    iget-object v0, v0, La/o;->a:La/h;

    return-object v0
.end method

.method public static a(Ljava/lang/Object;)La/h;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<TResult:",
            "Ljava/lang/Object;",
            ">(TTResult;)",
            "La/h",
            "<TTResult;>;"
        }
    .end annotation

    .prologue
    .line 128
    invoke-static {}, La/h;->a()La/o;

    move-result-object v0

    .line 129
    invoke-virtual {v0, p0}, La/o;->a(Ljava/lang/Object;)V

    .line 130
    iget-object v0, v0, La/o;->a:La/h;

    return-object v0
.end method

.method public static a()La/o;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<TResult:",
            "Ljava/lang/Object;",
            ">()",
            "La/h",
            "<TTResult;>.a/o;"
        }
    .end annotation

    .prologue
    .line 63
    new-instance v0, La/h;

    invoke-direct {v0}, La/h;-><init>()V

    .line 64
    new-instance v1, La/o;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 v2, 0x0

    invoke-direct {v1, v0, v2}, La/o;-><init>(La/h;B)V

    return-object v1
.end method

.method static synthetic a(La/h;Ljava/lang/Exception;)Ljava/lang/Exception;
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, La/h;->h:Ljava/lang/Exception;

    return-object p1
.end method

.method static synthetic a(La/h;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, La/h;->d:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic a(La/h;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, La/h;->g:Ljava/lang/Object;

    return-object p1
.end method

.method static synthetic a(La/o;La/g;La/h;Ljava/util/concurrent/Executor;)V
    .locals 0

    .prologue
    .line 27
    invoke-static {p0, p1, p2, p3}, La/h;->c(La/o;La/g;La/h;Ljava/util/concurrent/Executor;)V

    return-void
.end method

.method private b(La/g;Ljava/util/concurrent/Executor;)La/h;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<TContinuationResult:",
            "Ljava/lang/Object;",
            ">(",
            "La/g",
            "<TTResult;TTContinuationResult;>;",
            "Ljava/util/concurrent/Executor;",
            ")",
            "La/h",
            "<TTContinuationResult;>;"
        }
    .end annotation

    .prologue
    .line 300
    invoke-static {}, La/h;->a()La/o;

    move-result-object v0

    .line 301
    iget-object v1, p0, La/h;->d:Ljava/lang/Object;

    monitor-enter v1

    .line 302
    :try_start_0
    invoke-direct {p0}, La/h;->g()Z

    move-result v2

    .line 303
    if-nez v2, :cond_0

    .line 304
    iget-object v3, p0, La/h;->i:Ljava/util/List;

    new-instance v4, La/k;

    invoke-direct {v4, p0, v0, p1, p2}, La/k;-><init>(La/h;La/o;La/g;Ljava/util/concurrent/Executor;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 312
    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 313
    if-eqz v2, :cond_1

    .line 314
    invoke-static {v0, p1, p0, p2}, La/h;->c(La/o;La/g;La/h;Ljava/util/concurrent/Executor;)V

    .line 316
    :cond_1
    iget-object v0, v0, La/o;->a:La/h;

    return-object v0

    .line 312
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method static synthetic b(La/o;La/g;La/h;Ljava/util/concurrent/Executor;)V
    .locals 0

    .prologue
    .line 27
    invoke-static {p0, p1, p2, p3}, La/h;->d(La/o;La/g;La/h;Ljava/util/concurrent/Executor;)V

    return-void
.end method

.method static synthetic b(La/h;)Z
    .locals 1

    .prologue
    .line 27
    iget-boolean v0, p0, La/h;->e:Z

    return v0
.end method

.method private static c(La/o;La/g;La/h;Ljava/util/concurrent/Executor;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<TContinuationResult:",
            "Ljava/lang/Object;",
            "TResult:",
            "Ljava/lang/Object;",
            ">(",
            "La/h",
            "<TTContinuationResult;>.a/o;",
            "La/g",
            "<TTResult;TTContinuationResult;>;",
            "La/h",
            "<TTResult;>;",
            "Ljava/util/concurrent/Executor;",
            ")V"
        }
    .end annotation

    .prologue
    .line 440
    new-instance v0, La/n;

    invoke-direct {v0, p1, p2, p0}, La/n;-><init>(La/g;La/h;La/o;)V

    invoke-interface {p3, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 451
    return-void
.end method

.method static synthetic c(La/h;)Z
    .locals 1

    .prologue
    .line 27
    const/4 v0, 0x1

    iput-boolean v0, p0, La/h;->e:Z

    return v0
.end method

.method private static d(La/o;La/g;La/h;Ljava/util/concurrent/Executor;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<TContinuationResult:",
            "Ljava/lang/Object;",
            "TResult:",
            "Ljava/lang/Object;",
            ">(",
            "La/h",
            "<TTContinuationResult;>.a/o;",
            "La/g",
            "<TTResult;",
            "La/h",
            "<TTContinuationResult;>;>;",
            "La/h",
            "<TTResult;>;",
            "Ljava/util/concurrent/Executor;",
            ")V"
        }
    .end annotation

    .prologue
    .line 473
    new-instance v0, La/i;

    invoke-direct {v0, p1, p2, p0}, La/i;-><init>(La/g;La/h;La/o;)V

    invoke-interface {p3, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 500
    return-void
.end method

.method static synthetic d(La/h;)Z
    .locals 1

    .prologue
    .line 27
    const/4 v0, 0x1

    iput-boolean v0, p0, La/h;->f:Z

    return v0
.end method

.method static synthetic e(La/h;)V
    .locals 3

    .prologue
    .line 27
    iget-object v1, p0, La/h;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, La/h;->i:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, La/g;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :try_start_1
    invoke-interface {v0, p0}, La/g;->then(La/h;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catch_0
    move-exception v0

    :try_start_2
    throw v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    :catch_1
    move-exception v0

    :try_start_3
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2

    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, La/h;->i:Ljava/util/List;

    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    return-void
.end method

.method public static f()La/h;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<TResult:",
            "Ljava/lang/Object;",
            ">()",
            "La/h",
            "<TTResult;>;"
        }
    .end annotation

    .prologue
    .line 146
    invoke-static {}, La/h;->a()La/o;

    move-result-object v0

    .line 147
    invoke-virtual {v0}, La/o;->a()V

    .line 148
    iget-object v0, v0, La/o;->a:La/h;

    return-object v0
.end method

.method private g()Z
    .locals 2

    .prologue
    .line 72
    iget-object v1, p0, La/h;->d:Ljava/lang/Object;

    monitor-enter v1

    .line 73
    :try_start_0
    iget-boolean v0, p0, La/h;->e:Z

    monitor-exit v1

    return v0

    .line 74
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method public final a(La/g;)La/h;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<TContinuationResult:",
            "Ljava/lang/Object;",
            ">(",
            "La/g",
            "<TTResult;TTContinuationResult;>;)",
            "La/h",
            "<TTContinuationResult;>;"
        }
    .end annotation

    .prologue
    .line 325
    sget-object v0, La/h;->b:Ljava/util/concurrent/Executor;

    invoke-direct {p0, p1, v0}, La/h;->b(La/g;Ljava/util/concurrent/Executor;)La/h;

    move-result-object v0

    return-object v0
.end method

.method public final a(La/g;Ljava/util/concurrent/Executor;)La/h;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<TContinuationResult:",
            "Ljava/lang/Object;",
            ">(",
            "La/g",
            "<TTResult;",
            "La/h",
            "<TTContinuationResult;>;>;",
            "Ljava/util/concurrent/Executor;",
            ")",
            "La/h",
            "<TTContinuationResult;>;"
        }
    .end annotation

    .prologue
    .line 335
    invoke-static {}, La/h;->a()La/o;

    move-result-object v0

    .line 336
    iget-object v1, p0, La/h;->d:Ljava/lang/Object;

    monitor-enter v1

    .line 337
    :try_start_0
    invoke-direct {p0}, La/h;->g()Z

    move-result v2

    .line 338
    if-nez v2, :cond_0

    .line 339
    iget-object v3, p0, La/h;->i:Ljava/util/List;

    new-instance v4, La/l;

    invoke-direct {v4, p0, v0, p1, p2}, La/l;-><init>(La/h;La/o;La/g;Ljava/util/concurrent/Executor;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 347
    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 348
    if-eqz v2, :cond_1

    .line 349
    invoke-static {v0, p1, p0, p2}, La/h;->d(La/o;La/g;La/h;Ljava/util/concurrent/Executor;)V

    .line 351
    :cond_1
    iget-object v0, v0, La/o;->a:La/h;

    return-object v0

    .line 347
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public final b()Z
    .locals 2

    .prologue
    .line 81
    iget-object v1, p0, La/h;->d:Ljava/lang/Object;

    monitor-enter v1

    .line 82
    :try_start_0
    iget-boolean v0, p0, La/h;->f:Z

    monitor-exit v1

    return v0

    .line 83
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public final c()Z
    .locals 2

    .prologue
    .line 90
    iget-object v1, p0, La/h;->d:Ljava/lang/Object;

    monitor-enter v1

    .line 91
    :try_start_0
    iget-object v0, p0, La/h;->h:Ljava/lang/Exception;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 92
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public final d()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TTResult;"
        }
    .end annotation

    .prologue
    .line 99
    iget-object v1, p0, La/h;->d:Ljava/lang/Object;

    monitor-enter v1

    .line 100
    :try_start_0
    iget-object v0, p0, La/h;->g:Ljava/lang/Object;

    monitor-exit v1

    return-object v0

    .line 101
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public final e()Ljava/lang/Exception;
    .locals 2

    .prologue
    .line 108
    iget-object v1, p0, La/h;->d:Ljava/lang/Object;

    monitor-enter v1

    .line 109
    :try_start_0
    iget-object v0, p0, La/h;->h:Ljava/lang/Exception;

    monitor-exit v1

    return-object v0

    .line 110
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
