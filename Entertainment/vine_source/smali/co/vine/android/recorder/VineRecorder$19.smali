.class Lco/vine/android/recorder/VineRecorder$19;
.super Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;
.source "VineRecorder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/recorder/VineRecorder;->getFinishProcessTask(Ljava/lang/String;Ljava/lang/Runnable;ZZ)Lco/vine/android/recorder/BaseFinishProcessTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/VineRecorder;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/VineRecorder;Ljava/lang/String;Ljava/lang/Runnable;ZZ)V
    .locals 0
    .param p2, "x0"    # Ljava/lang/String;
    .param p3, "x1"    # Ljava/lang/Runnable;
    .param p4, "x2"    # Z
    .param p5, "x3"    # Z

    .prologue
    .line 1420
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder$19;->this$0:Lco/vine/android/recorder/VineRecorder;

    invoke-direct/range {p0 .. p5}, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;-><init>(Lco/vine/android/recorder/RegularVineRecorder;Ljava/lang/String;Ljava/lang/Runnable;ZZ)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 1420
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/VineRecorder$19;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 3
    .param p1, "aVoid"    # Ljava/lang/Void;

    .prologue
    .line 1423
    invoke-super {p0, p1}, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->onPostExecute(Ljava/lang/Void;)V

    .line 1424
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$19;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder$19;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mFinishLoadingOverlay:Landroid/view/View;
    invoke-static {v1}, Lco/vine/android/recorder/VineRecorder;->access$3000(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;

    move-result-object v1

    const/4 v2, 0x0

    # invokes: Lco/vine/android/recorder/VineRecorder;->animateSpinner(Landroid/view/View;Z)V
    invoke-static {v0, v1, v2}, Lco/vine/android/recorder/VineRecorder;->access$3100(Lco/vine/android/recorder/VineRecorder;Landroid/view/View;Z)V

    .line 1425
    return-void
.end method

.method protected onPreExecute()V
    .locals 3

    .prologue
    .line 1429
    invoke-super {p0}, Lco/vine/android/recorder/RegularVineRecorder$FinishProcessTask;->onPreExecute()V

    .line 1430
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$19;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder$19;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mFinishLoadingOverlay:Landroid/view/View;
    invoke-static {v1}, Lco/vine/android/recorder/VineRecorder;->access$3000(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;

    move-result-object v1

    const/4 v2, 0x1

    # invokes: Lco/vine/android/recorder/VineRecorder;->animateSpinner(Landroid/view/View;Z)V
    invoke-static {v0, v1, v2}, Lco/vine/android/recorder/VineRecorder;->access$3100(Lco/vine/android/recorder/VineRecorder;Landroid/view/View;Z)V

    .line 1431
    return-void
.end method
