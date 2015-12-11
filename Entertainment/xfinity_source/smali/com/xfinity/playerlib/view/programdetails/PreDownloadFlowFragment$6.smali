.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$6;
.super Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchVideoEntitlement()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener",
        "<",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
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
    .line 349
    .local p2, "provider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$6;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    return-void
.end method


# virtual methods
.method public onPostExecute(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    .locals 2
    .param p1, "resource"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    .line 352
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$6;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "Entitlement fetched"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 353
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$6;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # setter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    invoke-static {v0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$202(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 354
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$6;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->chooseVideoFormat()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$300(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    .line 355
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 349
    check-cast p1, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$6;->onPostExecute(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    return-void
.end method
