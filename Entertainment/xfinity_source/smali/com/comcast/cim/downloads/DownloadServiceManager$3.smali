.class Lcom/comcast/cim/downloads/DownloadServiceManager$3;
.super Ljava/lang/Object;
.source "DownloadServiceManager.java"

# interfaces
.implements Lcom/penthera/virtuososdk/client/IDownloadedObserver;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/downloads/DownloadServiceManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;


# direct methods
.method constructor <init>(Lcom/comcast/cim/downloads/DownloadServiceManager;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 173
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$3;, "Lcom/comcast/cim/downloads/DownloadServiceManager$3;"
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$3;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public engineDownloadedListChanged()V
    .locals 4

    .prologue
    .line 177
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$3;, "Lcom/comcast/cim/downloads/DownloadServiceManager$3;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$3;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager;->backgroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceManager$3$1;

    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$3;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;
    invoke-static {v2}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$500(Lcom/comcast/cim/downloads/DownloadServiceManager;)Lcom/penthera/virtuososdk/client/Virtuoso;

    move-result-object v2

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/client/Virtuoso;->downloadedRootList()Ljava/util/List;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$3;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadsMap:Ljava/util/Map;
    invoke-static {v3}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$600(Lcom/comcast/cim/downloads/DownloadServiceManager;)Ljava/util/Map;

    move-result-object v3

    invoke-direct {v1, p0, v2, v3}, Lcom/comcast/cim/downloads/DownloadServiceManager$3$1;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager$3;Ljava/util/List;Ljava/util/Map;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 183
    return-void
.end method
