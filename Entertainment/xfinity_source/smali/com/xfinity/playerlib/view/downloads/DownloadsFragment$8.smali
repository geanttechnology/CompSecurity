.class Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$8;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "DownloadsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->fetchBookmarksAndUpdateList()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple",
        "<",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        "Ljava/util/Map",
        "<",
        "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
        "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
        ">;>;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

.field final synthetic val$files:Ljava/util/List;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;Ljava/util/List;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    .prologue
    .line 637
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$8;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$8;->val$files:Ljava/util/List;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 0
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 662
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 646
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$8;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsAdapter:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->setNotifyOnChange(Z)V

    .line 647
    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$8;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsAdapter:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->clear()V

    .line 648
    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$8;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iget-object v2, v1, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsAdapter:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    check-cast v1, Ljava/util/Map;

    invoke-virtual {v2, v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->setVideoBookmarks(Ljava/util/Map;)V

    .line 649
    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$8;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iget-object v2, v1, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsAdapter:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    check-cast v1, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-virtual {v2, v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->setVideoEntitlement(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    .line 650
    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$8;->val$files:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 652
    .local v0, "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$8;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsAdapter:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    invoke-virtual {v2, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->add(Ljava/lang/Object;)V

    goto :goto_0

    .line 654
    .end local v0    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$8;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->applySort()V

    .line 656
    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$8;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    # getter for: Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->access$1000(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->ACCESSIBILITY_ANNOUNCE_LOADED:I

    invoke-interface {v1, v2}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 657
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 637
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$8;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V

    return-void
.end method

.method public onPreAsynchronousExecute()V
    .locals 2

    .prologue
    .line 641
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$8;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    # getter for: Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->access$1000(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->loading:I

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 642
    return-void
.end method
