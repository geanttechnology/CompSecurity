.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$23;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchTitaniumTicket()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask",
        "<",
        "Lcom/xfinity/playerlib/downloads/TitaniumTicket;",
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
    .line 809
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$23;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method


# virtual methods
.method public execute()Lcom/xfinity/playerlib/downloads/TitaniumTicket;
    .locals 4

    .prologue
    .line 812
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$23;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->titaniumTicketClient:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$3700(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    move-result-object v1

    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$23;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$900(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getAuthKeys()Lcom/comcast/cim/model/user/AuthKeys;

    move-result-object v0

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$23;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$23;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->selectedHalVideoProfile:Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$1200(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    move-result-object v3

    invoke-virtual {v1, v0, v2, v3}, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;->getTitaniumTicket(Lcom/comcast/cim/model/user/AuthKeys;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;)Lcom/xfinity/playerlib/downloads/TitaniumTicket;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 809
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$23;->execute()Lcom/xfinity/playerlib/downloads/TitaniumTicket;

    move-result-object v0

    return-object v0
.end method
