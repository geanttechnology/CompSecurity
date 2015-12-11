.class Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$1;
.super Ljava/lang/Object;
.source "PlayerDownloadServiceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->downloadHlsFileWithWatchable(Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Ljava/util/Date;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;Lcom/google/common/util/concurrent/FutureCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field final synthetic val$video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .prologue
    .line 194
    iput-object p1, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$1;->this$0:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iput-object p2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$1;->val$video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 197
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$1;->this$0:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    # getter for: Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->access$000(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;)Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$1;->val$video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackDownloadRequest(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    .line 198
    return-void
.end method
