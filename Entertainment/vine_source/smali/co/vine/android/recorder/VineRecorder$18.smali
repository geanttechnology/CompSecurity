.class Lco/vine/android/recorder/VineRecorder$18;
.super Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;
.source "VineRecorder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/recorder/VineRecorder;->getOnResumeTask(Landroid/view/View;Ljava/lang/String;)Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/VineRecorder;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/VineRecorder;Landroid/view/View;Ljava/lang/String;)V
    .locals 0
    .param p2, "x0"    # Landroid/view/View;
    .param p3, "x1"    # Ljava/lang/String;

    .prologue
    .line 1260
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder$18;->this$0:Lco/vine/android/recorder/VineRecorder;

    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;-><init>(Lco/vine/android/recorder/RegularVineRecorder;Landroid/view/View;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method protected onPostExecute(Lco/vine/android/recorder/RecordingFile;)V
    .locals 1
    .param p1, "needHashTask"    # Lco/vine/android/recorder/RecordingFile;

    .prologue
    .line 1263
    invoke-super {p0, p1}, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;->onPostExecute(Lco/vine/android/recorder/RecordingFile;)V

    .line 1264
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$18;->this$0:Lco/vine/android/recorder/VineRecorder;

    # invokes: Lco/vine/android/recorder/VineRecorder;->invalidateZoomSlider()V
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$000(Lco/vine/android/recorder/VineRecorder;)V

    .line 1265
    return-void
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 1260
    check-cast p1, Lco/vine/android/recorder/RecordingFile;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/VineRecorder$18;->onPostExecute(Lco/vine/android/recorder/RecordingFile;)V

    return-void
.end method
