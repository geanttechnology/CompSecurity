.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$5;
.super Ljava/lang/Object;
.source "ErrorState.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->addCancelListener(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V
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
    .line 569
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$5;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 3
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;

    .prologue
    .line 572
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$5;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->access$200(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$5;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->access$200(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 573
    return-void
.end method
