.class Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$4;
.super Ljava/lang/Object;
.source "DownloadsFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemLongClickListener;


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
    .line 319
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$4;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemLongClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z
    .locals 1
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
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
    .line 322
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$4;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    # getter for: Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->isEditMode:Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->access$200(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 323
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$4;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    # invokes: Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->startActionMode()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->access$600(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V

    .line 324
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$4;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    # invokes: Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->selectItem(I)V
    invoke-static {v0, p3}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->access$700(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;I)V

    .line 330
    :goto_0
    const/4 v0, 0x1

    return v0

    .line 327
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$4;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    # invokes: Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->selectItem(I)V
    invoke-static {v0, p3}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->access$700(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;I)V

    goto :goto_0
.end method
