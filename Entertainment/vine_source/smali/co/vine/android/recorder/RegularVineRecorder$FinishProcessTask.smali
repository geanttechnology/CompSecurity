.class public Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;
.super Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;
.source "RegularVineRecorder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/RegularVineRecorder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "FinishProcessTask"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/RegularVineRecorder;


# direct methods
.method public constructor <init>(Lco/vine/android/recorder/RegularVineRecorder;Ljava/lang/String;Ljava/lang/Runnable;ZZ)V
    .locals 0
    .param p2, "tag"    # Ljava/lang/String;
    .param p3, "onComplete"    # Ljava/lang/Runnable;
    .param p4, "releasePreview"    # Z
    .param p5, "saveSession"    # Z

    .prologue
    .line 263
    iput-object p1, p0, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    .line 264
    invoke-direct/range {p0 .. p5}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;-><init>(Lco/vine/android/recorder/BasicVineRecorder;Ljava/lang/String;Ljava/lang/Runnable;ZZ)V

    .line 265
    return-void
.end method


# virtual methods
.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 261
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 3
    .param p1, "aVoid"    # Ljava/lang/Void;

    .prologue
    .line 269
    invoke-super {p0, p1}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;->onPostExecute(Ljava/lang/Void;)V

    .line 270
    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    const/4 v2, 0x0

    # setter for: Lco/vine/android/recorder/RegularVineRecorder;->mIsHidingFinishProgressDialog:Z
    invoke-static {v1, v2}, Lco/vine/android/recorder/RegularVineRecorder;->access$002(Lco/vine/android/recorder/RegularVineRecorder;Z)Z

    .line 271
    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v1, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialog:Landroid/app/ProgressDialog;

    .line 272
    .local v0, "dialog":Landroid/app/ProgressDialog;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 273
    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 275
    :cond_0
    return-void
.end method

.method protected varargs onProgressUpdate([Ljava/lang/Integer;)V
    .locals 5
    .param p1, "values"    # [Ljava/lang/Integer;

    .prologue
    const/4 v4, 0x0

    .line 279
    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v1, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialog:Landroid/app/ProgressDialog;

    .line 280
    .local v0, "dialog":Landroid/app/ProgressDialog;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 281
    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v1, v1, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialogMessage:[Ljava/lang/CharSequence;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v1, v1, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialogMessage:[Ljava/lang/CharSequence;

    array-length v1, v1

    const/4 v2, 0x2

    if-le v1, v2, :cond_1

    .line 282
    aget-object v1, p1, v4

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    const/16 v2, 0x64

    iget-object v3, p0, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v3, v3, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialogMessage:[Ljava/lang/CharSequence;

    array-length v3, v3

    add-int/lit8 v3, v3, -0x1

    div-int/2addr v2, v3

    iget v3, p0, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->mCurrentMessage:I

    mul-int/2addr v2, v3

    if-lt v1, v2, :cond_1

    .line 283
    iget v1, p0, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->mCurrentMessage:I

    add-int/lit8 v1, v1, 0x1

    iget-object v2, p0, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v2, v2, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialogMessage:[Ljava/lang/CharSequence;

    array-length v2, v2

    if-ge v1, v2, :cond_0

    .line 284
    iget-object v1, p0, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v1, v1, Lco/vine/android/recorder/RegularVineRecorder;->mFinishProgressDialogMessage:[Ljava/lang/CharSequence;

    iget v2, p0, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->mCurrentMessage:I

    add-int/lit8 v2, v2, 0x1

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 286
    :cond_0
    iget v1, p0, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->mCurrentMessage:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->mCurrentMessage:I

    .line 289
    :cond_1
    aget-object v1, p1, v4

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 291
    :cond_2
    return-void
.end method

.method protected bridge synthetic onProgressUpdate([Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 261
    check-cast p1, [Ljava/lang/Integer;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->onProgressUpdate([Ljava/lang/Integer;)V

    return-void
.end method
