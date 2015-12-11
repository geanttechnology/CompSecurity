.class public Lco/vine/android/recorder/InlineVineRecorder;
.super Lco/vine/android/recorder/RegularVineRecorder;
.source "InlineVineRecorder.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xe
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/recorder/InlineVineRecorder$InlineFinishProcessTask;,
        Lco/vine/android/recorder/InlineVineRecorder$ProcessingListener;
    }
.end annotation


# static fields
.field private static DELAY_WAIT_FOR_EXPOSURE:J

.field public static final METHOD_TRACING:Z

.field public static startnanos:J


# instance fields
.field private mCameraSuccessfullyOpened:Z

.field private mFinishProgressView:Lco/vine/android/recorder/ProgressView;

.field private final mFinishProgressViewResourceId:I

.field private final mPaddingSize:I

.field private mProcessingListener:Lco/vine/android/recorder/InlineVineRecorder$ProcessingListener;

.field private mStartRelativeTimeRunnable:Ljava/lang/Runnable;

.field private mStarted:Z

.field private mStopping:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 24
    const-wide/16 v0, 0x15e

    sput-wide v0, Lco/vine/android/recorder/InlineVineRecorder;->DELAY_WAIT_FOR_EXPOSURE:J

    .line 26
    const-wide/16 v0, 0x0

    sput-wide v0, Lco/vine/android/recorder/InlineVineRecorder;->startnanos:J

    return-void
.end method

.method public varargs constructor <init>(Lco/vine/android/recorder/RecordSessionVersion;Landroid/graphics/Point;Landroid/app/Activity;Lco/vine/android/recorder/InlineVineRecorder$ProcessingListener;IIIIIIIIILjava/lang/String;[Ljava/lang/CharSequence;)V
    .locals 17
    .param p1, "version"    # Lco/vine/android/recorder/RecordSessionVersion;
    .param p2, "screenSize"    # Landroid/graphics/Point;
    .param p3, "activity"    # Landroid/app/Activity;
    .param p4, "listener"    # Lco/vine/android/recorder/InlineVineRecorder$ProcessingListener;
    .param p5, "recorderPadding"    # I
    .param p6, "progressViewResourceId"    # I
    .param p7, "finishProgressViewResourceId"    # I
    .param p8, "cameraViewResourceId"    # I
    .param p9, "topMaskId"    # I
    .param p10, "bottomMaskId"    # I
    .param p11, "cameraFailString"    # I
    .param p12, "openCameraString"    # I
    .param p13, "rootLayoutId"    # I
    .param p14, "deviceNotSupportedString"    # Ljava/lang/String;
    .param p15, "messages"    # [Ljava/lang/CharSequence;

    .prologue
    .line 60
    const/16 v3, 0x42

    const/4 v14, 0x1

    move-object/from16 v2, p0

    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move/from16 v6, p6

    move/from16 v7, p8

    move/from16 v8, p9

    move/from16 v9, p10

    move/from16 v10, p11

    move/from16 v11, p12

    move/from16 v12, p13

    move-object/from16 v13, p14

    move-object/from16 v15, p1

    move-object/from16 v16, p15

    invoke-direct/range {v2 .. v16}, Lco/vine/android/recorder/RegularVineRecorder;-><init>(ILandroid/graphics/Point;Landroid/app/Activity;IIIIIIILjava/lang/String;ZLco/vine/android/recorder/RecordSessionVersion;[Ljava/lang/CharSequence;)V

    .line 30
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lco/vine/android/recorder/InlineVineRecorder;->mCameraSuccessfullyOpened:Z

    .line 32
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lco/vine/android/recorder/InlineVineRecorder;->mStopping:Z

    .line 35
    new-instance v2, Lco/vine/android/recorder/InlineVineRecorder$1;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lco/vine/android/recorder/InlineVineRecorder$1;-><init>(Lco/vine/android/recorder/InlineVineRecorder;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/recorder/InlineVineRecorder;->mStartRelativeTimeRunnable:Ljava/lang/Runnable;

    .line 64
    move-object/from16 v0, p4

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/InlineVineRecorder;->mProcessingListener:Lco/vine/android/recorder/InlineVineRecorder$ProcessingListener;

    .line 65
    move/from16 v0, p5

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/InlineVineRecorder;->mPaddingSize:I

    .line 66
    move/from16 v0, p7

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/InlineVineRecorder;->mFinishProgressViewResourceId:I

    .line 67
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/recorder/InlineVineRecorder;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/InlineVineRecorder;

    .prologue
    .line 22
    iget-boolean v0, p0, Lco/vine/android/recorder/InlineVineRecorder;->mCameraSuccessfullyOpened:Z

    return v0
.end method

.method static synthetic access$100(Lco/vine/android/recorder/InlineVineRecorder;)Lco/vine/android/recorder/InlineVineRecorder$ProcessingListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/InlineVineRecorder;

    .prologue
    .line 22
    iget-object v0, p0, Lco/vine/android/recorder/InlineVineRecorder;->mProcessingListener:Lco/vine/android/recorder/InlineVineRecorder$ProcessingListener;

    return-object v0
.end method

.method static synthetic access$202(Lco/vine/android/recorder/InlineVineRecorder;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/InlineVineRecorder;
    .param p1, "x1"    # Z

    .prologue
    .line 22
    iput-boolean p1, p0, Lco/vine/android/recorder/InlineVineRecorder;->mStopping:Z

    return p1
.end method

.method static synthetic access$300(Lco/vine/android/recorder/InlineVineRecorder;)Lco/vine/android/recorder/ProgressView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/InlineVineRecorder;

    .prologue
    .line 22
    iget-object v0, p0, Lco/vine/android/recorder/InlineVineRecorder;->mFinishProgressView:Lco/vine/android/recorder/ProgressView;

    return-object v0
.end method


# virtual methods
.method protected adjustBoundaries(Lco/vine/android/recorder/CameraSetting;)V
    .locals 13
    .param p1, "cs"    # Lco/vine/android/recorder/CameraSetting;

    .prologue
    .line 114
    iget-object v0, p0, Lco/vine/android/recorder/InlineVineRecorder;->mActivity:Landroid/app/Activity;

    .line 115
    .local v0, "activity":Landroid/app/Activity;
    if-eqz v0, :cond_0

    .line 116
    if-eqz p1, :cond_0

    .line 118
    iget v11, p1, Lco/vine/android/recorder/CameraSetting;->originalW:I

    int-to-float v7, v11

    .line 119
    .local v7, "previewWidth":F
    iget v11, p1, Lco/vine/android/recorder/CameraSetting;->originalH:I

    int-to-float v6, v11

    .line 120
    .local v6, "previewHeight":F
    div-float v1, v7, v6

    .line 121
    .local v1, "aspectRatio":F
    iget-object v11, p0, Lco/vine/android/recorder/InlineVineRecorder;->mSize:Landroid/graphics/Point;

    iget v11, v11, Landroid/graphics/Point;->x:I

    iget v12, p0, Lco/vine/android/recorder/InlineVineRecorder;->mPaddingSize:I

    mul-int/lit8 v12, v12, 0x2

    sub-int v5, v11, v12

    .line 123
    .local v5, "cameraViewWidth":I
    int-to-float v11, v5

    mul-float/2addr v11, v1

    float-to-int v3, v11

    .line 125
    .local v3, "cameraViewHeight":I
    iget-object v11, p0, Lco/vine/android/recorder/InlineVineRecorder;->mTopMaskView:Landroid/view/View;

    if-eqz v11, :cond_0

    iget-object v11, p0, Lco/vine/android/recorder/InlineVineRecorder;->mBottomMaskView:Landroid/view/View;

    if-eqz v11, :cond_0

    .line 126
    iget-object v11, p0, Lco/vine/android/recorder/InlineVineRecorder;->mBottomMaskView:Landroid/view/View;

    invoke-virtual {v11}, Landroid/view/View;->getMeasuredHeight()I

    move-result v2

    .line 127
    .local v2, "bottomMaskHeightPx":I
    iget-object v11, p0, Lco/vine/android/recorder/InlineVineRecorder;->mRootLayoutView:Landroid/view/View;

    invoke-virtual {v11}, Landroid/view/View;->getMeasuredHeight()I

    move-result v8

    .line 128
    .local v8, "rootHeight":I
    sub-int v11, v8, v2

    iget-object v12, p0, Lco/vine/android/recorder/InlineVineRecorder;->mSize:Landroid/graphics/Point;

    iget v12, v12, Landroid/graphics/Point;->x:I

    sub-int v9, v11, v12

    .line 130
    .local v9, "topMaskHeight":I
    iget-object v11, p0, Lco/vine/android/recorder/InlineVineRecorder;->mTopMaskView:Landroid/view/View;

    invoke-virtual {v11}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v10

    check-cast v10, Landroid/widget/RelativeLayout$LayoutParams;

    .line 132
    .local v10, "topMaskParams":Landroid/widget/RelativeLayout$LayoutParams;
    iput v9, v10, Landroid/widget/RelativeLayout$LayoutParams;->height:I

    .line 134
    iget-object v11, p0, Lco/vine/android/recorder/InlineVineRecorder;->mCameraView:Landroid/view/View;

    invoke-virtual {v11}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    check-cast v4, Landroid/widget/RelativeLayout$LayoutParams;

    .line 136
    .local v4, "cameraViewParams":Landroid/widget/RelativeLayout$LayoutParams;
    iput v5, v4, Landroid/widget/RelativeLayout$LayoutParams;->width:I

    .line 137
    iput v3, v4, Landroid/widget/RelativeLayout$LayoutParams;->height:I

    .line 138
    iget v11, p0, Lco/vine/android/recorder/InlineVineRecorder;->mPaddingSize:I

    iput v11, v4, Landroid/widget/RelativeLayout$LayoutParams;->leftMargin:I

    .line 140
    iget-object v11, p0, Lco/vine/android/recorder/InlineVineRecorder;->mActivity:Landroid/app/Activity;

    new-instance v12, Lco/vine/android/recorder/InlineVineRecorder$3;

    invoke-direct {v12, p0, v10, v4}, Lco/vine/android/recorder/InlineVineRecorder$3;-><init>(Lco/vine/android/recorder/InlineVineRecorder;Landroid/widget/RelativeLayout$LayoutParams;Landroid/widget/RelativeLayout$LayoutParams;)V

    invoke-virtual {v11, v12}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 159
    .end local v1    # "aspectRatio":F
    .end local v2    # "bottomMaskHeightPx":I
    .end local v3    # "cameraViewHeight":I
    .end local v4    # "cameraViewParams":Landroid/widget/RelativeLayout$LayoutParams;
    .end local v5    # "cameraViewWidth":I
    .end local v6    # "previewHeight":F
    .end local v7    # "previewWidth":F
    .end local v8    # "rootHeight":I
    .end local v9    # "topMaskHeight":I
    .end local v10    # "topMaskParams":Landroid/widget/RelativeLayout$LayoutParams;
    :cond_0
    return-void
.end method

.method public cancelStartCallback()V
    .locals 2

    .prologue
    .line 47
    iget-object v0, p0, Lco/vine/android/recorder/InlineVineRecorder;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/recorder/InlineVineRecorder;->mStartRelativeTimeRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 48
    return-void
.end method

.method public getFinishProcessTask(Ljava/lang/String;Ljava/lang/Runnable;ZZ)Lco/vine/android/recorder/BaseFinishProcessTask;
    .locals 6
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "onComplete"    # Ljava/lang/Runnable;
    .param p3, "releasePreview"    # Z
    .param p4, "saveSession"    # Z

    .prologue
    .line 168
    new-instance v0, Lco/vine/android/recorder/InlineVineRecorder$InlineFinishProcessTask;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lco/vine/android/recorder/InlineVineRecorder$InlineFinishProcessTask;-><init>(Lco/vine/android/recorder/InlineVineRecorder;Ljava/lang/String;Ljava/lang/Runnable;ZZ)V

    return-object v0
.end method

.method public getOnResumeTask(Landroid/view/View;Ljava/lang/String;)Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "tag"    # Ljava/lang/String;

    .prologue
    .line 104
    new-instance v0, Lco/vine/android/recorder/InlineVineRecorder$2;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1, p2}, Lco/vine/android/recorder/InlineVineRecorder$2;-><init>(Lco/vine/android/recorder/InlineVineRecorder;Landroid/view/View;Ljava/lang/String;)V

    return-object v0
.end method

.method public onProgressMaxReached()V
    .locals 1

    .prologue
    .line 163
    const-string v0, "progressMaxReached"

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/InlineVineRecorder;->finish(Ljava/lang/String;)V

    .line 164
    return-void
.end method

.method protected onStop()Z
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 172
    iget-boolean v2, p0, Lco/vine/android/recorder/InlineVineRecorder;->mStopping:Z

    if-nez v2, :cond_0

    move v0, v1

    .line 173
    .local v0, "result":Z
    :goto_0
    iput-boolean v1, p0, Lco/vine/android/recorder/InlineVineRecorder;->mStopping:Z

    .line 174
    return v0

    .line 172
    .end local v0    # "result":Z
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onUiPaused()V
    .locals 1

    .prologue
    .line 98
    invoke-super {p0}, Lco/vine/android/recorder/RegularVineRecorder;->onUiPaused()V

    .line 99
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/recorder/InlineVineRecorder;->mStopping:Z

    .line 100
    return-void
.end method

.method public onUiResumed(Landroid/app/Activity;Ljava/lang/Runnable;Z)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "onCompleteAsyncTask"    # Ljava/lang/Runnable;
    .param p3, "doNotResumeRecorder"    # Z

    .prologue
    .line 89
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/recorder/RegularVineRecorder;->onUiResumed(Landroid/app/Activity;Ljava/lang/Runnable;Z)V

    .line 90
    iget v0, p0, Lco/vine/android/recorder/InlineVineRecorder;->mFinishProgressViewResourceId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/recorder/ProgressView;

    iput-object v0, p0, Lco/vine/android/recorder/InlineVineRecorder;->mFinishProgressView:Lco/vine/android/recorder/ProgressView;

    .line 91
    if-nez p3, :cond_0

    .line 92
    const-string v0, "UI Resume"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lco/vine/android/recorder/InlineVineRecorder;->onResume(Ljava/lang/String;Z)V

    .line 94
    :cond_0
    return-void
.end method

.method public openCamera()V
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 81
    :try_start_0
    iget-object v2, p0, Lco/vine/android/recorder/InlineVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lco/vine/android/recorder/InlineVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    iget-boolean v3, p0, Lco/vine/android/recorder/InlineVineRecorder;->mFrontFacing:Z

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Lco/vine/android/recorder/RecordController;->openDefaultCamera(ZZ)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lco/vine/android/recorder/InlineVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordController;->isCameraReady()Z

    move-result v2

    if-eqz v2, :cond_1

    :cond_0
    const/4 v1, 0x1

    :cond_1
    iput-boolean v1, p0, Lco/vine/android/recorder/InlineVineRecorder;->mCameraSuccessfullyOpened:Z
    :try_end_0
    .catch Lco/vine/android/VineNotSupportedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 85
    :goto_0
    return-void

    .line 82
    :catch_0
    move-exception v0

    .line 83
    .local v0, "e":Lco/vine/android/VineNotSupportedException;
    invoke-virtual {p0, v0}, Lco/vine/android/recorder/InlineVineRecorder;->onDeviceNotSupported(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public receivedFirstFrameAfterStartingPreview()V
    .locals 7

    .prologue
    .line 219
    iget-boolean v2, p0, Lco/vine/android/recorder/InlineVineRecorder;->mStarted:Z

    if-eqz v2, :cond_0

    iget-object v2, p0, Lco/vine/android/recorder/InlineVineRecorder;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    if-nez v2, :cond_0

    .line 220
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    .line 221
    .local v0, "endnannos":J
    const-string v2, "inline launch time: {}ms"

    sget-wide v3, Lco/vine/android/recorder/InlineVineRecorder;->startnanos:J

    sub-long v3, v0, v3

    const-wide/32 v5, 0xf4240

    div-long/2addr v3, v5

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;)V

    .line 222
    sput-wide v0, Lco/vine/android/recorder/InlineVineRecorder;->startnanos:J

    .line 223
    const/4 v2, 0x0

    iput-boolean v2, p0, Lco/vine/android/recorder/InlineVineRecorder;->mStarted:Z

    .line 224
    iget-object v2, p0, Lco/vine/android/recorder/InlineVineRecorder;->mHandler:Landroid/os/Handler;

    iget-object v3, p0, Lco/vine/android/recorder/InlineVineRecorder;->mStartRelativeTimeRunnable:Ljava/lang/Runnable;

    sget-wide v4, Lco/vine/android/recorder/InlineVineRecorder;->DELAY_WAIT_FOR_EXPOSURE:J

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 226
    .end local v0    # "endnannos":J
    :cond_0
    return-void
.end method

.method public setStarted(Z)V
    .locals 0
    .param p1, "started"    # Z

    .prologue
    .line 43
    iput-boolean p1, p0, Lco/vine/android/recorder/InlineVineRecorder;->mStarted:Z

    .line 44
    return-void
.end method

.method public stopRecording(Z)V
    .locals 2
    .param p1, "cancel"    # Z

    .prologue
    const/4 v1, 0x1

    .line 70
    invoke-virtual {p0}, Lco/vine/android/recorder/InlineVineRecorder;->cancelStartCallback()V

    .line 71
    iget-object v0, p0, Lco/vine/android/recorder/InlineVineRecorder;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    if-eqz v0, :cond_0

    .line 72
    invoke-virtual {p0}, Lco/vine/android/recorder/InlineVineRecorder;->endRelativeTime()Z

    .line 74
    :cond_0
    if-eqz p1, :cond_1

    iget-object v0, p0, Lco/vine/android/recorder/InlineVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    if-eqz v0, :cond_1

    .line 75
    iget-object v0, p0, Lco/vine/android/recorder/InlineVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0, v1, v1}, Lco/vine/android/recorder/RecordController;->stop(ZZ)Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    .line 77
    :cond_1
    return-void
.end method
