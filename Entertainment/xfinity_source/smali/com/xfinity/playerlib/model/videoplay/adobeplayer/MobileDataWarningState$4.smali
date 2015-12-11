.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$4;
.super Ljava/lang/Object;
.source "MobileDataWarningState.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


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
    .line 110
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$4;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 113
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$4;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$4;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    iget-object v2, v2, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 114
    return-void
.end method
