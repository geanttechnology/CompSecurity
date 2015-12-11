.class Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$1;
.super Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;
.source "DownloadsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;
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
.field final synthetic this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    .prologue
    .line 130
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$1;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    invoke-direct {p0}, Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onDownloadEngineStatusChanged(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V
    .locals 1
    .param p1, "status"    # Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    .prologue
    .line 138
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$1;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->updatePauseButton()V

    .line 139
    return-void
.end method

.method public bridge synthetic onFileDownloadFinished(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 130
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$1;->onFileDownloadFinished(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method public onFileDownloadFinished(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 1
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 150
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$1;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->applySort()V

    .line 151
    return-void
.end method

.method public bridge synthetic onFileDownloadStarted(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 130
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$1;->onFileDownloadStarted(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method public onFileDownloadStarted(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 1
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 144
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$1;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->applySort()V

    .line 145
    return-void
.end method

.method public onFileListUpdated()V
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$1;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    # invokes: Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->fetchBookmarksAndUpdateList()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->access$000(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V

    .line 134
    return-void
.end method
