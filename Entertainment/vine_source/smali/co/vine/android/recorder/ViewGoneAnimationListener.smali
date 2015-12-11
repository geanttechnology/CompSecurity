.class public Lco/vine/android/recorder/ViewGoneAnimationListener;
.super Ljava/lang/Object;
.source "ViewGoneAnimationListener.java"

# interfaces
.implements Landroid/animation/Animator$AnimatorListener;


# instance fields
.field private mView:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 0
    .param p1, "toRemove"    # Landroid/view/View;

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    iput-object p1, p0, Lco/vine/android/recorder/ViewGoneAnimationListener;->mView:Landroid/view/View;

    .line 11
    return-void
.end method


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .locals 0
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 29
    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 3
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    const/4 v2, 0x0

    .line 19
    iget-object v0, p0, Lco/vine/android/recorder/ViewGoneAnimationListener;->mView:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 20
    iget-object v0, p0, Lco/vine/android/recorder/ViewGoneAnimationListener;->mView:Landroid/view/View;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 21
    iget-object v0, p0, Lco/vine/android/recorder/ViewGoneAnimationListener;->mView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    .line 22
    iget-object v0, p0, Lco/vine/android/recorder/ViewGoneAnimationListener;->mView:Landroid/view/View;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 23
    iput-object v2, p0, Lco/vine/android/recorder/ViewGoneAnimationListener;->mView:Landroid/view/View;

    .line 25
    :cond_0
    return-void
.end method

.method public onAnimationRepeat(Landroid/animation/Animator;)V
    .locals 0
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 33
    return-void
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .locals 0
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 15
    return-void
.end method
