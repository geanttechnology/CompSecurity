.class Lcom/poshmark/ui/fragments/MyLikesFragment$3;
.super Ljava/lang/Object;
.source "MyLikesFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MyLikesFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MyLikesFragment;)V
    .locals 0

    .prologue
    .line 140
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$3;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 8
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
    .line 143
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v6, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$3;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

    # getter for: Lcom/poshmark/ui/fragments/MyLikesFragment;->bundlesAdapter:Lcom/poshmark/data_model/adapters/BundlesAdapter;
    invoke-static {v6}, Lcom/poshmark/ui/fragments/MyLikesFragment;->access$100(Lcom/poshmark/ui/fragments/MyLikesFragment;)Lcom/poshmark/data_model/adapters/BundlesAdapter;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/data_model/adapters/BundlesAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 144
    .local v2, "c":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    add-int/lit8 v6, p3, -0x1

    invoke-virtual {v2, v6}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->moveToPosition(I)Z

    .line 145
    sget-object v6, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v2, v6}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    .line 146
    .local v3, "idCol":I
    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/PMBundle;

    .line 148
    .local v1, "bundle":Lcom/poshmark/data_model/models/PMBundle;
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/poshmark/utils/view_holders/BundleViewHolder;

    .line 149
    .local v5, "viewHolder":Lcom/poshmark/utils/view_holders/BundleViewHolder;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$3;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

    invoke-virtual {v6}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getParentActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v4

    .line 150
    .local v4, "parentActivity":Lcom/poshmark/ui/PMActivity;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 151
    .local v0, "args":Landroid/os/Bundle;
    const-string v6, "ID"

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMBundle;->getSellerId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    const-class v6, Lcom/poshmark/ui/fragments/ViewBundleFragment;

    const/4 v7, 0x0

    invoke-virtual {v4, v0, v6, v7}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 153
    return-void
.end method
