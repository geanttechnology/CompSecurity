.class public Lcom/poshmark/ui/fragments/ListingFiltersFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "ListingFiltersFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# instance fields
.field availabilityValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

.field brandValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

.field categoryValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

.field colorValuesImageContainer:Landroid/widget/LinearLayout;

.field conditionValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

.field createdFromSavedState:Z

.field currentAvailabilityItem:Lcom/poshmark/data_model/models/MetaItem;

.field currentBrandItem:Lcom/poshmark/data_model/models/MetaItem;

.field currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

.field currentColors:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;"
        }
    .end annotation
.end field

.field currentConditionItem:Lcom/poshmark/data_model/models/MetaItem;

.field currentPrices:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PriceInfo;",
            ">;"
        }
    .end annotation
.end field

.field currentSizes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field currentSubCategories:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field dividerView:Landroid/view/View;

.field isG2FiltersEnabled:Z

.field isInitialized:Z

.field isMySizeSelected:Z

.field parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

.field priceValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

.field sizeValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

.field styleValueTextView:Lcom/poshmark/ui/customviews/PMTextView;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 63
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSizes:Ljava/util/List;

    .line 64
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentPrices:Ljava/util/List;

    .line 65
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSubCategories:Ljava/util/List;

    .line 66
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentColors:Ljava/util/List;

    .line 72
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->isMySizeSelected:Z

    .line 73
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->createdFromSavedState:Z

    .line 74
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->isInitialized:Z

    .line 75
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->isG2FiltersEnabled:Z

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingFiltersFragment;

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->fireSearch()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingFiltersFragment;

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->launchBrandSelection()V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingFiltersFragment;

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->launchConditionSelection()V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingFiltersFragment;

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->launchAvailabilitySelection()V

    return-void
.end method

.method private fireSearch()V
    .locals 12

    .prologue
    const/4 v11, 0x1

    const/4 v9, 0x0

    .line 813
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v5

    .line 815
    .local v5, "searchFilter":Lcom/poshmark/utils/SearchFilterModel;
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v7}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v7

    iget-object v8, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSizes:Ljava/util/List;

    invoke-virtual {v7, v8}, Lcom/poshmark/utils/FilterResultsManager;->updateSizes(Ljava/util/List;)V

    .line 816
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v7}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v7

    iget-object v8, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentPrices:Ljava/util/List;

    invoke-virtual {v7, v8}, Lcom/poshmark/utils/FilterResultsManager;->updatePrices(Ljava/util/List;)V

    .line 817
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v7}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v7

    iget-object v8, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSubCategories:Ljava/util/List;

    invoke-virtual {v7, v8}, Lcom/poshmark/utils/FilterResultsManager;->updateSubCatogories(Ljava/util/List;)V

    .line 818
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v7}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v7

    iget-object v8, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentColors:Ljava/util/List;

    invoke-virtual {v7, v8}, Lcom/poshmark/utils/FilterResultsManager;->updateColors(Ljava/util/List;)V

    .line 820
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v7, :cond_2

    .line 821
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Lcom/poshmark/utils/SearchFilterModel;->setCategory(Ljava/lang/String;)V

    .line 827
    :goto_0
    invoke-virtual {v5}, Lcom/poshmark/utils/SearchFilterModel;->clearBrand()V

    .line 828
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentBrandItem:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v7, :cond_0

    .line 829
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentBrandItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Lcom/poshmark/utils/SearchFilterModel;->setBrand(Ljava/lang/String;)V

    .line 832
    :cond_0
    iget-boolean v7, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->isMySizeSelected:Z

    if-eqz v7, :cond_3

    .line 833
    invoke-virtual {v5}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v7

    invoke-virtual {v7, v11}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->enableMySize(Z)V

    .line 838
    :goto_1
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentConditionItem:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v7, :cond_4

    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentConditionItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v7

    const-string v8, "not_nwt"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_4

    .line 839
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentConditionItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Lcom/poshmark/utils/SearchFilterModel;->setCondition(Ljava/lang/String;)V

    .line 844
    :goto_2
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentAvailabilityItem:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v7, :cond_5

    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentAvailabilityItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v7

    const v8, 0x7f060040

    invoke-virtual {p0, v8}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_5

    .line 845
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentAvailabilityItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    .line 850
    :goto_3
    invoke-virtual {v5}, Lcom/poshmark/utils/SearchFilterModel;->getLabelForAnalytics()Ljava/lang/String;

    move-result-object v2

    .line 851
    .local v2, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v7

    iget-object v8, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v9, "listing"

    const-string v10, "filter_applied"

    invoke-virtual {v7, v8, v9, v10, v2}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 856
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->fragmentType:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    sget-object v8, Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;->DRAWER:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    if-ne v7, v8, :cond_6

    .line 857
    const-string v7, "com.poshmark.intents.SEARCH_FILTER_ACTION"

    invoke-static {v7}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 874
    :cond_1
    :goto_4
    return-void

    .line 824
    .end local v2    # "label":Ljava/lang/String;
    :cond_2
    invoke-virtual {v5}, Lcom/poshmark/utils/SearchFilterModel;->clearCategory()V

    goto :goto_0

    .line 835
    :cond_3
    invoke-virtual {v5}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v7

    invoke-virtual {v7, v9}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->enableMySize(Z)V

    goto :goto_1

    .line 841
    :cond_4
    invoke-virtual {v5}, Lcom/poshmark/utils/SearchFilterModel;->clearCondition()V

    goto :goto_2

    .line 847
    :cond_5
    invoke-virtual {v5, v9}, Lcom/poshmark/utils/SearchFilterModel;->enableUnsoldOption(Z)V

    goto :goto_3

    .line 859
    .restart local v2    # "label":Ljava/lang/String;
    :cond_6
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v6

    check-cast v6, Lcom/poshmark/ui/fragments/PMFragment;

    .line 860
    .local v6, "targetFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v6, :cond_1

    .line 861
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 862
    .local v0, "b":Landroid/os/Bundle;
    const-string v7, "FILTERS_CHANGED"

    invoke-virtual {v0, v7, v11}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 863
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 864
    .local v1, "intent":Landroid/content/Intent;
    const-string v7, "RETURNED_RESULTS"

    invoke-virtual {v1, v7, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 865
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getTargetRequestCode()I

    move-result v4

    .line 866
    .local v4, "requestCode":I
    const/4 v7, -0x1

    invoke-virtual {v6, v4, v7, v1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 867
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    .line 868
    .local v3, "parent":Landroid/app/Activity;
    if-eqz v3, :cond_1

    .line 869
    invoke-virtual {v3}, Landroid/app/Activity;->onBackPressed()V

    goto :goto_4
.end method

.method private getCommaSeparatedPrices()Ljava/lang/String;
    .locals 5

    .prologue
    .line 258
    const-string v2, ""

    .line 259
    .local v2, "price":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentPrices:Ljava/util/List;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentPrices:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_1

    .line 260
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentPrices:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 261
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PriceInfo;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 262
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/PriceInfo;

    .line 263
    .local v1, "pInfo":Lcom/poshmark/data_model/models/PriceInfo;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PriceInfo;->getDisplay()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 264
    goto :goto_0

    .end local v1    # "pInfo":Lcom/poshmark/data_model/models/PriceInfo;
    :cond_0
    move-object v3, v2

    .line 269
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PriceInfo;>;"
    :goto_1
    return-object v3

    :cond_1
    const-string v3, ""

    goto :goto_1
.end method

.method private launchAvailabilitySelection()V
    .locals 8

    .prologue
    .line 585
    new-instance v3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    invoke-direct {v3}, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;-><init>()V

    .line 586
    .local v3, "info":Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->AVAILABILITY_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    .line 587
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentAvailabilityItem:Lcom/poshmark/data_model/models/MetaItem;

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    .line 589
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 590
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "META_ITEM_MODE"

    sget-object v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->AVAILABILITY_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v4

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 591
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 592
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    const/4 v5, 0x6

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 593
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v5, "listing"

    const-string v6, "filter_clicked"

    const-string v7, "inventory_status"

    invoke-virtual {v2, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 594
    return-void
.end method

.method private launchBrandSelection()V
    .locals 8

    .prologue
    const/4 v5, 0x1

    .line 469
    new-instance v3, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    invoke-direct {v3}, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;-><init>()V

    .line 470
    .local v3, "initInfo":Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;
    iget-object v2, v3, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->allItems:Ljava/util/List;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getBrandsFacetList()Ljava/util/List;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 471
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentBrandItem:Lcom/poshmark/data_model/models/MetaItem;

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    .line 472
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 473
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "SEARCH_ENABLED"

    invoke-virtual {v1, v2, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 474
    const-string v2, "RETURN_RESULT"

    invoke-virtual {v1, v2, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 475
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->allowFilteringOnAllBrands()Z

    move-result v2

    if-nez v2, :cond_0

    .line 476
    const-string v2, "SHOW_ALL"

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 478
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 479
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    const/4 v5, 0x3

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 480
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v5, "listing"

    const-string v6, "filter_clicked"

    const-string v7, "brand"

    invoke-virtual {v2, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 481
    return-void
.end method

.method private launchConditionSelection()V
    .locals 8

    .prologue
    .line 573
    new-instance v3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    invoke-direct {v3}, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;-><init>()V

    .line 574
    .local v3, "info":Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->CONDITION_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    .line 575
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentConditionItem:Lcom/poshmark/data_model/models/MetaItem;

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    .line 577
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 578
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "META_ITEM_MODE"

    sget-object v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->CONDITION_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v4

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 579
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 580
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    const/4 v5, 0x5

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 581
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v5, "listing"

    const-string v6, "filter_clicked"

    const-string v7, "condition"

    invoke-virtual {v2, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 582
    return-void
.end method

.method private prefillSearchOptions(Lcom/poshmark/utils/SearchFilterModel;Z)V
    .locals 14
    .param p1, "model"    # Lcom/poshmark/utils/SearchFilterModel;
    .param p2, "savedState"    # Z

    .prologue
    .line 411
    iget-boolean v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->isInitialized:Z

    if-eqz v12, :cond_0

    .line 466
    :goto_0
    return-void

    .line 414
    :cond_0
    invoke-virtual {p1}, Lcom/poshmark/utils/SearchFilterModel;->getCategory()Ljava/lang/String;

    move-result-object v1

    .line 415
    .local v1, "category":Ljava/lang/String;
    if-eqz v1, :cond_1

    .line 416
    invoke-static {v1}, Lcom/poshmark/db/DbApi;->getCurrentCategoryFromId(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v12

    iput-object v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 419
    :cond_1
    invoke-virtual {p1}, Lcom/poshmark/utils/SearchFilterModel;->getBrand()Ljava/lang/String;

    move-result-object v0

    .line 420
    .local v0, "brandName":Ljava/lang/String;
    if-eqz v0, :cond_2

    .line 421
    invoke-static {v0}, Lcom/poshmark/db/DbApi;->getBrandItemFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v12

    iput-object v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentBrandItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 424
    :cond_2
    iget-object v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v12}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v12

    invoke-virtual {v12}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentSubCategories()Ljava/util/List;

    move-result-object v11

    .line 425
    .local v11, "subCategories":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    if-eqz v11, :cond_3

    .line 426
    invoke-interface {v11}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .line 427
    .local v4, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_3

    .line 428
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/poshmark/data_model/models/MetaItem;

    .line 429
    .local v9, "size":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSubCategories:Ljava/util/List;

    invoke-static {v9}, Lcom/poshmark/data_model/models/MetaItem;->clone(Lcom/poshmark/data_model/models/MetaItem;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v13

    invoke-interface {v12, v13}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 433
    .end local v4    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    .end local v9    # "size":Lcom/poshmark/data_model/models/MetaItem;
    :cond_3
    iget-object v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v12}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v12

    invoke-virtual {v12}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentColorSelections()Ljava/util/List;

    move-result-object v3

    .line 434
    .local v3, "colors":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    if-eqz v3, :cond_4

    .line 435
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .line 436
    .local v5, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    :goto_2
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_4

    .line 437
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/PMColor;

    .line 438
    .local v2, "color":Lcom/poshmark/data_model/models/PMColor;
    iget-object v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentColors:Ljava/util/List;

    invoke-static {v2}, Lcom/poshmark/data_model/models/PMColor;->clone(Lcom/poshmark/data_model/models/PMColor;)Lcom/poshmark/data_model/models/PMColor;

    move-result-object v13

    invoke-interface {v12, v13}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 442
    .end local v2    # "color":Lcom/poshmark/data_model/models/PMColor;
    .end local v5    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    :cond_4
    iget-object v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v12}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v12

    invoke-virtual {v12}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentSizeSelections()Ljava/util/List;

    move-result-object v10

    .line 443
    .local v10, "sizeList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    if-eqz v10, :cond_5

    .line 444
    invoke-interface {v10}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .line 445
    .restart local v4    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :goto_3
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_5

    .line 446
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/poshmark/data_model/models/MetaItem;

    .line 447
    .restart local v9    # "size":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSizes:Ljava/util/List;

    invoke-static {v9}, Lcom/poshmark/data_model/models/MetaItem;->clone(Lcom/poshmark/data_model/models/MetaItem;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v13

    invoke-interface {v12, v13}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 451
    .end local v4    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    .end local v9    # "size":Lcom/poshmark/data_model/models/MetaItem;
    :cond_5
    iget-object v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v12}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v12

    invoke-virtual {v12}, Lcom/poshmark/utils/FilterResultsManager;->isMySizeEnabled()Z

    move-result v12

    iput-boolean v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->isMySizeSelected:Z

    .line 453
    iget-object v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v12}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v12

    invoke-virtual {v12}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentPriceSelections()Ljava/util/List;

    move-result-object v8

    .line 454
    .local v8, "priceList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PriceInfo;>;"
    if-eqz v8, :cond_6

    .line 455
    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .line 456
    .local v6, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PriceInfo;>;"
    :goto_4
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_6

    .line 457
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/poshmark/data_model/models/PriceInfo;

    .line 458
    .local v7, "priceInfo":Lcom/poshmark/data_model/models/PriceInfo;
    iget-object v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentPrices:Ljava/util/List;

    invoke-interface {v12, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 462
    .end local v6    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PriceInfo;>;"
    .end local v7    # "priceInfo":Lcom/poshmark/data_model/models/PriceInfo;
    :cond_6
    iget-object v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v12}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v12

    invoke-virtual {v12}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentAvailability()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v12

    iput-object v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentAvailabilityItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 463
    iget-object v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v12}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v12

    invoke-virtual {v12}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentCondition()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v12

    iput-object v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentConditionItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 465
    const/4 v12, 0x1

    iput-boolean v12, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->isInitialized:Z

    goto/16 :goto_0
.end method

.method private setup(Lcom/poshmark/utils/SearchFilterModel;Z)V
    .locals 0
    .param p1, "model"    # Lcom/poshmark/utils/SearchFilterModel;
    .param p2, "savedState"    # Z

    .prologue
    .line 405
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->prefillSearchOptions(Lcom/poshmark/utils/SearchFilterModel;Z)V

    .line 406
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->updateView()V

    .line 407
    return-void
.end method

.method private setupView(Landroid/view/View;)V
    .locals 25
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 707
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    const/high16 v22, 0x41f00000    # 30.0f

    invoke-static/range {v21 .. v22}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v21

    move/from16 v0, v21

    float-to-int v0, v0

    move/from16 v16, v0

    .line 709
    .local v16, "margin":I
    const v21, 0x7f0c01c1

    move-object/from16 v0, p1

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/LinearLayout;

    .line 710
    .local v7, "brandLayout":Landroid/widget/LinearLayout;
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v21

    const v22, 0x7f020024

    invoke-virtual/range {v21 .. v22}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v7, v0}, Landroid/widget/LinearLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 711
    invoke-virtual {v7}, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v15

    check-cast v15, Landroid/widget/LinearLayout$LayoutParams;

    .line 712
    .local v15, "layoutParams":Landroid/widget/LinearLayout$LayoutParams;
    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v23, 0x0

    move/from16 v0, v21

    move/from16 v1, v16

    move/from16 v2, v22

    move/from16 v3, v23

    invoke-virtual {v15, v0, v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 713
    const/16 v21, 0x0

    div-int/lit8 v22, v16, 0x2

    const/16 v23, 0x0

    div-int/lit8 v24, v16, 0x2

    move/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    invoke-virtual {v7, v0, v1, v2, v3}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 714
    invoke-virtual {v7, v15}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 716
    const v21, 0x7f0c0035

    move/from16 v0, v21

    invoke-virtual {v7, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Lcom/poshmark/ui/customviews/PMTextView;

    .line 717
    .local v8, "brandTitleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v21, 0x7f060056

    move/from16 v0, v21

    invoke-virtual {v8, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(I)V

    .line 718
    const v21, 0x7f0c01bf

    move/from16 v0, v21

    invoke-virtual {v7, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v21

    check-cast v21, Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->brandValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 719
    new-instance v21, Lcom/poshmark/ui/fragments/ListingFiltersFragment$15;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$15;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    move-object/from16 v0, v21

    invoke-virtual {v7, v0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 726
    const v21, 0x7f0c01c2

    move-object/from16 v0, p1

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/LinearLayout;

    .line 727
    .local v9, "categoryLayout":Landroid/widget/LinearLayout;
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v21

    const v22, 0x7f020022

    invoke-virtual/range {v21 .. v22}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Landroid/widget/LinearLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 728
    const/16 v21, 0x0

    div-int/lit8 v22, v16, 0x2

    const/16 v23, 0x0

    div-int/lit8 v24, v16, 0x2

    move/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    invoke-virtual {v9, v0, v1, v2, v3}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 729
    const v21, 0x7f0c0035

    move/from16 v0, v21

    invoke-virtual {v9, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Lcom/poshmark/ui/customviews/PMTextView;

    .line 730
    .local v10, "categoryTitleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v21, 0x7f060075

    move/from16 v0, v21

    invoke-virtual {v10, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(I)V

    .line 731
    const v21, 0x7f0c01bf

    move/from16 v0, v21

    invoke-virtual {v9, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v21

    check-cast v21, Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->categoryValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 732
    const v21, 0x7f0c01c0

    move/from16 v0, v21

    invoke-virtual {v9, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v21

    check-cast v21, Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->styleValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 733
    const v21, 0x7f0c0099

    move/from16 v0, v21

    invoke-virtual {v9, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v21

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->dividerView:Landroid/view/View;

    .line 735
    new-instance v21, Lcom/poshmark/ui/fragments/ListingFiltersFragment$16;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$16;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 742
    const v21, 0x7f0c01c3

    move-object/from16 v0, p1

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Landroid/widget/LinearLayout;

    .line 743
    .local v11, "colorLayout":Landroid/widget/LinearLayout;
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v21

    const v22, 0x7f020022

    invoke-virtual/range {v21 .. v22}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Landroid/widget/LinearLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 744
    const/16 v21, 0x0

    div-int/lit8 v22, v16, 0x2

    const/16 v23, 0x0

    div-int/lit8 v24, v16, 0x2

    move/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    invoke-virtual {v11, v0, v1, v2, v3}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 745
    const v21, 0x7f0c0035

    move/from16 v0, v21

    invoke-virtual {v11, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v12

    check-cast v12, Lcom/poshmark/ui/customviews/PMTextView;

    .line 746
    .local v12, "colorTitleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v21, 0x7f06008b

    move/from16 v0, v21

    invoke-virtual {v12, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(I)V

    .line 747
    const v21, 0x7f0c01a2

    move/from16 v0, v21

    invoke-virtual {v11, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v21

    check-cast v21, Landroid/widget/LinearLayout;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->colorValuesImageContainer:Landroid/widget/LinearLayout;

    .line 748
    new-instance v21, Lcom/poshmark/ui/fragments/ListingFiltersFragment$17;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$17;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 755
    const v21, 0x7f0c01c4

    move-object/from16 v0, p1

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v19

    check-cast v19, Landroid/widget/LinearLayout;

    .line 756
    .local v19, "sizeLayout":Landroid/widget/LinearLayout;
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v21

    const v22, 0x7f020022

    invoke-virtual/range {v21 .. v22}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v21

    move-object/from16 v0, v19

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 757
    const/16 v21, 0x0

    div-int/lit8 v22, v16, 0x2

    const/16 v23, 0x0

    div-int/lit8 v24, v16, 0x2

    move-object/from16 v0, v19

    move/from16 v1, v21

    move/from16 v2, v22

    move/from16 v3, v23

    move/from16 v4, v24

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 758
    const v21, 0x7f0c0035

    move-object/from16 v0, v19

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v20

    check-cast v20, Lcom/poshmark/ui/customviews/PMTextView;

    .line 759
    .local v20, "sizeTitleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v21, 0x7f060280

    invoke-virtual/range {v20 .. v21}, Lcom/poshmark/ui/customviews/PMTextView;->setText(I)V

    .line 760
    const v21, 0x7f0c01bf

    move-object/from16 v0, v19

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v21

    check-cast v21, Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->sizeValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 761
    new-instance v21, Lcom/poshmark/ui/fragments/ListingFiltersFragment$18;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$18;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    move-object/from16 v0, v19

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 768
    const v21, 0x7f0c01c5

    move-object/from16 v0, p1

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Landroid/widget/LinearLayout;

    .line 769
    .local v17, "priceLayout":Landroid/widget/LinearLayout;
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v21

    const v22, 0x7f020021

    invoke-virtual/range {v21 .. v22}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v21

    move-object/from16 v0, v17

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 770
    const/16 v21, 0x0

    div-int/lit8 v22, v16, 0x2

    const/16 v23, 0x0

    div-int/lit8 v24, v16, 0x2

    move-object/from16 v0, v17

    move/from16 v1, v21

    move/from16 v2, v22

    move/from16 v3, v23

    move/from16 v4, v24

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 771
    const v21, 0x7f0c0035

    move-object/from16 v0, v17

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v18

    check-cast v18, Lcom/poshmark/ui/customviews/PMTextView;

    .line 772
    .local v18, "priceTitleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v21, 0x7f060219

    move-object/from16 v0, v18

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(I)V

    .line 773
    const v21, 0x7f0c01bf

    move-object/from16 v0, v17

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v21

    check-cast v21, Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->priceValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 774
    new-instance v21, Lcom/poshmark/ui/fragments/ListingFiltersFragment$19;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$19;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    move-object/from16 v0, v17

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 781
    const v21, 0x7f0c01c6

    move-object/from16 v0, p1

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v13

    check-cast v13, Landroid/widget/LinearLayout;

    .line 782
    .local v13, "conditionLayout":Landroid/widget/LinearLayout;
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v21

    const v22, 0x7f020024

    invoke-virtual/range {v21 .. v22}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v13, v0}, Landroid/widget/LinearLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 783
    const/16 v21, 0x0

    div-int/lit8 v22, v16, 0x2

    const/16 v23, 0x0

    div-int/lit8 v24, v16, 0x2

    move/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    invoke-virtual {v13, v0, v1, v2, v3}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 784
    invoke-virtual {v13}, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v15

    .end local v15    # "layoutParams":Landroid/widget/LinearLayout$LayoutParams;
    check-cast v15, Landroid/widget/LinearLayout$LayoutParams;

    .line 785
    .restart local v15    # "layoutParams":Landroid/widget/LinearLayout$LayoutParams;
    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v23, 0x0

    move/from16 v0, v21

    move/from16 v1, v16

    move/from16 v2, v22

    move/from16 v3, v23

    invoke-virtual {v15, v0, v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 786
    invoke-virtual {v13, v15}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 788
    const v21, 0x7f0c0035

    move/from16 v0, v21

    invoke-virtual {v13, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Lcom/poshmark/ui/customviews/PMTextView;

    .line 789
    .local v14, "conditionTitleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v21, 0x7f060091

    move/from16 v0, v21

    invoke-virtual {v14, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(I)V

    .line 790
    const v21, 0x7f0c01bf

    move/from16 v0, v21

    invoke-virtual {v13, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v21

    check-cast v21, Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->conditionValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 791
    new-instance v21, Lcom/poshmark/ui/fragments/ListingFiltersFragment$20;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$20;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    move-object/from16 v0, v21

    invoke-virtual {v13, v0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 798
    const v21, 0x7f0c01c7

    move-object/from16 v0, p1

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    .line 799
    .local v5, "availabilityLayout":Landroid/widget/LinearLayout;
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v21

    const v22, 0x7f020021

    invoke-virtual/range {v21 .. v22}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v5, v0}, Landroid/widget/LinearLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 800
    const/16 v21, 0x0

    div-int/lit8 v22, v16, 0x2

    const/16 v23, 0x0

    div-int/lit8 v24, v16, 0x2

    move/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    invoke-virtual {v5, v0, v1, v2, v3}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 801
    const v21, 0x7f0c0035

    move/from16 v0, v21

    invoke-virtual {v5, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Lcom/poshmark/ui/customviews/PMTextView;

    .line 802
    .local v6, "availabilityTitleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v21, 0x7f06004e

    move/from16 v0, v21

    invoke-virtual {v6, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(I)V

    .line 803
    const v21, 0x7f0c01bf

    move/from16 v0, v21

    invoke-virtual {v5, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v21

    check-cast v21, Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->availabilityValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 804
    new-instance v21, Lcom/poshmark/ui/fragments/ListingFiltersFragment$21;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$21;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    move-object/from16 v0, v21

    invoke-virtual {v5, v0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 810
    return-void
.end method

.method private updateSearchFilters(ILandroid/os/Bundle;)V
    .locals 19
    .param p1, "requestCode"    # I
    .param p2, "b"    # Landroid/os/Bundle;

    .prologue
    .line 273
    const-string v9, ""

    .line 274
    .local v9, "selectedFilterKey":Ljava/lang/String;
    const-string v10, ""

    .line 276
    .local v10, "selectedFilterValue":Ljava/lang/String;
    const/4 v8, 0x0

    .line 278
    .local v8, "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    const-string v13, "DATA_SELECTED"

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 279
    .local v4, "jsonString":Ljava/lang/String;
    if-eqz v4, :cond_0

    .line 280
    const-class v13, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v4, v13}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v8

    .end local v8    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    check-cast v8, Lcom/poshmark/data_model/models/MetaItem;

    .line 283
    .restart local v8    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    packed-switch p1, :pswitch_data_0

    .line 399
    :cond_1
    :goto_0
    :pswitch_0
    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v13

    if-lez v13, :cond_2

    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v13

    if-lez v13, :cond_2

    .line 400
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v13

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v15, "listing"

    const-string v16, "filter_selected"

    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "/"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v13 .. v17}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 402
    :cond_2
    return-void

    .line 285
    :pswitch_1
    const-string v9, "category"

    .line 287
    if-eqz v8, :cond_3

    .line 288
    move-object/from16 v0, p0

    iput-object v8, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 290
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSizes:Ljava/util/List;

    invoke-interface {v13}, Ljava/util/List;->clear()V

    .line 291
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v13}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v10

    .line 292
    const-string v13, "TAGS_LIST"

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 293
    .local v1, "arrayListJson":Ljava/lang/String;
    if-eqz v1, :cond_1

    .line 294
    new-instance v5, Lcom/poshmark/ui/fragments/ListingFiltersFragment$10;

    move-object/from16 v0, p0

    invoke-direct {v5, v0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$10;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    .line 295
    .local v5, "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v1, v5}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/util/List;

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSubCategories:Ljava/util/List;

    goto :goto_0

    .line 299
    .end local v1    # "arrayListJson":Ljava/lang/String;
    .end local v5    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    :cond_3
    const/4 v13, 0x0

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 301
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSizes:Ljava/util/List;

    invoke-interface {v13}, Ljava/util/List;->clear()V

    .line 302
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSubCategories:Ljava/util/List;

    invoke-interface {v13}, Ljava/util/List;->clear()V

    .line 303
    const-string v10, "all"

    .line 305
    goto :goto_0

    .line 308
    :pswitch_2
    const-string v9, "style"

    .line 309
    if-eqz v8, :cond_4

    .line 310
    move-object/from16 v0, p0

    iput-object v8, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 313
    :cond_4
    const-string v13, "TAGS_LIST"

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 314
    .local v12, "styleJson":Ljava/lang/String;
    if-eqz v12, :cond_1

    .line 315
    new-instance v5, Lcom/poshmark/ui/fragments/ListingFiltersFragment$11;

    move-object/from16 v0, p0

    invoke-direct {v5, v0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$11;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    .line 316
    .restart local v5    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v12, v5}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/util/List;

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSubCategories:Ljava/util/List;

    goto/16 :goto_0

    .line 321
    .end local v5    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    .end local v12    # "styleJson":Ljava/lang/String;
    :pswitch_3
    const-string v13, "SIZE_CHANGED"

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    .line 322
    .local v2, "isDataChanged":Z
    const-string v13, "MYSIZE_SWITCH_STATE"

    const/4 v14, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v13, v14}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v6

    .line 323
    .local v6, "newMySizeState":Z
    const-string v9, "size"

    .line 324
    move-object/from16 v0, p0

    iput-boolean v6, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->isMySizeSelected:Z

    .line 326
    if-eqz v8, :cond_5

    .line 327
    move-object/from16 v0, p0

    iput-object v8, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 330
    :cond_5
    if-eqz v2, :cond_6

    .line 331
    const-string v13, "SIZE_LIST"

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 332
    .local v11, "sizeJson":Ljava/lang/String;
    if-eqz v11, :cond_6

    .line 333
    new-instance v5, Lcom/poshmark/ui/fragments/ListingFiltersFragment$12;

    move-object/from16 v0, p0

    invoke-direct {v5, v0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$12;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    .line 334
    .restart local v5    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v11, v5}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/util/List;

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSizes:Ljava/util/List;

    .line 337
    .end local v5    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    .end local v11    # "sizeJson":Ljava/lang/String;
    :cond_6
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v13

    invoke-virtual {v13}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v13

    invoke-virtual {v13}, Lcom/poshmark/utils/SearchFilterModel;->getCommaSeparatedSizes()Ljava/lang/String;

    move-result-object v10

    .line 338
    move-object/from16 v0, p0

    iget-boolean v13, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->isMySizeSelected:Z

    if-eqz v13, :cond_1

    .line 339
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v13, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "My Size"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    goto/16 :goto_0

    .line 344
    .end local v2    # "isDataChanged":Z
    .end local v6    # "newMySizeState":Z
    :pswitch_4
    const-string v9, "brand"

    .line 345
    if-eqz v8, :cond_7

    .line 346
    move-object/from16 v0, p0

    iput-object v8, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentBrandItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 347
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentBrandItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v13}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 349
    :cond_7
    const/4 v13, 0x0

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentBrandItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 350
    const-string v10, "all"

    .line 352
    goto/16 :goto_0

    .line 355
    :pswitch_5
    const-string v9, "price"

    .line 356
    const-string v13, "PRICE_CHANGED"

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v3

    .line 357
    .local v3, "isPriceChanged":Z
    if-eqz v3, :cond_1

    .line 358
    const-string v13, "PRICE_LIST"

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 359
    .local v7, "priceJson":Ljava/lang/String;
    if-eqz v7, :cond_1

    .line 360
    new-instance v5, Lcom/poshmark/ui/fragments/ListingFiltersFragment$13;

    move-object/from16 v0, p0

    invoke-direct {v5, v0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$13;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    .line 361
    .restart local v5    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v7, v5}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/util/List;

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentPrices:Ljava/util/List;

    .line 362
    invoke-direct/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getCommaSeparatedPrices()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 368
    .end local v3    # "isPriceChanged":Z
    .end local v5    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    .end local v7    # "priceJson":Ljava/lang/String;
    :pswitch_6
    const-string v9, "condition"

    .line 369
    if-eqz v8, :cond_1

    .line 370
    move-object/from16 v0, p0

    iput-object v8, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentConditionItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 371
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentConditionItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v13}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 376
    :pswitch_7
    const-string v9, "inventory_status"

    .line 377
    if-eqz v8, :cond_1

    .line 378
    move-object/from16 v0, p0

    iput-object v8, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentAvailabilityItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 379
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentAvailabilityItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v13}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 384
    :pswitch_8
    const-string v13, "COLOR_CHANGED"

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    .line 385
    .restart local v2    # "isDataChanged":Z
    const-string v9, "color"

    .line 387
    if-eqz v2, :cond_1

    .line 388
    const-string v13, "COLOR_LIST"

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 389
    .restart local v11    # "sizeJson":Ljava/lang/String;
    if-eqz v11, :cond_1

    .line 390
    new-instance v5, Lcom/poshmark/ui/fragments/ListingFiltersFragment$14;

    move-object/from16 v0, p0

    invoke-direct {v5, v0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$14;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    .line 391
    .restart local v5    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v11, v5}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/util/List;

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentColors:Ljava/util/List;

    goto/16 :goto_0

    .line 283
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_0
        :pswitch_2
        :pswitch_8
    .end packed-switch
.end method

.method private updateView()V
    .locals 18

    .prologue
    .line 597
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentBrandItem:Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v16, v0

    if-eqz v16, :cond_1

    .line 598
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->brandValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 599
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->brandValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentBrandItem:Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 604
    :goto_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v16, v0

    if-eqz v16, :cond_2

    .line 605
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->categoryValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 606
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->categoryValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 612
    :goto_1
    const-string v15, ""

    .line 613
    .local v15, "subcategoriesString":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSubCategories:Ljava/util/List;

    move-object/from16 v16, v0

    invoke-interface/range {v16 .. v16}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .line 614
    .local v8, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_0
    :goto_2
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v16

    if-eqz v16, :cond_3

    .line 615
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/poshmark/data_model/models/MetaItem;

    .line 616
    .local v7, "item":Lcom/poshmark/data_model/models/MetaItem;
    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v16

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    .line 617
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v16

    if-eqz v16, :cond_0

    .line 618
    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v16

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, ", "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    goto :goto_2

    .line 601
    .end local v7    # "item":Lcom/poshmark/data_model/models/MetaItem;
    .end local v8    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    .end local v15    # "subcategoriesString":Ljava/lang/String;
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->brandValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    const/16 v17, 0x8

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    goto :goto_0

    .line 608
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->categoryValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    const/16 v17, 0x8

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    goto :goto_1

    .line 622
    .restart local v8    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    .restart local v15    # "subcategoriesString":Ljava/lang/String;
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v16, v0

    if-eqz v16, :cond_4

    .line 623
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->dividerView:Landroid/view/View;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-virtual/range {v16 .. v17}, Landroid/view/View;->setVisibility(I)V

    .line 624
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->styleValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 626
    invoke-virtual {v15}, Ljava/lang/String;->length()I

    move-result v16

    if-lez v16, :cond_5

    .line 627
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->styleValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v15}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 634
    :cond_4
    :goto_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->colorValuesImageContainer:Landroid/widget/LinearLayout;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 635
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentColors:Ljava/util/List;

    move-object/from16 v16, v0

    invoke-interface/range {v16 .. v16}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 636
    .local v3, "colorIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    :goto_4
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v16

    if-eqz v16, :cond_6

    .line 637
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/PMColor;

    .line 638
    .local v2, "color":Lcom/poshmark/data_model/models/PMColor;
    new-instance v5, Landroid/widget/ImageView;

    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v5, v0}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 639
    .local v5, "imgView":Landroid/widget/ImageView;
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;

    const/16 v16, -0x2

    const/16 v17, -0x2

    move/from16 v0, v16

    move/from16 v1, v17

    invoke-direct {v9, v0, v1}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 640
    .local v9, "lp":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v16

    const/high16 v17, 0x41f00000    # 30.0f

    invoke-static/range {v16 .. v17}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v16

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    move/from16 v0, v16

    iput v0, v9, Landroid/widget/LinearLayout$LayoutParams;->height:I

    .line 641
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v16

    const/high16 v17, 0x41f00000    # 30.0f

    invoke-static/range {v16 .. v17}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v16

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    move/from16 v0, v16

    iput v0, v9, Landroid/widget/LinearLayout$LayoutParams;->width:I

    .line 642
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v16

    const/high16 v17, 0x41200000    # 10.0f

    invoke-static/range {v16 .. v17}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v16

    move/from16 v0, v16

    float-to-int v10, v0

    .line 643
    .local v10, "offset":I
    invoke-virtual {v9, v10, v10, v10, v10}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 644
    invoke-virtual {v5, v9}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 645
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v16

    const v17, 0x7f020038

    invoke-virtual/range {v16 .. v17}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    check-cast v4, Landroid/graphics/drawable/GradientDrawable;

    .line 646
    .local v4, "drawable":Landroid/graphics/drawable/GradientDrawable;
    iget-object v0, v2, Lcom/poshmark/data_model/models/PMColor;->rgb:Ljava/lang/String;

    move-object/from16 v16, v0

    invoke-static/range {v16 .. v16}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v16

    move/from16 v0, v16

    invoke-virtual {v4, v0}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    .line 647
    invoke-virtual {v5, v4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 648
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->colorValuesImageContainer:Landroid/widget/LinearLayout;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto/16 :goto_4

    .line 629
    .end local v2    # "color":Lcom/poshmark/data_model/models/PMColor;
    .end local v3    # "colorIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    .end local v4    # "drawable":Landroid/graphics/drawable/GradientDrawable;
    .end local v5    # "imgView":Landroid/widget/ImageView;
    .end local v9    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    .end local v10    # "offset":I
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->styleValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    const v17, 0x7f06003c

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setText(I)V

    goto/16 :goto_3

    .line 653
    .restart local v3    # "colorIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    :cond_6
    const-string v14, ""

    .line 654
    .local v14, "sizeString":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->isMySizeSelected:Z

    move/from16 v16, v0

    if-eqz v16, :cond_7

    .line 655
    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v16

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const v17, 0x7f0601ba

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getString(I)Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    .line 656
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSizes:Ljava/util/List;

    move-object/from16 v16, v0

    invoke-interface/range {v16 .. v16}, Ljava/util/List;->size()I

    move-result v16

    if-lez v16, :cond_7

    .line 657
    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v16

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, ", "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    .line 660
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSizes:Ljava/util/List;

    move-object/from16 v16, v0

    invoke-interface/range {v16 .. v16}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v13

    .line 661
    .local v13, "sizeItr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_8
    :goto_5
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v16

    if-eqz v16, :cond_9

    .line 662
    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/poshmark/data_model/models/MetaItem;

    .line 663
    .restart local v7    # "item":Lcom/poshmark/data_model/models/MetaItem;
    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v16

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    .line 664
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v16

    if-eqz v16, :cond_8

    .line 665
    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v16

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, ", "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    goto :goto_5

    .line 668
    .end local v7    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_9
    invoke-virtual {v14}, Ljava/lang/String;->length()I

    move-result v16

    if-lez v16, :cond_b

    .line 669
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->sizeValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 670
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->sizeValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v14}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 675
    :goto_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentPrices:Ljava/util/List;

    move-object/from16 v16, v0

    invoke-interface/range {v16 .. v16}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .line 676
    .local v11, "priceItr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PriceInfo;>;"
    const-string v12, ""

    .line 677
    .local v12, "prices":Ljava/lang/String;
    :cond_a
    :goto_7
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v16

    if-eqz v16, :cond_c

    .line 678
    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/poshmark/data_model/models/PriceInfo;

    .line 679
    .local v6, "info":Lcom/poshmark/data_model/models/PriceInfo;
    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v16

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/PriceInfo;->getDisplay()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 680
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v16

    if-eqz v16, :cond_a

    .line 681
    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v16

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, ", "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    goto :goto_7

    .line 672
    .end local v6    # "info":Lcom/poshmark/data_model/models/PriceInfo;
    .end local v11    # "priceItr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PriceInfo;>;"
    .end local v12    # "prices":Ljava/lang/String;
    :cond_b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->sizeValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    const/16 v17, 0x8

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    goto :goto_6

    .line 684
    .restart local v11    # "priceItr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PriceInfo;>;"
    .restart local v12    # "prices":Ljava/lang/String;
    :cond_c
    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v16

    if-lez v16, :cond_d

    .line 685
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->priceValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 686
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->priceValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v12}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 691
    :goto_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentAvailabilityItem:Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v16, v0

    if-eqz v16, :cond_e

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentAvailabilityItem:Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v16

    const v17, 0x7f060040

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getString(I)Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v16

    if-nez v16, :cond_e

    .line 692
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->availabilityValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 693
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->availabilityValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentAvailabilityItem:Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 698
    :goto_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentConditionItem:Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v16, v0

    if-eqz v16, :cond_f

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentConditionItem:Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v16

    const v17, 0x7f060040

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getString(I)Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v16

    if-nez v16, :cond_f

    .line 699
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->conditionValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 700
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->conditionValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentConditionItem:Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 704
    :goto_a
    return-void

    .line 688
    :cond_d
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->priceValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    const/16 v17, 0x8

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    goto/16 :goto_8

    .line 695
    :cond_e
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->availabilityValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    const/16 v17, 0x8

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    goto :goto_9

    .line 702
    :cond_f
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->conditionValueTextView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v16, v0

    const/16 v17, 0x8

    invoke-virtual/range {v16 .. v17}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    goto :goto_a
.end method


# virtual methods
.method public getFilterManager()Lcom/poshmark/utils/FilterResultsManager;
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    return-object v0
.end method

.method public getFilterModel()Lcom/poshmark/utils/SearchFilterModel;
    .locals 1

    .prologue
    .line 250
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 877
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.UPDATE_SEARCH_DRAWER"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 878
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->setup(Lcom/poshmark/utils/SearchFilterModel;Z)V

    .line 880
    :cond_0
    return-void
.end method

.method public launchCategorySelection()V
    .locals 9

    .prologue
    const/4 v7, 0x0

    const/4 v5, 0x1

    .line 500
    new-instance v3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-direct {v3}, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;-><init>()V

    .line 501
    .local v3, "info":Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v2, :cond_1

    .line 502
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/poshmark/db/DbApi;->getSubCategoriesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 503
    .local v6, "allTagsForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->STYLE_TAGS:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getUnscrubbedFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v2

    invoke-static {v6, v2}, Lcom/poshmark/utils/ListingsFilterUtils;->getScrubbedList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    .line 504
    iget-object v2, v3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    if-nez v2, :cond_0

    .line 505
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    .line 507
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 510
    .end local v6    # "allTagsForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSubCategories:Ljava/util/List;

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    .line 511
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->CATEGORY_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->categoryFacetList:Ljava/util/List;

    .line 512
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->STYLE_TAGS:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getUnscrubbedFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->subCategoryFacetList:Ljava/util/List;

    .line 513
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 514
    .local v1, "b":Landroid/os/Bundle;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->allowFilteringOnAllCategories()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 515
    const-string v2, "SHOW_ALL_VISIBLE"

    invoke-virtual {v1, v2, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 516
    const-string v2, "SET_SHOW_ALL"

    invoke-virtual {v1, v2, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 521
    :goto_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 522
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/CategoryListFragment;

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 523
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v5, "listing"

    const-string v7, "filter_clicked"

    const-string v8, "category"

    invoke-virtual {v2, v4, v5, v7, v8}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 524
    return-void

    .line 518
    .end local v0    # "parent":Lcom/poshmark/ui/PMActivity;
    :cond_2
    const-string v2, "SHOW_ALL_VISIBLE"

    invoke-virtual {v1, v2, v7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 519
    const-string v2, "SET_SHOW_ALL"

    invoke-virtual {v1, v2, v7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_0
.end method

.method public launchColorPicker()V
    .locals 8

    .prologue
    .line 527
    new-instance v3, Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    invoke-direct {v3}, Lcom/poshmark/utils/meta_data/ColorPickerInfo;-><init>()V

    .line 528
    .local v3, "info":Lcom/poshmark/utils/meta_data/ColorPickerInfo;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getColorFacetList()Ljava/util/List;

    move-result-object v2

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->allItems:Ljava/util/List;

    .line 529
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getUnscrubbedColorFacetList()Ljava/util/List;

    move-result-object v2

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->colorFacetList:Ljava/util/List;

    .line 530
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentColors:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 531
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentColors:Ljava/util/List;

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->selectedColors:Ljava/util/List;

    .line 533
    :cond_0
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 534
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "COLOR_PICKER_MODE"

    sget-object v4, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_FILTER:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->ordinal()I

    move-result v4

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 535
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 536
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/ColorPickerFragment;

    const/16 v5, 0x9

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 537
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v5, "listing"

    const-string v6, "filter_clicked"

    const-string v7, "color"

    invoke-virtual {v2, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 538
    return-void
.end method

.method public launchPricePicker()V
    .locals 7

    .prologue
    .line 563
    new-instance v3, Lcom/poshmark/utils/meta_data/PricePickerInfo;

    invoke-direct {v3}, Lcom/poshmark/utils/meta_data/PricePickerInfo;-><init>()V

    .line 564
    .local v3, "info":Lcom/poshmark/utils/meta_data/PricePickerInfo;
    invoke-static {}, Lcom/poshmark/db/DbApi;->getCannedPriceRanges()Ljava/util/List;

    move-result-object v1

    iput-object v1, v3, Lcom/poshmark/utils/meta_data/PricePickerInfo;->allItems:Ljava/util/List;

    .line 565
    iget-object v1, v3, Lcom/poshmark/utils/meta_data/PricePickerInfo;->selectedItems:Ljava/util/List;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentPrices:Ljava/util/List;

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 567
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 568
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const/4 v1, 0x0

    const-class v2, Lcom/poshmark/ui/fragments/PricePickerFragment;

    const/4 v5, 0x4

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 569
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "filter_clicked"

    const-string v6, "price"

    invoke-virtual {v1, v2, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 570
    return-void
.end method

.method public launchSizeSelection()V
    .locals 9

    .prologue
    .line 541
    new-instance v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    invoke-direct {v3}, Lcom/poshmark/utils/meta_data/MySizePickerInfo;-><init>()V

    .line 542
    .local v3, "info":Lcom/poshmark/utils/meta_data/MySizePickerInfo;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v2, :cond_1

    .line 543
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/poshmark/db/DbApi;->getSizesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 544
    .local v6, "allSizesForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->SIZE_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getUnscrubbedFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v2

    invoke-static {v6, v2}, Lcom/poshmark/utils/ListingsFilterUtils;->getScrubbedList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    .line 545
    iget-object v2, v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    if-nez v2, :cond_0

    .line 546
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    .line 548
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 551
    .end local v6    # "allSizesForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_1
    iget-object v2, v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->selectedItems:Ljava/util/List;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSizes:Ljava/util/List;

    invoke-interface {v2, v4}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 552
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->CATEGORY_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->categoryFacetList:Ljava/util/List;

    .line 553
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->SIZE_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getUnscrubbedFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->sizeFacetList:Ljava/util/List;

    .line 554
    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->isMySizeSelected:Z

    iput-boolean v2, v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->bIsMySizeEnabled:Z

    .line 555
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 556
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "MODE"

    sget-object v4, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->SEARCH_FILTER:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->ordinal()I

    move-result v4

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 557
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 558
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MySizePickerFragment;

    const/4 v5, 0x2

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 559
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v5, "listing"

    const-string v7, "filter_clicked"

    const-string v8, "size"

    invoke-virtual {v2, v4, v5, v7, v8}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 560
    return-void
.end method

.method public logScreenTracking()V
    .locals 0

    .prologue
    .line 199
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 165
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 166
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 170
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 171
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 172
    const-string v0, "RETURNED_RESULTS"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->updateSearchFilters(ILandroid/os/Bundle;)V

    .line 173
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->isG2FiltersEnabled:Z

    if-eqz v0, :cond_0

    .line 174
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->fireSearch()V

    .line 177
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v5, 0x1

    .line 79
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 80
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/FeatureManager;->isFilterBarv2FeatureEnabled()Z

    move-result v3

    iput-boolean v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->isG2FiltersEnabled:Z

    .line 81
    if-eqz p1, :cond_8

    .line 83
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getFragmentId()Ljava/util/UUID;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, p1, v4}, Landroid/support/v4/app/FragmentManager;->getFragment(Landroid/os/Bundle;Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    .line 85
    const-string v3, "CURRENT_SIZES_JSON"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 86
    .local v1, "json":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 87
    new-instance v2, Lcom/poshmark/ui/fragments/ListingFiltersFragment$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$1;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    .line 88
    .local v2, "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v1, v2}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSizes:Ljava/util/List;

    .line 91
    .end local v2    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    :cond_0
    const-string v3, "CURRENT_CATEGORY_STYLE_TAGS_JSON"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 92
    if-eqz v1, :cond_1

    .line 93
    new-instance v2, Lcom/poshmark/ui/fragments/ListingFiltersFragment$2;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$2;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    .line 94
    .restart local v2    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v1, v2}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSubCategories:Ljava/util/List;

    .line 97
    .end local v2    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    :cond_1
    const-string v3, "CURRENT_COLORS_JSON"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 98
    if-eqz v1, :cond_2

    .line 99
    new-instance v2, Lcom/poshmark/ui/fragments/ListingFiltersFragment$3;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$3;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    .line 100
    .restart local v2    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v1, v2}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentColors:Ljava/util/List;

    .line 103
    .end local v2    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    :cond_2
    const-string v3, "CURRENT_PRICES_JSON"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 104
    if-eqz v1, :cond_3

    .line 105
    new-instance v2, Lcom/poshmark/ui/fragments/ListingFiltersFragment$4;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$4;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    .line 106
    .restart local v2    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v1, v2}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentPrices:Ljava/util/List;

    .line 109
    .end local v2    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    :cond_3
    const-string v3, "CURRENT_CATEGORY_ITEM_JSON"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 110
    if-eqz v1, :cond_4

    .line 111
    const-class v3, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v1, v3}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/MetaItem;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 114
    :cond_4
    const-string v3, "CURRENT_BRAND_ITEM_JSON"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 115
    if-eqz v1, :cond_5

    .line 116
    const-class v3, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v1, v3}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/MetaItem;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentBrandItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 119
    :cond_5
    const-string v3, "CURRENT_CONDITION_ITEM_JSON"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 120
    if-eqz v1, :cond_6

    .line 121
    const-class v3, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v1, v3}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/MetaItem;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentConditionItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 124
    :cond_6
    const-string v3, "CURRENT_AVAILABILITY_ITEM_JSON"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 125
    if-eqz v1, :cond_7

    .line 126
    const-class v3, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v1, v3}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/MetaItem;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentAvailabilityItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 129
    :cond_7
    const-string v3, "MY_SIZE"

    invoke-virtual {p1, v3, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->isMySizeSelected:Z

    .line 130
    iput-boolean v5, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->createdFromSavedState:Z

    .line 140
    .end local v1    # "json":Ljava/lang/String;
    :goto_0
    return-void

    .line 133
    :cond_8
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 134
    .local v0, "b":Landroid/os/Bundle;
    if-eqz v0, :cond_9

    .line 137
    :cond_9
    const-class v3, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    .line 138
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->createdFromSavedState:Z

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 144
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 145
    const v1, 0x7f030072

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 146
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->setupView(Landroid/view/View;)V

    .line 148
    return-object v0
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 160
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroyView()V

    .line 161
    return-void
.end method

.method public onFragmentResult(Landroid/os/Bundle;I)V
    .locals 0
    .param p1, "b"    # Landroid/os/Bundle;
    .param p2, "requestCode"    # I

    .prologue
    .line 181
    invoke-direct {p0, p2, p1}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->updateSearchFilters(ILandroid/os/Bundle;)V

    .line 182
    return-void
.end method

.method public onPMResume()V
    .locals 2

    .prologue
    .line 153
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 154
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->setup(Lcom/poshmark/utils/SearchFilterModel;Z)V

    .line 155
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.UPDATE_SEARCH_DRAWER"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 156
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 203
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 205
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getFragmentId()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v2, p1, v3, v4}, Landroid/support/v4/app/FragmentManager;->putFragment(Landroid/os/Bundle;Ljava/lang/String;Landroid/support/v4/app/Fragment;)V

    .line 207
    new-instance v2, Lcom/poshmark/ui/fragments/ListingFiltersFragment$6;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$6;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$6;->getType()Ljava/lang/reflect/Type;

    move-result-object v1

    .line 208
    .local v1, "listOfObject":Ljava/lang/reflect/Type;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSizes:Ljava/util/List;

    invoke-static {v2, v1}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/util/List;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v0

    .line 209
    .local v0, "json":Ljava/lang/String;
    const-string v2, "CURRENT_SIZES_JSON"

    invoke-virtual {p1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 211
    new-instance v2, Lcom/poshmark/ui/fragments/ListingFiltersFragment$7;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$7;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$7;->getType()Ljava/lang/reflect/Type;

    move-result-object v1

    .line 212
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentPrices:Ljava/util/List;

    invoke-static {v2, v1}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/util/List;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v0

    .line 213
    const-string v2, "CURRENT_PRICES_JSON"

    invoke-virtual {p1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 215
    new-instance v2, Lcom/poshmark/ui/fragments/ListingFiltersFragment$8;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$8;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$8;->getType()Ljava/lang/reflect/Type;

    move-result-object v1

    .line 216
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentSubCategories:Ljava/util/List;

    invoke-static {v2, v1}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/util/List;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v0

    .line 217
    const-string v2, "CURRENT_CATEGORY_STYLE_TAGS_JSON"

    invoke-virtual {p1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 219
    new-instance v2, Lcom/poshmark/ui/fragments/ListingFiltersFragment$9;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$9;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$9;->getType()Ljava/lang/reflect/Type;

    move-result-object v1

    .line 220
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentColors:Ljava/util/List;

    invoke-static {v2, v1}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/util/List;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v0

    .line 221
    const-string v2, "CURRENT_COLORS_JSON"

    invoke-virtual {p1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 223
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v2, :cond_0

    .line 224
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentCategoryItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v2}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 225
    const-string v2, "CURRENT_CATEGORY_ITEM_JSON"

    invoke-virtual {p1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 228
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentBrandItem:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v2, :cond_1

    .line 229
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentBrandItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v2}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 230
    const-string v2, "CURRENT_BRAND_ITEM_JSON"

    invoke-virtual {p1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 233
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentConditionItem:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v2, :cond_2

    .line 234
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentConditionItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v2}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 235
    const-string v2, "CURRENT_CONDITION_ITEM_JSON"

    invoke-virtual {p1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    :cond_2
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentAvailabilityItem:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v2, :cond_3

    .line 239
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->currentAvailabilityItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v2}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 240
    const-string v2, "CURRENT_AVAILABILITY_ITEM_JSON"

    invoke-virtual {p1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 242
    :cond_3
    const-string v2, "MY_SIZE"

    iget-boolean v3, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->isMySizeSelected:Z

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 243
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 246
    const-string v0, "listing_filter_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 247
    return-void
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 186
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 187
    const v0, 0x7f06004a

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/fragments/ListingFiltersFragment$5;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment$5;-><init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 193
    const v0, 0x7f060125

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->setTitle(I)V

    .line 194
    return-void
.end method
