.class Lcom/mixerbox/mixerbox3b/MainPage$35$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/MainPage$35;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage$35;)V
    .locals 0

    .prologue
    .line 2320
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$35$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$35;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2

    .prologue
    .line 2323
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$35$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$35;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$35;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getRequestedOrientation()I

    move-result v0

    const/4 v1, 0x6

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$35$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$35;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$35;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->SCREEN_STATE:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 2325
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$35$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$35;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$35;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setFullScreen()V

    .line 2327
    :cond_0
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 2331
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 2335
    return-void
.end method
