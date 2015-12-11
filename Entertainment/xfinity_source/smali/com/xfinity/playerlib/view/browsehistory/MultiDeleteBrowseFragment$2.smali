.class Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;
.super Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;
.source "MultiDeleteBrowseFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->onResumeInternal()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener",
        "<TD;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;
    .param p3, "x1"    # Landroid/content/Context;
    .param p4, "x2"    # Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    .param p5, "x3"    # Landroid/content/DialogInterface$OnCancelListener;

    .prologue
    .line 109
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;"
    .local p2, "x0":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<TD;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    invoke-direct {p0, p2, p3, p4, p5}, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;)V

    return-void
.end method


# virtual methods
.method public onPostExecute(Ljava/lang/Object;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    .prologue
    .line 117
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;"
    .local p1, "data":Ljava/lang/Object;, "TD;"
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    invoke-virtual {v1, p1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->onResourceFetched(Ljava/lang/Object;)V

    .line 119
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->isEditMode:Z
    invoke-static {v1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->access$000(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 120
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->checkedItemPositionsToRestore:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->access$100(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 121
    .local v0, "i":I
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->absListView:Landroid/widget/AbsListView;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->access$200(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)Landroid/widget/AbsListView;

    move-result-object v1

    const/4 v3, 0x1

    invoke-virtual {v1, v0, v3}, Landroid/widget/AbsListView;->setItemChecked(IZ)V

    goto :goto_0

    .line 124
    .end local v0    # "i":I
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    # invokes: Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->showSelectedCountOnActionMenu()V
    invoke-static {v1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->access$300(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)V

    .line 127
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    invoke-interface {v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->ACCESSIBILITY_ANNOUNCE_LOADED:I

    invoke-interface {v1, v2}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 128
    return-void
.end method

.method public onPreAsynchronousExecute()V
    .locals 2

    .prologue
    .line 112
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->loading:I

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 113
    return-void
.end method
