.class Lco/vine/android/recorder/VineRecorder$5;
.super Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;
.source "VineRecorder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/recorder/VineRecorder;->getFinishProcessRunnable()Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/VineRecorder;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/VineRecorder;)V
    .locals 0

    .prologue
    .line 306
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder$5;->this$0:Lco/vine/android/recorder/VineRecorder;

    invoke-direct {p0, p1}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;-><init>(Lco/vine/android/recorder/BasicVineRecorder;)V

    return-void
.end method


# virtual methods
.method public doNotDeleteSession(Z)Z
    .locals 1
    .param p1, "isFinishing"    # Z

    .prologue
    .line 310
    if-nez p1, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$5;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mInitiallyStartedWithEditMode:Z
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$1000(Lco/vine/android/recorder/VineRecorder;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isCompleteSession(Z)Z
    .locals 1
    .param p1, "wasRecordingStarted"    # Z

    .prologue
    .line 315
    if-nez p1, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$5;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mInitiallyStartedWithEditMode:Z
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$1000(Lco/vine/android/recorder/VineRecorder;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected onPreCompleteSession(Z)V
    .locals 4
    .param p1, "wasRecordingStarted"    # Z

    .prologue
    .line 320
    if-eqz p1, :cond_0

    .line 321
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$5;->this$0:Lco/vine/android/recorder/VineRecorder;

    new-instance v1, Lco/vine/android/recorder/RecordSegment;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder$5;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-wide v2, v2, Lco/vine/android/recorder/VineRecorder;->mCurrentDuration:J

    invoke-direct {v1, v2, v3}, Lco/vine/android/recorder/RecordSegment;-><init>(J)V

    # setter for: Lco/vine/android/recorder/VineRecorder;->mLastPlayingSegment:Lco/vine/android/recorder/RecordSegment;
    invoke-static {v0, v1}, Lco/vine/android/recorder/VineRecorder;->access$1102(Lco/vine/android/recorder/VineRecorder;Lco/vine/android/recorder/RecordSegment;)Lco/vine/android/recorder/RecordSegment;

    .line 323
    :cond_0
    return-void
.end method
