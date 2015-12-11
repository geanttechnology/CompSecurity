.class Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$3;
.super Ljava/lang/Object;
.source "MultiDeleteBrowseFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemLongClickListener;


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


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    .prologue
    .line 173
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$3;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$3;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemLongClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z
    .locals 1
    .param p2, "view"    # Landroid/view/View;
    .param p3, "i"    # I
    .param p4, "l"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)Z"
        }
    .end annotation

    .prologue
    .line 178
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$3;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$3;"
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->isEditMode:Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->access$400(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 179
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    # invokes: Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->startActionMode()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->access$500(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)V

    .line 180
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    # invokes: Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->toggleItem(I)V
    invoke-static {v0, p3}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->access$600(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;I)V

    .line 185
    :goto_0
    const/4 v0, 0x1

    return v0

    .line 182
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    # invokes: Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->toggleItem(I)V
    invoke-static {v0, p3}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->access$600(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;I)V

    goto :goto_0
.end method
