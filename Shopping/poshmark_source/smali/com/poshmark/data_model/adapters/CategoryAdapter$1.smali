.class Lcom/poshmark/data_model/adapters/CategoryAdapter$1;
.super Ljava/lang/Object;
.source "CategoryAdapter.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/data_model/adapters/CategoryAdapter;->setupListItemClickListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/adapters/CategoryAdapter;)V
    .locals 0

    .prologue
    .line 95
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
    .param p2, "view"    # Landroid/view/View;
    .param p3, "i"    # I
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
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v2, 0x1

    .line 99
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    iget-object v1, v1, Lcom/poshmark/data_model/adapters/CategoryAdapter;->parentListView:Landroid/widget/ListView;

    invoke-virtual {v1}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v1

    if-lez v1, :cond_1

    if-nez p3, :cond_1

    .line 100
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    iget-boolean v1, v1, Lcom/poshmark/data_model/adapters/CategoryAdapter;->isAllSelected:Z

    if-nez v1, :cond_0

    .line 101
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    iput-boolean v2, v1, Lcom/poshmark/data_model/adapters/CategoryAdapter;->isAllSelected:Z

    .line 102
    :cond_0
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    iget-object v2, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    iget-boolean v2, v2, Lcom/poshmark/data_model/adapters/CategoryAdapter;->isAllSelected:Z

    # invokes: Lcom/poshmark/data_model/adapters/CategoryAdapter;->setAllItemsRowState(Landroid/view/View;Z)V
    invoke-static {v1, p2, v2}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->access$000(Lcom/poshmark/data_model/adapters/CategoryAdapter;Landroid/view/View;Z)V

    .line 103
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    # invokes: Lcom/poshmark/data_model/adapters/CategoryAdapter;->removeAllSelections()V
    invoke-static {v1}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->access$100(Lcom/poshmark/data_model/adapters/CategoryAdapter;)V

    .line 104
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    invoke-virtual {v1}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->notifyDataSetChanged()V

    .line 105
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    iget-object v1, v1, Lcom/poshmark/data_model/adapters/CategoryAdapter;->fragment:Lcom/poshmark/ui/fragments/CategoryListFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/CategoryListFragment;->allItemSelected()V

    .line 121
    :goto_0
    return-void

    .line 107
    :cond_1
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    iget-object v1, v1, Lcom/poshmark/data_model/adapters/CategoryAdapter;->parentListView:Landroid/widget/ListView;

    invoke-virtual {v1}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v1

    sub-int/2addr p3, v1

    .line 109
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    iget-object v1, v1, Lcom/poshmark/data_model/adapters/CategoryAdapter;->info:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->categoryFacetList:Ljava/util/List;

    invoke-interface {v1, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/MetaItem;

    .line 112
    .local v0, "selectedCategory":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    iget-object v1, v1, Lcom/poshmark/data_model/adapters/CategoryAdapter;->info:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    if-nez v1, :cond_2

    .line 113
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    iput-boolean v2, v1, Lcom/poshmark/data_model/adapters/CategoryAdapter;->isAllSelected:Z

    .line 114
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    iget-object v2, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    iget-object v2, v2, Lcom/poshmark/data_model/adapters/CategoryAdapter;->fragment:Lcom/poshmark/ui/fragments/CategoryListFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getListHeaderView()Landroid/view/View;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    iget-boolean v3, v3, Lcom/poshmark/data_model/adapters/CategoryAdapter;->isAllSelected:Z

    # invokes: Lcom/poshmark/data_model/adapters/CategoryAdapter;->setAllItemsRowState(Landroid/view/View;Z)V
    invoke-static {v1, v2, v3}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->access$000(Lcom/poshmark/data_model/adapters/CategoryAdapter;Landroid/view/View;Z)V

    .line 119
    :goto_1
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    iget-object v1, v1, Lcom/poshmark/data_model/adapters/CategoryAdapter;->fragment:Lcom/poshmark/ui/fragments/CategoryListFragment;

    invoke-virtual {v1, v0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->itemSelected(Lcom/poshmark/data_model/models/MetaItem;)V

    goto :goto_0

    .line 117
    :cond_2
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    invoke-virtual {v1}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->notifyDataSetChanged()V

    goto :goto_1
.end method
