.class public abstract Lco/vine/android/recorder/BaseFinishProcessTask;
.super Landroid/os/AsyncTask;
.source "BaseFinishProcessTask.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Integer;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field public isRunning:Z

.field protected mCurrentMessage:I

.field protected mWaitStartTime:J

.field public final onComplete:Ljava/lang/Runnable;

.field public final releasePreview:Z

.field public final saveSession:Z

.field protected final tag:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/Runnable;ZZ)V
    .locals 0
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "onComplete"    # Ljava/lang/Runnable;
    .param p3, "releasePreview"    # Z
    .param p4, "saveSession"    # Z

    .prologue
    .line 20
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 21
    iput-object p1, p0, Lco/vine/android/recorder/BaseFinishProcessTask;->tag:Ljava/lang/String;

    .line 22
    iput-object p2, p0, Lco/vine/android/recorder/BaseFinishProcessTask;->onComplete:Ljava/lang/Runnable;

    .line 23
    iput-boolean p3, p0, Lco/vine/android/recorder/BaseFinishProcessTask;->releasePreview:Z

    .line 24
    iput-boolean p4, p0, Lco/vine/android/recorder/BaseFinishProcessTask;->saveSession:Z

    .line 25
    return-void
.end method


# virtual methods
.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 10
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/BaseFinishProcessTask;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 5
    .param p1, "aVoid"    # Ljava/lang/Void;

    .prologue
    .line 29
    const-string v0, "Waited for {} ms"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    iget-wide v3, p0, Lco/vine/android/recorder/BaseFinishProcessTask;->mWaitStartTime:J

    sub-long/2addr v1, v3

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 30
    iget-object v0, p0, Lco/vine/android/recorder/BaseFinishProcessTask;->onComplete:Ljava/lang/Runnable;

    if-eqz v0, :cond_0

    .line 31
    iget-object v0, p0, Lco/vine/android/recorder/BaseFinishProcessTask;->onComplete:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 33
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/recorder/BaseFinishProcessTask;->isRunning:Z

    .line 34
    return-void
.end method

.method protected onPreExecute()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 38
    iput v2, p0, Lco/vine/android/recorder/BaseFinishProcessTask;->mCurrentMessage:I

    .line 39
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/recorder/BaseFinishProcessTask;->mWaitStartTime:J

    .line 40
    iput-boolean v2, p0, Lco/vine/android/recorder/BaseFinishProcessTask;->isRunning:Z

    .line 41
    return-void
.end method

.method public publish(I)V
    .locals 3
    .param p1, "value"    # I

    .prologue
    .line 44
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Integer;

    const/4 v1, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/BaseFinishProcessTask;->publishProgress([Ljava/lang/Object;)V

    .line 45
    return-void
.end method
