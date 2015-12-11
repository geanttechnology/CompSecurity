.class Lco/vine/android/RecordingFragment$2;
.super Ljava/lang/Object;
.source "RecordingFragment.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/RecordingFragment;
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
    .line 125
    iput-object p1, p0, Lco/vine/android/RecordingFragment$2;->this$0:Lco/vine/android/RecordingFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 132
    iget-object v0, p0, Lco/vine/android/RecordingFragment$2;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mVmOnboardOverlay:Landroid/view/ViewGroup;
    invoke-static {v0}, Lco/vine/android/RecordingFragment;->access$300(Lco/vine/android/RecordingFragment;)Landroid/view/ViewGroup;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 133
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 137
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 128
    return-void
.end method
