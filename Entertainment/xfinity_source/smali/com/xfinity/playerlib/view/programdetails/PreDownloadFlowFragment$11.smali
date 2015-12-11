.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$11;
.super Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;
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
        "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener",
        "<",
        "Lcom/xfinity/playerlib/authorization/SMILResource;",
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
    .line 484
    .local p2, "provider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/xfinity/playerlib/authorization/SMILResource;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$11;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    return-void
.end method


# virtual methods
.method public onPostExecute(Lcom/xfinity/playerlib/authorization/SMILResource;)V
    .locals 2
    .param p1, "resource"    # Lcom/xfinity/playerlib/authorization/SMILResource;

    .prologue
    .line 487
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$11;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/authorization/SMILResource;->getSignedManifestUrl()Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->manifestUrl:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$1402(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 488
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$11;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/authorization/SMILResource;->getSignedManifestUrl()Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchHlsVariantPlaylistAndSelectEmbeddedMediaProfile(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$1500(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Ljava/lang/String;)V

    .line 489
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 484
    check-cast p1, Lcom/xfinity/playerlib/authorization/SMILResource;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$11;->onPostExecute(Lcom/xfinity/playerlib/authorization/SMILResource;)V

    return-void
.end method
