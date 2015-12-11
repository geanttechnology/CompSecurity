.class final Lcom/google/analytics/tracking/android/aa;
.super Ljava/util/TimerTask;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/google/analytics/tracking/android/v;


# direct methods
.method private constructor <init>(Lcom/google/analytics/tracking/android/v;)V
    .locals 0

    .prologue
    .line 419
    iput-object p1, p0, Lcom/google/analytics/tracking/android/aa;->a:Lcom/google/analytics/tracking/android/v;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/analytics/tracking/android/v;B)V
    .locals 0

    .prologue
    .line 419
    invoke-direct {p0, p1}, Lcom/google/analytics/tracking/android/aa;-><init>(Lcom/google/analytics/tracking/android/v;)V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    .prologue
    .line 422
    iget-object v0, p0, Lcom/google/analytics/tracking/android/aa;->a:Lcom/google/analytics/tracking/android/v;

    iget v0, v0, Lcom/google/analytics/tracking/android/v;->b:I

    sget v1, Lcom/google/analytics/tracking/android/z;->b:I

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/google/analytics/tracking/android/aa;->a:Lcom/google/analytics/tracking/android/v;

    iget-object v0, v0, Lcom/google/analytics/tracking/android/v;->c:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/analytics/tracking/android/aa;->a:Lcom/google/analytics/tracking/android/v;

    iget-wide v0, v0, Lcom/google/analytics/tracking/android/v;->a:J

    iget-object v2, p0, Lcom/google/analytics/tracking/android/aa;->a:Lcom/google/analytics/tracking/android/v;

    iget-wide v2, v2, Lcom/google/analytics/tracking/android/v;->f:J

    add-long/2addr v0, v2

    iget-object v2, p0, Lcom/google/analytics/tracking/android/aa;->a:Lcom/google/analytics/tracking/android/v;

    iget-object v2, v2, Lcom/google/analytics/tracking/android/v;->e:Lcom/google/analytics/tracking/android/m;

    invoke-interface {v2}, Lcom/google/analytics/tracking/android/m;->a()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-gez v0, :cond_0

    .line 425
    const-string v0, "Disconnecting due to inactivity"

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->c(Ljava/lang/String;)V

    .line 426
    iget-object v0, p0, Lcom/google/analytics/tracking/android/aa;->a:Lcom/google/analytics/tracking/android/v;

    invoke-virtual {v0}, Lcom/google/analytics/tracking/android/v;->i()V

    .line 430
    :goto_0
    return-void

    .line 428
    :cond_0
    iget-object v0, p0, Lcom/google/analytics/tracking/android/aa;->a:Lcom/google/analytics/tracking/android/v;

    iget-object v0, v0, Lcom/google/analytics/tracking/android/v;->d:Ljava/util/Timer;

    new-instance v1, Lcom/google/analytics/tracking/android/aa;

    iget-object v2, p0, Lcom/google/analytics/tracking/android/aa;->a:Lcom/google/analytics/tracking/android/v;

    invoke-direct {v1, v2}, Lcom/google/analytics/tracking/android/aa;-><init>(Lcom/google/analytics/tracking/android/v;)V

    iget-object v2, p0, Lcom/google/analytics/tracking/android/aa;->a:Lcom/google/analytics/tracking/android/v;

    iget-wide v2, v2, Lcom/google/analytics/tracking/android/v;->f:J

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    goto :goto_0
.end method
