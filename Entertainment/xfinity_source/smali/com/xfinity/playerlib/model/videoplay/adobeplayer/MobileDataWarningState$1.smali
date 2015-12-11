.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$1;
.super Ljava/lang/Object;
.source "MobileDataWarningState.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->postMobileDataWarningDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 81
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setIgnoreMobileDataWarningSettingThisSession(Z)V

    .line 82
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->transitionState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->access$000(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 83
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 84
    return-void
.end method
