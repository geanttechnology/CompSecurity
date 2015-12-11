.class Lcom/poshmark/ui/fragments/ShopFragment$3;
.super Ljava/lang/Object;
.source "ShopFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ShopFragment;->setupShowroomList()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ShopFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ShopFragment;)V
    .locals 0

    .prologue
    .line 268
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ShopFragment$3;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

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
    .line 272
    .local p1, "list":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ShopFragment$3;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    iget-object v7, v7, Lcom/poshmark/ui/fragments/ShopFragment;->showroomListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    invoke-virtual {v7}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getWrappedAdapter()Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersAdapter;

    move-result-object v0

    check-cast v0, Landroid/widget/CursorAdapter;

    .line 273
    .local v0, "adapter":Landroid/widget/CursorAdapter;
    invoke-virtual {v0}, Landroid/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 274
    .local v2, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    if-eqz v2, :cond_0

    add-int/lit8 v7, p3, -0x1

    invoke-virtual {v2, v7}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->moveToPosition(I)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 275
    sget-object v7, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v2, v7}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    .line 276
    .local v3, "idCol":I
    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/poshmark/data_model/models/Showroom;

    .line 277
    .local v5, "showroom":Lcom/poshmark/data_model/models/Showroom;
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/Showroom;->getId()Ljava/lang/String;

    move-result-object v6

    .line 279
    .local v6, "showroomId":Ljava/lang/String;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 280
    .local v1, "b":Landroid/os/Bundle;
    const-string v7, "ID"

    invoke-virtual {v1, v7, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 281
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ShopFragment$3;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    invoke-virtual {v7}, Lcom/poshmark/ui/fragments/ShopFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/PMActivity;

    .line 282
    .local v4, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v7, Lcom/poshmark/ui/fragments/ShowroomFragment;

    invoke-virtual {v4, v1, v7, v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 284
    .end local v1    # "b":Landroid/os/Bundle;
    .end local v3    # "idCol":I
    .end local v4    # "parentActivity":Lcom/poshmark/ui/PMActivity;
    .end local v5    # "showroom":Lcom/poshmark/data_model/models/Showroom;
    .end local v6    # "showroomId":Ljava/lang/String;
    :cond_0
    return-void
.end method
