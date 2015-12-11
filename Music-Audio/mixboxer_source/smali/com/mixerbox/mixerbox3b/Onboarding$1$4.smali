.class Lcom/mixerbox/mixerbox3b/Onboarding$1$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/Onboarding$1;

.field final synthetic val$b4:Landroid/widget/ImageView;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/Onboarding$1;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 190
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1$4;->this$1:Lcom/mixerbox/mixerbox3b/Onboarding$1;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1$4;->val$b4:Landroid/widget/ImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 197
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 199
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 2

    .prologue
    .line 193
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1$4;->val$b4:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 194
    return-void
.end method
