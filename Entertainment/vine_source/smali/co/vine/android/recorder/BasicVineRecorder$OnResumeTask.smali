.class public abstract Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;
.super Landroid/os/AsyncTask;
.source "BasicVineRecorder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/BasicVineRecorder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x404
    name = "OnResumeTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/CharSequence;",
        "Lco/vine/android/recorder/RecordingFile;",
        ">;"
    }
.end annotation


# instance fields
.field public isRunning:Z

.field protected final mClicker:Landroid/view/View;

.field protected mStartTime:J

.field protected final mTag:Ljava/lang/String;

.field public showDialogDelayed:Z

.field final synthetic this$0:Lco/vine/android/recorder/BasicVineRecorder;


# direct methods
.method public constructor <init>(Lco/vine/android/recorder/BasicVineRecorder;Landroid/view/View;Ljava/lang/String;)V
    .locals 0
    .param p2, "view"    # Landroid/view/View;
    .param p3, "tag"    # Ljava/lang/String;

    .prologue
    .line 325
    iput-object p1, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 326
    iput-object p2, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->mClicker:Landroid/view/View;

    .line 327
    iput-object p3, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->mTag:Ljava/lang/String;

    .line 328
    return-void
.end method


# virtual methods
.method protected varargs doInBackground([Ljava/lang/Void;)Lco/vine/android/recorder/RecordingFile;
    .locals 10
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    const/4 v7, 0x1

    const/4 v5, 0x0

    const/4 v9, 0x0

    .line 340
    const-string v6, "OnResume task started from {}."

    new-array v7, v7, [Ljava/lang/Object;

    iget-object v8, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->mTag:Ljava/lang/String;

    aput-object v8, v7, v9

    invoke-static {v6, v7}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 341
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v2, v6, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    .line 342
    .local v2, "controller":Lco/vine/android/recorder/RecordController;
    if-nez v2, :cond_1

    .line 407
    :cond_0
    :goto_0
    return-object v5

    .line 345
    :cond_1
    invoke-virtual {v2}, Lco/vine/android/recorder/RecordController;->wasEncodingThreadRunning()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 346
    invoke-virtual {p0}, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->publishFinishLastSegmentProgress()V

    .line 348
    :try_start_0
    invoke-virtual {v2}, Lco/vine/android/recorder/RecordController;->finishLastIfNeeded()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 352
    :goto_1
    invoke-virtual {p0}, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->publishStartProgres()V

    .line 354
    :cond_2
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v6}, Lco/vine/android/recorder/BasicVineRecorder;->stopProgressTimer()V

    .line 355
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v6}, Lco/vine/android/recorder/BasicVineRecorder;->canKeepRecording()Z

    move-result v6

    if-eqz v6, :cond_7

    .line 356
    const-string v6, "Async open camera"

    invoke-static {v6}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 358
    :try_start_1
    invoke-virtual {p0, v2}, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->onMakingSureCameraReady(Lco/vine/android/recorder/RecordController;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 359
    invoke-virtual {v2}, Lco/vine/android/recorder/RecordController;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v3

    .line 360
    .local v3, "cs":Lco/vine/android/recorder/CameraSetting;
    if-eqz v3, :cond_3

    .line 361
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget v7, v3, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    iput v7, v6, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentFrameRate:I

    .line 363
    :cond_3
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v6, v6, Lco/vine/android/recorder/BasicVineRecorder;->mHashTask:Lco/vine/android/recorder/ReusableHashAsyncTask;

    if-eqz v6, :cond_4

    .line 364
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v6, v6, Lco/vine/android/recorder/BasicVineRecorder;->mHashTask:Lco/vine/android/recorder/ReusableHashAsyncTask;

    invoke-virtual {v6}, Lco/vine/android/recorder/ReusableHashAsyncTask;->reset()V

    .line 366
    :cond_4
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v6}, Lco/vine/android/recorder/BasicVineRecorder;->startProgressTimer()V

    .line 367
    const-string v6, "Open camera successful: {} fps."

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    iget-object v9, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget v9, v9, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentFrameRate:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 368
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v6, v6, Lco/vine/android/recorder/BasicVineRecorder;->mSession:Lco/vine/android/recorder/RecordSession;

    if-eqz v6, :cond_0

    .line 371
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v6, v6, Lco/vine/android/recorder/BasicVineRecorder;->mSession:Lco/vine/android/recorder/RecordSession;

    invoke-virtual {v6}, Lco/vine/android/recorder/RecordSession;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v1

    .line 373
    .local v1, "config":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    :goto_2
    if-eqz v2, :cond_0

    if-eqz v1, :cond_0

    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-wide v6, v6, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentDuration:J

    iget v8, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->maxDuration:I

    int-to-long v8, v8

    cmp-long v6, v6, v8

    if-gez v6, :cond_0

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordController;->isAudioReady()Z

    move-result v6

    if-nez v6, :cond_0

    .line 375
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Wait for audio to be ready. "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 376
    invoke-virtual {p0}, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->isCancelled()Z
    :try_end_1
    .catch Lco/vine/android/VineNotSupportedException; {:try_start_1 .. :try_end_1} :catch_1

    move-result v6

    if-nez v6, :cond_0

    .line 380
    const-wide/16 v6, 0x64

    :try_start_2
    invoke-static {v6, v7}, Ljava/lang/Thread;->sleep(J)V
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Lco/vine/android/VineNotSupportedException; {:try_start_2 .. :try_end_2} :catch_1

    .line 384
    :goto_3
    :try_start_3
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v6, v6, Lco/vine/android/recorder/BasicVineRecorder;->mSession:Lco/vine/android/recorder/RecordSession;

    if-eqz v6, :cond_5

    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v6, v6, Lco/vine/android/recorder/BasicVineRecorder;->mSession:Lco/vine/android/recorder/RecordSession;

    invoke-virtual {v6}, Lco/vine/android/recorder/RecordSession;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v1

    .line 385
    :goto_4
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v2, v6, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;
    :try_end_3
    .catch Lco/vine/android/VineNotSupportedException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_2

    .line 349
    .end local v1    # "config":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .end local v3    # "cs":Lco/vine/android/recorder/CameraSetting;
    :catch_0
    move-exception v4

    .line 350
    .local v4, "e":Ljava/lang/Exception;
    const-string v6, "Failed to finish last one."

    new-array v7, v9, [Ljava/lang/Object;

    invoke-static {v4, v6, v7}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_1

    .end local v4    # "e":Ljava/lang/Exception;
    .restart local v1    # "config":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .restart local v3    # "cs":Lco/vine/android/recorder/CameraSetting;
    :cond_5
    move-object v1, v5

    .line 384
    goto :goto_4

    .line 388
    .end local v1    # "config":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .end local v3    # "cs":Lco/vine/android/recorder/CameraSetting;
    :cond_6
    :try_start_4
    invoke-virtual {p0}, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->isCancelled()Z

    move-result v6

    if-nez v6, :cond_0

    .line 389
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v6}, Lco/vine/android/recorder/BasicVineRecorder;->showCameraFailedToast()V
    :try_end_4
    .catch Lco/vine/android/VineNotSupportedException; {:try_start_4 .. :try_end_4} :catch_1

    goto/16 :goto_0

    .line 392
    :catch_1
    move-exception v4

    .line 393
    .local v4, "e":Lco/vine/android/VineNotSupportedException;
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v6, v4}, Lco/vine/android/recorder/BasicVineRecorder;->onDeviceNotSupported(Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 396
    .end local v4    # "e":Lco/vine/android/VineNotSupportedException;
    :cond_7
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v0, v6, Lco/vine/android/recorder/BasicVineRecorder;->mActivity:Landroid/app/Activity;

    .line 397
    .local v0, "activity":Landroid/app/Activity;
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v6, v6, Lco/vine/android/recorder/BasicVineRecorder;->mHashTask:Lco/vine/android/recorder/ReusableHashAsyncTask;

    if-eqz v6, :cond_8

    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v6, v6, Lco/vine/android/recorder/BasicVineRecorder;->mHashTask:Lco/vine/android/recorder/ReusableHashAsyncTask;

    invoke-virtual {v6}, Lco/vine/android/recorder/ReusableHashAsyncTask;->isComplete()Z

    move-result v6

    if-eqz v6, :cond_8

    if-eqz v0, :cond_8

    .line 398
    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    goto/16 :goto_0

    .line 400
    :cond_8
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v6, v6, Lco/vine/android/recorder/BasicVineRecorder;->mHashTask:Lco/vine/android/recorder/ReusableHashAsyncTask;

    if-eqz v6, :cond_9

    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v6, v6, Lco/vine/android/recorder/BasicVineRecorder;->mHashTask:Lco/vine/android/recorder/ReusableHashAsyncTask;

    invoke-virtual {v6}, Lco/vine/android/recorder/ReusableHashAsyncTask;->getComputedFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v6

    if-eqz v6, :cond_9

    .line 401
    iget-object v5, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v5, v5, Lco/vine/android/recorder/BasicVineRecorder;->mHashTask:Lco/vine/android/recorder/ReusableHashAsyncTask;

    invoke-virtual {v5}, Lco/vine/android/recorder/ReusableHashAsyncTask;->getComputedFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v5

    goto/16 :goto_0

    .line 403
    :cond_9
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v6, v9}, Lco/vine/android/recorder/BasicVineRecorder;->startHashTask(Z)V

    goto/16 :goto_0

    .line 381
    .end local v0    # "activity":Landroid/app/Activity;
    .restart local v1    # "config":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .restart local v3    # "cs":Lco/vine/android/recorder/CameraSetting;
    :catch_2
    move-exception v6

    goto :goto_3
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 315
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->doInBackground([Ljava/lang/Void;)Lco/vine/android/recorder/RecordingFile;

    move-result-object v0

    return-object v0
.end method

.method protected onMakingSureCameraReady(Lco/vine/android/recorder/RecordController;)Z
    .locals 2
    .param p1, "controller"    # Lco/vine/android/recorder/RecordController;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/VineNotSupportedException;
        }
    .end annotation

    .prologue
    .line 335
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-boolean v0, v0, Lco/vine/android/recorder/BasicVineRecorder;->mFrontFacing:Z

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Lco/vine/android/recorder/RecordController;->openDefaultCamera(ZZ)Z

    move-result v0

    return v0
.end method

.method protected onPostExecute(Lco/vine/android/recorder/RecordingFile;)V
    .locals 6
    .param p1, "needHashTask"    # Lco/vine/android/recorder/RecordingFile;

    .prologue
    .line 434
    const/4 v2, 0x0

    iput-boolean v2, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->isRunning:Z

    .line 435
    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->mClicker:Landroid/view/View;

    if-eqz v2, :cond_0

    .line 436
    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->mClicker:Landroid/view/View;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/view/View;->setEnabled(Z)V

    .line 438
    :cond_0
    if-eqz p1, :cond_1

    .line 439
    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v2, v2, Lco/vine/android/recorder/BasicVineRecorder;->mHashTask:Lco/vine/android/recorder/ReusableHashAsyncTask;

    invoke-virtual {v2}, Lco/vine/android/recorder/ReusableHashAsyncTask;->resumeAll()V

    .line 441
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-wide v4, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->mStartTime:J

    sub-long v0, v2, v4

    .line 442
    .local v0, "timeTaken":J
    sget-wide v2, Lco/vine/android/recorder/BasicVineRecorder;->sTimeTaken:J

    cmp-long v2, v0, v2

    if-lez v2, :cond_2

    .line 443
    sput-wide v0, Lco/vine/android/recorder/BasicVineRecorder;->sTimeTaken:J

    .line 445
    :cond_2
    const-string v2, "OnResumeTask took {}ms."

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 446
    return-void
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 315
    check-cast p1, Lco/vine/android/recorder/RecordingFile;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->onPostExecute(Lco/vine/android/recorder/RecordingFile;)V

    return-void
.end method

.method protected onPreExecute()V
    .locals 5

    .prologue
    .line 412
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->mStartTime:J

    .line 413
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->mClicker:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 414
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->mClicker:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setEnabled(Z)V

    .line 416
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/BasicVineRecorder;->canKeepRecording()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 417
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v0

    if-nez v0, :cond_1

    .line 418
    invoke-virtual {p0}, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 420
    :try_start_0
    iget-boolean v0, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->showDialogDelayed:Z

    if-eqz v0, :cond_1

    .line 421
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->isRunning:Z
    :try_end_0
    .catch Landroid/view/WindowManager$BadTokenException; {:try_start_0 .. :try_end_0} :catch_0

    .line 429
    :cond_1
    :goto_0
    const-string v0, "OnResume PreExecute took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    iget-wide v3, p0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->mStartTime:J

    sub-long/2addr v1, v3

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 430
    return-void

    .line 423
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected abstract publishFinishLastSegmentProgress()V
.end method

.method protected abstract publishStartProgres()V
.end method
