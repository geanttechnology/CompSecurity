.class Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$4;
.super Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;
.source "DownloadsArrayAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
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
.field final synthetic this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

.field final synthetic val$holder:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    .prologue
    .line 170
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$4;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$4;->val$holder:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;

    invoke-direct {p0}, Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onDownloadEngineStatusChanged(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V
    .locals 4
    .param p1, "status"    # Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    .prologue
    .line 180
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$4;->val$holder:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$4;->val$holder:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playerDownloadFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$4;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$4;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {v0, v1, v2, v3}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setProgress(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;)V

    .line 181
    return-void
.end method

.method public bridge synthetic onFileProgressUpdated(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 170
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$4;->onFileProgressUpdated(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method public onFileProgressUpdated(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 3
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 173
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$4;->val$holder:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playerDownloadFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 174
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$4;->val$holder:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$4;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$4;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {v0, p1, v1, v2}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setProgress(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;)V

    .line 176
    :cond_0
    return-void
.end method
