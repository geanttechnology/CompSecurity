.class Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$7;
.super Ljava/lang/Object;
.source "DownloadsFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    .prologue
    .line 400
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$7;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onReady()V
    .locals 2

    .prologue
    .line 403
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$7;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->setEditMode(Z)V

    .line 405
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$7;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$7;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    # getter for: Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->access$900(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getCurrentSortType()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->updateSortButtonStates(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    .line 407
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$7;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->isFileListReady()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 408
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$7;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    # invokes: Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->fetchBookmarksAndUpdateList()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->access$000(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V

    .line 410
    :cond_0
    return-void
.end method
