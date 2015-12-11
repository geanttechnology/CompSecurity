.class public Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;
.super Landroid/os/AsyncTask;
.source "BasicVineRecorder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/BasicVineRecorder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "ResumeCameraAsyncTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field private final mSwitchCamera:Z

.field final synthetic this$0:Lco/vine/android/recorder/BasicVineRecorder;


# direct methods
.method public constructor <init>(Lco/vine/android/recorder/BasicVineRecorder;Z)V
    .locals 0
    .param p2, "switchCamera"    # Z

    .prologue
    .line 272
    iput-object p1, p0, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 273
    iput-boolean p2, p0, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->mSwitchCamera:Z

    .line 274
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 268
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 6
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 278
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v4}, Lco/vine/android/recorder/BasicVineRecorder;->canSwitchCamera()Z

    move-result v4

    if-nez v4, :cond_0

    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v4, v4, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v4}, Lco/vine/android/recorder/RecordController;->isRecording()Z

    move-result v4

    if-nez v4, :cond_3

    iget-boolean v4, p0, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->mSwitchCamera:Z

    if-nez v4, :cond_3

    .line 280
    :cond_0
    :try_start_0
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 281
    iget-boolean v4, p0, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->mSwitchCamera:Z

    if-eqz v4, :cond_1

    .line 282
    iget-object v4, p0, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v5, p0, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-boolean v5, v5, Lco/vine/android/recorder/BasicVineRecorder;->mFrontFacing:Z

    if-nez v5, :cond_4

    :goto_0
    iput-boolean v2, v4, Lco/vine/android/recorder/BasicVineRecorder;->mFrontFacing:Z

    .line 284
    :cond_1
    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v2, v2, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    iget-object v3, p0, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-boolean v3, v3, Lco/vine/android/recorder/BasicVineRecorder;->mFrontFacing:Z

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v4}, Lco/vine/android/recorder/RecordController;->openDefaultCamera(ZZ)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 285
    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v2, v2, Lco/vine/android/recorder/BasicVineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordController;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v1

    .line 286
    .local v1, "setting":Lco/vine/android/recorder/CameraSetting;
    if-eqz v1, :cond_2

    .line 287
    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget v3, v1, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    iput v3, v2, Lco/vine/android/recorder/BasicVineRecorder;->mCurrentFrameRate:I

    .line 289
    :cond_2
    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    const-string v3, "Switch camera"

    const/4 v4, 0x0

    const/4 v5, 0x1

    invoke-virtual {v2, v3, v4, v5}, Lco/vine/android/recorder/BasicVineRecorder;->start(Ljava/lang/String;ZZ)V

    .line 298
    .end local v1    # "setting":Lco/vine/android/recorder/CameraSetting;
    :cond_3
    :goto_1
    const/4 v2, 0x0

    return-object v2

    :cond_4
    move v2, v3

    .line 282
    goto :goto_0

    .line 291
    :cond_5
    iget-object v2, p0, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v2}, Lco/vine/android/recorder/BasicVineRecorder;->showCameraFailedToast()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 293
    :catch_0
    move-exception v0

    .line 295
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Error on cancel camera switching."

    invoke-static {v2, v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 268
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 2
    .param p1, "aVoid"    # Ljava/lang/Void;

    .prologue
    .line 308
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lco/vine/android/recorder/BasicVineRecorder;->mIsSwitchingCamera:Z

    .line 309
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 303
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lco/vine/android/recorder/BasicVineRecorder;->mIsSwitchingCamera:Z

    .line 304
    return-void
.end method
