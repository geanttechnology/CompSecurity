.class Lcom/mixerbox/mixerbox3b/Onboarding$1$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/Onboarding$1;

.field final synthetic val$b3:Landroid/widget/ImageView;

.field final synthetic val$b4:Landroid/widget/ImageView;

.field final synthetic val$zoom4:Landroid/view/animation/Animation;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/Onboarding$1;Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 176
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1$3;->this$1:Lcom/mixerbox/mixerbox3b/Onboarding$1;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1$3;->val$b3:Landroid/widget/ImageView;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1$3;->val$b4:Landroid/widget/ImageView;

    iput-object p4, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1$3;->val$zoom4:Landroid/view/animation/Animation;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2

    .prologue
    .line 183
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1$3;->val$b4:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1$3;->val$zoom4:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 184
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 186
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 2

    .prologue
    .line 179
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1$3;->val$b3:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 180
    return-void
.end method
