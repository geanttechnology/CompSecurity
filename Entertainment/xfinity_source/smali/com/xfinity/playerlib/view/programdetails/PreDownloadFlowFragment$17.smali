.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$17;
.super Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchHlsAlternateAudio()V
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
    .line 661
    .local p2, "provider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$17;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    return-void
.end method


# virtual methods
.method public onPostExecute(Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;)V
    .locals 1
    .param p1, "resource"    # Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    .prologue
    .line 664
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$17;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # setter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;
    invoke-static {v0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$2702(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;)Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    .line 665
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$17;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->ensureDeviceRegistration()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$2600(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    .line 666
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 661
    check-cast p1, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$17;->onPostExecute(Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;)V

    return-void
.end method
