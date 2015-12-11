.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState$1;
.super Ljava/lang/Object;
.source "EndCardState.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;->showEndCard()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I

    .prologue
    .line 67
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 68
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;

    iget-object v2, v2, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 69
    return-void
.end method
