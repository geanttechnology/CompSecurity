.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;
.super Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;
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
        "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener",
        "<",
        "Ljava/util/Date;",
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
    .line 877
    .local p2, "provider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Ljava/util/Date;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 4
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 887
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    instance-of v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient$LicenseAcquisitionTimeoutException;

    if-eqz v0, :cond_0

    .line 888
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;)V

    const-string v2, "acquireMediaLicense"

    const/4 v3, 0x0

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->showDialog(Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;Z)V
    invoke-static {v0, v1, v2, v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$3200(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;Z)V

    .line 908
    :goto_0
    return-void

    .line 906
    :cond_0
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;->onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V

    goto :goto_0
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 877
    check-cast p1, Ljava/util/Date;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;->onPostExecute(Ljava/util/Date;)V

    return-void
.end method

.method public onPostExecute(Ljava/util/Date;)V
    .locals 2
    .param p1, "resource"    # Ljava/util/Date;

    .prologue
    .line 880
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "Acquired media license"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 881
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # setter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->licenseExpirationDate:Ljava/util/Date;
    invoke-static {v0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$4402(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Ljava/util/Date;)Ljava/util/Date;

    .line 882
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->submitDownload()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$4500(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    .line 883
    return-void
.end method
