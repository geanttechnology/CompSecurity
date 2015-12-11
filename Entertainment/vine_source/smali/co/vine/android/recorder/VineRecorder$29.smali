.class Lco/vine/android/recorder/VineRecorder$29;
.super Ljava/lang/Object;
.source "VineRecorder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/recorder/VineRecorder;->adjustBoundaries(Lco/vine/android/recorder/CameraSetting;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/VineRecorder;

.field final synthetic val$params:Landroid/view/ViewGroup$LayoutParams;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/VineRecorder;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 0

    .prologue
    .line 1834
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder$29;->this$0:Lco/vine/android/recorder/VineRecorder;

    iput-object p2, p0, Lco/vine/android/recorder/VineRecorder$29;->val$params:Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1837
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$29;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mFinishLoadingOverlay:Landroid/view/View;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$3000(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1838
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$29;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mFinishLoadingOverlay:Landroid/view/View;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$3000(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder$29;->val$params:Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1840
    :cond_0
    return-void
.end method
