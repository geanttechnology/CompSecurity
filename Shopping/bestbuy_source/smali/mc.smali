.class public final Lmc;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:Ljava/util/concurrent/ScheduledExecutorService;

.field private final b:Landroid/app/Activity;

.field private c:Ljava/util/concurrent/ScheduledFuture;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ScheduledFuture",
            "<*>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    new-instance v0, Lmd;

    invoke-direct {v0, v1}, Lmd;-><init>(Lmc$1;)V

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newSingleThreadScheduledExecutor(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    iput-object v0, p0, Lmc;->a:Ljava/util/concurrent/ScheduledExecutorService;

    .line 18
    iput-object v1, p0, Lmc;->c:Ljava/util/concurrent/ScheduledFuture;

    .line 21
    iput-object p1, p0, Lmc;->b:Landroid/app/Activity;

    .line 22
    invoke-virtual {p0}, Lmc;->a()V

    .line 23
    return-void
.end method

.method private c()V
    .locals 2

    .prologue
    .line 33
    iget-object v0, p0, Lmc;->c:Ljava/util/concurrent/ScheduledFuture;

    if-eqz v0, :cond_0

    .line 34
    iget-object v0, p0, Lmc;->c:Ljava/util/concurrent/ScheduledFuture;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Ljava/util/concurrent/ScheduledFuture;->cancel(Z)Z

    .line 35
    const/4 v0, 0x0

    iput-object v0, p0, Lmc;->c:Ljava/util/concurrent/ScheduledFuture;

    .line 37
    :cond_0
    return-void
.end method


# virtual methods
.method public a()V
    .locals 5

    .prologue
    .line 26
    invoke-direct {p0}, Lmc;->c()V

    .line 27
    iget-object v0, p0, Lmc;->a:Ljava/util/concurrent/ScheduledExecutorService;

    new-instance v1, Lmb;

    iget-object v2, p0, Lmc;->b:Landroid/app/Activity;

    invoke-direct {v1, v2}, Lmb;-><init>(Landroid/app/Activity;)V

    const-wide/16 v2, 0x12c

    sget-object v4, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v0, v1, v2, v3, v4}, Ljava/util/concurrent/ScheduledExecutorService;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    move-result-object v0

    iput-object v0, p0, Lmc;->c:Ljava/util/concurrent/ScheduledFuture;

    .line 30
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0}, Lmc;->c()V

    .line 41
    iget-object v0, p0, Lmc;->a:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ScheduledExecutorService;->shutdown()V

    .line 42
    return-void
.end method
