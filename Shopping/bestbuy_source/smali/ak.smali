.class final Lak;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Lah;


# direct methods
.method private constructor <init>(Lah;)V
    .locals 0

    .prologue
    .line 122
    iput-object p1, p0, Lak;->a:Lah;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lah;B)V
    .locals 0

    .prologue
    .line 122
    invoke-direct {p0, p1}, Lak;-><init>(Lah;)V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    .prologue
    .line 125
    iget-object v0, p0, Lak;->a:Lah;

    invoke-static {v0}, Lah;->c(Lah;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 126
    const-string v0, "Agent persisting beacon queue state"

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 127
    iget-object v0, p0, Lak;->a:Lah;

    invoke-static {v0}, Lah;->d(Lah;)Lao;

    move-result-object v0

    invoke-virtual {v0}, Lao;->b()V

    .line 128
    iget-object v0, p0, Lak;->a:Lah;

    invoke-static {v0}, Lah;->b(Lah;)Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    const-wide/16 v2, 0x7530

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v0, p0, v2, v3, v1}, Ljava/util/concurrent/ScheduledExecutorService;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 130
    :cond_0
    return-void
.end method
