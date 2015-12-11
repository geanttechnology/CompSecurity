.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$10;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchSMILAndExtractSignedManifestUrl()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask",
        "<",
        "Lcom/xfinity/playerlib/authorization/SMILResource;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 478
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$10;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method


# virtual methods
.method public execute()Lcom/xfinity/playerlib/authorization/SMILResource;
    .locals 2

    .prologue
    .line 481
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$10;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->thePlatformClient:Lcom/xfinity/playerlib/authorization/ThePlatformClient;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$1300(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/authorization/ThePlatformClient;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$10;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->selectedHalVideoProfile:Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$1200(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->getManifestUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/authorization/ThePlatformClient;->getSMILResource(Ljava/lang/String;)Lcom/xfinity/playerlib/authorization/SMILResource;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 478
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$10;->execute()Lcom/xfinity/playerlib/authorization/SMILResource;

    move-result-object v0

    return-object v0
.end method
