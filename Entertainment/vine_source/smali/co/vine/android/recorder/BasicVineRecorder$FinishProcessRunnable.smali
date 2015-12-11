.class public Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;
.super Ljava/lang/Object;
.source "BasicVineRecorder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/BasicVineRecorder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "FinishProcessRunnable"
.end annotation


# instance fields
.field private isResumed:Z

.field final synthetic this$0:Lco/vine/android/recorder/BasicVineRecorder;


# direct methods
.method public constructor <init>(Lco/vine/android/recorder/BasicVineRecorder;)V
    .locals 0

    .prologue
    .line 737
    iput-object p1, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public doNotDeleteSession(Z)Z
    .locals 0
    .param p1, "isFinishing"    # Z

    .prologue
    .line 755
    return p1
.end method

.method public isCompleteSession(Z)Z
    .locals 0
    .param p1, "wasRecordingStarted"    # Z

    .prologue
    .line 836
    return p1
.end method

.method public onCompleteSessionFinish(Z)V
    .locals 10
    .param p1, "saveSession"    # Z

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 773
    iget-object v7, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v3, v7, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    .line 774
    .local v3, "recordingFile":Lco/vine/android/recorder/RecordingFile;
    if-nez v3, :cond_1

    .line 775
    new-instance v5, Lco/vine/android/VineLoggingException;

    const-string v6, "Failed to stop recording."

    invoke-direct {v5, v6}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-static {v5}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 833
    :cond_0
    :goto_0
    return-void

    .line 778
    :cond_1
    invoke-virtual {v3}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v4

    .line 779
    .local v4, "session":Lco/vine/android/recorder/RecordSession;
    invoke-virtual {v4}, Lco/vine/android/recorder/RecordSession;->calculateAudioCount()I

    move-result v7

    invoke-virtual {v4, v7}, Lco/vine/android/recorder/RecordSession;->setAudioDataCount(I)V

    .line 780
    invoke-virtual {v4}, Lco/vine/android/recorder/RecordSession;->calculateVideoCount()I

    move-result v7

    invoke-virtual {v4, v7}, Lco/vine/android/recorder/RecordSession;->setVideoDataCount(I)V

    .line 782
    iget-object v7, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-boolean v7, v7, Lco/vine/android/recorder/BasicVineRecorder;->mDiscardChanges:Z

    if-nez v7, :cond_b

    .line 783
    iget-object v7, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-boolean v7, v7, Lco/vine/android/recorder/BasicVineRecorder;->mFinished:Z

    if-eqz v7, :cond_6

    invoke-virtual {v3}, Lco/vine/android/recorder/RecordingFile;->hasData()Z

    move-result v7

    if-eqz v7, :cond_6

    iget-object v7, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v7}, Lco/vine/android/recorder/BasicVineRecorder;->canKeepRecording()Z

    move-result v7

    if-nez v7, :cond_6

    move v1, v5

    .line 784
    .local v1, "isFinishing":Z
    :goto_1
    iget-object v7, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {p0, v1}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->doNotDeleteSession(Z)Z

    move-result v8

    iput-boolean v8, v7, Lco/vine/android/recorder/BasicVineRecorder;->mDoNotDeleteSession:Z

    .line 785
    iget-object v7, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v7, v7, Lco/vine/android/recorder/BasicVineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-lez v7, :cond_7

    invoke-virtual {v4}, Lco/vine/android/recorder/RecordSession;->getVideoDataCount()I

    move-result v7

    if-lez v7, :cond_7

    move v2, v5

    .line 786
    .local v2, "isValidSession":Z
    :goto_2
    iget-object v7, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v7, v7, Lco/vine/android/recorder/BasicVineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-lez v7, :cond_2

    if-nez v2, :cond_2

    .line 787
    const-string v7, "Invalid session found."

    invoke-static {v7}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 789
    :cond_2
    if-eqz v2, :cond_9

    .line 791
    :try_start_0
    invoke-static {v3, p1}, Lco/vine/android/recorder/RecordSessionManager;->writeRecordingFile(Lco/vine/android/recorder/RecordingFile;Z)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 808
    :cond_3
    :goto_3
    if-eqz p1, :cond_5

    .line 809
    iget-boolean v7, v3, Lco/vine/android/recorder/RecordingFile;->isLastSession:Z

    if-nez v7, :cond_4

    .line 810
    iput-boolean v5, v3, Lco/vine/android/recorder/RecordingFile;->isSavedSession:Z

    .line 811
    iput-boolean v6, v3, Lco/vine/android/recorder/RecordingFile;->isDirty:Z

    .line 813
    :cond_4
    if-eqz v2, :cond_5

    .line 814
    iget-object v7, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v7, v6}, Lco/vine/android/recorder/BasicVineRecorder;->cleanThumbnails(Z)V

    .line 819
    :cond_5
    if-eqz v1, :cond_0

    .line 820
    iget-object v7, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    if-nez v2, :cond_a

    :goto_4
    invoke-virtual {v7, v5}, Lco/vine/android/recorder/BasicVineRecorder;->startHashTask(Z)V

    goto :goto_0

    .end local v1    # "isFinishing":Z
    .end local v2    # "isValidSession":Z
    :cond_6
    move v1, v6

    .line 783
    goto :goto_1

    .restart local v1    # "isFinishing":Z
    :cond_7
    move v2, v6

    .line 785
    goto :goto_2

    .line 792
    .restart local v2    # "isValidSession":Z
    :catch_0
    move-exception v0

    .line 793
    .local v0, "e":Ljava/io/IOException;
    if-eqz p1, :cond_8

    .line 794
    new-instance v5, Ljava/lang/RuntimeException;

    invoke-direct {v5, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v5

    .line 796
    :cond_8
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Failed to save the files due to IOException: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_3

    .line 800
    .end local v0    # "e":Ljava/io/IOException;
    :cond_9
    iget-object v7, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-boolean v7, v7, Lco/vine/android/recorder/BasicVineRecorder;->mCanKeepRecording:Z

    if-nez v7, :cond_3

    .line 802
    :try_start_1
    iget-object v7, v3, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    const-string v8, "Invalid session"

    invoke-static {v7, v8}, Lco/vine/android/recorder/RecordSessionManager;->deleteSession(Ljava/io/File;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_3

    .line 803
    :catch_1
    move-exception v0

    .line 804
    .restart local v0    # "e":Ljava/io/IOException;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Failed to delete session: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_3

    .end local v0    # "e":Ljava/io/IOException;
    :cond_a
    move v5, v6

    .line 820
    goto :goto_4

    .line 823
    .end local v1    # "isFinishing":Z
    .end local v2    # "isValidSession":Z
    :cond_b
    iget-object v5, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-boolean v5, v5, Lco/vine/android/recorder/BasicVineRecorder;->mDoNotDeleteSession:Z

    if-nez v5, :cond_c

    iget-object v5, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v5, v5, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    iget-boolean v5, v5, Lco/vine/android/recorder/RecordingFile;->isSavedSession:Z

    if-nez v5, :cond_c

    .line 825
    :try_start_2
    const-string v5, "Session {} deleted."

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    iget-object v9, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v9, v9, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    iget-object v9, v9, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    aput-object v9, v7, v8

    invoke-static {v5, v7}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 826
    iget-object v5, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v5, v5, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    iget-object v5, v5, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    const-string v7, "Discard Changes."

    invoke-static {v5, v7}, Lco/vine/android/recorder/RecordSessionManager;->deleteSession(Ljava/io/File;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2

    .line 831
    :cond_c
    :goto_5
    iget-object v5, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v5, v5, Lco/vine/android/recorder/BasicVineRecorder;->mToRemove:Ljava/util/HashSet;

    invoke-virtual {v5}, Ljava/util/HashSet;->clear()V

    goto/16 :goto_0

    .line 827
    :catch_2
    move-exception v0

    .line 828
    .restart local v0    # "e":Ljava/io/IOException;
    const-string v5, "Failed to delete session."

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v0, v5, v6}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_5
.end method

.method public onIncompleteSessionFinish()V
    .locals 1

    .prologue
    .line 746
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-boolean v0, v0, Lco/vine/android/recorder/BasicVineRecorder;->mFinished:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/BasicVineRecorder;->canKeepRecording()Z

    move-result v0

    if-nez v0, :cond_0

    .line 747
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/BasicVineRecorder;->mHashTask:Lco/vine/android/recorder/ReusableHashAsyncTask;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/BasicVineRecorder;->mHashTask:Lco/vine/android/recorder/ReusableHashAsyncTask;

    invoke-virtual {v0}, Lco/vine/android/recorder/ReusableHashAsyncTask;->isComplete()Z

    move-result v0

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->isResumed:Z

    if-nez v0, :cond_0

    .line 748
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->isResumed:Z

    .line 749
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/BasicVineRecorder;->mHashTask:Lco/vine/android/recorder/ReusableHashAsyncTask;

    invoke-virtual {v0}, Lco/vine/android/recorder/ReusableHashAsyncTask;->resumeAll()V

    .line 752
    :cond_0
    return-void
.end method

.method public onMakeRecordingStop(Ljava/lang/String;ZZ)Z
    .locals 5
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "releasePreview"    # Z
    .param p3, "saveSession"    # Z

    .prologue
    const/4 v1, 0x0

    .line 759
    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v2, v2, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    if-eqz v2, :cond_1

    .line 760
    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v2, v2, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v0

    .line 761
    .local v0, "wasRecordingStarted":Z
    const-string v2, "Stop recording in VineRecorder from {} : wasRecordingStarted {} releasePreview {} saveSession {} mDiscardChanges {} mDoNotDeleteSession {} mCurrentRecordingFile {}"

    const/4 v3, 0x7

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p1, v3, v1

    const/4 v1, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v3, v1

    const/4 v1, 0x2

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v3, v1

    const/4 v1, 0x3

    invoke-static {p3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v3, v1

    const/4 v1, 0x4

    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-boolean v4, v4, Lco/vine/android/recorder/BasicVineRecorder;->mDiscardChanges:Z

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v3, v1

    const/4 v1, 0x5

    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-boolean v4, v4, Lco/vine/android/recorder/BasicVineRecorder;->mDoNotDeleteSession:Z

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v3, v1

    const/4 v1, 0x6

    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v4, v4, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    aput-object v4, v3, v1

    invoke-static {v2, v3}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 762
    if-eqz v0, :cond_0

    .line 763
    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v1}, Lco/vine/android/recorder/BasicVineRecorder;->endRelativeTime()Z

    .line 764
    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v2, v2, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    iget-object v3, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-boolean v3, v3, Lco/vine/android/recorder/BasicVineRecorder;->mDiscardChanges:Z

    invoke-virtual {v2, v3, p2}, Lco/vine/android/recorder/RecordController;->stop(ZZ)Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    move-result-object v2

    iput-object v2, v1, Lco/vine/android/recorder/BasicVineRecorder;->grabThumbnailsRunnable:Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    .line 768
    .end local v0    # "wasRecordingStarted":Z
    :cond_0
    :goto_0
    return v0

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method protected onPreCompleteSession(Z)V
    .locals 0
    .param p1, "wasRecordingStarted"    # Z

    .prologue
    .line 851
    return-void
.end method

.method public reset()V
    .locals 1

    .prologue
    .line 742
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->isResumed:Z

    .line 743
    return-void
.end method

.method public declared-synchronized run(Ljava/lang/String;ZZ)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "releasePreview"    # Z
    .param p3, "saveSession"    # Z

    .prologue
    .line 840
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0, p1, p2, p3}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->onMakeRecordingStop(Ljava/lang/String;ZZ)Z

    move-result v0

    .line 841
    .local v0, "wasRecordingStarted":Z
    invoke-virtual {p0, v0}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->onPreCompleteSession(Z)V

    .line 842
    invoke-virtual {p0, v0}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->isCompleteSession(Z)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 843
    invoke-virtual {p0, p3}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->onCompleteSessionFinish(Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 847
    :goto_0
    monitor-exit p0

    return-void

    .line 845
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->onIncompleteSessionFinish()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 840
    .end local v0    # "wasRecordingStarted":Z
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method
