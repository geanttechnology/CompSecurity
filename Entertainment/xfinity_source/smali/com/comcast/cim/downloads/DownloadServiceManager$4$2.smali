.class Lcom/comcast/cim/downloads/DownloadServiceManager$4$2;
.super Ljava/lang/Object;
.source "DownloadServiceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/downloads/DownloadServiceManager$4;->downloadEngineProgressUpdatedForFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$4;

.field final synthetic val$file:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;


# direct methods
.method constructor <init>(Lcom/comcast/cim/downloads/DownloadServiceManager$4;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V
    .locals 0
    .param p1, "this$1"    # Lcom/comcast/cim/downloads/DownloadServiceManager$4;

    .prologue
    .line 209
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$4$2;, "Lcom/comcast/cim/downloads/DownloadServiceManager$4$2;"
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$4$2;->this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$4;

    iput-object p2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$4$2;->val$file:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 211
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$4$2;, "Lcom/comcast/cim/downloads/DownloadServiceManager$4$2;"
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$4$2;->this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$4;

    iget-object v1, v1, Lcom/comcast/cim/downloads/DownloadServiceManager$4;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$4$2;->val$file:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    # invokes: Lcom/comcast/cim/downloads/DownloadServiceManager;->getDownloadFile(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)Lcom/comcast/cim/downloads/DownloadFile;
    invoke-static {v1, v2}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$800(Lcom/comcast/cim/downloads/DownloadServiceManager;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)Lcom/comcast/cim/downloads/DownloadFile;

    move-result-object v0

    .line 212
    .local v0, "dlFile":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$4$2;->this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$4;

    iget-object v1, v1, Lcom/comcast/cim/downloads/DownloadServiceManager$4;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->queuedFilesMap:Ljava/util/Map;
    invoke-static {v1}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$900(Lcom/comcast/cim/downloads/DownloadServiceManager;)Ljava/util/Map;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$4$2;->val$file:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v2}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 213
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$4$2;->this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$4;

    iget-object v1, v1, Lcom/comcast/cim/downloads/DownloadServiceManager$4;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-virtual {v1, v0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->onFileProgressUpdated(Lcom/comcast/cim/downloads/DownloadFile;)V

    .line 214
    return-void
.end method
