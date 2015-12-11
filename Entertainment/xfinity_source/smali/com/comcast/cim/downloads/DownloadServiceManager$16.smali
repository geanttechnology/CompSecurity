.class Lcom/comcast/cim/downloads/DownloadServiceManager$16;
.super Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;
.source "DownloadServiceManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/downloads/DownloadServiceManager;->fetchFileList()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/downloads/DownloadServiceManager",
        "<TD;TT;TS;>.com/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;


# direct methods
.method constructor <init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Ljava/util/List;Ljava/util/Map;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 713
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$16;, "Lcom/comcast/cim/downloads/DownloadServiceManager$16;"
    .local p2, "identifiers":Ljava/util/List;, "Ljava/util/List<Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;>;"
    .local p3, "uuidToFileMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;TD;>;"
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$16;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-direct {p0, p1, p2, p3}, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Ljava/util/List;Ljava/util/Map;)V

    return-void
.end method


# virtual methods
.method protected onFileMapRetrieved()V
    .locals 2

    .prologue
    .line 716
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$16;, "Lcom/comcast/cim/downloads/DownloadServiceManager$16;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$16;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    const/4 v1, 0x1

    # setter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->initialDownloadFilesMapRetrieved:Z
    invoke-static {v0, v1}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$702(Lcom/comcast/cim/downloads/DownloadServiceManager;Z)Z

    .line 717
    return-void
.end method
