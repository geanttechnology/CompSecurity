.class Lcom/mixerbox/mixerbox3b/MainPage$32$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/MainPage$32;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage$32;)V
    .locals 0

    .prologue
    .line 1999
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$32$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$32;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2

    .prologue
    .line 2002
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$32$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$32;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$32;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getRequestedOrientation()I

    move-result v0

    const/4 v1, 0x6

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$32$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$32;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$32;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->SCREEN_STATE:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 2004
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$32$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$32;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$32;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setFullScreen()V

    .line 2006
    :cond_0
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 2010
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 2014
    return-void
.end method
