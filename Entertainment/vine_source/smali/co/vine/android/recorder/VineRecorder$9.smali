.class Lco/vine/android/recorder/VineRecorder$9;
.super Ljava/lang/Object;
.source "VineRecorder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/recorder/VineRecorder;->animateCaptureControlsIn()V
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
    .line 491
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder$9;->this$0:Lco/vine/android/recorder/VineRecorder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    const-wide/16 v5, 0xfa

    const/4 v4, 0x0

    const/high16 v3, 0x3f800000    # 1.0f

    const/4 v2, 0x0

    .line 494
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$9;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mRecordingOptions:Landroid/view/View;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$1500(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 495
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$9;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mRecordingOptions:Landroid/view/View;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$1500(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setAlpha(F)V

    .line 496
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$9;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mRecordingOptions:Landroid/view/View;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$1500(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 497
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$9;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mRecordingOptions:Landroid/view/View;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$1500(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v5, v6}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 499
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$9;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mTopMaskView:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 500
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$9;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mTopMaskView:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setAlpha(F)V

    .line 501
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$9;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mTopMaskView:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 502
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$9;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mTopMaskView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v5, v6}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 504
    :cond_1
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$9;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mProgressView:Lco/vine/android/recorder/ProgressView;

    if-eqz v0, :cond_2

    .line 505
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$9;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mProgressView:Lco/vine/android/recorder/ProgressView;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder$9;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mEditorButtonsHeight:I
    invoke-static {v1}, Lco/vine/android/recorder/VineRecorder;->access$1600(Lco/vine/android/recorder/VineRecorder;)I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/ProgressView;->setTranslationY(F)V

    .line 506
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$9;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mProgressView:Lco/vine/android/recorder/ProgressView;

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/ProgressView;->setScaleY(F)V

    .line 507
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$9;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mProgressView:Lco/vine/android/recorder/ProgressView;

    invoke-virtual {v0, v4}, Lco/vine/android/recorder/ProgressView;->setVisibility(I)V

    .line 508
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$9;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mProgressView:Lco/vine/android/recorder/ProgressView;

    invoke-virtual {v0}, Lco/vine/android/recorder/ProgressView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->scaleY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/ViewPropertyAnimator;->translationY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v5, v6}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 511
    :cond_2
    return-void
.end method
