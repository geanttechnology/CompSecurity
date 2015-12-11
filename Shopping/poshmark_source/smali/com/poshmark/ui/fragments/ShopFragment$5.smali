.class Lcom/poshmark/ui/fragments/ShopFragment$5;
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
    .line 363
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ShopFragment$5;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x1

    .line 366
    new-instance v6, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    invoke-direct {v6}, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;-><init>()V

    .line 367
    .local v6, "initInfo":Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 368
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "META_ITEM_MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->CATEGORY_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 369
    const-string v2, "ENABLE_BROWSE_MODE"

    invoke-virtual {v1, v2, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 370
    const-string v2, "RETURN_RESULT"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 371
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShopFragment$5;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ShopFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 372
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/CategoryListFragment;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShopFragment$5;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 373
    return-void
.end method
