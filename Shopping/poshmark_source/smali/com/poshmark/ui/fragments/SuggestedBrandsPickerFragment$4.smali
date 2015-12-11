.class Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$4;
.super Ljava/lang/Object;
.source "SuggestedBrandsPickerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->showSuggestedBrands()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;)V
    .locals 0

    .prologue
    .line 275
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$4;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v8, 0x1

    .line 278
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$4;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v5, "brand"

    const-string v6, "view_more_brands_onramp"

    const/4 v7, 0x0

    invoke-virtual {v3, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 279
    new-instance v1, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    invoke-direct {v1}, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;-><init>()V

    .line 280
    .local v1, "initInfo":Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/controllers/GlobalDbController;->getAllBrands()Ljava/util/List;

    move-result-object v3

    iput-object v3, v1, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    .line 281
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 282
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "META_ITEM_MODE"

    sget-object v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->BRAND_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 283
    const-string v3, "SEARCH_ENABLED"

    invoke-virtual {v0, v3, v8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 284
    const-string v3, "BRAND_FOLLOW_BUTTON"

    invoke-virtual {v0, v3, v8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 285
    iget-object v3, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$4;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 286
    .local v2, "parentActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 287
    const-class v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-virtual {v2, v0, v3, v1}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 290
    :cond_0
    return-void
.end method
