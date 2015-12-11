.class final Lah;
.super Lr;
.source "SourceFile"


# instance fields
.field private final a:Lao;

.field private final b:Ljava/util/concurrent/ScheduledExecutorService;

.field private final c:Ljava/lang/Runnable;

.field private volatile d:Z

.field private e:Lac;


# direct methods
.method constructor <init>(Lao;Ljava/util/concurrent/ScheduledExecutorService;Lab;)V
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 23
    invoke-direct {p0}, Lr;-><init>()V

    .line 35
    new-instance v0, Lah$1;

    invoke-direct {v0, p0}, Lah$1;-><init>(Lah;)V

    iput-object v0, p0, Lah;->e:Lac;

    .line 24
    iput-object p1, p0, Lah;->a:Lao;

    .line 25
    iput-object p2, p0, Lah;->b:Ljava/util/concurrent/ScheduledExecutorService;

    .line 26
    new-instance v0, Lai;

    invoke-direct {v0, p0, v2}, Lai;-><init>(Lah;B)V

    iput-object v0, p0, Lah;->c:Ljava/lang/Runnable;

    .line 27
    const/4 v0, 0x1

    iput-boolean v0, p0, Lah;->d:Z

    .line 29
    new-instance v1, Lak;

    invoke-direct {v1, p0, v2}, Lak;-><init>(Lah;B)V

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x7530

    sget-object v6, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    move-object v0, p2

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 32
    const-class v0, Lad;

    iget-object v1, p0, Lah;->e:Lac;

    invoke-virtual {p3, v0, v1}, Lab;->a(Ljava/lang/Class;Lac;)V

    .line 33
    return-void
.end method

.method static synthetic a(Lah;)Ljava/lang/Runnable;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lah;->c:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic a(Lah;Z)Z
    .locals 1

    .prologue
    .line 17
    const/4 v0, 0x0

    iput-boolean v0, p0, Lah;->d:Z

    return v0
.end method

.method static synthetic b(Lah;)Ljava/util/concurrent/ScheduledExecutorService;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lah;->b:Ljava/util/concurrent/ScheduledExecutorService;

    return-object v0
.end method

.method static synthetic c(Lah;)Z
    .locals 1

    .prologue
    .line 17
    iget-boolean v0, p0, Lah;->d:Z

    return v0
.end method

.method static synthetic d(Lah;)Lao;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lah;->a:Lao;

    return-object v0
.end method


# virtual methods
.method final a()V
    .locals 2

    .prologue
    .line 62
    iget-object v0, p0, Lah;->b:Ljava/util/concurrent/ScheduledExecutorService;

    iget-object v1, p0, Lah;->c:Ljava/lang/Runnable;

    invoke-interface {v0, v1}, Ljava/util/concurrent/ScheduledExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 63
    return-void
.end method

.method final a(Ljava/lang/Runnable;I)V
    .locals 7

    .prologue
    .line 53
    iget-object v0, p0, Lah;->b:Ljava/util/concurrent/ScheduledExecutorService;

    const-wide/16 v2, 0x0

    int-to-long v4, p2

    sget-object v6, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    move-object v1, p1

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 54
    return-void
.end method

.method final a(Ljava/lang/Runnable;J)V
    .locals 4

    .prologue
    .line 49
    iget-object v0, p0, Lah;->b:Ljava/util/concurrent/ScheduledExecutorService;

    const-wide/16 v2, 0x0

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v0, p1, v2, v3, v1}, Ljava/util/concurrent/ScheduledExecutorService;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 50
    return-void
.end method

.method final b()V
    .locals 1

    .prologue
    .line 66
    const/4 v0, 0x1

    iput-boolean v0, p0, Lah;->d:Z

    .line 67
    return-void
.end method
