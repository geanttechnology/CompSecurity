.class Lcom/comcast/cim/downloads/DownloadServiceManager$3$1;
.super Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;
.source "DownloadServiceManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/downloads/DownloadServiceManager$3;->engineDownloadedListChanged()V
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
.field final synthetic this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$3;


# direct methods
.method constructor <init>(Lcom/comcast/cim/downloads/DownloadServiceManager$3;Ljava/util/List;Ljava/util/Map;)V
    .locals 1
    .param p1, "this$1"    # Lcom/comcast/cim/downloads/DownloadServiceManager$3;

    .prologue
    .line 177
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$3$1;, "Lcom/comcast/cim/downloads/DownloadServiceManager$3$1;"
    .local p2, "identifiers":Ljava/util/List;, "Ljava/util/List<Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;>;"
    .local p3, "uuidToFileMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;TD;>;"
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$3$1;->this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$3;

    iget-object v0, p1, Lcom/comcast/cim/downloads/DownloadServiceManager$3;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-direct {p0, v0, p2, p3}, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Ljava/util/List;Ljava/util/Map;)V

    return-void
.end method


# virtual methods
.method protected onFileMapRetrieved()V
    .locals 2

    .prologue
    .line 180
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$3$1;, "Lcom/comcast/cim/downloads/DownloadServiceManager$3$1;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$3$1;->this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$3;

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$3;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    const/4 v1, 0x1

    # setter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->initialDownloadFilesMapRetrieved:Z
    invoke-static {v0, v1}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$702(Lcom/comcast/cim/downloads/DownloadServiceManager;Z)Z

    .line 181
    return-void
.end method
