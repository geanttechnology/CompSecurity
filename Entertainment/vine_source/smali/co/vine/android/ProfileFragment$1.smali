.class Lco/vine/android/ProfileFragment$1;
.super Ljava/lang/Object;
.source "ProfileFragment.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ProfileFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ProfileFragment;


# direct methods
.method constructor <init>(Lco/vine/android/ProfileFragment;)V
    .locals 0

    .prologue
    .line 118
    iput-object p1, p0, Lco/vine/android/ProfileFragment$1;->this$0:Lco/vine/android/ProfileFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 128
    iget-object v0, p0, Lco/vine/android/ProfileFragment$1;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lco/vine/android/HomeTabActivity;

    if-eqz v0, :cond_0

    .line 129
    iget-object v0, p0, Lco/vine/android/ProfileFragment$1;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/HomeTabActivity;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lco/vine/android/HomeTabActivity;->setScrollAwayNavEnabled(Z)V

    .line 131
    :cond_0
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 136
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 121
    iget-object v0, p0, Lco/vine/android/ProfileFragment$1;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lco/vine/android/HomeTabActivity;

    if-eqz v0, :cond_0

    .line 122
    iget-object v0, p0, Lco/vine/android/ProfileFragment$1;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/HomeTabActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/HomeTabActivity;->setScrollAwayNavEnabled(Z)V

    .line 124
    :cond_0
    return-void
.end method
