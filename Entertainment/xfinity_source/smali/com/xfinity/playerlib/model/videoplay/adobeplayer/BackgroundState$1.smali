.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState$1;
.super Landroid/content/BroadcastReceiver;
.source "BackgroundState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->onActivityResumed()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "andCtx"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 54
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "android.intent.action.USER_PRESENT"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 61
    :goto_0
    return-void

    .line 58
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;

    # invokes: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->returnFromBackground()V
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->access$000(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;)V

    .line 60
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;

    # invokes: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->unregisterKeyguardReceiver()V
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->access$100(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;)V

    goto :goto_0
.end method
