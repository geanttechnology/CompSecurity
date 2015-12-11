.class Lcom/inc247/ChatSDK$6;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/ChatSDK;->hideWithAnimation()V
.end annotation


# instance fields
.field final synthetic this$0:Lcom/inc247/ChatSDK;


# direct methods
.method constructor <init>(Lcom/inc247/ChatSDK;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/inc247/ChatSDK$6;->this$0:Lcom/inc247/ChatSDK;

    .line 871
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 884
    iget-object v0, p0, Lcom/inc247/ChatSDK$6;->this$0:Lcom/inc247/ChatSDK;

    # getter for: Lcom/inc247/ChatSDK;->buttonLayout:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/inc247/ChatSDK;->access$5(Lcom/inc247/ChatSDK;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 885
    iget-object v0, p0, Lcom/inc247/ChatSDK$6;->this$0:Lcom/inc247/ChatSDK;

    # getter for: Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/inc247/ChatSDK;->access$4(Lcom/inc247/ChatSDK;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 887
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 2

    .prologue
    .line 879
    iget-object v0, p0, Lcom/inc247/ChatSDK$6;->this$0:Lcom/inc247/ChatSDK;

    # getter for: Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/inc247/ChatSDK;->access$4(Lcom/inc247/ChatSDK;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 880
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 2

    .prologue
    .line 874
    iget-object v0, p0, Lcom/inc247/ChatSDK$6;->this$0:Lcom/inc247/ChatSDK;

    # getter for: Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/inc247/ChatSDK;->access$4(Lcom/inc247/ChatSDK;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 875
    return-void
.end method
