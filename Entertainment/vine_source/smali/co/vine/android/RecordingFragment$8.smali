.class Lco/vine/android/RecordingFragment$8;
.super Ljava/lang/Object;
.source "RecordingFragment.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/RecordingFragment;->onActivityCreated(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/RecordingFragment;


# direct methods
.method constructor <init>(Lco/vine/android/RecordingFragment;)V
    .locals 0

    .prologue
    .line 496
    iput-object p1, p0, Lco/vine/android/RecordingFragment$8;->this$0:Lco/vine/android/RecordingFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 499
    invoke-virtual {p1}, Landroid/view/View;->getVisibility()I

    move-result v1

    if-nez v1, :cond_0

    .line 500
    iget-object v1, p0, Lco/vine/android/RecordingFragment$8;->this$0:Lco/vine/android/RecordingFragment;

    invoke-virtual {v1}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f04000f

    invoke-static {v1, v2}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 502
    .local v0, "fadeOut":Landroid/view/animation/Animation;
    iget-object v1, p0, Lco/vine/android/RecordingFragment$8;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mVmOnboardingFadeListener:Landroid/view/animation/Animation$AnimationListener;
    invoke-static {v1}, Lco/vine/android/RecordingFragment;->access$1100(Lco/vine/android/RecordingFragment;)Landroid/view/animation/Animation$AnimationListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 503
    iget-object v1, p0, Lco/vine/android/RecordingFragment$8;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mVmOnboardOverlay:Landroid/view/ViewGroup;
    invoke-static {v1}, Lco/vine/android/RecordingFragment;->access$300(Lco/vine/android/RecordingFragment;)Landroid/view/ViewGroup;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->startAnimation(Landroid/view/animation/Animation;)V

    .line 505
    .end local v0    # "fadeOut":Landroid/view/animation/Animation;
    :cond_0
    const/4 v1, 0x0

    return v1
.end method
