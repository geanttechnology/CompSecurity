.class Lcom/comcast/cim/cmasl/hls/HlsDownloadClient$1;
.super Ljava/lang/Object;
.source "HlsDownloadClient.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;->downloadHlsFile(Ljava/lang/String;Lcom/comcast/cim/cmasl/hls/HlsParser;Ljava/util/Map;)Lcom/comcast/cim/cmasl/hls/HlsPlaylist;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
        "<",
        "Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler",
        "<TP;>;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;

.field final synthetic val$hlsParser:Lcom/comcast/cim/cmasl/hls/HlsParser;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;Lcom/comcast/cim/cmasl/hls/HlsParser;)V
    .locals 0

    .prologue
    .line 34
    .local p0, "this":Lcom/comcast/cim/cmasl/hls/HlsDownloadClient$1;, "Lcom/comcast/cim/cmasl/hls/HlsDownloadClient.1;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hls/HlsDownloadClient$1;->this$0:Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;

    iput-object p2, p0, Lcom/comcast/cim/cmasl/hls/HlsDownloadClient$1;->val$hlsParser:Lcom/comcast/cim/cmasl/hls/HlsParser;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler",
            "<TP;>;"
        }
    .end annotation

    .prologue
    .line 36
    .local p0, "this":Lcom/comcast/cim/cmasl/hls/HlsDownloadClient$1;, "Lcom/comcast/cim/cmasl/hls/HlsDownloadClient.1;"
    new-instance v0, Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/hls/HlsDownloadClient$1;->val$hlsParser:Lcom/comcast/cim/cmasl/hls/HlsParser;

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;-><init>(Lcom/comcast/cim/cmasl/hls/HlsParser;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 34
    .local p0, "this":Lcom/comcast/cim/cmasl/hls/HlsDownloadClient$1;, "Lcom/comcast/cim/cmasl/hls/HlsDownloadClient.1;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/hls/HlsDownloadClient$1;->get()Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;

    move-result-object v0

    return-object v0
.end method
