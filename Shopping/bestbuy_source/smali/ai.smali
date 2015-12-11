.class final Lai;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private a:J

.field private b:I

.field private synthetic c:Lah;


# direct methods
.method private constructor <init>(Lah;)V
    .locals 2

    .prologue
    .line 69
    iput-object p1, p0, Lai;->c:Lah;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 70
    const-wide/16 v0, 0x7530

    iput-wide v0, p0, Lai;->a:J

    .line 71
    const/4 v0, 0x0

    iput v0, p0, Lai;->b:I

    return-void
.end method

.method synthetic constructor <init>(Lah;B)V
    .locals 0

    .prologue
    .line 69
    invoke-direct {p0, p1}, Lai;-><init>(Lah;)V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 5

    .prologue
    .line 75
    const-string v0, "BeaconFlusher task is about to run..."

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 76
    iget-object v0, p0, Lai;->c:Lah;

    invoke-static {v0}, Lah;->c(Lah;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 107
    :goto_0
    return-void

    .line 80
    :cond_0
    iget-object v0, p0, Lai;->c:Lah;

    invoke-static {v0}, Lah;->d(Lah;)Lao;

    move-result-object v0

    invoke-virtual {v0}, Lao;->c()V

    .line 82
    :try_start_0
    iget-object v0, p0, Lai;->c:Lah;

    invoke-static {v0}, Lah;->d(Lah;)Lao;

    move-result-object v0

    invoke-virtual {v0}, Lao;->d()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 83
    const/4 v0, 0x0

    iput v0, p0, Lai;->b:I

    .line 84
    const-wide/16 v0, 0x7530

    iput-wide v0, p0, Lai;->a:J

    .line 85
    iget-object v0, p0, Lai;->c:Lah;

    invoke-virtual {v0}, Lah;->b()V
    :try_end_0
    .catch Lar; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 99
    :catch_0
    move-exception v0

    .line 100
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Agent disabled by collector until "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-wide v2, v0, Lar;->a:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V

    .line 101
    sget-object v1, Ll;->c:Ll;

    .line 102
    if-eqz v1, :cond_1

    .line 103
    invoke-virtual {v1}, Ll;->a()V

    .line 105
    :cond_1
    iget-wide v0, v0, Lar;->a:J

    invoke-static {v0, v1}, Ll;->a(J)V

    goto :goto_0

    .line 87
    :cond_2
    :try_start_1
    iget-object v0, p0, Lai;->c:Lah;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lah;->a(Lah;Z)Z

    .line 88
    iget v0, p0, Lai;->b:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lai;->b:I

    .line 89
    iget v0, p0, Lai;->b:I

    const/4 v1, 0x3

    if-gt v0, v1, :cond_3

    .line 90
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Agent detected network error sending message to collector; trying again in "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-wide v2, p0, Lai;->a:J

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 92
    iget-object v0, p0, Lai;->c:Lah;

    invoke-static {v0}, Lah;->b(Lah;)Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    new-instance v1, Laj;

    iget-object v2, p0, Lai;->c:Lah;

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Laj;-><init>(Lah;B)V

    iget-wide v2, p0, Lai;->a:J

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v0, v1, v2, v3, v4}, Ljava/util/concurrent/ScheduledExecutorService;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 93
    iget-wide v0, p0, Lai;->a:J

    long-to-double v0, v0

    const-wide v2, 0x3ff3333333333333L    # 1.2

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    double-to-long v0, v0

    iput-wide v0, p0, Lai;->a:J

    goto/16 :goto_0

    .line 95
    :cond_3
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Agent detected "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v1, p0, Lai;->b:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " failures in a row; queuing messages until next start up"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V
    :try_end_1
    .catch Lar; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method
