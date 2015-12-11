.class Lcom/poshmark/data_model/adapters/SubCategoryAdapter$1;
.super Ljava/lang/Object;
.source "SubCategoryAdapter.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->setupListItemClickListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/data_model/adapters/SubCategoryAdapter;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/adapters/SubCategoryAdapter;)V
    .locals 0

    .prologue
    .line 101
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/SubCategoryAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
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
    .line 105
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/SubCategoryAdapter;

    iget-object v1, v1, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->parentListView:Landroid/widget/ListView;

    invoke-virtual {v1}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v1

    if-lez v1, :cond_0

    if-nez p3, :cond_0

    .line 106
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/SubCategoryAdapter;

    iget-object v1, v1, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->fragment:Lcom/poshmark/ui/fragments/SubCategoryListFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->allItemSelected()V

    .line 120
    :goto_0
    return-void

    .line 108
    :cond_0
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/SubCategoryAdapter;

    iget-object v1, v1, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->parentListView:Landroid/widget/ListView;

    invoke-virtual {v1}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v1

    sub-int/2addr p3, v1

    .line 111
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/SubCategoryAdapter;

    iget-object v1, v1, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->info:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    invoke-interface {v1, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/MetaItem;

    .line 112
    .local v0, "subCategory":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/SubCategoryAdapter;

    iget-object v1, v1, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->fragment:Lcom/poshmark/ui/fragments/SubCategoryListFragment;

    invoke-virtual {v1, v0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->itemSelected(Lcom/poshmark/data_model/models/MetaItem;)V

    goto :goto_0
.end method
