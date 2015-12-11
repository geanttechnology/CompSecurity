.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$4;
.super Ljava/lang/Object;
.source "ErrorState.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->showError()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    .prologue
    .line 542
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$4;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public tryAgain()V
    .locals 2

    .prologue
    .line 545
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$4;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->access$200(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$4;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->retryState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->access$300(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 546
    return-void
.end method
