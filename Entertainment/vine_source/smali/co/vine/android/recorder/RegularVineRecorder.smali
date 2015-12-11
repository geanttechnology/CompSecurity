.class public abstract Lco/vine/android/recorder/RegularVineRecorder;
.super Lco/vine/android/recorder/BasicVineRecorder;
.source "RegularVineRecorder.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;,
        Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;,
        Lco/vine/android/recorder/RegularVineRecorder$ResumeCameraAsyncTask;
    }
.end annotation


# static fields
.field private static final PREF_BOTTOM_MASK_HEIGHT:Ljava/lang/String; = "bottomMaskHeightPx"

.field protected static final TOUCH_EDGE_BOUNDARY:F = 0.05f


# instance fields
.field public density:F

.field protected mBottomMaskId:I

.field protected mBottomMaskView:Landroid/view/View;

.field protected mCameraFailString:I

.field protected mCameraViewResourceId:I

.field protected mDeviceNotSupportedString:Ljava/lang/String;

.field protected mFinishLastSegmentString:Ljava/lang/CharSequence;

.field protected mFinishProgressDialog:Landroid/app/ProgressDialog;

.field protected mFinishProgressDialogMessage:[Ljava/lang/CharSequence;

.field private mIsHidingFinishProgressDialog:Z

.field protected mOpenCameraDialog:Landroid/app/ProgressDialog;

.field protected mOpenCameraResource:Ljava/lang/CharSequence;

.field protected mProgressView:Lco/vine/android/recorder/ProgressView;

.field protected mProgressViewResourceId:I

.field protected mRootLayoutId:I

.field protected mRootLayoutView:Landroid/view/View;

.field protected mSize:Landroid/graphics/Point;

.field protected mStartProgressDialog:Landroid/app/ProgressDialog;

.field protected mStartProgressDialogMessage:Ljava/lang/CharSequence;

.field protected mToast:Landroid/widget/Toast;

.field protected mTopMaskId:I

.field protected mTopMaskView:Landroid/view/View;


# direct methods
.method public varargs constructor <init>(ILandroid/graphics/Point;Landroid/app/Activity;IIIIIIILjava/lang/String;ZLco/vine/android/recorder/RecordSessionVersion;[Ljava/lang/CharSequence;)V
    .locals 7
    .param p1, "thresholdMs"    # I
    .param p2, "screenSize"    # Landroid/graphics/Point;
    .param p3, "activity"    # Landroid/app/Activity;
    .param p4, "progressViewResourceId"    # I
    .param p5, "cameraViewResourceId"    # I
    .param p6, "topMaskId"    # I
    .param p7, "bottomMaskId"    # I
    .param p8, "cameraFailString"    # I
    .param p9, "openCameraString"    # I
    .param p10, "rootLayoutId"    # I
    .param p11, "deviceNotSupportedString"    # Ljava/lang/String;
    .param p12, "startWithFrontFacingCamera"    # Z
    .param p13, "version"    # Lco/vine/android/recorder/RecordSessionVersion;
    .param p14, "messages"    # [Ljava/lang/CharSequence;

    .prologue
    .line 58
    sget-object v1, Lco/vine/android/recorder/RecordSessionVersion;->HW:Lco/vine/android/recorder/RecordSessionVersion;

    move-object/from16 v0, p13

    if-ne v0, v1, :cond_0

    const/4 v5, 0x1

    :goto_0
    sget-object v1, Lco/vine/android/recorder/RecordSessionVersion;->SW_WEBM:Lco/vine/android/recorder/RecordSessionVersion;

    move-object/from16 v0, p13

    if-eq v0, v1, :cond_1

    const/4 v6, 0x1

    :goto_1
    move-object v1, p0

    move v2, p1

    move-object v3, p3

    move/from16 v4, p12

    invoke-direct/range {v1 .. v6}, Lco/vine/android/recorder/BasicVineRecorder;-><init>(ILandroid/app/Activity;ZZZ)V

    .line 60
    const/4 v1, 0x0

    aget-object v1, p14, v1

    iput-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder;->mStartProgressDialogMessage:Ljava/lang/CharSequence;

    .line 61
    move-object/from16 v0, p14

    iput-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialogMessage:[Ljava/lang/CharSequence;

    .line 62
    move/from16 v0, p9

    invoke-virtual {p3, v0}, Landroid/app/Activity;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder;->mOpenCameraResource:Ljava/lang/CharSequence;

    .line 63
    iput-object p2, p0, Lco/vine/android/recorder/RegularVineRecorder;->mSize:Landroid/graphics/Point;

    .line 64
    invoke-virtual {p3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->density:F

    iput v1, p0, Lco/vine/android/recorder/RegularVineRecorder;->density:F

    .line 65
    iput p4, p0, Lco/vine/android/recorder/RegularVineRecorder;->mProgressViewResourceId:I

    .line 66
    iput p5, p0, Lco/vine/android/recorder/RegularVineRecorder;->mCameraViewResourceId:I

    .line 67
    move/from16 v0, p10

    iput v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mRootLayoutId:I

    .line 68
    iput p8, p0, Lco/vine/android/recorder/RegularVineRecorder;->mCameraFailString:I

    .line 69
    move-object/from16 v0, p11

    iput-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mDeviceNotSupportedString:Ljava/lang/String;

    .line 70
    iput p6, p0, Lco/vine/android/recorder/RegularVineRecorder;->mTopMaskId:I

    .line 71
    iput p7, p0, Lco/vine/android/recorder/RegularVineRecorder;->mBottomMaskId:I

    .line 72
    return-void

    .line 58
    :cond_0
    const/4 v5, 0x0

    goto :goto_0

    :cond_1
    const/4 v6, 0x0

    goto :goto_1
.end method

.method static synthetic access$002(Lco/vine/android/recorder/RegularVineRecorder;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/RegularVineRecorder;
    .param p1, "x1"    # Z

    .prologue
    .line 18
    iput-boolean p1, p0, Lco/vine/android/recorder/RegularVineRecorder;->mIsHidingFinishProgressDialog:Z

    return p1
.end method

.method public static getBottomMaskHeightPref(Z)Ljava/lang/String;
    .locals 2
    .param p0, "frontFacing"    # Z

    .prologue
    .line 170
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "bottomMaskHeightPx"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public changeProgress(J)V
    .locals 4
    .param p1, "progress"    # J

    .prologue
    .line 158
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mProgressView:Lco/vine/android/recorder/ProgressView;

    .line 159
    .local v0, "view":Lco/vine/android/recorder/ProgressView;
    if-eqz v0, :cond_0

    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder;->mSession:Lco/vine/android/recorder/RecordSession;

    if-eqz v1, :cond_0

    .line 160
    long-to-float v1, p1

    const/high16 v2, 0x3f800000    # 1.0f

    iget-object v3, p0, Lco/vine/android/recorder/RegularVineRecorder;->mSession:Lco/vine/android/recorder/RecordSession;

    invoke-virtual {v3}, Lco/vine/android/recorder/RecordSession;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v3

    iget v3, v3, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->maxDuration:I

    int-to-float v3, v3

    mul-float/2addr v2, v3

    div-float/2addr v1, v2

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/ProgressView;->setProgressRatio(F)V

    .line 161
    invoke-static {}, Lco/vine/android/util/SystemUtil;->isOnMainThread()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 162
    invoke-virtual {v0}, Lco/vine/android/recorder/ProgressView;->invalidate()V

    .line 167
    :cond_0
    :goto_0
    return-void

    .line 164
    :cond_1
    invoke-virtual {v0}, Lco/vine/android/recorder/ProgressView;->postInvalidate()V

    goto :goto_0
.end method

.method public getFinishProcessTask(Ljava/lang/String;Ljava/lang/Runnable;ZZ)Lco/vine/android/recorder/BaseFinishProcessTask;
    .locals 6
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "onComplete"    # Ljava/lang/Runnable;
    .param p3, "releasePreview"    # Z
    .param p4, "saveSession"    # Z

    .prologue
    .line 258
    new-instance v0, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;-><init>(Lco/vine/android/recorder/RegularVineRecorder;Ljava/lang/String;Ljava/lang/Runnable;ZZ)V

    return-object v0
.end method

.method protected getOnDeviceNotSupportedAction()Ljava/lang/Runnable;
    .locals 1

    .prologue
    .line 296
    new-instance v0, Lco/vine/android/recorder/RegularVineRecorder$3;

    invoke-direct {v0, p0}, Lco/vine/android/recorder/RegularVineRecorder$3;-><init>(Lco/vine/android/recorder/RegularVineRecorder;)V

    return-object v0
.end method

.method public getOnResumeTask(Landroid/view/View;Ljava/lang/String;)Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "tag"    # Ljava/lang/String;

    .prologue
    .line 348
    new-instance v0, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;

    invoke-direct {v0, p0, p1, p2}, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;-><init>(Lco/vine/android/recorder/RegularVineRecorder;Landroid/view/View;Ljava/lang/String;)V

    return-object v0
.end method

.method public getSize()Landroid/graphics/Point;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mSize:Landroid/graphics/Point;

    return-object v0
.end method

.method protected onStop()Z
    .locals 4

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 231
    iget-boolean v3, p0, Lco/vine/android/recorder/RegularVineRecorder;->mFastEncoding:Z

    if-eqz v3, :cond_1

    .line 232
    iget-boolean v3, p0, Lco/vine/android/recorder/RegularVineRecorder;->mIsHidingFinishProgressDialog:Z

    if-nez v3, :cond_0

    .line 233
    iput-boolean v1, p0, Lco/vine/android/recorder/RegularVineRecorder;->mIsHidingFinishProgressDialog:Z

    .line 251
    :goto_0
    return v1

    .line 236
    :cond_0
    const-string v1, "Stop twice? wtf."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    move v1, v2

    .line 237
    goto :goto_0

    .line 240
    :cond_1
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialog:Landroid/app/ProgressDialog;

    .line 241
    .local v0, "dialog":Landroid/app/ProgressDialog;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v3

    if-nez v3, :cond_2

    .line 242
    iget-object v2, p0, Lco/vine/android/recorder/RegularVineRecorder;->mActivity:Landroid/app/Activity;

    new-instance v3, Lco/vine/android/recorder/RegularVineRecorder$2;

    invoke-direct {v3, p0, v0}, Lco/vine/android/recorder/RegularVineRecorder$2;-><init>(Lco/vine/android/recorder/RegularVineRecorder;Landroid/app/ProgressDialog;)V

    invoke-virtual {v2, v3}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 250
    :cond_2
    const-string v1, "Stop twice? wtf."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    move v1, v2

    .line 251
    goto :goto_0
.end method

.method public declared-synchronized onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 5
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 175
    monitor-enter p0

    :try_start_0
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 176
    .local v0, "action":I
    iget-object v4, p0, Lco/vine/android/recorder/RegularVineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    if-eqz v4, :cond_2

    iget-boolean v4, p0, Lco/vine/android/recorder/RegularVineRecorder;->mEnabled:Z

    if-eqz v4, :cond_2

    .line 177
    iget-boolean v3, p0, Lco/vine/android/recorder/RegularVineRecorder;->mAutoFocusing:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v3, :cond_1

    .line 178
    packed-switch v0, :pswitch_data_0

    .line 200
    :cond_0
    :goto_0
    monitor-exit p0

    return v2

    .line 181
    :pswitch_0
    const/4 v3, 0x0

    :try_start_1
    invoke-virtual {p2, v3}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v1

    .line 182
    .local v1, "axisX":F
    const v3, 0x3d4ccccd    # 0.05f

    iget-object v4, p0, Lco/vine/android/recorder/RegularVineRecorder;->mSize:Landroid/graphics/Point;

    iget v4, v4, Landroid/graphics/Point;->x:I

    int-to-float v4, v4

    mul-float/2addr v3, v4

    cmpl-float v3, v1, v3

    if-lez v3, :cond_0

    const v3, 0x3f733333    # 0.95f

    iget-object v4, p0, Lco/vine/android/recorder/RegularVineRecorder;->mSize:Landroid/graphics/Point;

    iget v4, v4, Landroid/graphics/Point;->x:I

    int-to-float v4, v4

    mul-float/2addr v3, v4

    cmpg-float v3, v1, v3

    if-gez v3, :cond_0

    .line 184
    invoke-virtual {p0}, Lco/vine/android/recorder/RegularVineRecorder;->startRelativeTime()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 175
    .end local v0    # "action":I
    .end local v1    # "axisX":F
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 188
    .restart local v0    # "action":I
    :pswitch_1
    :try_start_2
    invoke-virtual {p0}, Lco/vine/android/recorder/RegularVineRecorder;->endRelativeTime()Z

    goto :goto_0

    .line 192
    :cond_1
    packed-switch v0, :pswitch_data_1

    goto :goto_0

    .line 194
    :pswitch_2
    const/4 v3, 0x0

    invoke-virtual {p2, v3}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v3

    const/4 v4, 0x1

    invoke-virtual {p2, v4}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v4

    invoke-virtual {p0, v3, v4}, Lco/vine/android/recorder/RegularVineRecorder;->changeFocusTo(FF)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    :cond_2
    move v2, v3

    .line 200
    goto :goto_0

    .line 178
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch

    .line 192
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_2
    .end packed-switch
.end method

.method public onUiPaused()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 204
    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder;->mCameraView:Landroid/view/View;

    if-eqz v1, :cond_0

    .line 205
    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder;->mCameraView:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 208
    :cond_0
    :try_start_0
    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialog:Landroid/app/ProgressDialog;

    if-eqz v1, :cond_1

    .line 209
    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v1}, Landroid/app/ProgressDialog;->dismiss()V

    .line 211
    :cond_1
    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder;->mStartProgressDialog:Landroid/app/ProgressDialog;

    if-eqz v1, :cond_2

    .line 212
    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder;->mStartProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v1}, Landroid/app/ProgressDialog;->dismiss()V

    .line 214
    :cond_2
    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder;->mOpenCameraDialog:Landroid/app/ProgressDialog;

    if-eqz v1, :cond_3

    .line 215
    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder;->mOpenCameraDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v1}, Landroid/app/ProgressDialog;->dismiss()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 220
    :cond_3
    :goto_0
    iput-object v2, p0, Lco/vine/android/recorder/RegularVineRecorder;->mStartProgressDialog:Landroid/app/ProgressDialog;

    .line 221
    iput-object v2, p0, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialog:Landroid/app/ProgressDialog;

    .line 222
    iput-object v2, p0, Lco/vine/android/recorder/RegularVineRecorder;->mOpenCameraDialog:Landroid/app/ProgressDialog;

    .line 223
    iput-object v2, p0, Lco/vine/android/recorder/RegularVineRecorder;->mTopMaskView:Landroid/view/View;

    .line 224
    iput-object v2, p0, Lco/vine/android/recorder/RegularVineRecorder;->mBottomMaskView:Landroid/view/View;

    .line 225
    iput-object v2, p0, Lco/vine/android/recorder/RegularVineRecorder;->mProgressView:Lco/vine/android/recorder/ProgressView;

    .line 226
    iput-object v2, p0, Lco/vine/android/recorder/RegularVineRecorder;->mToast:Landroid/widget/Toast;

    .line 227
    invoke-super {p0}, Lco/vine/android/recorder/BasicVineRecorder;->onUiPaused()V

    .line 228
    return-void

    .line 217
    :catch_0
    move-exception v0

    .line 218
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "It\'s probably detached already."

    invoke-static {v1, v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onUiResumed(Landroid/app/Activity;Ljava/lang/Runnable;Z)V
    .locals 6
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "onCompleteAsyncTask"    # Ljava/lang/Runnable;
    .param p3, "doNotResumeRecorder"    # Z
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "ShowToast"
        }
    .end annotation

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 322
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/recorder/BasicVineRecorder;->onUiResumed(Landroid/app/Activity;Ljava/lang/Runnable;Z)V

    .line 323
    new-instance v0, Landroid/app/ProgressDialog;

    invoke-direct {v0, p1, v5}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    iput-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialog:Landroid/app/ProgressDialog;

    .line 324
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialog:Landroid/app/ProgressDialog;

    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialogMessage:[Ljava/lang/CharSequence;

    aget-object v1, v1, v4

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 325
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialog:Landroid/app/ProgressDialog;

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMax(I)V

    .line 326
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0, v3}, Landroid/app/ProgressDialog;->setCancelable(Z)V

    .line 327
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0, v3}, Landroid/app/ProgressDialog;->setIndeterminate(Z)V

    .line 328
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0, v4}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    .line 329
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lco/vine/android/recorder/R$drawable;->progress_horizontal:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setProgressDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 330
    new-instance v0, Landroid/app/ProgressDialog;

    invoke-direct {v0, p1, v5}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    iput-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mStartProgressDialog:Landroid/app/ProgressDialog;

    .line 331
    new-instance v0, Landroid/app/ProgressDialog;

    invoke-direct {v0, p1, v5}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    iput-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mOpenCameraDialog:Landroid/app/ProgressDialog;

    .line 332
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mOpenCameraDialog:Landroid/app/ProgressDialog;

    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder;->mOpenCameraResource:Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 333
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mOpenCameraDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0, v3}, Landroid/app/ProgressDialog;->setCancelable(Z)V

    .line 334
    iget v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mRootLayoutId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mRootLayoutView:Landroid/view/View;

    .line 335
    iget v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mCameraViewResourceId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mCameraView:Landroid/view/View;

    .line 336
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mCameraView:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 337
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mCameraView:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 338
    iget v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mTopMaskId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mTopMaskView:Landroid/view/View;

    .line 339
    iget v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mBottomMaskId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mBottomMaskView:Landroid/view/View;

    .line 340
    iget v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mProgressViewResourceId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/recorder/ProgressView;

    iput-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mProgressView:Lco/vine/android/recorder/ProgressView;

    .line 341
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mCameraView:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 342
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mProgressView:Lco/vine/android/recorder/ProgressView;

    invoke-virtual {v0, v4}, Lco/vine/android/recorder/ProgressView;->setKeepScreenOn(Z)V

    .line 343
    iget v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mCameraFailString:I

    invoke-static {p1, v0, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mToast:Landroid/widget/Toast;

    .line 344
    return-void
.end method

.method protected showCameraFailedToast()V
    .locals 2

    .prologue
    .line 76
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mHandler:Landroid/os/Handler;

    new-instance v1, Lco/vine/android/recorder/RegularVineRecorder$1;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/RegularVineRecorder$1;-><init>(Lco/vine/android/recorder/RegularVineRecorder;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 84
    return-void
.end method

.method public stopAndDiscardChanges(Ljava/lang/String;Ljava/lang/Runnable;Z)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "onComplete"    # Ljava/lang/Runnable;
    .param p3, "releasePreview"    # Z

    .prologue
    .line 313
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/RegularVineRecorder;->setDiscardChanges(Z)V

    .line 314
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProcessRunnable:Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, p3, v1}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->run(Ljava/lang/String;ZZ)V

    .line 315
    if-eqz p2, :cond_0

    .line 316
    invoke-interface {p2}, Ljava/lang/Runnable;->run()V

    .line 318
    :cond_0
    return-void
.end method
