.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$24;
.super Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;
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
        "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener",
        "<",
        "Lcom/xfinity/playerlib/downloads/TitaniumTicket;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 815
    .local p2, "provider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/xfinity/playerlib/downloads/TitaniumTicket;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$24;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 4
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 825
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v2

    instance-of v2, v2, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    if-eqz v2, :cond_0

    .line 826
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    check-cast v2, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getDetailedStatusCode()I

    move-result v2

    const/16 v3, 0x7d1

    if-ne v2, v3, :cond_0

    .line 827
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$24;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "Device is not registered, wiping all content and prompting user to register device"

    invoke-interface {v2, v3, p1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 828
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$24;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$900(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .line 829
    .local v1, "userSettings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setDeviceRegistration(Lcom/xfinity/playerlib/downloads/DeviceRegistration;)V

    .line 831
    :try_start_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$24;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$800(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->deleteAllContent()Ljava/util/Map;
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 837
    :goto_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$24;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->promptToRegisterDevice()V
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$4000(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    .line 841
    .end local v1    # "userSettings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    :goto_1
    return-void

    .line 832
    .restart local v1    # "userSettings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    :catch_0
    move-exception v0

    .line 835
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$24;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "Caught exception attempting to delete all content"

    invoke-interface {v2, v3, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 839
    .end local v0    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    .end local v1    # "userSettings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    :cond_0
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;->onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V

    goto :goto_1
.end method

.method public onPostExecute(Lcom/xfinity/playerlib/downloads/TitaniumTicket;)V
    .locals 2
    .param p1, "resource"    # Lcom/xfinity/playerlib/downloads/TitaniumTicket;

    .prologue
    .line 818
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$24;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "Fetched titanium ticket"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 819
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$24;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # setter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->titaniumTicket:Lcom/xfinity/playerlib/downloads/TitaniumTicket;
    invoke-static {v0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$3802(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/xfinity/playerlib/downloads/TitaniumTicket;)Lcom/xfinity/playerlib/downloads/TitaniumTicket;

    .line 820
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$24;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->configurePlayer()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$3900(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    .line 821
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 815
    check-cast p1, Lcom/xfinity/playerlib/downloads/TitaniumTicket;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$24;->onPostExecute(Lcom/xfinity/playerlib/downloads/TitaniumTicket;)V

    return-void
.end method
