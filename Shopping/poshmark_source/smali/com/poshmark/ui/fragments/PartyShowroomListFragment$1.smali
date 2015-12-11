.class Lcom/poshmark/ui/fragments/PartyShowroomListFragment$1;
.super Ljava/lang/Object;
.source "PartyShowroomListFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->setupList()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PartyShowroomListFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PartyShowroomListFragment;)V
    .locals 0

    .prologue
    .line 85
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$1;->this$0:Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 7
    .param p2, "arg1"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "rowId"    # J
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
    .line 89
    .local p1, "list":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$1;->this$0:Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

    # getter for: Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->listView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;
    invoke-static {v5}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->access$000(Lcom/poshmark/ui/fragments/PartyShowroomListFragment;)Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    move-result-object v5

    invoke-virtual {v5}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getWrappedAdapter()Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersAdapter;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/CursorAdapter;

    .line 90
    .local v0, "adapter":Landroid/support/v4/widget/CursorAdapter;
    invoke-virtual {v0}, Landroid/support/v4/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 91
    .local v3, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    add-int/lit8 v5, p3, -0x1

    invoke-virtual {v3, v5}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->moveToPosition(I)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 94
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 95
    .local v1, "b":Landroid/os/Bundle;
    const-string v5, "SHOWROOM_INDEX"

    add-int/lit8 v6, p3, -0x1

    invoke-virtual {v1, v5, v6}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 96
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$1;->this$0:Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

    invoke-virtual {v5}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/fragments/PMFragment;

    .line 97
    .local v2, "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v2, :cond_0

    .line 98
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$1;->this$0:Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

    invoke-virtual {v5}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->getTargetRequestCode()I

    move-result v4

    .line 99
    .local v4, "requestCode":I
    invoke-virtual {v2, v1, v4}, Lcom/poshmark/ui/fragments/PMFragment;->onFragmentResult(Landroid/os/Bundle;I)V

    .line 102
    .end local v4    # "requestCode":I
    :cond_0
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$1;->this$0:Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

    invoke-virtual {v5}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->dismiss()V

    .line 104
    .end local v1    # "b":Landroid/os/Bundle;
    .end local v2    # "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    :cond_1
    return-void
.end method
