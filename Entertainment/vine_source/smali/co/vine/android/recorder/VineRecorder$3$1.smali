.class Lco/vine/android/recorder/VineRecorder$3$1;
.super Lco/vine/android/recorder/RegularVineRecorder$ResumeCameraAsyncTask;
.source "VineRecorder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/recorder/VineRecorder$3;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lco/vine/android/recorder/VineRecorder$3;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/VineRecorder$3;Z)V
    .locals 1
    .param p2, "x0"    # Z

    .prologue
    .line 160
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder$3$1;->this$1:Lco/vine/android/recorder/VineRecorder$3;

    iget-object v0, p1, Lco/vine/android/recorder/VineRecorder$3;->this$0:Lco/vine/android/recorder/VineRecorder;

    invoke-direct {p0, v0, p2}, Lco/vine/android/recorder/RegularVineRecorder$ResumeCameraAsyncTask;-><init>(Lco/vine/android/recorder/RegularVineRecorder;Z)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 160
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/VineRecorder$3$1;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 1
    .param p1, "aVoid"    # Ljava/lang/Void;

    .prologue
    .line 163
    invoke-super {p0, p1}, Lco/vine/android/recorder/RegularVineRecorder$ResumeCameraAsyncTask;->onPostExecute(Ljava/lang/Void;)V

    .line 164
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$3$1;->this$1:Lco/vine/android/recorder/VineRecorder$3;

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder$3;->this$0:Lco/vine/android/recorder/VineRecorder;

    # invokes: Lco/vine/android/recorder/VineRecorder;->invalidateZoomSlider()V
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$000(Lco/vine/android/recorder/VineRecorder;)V

    .line 165
    return-void
.end method
