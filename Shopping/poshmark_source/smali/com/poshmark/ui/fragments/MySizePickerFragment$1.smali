.class Lcom/poshmark/ui/fragments/MySizePickerFragment$1;
.super Ljava/lang/Object;
.source "MySizePickerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MySizePickerFragment;->setupClickHandlers()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MySizePickerFragment;)V
    .locals 0

    .prologue
    .line 129
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 132
    new-instance v3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    invoke-direct {v3}, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;-><init>()V

    .line 133
    .local v3, "initInfo":Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->categoryFacetList:Ljava/util/List;

    if-eqz v2, :cond_0

    .line 134
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->categoryFacetList:Ljava/util/List;

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    .line 138
    :goto_0
    const/4 v2, 0x0

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    .line 139
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 140
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "META_ITEM_MODE"

    sget-object v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->CATEGORY_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v4

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 141
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 142
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    const/4 v5, 0x4

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 143
    return-void

    .line 136
    .end local v0    # "parent":Lcom/poshmark/ui/PMActivity;
    .end local v1    # "b":Landroid/os/Bundle;
    :cond_0
    invoke-static {}, Lcom/poshmark/db/DbApi;->getAllCategories()Ljava/util/List;

    move-result-object v2

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    goto :goto_0
.end method
