.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$12;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchHlsVariantPlaylistAndSelectEmbeddedMediaProfile(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask",
        "<",
        "Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

.field final synthetic val$hlsVariantPlaylistUrl:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Ljava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 495
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$12;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$12;->val$hlsVariantPlaylistUrl:Ljava/lang/String;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method


# virtual methods
.method public execute()Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;
    .locals 3

    .prologue
    .line 498
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$12;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->hlsDownloadClient:Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$1600(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$12;->val$hlsVariantPlaylistUrl:Ljava/lang/String;

    new-instance v2, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylistParser;

    invoke-direct {v2}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylistParser;-><init>()V

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;->downloadHlsFile(Ljava/lang/String;Lcom/comcast/cim/cmasl/hls/HlsParser;)Lcom/comcast/cim/cmasl/hls/HlsPlaylist;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    return-object v0
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 495
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$12;->execute()Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    move-result-object v0

    return-object v0
.end method
