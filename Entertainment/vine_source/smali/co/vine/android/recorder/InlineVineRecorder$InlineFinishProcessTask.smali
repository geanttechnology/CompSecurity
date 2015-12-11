.class public Lco/vine/android/recorder/InlineVineRecorder$InlineFinishProcessTask;
.super Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;
.source "InlineVineRecorder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/InlineVineRecorder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "InlineFinishProcessTask"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/InlineVineRecorder;


# direct methods
.method public constructor <init>(Lco/vine/android/recorder/InlineVineRecorder;Ljava/lang/String;Ljava/lang/Runnable;ZZ)V
    .locals 0
    .param p2, "tag"    # Ljava/lang/String;
    .param p3, "onComplete"    # Ljava/lang/Runnable;
    .param p4, "releasePreview"    # Z
    .param p5, "saveSession"    # Z

    .prologue
    .line 180
    iput-object p1, p0, Lco/vine/android/recorder/InlineVineRecorder$InlineFinishProcessTask;->this$0:Lco/vine/android/recorder/InlineVineRecorder;

    .line 181
    invoke-direct/range {p0 .. p5}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;-><init>(Lco/vine/android/recorder/BasicVineRecorder;Ljava/lang/String;Ljava/lang/Runnable;ZZ)V

    .line 182
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 178
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/InlineVineRecorder$InlineFinishProcessTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 1
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 192
    const-string v0, "Finishing Inline"

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 193
    invoke-super {p0, p1}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 178
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/InlineVineRecorder$InlineFinishProcessTask;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 2
    .param p1, "aVoid"    # Ljava/lang/Void;

    .prologue
    .line 198
    invoke-super {p0, p1}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;->onPostExecute(Ljava/lang/Void;)V

    .line 199
    const-string v0, "Finishing Inline postExec"

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 200
    iget-object v0, p0, Lco/vine/android/recorder/InlineVineRecorder$InlineFinishProcessTask;->this$0:Lco/vine/android/recorder/InlineVineRecorder;

    # getter for: Lco/vine/android/recorder/InlineVineRecorder;->mProcessingListener:Lco/vine/android/recorder/InlineVineRecorder$ProcessingListener;
    invoke-static {v0}, Lco/vine/android/recorder/InlineVineRecorder;->access$100(Lco/vine/android/recorder/InlineVineRecorder;)Lco/vine/android/recorder/InlineVineRecorder$ProcessingListener;

    move-result-object v0

    invoke-interface {v0}, Lco/vine/android/recorder/InlineVineRecorder$ProcessingListener;->onProcessingFinish()V

    .line 201
    iget-object v0, p0, Lco/vine/android/recorder/InlineVineRecorder$InlineFinishProcessTask;->this$0:Lco/vine/android/recorder/InlineVineRecorder;

    const/4 v1, 0x0

    # setter for: Lco/vine/android/recorder/InlineVineRecorder;->mStopping:Z
    invoke-static {v0, v1}, Lco/vine/android/recorder/InlineVineRecorder;->access$202(Lco/vine/android/recorder/InlineVineRecorder;Z)Z

    .line 202
    return-void
.end method

.method protected onPreExecute()V
    .locals 1

    .prologue
    .line 185
    invoke-super {p0}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;->onPreExecute()V

    .line 186
    const-string v0, "Finishing Inline preExec"

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 187
    iget-object v0, p0, Lco/vine/android/recorder/InlineVineRecorder$InlineFinishProcessTask;->this$0:Lco/vine/android/recorder/InlineVineRecorder;

    # getter for: Lco/vine/android/recorder/InlineVineRecorder;->mProcessingListener:Lco/vine/android/recorder/InlineVineRecorder$ProcessingListener;
    invoke-static {v0}, Lco/vine/android/recorder/InlineVineRecorder;->access$100(Lco/vine/android/recorder/InlineVineRecorder;)Lco/vine/android/recorder/InlineVineRecorder$ProcessingListener;

    move-result-object v0

    invoke-interface {v0}, Lco/vine/android/recorder/InlineVineRecorder$ProcessingListener;->onProcessingStart()V

    .line 188
    return-void
.end method

.method protected varargs onProgressUpdate([Ljava/lang/Integer;)V
    .locals 3
    .param p1, "values"    # [Ljava/lang/Integer;

    .prologue
    .line 206
    iget-object v0, p0, Lco/vine/android/recorder/InlineVineRecorder$InlineFinishProcessTask;->this$0:Lco/vine/android/recorder/InlineVineRecorder;

    # getter for: Lco/vine/android/recorder/InlineVineRecorder;->mFinishProgressView:Lco/vine/android/recorder/ProgressView;
    invoke-static {v0}, Lco/vine/android/recorder/InlineVineRecorder;->access$300(Lco/vine/android/recorder/InlineVineRecorder;)Lco/vine/android/recorder/ProgressView;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 207
    iget-object v0, p0, Lco/vine/android/recorder/InlineVineRecorder$InlineFinishProcessTask;->this$0:Lco/vine/android/recorder/InlineVineRecorder;

    # getter for: Lco/vine/android/recorder/InlineVineRecorder;->mFinishProgressView:Lco/vine/android/recorder/ProgressView;
    invoke-static {v0}, Lco/vine/android/recorder/InlineVineRecorder;->access$300(Lco/vine/android/recorder/InlineVineRecorder;)Lco/vine/android/recorder/ProgressView;

    move-result-object v0

    const/4 v1, 0x0

    aget-object v1, p1, v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    int-to-float v1, v1

    const/high16 v2, 0x42c80000    # 100.0f

    div-float/2addr v1, v2

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/ProgressView;->setProgressRatio(F)V

    .line 209
    :cond_0
    return-void
.end method

.method protected bridge synthetic onProgressUpdate([Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 178
    check-cast p1, [Ljava/lang/Integer;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/InlineVineRecorder$InlineFinishProcessTask;->onProgressUpdate([Ljava/lang/Integer;)V

    return-void
.end method
