.class public abstract Lco/vine/android/recorder/BasicVineRecorder;
.super Ljava/lang/Object;
.source "BasicVineRecorder.java"

# interfaces
.implements Lco/vine/android/recorder/RecordController$OnRecorderControllerStateChangedListener;
.implements Lco/vine/android/player/VideoViewInterface$OnErrorListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;,
        Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;,
        Lco/vine/android/recorder/BasicVineRecorder$ChangeProgressRunnable;,
        Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;,
        Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;
    }
.end annotation


# static fields
.field public static final LOG_RECORDER_INIT_COMPLETE:Ljava/lang/String; = "Recorder fully initialized."

.field public static final PREFS_CAPTURE:Ljava/lang/String; = "capture"

.field public static sTimeTaken:J


# instance fields
.field public detectedInvalidSession:Z

.field public volatile finalFile:Lco/vine/android/recorder/RecordingFile;

.field public grabThumbnailsRunnable:Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

.field protected mActivity:Landroid/app/Activity;

.field protected final mAddedSegments:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/recorder/RecordSegment;",
            ">;"
        }
    .end annotation
.end field

.field private mAlreadyStoppingForUnspportedReasons:Z

.field protected mAutoFocusing:Z

.field protected mCameraView:Landroid/view/View;

.field protected mCanKeepRecording:Z

.field protected final mChangeProgressRunnable:Lco/vine/android/recorder/BasicVineRecorder$ChangeProgressRunnable;

.field protected volatile mCurrentDuration:J

.field protected mCurrentFrameRate:I

.field protected mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

.field protected mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

.field public volatile mDiscardChanges:Z

.field protected mDoNotDeleteSession:Z

.field protected final mEditedSegments:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/recorder/RecordSegment;",
            ">;"
        }
    .end annotation
.end field

.field protected mEnabled:Z

.field protected final mFastEncoding:Z

.field protected final mFinishProcessRunnable:Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;

.field protected mFinished:Z

.field protected mFrontFacing:Z

.field protected final mHandler:Landroid/os/Handler;

.field protected final mHardwareEncoding:Z

.field protected mHashTask:Lco/vine/android/recorder/ReusableHashAsyncTask;

.field protected volatile mIsSwitchingCamera:Z

.field protected mNeverResumedRecorder:Z

.field public volatile mOnCompleteConsumer:Ljava/lang/Runnable;

.field protected mProgressTimer:Lco/vine/android/recorder/ProgressTimer;

.field protected mRecordingFileDuration:I

.field protected mResumeTask:Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;

.field protected mSession:Lco/vine/android/recorder/RecordSession;

.field protected mSwitchCameraTask:Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;

.field protected final mThresholdMs:I

.field protected final mToRemove:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Lco/vine/android/recorder/RecordSegment;",
            ">;"
        }
    .end annotation
.end field

.field protected final mUseMp4:Z

.field protected mVideoController:Lco/vine/android/recorder/RecordController;


# direct methods
.method public constructor <init>(ILandroid/app/Activity;ZZZ)V
    .locals 7
    .param p1, "thresholdMs"    # I
    .param p2, "activity"    # Landroid/app/Activity;
    .param p3, "startWithFrontFacingCamera"    # Z
    .param p4, "hardwareEncoding"    # Z
    .param p5, "useMp4"    # Z

    .prologue
    const/4 v6, 0x1

    .line 86
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    .line 52
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mHandler:Landroid/os/Handler;

    .line 64
    new-instance v0, Lco/vine/android/recorder/BasicVineRecorder$ChangeProgressRunnable;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lco/vine/android/recorder/BasicVineRecorder$ChangeProgressRunnable;-><init>(Lco/vine/android/recorder/BasicVineRecorder;Lco/vine/android/recorder/BasicVineRecorder$1;)V

    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mChangeProgressRunnable:Lco/vine/android/recorder/BasicVineRecorder$ChangeProgressRunnable;

    .line 67
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mAddedSegments:Ljava/util/ArrayList;

    .line 76
    iput-boolean v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mAutoFocusing:Z

    .line 77
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mToRemove:Ljava/util/HashSet;

    .line 78
    iput-boolean v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mEnabled:Z

    .line 87
    iput p1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mThresholdMs:I

    .line 88
    iput-boolean v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mNeverResumedRecorder:Z

    .line 89
    iput-boolean p4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mHardwareEncoding:Z

    .line 90
    invoke-static {p4}, Lco/vine/android/recorder/RecordConfigUtils;->isFastEncoding(Z)Z

    move-result v0

    iput-boolean v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mFastEncoding:Z

    .line 91
    iput-boolean p5, p0, Lco/vine/android/recorder/BasicVineRecorder;->mUseMp4:Z

    .line 92
    new-instance v0, Lco/vine/android/recorder/RecordController;

    iget-boolean v3, p0, Lco/vine/android/recorder/BasicVineRecorder;->mHardwareEncoding:Z

    iget-boolean v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mFastEncoding:Z

    move-object v1, p0

    move-object v2, p2

    move v5, p5

    invoke-direct/range {v0 .. v5}, Lco/vine/android/recorder/RecordController;-><init>(Lco/vine/android/recorder/BasicVineRecorder;Landroid/app/Activity;ZZZ)V

    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    .line 93
    iput-object p2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mActivity:Landroid/app/Activity;

    .line 94
    if-nez p3, :cond_0

    invoke-static {}, Lco/vine/android/recorder/RecordConfigUtils;->isDefaultFrontFacing()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    move v0, v6

    :goto_0
    iput-boolean v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mFrontFacing:Z

    .line 95
    invoke-virtual {p0}, Lco/vine/android/recorder/BasicVineRecorder;->getFinishProcessRunnable()Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mFinishProcessRunnable:Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;

    .line 96
    return-void

    .line 94
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected abstract adjustBoundaries(Lco/vine/android/recorder/CameraSetting;)V
.end method

.method public canKeepRecording()Z
    .locals 1

    .prologue
    .line 138
    iget-boolean v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCanKeepRecording:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mDiscardChanges:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public canSwitchCamera()Z
    .locals 1

    .prologue
    .line 456
    invoke-static {}, Lco/vine/android/recorder/CameraManager;->hasFrontFacingCamera()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lco/vine/android/recorder/CameraManager;->hasBackFacingCamera()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->isRecording()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public changeFocusTo(FF)V
    .locals 3
    .param p1, "x"    # F
    .param p2, "y"    # F

    .prologue
    .line 611
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    float-to-int v1, p1

    float-to-int v2, p2

    invoke-virtual {v0, v1, v2}, Lco/vine/android/recorder/RecordController;->autoFocus(II)V

    .line 612
    return-void
.end method

.method public abstract changeProgress(J)V
.end method

.method public cleanThumbnails(Z)V
    .locals 5
    .param p1, "discardNewOnes"    # Z

    .prologue
    .line 947
    new-instance v3, Ljava/util/HashSet;

    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mToRemove:Ljava/util/HashSet;

    invoke-direct {v3, v4}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 948
    .local v3, "toRemove":Ljava/util/HashSet;, "Ljava/util/HashSet<Lco/vine/android/recorder/RecordSegment;>;"
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mToRemove:Ljava/util/HashSet;

    invoke-virtual {v4}, Ljava/util/HashSet;->clear()V

    .line 949
    if-eqz p1, :cond_0

    .line 950
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mAddedSegments:Ljava/util/ArrayList;

    invoke-virtual {v3, v4}, Ljava/util/HashSet;->addAll(Ljava/util/Collection;)Z

    .line 952
    :cond_0
    invoke-virtual {v3}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/recorder/RecordSegment;

    .line 953
    .local v1, "segment":Lco/vine/android/recorder/RecordSegment;
    invoke-virtual {v1}, Lco/vine/android/recorder/RecordSegment;->getThumbnailPath()Ljava/lang/String;

    move-result-object v2

    .line 954
    .local v2, "thumbnailPath":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 955
    new-instance v4, Ljava/io/File;

    invoke-direct {v4, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v4}, Lorg/apache/commons/io/FileUtils;->deleteQuietly(Ljava/io/File;)Z

    goto :goto_0

    .line 958
    .end local v1    # "segment":Lco/vine/android/recorder/RecordSegment;
    .end local v2    # "thumbnailPath":Ljava/lang/String;
    :cond_2
    return-void
.end method

.method public deleteCurrentDraftFolder(Ljava/lang/String;)Z
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 888
    :try_start_0
    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    iget-object v1, v1, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-static {v1, p1}, Lco/vine/android/recorder/RecordSessionManager;->deleteSession(Ljava/io/File;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 889
    const/4 v1, 0x1

    .line 892
    :goto_0
    return v1

    .line 890
    :catch_0
    move-exception v0

    .line 891
    .local v0, "e":Ljava/io/IOException;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 892
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public declared-synchronized endRelativeTime()Z
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 594
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    if-eqz v0, :cond_0

    .line 595
    const-string v0, "END RELATIVE TIME."

    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 596
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lco/vine/android/recorder/RecordController;->offerLastFrame(Lco/vine/android/recorder/RecordSegment;Lco/vine/android/recorder/VideoData;)V

    .line 597
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->getTimestamp()J

    move-result-wide v0

    long-to-int v0, v0

    iput v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mRecordingFileDuration:I

    .line 598
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/RecordSession;->add(Lco/vine/android/recorder/RecordSegment;)V

    .line 599
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 600
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mAddedSegments:Ljava/util/ArrayList;

    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 601
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lco/vine/android/recorder/RecordingFile;->isDirty:Z

    .line 602
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    .line 603
    iget v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mRecordingFileDuration:I

    int-to-long v0, v0

    iput-wide v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentDuration:J

    .line 604
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/RecordController;->setRecordingAudio(Z)V

    .line 605
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/RecordController;->setRecording(Lco/vine/android/recorder/RecordSegment;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 607
    :cond_0
    monitor-exit p0

    return v3

    .line 594
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected finish(Ljava/lang/String;)V
    .locals 3
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 645
    iput-boolean v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mFinished:Z

    .line 646
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 647
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0, v2, v1}, Lco/vine/android/recorder/BasicVineRecorder;->stop(Ljava/lang/String;Ljava/lang/Runnable;ZZ)V

    .line 648
    iput-boolean v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCanKeepRecording:Z

    .line 654
    :cond_0
    :goto_0
    return-void

    .line 650
    :cond_1
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mOnCompleteConsumer:Ljava/lang/Runnable;

    if-eqz v0, :cond_0

    .line 651
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mOnCompleteConsumer:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    goto :goto_0
.end method

.method public getCameraView()Landroid/view/View;
    .locals 1

    .prologue
    .line 524
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCameraView:Landroid/view/View;

    return-object v0
.end method

.method public getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .locals 2

    .prologue
    .line 147
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mSession:Lco/vine/android/recorder/RecordSession;

    .line 148
    .local v0, "session":Lco/vine/android/recorder/RecordSession;
    if-eqz v0, :cond_0

    .line 149
    invoke-virtual {v0}, Lco/vine/android/recorder/RecordSession;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v1

    .line 151
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getCurrentDuration()J
    .locals 2

    .prologue
    .line 484
    iget-wide v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentDuration:J

    return-wide v0
.end method

.method public getFile()Lco/vine/android/recorder/RecordingFile;
    .locals 1

    .prologue
    .line 488
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    return-object v0
.end method

.method protected getFinishProcessRunnable()Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;
    .locals 1

    .prologue
    .line 99
    new-instance v0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;

    invoke-direct {v0, p0}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;-><init>(Lco/vine/android/recorder/BasicVineRecorder;)V

    return-object v0
.end method

.method public getFinishProcessTask(Ljava/lang/String;Ljava/lang/Runnable;ZZ)Lco/vine/android/recorder/BaseFinishProcessTask;
    .locals 6
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "onComplete"    # Ljava/lang/Runnable;
    .param p3, "releasePreview"    # Z
    .param p4, "saveSession"    # Z

    .prologue
    .line 675
    new-instance v0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;

    if-nez p4, :cond_0

    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    iget-boolean v1, v1, Lco/vine/android/recorder/RecordingFile;->isSavedSession:Z

    if-eqz v1, :cond_1

    :cond_0
    const/4 v5, 0x1

    :goto_0
    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move v4, p3

    invoke-direct/range {v0 .. v5}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;-><init>(Lco/vine/android/recorder/BasicVineRecorder;Ljava/lang/String;Ljava/lang/Runnable;ZZ)V

    return-object v0

    :cond_1
    const/4 v5, 0x0

    goto :goto_0
.end method

.method public getHandler()Landroid/os/Handler;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method public getMemoryResponder()Lco/vine/android/recorder/ByteBufferQueue$MemoryResponder;
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mActivity:Landroid/app/Activity;

    instance-of v0, v0, Lco/vine/android/recorder/ByteBufferQueue$MemoryResponder;

    if-eqz v0, :cond_0

    .line 259
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mActivity:Landroid/app/Activity;

    check-cast v0, Lco/vine/android/recorder/ByteBufferQueue$MemoryResponder;

    .line 261
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getOnCompleteConsumer()Ljava/lang/Runnable;
    .locals 1

    .prologue
    .line 473
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mOnCompleteConsumer:Ljava/lang/Runnable;

    return-object v0
.end method

.method protected abstract getOnDeviceNotSupportedAction()Ljava/lang/Runnable;
.end method

.method public abstract getOnResumeTask(Landroid/view/View;Ljava/lang/String;)Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;
.end method

.method public getThumbnailPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 533
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordingFile;->getThumbnailPath()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTimestamp()J
    .locals 2

    .prologue
    .line 537
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->getTimestamp()J

    move-result-wide v0

    return-wide v0
.end method

.method protected guardedStartRecording(Ljava/lang/String;)V
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 156
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v0

    if-nez v0, :cond_0

    .line 157
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/BasicVineRecorder;->startRecording(Ljava/lang/String;)V

    .line 159
    :cond_0
    return-void
.end method

.method public hasSessionFile()Z
    .locals 1

    .prologue
    .line 239
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public initPreviewSurface()V
    .locals 3

    .prologue
    .line 517
    :try_start_0
    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCameraView:Landroid/view/View;

    invoke-virtual {v1, v2}, Lco/vine/android/recorder/RecordController;->setPreviewSurface(Landroid/view/View;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 521
    :goto_0
    return-void

    .line 518
    :catch_0
    move-exception v0

    .line 519
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Cannot resume."

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected invalidateFinishButton()V
    .locals 0

    .prologue
    .line 927
    return-void
.end method

.method public isCurrentlyRecording()Z
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isFinished()Z
    .locals 1

    .prologue
    .line 657
    iget-boolean v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mFinished:Z

    return v0
.end method

.method public isRecordingSegment()Z
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isResuming()Z
    .locals 2

    .prologue
    .line 528
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mResumeTask:Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;

    .line 529
    .local v0, "task":Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;
    if-eqz v0, :cond_0

    iget-boolean v1, v0, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->isRunning:Z

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isSavedSession()Z
    .locals 1

    .prologue
    .line 694
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    iget-boolean v0, v0, Lco/vine/android/recorder/RecordingFile;->isSavedSession:Z

    return v0
.end method

.method public isSessionDirty()Z
    .locals 1

    .prologue
    .line 710
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    iget-boolean v0, v0, Lco/vine/android/recorder/RecordingFile;->isDirty:Z

    return v0
.end method

.method public modifyAntiBanding(Z)V
    .locals 1
    .param p1, "up"    # Z

    .prologue
    .line 726
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    if-eqz v0, :cond_0

    .line 727
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/RecordController;->modifyAntiBanding(Z)V

    .line 729
    :cond_0
    return-void
.end method

.method public modifyColorEffects(Z)V
    .locals 1
    .param p1, "up"    # Z

    .prologue
    .line 720
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    if-eqz v0, :cond_0

    .line 721
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/RecordController;->modifyColorEffects(Z)V

    .line 723
    :cond_0
    return-void
.end method

.method public modifyExposure(Z)V
    .locals 1
    .param p1, "up"    # Z

    .prologue
    .line 704
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    if-eqz v0, :cond_0

    .line 705
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/RecordController;->modifyExposure(Z)V

    .line 707
    :cond_0
    return-void
.end method

.method public modifySceneMode(Z)V
    .locals 1
    .param p1, "up"    # Z

    .prologue
    .line 714
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    if-eqz v0, :cond_0

    .line 715
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/RecordController;->modifySceneMode(Z)V

    .line 717
    :cond_0
    return-void
.end method

.method public modifyWhiteBalance(Z)V
    .locals 1
    .param p1, "up"    # Z

    .prologue
    .line 698
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    if-eqz v0, :cond_0

    .line 699
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/RecordController;->modifyWhiteBalance(Z)V

    .line 701
    :cond_0
    return-void
.end method

.method public onAutoFocusComplete(Z)V
    .locals 2
    .param p1, "success"    # Z

    .prologue
    .line 493
    const-string v0, "Auto focus {}."

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 494
    return-void
.end method

.method public onCameraReady(Lco/vine/android/recorder/RecordController;)V
    .locals 3
    .param p1, "controller"    # Lco/vine/android/recorder/RecordController;

    .prologue
    .line 546
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mActivity:Landroid/app/Activity;

    if-eqz v0, :cond_0

    .line 547
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->isSurfaceReady()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v0

    if-nez v0, :cond_1

    .line 548
    const-string v0, "Camera ready"

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lco/vine/android/recorder/BasicVineRecorder;->start(Ljava/lang/String;ZZ)V

    .line 553
    :cond_0
    :goto_0
    return-void

    .line 550
    :cond_1
    const-string v0, "Do not start recording: {} {}"

    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v1}, Lco/vine/android/recorder/RecordController;->isSurfaceReady()Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public onDeviceNotSupported(Ljava/lang/Throwable;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Throwable;

    .prologue
    const/4 v2, 0x1

    .line 857
    iget-boolean v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mAlreadyStoppingForUnspportedReasons:Z

    if-nez v0, :cond_1

    .line 858
    iput-boolean v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mAlreadyStoppingForUnspportedReasons:Z

    .line 859
    if-eqz p1, :cond_0

    .line 860
    invoke-static {p1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 861
    const-string v0, "Device not supported happened."

    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 863
    :cond_0
    const-string v0, "OnDeviceNotSupported"

    invoke-virtual {p0}, Lco/vine/android/recorder/BasicVineRecorder;->getOnDeviceNotSupportedAction()Ljava/lang/Runnable;

    move-result-object v1

    invoke-virtual {p0, v0, v1, v2}, Lco/vine/android/recorder/BasicVineRecorder;->stopAndDiscardChanges(Ljava/lang/String;Ljava/lang/Runnable;Z)V

    .line 866
    :cond_1
    return-void
.end method

.method public onError(Lco/vine/android/player/VideoViewInterface;II)Z
    .locals 1
    .param p1, "view"    # Lco/vine/android/player/VideoViewInterface;
    .param p2, "what"    # I
    .param p3, "extra"    # I

    .prologue
    .line 246
    const/4 v0, 0x0

    return v0
.end method

.method public onFinishPressed()V
    .locals 1

    .prologue
    .line 142
    invoke-virtual {p0}, Lco/vine/android/recorder/BasicVineRecorder;->setHasPreviewedAlreadyIfNeeded()V

    .line 143
    const-string v0, "onFinishPressed"

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/BasicVineRecorder;->finish(Ljava/lang/String;)V

    .line 144
    return-void
.end method

.method public onPause()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 625
    iput-boolean v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mNeverResumedRecorder:Z

    .line 626
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mSwitchCameraTask:Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;

    if-eqz v0, :cond_0

    .line 627
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mSwitchCameraTask:Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;

    invoke-virtual {v0, v3}, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->cancel(Z)Z

    .line 629
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mResumeTask:Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;

    if-eqz v0, :cond_1

    .line 630
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Cancel resume task: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mResumeTask:Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 631
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mResumeTask:Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;

    invoke-virtual {v0, v3}, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->cancel(Z)Z

    .line 633
    :cond_1
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mFinishProcessRunnable:Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;

    const-string v1, "onPause"

    invoke-virtual {v0, v1, v3, v2}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->run(Ljava/lang/String;ZZ)V

    .line 634
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->onPause()V

    .line 635
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mHashTask:Lco/vine/android/recorder/ReusableHashAsyncTask;

    if-eqz v0, :cond_2

    .line 636
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mHashTask:Lco/vine/android/recorder/ReusableHashAsyncTask;

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/ReusableHashAsyncTask;->cancel(Z)Z

    .line 638
    :cond_2
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mProgressTimer:Lco/vine/android/recorder/ProgressTimer;

    if-eqz v0, :cond_3

    .line 639
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mProgressTimer:Lco/vine/android/recorder/ProgressTimer;

    invoke-virtual {v0}, Lco/vine/android/recorder/ProgressTimer;->release()V

    .line 640
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mProgressTimer:Lco/vine/android/recorder/ProgressTimer;

    .line 642
    :cond_3
    return-void
.end method

.method public onProgressMaxReached()V
    .locals 0

    .prologue
    .line 480
    return-void
.end method

.method public onProgressThresholdReached()V
    .locals 0

    .prologue
    .line 622
    return-void
.end method

.method public onResume(Ljava/lang/String;Z)V
    .locals 7
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "delayDialog"    # Z

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 961
    invoke-virtual {p0}, Lco/vine/android/recorder/BasicVineRecorder;->canKeepRecording()Z

    move-result v0

    .line 962
    .local v0, "canKeepRecording":Z
    const-string v3, "Resume VineRecorder: delayDialog: {} canKeepRecording: {} isEditing: {} NullFinalFile: {}."

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    aput-object v5, v4, v2

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    aput-object v5, v4, v1

    const/4 v5, 0x2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x3

    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->finalFile:Lco/vine/android/recorder/RecordingFile;

    if-eqz v6, :cond_1

    :goto_0
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    aput-object v1, v4, v5

    invoke-static {v3, v4}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 963
    if-eqz v0, :cond_2

    .line 964
    const/4 v1, 0x0

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "OnResume_"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v1, v3}, Lco/vine/android/recorder/BasicVineRecorder;->getOnResumeTask(Landroid/view/View;Ljava/lang/String;)Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mResumeTask:Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;

    .line 965
    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mResumeTask:Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;

    iput-boolean p2, v1, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->showDialogDelayed:Z

    .line 966
    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mResumeTask:Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 972
    :cond_0
    :goto_1
    return-void

    :cond_1
    move v1, v2

    .line 962
    goto :goto_0

    .line 968
    :cond_2
    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->finalFile:Lco/vine/android/recorder/RecordingFile;

    if-eqz v1, :cond_0

    .line 969
    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mOnCompleteConsumer:Ljava/lang/Runnable;

    invoke-interface {v1}, Ljava/lang/Runnable;->run()V

    goto :goto_1
.end method

.method protected abstract onStop()Z
.end method

.method public onSurfaceReady(Lco/vine/android/recorder/RecordController;)V
    .locals 3
    .param p1, "controller"    # Lco/vine/android/recorder/RecordController;

    .prologue
    const/4 v2, 0x0

    .line 557
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->isCameraReady()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 558
    const-string v0, "Start recording on surface ready."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 559
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v0

    if-nez v0, :cond_0

    .line 560
    const-string v0, "Surface Ready"

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v2, v1}, Lco/vine/android/recorder/BasicVineRecorder;->start(Ljava/lang/String;ZZ)V

    .line 570
    :goto_0
    return-void

    .line 562
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    if-eqz v0, :cond_1

    .line 563
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/BasicVineRecorder;->adjustBoundaries(Lco/vine/android/recorder/CameraSetting;)V

    .line 565
    :cond_1
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->startPreview()V

    goto :goto_0

    .line 568
    :cond_2
    const-string v0, "Do not start recording: {} {}."

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public onUiPaused()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 615
    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mActivity:Landroid/app/Activity;

    .line 616
    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCameraView:Landroid/view/View;

    .line 617
    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mOnCompleteConsumer:Ljava/lang/Runnable;

    .line 618
    invoke-virtual {p0}, Lco/vine/android/recorder/BasicVineRecorder;->onPause()V

    .line 619
    return-void
.end method

.method public onUiResumed(Landroid/app/Activity;Ljava/lang/Runnable;Z)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "onCompleteAsyncTask"    # Ljava/lang/Runnable;
    .param p3, "doNotResumeRecorder"    # Z
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "ShowToast"
        }
    .end annotation

    .prologue
    .line 880
    iput-object p1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mActivity:Landroid/app/Activity;

    .line 881
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/RecordController;->updateRotation(Landroid/app/Activity;)V

    .line 882
    iput-object p2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mOnCompleteConsumer:Ljava/lang/Runnable;

    .line 883
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mFinishProcessRunnable:Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;

    invoke-virtual {v0}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->reset()V

    .line 884
    return-void
.end method

.method public onZoomUpdated(IZ)V
    .locals 0
    .param p1, "zoom"    # I
    .param p2, "stopped"    # Z

    .prologue
    .line 251
    return-void
.end method

.method public postProgressUpdate(I)V
    .locals 2
    .param p1, "progress"    # I

    .prologue
    .line 497
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mChangeProgressRunnable:Lco/vine/android/recorder/BasicVineRecorder$ChangeProgressRunnable;

    iput p1, v0, Lco/vine/android/recorder/BasicVineRecorder$ChangeProgressRunnable;->progress:I

    .line 498
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mChangeProgressRunnable:Lco/vine/android/recorder/BasicVineRecorder$ChangeProgressRunnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 499
    return-void
.end method

.method public receivedFirstFrameAfterStartingPreview()V
    .locals 0

    .prologue
    .line 976
    return-void
.end method

.method public release()Z
    .locals 7

    .prologue
    const/4 v0, 0x0

    const/4 v6, 0x0

    .line 897
    const-string v4, "Recorder Released."

    invoke-static {v4}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 898
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v4}, Lco/vine/android/recorder/RecordController;->releaseParent()V

    .line 899
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v4}, Lco/vine/android/recorder/RecordController;->releaseCameraResources()V

    .line 900
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v4}, Lco/vine/android/recorder/RecordController;->releaseResources()V

    .line 901
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v4}, Lco/vine/android/recorder/RecordController;->releaseCallbacks()V

    .line 902
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v4}, Lco/vine/android/recorder/RecordController;->logPreviewSizeExceptionIfNeeded()V

    .line 903
    const/4 v2, 0x0

    .line 904
    .local v2, "sessionDeleted":Z
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    if-eqz v4, :cond_1

    .line 905
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    iget-object v1, v4, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    .line 906
    .local v1, "folder":Ljava/io/File;
    iget-boolean v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mDoNotDeleteSession:Z

    if-nez v4, :cond_3

    invoke-static {v1}, Lco/vine/android/recorder/RecordSessionManager;->isSessionSaved(Ljava/io/File;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 907
    const-string v4, "release"

    invoke-virtual {p0, v4}, Lco/vine/android/recorder/BasicVineRecorder;->deleteCurrentDraftFolder(Ljava/lang/String;)Z

    move-result v2

    .line 914
    :cond_0
    :goto_0
    const-string v4, "Session deleted: {}"

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 916
    .end local v1    # "folder":Ljava/io/File;
    :cond_1
    iput-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mSession:Lco/vine/android/recorder/RecordSession;

    .line 917
    iput-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    .line 918
    iput-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    .line 919
    iput-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    .line 920
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mAddedSegments:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->clear()V

    .line 921
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-lez v4, :cond_2

    if-eqz v2, :cond_2

    const/4 v0, 0x1

    .line 922
    .local v0, "abandoned":Z
    :cond_2
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->clear()V

    .line 923
    return v0

    .line 909
    .end local v0    # "abandoned":Z
    .restart local v1    # "folder":Ljava/io/File;
    :cond_3
    invoke-static {v1, v0}, Lco/vine/android/recorder/RecordSessionManager;->getDataFile(Ljava/io/File;Z)Ljava/io/File;

    move-result-object v3

    .line 910
    .local v3, "temporaryDataFile":Ljava/io/File;
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 911
    invoke-static {v3}, Lorg/apache/commons/io/FileUtils;->deleteQuietly(Ljava/io/File;)Z

    goto :goto_0
.end method

.method public setCameraView(Landroid/view/View;)V
    .locals 0
    .param p1, "cameraView"    # Landroid/view/View;

    .prologue
    .line 512
    iput-object p1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCameraView:Landroid/view/View;

    .line 513
    return-void
.end method

.method public setDiscardChanges(Z)V
    .locals 0
    .param p1, "discardChanges"    # Z

    .prologue
    .line 541
    iput-boolean p1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mDiscardChanges:Z

    .line 542
    return-void
.end method

.method public setEnabled(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 130
    iput-boolean p1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mEnabled:Z

    .line 131
    return-void
.end method

.method public setFinalFile(Lco/vine/android/recorder/RecordingFile;)V
    .locals 0
    .param p1, "recordingFile"    # Lco/vine/android/recorder/RecordingFile;

    .prologue
    .line 477
    iput-object p1, p0, Lco/vine/android/recorder/BasicVineRecorder;->finalFile:Lco/vine/android/recorder/RecordingFile;

    .line 478
    return-void
.end method

.method protected setHasPreviewedAlreadyIfNeeded()V
    .locals 0

    .prologue
    .line 929
    return-void
.end method

.method protected abstract showCameraFailedToast()V
.end method

.method public showFocusIndicator(II)V
    .locals 0
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 481
    return-void
.end method

.method public start(Ljava/lang/String;ZZ)V
    .locals 7
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "stopPrevious"    # Z
    .param p3, "adjustBoundaries"    # Z

    .prologue
    const/4 v6, 0x1

    const/4 v4, 0x0

    .line 107
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 108
    .local v0, "start":J
    iget-boolean v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCanKeepRecording:Z

    if-nez v2, :cond_0

    .line 109
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "You cannot start recording again if it is finished."

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 110
    const-string v2, "Start failed."

    invoke-static {v2}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 126
    :goto_0
    const-string v2, "Start called from {} took {}ms."

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p1, v3, v4

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long/2addr v4, v0

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v2, v3}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 127
    return-void

    .line 112
    :cond_0
    if-eqz p3, :cond_1

    .line 113
    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordController;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v2

    invoke-virtual {p0, v2}, Lco/vine/android/recorder/BasicVineRecorder;->adjustBoundaries(Lco/vine/android/recorder/CameraSetting;)V

    .line 115
    :cond_1
    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v2

    if-eqz v2, :cond_2

    if-eqz p2, :cond_2

    .line 116
    const-string v2, "stopPrevious"

    new-instance v3, Lco/vine/android/recorder/BasicVineRecorder$1;

    invoke-direct {v3, p0, p1}, Lco/vine/android/recorder/BasicVineRecorder$1;-><init>(Lco/vine/android/recorder/BasicVineRecorder;Ljava/lang/String;)V

    invoke-virtual {p0, v2, v3, v6, v4}, Lco/vine/android/recorder/BasicVineRecorder;->stop(Ljava/lang/String;Ljava/lang/Runnable;ZZ)V

    goto :goto_0

    .line 123
    :cond_2
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/BasicVineRecorder;->guardedStartRecording(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected startHashTask(Z)V
    .locals 4
    .param p1, "detectedInvalidSession"    # Z

    .prologue
    .line 450
    new-instance v0, Lco/vine/android/recorder/ReusableHashAsyncTask;

    invoke-direct {v0, p0}, Lco/vine/android/recorder/ReusableHashAsyncTask;-><init>(Lco/vine/android/recorder/BasicVineRecorder;)V

    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mHashTask:Lco/vine/android/recorder/ReusableHashAsyncTask;

    .line 451
    iput-boolean p1, p0, Lco/vine/android/recorder/BasicVineRecorder;->detectedInvalidSession:Z

    .line 452
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mHashTask:Lco/vine/android/recorder/ReusableHashAsyncTask;

    const/4 v1, 0x1

    new-array v1, v1, [Lco/vine/android/recorder/RecordingFile;

    const/4 v2, 0x0

    iget-object v3, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/ReusableHashAsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 453
    return-void
.end method

.method protected startProgressTimer()V
    .locals 3

    .prologue
    .line 468
    new-instance v0, Lco/vine/android/recorder/ProgressTimer;

    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mHandler:Landroid/os/Handler;

    iget v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mThresholdMs:I

    invoke-direct {v0, p0, v1, v2}, Lco/vine/android/recorder/ProgressTimer;-><init>(Lco/vine/android/recorder/BasicVineRecorder;Landroid/os/Handler;I)V

    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mProgressTimer:Lco/vine/android/recorder/ProgressTimer;

    .line 469
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mProgressTimer:Lco/vine/android/recorder/ProgressTimer;

    invoke-virtual {v0}, Lco/vine/android/recorder/ProgressTimer;->start()V

    .line 470
    return-void
.end method

.method protected declared-synchronized startRecording(Ljava/lang/String;)V
    .locals 11
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 166
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mActivity:Landroid/app/Activity;

    .line 167
    .local v0, "activity":Landroid/app/Activity;
    const-string v6, "Start recording called from {}."

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object p1, v7, v8

    invoke-static {v6, v7}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 168
    if-eqz v0, :cond_6

    .line 169
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v6}, Lco/vine/android/recorder/RecordController;->isCameraReady()Z

    move-result v2

    .line 170
    .local v2, "isCameraReady":Z
    if-nez v2, :cond_0

    .line 171
    const-string v6, "Start recording."

    invoke-static {v6}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 173
    :try_start_1
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    iget-boolean v7, p0, Lco/vine/android/recorder/BasicVineRecorder;->mFrontFacing:Z

    const/4 v8, 0x0

    invoke-virtual {v6, v7, v8}, Lco/vine/android/recorder/RecordController;->openDefaultCamera(ZZ)Z
    :try_end_1
    .catch Lco/vine/android/VineNotSupportedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v2

    .line 178
    :cond_0
    :goto_0
    if-eqz v2, :cond_7

    .line 179
    :try_start_2
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v6}, Lco/vine/android/recorder/RecordController;->isPreviewing()Z

    move-result v6

    if-nez v6, :cond_1

    .line 180
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v6}, Lco/vine/android/recorder/RecordController;->startPreview()V

    .line 182
    :cond_1
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    invoke-virtual {v6}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v3

    .line 183
    .local v3, "session":Lco/vine/android/recorder/RecordSession;
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v6}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v6

    if-nez v6, :cond_4

    .line 184
    invoke-virtual {v3}, Lco/vine/android/recorder/RecordSession;->calculateAudioCount()I

    move-result v6

    invoke-virtual {v3, v6}, Lco/vine/android/recorder/RecordSession;->setAudioDataCount(I)V

    .line 185
    invoke-virtual {v3}, Lco/vine/android/recorder/RecordSession;->calculateVideoCount()I

    move-result v6

    invoke-virtual {v3, v6}, Lco/vine/android/recorder/RecordSession;->setVideoDataCount(I)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 187
    :try_start_3
    iget-boolean v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mHardwareEncoding:Z

    if-nez v6, :cond_3

    .line 188
    invoke-virtual {v3}, Lco/vine/android/recorder/RecordSession;->getVersion()Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v6

    sget-object v7, Lco/vine/android/recorder/RecordSessionVersion;->SW_MP4:Lco/vine/android/recorder/RecordSessionVersion;

    if-ne v6, v7, :cond_2

    .line 189
    invoke-static {}, Lco/vine/android/recorder/EncoderManager;->tryLoad()V

    .line 191
    :cond_2
    invoke-static {}, Lcom/googlecode/javacv/cpp/opencv_imgproc;->tryLoad()V

    .line 193
    :cond_3
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 194
    .local v4, "start":J
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    iget-object v7, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    invoke-virtual {v7}, Lco/vine/android/recorder/RecordingFile;->getVideoPath()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3}, Lco/vine/android/recorder/RecordSession;->getAudioDataCount()I

    move-result v8

    invoke-virtual {v3}, Lco/vine/android/recorder/RecordSession;->getVideoDataCount()I

    move-result v9

    invoke-virtual {v6, v0, v7, v8, v9}, Lco/vine/android/recorder/RecordController;->start(Landroid/app/Activity;Ljava/lang/String;II)Z

    .line 195
    const-string v6, "Start recording: {} took {}ms."

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    iget-object v9, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    invoke-virtual {v9}, Lco/vine/android/recorder/RecordingFile;->getVideoPath()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v9

    sub-long/2addr v9, v4

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_3
    .catch Ljava/lang/NoClassDefFoundError; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/lang/ExceptionInInitializerError; {:try_start_3 .. :try_end_3} :catch_1
    .catch Lco/vine/android/recorder/RecordController$RecordControllerReadyStartedException; {:try_start_3 .. :try_end_3} :catch_2
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 205
    .end local v3    # "session":Lco/vine/android/recorder/RecordSession;
    .end local v4    # "start":J
    :cond_4
    :goto_1
    :try_start_4
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v6}, Lco/vine/android/recorder/RecordController;->waitForPreviewToStart()V

    .line 206
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v6}, Lco/vine/android/recorder/RecordController;->isPreviewing()Z

    move-result v6

    if-nez v6, :cond_5

    .line 207
    iget-object v6, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v6}, Lco/vine/android/recorder/RecordController;->startPreview()V

    .line 209
    :cond_5
    const-string v6, "TestLog"

    const-string v7, "Recorder fully initialized."

    invoke-static {v6, v7}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 211
    .end local v2    # "isCameraReady":Z
    :cond_6
    monitor-exit p0

    return-void

    .line 174
    .restart local v2    # "isCameraReady":Z
    :catch_0
    move-exception v1

    .line 175
    .local v1, "e":Lco/vine/android/VineNotSupportedException;
    :try_start_5
    invoke-virtual {p0, v1}, Lco/vine/android/recorder/BasicVineRecorder;->onDeviceNotSupported(Ljava/lang/Throwable;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto/16 :goto_0

    .line 166
    .end local v0    # "activity":Landroid/app/Activity;
    .end local v1    # "e":Lco/vine/android/VineNotSupportedException;
    .end local v2    # "isCameraReady":Z
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6

    .line 196
    .restart local v0    # "activity":Landroid/app/Activity;
    .restart local v2    # "isCameraReady":Z
    .restart local v3    # "session":Lco/vine/android/recorder/RecordSession;
    :catch_1
    move-exception v1

    .line 197
    .local v1, "e":Ljava/lang/LinkageError;
    :try_start_6
    invoke-virtual {p0, v1}, Lco/vine/android/recorder/BasicVineRecorder;->onDeviceNotSupported(Ljava/lang/Throwable;)V

    goto :goto_1

    .line 198
    .end local v1    # "e":Ljava/lang/LinkageError;
    :catch_2
    move-exception v1

    .line 199
    .local v1, "e":Lco/vine/android/recorder/RecordController$RecordControllerReadyStartedException;
    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_1

    .line 203
    .end local v1    # "e":Lco/vine/android/recorder/RecordController$RecordControllerReadyStartedException;
    .end local v3    # "session":Lco/vine/android/recorder/RecordSession;
    :cond_7
    invoke-virtual {p0}, Lco/vine/android/recorder/BasicVineRecorder;->showCameraFailedToast()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto :goto_1
.end method

.method public startRelativeTime()Z
    .locals 6

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 573
    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mSession:Lco/vine/android/recorder/RecordSession;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mSession:Lco/vine/android/recorder/RecordSession;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordSession;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-boolean v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCanKeepRecording:Z

    if-eqz v2, :cond_0

    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordController;->isCameraReady()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-wide v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentDuration:J

    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mSession:Lco/vine/android/recorder/RecordSession;

    invoke-virtual {v4}, Lco/vine/android/recorder/RecordSession;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v4

    iget v4, v4, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->maxDuration:I

    int-to-long v4, v4

    cmp-long v2, v2, v4

    if-gez v2, :cond_0

    .line 577
    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    if-eqz v2, :cond_1

    .line 578
    invoke-virtual {p0}, Lco/vine/android/recorder/BasicVineRecorder;->endRelativeTime()Z

    move-result v2

    if-nez v2, :cond_1

    .line 589
    :cond_0
    :goto_0
    return v0

    .line 582
    :cond_1
    iget v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mRecordingFileDuration:I

    int-to-long v2, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long/2addr v2, v4

    iput-wide v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentDuration:J

    .line 583
    new-instance v0, Lco/vine/android/recorder/RecordSegment;

    iget-wide v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentDuration:J

    invoke-direct {v0, v2, v3}, Lco/vine/android/recorder/RecordSegment;-><init>(J)V

    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    .line 584
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "START RELATIVE TIME: "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " bc: "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget v2, Lco/vine/android/recorder/CameraManager;->sCameraBufferCount:I

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ", added: "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lco/vine/android/recorder/CameraManager;->getInstance()Lco/vine/android/recorder/CameraManager;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/recorder/CameraManager;->getAddedBufferArrayCount()I

    move-result v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 585
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/RecordController;->setRecordingAudio(Z)V

    .line 586
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/RecordController;->setRecording(Lco/vine/android/recorder/RecordSegment;)V

    move v0, v1

    .line 587
    goto :goto_0
.end method

.method protected stop(Ljava/lang/String;Ljava/lang/Runnable;ZZ)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "onComplete"    # Ljava/lang/Runnable;
    .param p3, "releasePreview"    # Z
    .param p4, "saveSession"    # Z

    .prologue
    .line 667
    invoke-virtual {p0}, Lco/vine/android/recorder/BasicVineRecorder;->onStop()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 668
    invoke-virtual {p0, p1, p2, p3, p4}, Lco/vine/android/recorder/BasicVineRecorder;->getFinishProcessTask(Ljava/lang/String;Ljava/lang/Runnable;ZZ)Lco/vine/android/recorder/BaseFinishProcessTask;

    move-result-object v0

    .line 669
    .local v0, "finishProcessTask":Lco/vine/android/recorder/BaseFinishProcessTask;
    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v1, v0}, Lco/vine/android/recorder/RecordController;->setFinishProcessTask(Lco/vine/android/recorder/BaseFinishProcessTask;)V

    .line 670
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/BaseFinishProcessTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 672
    .end local v0    # "finishProcessTask":Lco/vine/android/recorder/BaseFinishProcessTask;
    :cond_0
    return-void
.end method

.method public stopAndDiscardChanges(Ljava/lang/String;Ljava/lang/Runnable;Z)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "onComplete"    # Ljava/lang/Runnable;
    .param p3, "releasePreview"    # Z

    .prologue
    .line 871
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/BasicVineRecorder;->setDiscardChanges(Z)V

    .line 872
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mFinishProcessRunnable:Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, p3, v1}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->run(Ljava/lang/String;ZZ)V

    .line 873
    if-eqz p2, :cond_0

    .line 874
    invoke-interface {p2}, Ljava/lang/Runnable;->run()V

    .line 876
    :cond_0
    return-void
.end method

.method protected stopProgressTimer()V
    .locals 1

    .prologue
    .line 461
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mProgressTimer:Lco/vine/android/recorder/ProgressTimer;

    if-eqz v0, :cond_0

    .line 462
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mProgressTimer:Lco/vine/android/recorder/ProgressTimer;

    invoke-virtual {v0}, Lco/vine/android/recorder/ProgressTimer;->release()V

    .line 463
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mProgressTimer:Lco/vine/android/recorder/ProgressTimer;

    .line 465
    :cond_0
    return-void
.end method

.method public swapSession(Ljava/lang/String;Lco/vine/android/recorder/RecordingFile;)Lco/vine/android/recorder/RecordingFile;
    .locals 5
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "file"    # Lco/vine/android/recorder/RecordingFile;

    .prologue
    const/4 v4, 0x1

    const/4 v1, 0x0

    .line 214
    if-eqz p2, :cond_1

    .line 215
    const-string v0, "Swap new Recorder for {} from {}."

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p1, v2, v1

    iget-object v3, p2, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v0, v2}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 216
    invoke-virtual {p2}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mSession:Lco/vine/android/recorder/RecordSession;

    .line 217
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 218
    const-string v2, "[session] Swapping file {} for {}."

    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    if-nez v0, :cond_2

    move v0, v1

    :goto_0
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p2}, Ljava/lang/Object;->hashCode()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v2, v0, v3}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 220
    :cond_0
    iput-object p2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    .line 221
    iput-boolean v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mFinished:Z

    .line 222
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 223
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordSession;->getSegments()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 224
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mToRemove:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->clear()V

    .line 225
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mAddedSegments:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 226
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    iput-object v2, v0, Lco/vine/android/recorder/RecordingFile;->editedSegments:Ljava/util/ArrayList;

    .line 227
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/BasicVineRecorder;->swapTimestampsFromSegments(Ljava/util/ArrayList;)V

    .line 228
    iput-boolean v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCanKeepRecording:Z

    .line 229
    invoke-virtual {p0}, Lco/vine/android/recorder/BasicVineRecorder;->setHasPreviewedAlreadyIfNeeded()V

    .line 230
    iget-wide v2, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentDuration:J

    invoke-virtual {p0, v2, v3}, Lco/vine/android/recorder/BasicVineRecorder;->changeProgress(J)V

    .line 231
    iput-boolean v1, p0, Lco/vine/android/recorder/BasicVineRecorder;->mDiscardChanges:Z

    .line 232
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->finalFile:Lco/vine/android/recorder/RecordingFile;

    .line 233
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->swapSession()V

    .line 235
    :cond_1
    return-object p2

    .line 218
    :cond_2
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_0
.end method

.method protected swapTimestampsFromSegments(Ljava/util/ArrayList;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/recorder/RecordSegment;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 932
    .local p1, "segments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSegment;>;"
    const/4 v0, 0x0

    .line 933
    .local v0, "audioProgress":I
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/recorder/RecordSegment;

    .line 934
    .local v3, "segment":Lco/vine/android/recorder/RecordSegment;
    iget-boolean v4, v3, Lco/vine/android/recorder/RecordSegment;->removed:Z

    if-nez v4, :cond_0

    .line 935
    invoke-virtual {v3}, Lco/vine/android/recorder/RecordSegment;->getCombinedAudioData()Lco/vine/android/recorder/AudioData;

    move-result-object v4

    iget v4, v4, Lco/vine/android/recorder/AudioData;->size:I

    add-int/2addr v0, v4

    goto :goto_0

    .line 938
    .end local v3    # "segment":Lco/vine/android/recorder/RecordSegment;
    :cond_1
    invoke-static {v0}, Lco/vine/android/recorder/RecordConfigUtils;->getTimeStampInNsFromSampleCounted(I)I

    move-result v1

    .line 939
    .local v1, "audioTimestamp":I
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v4, v1}, Lco/vine/android/recorder/RecordController;->setAudioTimestamp(I)V

    .line 940
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    int-to-long v5, v1

    invoke-virtual {v4, v5, v6}, Lco/vine/android/recorder/RecordController;->setVideoTimeStamp(J)V

    .line 941
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v4}, Lco/vine/android/recorder/RecordController;->getTimestamp()J

    move-result-wide v4

    iput-wide v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentDuration:J

    .line 942
    iget-wide v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentDuration:J

    long-to-int v4, v4

    iput v4, p0, Lco/vine/android/recorder/BasicVineRecorder;->mRecordingFileDuration:I

    .line 943
    invoke-virtual {p0}, Lco/vine/android/recorder/BasicVineRecorder;->invalidateFinishButton()V

    .line 944
    return-void
.end method

.method public switchImageStabilization()V
    .locals 1

    .prologue
    .line 732
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    if-eqz v0, :cond_0

    .line 733
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->switchImageStabilization()V

    .line 735
    :cond_0
    return-void
.end method

.method public updateGhostBitmap(Landroid/graphics/Bitmap;)V
    .locals 0
    .param p1, "mGhostBitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 491
    return-void
.end method
