.class Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$4;
.super Ljava/lang/Object;
.source "MultiDeleteBrowseFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->setupListView(Landroid/widget/AbsListView;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

.field wrappedItemClickListener:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)V
    .locals 1
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    .prologue
    .line 193
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$4;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$4;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$4;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 195
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$4;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->getItemClickListener()Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$4;->wrappedItemClickListener:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener;

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
    .param p2, "view"    # Landroid/view/View;
    .param p3, "pos"    # I
    .param p4, "l"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 200
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$4;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$4;"
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$4;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->isEditMode:Z
    invoke-static {v1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->access$700(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 202
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$4;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    # invokes: Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->uncheckAll()V
    invoke-static {v1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->access$800(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)V

    .line 203
    invoke-virtual {p1, p3}, Landroid/widget/AdapterView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v1}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 205
    .local v0, "item":Ljava/lang/Object;, "TT;"
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$4;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    iget-boolean v1, v1, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->inBabyGuideMode:Z

    if-eqz v1, :cond_0

    if-nez v0, :cond_0

    .line 215
    .end local v0    # "item":Ljava/lang/Object;, "TT;"
    :goto_0
    return-void

    .line 209
    .restart local v0    # "item":Ljava/lang/Object;, "TT;"
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$4;->wrappedItemClickListener:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener;

    invoke-interface {v1, v0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener;->onItemClicked(Ljava/lang/Object;)V

    goto :goto_0

    .line 213
    .end local v0    # "item":Ljava/lang/Object;, "TT;"
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$4;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    # invokes: Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->showSelectedCountOnActionMenu()V
    invoke-static {v1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->access$900(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)V

    goto :goto_0
.end method
