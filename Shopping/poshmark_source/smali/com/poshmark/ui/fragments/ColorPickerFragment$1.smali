.class Lcom/poshmark/ui/fragments/ColorPickerFragment$1;
.super Ljava/lang/Object;
.source "ColorPickerFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ColorPickerFragment;->setupItemSelectionHandler()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ColorPickerFragment;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 9
    .param p2, "view"    # Landroid/view/View;
    .param p3, "index"    # I
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
    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v6, 0x1

    .line 86
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->listView:Landroid/widget/ListView;

    invoke-virtual {v4}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v4

    if-lez v4, :cond_1

    if-nez p3, :cond_1

    .line 87
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-boolean v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->isAllSelected:Z

    if-nez v4, :cond_0

    .line 88
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iput-boolean v6, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->isAllSelected:Z

    .line 89
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/ColorPickerFragment;->headerView:Landroid/view/View;

    # invokes: Lcom/poshmark/ui/fragments/ColorPickerFragment;->setAllOption(ZLandroid/view/View;)V
    invoke-static {v4, v6, v5}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->access$000(Lcom/poshmark/ui/fragments/ColorPickerFragment;ZLandroid/view/View;)V

    .line 90
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    invoke-virtual {v4}, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->clearSelectionList()V

    .line 91
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->adapter:Lcom/poshmark/data_model/adapters/ColorListAdapter;

    invoke-virtual {v4}, Lcom/poshmark/data_model/adapters/ColorListAdapter;->notifyDataSetChanged()V

    .line 92
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iput-boolean v6, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->dataChanged:Z

    .line 94
    :cond_0
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->mode:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    sget-object v5, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_LISTING_FLOW:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    if-eq v4, v5, :cond_1

    .line 95
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->returnData()Z

    .line 98
    :cond_1
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->listView:Landroid/widget/ListView;

    invoke-virtual {v4}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v4

    sub-int/2addr p3, v4

    .line 99
    if-ltz p3, :cond_2

    .line 100
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    iget-object v4, v4, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->selectedColors:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v3

    .line 101
    .local v3, "selectedCount":I
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/PMColor;

    .line 102
    .local v1, "color":Lcom/poshmark/data_model/models/PMColor;
    const v4, 0x7f0c00d3

    invoke-virtual {p2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 103
    .local v0, "checkMark":Landroid/widget/ImageView;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    invoke-virtual {v4, v1}, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->isColorInSelectColorList(Lcom/poshmark/data_model/models/PMColor;)Z

    move-result v2

    .line 105
    .local v2, "isColorCurrentlySelected":Z
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->mode:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    sget-object v5, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_LISTING_FLOW:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    if-ne v4, v5, :cond_6

    .line 106
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->MAX_COUNT:I

    if-ge v3, v4, :cond_4

    .line 108
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iput-boolean v6, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->dataChanged:Z

    .line 109
    if-eqz v2, :cond_3

    .line 110
    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 111
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    invoke-virtual {v4, v1}, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->removeColorFromSelectedColorList(Lcom/poshmark/data_model/models/PMColor;)V

    .line 141
    .end local v0    # "checkMark":Landroid/widget/ImageView;
    .end local v1    # "color":Lcom/poshmark/data_model/models/PMColor;
    .end local v2    # "isColorCurrentlySelected":Z
    .end local v3    # "selectedCount":I
    :cond_2
    :goto_0
    return-void

    .line 113
    .restart local v0    # "checkMark":Landroid/widget/ImageView;
    .restart local v1    # "color":Lcom/poshmark/data_model/models/PMColor;
    .restart local v2    # "isColorCurrentlySelected":Z
    .restart local v3    # "selectedCount":I
    :cond_3
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f02007e

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 114
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    iget-object v4, v4, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->selectedColors:Ljava/util/List;

    invoke-interface {v4, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 117
    :cond_4
    if-eqz v2, :cond_5

    .line 118
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iput-boolean v6, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->dataChanged:Z

    .line 119
    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 120
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    invoke-virtual {v4, v1}, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->removeColorFromSelectedColorList(Lcom/poshmark/data_model/models/PMColor;)V

    goto :goto_0

    .line 122
    :cond_5
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    const-string v5, "You can only select up to %s colors"

    new-array v6, v6, [Ljava/lang/Object;

    iget-object v7, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget v7, v7, Lcom/poshmark/ui/fragments/ColorPickerFragment;->MAX_COUNT:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v8

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->showAutoHideSuccessMessage(Ljava/lang/String;)V

    goto :goto_0

    .line 125
    :cond_6
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->mode:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    sget-object v5, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_FILTER:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    if-ne v4, v5, :cond_7

    .line 126
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iput-boolean v6, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->dataChanged:Z

    .line 127
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iput-boolean v8, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->isAllSelected:Z

    .line 128
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/ColorPickerFragment;->headerView:Landroid/view/View;

    # invokes: Lcom/poshmark/ui/fragments/ColorPickerFragment;->setAllOption(ZLandroid/view/View;)V
    invoke-static {v4, v8, v5}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->access$000(Lcom/poshmark/ui/fragments/ColorPickerFragment;ZLandroid/view/View;)V

    .line 129
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    invoke-virtual {v4}, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->clearSelectionList()V

    .line 130
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    iget-object v4, v4, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->selectedColors:Ljava/util/List;

    invoke-interface {v4, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 131
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->adapter:Lcom/poshmark/data_model/adapters/ColorListAdapter;

    invoke-virtual {v4}, Lcom/poshmark/data_model/adapters/ColorListAdapter;->notifyDataSetChanged()V

    .line 132
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->returnData()Z

    goto :goto_0

    .line 134
    :cond_7
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->mode:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    sget-object v5, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_BROWSE:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    if-ne v4, v5, :cond_2

    .line 136
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iput-boolean v6, v4, Lcom/poshmark/ui/fragments/ColorPickerFragment;->dataChanged:Z

    .line 138
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    # invokes: Lcom/poshmark/ui/fragments/ColorPickerFragment;->fireBrowseWithColor(Lcom/poshmark/data_model/models/PMColor;)V
    invoke-static {v4, v1}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->access$100(Lcom/poshmark/ui/fragments/ColorPickerFragment;Lcom/poshmark/data_model/models/PMColor;)V

    goto/16 :goto_0
.end method
