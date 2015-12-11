.class public Lco/vine/android/InlineRecorderManager$ResumeThread;
.super Ljava/lang/Thread;
.source "InlineRecorderManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/InlineRecorderManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ResumeThread"
.end annotation


# instance fields
.field private mFileToResume:Lco/vine/android/recorder/RecordingFile;

.field final synthetic this$0:Lco/vine/android/InlineRecorderManager;


# direct methods
.method public constructor <init>(Lco/vine/android/InlineRecorderManager;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 329
    iput-object p1, p0, Lco/vine/android/InlineRecorderManager$ResumeThread;->this$0:Lco/vine/android/InlineRecorderManager;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 331
    :try_start_0
    # invokes: Lco/vine/android/InlineRecorderManager;->getNewMessageRecordingFile()Lco/vine/android/recorder/RecordingFile;
    invoke-static {p1}, Lco/vine/android/InlineRecorderManager;->access$700(Lco/vine/android/InlineRecorderManager;)Lco/vine/android/recorder/RecordingFile;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/InlineRecorderManager$ResumeThread;->mFileToResume:Lco/vine/android/recorder/RecordingFile;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 335
    return-void

    .line 332
    :catch_0
    move-exception v0

    .line 333
    .local v0, "e":Ljava/lang/RuntimeException;
    new-instance v1, Ljava/io/IOException;

    const-string v2, "Failed to create new recording file."

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 340
    const-wide/16 v3, 0x5dc

    :try_start_0
    invoke-static {v3, v4}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 344
    :goto_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    .line 345
    .local v1, "start":J
    const-string v3, "Start resuming for inline."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 346
    iget-object v3, p0, Lco/vine/android/InlineRecorderManager$ResumeThread;->this$0:Lco/vine/android/InlineRecorderManager;

    # getter for: Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;
    invoke-static {v3}, Lco/vine/android/InlineRecorderManager;->access$600(Lco/vine/android/InlineRecorderManager;)Lco/vine/android/recorder/InlineVineRecorder;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/recorder/InlineVineRecorder;->initPreviewSurface()V

    .line 347
    iget-object v3, p0, Lco/vine/android/InlineRecorderManager$ResumeThread;->this$0:Lco/vine/android/InlineRecorderManager;

    # getter for: Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;
    invoke-static {v3}, Lco/vine/android/InlineRecorderManager;->access$600(Lco/vine/android/InlineRecorderManager;)Lco/vine/android/recorder/InlineVineRecorder;

    move-result-object v3

    const-string v4, "Inline record"

    iget-object v5, p0, Lco/vine/android/InlineRecorderManager$ResumeThread;->mFileToResume:Lco/vine/android/recorder/RecordingFile;

    invoke-virtual {v3, v4, v5}, Lco/vine/android/recorder/InlineVineRecorder;->swapSession(Ljava/lang/String;Lco/vine/android/recorder/RecordingFile;)Lco/vine/android/recorder/RecordingFile;

    .line 348
    const/4 v3, 0x0

    iput-object v3, p0, Lco/vine/android/InlineRecorderManager$ResumeThread;->mFileToResume:Lco/vine/android/recorder/RecordingFile;

    .line 349
    iget-object v3, p0, Lco/vine/android/InlineRecorderManager$ResumeThread;->this$0:Lco/vine/android/InlineRecorderManager;

    # getter for: Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;
    invoke-static {v3}, Lco/vine/android/InlineRecorderManager;->access$600(Lco/vine/android/InlineRecorderManager;)Lco/vine/android/recorder/InlineVineRecorder;

    move-result-object v3

    const-string v4, "Inline record"

    invoke-virtual {v3, v4, v7, v7}, Lco/vine/android/recorder/InlineVineRecorder;->start(Ljava/lang/String;ZZ)V

    .line 350
    iget-object v3, p0, Lco/vine/android/InlineRecorderManager$ResumeThread;->this$0:Lco/vine/android/InlineRecorderManager;

    # setter for: Lco/vine/android/InlineRecorderManager;->mIsWaitingForResumeThread:Z
    invoke-static {v3, v7}, Lco/vine/android/InlineRecorderManager;->access$902(Lco/vine/android/InlineRecorderManager;Z)Z

    .line 351
    const-string v3, "Inline resume took {}ms."

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    sub-long/2addr v5, v1

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-static {v3, v4}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 352
    return-void

    .line 341
    .end local v1    # "start":J
    :catch_0
    move-exception v0

    .line 342
    .local v0, "e":Ljava/lang/InterruptedException;
    const-string v3, "Failed to sleep wait."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto :goto_0
.end method
