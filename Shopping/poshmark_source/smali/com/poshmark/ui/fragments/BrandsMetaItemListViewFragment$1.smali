.class Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;
.super Ljava/lang/Object;
.source "BrandsMetaItemListViewFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->setupListItemClickListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;)V
    .locals 0

    .prologue
    .line 219
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 7
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
    .line 223
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->stickyListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    invoke-virtual {v4}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getHeaderViewsCount()I

    move-result v4

    sub-int/2addr p3, v4

    .line 225
    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget v0, v4, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->recentItemsCount:I

    .line 227
    .local v0, "actualItemCount":I
    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    const/4 v5, 0x1

    iput-boolean v5, v4, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->itemClick:Z

    .line 229
    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    iget-object v4, v4, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->allItems:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    add-int/2addr v4, v0

    if-ge p3, v4, :cond_4

    .line 230
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 232
    .local v2, "index":I
    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchText:Ljava/lang/String;

    if-eqz v4, :cond_1

    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchText:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_1

    .line 233
    iget-object v5, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    iget-object v4, v4, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->allItems:Ljava/util/List;

    invoke-interface {v4, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/MetaItem;

    iput-object v4, v5, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 246
    :goto_0
    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    iput-object v5, v4, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    .line 247
    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    iget-object v4, v4, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v4, :cond_0

    .line 248
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    iget-object v5, v5, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v4, v5}, Lcom/poshmark/controllers/GlobalDbController;->addBrandToRecents(Lcom/poshmark/data_model/models/MetaItem;)V

    .line 251
    :cond_0
    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->returnData()V

    .line 283
    .end local v2    # "index":I
    :goto_1
    return-void

    .line 236
    .restart local v2    # "index":I
    :cond_1
    if-lez v0, :cond_3

    .line 237
    if-ge v2, v0, :cond_2

    .line 238
    iget-object v5, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->recentItems:Ljava/util/ArrayList;

    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/MetaItem;

    iput-object v4, v5, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    goto :goto_0

    .line 240
    :cond_2
    iget-object v5, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    iget-object v4, v4, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->allItems:Ljava/util/List;

    sub-int v6, v2, v0

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/MetaItem;

    iput-object v4, v5, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    goto :goto_0

    .line 242
    :cond_3
    iget-object v5, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    iget-object v4, v4, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->allItems:Ljava/util/List;

    invoke-interface {v4, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/MetaItem;

    iput-object v4, v5, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    goto :goto_0

    .line 255
    .end local v2    # "index":I
    :cond_4
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-direct {v1, v4}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 256
    .local v1, "alert":Landroid/app/AlertDialog$Builder;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    const v5, 0x7f060032

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 257
    const-string v4, ""

    invoke-virtual {v1, v4}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 260
    new-instance v3, Landroid/widget/EditText;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-direct {v3, v4}, Landroid/widget/EditText;-><init>(Landroid/content/Context;)V

    .line 261
    .local v3, "input":Landroid/widget/EditText;
    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 263
    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    const v5, 0x7f0601e1

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-instance v5, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1$1;

    invoke-direct {v5, p0, v3}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1$1;-><init>(Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;Landroid/widget/EditText;)V

    invoke-virtual {v1, v4, v5}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 272
    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    const v5, 0x7f06006d

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-instance v5, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1$2;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1$2;-><init>(Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;)V

    invoke-virtual {v1, v4, v5}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 280
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 281
    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->showKeyboard()V

    goto/16 :goto_1
.end method
