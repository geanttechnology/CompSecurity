.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$2;
.super Ljava/lang/Object;
.source "ErrorState.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


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
    .line 515
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$2;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 518
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$2;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->access$200(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState$2;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->access$200(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 519
    return-void
.end method
