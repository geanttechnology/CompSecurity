.class Lcom/poshmark/ui/fragments/AllPartiesFragment$2;
.super Ljava/lang/Object;
.source "AllPartiesFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/AllPartiesFragment;->setupPartyList()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/AllPartiesFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/AllPartiesFragment;)V
    .locals 0

    .prologue
    .line 108
    iput-object p1, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment$2;->this$0:Lcom/poshmark/ui/fragments/AllPartiesFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 8
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
    .line 112
    .local p1, "list":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v7, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment$2;->this$0:Lcom/poshmark/ui/fragments/AllPartiesFragment;

    iget-object v7, v7, Lcom/poshmark/ui/fragments/AllPartiesFragment;->eventListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    invoke-virtual {v7}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getWrappedAdapter()Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersAdapter;

    move-result-object v0

    check-cast v0, Landroid/widget/CursorAdapter;

    .line 113
    .local v0, "adapter":Landroid/widget/CursorAdapter;
    invoke-virtual {v0}, Landroid/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 114
    .local v2, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    invoke-virtual {v2, p3}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->moveToPosition(I)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 115
    sget-object v7, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v2, v7}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    .line 116
    .local v5, "idCol":I
    invoke-virtual {v2, v5}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/PartyEvent;

    .line 118
    .local v3, "event":Lcom/poshmark/data_model/models/PartyEvent;
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v4

    .line 120
    .local v4, "eventId":Ljava/lang/String;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 121
    .local v1, "b":Landroid/os/Bundle;
    const-string v7, "ID"

    invoke-virtual {v1, v7, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    iget-object v7, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment$2;->this$0:Lcom/poshmark/ui/fragments/AllPartiesFragment;

    invoke-virtual {v7}, Lcom/poshmark/ui/fragments/AllPartiesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    check-cast v6, Lcom/poshmark/ui/PMActivity;

    .line 123
    .local v6, "parentActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v6, :cond_1

    invoke-virtual {v6}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 124
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v7

    if-nez v7, :cond_0

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 125
    :cond_0
    const-class v7, Lcom/poshmark/ui/fragments/PartyFragment;

    invoke-virtual {v6, v1, v7, v3}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 131
    .end local v1    # "b":Landroid/os/Bundle;
    .end local v3    # "event":Lcom/poshmark/data_model/models/PartyEvent;
    .end local v4    # "eventId":Ljava/lang/String;
    .end local v5    # "idCol":I
    .end local v6    # "parentActivity":Lcom/poshmark/ui/PMActivity;
    :cond_1
    :goto_0
    return-void

    .line 126
    .restart local v1    # "b":Landroid/os/Bundle;
    .restart local v3    # "event":Lcom/poshmark/data_model/models/PartyEvent;
    .restart local v4    # "eventId":Ljava/lang/String;
    .restart local v5    # "idCol":I
    .restart local v6    # "parentActivity":Lcom/poshmark/ui/PMActivity;
    :cond_2
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isFutureEvent()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 127
    const-class v7, Lcom/poshmark/ui/fragments/PartyInviteFragment;

    invoke-virtual {v6, v1, v7, v3}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    goto :goto_0
.end method
