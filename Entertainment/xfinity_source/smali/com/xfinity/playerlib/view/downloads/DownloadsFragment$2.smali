.class Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$2;
.super Ljava/lang/Object;
.source "DownloadsFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->enableListSelection(Z)V
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
    .line 170
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$2;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
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
    .line 174
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$2;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    # getter for: Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->isEditMode:Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->access$200(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 175
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$2;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    # invokes: Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->showItemAtPosition(I)V
    invoke-static {v0, p3}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->access$300(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;I)V

    .line 177
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$2;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    const/4 v1, 0x0

    invoke-virtual {v0, p3, v1}, Landroid/widget/ListView;->setItemChecked(IZ)V

    .line 181
    :goto_0
    return-void

    .line 179
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$2;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    # invokes: Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->showSelectedCountOnActionMenu()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->access$400(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V

    goto :goto_0
.end method
