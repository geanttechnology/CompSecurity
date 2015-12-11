.class Lcom/poshmark/ui/fragments/ShopFragment$4;
.super Ljava/lang/Object;
.source "ShopFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ShopFragment;->setUpButtons()V
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
    .line 345
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ShopFragment$4;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 348
    new-instance v3, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    invoke-direct {v3}, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;-><init>()V

    .line 349
    .local v3, "initInfo":Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;
    iget-object v2, v3, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->allItems:Ljava/util/List;

    invoke-static {}, Lcom/poshmark/db/DbApi;->getBrandsForAllCategories()Ljava/util/List;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 350
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 351
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "SHOW_ALL"

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 352
    const-string v2, "META_ITEM_MODE"

    sget-object v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->BRAND_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v4

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 353
    const-string v2, "SEARCH_ENABLED"

    const/4 v4, 0x1

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 354
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShopFragment$4;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ShopFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 355
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShopFragment$4;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    const/4 v5, 0x2

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 356
    return-void
.end method
