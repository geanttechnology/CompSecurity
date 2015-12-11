.class Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;
.super Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;
.source "HistoryAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "DownloadServiceListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/downloads/SimpleDownloadServiceListener",
        "<",
        "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

.field viewHolderMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
            "Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;)V
    .locals 1
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    .prologue
    .line 551
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    invoke-direct {p0}, Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;-><init>()V

    .line 552
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;->viewHolderMap:Ljava/util/Map;

    return-void
.end method


# virtual methods
.method public add(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 1
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;
    .param p2, "playerDownloadFile"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 570
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;->viewHolderMap:Ljava/util/Map;

    invoke-interface {v0, p2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 571
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;->viewHolderMap:Ljava/util/Map;

    invoke-interface {v0, p2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 573
    :cond_0
    return-void
.end method

.method public onDownloadEngineStatusChanged(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V
    .locals 6
    .param p1, "downloadEngineStatus"    # Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    .prologue
    .line 564
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;->viewHolderMap:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 565
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;

    iget-object v3, v1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->access$100(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->access$200(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;)Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v5

    invoke-virtual {v3, v1, v4, v5}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setProgress(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;)V

    goto :goto_0

    .line 567
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;>;"
    :cond_0
    return-void
.end method

.method public bridge synthetic onFileProgressUpdated(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 551
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;->onFileProgressUpdated(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method public onFileProgressUpdated(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 4
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 556
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;->viewHolderMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;

    .line 557
    .local v0, "holder":Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;
    if-eqz v0, :cond_0

    .line 558
    iget-object v1, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->access$100(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->access$200(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;)Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v3

    invoke-virtual {v1, p1, v2, v3}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setProgress(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;)V

    .line 560
    :cond_0
    return-void
.end method
