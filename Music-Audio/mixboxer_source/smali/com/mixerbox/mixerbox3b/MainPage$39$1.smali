.class Lcom/mixerbox/mixerbox3b/MainPage$39$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/MainPage$39;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage$39;)V
    .locals 0

    .prologue
    .line 2862
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$39$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$39;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2

    .prologue
    .line 2865
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$39;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 2866
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 2870
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 2874
    return-void
.end method
