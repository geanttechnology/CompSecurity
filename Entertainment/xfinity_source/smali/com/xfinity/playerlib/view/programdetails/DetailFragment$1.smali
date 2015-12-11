.class Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;
.super Ljava/lang/Object;
.source "DetailFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->setupCancelDownloadButton(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

.field final synthetic val$layout:Landroid/view/View;

.field final synthetic val$video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Landroid/view/View;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    .prologue
    .line 395
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;->val$video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;->val$layout:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 401
    :try_start_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;->val$video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->findFileWithVideoId(J)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-result-object v1

    .line 403
    .local v1, "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    if-eqz v1, :cond_0

    .line 404
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v2, v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->deleteFile(Lcom/comcast/cim/downloads/DownloadFile;)Ljava/util/Map;
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 411
    .end local v1    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :cond_0
    :goto_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;->val$layout:Landroid/view/View;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->toggleProgressState(ZLandroid/view/View;)V
    invoke-static {v2, v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;ZLandroid/view/View;)V

    .line 412
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;->val$video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;->val$layout:Landroid/view/View;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadAvailableState(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Landroid/view/View;)Landroid/widget/LinearLayout;
    invoke-static {v2, v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Landroid/view/View;)Landroid/widget/LinearLayout;

    .line 414
    return-void

    .line 407
    :catch_0
    move-exception v0

    .line 408
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->access$000(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;)Lorg/slf4j/Logger;

    move-result-object v2

    invoke-virtual {v0}, Lcom/comcast/cim/downloads/DownloadServiceException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
