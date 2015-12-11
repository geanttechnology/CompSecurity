.class public Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;
.super Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;
.source "RegularVineRecorder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/RegularVineRecorder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "OnResumeTask"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/RegularVineRecorder;


# direct methods
.method public constructor <init>(Lco/vine/android/recorder/RegularVineRecorder;Landroid/view/View;Ljava/lang/String;)V
    .locals 0
    .param p2, "view"    # Landroid/view/View;
    .param p3, "tag"    # Ljava/lang/String;

    .prologue
    .line 117
    iput-object p1, p0, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    .line 118
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;-><init>(Lco/vine/android/recorder/BasicVineRecorder;Landroid/view/View;Ljava/lang/String;)V

    .line 119
    return-void
.end method


# virtual methods
.method protected onPostExecute(Lco/vine/android/recorder/RecordingFile;)V
    .locals 1
    .param p1, "needHashTask"    # Lco/vine/android/recorder/RecordingFile;

    .prologue
    .line 145
    invoke-super {p0, p1}, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->onPostExecute(Lco/vine/android/recorder/RecordingFile;)V

    .line 146
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder;->mStartProgressDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 147
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder;->mStartProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 149
    :cond_0
    return-void
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 115
    check-cast p1, Lco/vine/android/recorder/RecordingFile;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;->onPostExecute(Lco/vine/android/recorder/RecordingFile;)V

    return-void
.end method

.method protected varargs onProgressUpdate([Ljava/lang/CharSequence;)V
    .locals 2
    .param p1, "values"    # [Ljava/lang/CharSequence;

    .prologue
    .line 133
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder;->mStartProgressDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_1

    .line 134
    iget-boolean v0, p0, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;->showDialogDelayed:Z

    if-nez v0, :cond_0

    .line 135
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder;->mStartProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-nez v0, :cond_0

    .line 136
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder;->mStartProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 139
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder;->mStartProgressDialog:Landroid/app/ProgressDialog;

    const/4 v1, 0x0

    aget-object v1, p1, v1

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 141
    :cond_1
    return-void
.end method

.method protected bridge synthetic onProgressUpdate([Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 115
    check-cast p1, [Ljava/lang/CharSequence;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;->onProgressUpdate([Ljava/lang/CharSequence;)V

    return-void
.end method

.method protected publishFinishLastSegmentProgress()V
    .locals 3

    .prologue
    .line 123
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/CharSequence;

    const/4 v1, 0x0

    iget-object v2, p0, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v2, v2, Lco/vine/android/recorder/RegularVineRecorder;->mFinishLastSegmentString:Ljava/lang/CharSequence;

    aput-object v2, v0, v1

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;->publishProgress([Ljava/lang/Object;)V

    .line 124
    return-void
.end method

.method protected publishStartProgres()V
    .locals 3

    .prologue
    .line 128
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/CharSequence;

    const/4 v1, 0x0

    iget-object v2, p0, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v2, v2, Lco/vine/android/recorder/RegularVineRecorder;->mStartProgressDialogMessage:Ljava/lang/CharSequence;

    aput-object v2, v0, v1

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;->publishProgress([Ljava/lang/Object;)V

    .line 129
    return-void
.end method
