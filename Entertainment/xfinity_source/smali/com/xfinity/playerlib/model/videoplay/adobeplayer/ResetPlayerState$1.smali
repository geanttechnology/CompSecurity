.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState$1;
.super Landroid/content/BroadcastReceiver;
.source "ResetPlayerState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->onActivityResumed()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;

    .prologue
    .line 417
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "andCtx"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 420
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "android.intent.action.USER_PRESENT"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 425
    :goto_0
    return-void

    .line 423
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->access$000(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->reset()V

    .line 424
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;

    # invokes: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->unregisterKeyguardReceiver()V
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->access$100(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;)V

    goto :goto_0
.end method
