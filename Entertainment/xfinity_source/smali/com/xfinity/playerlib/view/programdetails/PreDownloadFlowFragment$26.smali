.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$26;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->acquireMediaLicense()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask",
        "<",
        "Ljava/util/Date;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

.field final synthetic val$playerPlatformAPI:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 868
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$26;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$26;->val$playerPlatformAPI:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 868
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$26;->execute()Ljava/util/Date;

    move-result-object v0

    return-object v0
.end method

.method public execute()Ljava/util/Date;
    .locals 6

    .prologue
    .line 872
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$26;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$4200(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$26;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->manifestUrl:Ljava/lang/String;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$1400(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$26;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->titaniumTicket:Lcom/xfinity/playerlib/downloads/TitaniumTicket;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$3800(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/downloads/TitaniumTicket;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$26;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$3300(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v4

    sget-object v5, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->STREAMING:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;->create(Ljava/lang/String;Lcom/xfinity/playerlib/downloads/TitaniumTicket;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v0

    .line 873
    .local v0, "cimAsset":Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$26;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->mediaLicenseClient:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$4300(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$26;->val$playerPlatformAPI:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v1, v2, v0}, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->getOrRefreshMediaLicense(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;Lcom/comcast/playerplatform/primetime/android/asset/Asset;)Ljava/util/Date;

    move-result-object v1

    return-object v1
.end method
