.class Lcom/comcast/cim/android/view/common/Fade$2;
.super Landroid/animation/AnimatorListenerAdapter;
.source "Fade.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/common/Fade;->hide(Landroid/view/View;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/common/Fade;

.field final synthetic val$view:Landroid/view/View;

.field final synthetic val$visibility:I


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/common/Fade;Landroid/view/View;I)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/common/Fade;

    .prologue
    .line 106
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/Fade$2;->this$0:Lcom/comcast/cim/android/view/common/Fade;

    iput-object p2, p0, Lcom/comcast/cim/android/view/common/Fade$2;->val$view:Landroid/view/View;

    iput p3, p0, Lcom/comcast/cim/android/view/common/Fade$2;->val$visibility:I

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 108
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/Fade$2;->val$view:Landroid/view/View;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 109
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/Fade$2;->val$view:Landroid/view/View;

    iget v1, p0, Lcom/comcast/cim/android/view/common/Fade$2;->val$visibility:I

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 110
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/Fade$2;->val$view:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    .line 111
    return-void
.end method
