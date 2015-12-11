.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState$2;
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

.field final synthetic val$nextVideoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

.field final synthetic val$nextWatchable:Lcom/xfinity/playerlib/model/consumable/Watchable;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState$2;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;

    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState$2;->val$nextVideoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    iput-object p3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState$2;->val$nextWatchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I

    .prologue
    .line 61
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState$2;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState$2;->val$nextVideoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState$2;->val$nextWatchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setVideoAndWatchable(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 62
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState$2;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->reset()V

    .line 63
    return-void
.end method
