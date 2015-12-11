.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$16;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
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
        "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask",
        "<",
        "Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;",
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
    .line 654
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$16;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method


# virtual methods
.method public execute()Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;
    .locals 5

    .prologue
    .line 657
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$16;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->hlsDownloadClient:Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$1600(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$16;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->metaDownloadProfile:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$2200(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->getUrlPathPrefix()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$16;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->alternateAudioProfile:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$2100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->getUriString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "\""

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylistParser;

    invoke-direct {v2}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylistParser;-><init>()V

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;->downloadHlsFile(Ljava/lang/String;Lcom/comcast/cim/cmasl/hls/HlsParser;)Lcom/comcast/cim/cmasl/hls/HlsPlaylist;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    return-object v0
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 654
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$16;->execute()Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    move-result-object v0

    return-object v0
.end method
