.class public final Ls;
.super Ljava/lang/Thread;
.source "SourceFile"


# instance fields
.field private volatile a:Z

.field private volatile b:I

.field private volatile c:I

.field private volatile d:Lao;

.field private final e:Landroid/os/Handler;

.field private final f:Ljava/lang/Thread;

.field private final g:J

.field private h:Lag;

.field private final i:Lab;

.field private final j:Ljava/lang/Runnable;


# direct methods
.method public constructor <init>(JLab;)V
    .locals 4

    .prologue
    .line 44
    const-wide/16 v0, 0x7d0

    new-instance v2, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    invoke-direct {p0, v0, v1, v2, p3}, Ls;-><init>(JLandroid/os/Handler;Lab;)V

    .line 45
    return-void
.end method

.method private constructor <init>(JLandroid/os/Handler;Lab;)V
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 32
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 21
    iput-boolean v0, p0, Ls;->a:Z

    .line 22
    iput v0, p0, Ls;->b:I

    .line 52
    new-instance v0, Ls$1;

    invoke-direct {v0, p0}, Ls$1;-><init>(Ls;)V

    iput-object v0, p0, Ls;->j:Ljava/lang/Runnable;

    .line 33
    const-wide/16 v0, 0x64

    cmp-long v0, p1, v0

    if-gez v0, :cond_0

    .line 34
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Detection period cannot be less than 100 ms."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 37
    :cond_0
    iput-object p3, p0, Ls;->e:Landroid/os/Handler;

    .line 38
    iput-wide p1, p0, Ls;->g:J

    .line 39
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    iput-object v0, p0, Ls;->f:Ljava/lang/Thread;

    .line 40
    iput-object p4, p0, Ls;->i:Lab;

    .line 41
    return-void
.end method

.method static synthetic a(Ls;)I
    .locals 1

    .prologue
    .line 20
    iget v0, p0, Ls;->b:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Ls;->b:I

    return v0
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 147
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Terminate flag set to true. Interrupting :"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " to stop immediately."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 148
    const/4 v0, 0x1

    iput-boolean v0, p0, Ls;->a:Z

    .line 149
    invoke-virtual {p0}, Ls;->interrupt()V

    .line 150
    return-void
.end method

.method public final a(Lag;)V
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Ls;->h:Lag;

    .line 49
    return-void
.end method

.method public final a(Lao;)V
    .locals 0

    .prologue
    .line 165
    iput-object p1, p0, Ls;->d:Lao;

    .line 166
    return-void
.end method

.method public final b()V
    .locals 1

    .prologue
    .line 153
    iget v0, p0, Ls;->c:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Ls;->c:I

    .line 154
    return-void
.end method

.method public final c()V
    .locals 2

    .prologue
    .line 157
    iget v0, p0, Ls;->c:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Ls;->c:I

    if-nez v0, :cond_0

    .line 158
    monitor-enter p0

    .line 159
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->notify()V

    .line 160
    monitor-exit p0

    .line 162
    :cond_0
    return-void

    .line 160
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public final run()V
    .locals 7

    .prologue
    .line 61
    const-string v0, "ADEum-ANRDetector"

    invoke-virtual {p0, v0}, Ls;->setName(Ljava/lang/String;)V

    .line 62
    const-string v0, "Starting ANRDetector"

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 63
    const/16 v0, 0xa

    invoke-static {v0}, Landroid/os/Process;->setThreadPriority(I)V

    .line 64
    const/4 v0, -0x1

    .line 66
    :cond_0
    :goto_0
    iget-boolean v1, p0, Ls;->a:Z

    if-nez v1, :cond_6

    .line 69
    :goto_1
    :try_start_0
    iget v1, p0, Ls;->c:I

    if-nez v1, :cond_1

    monitor-enter p0
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget v1, p0, Ls;->c:I

    if-lez v1, :cond_3

    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 71
    :cond_1
    :goto_2
    :try_start_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 72
    iget v1, p0, Ls;->b:I

    .line 73
    iget-object v4, p0, Ls;->e:Landroid/os/Handler;

    iget-object v5, p0, Ls;->j:Ljava/lang/Runnable;

    invoke-virtual {v4, v5}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_0

    .line 76
    :try_start_3
    iget-wide v4, p0, Ls;->g:J

    invoke-static {v4, v5}, Ljava/lang/Thread;->sleep(J)V
    :try_end_3
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_0

    .line 82
    :try_start_4
    iget v4, p0, Ls;->b:I

    if-ne v1, v4, :cond_0

    iget v1, p0, Ls;->b:I

    if-eq v1, v0, :cond_0

    .line 83
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v4, "Reporting ANR, before = "

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, ", counter = "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v4, p0, Ls;->b:I

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V

    .line 84
    iget v0, p0, Ls;->b:I

    .line 86
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v4, "Application is not responsive since: "

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    new-instance v4, Ljava/util/Date;

    invoke-direct {v4, v2, v3}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, ". Creating ANR report."

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V

    iget-object v1, p0, Ls;->d:Lao;

    if-eqz v1, :cond_5

    iget-object v1, p0, Ls;->h:Lag;

    if-eqz v1, :cond_5

    iget-object v1, p0, Ls;->h:Lag;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    iget-object v6, p0, Ls;->f:Ljava/lang/Thread;

    invoke-virtual {v6}, Ljava/lang/Thread;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v6

    invoke-virtual/range {v1 .. v6}, Lag;->a(JJ[Ljava/lang/StackTraceElement;)Lorg/json/JSONObject;

    move-result-object v1

    if-eqz v1, :cond_2

    iget-object v2, p0, Ls;->d:Lao;

    invoke-virtual {v2, v1}, Lao;->b(Lorg/json/JSONObject;)V

    const-string v1, "ANR json object has been added to the MetricQueue..."

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V

    :cond_2
    iget-object v1, p0, Ls;->i:Lab;

    sget-object v2, Lad;->b:Lad;

    invoke-virtual {v1, v2}, Lab;->a(Ljava/lang/Object;)V
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_0

    goto/16 :goto_0

    .line 88
    :catch_0
    move-exception v1

    .line 89
    const-string v2, "Error running ANRDetector"

    invoke-static {v2, v1}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 90
    const-string v1, "Error encountered running ANRDetector. Shutting it down..."

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V

    .line 91
    const/4 v1, 0x1

    iput-boolean v1, p0, Ls;->a:Z

    goto/16 :goto_0

    .line 69
    :cond_3
    :try_start_5
    invoke-virtual {p0}, Ljava/lang/Object;->wait()V
    :try_end_5
    .catch Ljava/lang/InterruptedException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    :cond_4
    :try_start_6
    monitor-exit p0

    goto/16 :goto_1

    :catchall_0
    move-exception v1

    monitor-exit p0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    :try_start_7
    throw v1
    :try_end_7
    .catch Ljava/lang/Throwable; {:try_start_7 .. :try_end_7} :catch_0

    :catch_1
    move-exception v1

    :try_start_8
    iget-boolean v1, p0, Ls;->a:Z

    if-eqz v1, :cond_4

    monitor-exit p0
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    goto/16 :goto_2

    .line 86
    :cond_5
    :try_start_9
    const-string v1, "Unable to report ANR because instrumentation has not initialized yet."

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V
    :try_end_9
    .catch Ljava/lang/Throwable; {:try_start_9 .. :try_end_9} :catch_0

    goto/16 :goto_0

    .line 94
    :cond_6
    return-void

    :catch_2
    move-exception v1

    goto/16 :goto_0
.end method
