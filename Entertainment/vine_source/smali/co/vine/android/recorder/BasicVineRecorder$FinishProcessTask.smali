.class public Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;
.super Lco/vine/android/recorder/BaseFinishProcessTask;
.source "BasicVineRecorder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/BasicVineRecorder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "FinishProcessTask"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/BasicVineRecorder;


# direct methods
.method public constructor <init>(Lco/vine/android/recorder/BasicVineRecorder;Ljava/lang/String;Ljava/lang/Runnable;ZZ)V
    .locals 0
    .param p2, "tag"    # Ljava/lang/String;
    .param p3, "onComplete"    # Ljava/lang/Runnable;
    .param p4, "releasePreview"    # Z
    .param p5, "saveSession"    # Z

    .prologue
    .line 681
    iput-object p1, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    .line 682
    invoke-direct {p0, p2, p3, p4, p5}, Lco/vine/android/recorder/BaseFinishProcessTask;-><init>(Ljava/lang/String;Ljava/lang/Runnable;ZZ)V

    .line 683
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 679
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 4
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 687
    iget-object v0, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;->this$0:Lco/vine/android/recorder/BasicVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/BasicVineRecorder;->mFinishProcessRunnable:Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;

    iget-object v1, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;->tag:Ljava/lang/String;

    iget-boolean v2, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;->releasePreview:Z

    iget-boolean v3, p0, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessTask;->saveSession:Z

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;->run(Ljava/lang/String;ZZ)V

    .line 688
    const/4 v0, 0x0

    return-object v0
.end method
