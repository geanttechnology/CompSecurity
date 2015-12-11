.class Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;
.super Ljava/lang/Object;
.source "MetaItemListViewFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setupListItemClickListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MetaItemListViewFragment;)V
    .locals 0

    .prologue
    .line 242
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

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
    .line 246
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->listView:Landroid/widget/ListView;

    invoke-virtual {v3}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v3

    if-lez v3, :cond_2

    .line 247
    if-nez p3, :cond_1

    .line 249
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->returnData()V

    .line 313
    :cond_0
    :goto_0
    return-void

    .line 252
    :cond_1
    add-int/lit8 p3, p3, -0x1

    .line 255
    :cond_2
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->searchBox:Landroid/widget/EditText;

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->searchBox:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_4

    .line 256
    if-nez p3, :cond_3

    .line 258
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    new-instance v4, Lcom/poshmark/data_model/models/MetaItem;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->searchBox:Landroid/widget/EditText;

    invoke-virtual {v5}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v6, v6, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->searchBox:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v4, v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 259
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->hideKeyboard()V

    .line 260
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->returnData()V

    goto :goto_0

    .line 262
    :cond_3
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 263
    .local v1, "index":I
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->initInfo:Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    iget-object v3, v3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    invoke-interface {v3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/MetaItem;

    iput-object v3, v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 264
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->hideKeyboard()V

    .line 265
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->returnData()V

    goto :goto_0

    .line 268
    .end local v1    # "index":I
    :cond_4
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->initInfo:Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    iget-object v3, v3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-ge p3, v3, :cond_7

    .line 269
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 270
    .restart local v1    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->initInfo:Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    iget-object v3, v3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    invoke-interface {v3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/MetaItem;

    iput-object v3, v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 271
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-boolean v3, v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->allowMultiSelect:Z

    if-eqz v3, :cond_6

    .line 272
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->multiSelectList:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 273
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->multiSelectList:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 274
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    # invokes: Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->removeCheckMark(Landroid/view/View;)V
    invoke-static {v3, p2}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->access$000(Lcom/poshmark/ui/fragments/MetaItemListViewFragment;Landroid/view/View;)V

    goto/16 :goto_0

    .line 276
    :cond_5
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->multiSelectList:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 277
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    # invokes: Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->showCheckMark(Landroid/view/View;)V
    invoke-static {v3, p2}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->access$100(Lcom/poshmark/ui/fragments/MetaItemListViewFragment;Landroid/view/View;)V

    goto/16 :goto_0

    .line 280
    :cond_6
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->returnData()V

    goto/16 :goto_0

    .line 282
    .end local v1    # "index":I
    :cond_7
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->listView:Landroid/widget/ListView;

    invoke-virtual {v3}, Landroid/widget/ListView;->getFooterViewsCount()I

    move-result v3

    if-nez v3, :cond_0

    .line 284
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v0, v3}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 285
    .local v0, "alert":Landroid/app/AlertDialog$Builder;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    const v4, 0x7f060032

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 286
    const-string v3, ""

    invoke-virtual {v0, v3}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 289
    new-instance v2, Landroid/widget/EditText;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/widget/EditText;-><init>(Landroid/content/Context;)V

    .line 290
    .local v2, "input":Landroid/widget/EditText;
    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 292
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    const v4, 0x7f0601e1

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2$1;

    invoke-direct {v4, p0, v2}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2$1;-><init>(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;Landroid/widget/EditText;)V

    invoke-virtual {v0, v3, v4}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 301
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    const v4, 0x7f06006d

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2$2;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2$2;-><init>(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;)V

    invoke-virtual {v0, v3, v4}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 309
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 310
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->showKeyboard()V

    goto/16 :goto_0
.end method
