.class Lco/vine/android/recorder/VineRecorder$20;
.super Ljava/lang/Object;
.source "VineRecorder.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/recorder/VineRecorder;->onUiResumed(Landroid/app/Activity;Ljava/lang/Runnable;Z)V
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
    .line 1520
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder$20;->this$0:Lco/vine/android/recorder/VineRecorder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 1523
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$20;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$3200(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1524
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$20;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$3200(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->isActivated()Z

    move-result v0

    .line 1526
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
