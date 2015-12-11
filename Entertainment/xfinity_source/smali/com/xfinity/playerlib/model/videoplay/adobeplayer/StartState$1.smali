.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$1;
.super Ljava/lang/Object;
.source "StartState.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    .prologue
    .line 50
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 3
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    iget-object v2, v2, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 54
    return-void
.end method
