.class Lcom/mixerbox/mixerbox3b/MainPage$32;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 1991
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$32;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 1994
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$32;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1995
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$32;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1996
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$32;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1998
    const/16 v0, 0x320

    const/high16 v1, -0x40800000    # -1.0f

    # invokes: Lcom/mixerbox/mixerbox3b/MainPage;->slideAnim(IFFFF)Landroid/view/animation/Animation;
    invoke-static {v0, v2, v2, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->access$400(IFFFF)Landroid/view/animation/Animation;

    move-result-object v0

    .line 1999
    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$32$1;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$32$1;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$32;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 2017
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$32;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 2018
    return-void
.end method
