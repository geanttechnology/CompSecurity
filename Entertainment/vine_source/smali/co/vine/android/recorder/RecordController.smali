.class public Lco/vine/android/recorder/RecordController;
.super Ljava/lang/Object;
.source "RecordController.java"

# interfaces
.implements Landroid/view/TextureView$SurfaceTextureListener;
.implements Landroid/hardware/Camera$PreviewCallback;
.implements Landroid/view/SurfaceHolder$Callback;
.implements Landroid/hardware/Camera$AutoFocusCallback;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xe
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/recorder/RecordController$AudioRecordRunnable;,
        Lco/vine/android/recorder/RecordController$OnRecorderControllerStateChangedListener;,
        Lco/vine/android/recorder/RecordController$GhostUpdateRunnable;,
        Lco/vine/android/recorder/RecordController$RecordControllerReadyStartedException;
    }
.end annotation


# static fields
.field private static sByteBufferQueue:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/recorder/ByteBufferQueue;",
            ">;"
        }
    .end annotation
.end field

.field private static sByteBufferQueueReal:Lco/vine/android/recorder/ByteBufferQueue;

.field public static sMaxKnownStopTime:J


# instance fields
.field private volatile isRecordingStarted:Z

.field private mAudioDataBufferMax:Lco/vine/android/recorder/AudioArray;

.field private mAudioRunnable:Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

.field private mAudioThread:Ljava/lang/Thread;

.field private volatile mAudioTimeRecorded:J

.field private volatile mAudioTimestamp:J

.field private mAudioTrim:Z

.field private mAutoFocus:Z

.field private final mCameraManager:Lco/vine/android/recorder/CameraManager;

.field private final mContext:Landroid/content/Context;

.field private volatile mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

.field private mCurrentSegmentEverReceivedFrames:Z

.field private final mDataQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentLinkedQueue",
            "<",
            "Lco/vine/android/recorder/VideoData;",
            ">;"
        }
    .end annotation
.end field

.field private mEncodingRunnable:Lco/vine/android/recorder/AbstractEncodingRunnable;

.field private mEncodingThreadWasRunning:Z

.field private final mFastEncoding:Z

.field private mFinishProcessTask:Lco/vine/android/recorder/BaseFinishProcessTask;

.field private mFlash:Z

.field private mFrameRate:I

.field private mFrameTime:J

.field private mGhostBitmap:Landroid/graphics/Bitmap;

.field private mGhostCanvas:Landroid/graphics/Canvas;

.field private mGhostFrame:Lco/vine/android/recorder/VideoData;

.field private final mHardwareEncoding:Z

.field private mInvalidPreviewSizeException:Lco/vine/android/recorder/CameraManager$InvalidPreviewSizeException;

.field private mIsFocusing:Z

.field private mIsRecordingEnded:Z

.field private mLastAudioRecordingSegment:Lco/vine/android/recorder/RecordSegment;

.field private mLastAudioTimestamp:J

.field private mLastCameraSetting:Lco/vine/android/recorder/CameraSetting;

.field private mLastFrame:Lco/vine/android/recorder/VideoData;

.field private mLastLastFrame:Lco/vine/android/recorder/VideoData;

.field private mLastVideoSegment:Lco/vine/android/recorder/RecordSegment;

.field private mOutput:Ljava/lang/String;

.field public mParent:Lco/vine/android/recorder/BasicVineRecorder;

.field private mProcessThread:Ljava/lang/Thread;

.field private mRotation:I

.field private volatile mRunAudioThread:Z

.field private mSession:Lco/vine/android/recorder/RecordSession;

.field private mSessionFeatureDisabled:Z

.field private mStartTime:J

.field private mSurface:Landroid/view/Surface;

.field private mSurfaceHolder:Landroid/view/SurfaceHolder;

.field private mSurfaceTexture:Landroid/graphics/SurfaceTexture;

.field private mTextureView:Landroid/view/TextureView;

.field private final mUseMp4:Z

.field private mVideoDataBufferMax:[B

.field private final mVideoRecordLock:[I

.field private mVideoTimestamp:J

.field private volatile recordingAudio:Z


# direct methods
.method public constructor <init>(Lco/vine/android/recorder/BasicVineRecorder;Landroid/app/Activity;ZZZ)V
    .locals 3
    .param p1, "parent"    # Lco/vine/android/recorder/BasicVineRecorder;
    .param p2, "activity"    # Landroid/app/Activity;
    .param p3, "hardwareEncoding"    # Z
    .param p4, "fastEncoding"    # Z
    .param p5, "useMp4"    # Z

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 110
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    new-instance v0, Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentLinkedQueue;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mDataQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    .line 55
    new-array v0, v1, [I

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mVideoRecordLock:[I

    .line 64
    iput-boolean v2, p0, Lco/vine/android/recorder/RecordController;->mRunAudioThread:Z

    .line 65
    iput-boolean v1, p0, Lco/vine/android/recorder/RecordController;->isRecordingStarted:Z

    .line 69
    iput-boolean v1, p0, Lco/vine/android/recorder/RecordController;->mFlash:Z

    .line 70
    iput-boolean v2, p0, Lco/vine/android/recorder/RecordController;->mAutoFocus:Z

    .line 87
    iput-boolean v1, p0, Lco/vine/android/recorder/RecordController;->mIsFocusing:Z

    .line 100
    iput-boolean v1, p0, Lco/vine/android/recorder/RecordController;->mAudioTrim:Z

    .line 111
    iput-object p1, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    .line 112
    iput-boolean p3, p0, Lco/vine/android/recorder/RecordController;->mHardwareEncoding:Z

    .line 113
    iput-boolean p4, p0, Lco/vine/android/recorder/RecordController;->mFastEncoding:Z

    .line 114
    invoke-virtual {p2}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mContext:Landroid/content/Context;

    .line 115
    invoke-static {}, Lco/vine/android/recorder/CameraManager;->getInstance()Lco/vine/android/recorder/CameraManager;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    .line 116
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0, p0}, Lco/vine/android/recorder/CameraManager;->setController(Lco/vine/android/recorder/RecordController;)V

    .line 117
    iput-boolean p5, p0, Lco/vine/android/recorder/RecordController;->mUseMp4:Z

    .line 118
    return-void
.end method

.method static synthetic access$100(Lco/vine/android/recorder/RecordController;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/RecordController;
    .param p1, "x1"    # Z

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lco/vine/android/recorder/RecordController;->updateGhostBitmap(Z)V

    return-void
.end method

.method static synthetic access$1000(Lco/vine/android/recorder/RecordController;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/RecordController;

    .prologue
    .line 49
    iget-boolean v0, p0, Lco/vine/android/recorder/RecordController;->mAudioTrim:Z

    return v0
.end method

.method static synthetic access$1100(Lco/vine/android/recorder/RecordController;)Lco/vine/android/recorder/RecordSegment;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/RecordController;

    .prologue
    .line 49
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    return-object v0
.end method

.method static synthetic access$1200(Lco/vine/android/recorder/RecordController;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/RecordController;

    .prologue
    .line 49
    iget-boolean v0, p0, Lco/vine/android/recorder/RecordController;->recordingAudio:Z

    return v0
.end method

.method static synthetic access$1300(Lco/vine/android/recorder/RecordController;)Lco/vine/android/recorder/RecordSegment;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/RecordController;

    .prologue
    .line 49
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mLastAudioRecordingSegment:Lco/vine/android/recorder/RecordSegment;

    return-object v0
.end method

.method static synthetic access$1302(Lco/vine/android/recorder/RecordController;Lco/vine/android/recorder/RecordSegment;)Lco/vine/android/recorder/RecordSegment;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/RecordController;
    .param p1, "x1"    # Lco/vine/android/recorder/RecordSegment;

    .prologue
    .line 49
    iput-object p1, p0, Lco/vine/android/recorder/RecordController;->mLastAudioRecordingSegment:Lco/vine/android/recorder/RecordSegment;

    return-object p1
.end method

.method static synthetic access$1400(Lco/vine/android/recorder/RecordController;)Lco/vine/android/recorder/RecordSegment;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/RecordController;

    .prologue
    .line 49
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mLastVideoSegment:Lco/vine/android/recorder/RecordSegment;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/recorder/RecordController;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/RecordController;

    .prologue
    .line 49
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mOutput:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/recorder/RecordController;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/recorder/RecordController;

    .prologue
    .line 49
    iget-wide v0, p0, Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J

    return-wide v0
.end method

.method static synthetic access$302(Lco/vine/android/recorder/RecordController;J)J
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/RecordController;
    .param p1, "x1"    # J

    .prologue
    .line 49
    iput-wide p1, p0, Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J

    return-wide p1
.end method

.method static synthetic access$402(Lco/vine/android/recorder/RecordController;J)J
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/RecordController;
    .param p1, "x1"    # J

    .prologue
    .line 49
    iput-wide p1, p0, Lco/vine/android/recorder/RecordController;->mAudioTimeRecorded:J

    return-wide p1
.end method

.method static synthetic access$500(Lco/vine/android/recorder/RecordController;)Lco/vine/android/recorder/AudioArray;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/RecordController;

    .prologue
    .line 49
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mAudioDataBufferMax:Lco/vine/android/recorder/AudioArray;

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/recorder/RecordController;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/RecordController;

    .prologue
    .line 49
    iget-boolean v0, p0, Lco/vine/android/recorder/RecordController;->mHardwareEncoding:Z

    return v0
.end method

.method static synthetic access$700(Lco/vine/android/recorder/RecordController;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/RecordController;

    .prologue
    .line 49
    iget-boolean v0, p0, Lco/vine/android/recorder/RecordController;->mRunAudioThread:Z

    return v0
.end method

.method static synthetic access$800(Lco/vine/android/recorder/RecordController;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/recorder/RecordController;

    .prologue
    .line 49
    iget-wide v0, p0, Lco/vine/android/recorder/RecordController;->mVideoTimestamp:J

    return-wide v0
.end method

.method static synthetic access$900(Lco/vine/android/recorder/RecordController;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/RecordController;

    .prologue
    .line 49
    iget-boolean v0, p0, Lco/vine/android/recorder/RecordController;->mIsRecordingEnded:Z

    return v0
.end method

.method private clearLastFrames()V
    .locals 4

    .prologue
    .line 121
    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mVideoRecordLock:[I

    monitor-enter v1

    .line 122
    :try_start_0
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    iget-object v2, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;

    iget-object v2, v2, Lco/vine/android/recorder/VideoData;->data:[B

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/CameraManager;->isFrameAdded([B)Z

    move-result v0

    if-nez v0, :cond_0

    .line 123
    const-string v0, "[START] AHAHHHH"

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 124
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    iget-object v2, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;

    iget-object v2, v2, Lco/vine/android/recorder/VideoData;->data:[B

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Lco/vine/android/recorder/CameraManager;->addBuffer([BZ)V

    .line 125
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;

    .line 127
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mLastLastFrame:Lco/vine/android/recorder/VideoData;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    iget-object v2, p0, Lco/vine/android/recorder/RecordController;->mLastLastFrame:Lco/vine/android/recorder/VideoData;

    iget-object v2, v2, Lco/vine/android/recorder/VideoData;->data:[B

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/CameraManager;->isFrameAdded([B)Z

    move-result v0

    if-nez v0, :cond_1

    .line 128
    const-string v0, "[START] AHAHHHH"

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 129
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    iget-object v2, p0, Lco/vine/android/recorder/RecordController;->mLastLastFrame:Lco/vine/android/recorder/VideoData;

    iget-object v2, v2, Lco/vine/android/recorder/VideoData;->data:[B

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Lco/vine/android/recorder/CameraManager;->addBuffer([BZ)V

    .line 130
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mLastLastFrame:Lco/vine/android/recorder/VideoData;

    .line 132
    :cond_1
    monitor-exit v1

    .line 133
    return-void

    .line 132
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private onSurfaceCreated()V
    .locals 1

    .prologue
    .line 648
    const-string v0, "Surface created..."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 649
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v0, p0}, Lco/vine/android/recorder/BasicVineRecorder;->onSurfaceReady(Lco/vine/android/recorder/RecordController;)V

    .line 650
    return-void
.end method

.method private onSurfaceDestroyed()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 653
    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mSurfaceTexture:Landroid/graphics/SurfaceTexture;

    .line 654
    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mSurface:Landroid/view/Surface;

    .line 655
    return-void
.end method

.method private onSurfaceUpdated()V
    .locals 1

    .prologue
    .line 915
    iget-boolean v0, p0, Lco/vine/android/recorder/RecordController;->isRecordingStarted:Z

    if-nez v0, :cond_0

    .line 916
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0}, Lco/vine/android/recorder/CameraManager;->isPreviewing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 917
    const-string v0, "Surface updated. mCameraManager is previewing..."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 919
    :try_start_0
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0}, Lco/vine/android/recorder/CameraManager;->stopPreview()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 923
    :goto_0
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0}, Lco/vine/android/recorder/CameraManager;->isPreviewing()Z

    move-result v0

    if-nez v0, :cond_0

    .line 924
    invoke-virtual {p0}, Lco/vine/android/recorder/RecordController;->startPreview()V

    .line 928
    :cond_0
    return-void

    .line 920
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private updateGhostBitmap(Z)V
    .locals 6
    .param p1, "updateForParent"    # Z

    .prologue
    .line 607
    invoke-static {}, Lco/vine/android/service/ResourceService;->getPictureConverter()Lco/vine/android/recorder/PictureConverter;

    move-result-object v2

    .line 608
    .local v2, "pictureConverter":Lco/vine/android/recorder/PictureConverter;
    iget-object v4, v2, Lco/vine/android/recorder/PictureConverter;->LOCK:[I

    monitor-enter v4

    .line 609
    :try_start_0
    iget-object v3, p0, Lco/vine/android/recorder/RecordController;->mGhostFrame:Lco/vine/android/recorder/VideoData;

    iget-object v3, v3, Lco/vine/android/recorder/VideoData;->segment:Lco/vine/android/recorder/RecordSegment;

    invoke-virtual {v3}, Lco/vine/android/recorder/RecordSegment;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v0

    .line 610
    .local v0, "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    invoke-virtual {v2, v0}, Lco/vine/android/recorder/PictureConverter;->updateSettingsIfNeeded(Lco/vine/android/recorder/CameraSetting;)Z

    move-result v1

    .line 611
    .local v1, "hasChanged":Z
    iget v3, v0, Lco/vine/android/recorder/CameraSetting;->degrees:I

    iget-boolean v5, v0, Lco/vine/android/recorder/CameraSetting;->frontFacing:Z

    invoke-virtual {v2, v3, v5}, Lco/vine/android/recorder/PictureConverter;->giveMatrixNewValuesWithScaleIfDegreeHasChangedWithKnownConfigs(IZ)V

    .line 612
    iget-object v3, p0, Lco/vine/android/recorder/RecordController;->mGhostFrame:Lco/vine/android/recorder/VideoData;

    invoke-virtual {v2, v0, v3, v1}, Lco/vine/android/recorder/PictureConverter;->convert(Lco/vine/android/recorder/CameraSetting;Lco/vine/android/recorder/VideoData;Z)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 613
    iget-object v3, p0, Lco/vine/android/recorder/RecordController;->mGhostCanvas:Landroid/graphics/Canvas;

    invoke-virtual {v2, v3}, Lco/vine/android/recorder/PictureConverter;->draw(Landroid/graphics/Canvas;)V

    .line 614
    if-eqz p1, :cond_0

    iget-object v3, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    if-eqz v3, :cond_0

    .line 615
    iget-object v3, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v5, p0, Lco/vine/android/recorder/RecordController;->mGhostBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v3, v5}, Lco/vine/android/recorder/BasicVineRecorder;->updateGhostBitmap(Landroid/graphics/Bitmap;)V

    .line 618
    :cond_0
    monitor-exit v4

    .line 619
    return-void

    .line 618
    .end local v0    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    .end local v1    # "hasChanged":Z
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3
.end method

.method private writeToFile(Ljava/util/ArrayList;[BLco/vine/android/recorder/AudioArray;ZI)Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    .locals 20
    .param p2, "videoData"    # [B
    .param p3, "audioData"    # Lco/vine/android/recorder/AudioArray;
    .param p4, "preview"    # Z
    .param p5, "frameRate"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/recorder/RecordSegment;",
            ">;[B",
            "Lco/vine/android/recorder/AudioArray;",
            "ZI)",
            "Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;"
        }
    .end annotation

    .prologue
    .line 380
    .local p1, "editedSegments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSegment;>;"
    :try_start_0
    const-string v2, "Write to file: {}"

    invoke-static/range {p4 .. p4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 381
    :goto_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/RecordController;->mAudioRunnable:Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

    if-eqz v2, :cond_0

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/RecordController;->mAudioRunnable:Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

    iget-boolean v2, v2, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->isInitialized:Z

    if-eqz v2, :cond_0

    .line 382
    const-wide/16 v2, 0x14

    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 384
    :catch_0
    move-exception v19

    .line 385
    .local v19, "e":Ljava/lang/InterruptedException;
    const-string v2, "No..."

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 389
    .end local v19    # "e":Ljava/lang/InterruptedException;
    :cond_0
    :try_start_1
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lco/vine/android/recorder/RecordController;->mHardwareEncoding:Z

    if-eqz v2, :cond_2

    .line 391
    if-eqz p4, :cond_1

    .line 392
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/RecordController;->mContext:Landroid/content/Context;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v4}, Lco/vine/android/recorder/BasicVineRecorder;->getFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v4

    invoke-virtual {v4}, Lco/vine/android/recorder/RecordingFile;->getPreviewVideoPath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ".temp_video.mp4"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    move/from16 v0, p5

    invoke-static {v2, v3, v0}, Lco/vine/android/recorder/RecordConfigUtils;->newVideoRecorder(Landroid/content/Context;Ljava/lang/String;I)Lco/vine/android/recorder/HwVineFrameRecorder;

    move-result-object v7

    .line 398
    .local v7, "videoRecorder":Lco/vine/android/recorder/HwVineFrameRecorder;
    :goto_1
    new-instance v1, Lco/vine/android/recorder/HwCombiningRunnable;

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v2}, Lco/vine/android/recorder/BasicVineRecorder;->getFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v8, v0, Lco/vine/android/recorder/RecordController;->mFinishProcessTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    move/from16 v3, p4

    move-object/from16 v4, p3

    move-object/from16 v5, p2

    move-object/from16 v6, p1

    invoke-direct/range {v1 .. v8}, Lco/vine/android/recorder/HwCombiningRunnable;-><init>(Lco/vine/android/recorder/RecordingFile;ZLco/vine/android/recorder/AudioArray;[BLjava/util/ArrayList;Lco/vine/android/recorder/HwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;)V

    .line 401
    .local v1, "combiningRunnable":Lco/vine/android/recorder/HwCombiningRunnable;
    invoke-virtual {v1}, Lco/vine/android/recorder/HwCombiningRunnable;->combineVideos()Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    move-result-object v2

    .line 423
    .end local v1    # "combiningRunnable":Lco/vine/android/recorder/HwCombiningRunnable;
    .end local v7    # "videoRecorder":Lco/vine/android/recorder/HwVineFrameRecorder;
    :goto_2
    return-object v2

    .line 396
    :cond_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/RecordController;->mContext:Landroid/content/Context;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/RecordController;->mOutput:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ".video.mp4"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    move/from16 v0, p5

    invoke-static {v2, v3, v0}, Lco/vine/android/recorder/RecordConfigUtils;->newVideoRecorder(Landroid/content/Context;Ljava/lang/String;I)Lco/vine/android/recorder/HwVineFrameRecorder;

    move-result-object v7

    .restart local v7    # "videoRecorder":Lco/vine/android/recorder/HwVineFrameRecorder;
    goto :goto_1

    .line 404
    .end local v7    # "videoRecorder":Lco/vine/android/recorder/HwVineFrameRecorder;
    :cond_2
    if-eqz p4, :cond_3

    .line 405
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v3}, Lco/vine/android/recorder/BasicVineRecorder;->getFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/recorder/RecordingFile;->getPreviewVideoPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".temp_video"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lco/vine/android/recorder/RecordConfigUtils;->VIDEO_CONTAINER_EXT:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x1e0

    move-object/from16 v0, p0

    iget-boolean v4, v0, Lco/vine/android/recorder/RecordController;->mUseMp4:Z

    move/from16 v0, p5

    invoke-static {v2, v0, v3, v4}, Lco/vine/android/recorder/RecordConfigUtils;->newVideoRecorder(Ljava/lang/String;IIZ)Lco/vine/android/recorder/SwVineFrameRecorder;

    move-result-object v7

    .line 412
    .local v7, "videoRecorder":Lco/vine/android/recorder/SwVineFrameRecorder;
    :goto_3
    invoke-virtual {v7}, Lco/vine/android/recorder/SwVineFrameRecorder;->start()V

    .line 413
    new-instance v1, Lco/vine/android/recorder/RecordController$2;

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v2}, Lco/vine/android/recorder/BasicVineRecorder;->getFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v10

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/RecordController;->mFinishProcessTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    move-object/from16 v16, v0

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/recorder/RecordController;->getPreviewBitmap()Landroid/graphics/Bitmap;

    move-result-object v17

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/recorder/RecordController;->getFrameBuffer()Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    move-result-object v18

    move-object v8, v1

    move-object/from16 v9, p0

    move/from16 v11, p4

    move-object/from16 v12, p3

    move-object/from16 v13, p2

    move-object/from16 v14, p1

    move-object v15, v7

    invoke-direct/range {v8 .. v18}, Lco/vine/android/recorder/RecordController$2;-><init>(Lco/vine/android/recorder/RecordController;Lco/vine/android/recorder/RecordingFile;ZLco/vine/android/recorder/AudioArray;[BLjava/util/ArrayList;Lco/vine/android/recorder/SwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;Landroid/graphics/Bitmap;Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)V

    .line 417
    .local v1, "combiningRunnable":Lco/vine/android/recorder/AbstractCombiningRunnable;
    invoke-virtual {v1}, Lco/vine/android/recorder/AbstractCombiningRunnable;->combineVideos()Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    move-result-object v2

    goto/16 :goto_2

    .line 409
    .end local v1    # "combiningRunnable":Lco/vine/android/recorder/AbstractCombiningRunnable;
    .end local v7    # "videoRecorder":Lco/vine/android/recorder/SwVineFrameRecorder;
    :cond_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/RecordController;->mOutput:Ljava/lang/String;

    const/16 v3, 0x1e0

    move-object/from16 v0, p0

    iget-boolean v4, v0, Lco/vine/android/recorder/RecordController;->mUseMp4:Z

    move/from16 v0, p5

    invoke-static {v2, v0, v3, v4}, Lco/vine/android/recorder/RecordConfigUtils;->newVideoRecorder(Ljava/lang/String;IIZ)Lco/vine/android/recorder/SwVineFrameRecorder;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v7

    .restart local v7    # "videoRecorder":Lco/vine/android/recorder/SwVineFrameRecorder;
    goto :goto_3

    .line 419
    .end local v7    # "videoRecorder":Lco/vine/android/recorder/SwVineFrameRecorder;
    :catch_1
    move-exception v19

    .line 420
    .local v19, "e":Ljava/lang/Exception;
    const-string v2, "failed to write to file. "

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    move-object/from16 v0, v19

    invoke-static {v0, v2, v3}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 423
    const/4 v2, 0x0

    goto/16 :goto_2
.end method


# virtual methods
.method public autoFocus(II)V
    .locals 1
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 195
    iget-boolean v0, p0, Lco/vine/android/recorder/RecordController;->mIsFocusing:Z

    if-nez v0, :cond_0

    .line 196
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0, p1, p2}, Lco/vine/android/recorder/CameraManager;->setFocusAreas(II)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0, p0}, Lco/vine/android/recorder/CameraManager;->autoFocus(Landroid/hardware/Camera$AutoFocusCallback;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 197
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/recorder/RecordController;->mIsFocusing:Z

    .line 198
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v0, p1, p2}, Lco/vine/android/recorder/BasicVineRecorder;->showFocusIndicator(II)V

    .line 201
    :cond_0
    return-void
.end method

.method public canChangeFocus()Z
    .locals 1

    .prologue
    .line 829
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0}, Lco/vine/android/recorder/CameraManager;->canChangeFocus()Z

    move-result v0

    return v0
.end method

.method public finishLastIfNeeded()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 241
    :try_start_0
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mProcessThread:Ljava/lang/Thread;

    if-eqz v0, :cond_0

    .line 242
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mProcessThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->join()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 247
    :cond_0
    :goto_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/recorder/RecordController;->mEncodingThreadWasRunning:Z

    .line 248
    return-void

    .line 244
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public getCameraSetting()Lco/vine/android/recorder/CameraSetting;
    .locals 1

    .prologue
    .line 431
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0}, Lco/vine/android/recorder/CameraManager;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v0

    return-object v0
.end method

.method public getFinishProcessTask()Lco/vine/android/recorder/BaseFinishProcessTask;
    .locals 1

    .prologue
    .line 866
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mFinishProcessTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    return-object v0
.end method

.method public getFrameBuffer()Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .locals 1

    .prologue
    .line 862
    invoke-static {}, Lco/vine/android/service/ResourceService;->getFrameImage()Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    move-result-object v0

    return-object v0
.end method

.method public getPreviewBitmap()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 858
    invoke-static {}, Lco/vine/android/service/ResourceService;->getPreviewBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public getTimestamp()J
    .locals 4

    .prologue
    .line 1015
    const-string v0, "Recorder Timestamp: {}."

    iget-wide v1, p0, Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1016
    iget-wide v0, p0, Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J

    const-wide/16 v2, 0x3e8

    div-long/2addr v0, v2

    return-wide v0
.end method

.method protected initializeGhostBitmapsIfNeeded()V
    .locals 2

    .prologue
    .line 981
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mGhostBitmap:Landroid/graphics/Bitmap;

    if-nez v0, :cond_0

    .line 982
    invoke-static {}, Lco/vine/android/recorder/RecordConfigUtils;->createDefaultSizeBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mGhostBitmap:Landroid/graphics/Bitmap;

    .line 983
    new-instance v0, Landroid/graphics/Canvas;

    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mGhostBitmap:Landroid/graphics/Bitmap;

    invoke-direct {v0, v1}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mGhostCanvas:Landroid/graphics/Canvas;

    .line 985
    :cond_0
    return-void
.end method

.method public invalidateGhostFrame()V
    .locals 1

    .prologue
    .line 870
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mGhostFrame:Lco/vine/android/recorder/VideoData;

    .line 871
    return-void
.end method

.method public isAudioReady()Z
    .locals 1

    .prologue
    .line 427
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mAudioRunnable:Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mAudioRunnable:Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

    iget-boolean v0, v0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->isInitialized:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isCameraReady()Z
    .locals 1

    .prologue
    .line 644
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0}, Lco/vine/android/recorder/CameraManager;->isCameraReady()Z

    move-result v0

    return v0
.end method

.method public isFlashSupported()Z
    .locals 1

    .prologue
    .line 210
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0}, Lco/vine/android/recorder/CameraManager;->isFlashSupported()Z

    move-result v0

    return v0
.end method

.method public isPreviewing()Z
    .locals 1

    .prologue
    .line 825
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0}, Lco/vine/android/recorder/CameraManager;->isPreviewing()Z

    move-result v0

    return v0
.end method

.method public isRecording()Z
    .locals 1

    .prologue
    .line 699
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isRecordingStarted()Z
    .locals 1

    .prologue
    .line 703
    iget-boolean v0, p0, Lco/vine/android/recorder/RecordController;->isRecordingStarted:Z

    return v0
.end method

.method public isSurfaceReady()Z
    .locals 1

    .prologue
    .line 640
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mSurfaceTexture:Landroid/graphics/SurfaceTexture;

    if-nez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mSurface:Landroid/view/Surface;

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public logPreviewSizeExceptionIfNeeded()V
    .locals 1

    .prologue
    .line 435
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mInvalidPreviewSizeException:Lco/vine/android/recorder/CameraManager$InvalidPreviewSizeException;

    if-eqz v0, :cond_0

    .line 436
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mInvalidPreviewSizeException:Lco/vine/android/recorder/CameraManager$InvalidPreviewSizeException;

    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 438
    :cond_0
    return-void
.end method

.method public makePreview(Lco/vine/android/recorder/RecordSegment;Z)V
    .locals 12
    .param p1, "segment"    # Lco/vine/android/recorder/RecordSegment;
    .param p2, "getLastSegmentOnlyMode"    # Z

    .prologue
    .line 342
    if-nez p2, :cond_0

    :try_start_0
    iget-object v1, p1, Lco/vine/android/recorder/RecordSegment;->videoPath:Ljava/lang/String;

    if-eqz v1, :cond_0

    new-instance v1, Ljava/io/File;

    iget-object v2, p1, Lco/vine/android/recorder/RecordSegment;->videoPath:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_1

    .line 343
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v2}, Lco/vine/android/recorder/BasicVineRecorder;->getFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordingFile;->getPreviewVideoPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ".temp_video"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lco/vine/android/recorder/RecordConfigUtils;->VIDEO_CONTAINER_EXT:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 345
    .local v10, "output":Ljava/lang/String;
    iget-boolean v1, p0, Lco/vine/android/recorder/RecordController;->mHardwareEncoding:Z

    if-eqz v1, :cond_2

    .line 346
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordSegment;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v1

    iget v9, v1, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    .line 347
    .local v9, "frameRate":I
    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mContext:Landroid/content/Context;

    invoke-static {v1, v10, v9}, Lco/vine/android/recorder/RecordConfigUtils;->newVideoRecorder(Landroid/content/Context;Ljava/lang/String;I)Lco/vine/android/recorder/HwVineFrameRecorder;

    move-result-object v3

    .line 348
    .local v3, "videoRecorder":Lco/vine/android/recorder/HwVineFrameRecorder;
    new-instance v0, Lco/vine/android/recorder/HwCombiningRunnable;

    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v1}, Lco/vine/android/recorder/BasicVineRecorder;->getFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v1

    iget-object v4, p0, Lco/vine/android/recorder/RecordController;->mFinishProcessTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    move-object v2, p1

    move v5, p2

    invoke-direct/range {v0 .. v5}, Lco/vine/android/recorder/HwCombiningRunnable;-><init>(Lco/vine/android/recorder/RecordingFile;Lco/vine/android/recorder/RecordSegment;Lco/vine/android/recorder/HwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;Z)V

    .line 356
    .end local v3    # "videoRecorder":Lco/vine/android/recorder/HwVineFrameRecorder;
    .end local v9    # "frameRate":I
    .local v0, "combiningRunnable":Lco/vine/android/recorder/AbstractCombiningRunnable;
    :goto_0
    invoke-virtual {v0}, Lco/vine/android/recorder/AbstractCombiningRunnable;->combineVideos()Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    move-result-object v11

    .line 357
    .local v11, "r":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    if-eqz v11, :cond_1

    .line 358
    invoke-virtual {v11}, Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;->run()V

    .line 364
    .end local v0    # "combiningRunnable":Lco/vine/android/recorder/AbstractCombiningRunnable;
    .end local v10    # "output":Ljava/lang/String;
    .end local v11    # "r":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    :cond_1
    :goto_1
    return-void

    .line 350
    .restart local v10    # "output":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordSegment;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v1

    iget v1, v1, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    const/16 v2, 0x1e0

    iget-boolean v4, p0, Lco/vine/android/recorder/RecordController;->mUseMp4:Z

    invoke-static {v10, v1, v2, v4}, Lco/vine/android/recorder/RecordConfigUtils;->newVideoRecorder(Ljava/lang/String;IIZ)Lco/vine/android/recorder/SwVineFrameRecorder;

    move-result-object v3

    .line 352
    .local v3, "videoRecorder":Lco/vine/android/recorder/SwVineFrameRecorder;
    invoke-virtual {v3}, Lco/vine/android/recorder/SwVineFrameRecorder;->start()V

    .line 353
    new-instance v0, Lco/vine/android/recorder/SwCombiningRunnable;

    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v1}, Lco/vine/android/recorder/BasicVineRecorder;->getFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v1

    iget-object v4, p0, Lco/vine/android/recorder/RecordController;->mFinishProcessTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    invoke-virtual {p0}, Lco/vine/android/recorder/RecordController;->getPreviewBitmap()Landroid/graphics/Bitmap;

    move-result-object v5

    invoke-virtual {p0}, Lco/vine/android/recorder/RecordController;->getFrameBuffer()Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    move-result-object v6

    move-object v2, p1

    move v7, p2

    invoke-direct/range {v0 .. v7}, Lco/vine/android/recorder/SwCombiningRunnable;-><init>(Lco/vine/android/recorder/RecordingFile;Lco/vine/android/recorder/RecordSegment;Lco/vine/android/recorder/SwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;Landroid/graphics/Bitmap;Lcom/googlecode/javacv/cpp/opencv_core$IplImage;Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .restart local v0    # "combiningRunnable":Lco/vine/android/recorder/AbstractCombiningRunnable;
    goto :goto_0

    .line 361
    .end local v0    # "combiningRunnable":Lco/vine/android/recorder/AbstractCombiningRunnable;
    .end local v3    # "videoRecorder":Lco/vine/android/recorder/SwVineFrameRecorder;
    .end local v10    # "output":Ljava/lang/String;
    :catch_0
    move-exception v8

    .line 362
    .local v8, "e":Ljava/lang/Exception;
    const-string v1, "Cannot make previews"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v8, v1, v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method

.method public modifyAntiBanding(Z)V
    .locals 1
    .param p1, "up"    # Z

    .prologue
    .line 775
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/CameraManager;->modifyAntiBanding(Z)V

    .line 776
    return-void
.end method

.method public modifyColorEffects(Z)V
    .locals 1
    .param p1, "up"    # Z

    .prologue
    .line 771
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/CameraManager;->modifyColorEffects(Z)V

    .line 772
    return-void
.end method

.method public modifyExposure(Z)V
    .locals 1
    .param p1, "up"    # Z

    .prologue
    .line 749
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/CameraManager;->modifyExposure(Z)V

    .line 750
    return-void
.end method

.method public modifySceneMode(Z)V
    .locals 1
    .param p1, "up"    # Z

    .prologue
    .line 767
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/CameraManager;->modifySceneMode(Z)V

    .line 768
    return-void
.end method

.method public modifyWhiteBalance(Z)V
    .locals 1
    .param p1, "up"    # Z

    .prologue
    .line 745
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/CameraManager;->modifyWhiteBalance(Z)V

    .line 746
    return-void
.end method

.method public modifyZoom(Z)V
    .locals 1
    .param p1, "zoomIn"    # Z

    .prologue
    .line 753
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/CameraManager;->modifyZoom(Z)I

    .line 754
    return-void
.end method

.method public offerLastFrame(Lco/vine/android/recorder/RecordSegment;Lco/vine/android/recorder/VideoData;)V
    .locals 7
    .param p1, "segment"    # Lco/vine/android/recorder/RecordSegment;
    .param p2, "next"    # Lco/vine/android/recorder/VideoData;

    .prologue
    .line 988
    iget-object v2, p0, Lco/vine/android/recorder/RecordController;->mVideoRecordLock:[I

    monitor-enter v2

    .line 989
    :try_start_0
    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;

    if-eqz v1, :cond_1

    .line 990
    iget-wide v3, p0, Lco/vine/android/recorder/RecordController;->mVideoTimestamp:J

    iget-wide v5, p0, Lco/vine/android/recorder/RecordController;->mFrameTime:J

    add-long/2addr v3, v5

    iput-wide v3, p0, Lco/vine/android/recorder/RecordController;->mVideoTimestamp:J

    .line 991
    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;

    iget-wide v3, v1, Lco/vine/android/recorder/VideoData;->timestamp:J

    iget-wide v5, p0, Lco/vine/android/recorder/RecordController;->mVideoTimestamp:J

    cmp-long v1, v3, v5

    if-lez v1, :cond_0

    .line 992
    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;

    iget-wide v3, v1, Lco/vine/android/recorder/VideoData;->timestamp:J

    iput-wide v3, p0, Lco/vine/android/recorder/RecordController;->mVideoTimestamp:J

    .line 994
    :cond_0
    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;

    invoke-virtual {v1, p1}, Lco/vine/android/recorder/VideoData;->setSegment(Lco/vine/android/recorder/RecordSegment;)V

    .line 995
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordSegment;->getVideoData()Ljava/util/ArrayList;

    move-result-object v1

    iget-object v3, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 996
    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mDataQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    iget-object v3, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;

    invoke-virtual {v1, v3}, Ljava/util/concurrent/ConcurrentLinkedQueue;->offer(Ljava/lang/Object;)Z

    .line 998
    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v1}, Lco/vine/android/recorder/CameraManager;->getSharedByteBuffer()Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 999
    .local v0, "bb":Ljava/nio/ByteBuffer;
    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->rewind()Ljava/nio/Buffer;

    .line 1000
    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;

    iget-object v1, v1, Lco/vine/android/recorder/VideoData;->data:[B

    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    .line 1001
    new-instance v1, Lco/vine/android/recorder/VideoData;

    const-wide/16 v3, 0x0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v5

    invoke-direct {v1, v3, v4, v5}, Lco/vine/android/recorder/VideoData;-><init>(J[B)V

    iput-object v1, p0, Lco/vine/android/recorder/RecordController;->mGhostFrame:Lco/vine/android/recorder/VideoData;

    .line 1002
    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mGhostFrame:Lco/vine/android/recorder/VideoData;

    invoke-virtual {v1, p1}, Lco/vine/android/recorder/VideoData;->setSegment(Lco/vine/android/recorder/RecordSegment;)V

    .line 1003
    iput-object p1, p0, Lco/vine/android/recorder/RecordController;->mLastVideoSegment:Lco/vine/android/recorder/RecordSegment;

    .line 1005
    const-string v1, "Video timestamp {}, actual {}, segment: {}"

    iget-wide v3, p0, Lco/vine/android/recorder/RecordController;->mVideoTimestamp:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    iget-object v4, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;

    iget-wide v4, v4, Lco/vine/android/recorder/VideoData;->timestamp:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v1, v3, v4, p1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1006
    iput-object p2, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;

    .line 1011
    .end local v0    # "bb":Ljava/nio/ByteBuffer;
    :goto_0
    monitor-exit v2

    .line 1012
    return-void

    .line 1008
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Offer last frame failed, did we ever got a frame? "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v3, p0, Lco/vine/android/recorder/RecordController;->mCurrentSegmentEverReceivedFrames:Z

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, ", are we in controller? "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v3, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v3}, Lco/vine/android/recorder/CameraManager;->getControllerId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " - "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_0

    .line 1011
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public onAutoFocus(ZLandroid/hardware/Camera;)V
    .locals 1
    .param p1, "success"    # Z
    .param p2, "camera"    # Landroid/hardware/Camera;

    .prologue
    .line 834
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/recorder/RecordController;->mIsFocusing:Z

    .line 835
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/BasicVineRecorder;->onAutoFocusComplete(Z)V

    .line 836
    return-void
.end method

.method public onPause()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 204
    invoke-virtual {p0, v1}, Lco/vine/android/recorder/RecordController;->setRecording(Lco/vine/android/recorder/RecordSegment;)V

    .line 205
    const-string v0, "onPause"

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/RecordController;->releaseCameraAndPreview(Ljava/lang/String;)V

    .line 206
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/CameraManager;->setController(Lco/vine/android/recorder/RecordController;)V

    .line 207
    return-void
.end method

.method public onPreviewFrame([BLandroid/hardware/Camera;)V
    .locals 11
    .param p1, "data"    # [B
    .param p2, "camera"    # Landroid/hardware/Camera;

    .prologue
    const-wide/16 v9, 0x3e8

    const-wide/16 v3, 0x0

    .line 932
    const/4 v5, 0x1

    iput-boolean v5, p0, Lco/vine/android/recorder/RecordController;->mCurrentSegmentEverReceivedFrames:Z

    .line 933
    sget-boolean v5, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v5, :cond_0

    .line 934
    iget-object v5, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v5}, Lco/vine/android/recorder/CameraManager;->onPreviewFrameReceived()V

    .line 936
    :cond_0
    sget v5, Lco/vine/android/recorder/CameraManager;->sCameraBufferCount:I

    add-int/lit8 v5, v5, -0x1

    sput v5, Lco/vine/android/recorder/CameraManager;->sCameraBufferCount:I

    .line 937
    iget-boolean v5, p0, Lco/vine/android/recorder/RecordController;->recordingAudio:Z

    if-nez v5, :cond_1

    .line 938
    iget-object v5, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v5}, Lco/vine/android/recorder/BasicVineRecorder;->receivedFirstFrameAfterStartingPreview()V

    .line 941
    :cond_1
    iget-wide v5, p0, Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J

    cmp-long v5, v5, v3

    if-nez v5, :cond_3

    .line 943
    iget-wide v5, p0, Lco/vine/android/recorder/RecordController;->mStartTime:J

    cmp-long v5, v5, v3

    if-lez v5, :cond_2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    iget-wide v7, p0, Lco/vine/android/recorder/RecordController;->mStartTime:J

    sub-long/2addr v5, v7

    mul-long v3, v5, v9

    .line 955
    .local v3, "timestamp":J
    :cond_2
    :goto_0
    if-nez p1, :cond_5

    .line 956
    iget-object v5, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    new-instance v6, Lco/vine/android/VineLoggingException;

    const-string v7, "Camera is not supported yet."

    invoke-direct {v6, v7}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v6}, Lco/vine/android/recorder/BasicVineRecorder;->onDeviceNotSupported(Ljava/lang/Throwable;)V

    .line 978
    :goto_1
    return-void

    .line 946
    .end local v3    # "timestamp":J
    :cond_3
    iget-wide v5, p0, Lco/vine/android/recorder/RecordController;->mLastAudioTimestamp:J

    iget-wide v7, p0, Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J

    cmp-long v5, v5, v7

    if-nez v5, :cond_4

    .line 947
    iget-wide v5, p0, Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J

    iget-wide v7, p0, Lco/vine/android/recorder/RecordController;->mFrameTime:J

    add-long v3, v5, v7

    .restart local v3    # "timestamp":J
    goto :goto_0

    .line 949
    .end local v3    # "timestamp":J
    :cond_4
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v5

    iget-wide v7, p0, Lco/vine/android/recorder/RecordController;->mAudioTimeRecorded:J

    sub-long/2addr v5, v7

    div-long v0, v5, v9

    .line 950
    .local v0, "offset":J
    iget-wide v5, p0, Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J

    add-long v3, v0, v5

    .line 951
    .restart local v3    # "timestamp":J
    iget-wide v5, p0, Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J

    iput-wide v5, p0, Lco/vine/android/recorder/RecordController;->mLastAudioTimestamp:J

    .line 952
    const-string v5, "Offset {}."

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0

    .line 960
    .end local v0    # "offset":J
    :cond_5
    iget-object v5, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v5, p1}, Lco/vine/android/recorder/CameraManager;->removeBufferFromAvailableQueue([B)V

    .line 961
    iget-object v6, p0, Lco/vine/android/recorder/RecordController;->mVideoRecordLock:[I

    monitor-enter v6

    .line 962
    :try_start_0
    iget-object v2, p0, Lco/vine/android/recorder/RecordController;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    .line 963
    .local v2, "segment":Lco/vine/android/recorder/RecordSegment;
    if-eqz v2, :cond_7

    .line 964
    iget-object v5, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;

    if-nez v5, :cond_6

    .line 965
    new-instance v5, Lco/vine/android/recorder/VideoData;

    invoke-direct {v5, v3, v4, p1}, Lco/vine/android/recorder/VideoData;-><init>(J[B)V

    iput-object v5, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;

    .line 966
    const/4 v5, 0x0

    invoke-virtual {p0, v2, v5}, Lco/vine/android/recorder/RecordController;->offerLastFrame(Lco/vine/android/recorder/RecordSegment;Lco/vine/android/recorder/VideoData;)V

    .line 977
    :goto_2
    monitor-exit v6

    goto :goto_1

    .end local v2    # "segment":Lco/vine/android/recorder/RecordSegment;
    :catchall_0
    move-exception v5

    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v5

    .line 968
    .restart local v2    # "segment":Lco/vine/android/recorder/RecordSegment;
    :cond_6
    :try_start_1
    new-instance v5, Lco/vine/android/recorder/VideoData;

    invoke-direct {v5, v3, v4, p1}, Lco/vine/android/recorder/VideoData;-><init>(J[B)V

    invoke-virtual {p0, v2, v5}, Lco/vine/android/recorder/RecordController;->offerLastFrame(Lco/vine/android/recorder/RecordSegment;Lco/vine/android/recorder/VideoData;)V

    goto :goto_2

    .line 971
    :cond_7
    iget-object v5, p0, Lco/vine/android/recorder/RecordController;->mLastLastFrame:Lco/vine/android/recorder/VideoData;

    if-eqz v5, :cond_8

    .line 972
    iget-object v5, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    iget-object v7, p0, Lco/vine/android/recorder/RecordController;->mLastLastFrame:Lco/vine/android/recorder/VideoData;

    iget-object v7, v7, Lco/vine/android/recorder/VideoData;->data:[B

    invoke-virtual {v5, v7}, Lco/vine/android/recorder/CameraManager;->addCallbackBuffer([B)V

    .line 974
    :cond_8
    iget-object v5, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;

    iput-object v5, p0, Lco/vine/android/recorder/RecordController;->mLastLastFrame:Lco/vine/android/recorder/VideoData;

    .line 975
    new-instance v5, Lco/vine/android/recorder/VideoData;

    invoke-direct {v5, v3, v4, p1}, Lco/vine/android/recorder/VideoData;-><init>(J[B)V

    iput-object v5, p0, Lco/vine/android/recorder/RecordController;->mLastFrame:Lco/vine/android/recorder/VideoData;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_2
.end method

.method public onSurfaceTextureAvailable(Landroid/graphics/SurfaceTexture;II)V
    .locals 0
    .param p1, "surface"    # Landroid/graphics/SurfaceTexture;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 891
    iput-object p1, p0, Lco/vine/android/recorder/RecordController;->mSurfaceTexture:Landroid/graphics/SurfaceTexture;

    .line 892
    invoke-direct {p0}, Lco/vine/android/recorder/RecordController;->onSurfaceCreated()V

    .line 893
    return-void
.end method

.method public onSurfaceTextureDestroyed(Landroid/graphics/SurfaceTexture;)Z
    .locals 1
    .param p1, "surface"    # Landroid/graphics/SurfaceTexture;

    .prologue
    .line 904
    invoke-direct {p0}, Lco/vine/android/recorder/RecordController;->onSurfaceDestroyed()V

    .line 905
    const/4 v0, 0x1

    return v0
.end method

.method public onSurfaceTextureSizeChanged(Landroid/graphics/SurfaceTexture;II)V
    .locals 0
    .param p1, "surface"    # Landroid/graphics/SurfaceTexture;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 897
    iput-object p1, p0, Lco/vine/android/recorder/RecordController;->mSurfaceTexture:Landroid/graphics/SurfaceTexture;

    .line 898
    invoke-direct {p0}, Lco/vine/android/recorder/RecordController;->onSurfaceCreated()V

    .line 899
    invoke-direct {p0}, Lco/vine/android/recorder/RecordController;->onSurfaceUpdated()V

    .line 900
    return-void
.end method

.method public onSurfaceTextureUpdated(Landroid/graphics/SurfaceTexture;)V
    .locals 0
    .param p1, "surface"    # Landroid/graphics/SurfaceTexture;

    .prologue
    .line 910
    iput-object p1, p0, Lco/vine/android/recorder/RecordController;->mSurfaceTexture:Landroid/graphics/SurfaceTexture;

    .line 911
    invoke-direct {p0}, Lco/vine/android/recorder/RecordController;->onSurfaceUpdated()V

    .line 912
    return-void
.end method

.method public onZoomUpdated(IZ)V
    .locals 1
    .param p1, "zoom"    # I
    .param p2, "stopped"    # Z

    .prologue
    .line 757
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    if-eqz v0, :cond_0

    .line 758
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v0, p1, p2}, Lco/vine/android/recorder/BasicVineRecorder;->onZoomUpdated(IZ)V

    .line 760
    :cond_0
    return-void
.end method

.method public openDefaultCamera(ZZ)Z
    .locals 8
    .param p1, "frontFacing"    # Z
    .param p2, "reOpen"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/VineNotSupportedException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 214
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    .line 215
    .local v1, "start":J
    iget-object v5, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    iget-object v6, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v6}, Lco/vine/android/recorder/BasicVineRecorder;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v6

    iget v7, p0, Lco/vine/android/recorder/RecordController;->mRotation:I

    invoke-virtual {v5, v6, p1, v7, p2}, Lco/vine/android/recorder/CameraManager;->openDefaultCamera(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;ZIZ)Lco/vine/android/recorder/CameraSetting;

    move-result-object v0

    .line 216
    .local v0, "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    const-string v5, "Camera Open 1 took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    sub-long/2addr v6, v1

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 217
    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mLastCameraSetting:Lco/vine/android/recorder/CameraSetting;

    .line 218
    if-eqz v0, :cond_0

    .line 219
    const-string v5, "Received camera info."

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 220
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    .line 221
    iget-object v5, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    iget v6, v0, Lco/vine/android/recorder/CameraSetting;->originalW:I

    iget v7, v0, Lco/vine/android/recorder/CameraSetting;->originalH:I

    invoke-virtual {v5, v6, v7}, Lco/vine/android/recorder/CameraManager;->setPreviewSize(II)V

    .line 222
    invoke-virtual {p0}, Lco/vine/android/recorder/RecordController;->startPreview()V

    .line 223
    const-string v5, "Camera Open 2 took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    sub-long/2addr v6, v1

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 224
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    .line 225
    iput-boolean v4, p0, Lco/vine/android/recorder/RecordController;->mIsFocusing:Z

    .line 226
    iget-object v4, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v4, p0}, Lco/vine/android/recorder/BasicVineRecorder;->onCameraReady(Lco/vine/android/recorder/RecordController;)V

    .line 227
    const-string v4, "Camera Open 3 took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    sub-long/2addr v5, v1

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 231
    :goto_0
    return v3

    .line 230
    :cond_0
    const-string v5, "Failed to open camera: {}."

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    aput-object v6, v3, v4

    invoke-static {v5, v3}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    move v3, v4

    .line 231
    goto :goto_0
.end method

.method public refreshBufferMax(Lco/vine/android/recorder/RecordSession;)V
    .locals 1
    .param p1, "session"    # Lco/vine/android/recorder/RecordSession;

    .prologue
    .line 1020
    iput-object p1, p0, Lco/vine/android/recorder/RecordController;->mSession:Lco/vine/android/recorder/RecordSession;

    .line 1021
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mSession:Lco/vine/android/recorder/RecordSession;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordSession;->getVideoData()[B

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mVideoDataBufferMax:[B

    .line 1022
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mSession:Lco/vine/android/recorder/RecordSession;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordSession;->getAudioData()Lco/vine/android/recorder/AudioArray;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mAudioDataBufferMax:Lco/vine/android/recorder/AudioArray;

    .line 1023
    return-void
.end method

.method public releaseCallbacks()V
    .locals 2

    .prologue
    .line 804
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    if-eqz v0, :cond_0

    .line 805
    const-string v0, "releasing surface holder callback"

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 806
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v0, p0}, Landroid/view/SurfaceHolder;->removeCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 808
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mTextureView:Landroid/view/TextureView;

    if-eqz v0, :cond_1

    .line 809
    const-string v0, "releasing surface holder callback"

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 810
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mTextureView:Landroid/view/TextureView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/TextureView;->setSurfaceTextureListener(Landroid/view/TextureView$SurfaceTextureListener;)V

    .line 812
    :cond_1
    return-void
.end method

.method protected releaseCameraAndPreview(Ljava/lang/String;)V
    .locals 3
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 635
    const-string v0, "Release camera and preview."

    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 636
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Controller "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/CameraManager;->releaseCameraAndPreview(Ljava/lang/String;)V

    .line 637
    return-void
.end method

.method public releaseCameraResources()V
    .locals 1

    .prologue
    .line 787
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0}, Lco/vine/android/recorder/CameraManager;->releaseCameraResources()V

    .line 788
    return-void
.end method

.method public releaseParent()V
    .locals 1

    .prologue
    .line 791
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    .line 792
    return-void
.end method

.method public releaseResources()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 795
    const-string v0, "releaseResources"

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 796
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mDataQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v0}, Ljava/util/concurrent/ConcurrentLinkedQueue;->clear()V

    .line 797
    iput-object v1, p0, Lco/vine/android/recorder/RecordController;->mLastAudioRecordingSegment:Lco/vine/android/recorder/RecordSegment;

    .line 798
    iput-object v1, p0, Lco/vine/android/recorder/RecordController;->mLastVideoSegment:Lco/vine/android/recorder/RecordSegment;

    .line 799
    iput-object v1, p0, Lco/vine/android/recorder/RecordController;->mEncodingRunnable:Lco/vine/android/recorder/AbstractEncodingRunnable;

    .line 800
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 801
    return-void
.end method

.method public requestGhostDrawing(Z)V
    .locals 2
    .param p1, "synchronous"    # Z

    .prologue
    .line 839
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mGhostFrame:Lco/vine/android/recorder/VideoData;

    if-eqz v0, :cond_0

    .line 840
    if-eqz p1, :cond_1

    .line 841
    invoke-virtual {p0}, Lco/vine/android/recorder/RecordController;->initializeGhostBitmapsIfNeeded()V

    .line 842
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lco/vine/android/recorder/RecordController;->updateGhostBitmap(Z)V

    .line 847
    :cond_0
    :goto_0
    return-void

    .line 844
    :cond_1
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lco/vine/android/recorder/RecordController$GhostUpdateRunnable;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/RecordController$GhostUpdateRunnable;-><init>(Lco/vine/android/recorder/RecordController;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    goto :goto_0
.end method

.method public setAudioTimestamp(I)V
    .locals 2
    .param p1, "timeStampInNsFromSampleCounted"    # I

    .prologue
    .line 850
    int-to-long v0, p1

    iput-wide v0, p0, Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J

    .line 851
    return-void
.end method

.method public setAudioTrim(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 441
    iput-boolean p1, p0, Lco/vine/android/recorder/RecordController;->mAudioTrim:Z

    .line 442
    return-void
.end method

.method public setAutoFocus(Z)V
    .locals 3
    .param p1, "isOn"    # Z

    .prologue
    .line 173
    iput-boolean p1, p0, Lco/vine/android/recorder/RecordController;->mAutoFocus:Z

    .line 175
    :try_start_0
    iget-boolean v1, p0, Lco/vine/android/recorder/RecordController;->mAutoFocus:Z

    if-eqz v1, :cond_1

    .line 176
    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v1}, Lco/vine/android/recorder/CameraManager;->isPreviewing()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 177
    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    iget-object v2, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v2}, Lco/vine/android/recorder/CameraManager;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v2

    invoke-virtual {v1, v2}, Lco/vine/android/recorder/CameraManager;->startContinuousAutoFocus(Landroid/hardware/Camera$Parameters;)Z

    .line 192
    :cond_0
    :goto_0
    return-void

    .line 180
    :cond_1
    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v1}, Lco/vine/android/recorder/CameraManager;->isPreviewing()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 181
    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    iget-object v2, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v2}, Lco/vine/android/recorder/CameraManager;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v2

    invoke-virtual {v1, v2}, Lco/vine/android/recorder/CameraManager;->stopContinuousFocus(Landroid/hardware/Camera$Parameters;)Z

    .line 182
    iget-boolean v1, p0, Lco/vine/android/recorder/RecordController;->mAutoFocus:Z

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Lco/vine/android/recorder/RecordController;->mIsFocusing:Z

    if-nez v1, :cond_0

    .line 183
    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v1, p0}, Lco/vine/android/recorder/CameraManager;->autoFocus(Landroid/hardware/Camera$AutoFocusCallback;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 184
    const/4 v1, 0x1

    iput-boolean v1, p0, Lco/vine/android/recorder/RecordController;->mIsFocusing:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 189
    :catch_0
    move-exception v0

    .line 190
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "It\'s ok if we failed to auto focus here."

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public setFinishProcessTask(Lco/vine/android/recorder/BaseFinishProcessTask;)V
    .locals 2
    .param p1, "finishProcessTask"    # Lco/vine/android/recorder/BaseFinishProcessTask;

    .prologue
    .line 738
    iput-object p1, p0, Lco/vine/android/recorder/RecordController;->mFinishProcessTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    .line 739
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mEncodingRunnable:Lco/vine/android/recorder/AbstractEncodingRunnable;

    if-eqz v0, :cond_0

    .line 740
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mEncodingRunnable:Lco/vine/android/recorder/AbstractEncodingRunnable;

    iget-object v1, p0, Lco/vine/android/recorder/RecordController;->mFinishProcessTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/AbstractEncodingRunnable;->setAsyncTask(Lco/vine/android/recorder/BaseFinishProcessTask;)V

    .line 742
    :cond_0
    return-void
.end method

.method public setPreviewSurface(Landroid/view/View;)V
    .locals 1
    .param p1, "previewView"    # Landroid/view/View;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 815
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0, p0}, Lco/vine/android/recorder/CameraManager;->setController(Lco/vine/android/recorder/RecordController;)V

    .line 816
    instance-of v0, p1, Landroid/view/TextureView;

    if-eqz v0, :cond_0

    move-object v0, p1

    .line 817
    check-cast v0, Landroid/view/TextureView;

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/RecordController;->switchSurface(Landroid/view/TextureView;)V

    .line 819
    :cond_0
    instance-of v0, p1, Landroid/view/SurfaceView;

    if-eqz v0, :cond_1

    .line 820
    check-cast p1, Landroid/view/SurfaceView;

    .end local p1    # "previewView":Landroid/view/View;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/RecordController;->switchSurface(Landroid/view/SurfaceView;)V

    .line 822
    :cond_1
    return-void
.end method

.method public setRecording(Lco/vine/android/recorder/RecordSegment;)V
    .locals 2
    .param p1, "segment"    # Lco/vine/android/recorder/RecordSegment;

    .prologue
    .line 727
    invoke-virtual {p0}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 728
    if-eqz p1, :cond_0

    .line 729
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/recorder/RecordController;->mCurrentSegmentEverReceivedFrames:Z

    .line 730
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/recorder/RecordController;->mStartTime:J

    .line 731
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0}, Lco/vine/android/recorder/CameraManager;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v0

    invoke-virtual {p1, v0}, Lco/vine/android/recorder/RecordSegment;->setCameraSetting(Lco/vine/android/recorder/CameraSetting;)Lco/vine/android/recorder/RecordSegment;

    .line 733
    :cond_0
    iput-object p1, p0, Lco/vine/android/recorder/RecordController;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    .line 735
    :cond_1
    return-void
.end method

.method public setRecordingAudio(Z)V
    .locals 0
    .param p1, "recordingAudio"    # Z

    .prologue
    .line 783
    iput-boolean p1, p0, Lco/vine/android/recorder/RecordController;->recordingAudio:Z

    .line 784
    return-void
.end method

.method public setSessionFeatureDisabled(Z)V
    .locals 0
    .param p1, "sessionFeatureDisabled"    # Z

    .prologue
    .line 449
    iput-boolean p1, p0, Lco/vine/android/recorder/RecordController;->mSessionFeatureDisabled:Z

    .line 450
    return-void
.end method

.method public setVideoTimeStamp(J)V
    .locals 0
    .param p1, "timestamp"    # J

    .prologue
    .line 854
    iput-wide p1, p0, Lco/vine/android/recorder/RecordController;->mVideoTimestamp:J

    .line 855
    return-void
.end method

.method public declared-synchronized start(Landroid/app/Activity;Ljava/lang/String;II)Z
    .locals 47
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "output"    # Ljava/lang/String;
    .param p3, "currentAudioSampleCount"    # I
    .param p4, "currentVideoSampleCount"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/RecordController$RecordControllerReadyStartedException;
        }
    .end annotation

    .prologue
    .line 456
    monitor-enter p0

    :try_start_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v3}, Lco/vine/android/recorder/CameraManager;->isCameraReady()Z

    move-result v3

    if-nez v3, :cond_0

    .line 457
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "You have to choose a camera via open() first."

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 456
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3

    .line 459
    :cond_0
    :try_start_1
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mTextureView:Landroid/view/TextureView;

    if-nez v3, :cond_1

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    if-nez v3, :cond_1

    .line 460
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "You have to set a preview surface via switchSurface first."

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 462
    :cond_1
    move-object/from16 v0, p0

    iget-boolean v3, v0, Lco/vine/android/recorder/RecordController;->isRecordingStarted:Z

    if-eqz v3, :cond_2

    .line 463
    new-instance v3, Lco/vine/android/recorder/RecordController$RecordControllerReadyStartedException;

    invoke-direct {v3}, Lco/vine/android/recorder/RecordController$RecordControllerReadyStartedException;-><init>()V

    throw v3

    .line 465
    :cond_2
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v3}, Lco/vine/android/recorder/CameraManager;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v38

    .line 466
    .local v38, "cs":Lco/vine/android/recorder/CameraSetting;
    if-nez v38, :cond_3

    .line 467
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "Camera is ready but camera setting is null, something is terribly wrong."

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 470
    :cond_3
    const-string v3, "START Recorder, with ResourceService ready? {}."

    sget-boolean v4, Lco/vine/android/service/ResourceService;->IS_READY:Z

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 472
    :try_start_2
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/recorder/RecordController;->finishLastIfNeeded()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 477
    :goto_0
    :try_start_3
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v43

    .line 478
    .local v43, "start":J
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput-boolean v3, v0, Lco/vine/android/recorder/RecordController;->mIsRecordingEnded:Z

    .line 479
    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput-boolean v3, v0, Lco/vine/android/recorder/RecordController;->isRecordingStarted:Z

    .line 480
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mAudioRunnable:Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

    if-eqz v3, :cond_4

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mAudioRunnable:Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

    iget-boolean v3, v3, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->isInitialized:Z

    if-eqz v3, :cond_4

    .line 481
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mAudioRunnable:Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

    const/4 v4, 0x1

    iput-boolean v4, v3, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->forceQuit:Z

    .line 482
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mAudioThread:Ljava/lang/Thread;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    if-eqz v3, :cond_4

    .line 484
    :try_start_4
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mAudioThread:Ljava/lang/Thread;

    invoke-virtual {v3}, Ljava/lang/Thread;->join()V
    :try_end_4
    .catch Ljava/lang/InterruptedException; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 490
    :cond_4
    :goto_1
    :try_start_5
    new-instance v3, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

    const/4 v4, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move/from16 v2, p3

    invoke-direct {v3, v0, v1, v2, v4}, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;-><init>(Lco/vine/android/recorder/RecordController;Ljava/lang/String;ILco/vine/android/recorder/RecordController$1;)V

    move-object/from16 v0, p0

    iput-object v3, v0, Lco/vine/android/recorder/RecordController;->mAudioRunnable:Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

    .line 491
    const-string v3, "Audio recorder initialized with count {}."

    invoke-static/range {p3 .. p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 492
    const-string v3, "Starting timestamps: {}"

    move-object/from16 v0, p0

    iget-wide v4, v0, Lco/vine/android/recorder/RecordController;->mVideoTimestamp:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    move-object/from16 v0, p0

    iget-wide v5, v0, Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-static {v3, v4, v5}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 493
    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput-boolean v3, v0, Lco/vine/android/recorder/RecordController;->mRunAudioThread:Z

    .line 494
    invoke-direct/range {p0 .. p0}, Lco/vine/android/recorder/RecordController;->clearLastFrames()V

    .line 495
    new-instance v3, Ljava/lang/Thread;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/RecordController;->mAudioRunnable:Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

    const-string v5, "AudioRunnable"

    invoke-direct {v3, v4, v5}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    move-object/from16 v0, p0

    iput-object v3, v0, Lco/vine/android/recorder/RecordController;->mAudioThread:Ljava/lang/Thread;

    .line 496
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mAudioThread:Ljava/lang/Thread;

    invoke-virtual {v3}, Ljava/lang/Thread;->start()V

    .line 497
    const-wide/16 v3, 0x0

    move-object/from16 v0, p0

    iput-wide v3, v0, Lco/vine/android/recorder/RecordController;->mStartTime:J

    .line 498
    move-object/from16 v0, v38

    iget v9, v0, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    .line 499
    .local v9, "frameRate":I
    const/16 v45, 0x1e0

    .line 501
    .local v45, "targetSize":I
    sget-boolean v3, Lco/vine/android/recorder/SwVineFrameRecorder;->hasEverSuccessfullyLoaded:Z
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    if-nez v3, :cond_5

    .line 503
    :try_start_6
    invoke-static/range {p1 .. p1}, Lco/vine/android/recorder/SwVineFrameRecorder;->tryLoad(Landroid/content/Context;)V
    :try_end_6
    .catch Lco/vine/android/recorder/SwVineFrameRecorder$Exception; {:try_start_6 .. :try_end_6} :catch_2
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 508
    :cond_5
    :goto_2
    :try_start_7
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mAudioRunnable:Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

    invoke-virtual {v3}, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->updateTimestamp()V

    .line 509
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p2

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ".video"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lco/vine/android/recorder/RecordConfigUtils;->VIDEO_CONTAINER_EXT:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lco/vine/android/recorder/RecordController;->mOutput:Ljava/lang/String;

    .line 516
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/recorder/RecordController;->getPreviewBitmap()Landroid/graphics/Bitmap;

    move-result-object v11

    .line 517
    .local v11, "matrixBitmap":Landroid/graphics/Bitmap;
    move-object/from16 v0, p0

    iput v9, v0, Lco/vine/android/recorder/RecordController;->mFrameRate:I

    .line 519
    const-string v3, "start 1 took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long v4, v4, v43

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 520
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v43

    .line 522
    invoke-static/range {p1 .. p1}, Lco/vine/android/service/ResourceService;->getThumbnailBitmap(Landroid/content/Context;)Landroid/graphics/Bitmap;

    move-result-object v12

    .line 523
    .local v12, "thumbnailBitmap":Landroid/graphics/Bitmap;
    invoke-static/range {p1 .. p1}, Lco/vine/android/service/ResourceService;->getRenderScript(Landroid/content/Context;)Landroid/support/v8/renderscript/RenderScript;

    move-result-object v42

    .line 524
    .local v42, "rs":Landroid/support/v8/renderscript/RenderScript;
    invoke-static/range {p1 .. p1}, Lco/vine/android/service/ResourceService;->getThumbnailMatrix(Landroid/content/Context;)Landroid/graphics/Matrix;

    move-result-object v17

    .line 525
    .local v17, "thumbnailMatrix":Landroid/graphics/Matrix;
    invoke-static/range {p1 .. p1}, Lco/vine/android/service/ResourceService;->getThumbnailCanvas(Landroid/content/Context;)Landroid/graphics/Canvas;

    move-result-object v18

    .line 526
    .local v18, "thumbnailCanvas":Landroid/graphics/Canvas;
    invoke-static {}, Lco/vine/android/service/ResourceService;->getPreviewCanvas()Landroid/graphics/Canvas;

    move-result-object v19

    .line 528
    .local v19, "previewCanvas":Landroid/graphics/Canvas;
    const-string v3, "start 4 took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long v4, v4, v43

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 529
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v43

    .line 531
    invoke-static {}, Lco/vine/android/service/ResourceService;->getPictureConverter()Lco/vine/android/recorder/PictureConverter;

    move-result-object v13

    .line 532
    .local v13, "pictureConverter":Lco/vine/android/recorder/PictureConverter;
    if-eqz v13, :cond_7

    .line 533
    move-object/from16 v0, v38

    invoke-virtual {v13, v0}, Lco/vine/android/recorder/PictureConverter;->updateSettingsIfNeeded(Lco/vine/android/recorder/CameraSetting;)Z

    .line 544
    :goto_3
    const-string v3, "start 5 took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long v4, v4, v43

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 545
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v43

    .line 547
    sget-boolean v3, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v3, :cond_6

    .line 548
    new-instance v40, Landroid/app/ActivityManager$MemoryInfo;

    invoke-direct/range {v40 .. v40}, Landroid/app/ActivityManager$MemoryInfo;-><init>()V

    .line 549
    .local v40, "mi":Landroid/app/ActivityManager$MemoryInfo;
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v3, v3, Lco/vine/android/recorder/BasicVineRecorder;->mActivity:Landroid/app/Activity;

    const-string v4, "activity"

    invoke-virtual {v3, v4}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v37

    check-cast v37, Landroid/app/ActivityManager;

    .line 550
    .local v37, "activityManager":Landroid/app/ActivityManager;
    move-object/from16 v0, v37

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/app/ActivityManager;->getMemoryInfo(Landroid/app/ActivityManager$MemoryInfo;)V

    .line 551
    const-string v3, "[mem] Avaliable bytes: {}."

    move-object/from16 v0, v40

    iget-wide v4, v0, Landroid/app/ActivityManager$MemoryInfo;->availMem:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 554
    .end local v37    # "activityManager":Landroid/app/ActivityManager;
    .end local v40    # "mi":Landroid/app/ActivityManager$MemoryInfo;
    :cond_6
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v3}, Lco/vine/android/recorder/BasicVineRecorder;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v3

    iget-wide v3, v3, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->memRatio:D

    const-wide/high16 v5, 0x3ff0000000000000L    # 1.0

    cmpl-double v3, v3, v5

    if-nez v3, :cond_8

    const/16 v46, 0x1

    .line 555
    .local v46, "useRealQueue":Z
    :goto_4
    const/16 v16, 0x0

    .line 556
    .local v16, "queue":Lco/vine/android/recorder/ByteBufferQueue;
    sget-object v3, Lco/vine/android/recorder/RecordController;->sByteBufferQueue:Ljava/lang/ref/WeakReference;

    if-nez v3, :cond_a

    sget-object v3, Lco/vine/android/recorder/RecordController;->sByteBufferQueueReal:Lco/vine/android/recorder/ByteBufferQueue;

    if-nez v3, :cond_a

    .line 557
    new-instance v16, Lco/vine/android/recorder/ByteBufferQueue;

    .end local v16    # "queue":Lco/vine/android/recorder/ByteBufferQueue;
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v3}, Lco/vine/android/recorder/BasicVineRecorder;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v3

    iget v3, v3, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->bufferCount:I

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v4}, Lco/vine/android/recorder/CameraManager;->getFrameSize()I

    move-result v4

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v5}, Lco/vine/android/recorder/BasicVineRecorder;->getMemoryResponder()Lco/vine/android/recorder/ByteBufferQueue$MemoryResponder;

    move-result-object v5

    move-object/from16 v0, v16

    invoke-direct {v0, v3, v4, v5}, Lco/vine/android/recorder/ByteBufferQueue;-><init>(IILco/vine/android/recorder/ByteBufferQueue$MemoryResponder;)V

    .line 558
    .restart local v16    # "queue":Lco/vine/android/recorder/ByteBufferQueue;
    if-eqz v46, :cond_9

    .line 559
    sput-object v16, Lco/vine/android/recorder/RecordController;->sByteBufferQueueReal:Lco/vine/android/recorder/ByteBufferQueue;

    .line 579
    :goto_5
    const-string v3, "start 6 took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long v4, v4, v43

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 580
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v43

    .line 582
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v3}, Lco/vine/android/recorder/CameraManager;->isCameraReady()Z

    move-result v3

    if-nez v3, :cond_e

    .line 583
    new-instance v3, Lco/vine/android/VineLoggingException;

    const-string v4, "Camera was released already. "

    invoke-direct {v3, v4}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-static {v3}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 584
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mAudioRunnable:Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

    const/4 v4, 0x1

    iput-boolean v4, v3, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->forceQuit:Z
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 585
    const/4 v3, 0x0

    .line 602
    .end local v16    # "queue":Lco/vine/android/recorder/ByteBufferQueue;
    .end local v46    # "useRealQueue":Z
    :goto_6
    monitor-exit p0

    return v3

    .line 473
    .end local v9    # "frameRate":I
    .end local v11    # "matrixBitmap":Landroid/graphics/Bitmap;
    .end local v12    # "thumbnailBitmap":Landroid/graphics/Bitmap;
    .end local v13    # "pictureConverter":Lco/vine/android/recorder/PictureConverter;
    .end local v17    # "thumbnailMatrix":Landroid/graphics/Matrix;
    .end local v18    # "thumbnailCanvas":Landroid/graphics/Canvas;
    .end local v19    # "previewCanvas":Landroid/graphics/Canvas;
    .end local v42    # "rs":Landroid/support/v8/renderscript/RenderScript;
    .end local v43    # "start":J
    .end local v45    # "targetSize":I
    :catch_0
    move-exception v39

    .line 474
    .local v39, "e":Ljava/lang/Exception;
    :try_start_8
    const-string v3, "Finish last if needed Failed."

    move-object/from16 v0, v39

    invoke-static {v3, v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 485
    .end local v39    # "e":Ljava/lang/Exception;
    .restart local v43    # "start":J
    :catch_1
    move-exception v39

    .line 486
    .local v39, "e":Ljava/lang/InterruptedException;
    const-string v3, "Error join audio thread."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 504
    .end local v39    # "e":Ljava/lang/InterruptedException;
    .restart local v9    # "frameRate":I
    .restart local v45    # "targetSize":I
    :catch_2
    move-exception v39

    .line 505
    .local v39, "e":Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
    const-string v3, "Failed to load native libraries."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    move-object/from16 v0, v39

    invoke-static {v0, v3, v4}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    goto/16 :goto_2

    .line 536
    .end local v39    # "e":Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
    .restart local v11    # "matrixBitmap":Landroid/graphics/Bitmap;
    .restart local v12    # "thumbnailBitmap":Landroid/graphics/Bitmap;
    .restart local v13    # "pictureConverter":Lco/vine/android/recorder/PictureConverter;
    .restart local v17    # "thumbnailMatrix":Landroid/graphics/Matrix;
    .restart local v18    # "thumbnailCanvas":Landroid/graphics/Canvas;
    .restart local v19    # "previewCanvas":Landroid/graphics/Canvas;
    .restart local v42    # "rs":Landroid/support/v8/renderscript/RenderScript;
    :cond_7
    :try_start_9
    new-instance v41, Lco/vine/android/recorder/PictureConverter;

    const/16 v3, 0x1e0

    move-object/from16 v0, v41

    move-object/from16 v1, v42

    move-object/from16 v2, v38

    invoke-direct {v0, v1, v3, v2}, Lco/vine/android/recorder/PictureConverter;-><init>(Landroid/support/v8/renderscript/RenderScript;ILco/vine/android/recorder/CameraSetting;)V
    :try_end_9
    .catch Lco/vine/android/VineNotSupportedException; {:try_start_9 .. :try_end_9} :catch_3
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 541
    .end local v13    # "pictureConverter":Lco/vine/android/recorder/PictureConverter;
    .local v41, "pictureConverter":Lco/vine/android/recorder/PictureConverter;
    :try_start_a
    invoke-static/range {v41 .. v41}, Lco/vine/android/service/ResourceService;->setPictureConverter(Lco/vine/android/recorder/PictureConverter;)V

    move-object/from16 v13, v41

    .end local v41    # "pictureConverter":Lco/vine/android/recorder/PictureConverter;
    .restart local v13    # "pictureConverter":Lco/vine/android/recorder/PictureConverter;
    goto/16 :goto_3

    .line 537
    :catch_3
    move-exception v39

    .line 538
    .local v39, "e":Lco/vine/android/VineNotSupportedException;
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    new-instance v4, Lco/vine/android/VineLoggingException;

    const-string v5, "Camera is not supported yet."

    invoke-direct {v4, v5}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Lco/vine/android/recorder/BasicVineRecorder;->onDeviceNotSupported(Ljava/lang/Throwable;)V

    .line 539
    const/4 v3, 0x0

    goto :goto_6

    .line 554
    .end local v39    # "e":Lco/vine/android/VineNotSupportedException;
    :cond_8
    const/16 v46, 0x0

    goto/16 :goto_4

    .line 561
    .restart local v16    # "queue":Lco/vine/android/recorder/ByteBufferQueue;
    .restart local v46    # "useRealQueue":Z
    :cond_9
    new-instance v3, Ljava/lang/ref/WeakReference;

    move-object/from16 v0, v16

    invoke-direct {v3, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    sput-object v3, Lco/vine/android/recorder/RecordController;->sByteBufferQueue:Ljava/lang/ref/WeakReference;

    goto/16 :goto_5

    .line 564
    :cond_a
    if-eqz v46, :cond_c

    .line 565
    sget-object v16, Lco/vine/android/recorder/RecordController;->sByteBufferQueueReal:Lco/vine/android/recorder/ByteBufferQueue;

    .line 571
    :cond_b
    :goto_7
    if-nez v16, :cond_d

    .line 572
    new-instance v16, Lco/vine/android/recorder/ByteBufferQueue;

    .end local v16    # "queue":Lco/vine/android/recorder/ByteBufferQueue;
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v3}, Lco/vine/android/recorder/BasicVineRecorder;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v3

    iget v3, v3, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->bufferCount:I

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v4}, Lco/vine/android/recorder/CameraManager;->getFrameSize()I

    move-result v4

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v5}, Lco/vine/android/recorder/BasicVineRecorder;->getMemoryResponder()Lco/vine/android/recorder/ByteBufferQueue$MemoryResponder;

    move-result-object v5

    move-object/from16 v0, v16

    invoke-direct {v0, v3, v4, v5}, Lco/vine/android/recorder/ByteBufferQueue;-><init>(IILco/vine/android/recorder/ByteBufferQueue$MemoryResponder;)V

    .line 573
    .restart local v16    # "queue":Lco/vine/android/recorder/ByteBufferQueue;
    new-instance v3, Ljava/lang/ref/WeakReference;

    move-object/from16 v0, v16

    invoke-direct {v3, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    sput-object v3, Lco/vine/android/recorder/RecordController;->sByteBufferQueue:Ljava/lang/ref/WeakReference;

    goto/16 :goto_5

    .line 567
    :cond_c
    sget-object v3, Lco/vine/android/recorder/RecordController;->sByteBufferQueue:Ljava/lang/ref/WeakReference;

    if-eqz v3, :cond_b

    .line 568
    sget-object v3, Lco/vine/android/recorder/RecordController;->sByteBufferQueue:Ljava/lang/ref/WeakReference;

    invoke-virtual {v3}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v16

    .end local v16    # "queue":Lco/vine/android/recorder/ByteBufferQueue;
    check-cast v16, Lco/vine/android/recorder/ByteBufferQueue;

    .restart local v16    # "queue":Lco/vine/android/recorder/ByteBufferQueue;
    goto :goto_7

    .line 575
    :cond_d
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v3}, Lco/vine/android/recorder/BasicVineRecorder;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v3

    iget v3, v3, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->bufferCount:I

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v4}, Lco/vine/android/recorder/CameraManager;->getFrameSize()I

    move-result v4

    move-object/from16 v0, v16

    invoke-virtual {v0, v3, v4}, Lco/vine/android/recorder/ByteBufferQueue;->reset(II)V

    goto/16 :goto_5

    .line 587
    :cond_e
    move-object/from16 v0, p0

    iget-boolean v3, v0, Lco/vine/android/recorder/RecordController;->mHardwareEncoding:Z

    if-eqz v3, :cond_f

    .line 588
    invoke-static {}, Lco/vine/android/service/ResourceService;->getFrameBuffer()Ljava/nio/ByteBuffer;

    move-result-object v10

    .line 589
    .local v10, "frameBuffer":Ljava/nio/ByteBuffer;
    new-instance v3, Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/RecordController;->mContext:Landroid/content/Context;

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/recorder/RecordController;->mDataQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/recorder/RecordController;->mVideoDataBufferMax:[B

    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    move-object/from16 v7, p0

    move-object/from16 v8, p2

    move/from16 v14, p4

    invoke-direct/range {v3 .. v19}, Lco/vine/android/recorder/HwEncodingRunnable;-><init>(Landroid/content/Context;Ljava/util/concurrent/ConcurrentLinkedQueue;[BLco/vine/android/recorder/RecordController;Ljava/lang/String;ILjava/nio/ByteBuffer;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Lco/vine/android/recorder/PictureConverter;ILco/vine/android/recorder/CameraManager;Lco/vine/android/recorder/ByteBufferQueue;Landroid/graphics/Matrix;Landroid/graphics/Canvas;Landroid/graphics/Canvas;)V

    move-object/from16 v0, p0

    iput-object v3, v0, Lco/vine/android/recorder/RecordController;->mEncodingRunnable:Lco/vine/android/recorder/AbstractEncodingRunnable;

    .line 599
    .end local v10    # "frameBuffer":Ljava/nio/ByteBuffer;
    :goto_8
    new-instance v3, Ljava/lang/Thread;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/RecordController;->mEncodingRunnable:Lco/vine/android/recorder/AbstractEncodingRunnable;

    const-string v5, "EncodingRunnable"

    invoke-direct {v3, v4, v5}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    move-object/from16 v0, p0

    iput-object v3, v0, Lco/vine/android/recorder/RecordController;->mProcessThread:Ljava/lang/Thread;

    .line 600
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mProcessThread:Ljava/lang/Thread;

    invoke-virtual {v3}, Ljava/lang/Thread;->start()V

    .line 601
    const-string v3, "start 7 took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long v4, v4, v43

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 602
    const/4 v3, 0x1

    goto/16 :goto_6

    .line 594
    :cond_f
    new-instance v20, Lco/vine/android/recorder/SwEncodingRunnable;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/RecordController;->mDataQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/RecordController;->mVideoDataBufferMax:[B

    move-object/from16 v22, v0

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/recorder/RecordController;->getFrameBuffer()Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    move-result-object v26

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    move-object/from16 v31, v0

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/recorder/RecordController;->mUseMp4:Z

    move/from16 v36, v0

    move-object/from16 v23, p0

    move-object/from16 v24, p2

    move/from16 v25, v9

    move-object/from16 v27, v11

    move-object/from16 v28, v12

    move-object/from16 v29, v13

    move/from16 v30, p4

    move-object/from16 v32, v16

    move-object/from16 v33, v17

    move-object/from16 v34, v18

    move-object/from16 v35, v19

    invoke-direct/range {v20 .. v36}, Lco/vine/android/recorder/SwEncodingRunnable;-><init>(Ljava/util/concurrent/ConcurrentLinkedQueue;[BLco/vine/android/recorder/RecordController;Ljava/lang/String;ILcom/googlecode/javacv/cpp/opencv_core$IplImage;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Lco/vine/android/recorder/PictureConverter;ILco/vine/android/recorder/CameraManager;Lco/vine/android/recorder/ByteBufferQueue;Landroid/graphics/Matrix;Landroid/graphics/Canvas;Landroid/graphics/Canvas;Z)V

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/RecordController;->mEncodingRunnable:Lco/vine/android/recorder/AbstractEncodingRunnable;
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    goto :goto_8
.end method

.method public startPreview()V
    .locals 17

    .prologue
    .line 658
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v1}, Lco/vine/android/recorder/CameraManager;->isCameraReady()Z

    move-result v1

    if-eqz v1, :cond_0

    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v1}, Lco/vine/android/recorder/CameraManager;->isPreviewing()Z

    move-result v1

    if-nez v1, :cond_0

    .line 659
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v1}, Lco/vine/android/recorder/CameraManager;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v9

    .line 660
    .local v9, "cs":Lco/vine/android/recorder/CameraSetting;
    if-eqz v9, :cond_0

    .line 661
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    iget v3, v9, Lco/vine/android/recorder/CameraSetting;->originalFrameRate:I

    invoke-virtual {v1, v3}, Lco/vine/android/recorder/CameraManager;->setFrameRate(I)I

    move-result v1

    iput v1, v9, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    .line 662
    iget v1, v9, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    if-lez v1, :cond_0

    .line 663
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v1}, Lco/vine/android/recorder/BasicVineRecorder;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v2

    .line 664
    .local v2, "config":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    const-wide/32 v3, 0xf4240

    iget v1, v9, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    int-to-long v5, v1

    div-long/2addr v3, v5

    move-object/from16 v0, p0

    iput-wide v3, v0, Lco/vine/android/recorder/RecordController;->mFrameTime:J

    .line 665
    const-string v1, "Determined frame rate: {}, frame time: {}."

    iget v3, v9, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    move-object/from16 v0, p0

    iget-wide v4, v0, Lco/vine/android/recorder/RecordController;->mFrameTime:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v1, v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 667
    :try_start_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/RecordController;->mTextureView:Landroid/view/TextureView;

    if-eqz v1, :cond_1

    .line 668
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mSurfaceTexture:Landroid/graphics/SurfaceTexture;

    move-object/from16 v0, p0

    iget-boolean v4, v0, Lco/vine/android/recorder/RecordController;->mFlash:Z

    move-object/from16 v0, p0

    iget-boolean v5, v0, Lco/vine/android/recorder/RecordController;->mAutoFocus:Z

    iget v6, v9, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    move-object/from16 v0, p0

    iget v7, v0, Lco/vine/android/recorder/RecordController;->mRotation:I

    move-object/from16 v0, p0

    iget-wide v13, v0, Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J

    const-wide/16 v15, 0x3e8

    div-long/2addr v13, v15

    long-to-int v8, v13

    invoke-virtual/range {v1 .. v8}, Lco/vine/android/recorder/CameraManager;->startPreview(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;Landroid/graphics/SurfaceTexture;ZZIII)V

    .line 696
    .end local v2    # "config":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .end local v9    # "cs":Lco/vine/android/recorder/CameraSetting;
    :cond_0
    :goto_0
    return-void

    .line 670
    .restart local v2    # "config":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .restart local v9    # "cs":Lco/vine/android/recorder/CameraSetting;
    :cond_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mSurface:Landroid/view/Surface;

    move-object/from16 v0, p0

    iget-boolean v4, v0, Lco/vine/android/recorder/RecordController;->mFlash:Z

    move-object/from16 v0, p0

    iget-boolean v5, v0, Lco/vine/android/recorder/RecordController;->mAutoFocus:Z

    iget v6, v9, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    move-object/from16 v0, p0

    iget v7, v0, Lco/vine/android/recorder/RecordController;->mRotation:I

    move-object/from16 v0, p0

    iget-wide v13, v0, Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J

    const-wide/16 v15, 0x3e8

    div-long/2addr v13, v15

    long-to-int v8, v13

    invoke-virtual/range {v1 .. v8}, Lco/vine/android/recorder/CameraManager;->startPreview(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;Landroid/view/Surface;ZZIII)V
    :try_end_0
    .catch Lco/vine/android/recorder/CameraManager$InvalidPreviewSizeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 672
    :catch_0
    move-exception v11

    .line 673
    .local v11, "e":Lco/vine/android/recorder/CameraManager$InvalidPreviewSizeException;
    const/16 v1, 0xf0

    iput v1, v9, Lco/vine/android/recorder/CameraSetting;->originalH:I

    .line 674
    const/16 v1, 0x140

    iput v1, v9, Lco/vine/android/recorder/CameraSetting;->originalW:I

    .line 675
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "CAUGHT INVALID PREVIEW SIZE, trying to use a smaller size again: "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v3, v9, Lco/vine/android/recorder/CameraSetting;->originalW:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " * "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v3, v9, Lco/vine/android/recorder/CameraSetting;->originalH:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " ff: "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v3, v9, Lco/vine/android/recorder/CameraSetting;->frontFacing:Z

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 676
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    if-eqz v1, :cond_2

    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v1, v1, Lco/vine/android/recorder/BasicVineRecorder;->mActivity:Landroid/app/Activity;

    if-eqz v1, :cond_2

    .line 677
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v1, v1, Lco/vine/android/recorder/BasicVineRecorder;->mActivity:Landroid/app/Activity;

    invoke-static {v1}, Lco/vine/android/util/SystemUtil;->getDisplaySize(Landroid/app/Activity;)Landroid/graphics/Point;

    move-result-object v10

    .line 678
    .local v10, "displaySize":Landroid/graphics/Point;
    const-string v1, "Screen size: {} * {}"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget v5, v10, Landroid/graphics/Point;->x:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    iget v5, v10, Landroid/graphics/Point;->y:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v3}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 680
    .end local v10    # "displaySize":Landroid/graphics/Point;
    :cond_2
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v1}, Lco/vine/android/recorder/CameraManager;->printSupportedPreviewSizes()V

    .line 681
    move-object/from16 v0, p0

    iput-object v11, v0, Lco/vine/android/recorder/RecordController;->mInvalidPreviewSizeException:Lco/vine/android/recorder/CameraManager$InvalidPreviewSizeException;

    .line 682
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    iget v3, v9, Lco/vine/android/recorder/CameraSetting;->originalW:I

    iget v4, v9, Lco/vine/android/recorder/CameraSetting;->originalH:I

    invoke-virtual {v1, v3, v4}, Lco/vine/android/recorder/CameraManager;->setPreviewSize(II)V

    .line 684
    :try_start_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/RecordController;->mTextureView:Landroid/view/TextureView;

    if-eqz v1, :cond_3

    .line 685
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mSurfaceTexture:Landroid/graphics/SurfaceTexture;

    move-object/from16 v0, p0

    iget-boolean v4, v0, Lco/vine/android/recorder/RecordController;->mFlash:Z

    move-object/from16 v0, p0

    iget-boolean v5, v0, Lco/vine/android/recorder/RecordController;->mAutoFocus:Z

    iget v6, v9, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    move-object/from16 v0, p0

    iget v7, v0, Lco/vine/android/recorder/RecordController;->mRotation:I

    move-object/from16 v0, p0

    iget-wide v13, v0, Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J

    const-wide/16 v15, 0x3e8

    div-long/2addr v13, v15

    long-to-int v8, v13

    invoke-virtual/range {v1 .. v8}, Lco/vine/android/recorder/CameraManager;->startPreview(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;Landroid/graphics/SurfaceTexture;ZZIII)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_0

    .line 689
    :catch_1
    move-exception v12

    .line 690
    .local v12, "e2":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v12}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 687
    .end local v12    # "e2":Ljava/lang/Exception;
    :cond_3
    :try_start_2
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/RecordController;->mSurface:Landroid/view/Surface;

    move-object/from16 v0, p0

    iget-boolean v4, v0, Lco/vine/android/recorder/RecordController;->mFlash:Z

    move-object/from16 v0, p0

    iget-boolean v5, v0, Lco/vine/android/recorder/RecordController;->mAutoFocus:Z

    iget v6, v9, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    move-object/from16 v0, p0

    iget v7, v0, Lco/vine/android/recorder/RecordController;->mRotation:I

    move-object/from16 v0, p0

    iget-wide v13, v0, Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J

    const-wide/16 v15, 0x3e8

    div-long/2addr v13, v15

    long-to-int v8, v13

    invoke-virtual/range {v1 .. v8}, Lco/vine/android/recorder/CameraManager;->startPreview(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;Landroid/view/Surface;ZZIII)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_0
.end method

.method public stop(ZZ)Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    .locals 12
    .param p1, "discard"    # Z
    .param p2, "stopPreview"    # Z

    .prologue
    const/4 v11, 0x0

    const/4 v10, 0x0

    .line 251
    iget-boolean v8, p0, Lco/vine/android/recorder/RecordController;->isRecordingStarted:Z

    if-nez v8, :cond_0

    .line 252
    sget-boolean v8, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v8, :cond_0

    .line 253
    new-instance v8, Ljava/lang/IllegalStateException;

    const-string v9, "You can\'t stop before you have start it."

    invoke-direct {v8, v9}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 256
    :cond_0
    const/4 v1, 0x0

    .line 257
    .local v1, "r":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    const/4 v2, 0x0

    .line 259
    .local v2, "releaseThread":Ljava/lang/Thread;
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 260
    .local v4, "stopStart":J
    const-string v8, "Stop audio runnable and recording."

    invoke-static {v8}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 261
    const/4 v8, 0x0

    iput-boolean v8, p0, Lco/vine/android/recorder/RecordController;->mRunAudioThread:Z

    .line 262
    iget-boolean v8, p0, Lco/vine/android/recorder/RecordController;->isRecordingStarted:Z

    if-eqz v8, :cond_3

    .line 263
    const-string v8, "Finishing recording, calling stop and release on recorder"

    invoke-static {v8}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 264
    if-eqz p2, :cond_7

    .line 265
    iget-boolean v8, p0, Lco/vine/android/recorder/RecordController;->mFastEncoding:Z

    if-eqz v8, :cond_6

    .line 266
    new-instance v3, Ljava/lang/Thread;

    new-instance v8, Lco/vine/android/recorder/RecordController$1;

    invoke-direct {v8, p0}, Lco/vine/android/recorder/RecordController$1;-><init>(Lco/vine/android/recorder/RecordController;)V

    invoke-direct {v3, v8}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 272
    .end local v2    # "releaseThread":Ljava/lang/Thread;
    .local v3, "releaseThread":Ljava/lang/Thread;
    :try_start_1
    invoke-virtual {v3}, Ljava/lang/Thread;->start()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3

    move-object v2, v3

    .line 279
    .end local v3    # "releaseThread":Ljava/lang/Thread;
    .restart local v2    # "releaseThread":Ljava/lang/Thread;
    :goto_0
    :try_start_2
    const-string v8, "Waiting..........."

    invoke-static {v8}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 280
    const/4 v8, 0x0

    iput-boolean v8, p0, Lco/vine/android/recorder/RecordController;->isRecordingStarted:Z

    .line 281
    if-eqz p1, :cond_8

    .line 282
    iget-object v8, p0, Lco/vine/android/recorder/RecordController;->mEncodingRunnable:Lco/vine/android/recorder/AbstractEncodingRunnable;

    if-eqz v8, :cond_1

    .line 283
    iget-object v8, p0, Lco/vine/android/recorder/RecordController;->mEncodingRunnable:Lco/vine/android/recorder/AbstractEncodingRunnable;

    invoke-virtual {v8}, Lco/vine/android/recorder/AbstractEncodingRunnable;->terminate()V

    .line 285
    :cond_1
    iget-object v8, p0, Lco/vine/android/recorder/RecordController;->mProcessThread:Ljava/lang/Thread;

    if-eqz v8, :cond_2

    .line 286
    iget-object v8, p0, Lco/vine/android/recorder/RecordController;->mProcessThread:Ljava/lang/Thread;

    invoke-virtual {v8}, Ljava/lang/Thread;->interrupt()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 289
    :cond_2
    :try_start_3
    invoke-virtual {p0}, Lco/vine/android/recorder/RecordController;->finishLastIfNeeded()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    .line 314
    :cond_3
    :goto_1
    const/4 v8, 0x1

    :try_start_4
    iput-boolean v8, p0, Lco/vine/android/recorder/RecordController;->mIsRecordingEnded:Z
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    .line 318
    .end local v4    # "stopStart":J
    :goto_2
    iput-boolean v10, p0, Lco/vine/android/recorder/RecordController;->isRecordingStarted:Z

    .line 319
    if-eqz p2, :cond_b

    .line 320
    const-string v8, "Force stop"

    invoke-virtual {p0, v8}, Lco/vine/android/recorder/RecordController;->releaseCameraAndPreview(Ljava/lang/String;)V

    .line 326
    :goto_3
    iget-object v8, p0, Lco/vine/android/recorder/RecordController;->mFinishProcessTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    if-eqz v8, :cond_4

    .line 327
    iget-object v8, p0, Lco/vine/android/recorder/RecordController;->mFinishProcessTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    const/16 v9, 0x64

    invoke-virtual {v8, v9}, Lco/vine/android/recorder/BaseFinishProcessTask;->publish(I)V

    .line 329
    :cond_4
    if-eqz v2, :cond_5

    .line 331
    :try_start_5
    invoke-virtual {v2}, Ljava/lang/Thread;->join()V
    :try_end_5
    .catch Ljava/lang/InterruptedException; {:try_start_5 .. :try_end_5} :catch_2

    .line 336
    :cond_5
    :goto_4
    const-string v8, "Recorder is stopped."

    invoke-static {v8}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 337
    return-object v1

    .line 274
    .restart local v4    # "stopStart":J
    :cond_6
    :try_start_6
    const-string v8, "Stop"

    invoke-virtual {p0, v8}, Lco/vine/android/recorder/RecordController;->releaseCameraAndPreview(Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_0

    goto :goto_0

    .line 315
    .end local v4    # "stopStart":J
    :catch_0
    move-exception v0

    .line 316
    .local v0, "e":Ljava/lang/Exception;
    :goto_5
    const-string v8, "Stop failed"

    new-array v9, v10, [Ljava/lang/Object;

    invoke-static {v0, v8, v9}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2

    .line 277
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v4    # "stopStart":J
    :cond_7
    :try_start_7
    iget-object v8, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Lco/vine/android/recorder/CameraManager;->setController(Lco/vine/android/recorder/RecordController;)V

    goto :goto_0

    .line 290
    :catch_1
    move-exception v0

    .line 291
    .restart local v0    # "e":Ljava/lang/Exception;
    const-string v8, "discard failed."

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Object;

    invoke-static {v0, v8, v9}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 294
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_8
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v8

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v9

    if-ne v8, v9, :cond_9

    .line 295
    const/4 v8, 0x1

    iput-boolean v8, p0, Lco/vine/android/recorder/RecordController;->mEncodingThreadWasRunning:Z

    goto :goto_1

    .line 297
    :cond_9
    iget-object v8, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v8}, Lco/vine/android/recorder/BasicVineRecorder;->canKeepRecording()Z

    move-result v8

    if-nez v8, :cond_a

    .line 298
    const/4 v8, 0x1

    iput-boolean v8, p0, Lco/vine/android/recorder/RecordController;->mEncodingThreadWasRunning:Z

    .line 300
    :cond_a
    invoke-virtual {p0}, Lco/vine/android/recorder/RecordController;->finishLastIfNeeded()V

    .line 301
    iget-object v8, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v8}, Lco/vine/android/recorder/BasicVineRecorder;->canKeepRecording()Z

    move-result v8

    if-nez v8, :cond_3

    .line 302
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 303
    const/4 v8, 0x0

    invoke-virtual {p0, v8}, Lco/vine/android/recorder/RecordController;->writeToFile(Z)Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    move-result-object v1

    .line 304
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    sub-long v6, v8, v4

    .line 305
    .local v6, "stopTime":J
    const-string v8, "Stop wait time: {}."

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 306
    sget-wide v8, Lco/vine/android/recorder/RecordController;->sMaxKnownStopTime:J

    cmp-long v8, v6, v8

    if-lez v8, :cond_3

    .line 307
    sput-wide v6, Lco/vine/android/recorder/RecordController;->sMaxKnownStopTime:J
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_0

    goto/16 :goto_1

    .line 322
    .end local v4    # "stopStart":J
    .end local v6    # "stopTime":J
    :cond_b
    invoke-direct {p0}, Lco/vine/android/recorder/RecordController;->clearLastFrames()V

    .line 323
    iget-object v8, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v8, v11}, Lco/vine/android/recorder/CameraManager;->setController(Lco/vine/android/recorder/RecordController;)V

    goto/16 :goto_3

    .line 332
    :catch_2
    move-exception v0

    .line 333
    .local v0, "e":Ljava/lang/InterruptedException;
    const-string v8, "Camera still not released?!"

    invoke-static {v8}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto :goto_4

    .line 315
    .end local v0    # "e":Ljava/lang/InterruptedException;
    .end local v2    # "releaseThread":Ljava/lang/Thread;
    .restart local v3    # "releaseThread":Ljava/lang/Thread;
    .restart local v4    # "stopStart":J
    :catch_3
    move-exception v0

    move-object v2, v3

    .end local v3    # "releaseThread":Ljava/lang/Thread;
    .restart local v2    # "releaseThread":Ljava/lang/Thread;
    goto :goto_5
.end method

.method public stopZoom()V
    .locals 1

    .prologue
    .line 763
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0}, Lco/vine/android/recorder/CameraManager;->stopSmoothZoom()Z

    .line 764
    return-void
.end method

.method public surfaceChanged(Landroid/view/SurfaceHolder;III)V
    .locals 1
    .param p1, "holder"    # Landroid/view/SurfaceHolder;
    .param p2, "format"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I

    .prologue
    .line 715
    iput-object p1, p0, Lco/vine/android/recorder/RecordController;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    .line 716
    invoke-interface {p1}, Landroid/view/SurfaceHolder;->getSurface()Landroid/view/Surface;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mSurface:Landroid/view/Surface;

    .line 717
    invoke-direct {p0}, Lco/vine/android/recorder/RecordController;->onSurfaceCreated()V

    .line 718
    invoke-direct {p0}, Lco/vine/android/recorder/RecordController;->onSurfaceUpdated()V

    .line 719
    return-void
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 1
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 708
    iput-object p1, p0, Lco/vine/android/recorder/RecordController;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    .line 709
    invoke-interface {p1}, Landroid/view/SurfaceHolder;->getSurface()Landroid/view/Surface;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mSurface:Landroid/view/Surface;

    .line 710
    invoke-direct {p0}, Lco/vine/android/recorder/RecordController;->onSurfaceCreated()V

    .line 711
    return-void
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 0
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 723
    invoke-direct {p0}, Lco/vine/android/recorder/RecordController;->onSurfaceDestroyed()V

    .line 724
    return-void
.end method

.method public swapSession()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 136
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/BasicVineRecorder;->getFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mSession:Lco/vine/android/recorder/RecordSession;

    .line 137
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mSession:Lco/vine/android/recorder/RecordSession;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordSession;->getVideoData()[B

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mVideoDataBufferMax:[B

    .line 138
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mSession:Lco/vine/android/recorder/RecordSession;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordSession;->getAudioData()Lco/vine/android/recorder/AudioArray;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mAudioDataBufferMax:Lco/vine/android/recorder/AudioArray;

    .line 139
    iput-object v2, p0, Lco/vine/android/recorder/RecordController;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    .line 140
    invoke-direct {p0}, Lco/vine/android/recorder/RecordController;->clearLastFrames()V

    .line 141
    iput-object v2, p0, Lco/vine/android/recorder/RecordController;->mLastLastFrame:Lco/vine/android/recorder/VideoData;

    .line 142
    iput-object v2, p0, Lco/vine/android/recorder/RecordController;->mLastVideoSegment:Lco/vine/android/recorder/RecordSegment;

    .line 143
    iput-object v2, p0, Lco/vine/android/recorder/RecordController;->mLastAudioRecordingSegment:Lco/vine/android/recorder/RecordSegment;

    .line 144
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/recorder/RecordController;->mIsRecordingEnded:Z

    .line 145
    iput-object v2, p0, Lco/vine/android/recorder/RecordController;->mOutput:Ljava/lang/String;

    .line 146
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mAudioThread:Ljava/lang/Thread;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mAudioRunnable:Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

    if-eqz v0, :cond_1

    .line 147
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mAudioRunnable:Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

    iget-boolean v0, v0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->isInitialized:Z

    if-eqz v0, :cond_0

    .line 148
    const-string v0, "Force quit audio runnable."

    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 149
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mAudioRunnable:Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->forceQuit:Z

    .line 152
    :cond_0
    :try_start_0
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mAudioThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->join()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 157
    :cond_1
    :goto_0
    iput-object v2, p0, Lco/vine/android/recorder/RecordController;->mAudioThread:Ljava/lang/Thread;

    .line 158
    iput-object v2, p0, Lco/vine/android/recorder/RecordController;->mAudioRunnable:Lco/vine/android/recorder/RecordController$AudioRecordRunnable;

    .line 159
    iput-object v2, p0, Lco/vine/android/recorder/RecordController;->mGhostFrame:Lco/vine/android/recorder/VideoData;

    .line 160
    return-void

    .line 153
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public switchFlash()V
    .locals 2

    .prologue
    .line 168
    iget-boolean v0, p0, Lco/vine/android/recorder/RecordController;->mFlash:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lco/vine/android/recorder/RecordController;->mFlash:Z

    .line 169
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    iget-boolean v1, p0, Lco/vine/android/recorder/RecordController;->mFlash:Z

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/CameraManager;->changeFlashState(Z)V

    .line 170
    return-void

    .line 168
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public switchImageStabilization()V
    .locals 1

    .prologue
    .line 779
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0}, Lco/vine/android/recorder/CameraManager;->switchImageStabilization()V

    .line 780
    return-void
.end method

.method public switchSurface(Landroid/view/SurfaceView;)V
    .locals 1
    .param p1, "view"    # Landroid/view/SurfaceView;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 630
    invoke-virtual {p1}, Landroid/view/SurfaceView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RecordController;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    .line 631
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v0, p0}, Landroid/view/SurfaceHolder;->addCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 632
    return-void
.end method

.method public switchSurface(Landroid/view/TextureView;)V
    .locals 3
    .param p1, "view"    # Landroid/view/TextureView;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 622
    iput-object p1, p0, Lco/vine/android/recorder/RecordController;->mTextureView:Landroid/view/TextureView;

    .line 623
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mTextureView:Landroid/view/TextureView;

    invoke-virtual {v0, p0}, Landroid/view/TextureView;->setSurfaceTextureListener(Landroid/view/TextureView$SurfaceTextureListener;)V

    .line 624
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mTextureView:Landroid/view/TextureView;

    invoke-virtual {v0}, Landroid/view/TextureView;->isAvailable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 625
    invoke-virtual {p1}, Landroid/view/TextureView;->getSurfaceTexture()Landroid/graphics/SurfaceTexture;

    move-result-object v0

    invoke-virtual {p1}, Landroid/view/TextureView;->getWidth()I

    move-result v1

    invoke-virtual {p1}, Landroid/view/TextureView;->getHeight()I

    move-result v2

    invoke-virtual {p0, v0, v1, v2}, Lco/vine/android/recorder/RecordController;->onSurfaceTextureAvailable(Landroid/graphics/SurfaceTexture;II)V

    .line 627
    :cond_0
    return-void
.end method

.method public updateRotation(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 164
    invoke-static {p1}, Lco/vine/android/recorder/CameraManager;->getCameraRotation(Landroid/app/Activity;)I

    move-result v0

    iput v0, p0, Lco/vine/android/recorder/RecordController;->mRotation:I

    .line 165
    return-void
.end method

.method public waitForPreviewToStart()V
    .locals 1

    .prologue
    .line 445
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v0}, Lco/vine/android/recorder/CameraManager;->waitForPreviewToStart()V

    .line 446
    return-void
.end method

.method public wasEncodingThreadRunning()Z
    .locals 1

    .prologue
    .line 236
    iget-boolean v0, p0, Lco/vine/android/recorder/RecordController;->mEncodingThreadWasRunning:Z

    return v0
.end method

.method public writeToFile(Z)Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    .locals 7
    .param p1, "preview"    # Z

    .prologue
    .line 374
    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/BasicVineRecorder;->getFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v6

    .line 375
    .local v6, "session":Lco/vine/android/recorder/RecordSession;
    invoke-virtual {v6}, Lco/vine/android/recorder/RecordSession;->getSegments()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v6}, Lco/vine/android/recorder/RecordSession;->getVideoData()[B

    move-result-object v2

    invoke-virtual {v6}, Lco/vine/android/recorder/RecordSession;->getAudioData()Lco/vine/android/recorder/AudioArray;

    move-result-object v3

    iget-object v0, p0, Lco/vine/android/recorder/RecordController;->mLastCameraSetting:Lco/vine/android/recorder/CameraSetting;

    iget v5, v0, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    move-object v0, p0

    move v4, p1

    invoke-direct/range {v0 .. v5}, Lco/vine/android/recorder/RecordController;->writeToFile(Ljava/util/ArrayList;[BLco/vine/android/recorder/AudioArray;ZI)Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    move-result-object v0

    return-object v0
.end method

.method public writeToFile(Ljava/util/ArrayList;[BLco/vine/android/recorder/AudioArray;I)V
    .locals 7
    .param p2, "videoData"    # [B
    .param p3, "audioData"    # Lco/vine/android/recorder/AudioArray;
    .param p4, "frameRate"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/recorder/RecordSegment;",
            ">;[B",
            "Lco/vine/android/recorder/AudioArray;",
            "I)V"
        }
    .end annotation

    .prologue
    .line 367
    .local p1, "editedSegments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSegment;>;"
    const/4 v4, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lco/vine/android/recorder/RecordController;->writeToFile(Ljava/util/ArrayList;[BLco/vine/android/recorder/AudioArray;ZI)Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    move-result-object v6

    .line 368
    .local v6, "r":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    if-eqz v6, :cond_0

    .line 369
    invoke-virtual {v6}, Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;->run()V

    .line 371
    :cond_0
    return-void
.end method
