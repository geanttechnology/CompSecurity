.class Lcom/xfinity/playerlib/view/programdetails/DetailFragment$FlowEventListener;
.super Ljava/lang/Object;
.source "DetailFragment.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$PreDownloadFlowEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FlowEventListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;)V
    .locals 0

    .prologue
    .line 492
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$FlowEventListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;

    .prologue
    .line 492
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$FlowEventListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;)V

    return-void
.end method


# virtual methods
.method public onPreDownloadFlowCompleted(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 6
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 497
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$FlowEventListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getVideoItemViewContainer()Landroid/view/ViewGroup;

    move-result-object v1

    .line 498
    .local v1, "videoItemViewContainer":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 499
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v0

    .line 500
    .local v0, "layout":Landroid/view/View;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$FlowEventListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    const/4 v3, 0x1

    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->toggleProgressState(ZLandroid/view/View;)V
    invoke-static {v2, v3, v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;ZLandroid/view/View;)V

    .line 502
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$FlowEventListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$FlowEventListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->findFileWithVideoId(J)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-result-object v3

    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showCustomDownloadWaitingState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;)V
    invoke-static {v2, v3, v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->access$400(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;)V

    .line 504
    .end local v0    # "layout":Landroid/view/View;
    :cond_0
    return-void
.end method
