.class Lco/vine/android/ConversationFragment$HeightAnimation;
.super Landroid/view/animation/Animation;
.source "ConversationFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ConversationFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "HeightAnimation"
.end annotation


# instance fields
.field private mView:Landroid/view/View;

.field final synthetic this$0:Lco/vine/android/ConversationFragment;


# direct methods
.method public constructor <init>(Lco/vine/android/ConversationFragment;Landroid/view/View;Ljava/lang/Runnable;)V
    .locals 2
    .param p2, "view"    # Landroid/view/View;
    .param p3, "onAnimationEnd"    # Ljava/lang/Runnable;

    .prologue
    .line 709
    iput-object p1, p0, Lco/vine/android/ConversationFragment$HeightAnimation;->this$0:Lco/vine/android/ConversationFragment;

    invoke-direct {p0}, Landroid/view/animation/Animation;-><init>()V

    .line 710
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lco/vine/android/ConversationFragment$HeightAnimation;->setFillAfter(Z)V

    .line 711
    const-wide/16 v0, 0x12c

    invoke-virtual {p0, v0, v1}, Lco/vine/android/ConversationFragment$HeightAnimation;->setDuration(J)V

    .line 712
    iput-object p2, p0, Lco/vine/android/ConversationFragment$HeightAnimation;->mView:Landroid/view/View;

    .line 713
    new-instance v0, Lco/vine/android/ConversationFragment$HeightAnimation$1;

    invoke-direct {v0, p0, p1, p3}, Lco/vine/android/ConversationFragment$HeightAnimation$1;-><init>(Lco/vine/android/ConversationFragment$HeightAnimation;Lco/vine/android/ConversationFragment;Ljava/lang/Runnable;)V

    invoke-virtual {p0, v0}, Lco/vine/android/ConversationFragment$HeightAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 725
    return-void
.end method


# virtual methods
.method protected applyTransformation(FLandroid/view/animation/Transformation;)V
    .locals 4
    .param p1, "interpolatedTime"    # F
    .param p2, "t"    # Landroid/view/animation/Transformation;

    .prologue
    .line 729
    iget-object v1, p0, Lco/vine/android/ConversationFragment$HeightAnimation;->this$0:Lco/vine/android/ConversationFragment;

    invoke-virtual {v1}, Lco/vine/android/ConversationFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b001e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .line 730
    .local v0, "height":I
    iget-object v1, p0, Lco/vine/android/ConversationFragment$HeightAnimation;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    int-to-float v2, v0

    const/high16 v3, 0x3f800000    # 1.0f

    sub-float/2addr v3, p1

    mul-float/2addr v2, v3

    float-to-int v2, v2

    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 731
    iget-object v1, p0, Lco/vine/android/ConversationFragment$HeightAnimation;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->requestLayout()V

    .line 732
    return-void
.end method

.method public willChangeBounds()Z
    .locals 1

    .prologue
    .line 736
    const/4 v0, 0x1

    return v0
.end method
