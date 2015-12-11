.class public Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;
.super Ljava/lang/Object;
.source "ProgressTimer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/ProgressTimer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ProgressTimerRunnable"
.end annotation


# instance fields
.field private hasNotifiedThreshold:Z

.field private final mController:Lco/vine/android/recorder/BasicVineRecorder;

.field private final mHandler:Landroid/os/Handler;

.field private mProgress:I

.field private final mThresholdMs:I

.field public volatile run:Z


# direct methods
.method public constructor <init>(Lco/vine/android/recorder/BasicVineRecorder;Landroid/os/Handler;I)V
    .locals 1
    .param p1, "controller"    # Lco/vine/android/recorder/BasicVineRecorder;
    .param p2, "handler"    # Landroid/os/Handler;
    .param p3, "thresholdMs"    # I

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->mProgress:I

    .line 41
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->run:Z

    .line 44
    iput-object p1, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->mController:Lco/vine/android/recorder/BasicVineRecorder;

    .line 45
    iput-object p2, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->mHandler:Landroid/os/Handler;

    .line 46
    iput p3, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->mThresholdMs:I

    .line 47
    return-void
.end method

.method private exec()V
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 61
    iget-object v1, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->mController:Lco/vine/android/recorder/BasicVineRecorder;

    .line 62
    .local v1, "controller":Lco/vine/android/recorder/BasicVineRecorder;
    :goto_0
    iget-boolean v7, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->run:Z

    if-eqz v7, :cond_2

    .line 63
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    .line 64
    .local v5, "time":J
    invoke-virtual {v1}, Lco/vine/android/recorder/BasicVineRecorder;->getCurrentDuration()J

    move-result-wide v3

    .line 65
    .local v3, "temp":J
    const-wide/16 v7, 0x0

    cmp-long v7, v3, v7

    if-gez v7, :cond_3

    .line 66
    add-long v7, v3, v5

    long-to-int v2, v7

    .line 70
    .local v2, "progress":I
    :goto_1
    iget v7, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->mProgress:I

    if-eq v2, v7, :cond_0

    .line 71
    iput v2, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->mProgress:I

    .line 72
    iget v7, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->mProgress:I

    invoke-virtual {v1, v7}, Lco/vine/android/recorder/BasicVineRecorder;->postProgressUpdate(I)V

    .line 74
    :cond_0
    iget-boolean v7, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->hasNotifiedThreshold:Z

    if-nez v7, :cond_1

    invoke-virtual {v1}, Lco/vine/android/recorder/BasicVineRecorder;->isRecordingSegment()Z

    move-result v7

    if-eqz v7, :cond_1

    iget v7, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->mProgress:I

    iget v8, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->mThresholdMs:I

    if-lt v7, v8, :cond_1

    .line 75
    const/4 v7, 0x1

    iput-boolean v7, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->hasNotifiedThreshold:Z

    .line 76
    iget-object v7, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->mHandler:Landroid/os/Handler;

    new-instance v8, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable$1;

    invoke-direct {v8, p0, v1}, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable$1;-><init>(Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;Lco/vine/android/recorder/BasicVineRecorder;)V

    invoke-virtual {v7, v8}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 83
    :cond_1
    iget-object v7, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->mController:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v7}, Lco/vine/android/recorder/BasicVineRecorder;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v0

    .line 84
    .local v0, "config":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    if-eqz v0, :cond_4

    iget v7, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->mProgress:I

    iget v8, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->maxDuration:I

    if-lt v7, v8, :cond_4

    .line 85
    iget-object v7, p0, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->mHandler:Landroid/os/Handler;

    new-instance v8, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable$2;

    invoke-direct {v8, p0, v1}, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable$2;-><init>(Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;Lco/vine/android/recorder/BasicVineRecorder;)V

    invoke-virtual {v7, v8}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 95
    .end local v0    # "config":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .end local v2    # "progress":I
    .end local v3    # "temp":J
    .end local v5    # "time":J
    :cond_2
    return-void

    .line 68
    .restart local v3    # "temp":J
    .restart local v5    # "time":J
    :cond_3
    long-to-int v2, v3

    .restart local v2    # "progress":I
    goto :goto_1

    .line 93
    .restart local v0    # "config":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    :cond_4
    const-wide/16 v7, 0x23

    invoke-static {v7, v8}, Ljava/lang/Thread;->sleep(J)V

    goto :goto_0
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 52
    :try_start_0
    invoke-direct {p0}, Lco/vine/android/recorder/ProgressTimer$ProgressTimerRunnable;->exec()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 56
    :goto_0
    return-void

    .line 53
    :catch_0
    move-exception v0

    goto :goto_0
.end method
