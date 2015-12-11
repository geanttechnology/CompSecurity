.class public Lco/vine/android/recorder/RegularVineRecorder$ResumeCameraAsyncTask;
.super Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;
.source "RegularVineRecorder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/RegularVineRecorder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "ResumeCameraAsyncTask"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/RegularVineRecorder;


# direct methods
.method public constructor <init>(Lco/vine/android/recorder/RegularVineRecorder;Z)V
    .locals 0
    .param p2, "switchCamera"    # Z

    .prologue
    .line 91
    iput-object p1, p0, Lco/vine/android/recorder/RegularVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    .line 92
    invoke-direct {p0, p1, p2}, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;-><init>(Lco/vine/android/recorder/BasicVineRecorder;Z)V

    .line 93
    return-void
.end method


# virtual methods
.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 89
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/RegularVineRecorder$ResumeCameraAsyncTask;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 1
    .param p1, "aVoid"    # Ljava/lang/Void;

    .prologue
    .line 105
    invoke-super {p0, p1}, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->onPostExecute(Ljava/lang/Void;)V

    .line 106
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder;->mOpenCameraDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    .line 107
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder;->mOpenCameraDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 109
    :cond_0
    return-void
.end method

.method protected onPreExecute()V
    .locals 1

    .prologue
    .line 97
    invoke-super {p0}, Lco/vine/android/recorder/BasicVineRecorder$ResumeCameraAsyncTask;->onPreExecute()V

    .line 98
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder;->mOpenCameraDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    .line 99
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder$ResumeCameraAsyncTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder;->mOpenCameraDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 101
    :cond_0
    return-void
.end method
