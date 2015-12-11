.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$15;
.super Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchHlsSimplePlaylistForMediaProfile(Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener",
        "<",
        "Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;",
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
    .line 609
    .local p2, "provider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$15;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    return-void
.end method


# virtual methods
.method public onPostExecute(Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;)V
    .locals 3
    .param p1, "resource"    # Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    .prologue
    .line 612
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->getRelativeSequencePaths()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->getRelativeSequencePaths()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 613
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$15;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # setter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->profileToDownload:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;
    invoke-static {v0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$2402(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;)Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    .line 614
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$15;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->alternateAudioProfile:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$2100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 615
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$15;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchHlsAlternateAudio()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$2500(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    .line 648
    :goto_0
    return-void

    .line 617
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$15;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->ensureDeviceRegistration()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$2600(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    goto :goto_0

    .line 620
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$15;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$15$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$15$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$15;)V

    const-string v2, "chooseVideoFormat"

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->showDialog(Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$1700(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 609
    check-cast p1, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$15;->onPostExecute(Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;)V

    return-void
.end method
