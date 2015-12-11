.class Lcom/mixerbox/mixerbox3b/MainPage$MyHandler$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

.field final synthetic val$theActivity:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 1722
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler$2;->this$0:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler$2;->val$theActivity:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2

    .prologue
    .line 1725
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler$2;->val$theActivity:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1726
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 1730
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 1734
    return-void
.end method
