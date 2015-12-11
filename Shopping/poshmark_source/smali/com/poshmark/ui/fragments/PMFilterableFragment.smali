.class public Lcom/poshmark/ui/fragments/PMFilterableFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "PMFilterableFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/PMFilterableFragment$6;
    }
.end annotation


# instance fields
.field facetLists:Lcom/poshmark/data_model/models/Facets;

.field filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

.field isFilterApplied:Z

.field searchManager:Lcom/poshmark/utils/FilterResultsManager;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 32
    new-instance v0, Lcom/poshmark/utils/FilterResultsManager;

    invoke-direct {v0}, Lcom/poshmark/utils/FilterResultsManager;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    .line 35
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->isFilterApplied:Z

    return-void
.end method

.method private getAvailabilityMetaItemListFromFacetList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 449
    invoke-static {}, Lcom/poshmark/db/DbApi;->getAvailabilityList()Ljava/util/List;

    move-result-object v0

    .line 450
    .local v0, "availabilityMetaItems":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    return-object v0
.end method

.method private getBrandMetaItemListFromFacetList()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 379
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    if-eqz v3, :cond_0

    .line 380
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/Facets;->getBrandFacets()Ljava/util/List;

    move-result-object v1

    .line 381
    .local v1, "brands":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    if-eqz v1, :cond_0

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 382
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/SearchFilterModel;->getCategory()Ljava/lang/String;

    move-result-object v2

    .line 384
    .local v2, "category":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/db/DbApi;->getBrandsForAllCategories()Ljava/util/List;

    move-result-object v0

    .line 385
    .local v0, "brandMetaItems":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-static {v0, v1}, Lcom/poshmark/utils/ListingsFilterUtils;->getScrubbedList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    .line 388
    .end local v0    # "brandMetaItems":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    .end local v1    # "brands":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    .end local v2    # "category":Ljava/lang/String;
    :goto_0
    return-object v3

    :cond_0
    invoke-static {}, Lcom/poshmark/db/DbApi;->getBrandsForAllCategories()Ljava/util/List;

    move-result-object v3

    goto :goto_0
.end method

.method private getCategoryMetaItemListFromFacetList()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 430
    invoke-static {}, Lcom/poshmark/db/DbApi;->getAllCategories()Ljava/util/List;

    move-result-object v1

    .line 431
    .local v1, "categoryMetaItems":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    if-eqz v2, :cond_0

    .line 432
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/Facets;->getCategoryFacets()Ljava/util/List;

    move-result-object v0

    .line 433
    .local v0, "categories":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 434
    invoke-static {v1, v0}, Lcom/poshmark/utils/ListingsFilterUtils;->getScrubbedList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v1

    .line 439
    .end local v0    # "categories":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    .end local v1    # "categoryMetaItems":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_0
    return-object v1
.end method

.method private getColorMetaItemListFromFacetList()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;"
        }
    .end annotation

    .prologue
    .line 454
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    if-eqz v2, :cond_0

    .line 455
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/Facets;->getColorFacets()Ljava/util/List;

    move-result-object v1

    .line 456
    .local v1, "colors":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    if-eqz v1, :cond_0

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 458
    invoke-static {}, Lcom/poshmark/db/DbApi;->getAllColors()Ljava/util/List;

    move-result-object v0

    .line 459
    .local v0, "colorList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    invoke-static {v0, v1}, Lcom/poshmark/utils/ListingsFilterUtils;->getScrubbedColorList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    .line 462
    .end local v0    # "colorList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    .end local v1    # "colors":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    :goto_0
    return-object v2

    :cond_0
    invoke-static {}, Lcom/poshmark/db/DbApi;->getAllColors()Ljava/util/List;

    move-result-object v2

    goto :goto_0
.end method

.method private getConditionMetaItemListFromFacetList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 444
    invoke-static {}, Lcom/poshmark/db/DbApi;->getAllConditions()Ljava/util/List;

    move-result-object v0

    .line 445
    .local v0, "conditionMetaItems":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    return-object v0
.end method

.method private getSizeMetaItemListFromFacetList()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 392
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/SearchFilterModel;->getCategory()Ljava/lang/String;

    move-result-object v0

    .line 393
    .local v0, "category":Ljava/lang/String;
    if-eqz v0, :cond_2

    .line 394
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    if-eqz v3, :cond_1

    .line 395
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/Facets;->getSizeFacets()Ljava/util/List;

    move-result-object v2

    .line 396
    .local v2, "sizes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    if-eqz v2, :cond_0

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 397
    invoke-static {v0}, Lcom/poshmark/db/DbApi;->getSizesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 398
    .local v1, "sizeMetaItems":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-static {v1, v2}, Lcom/poshmark/utils/ListingsFilterUtils;->getScrubbedList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    .line 406
    .end local v1    # "sizeMetaItems":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    .end local v2    # "sizes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    :goto_0
    return-object v3

    .line 400
    .restart local v2    # "sizes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    :cond_0
    invoke-static {v0}, Lcom/poshmark/db/DbApi;->getSizesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    goto :goto_0

    .line 403
    .end local v2    # "sizes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    :cond_1
    invoke-static {v0}, Lcom/poshmark/db/DbApi;->getSizesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    goto :goto_0

    .line 406
    :cond_2
    const/4 v3, 0x0

    goto :goto_0
.end method

.method private getStyleTagsMetaItemListFromFacetList()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 411
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/SearchFilterModel;->getCategory()Ljava/lang/String;

    move-result-object v0

    .line 412
    .local v0, "category":Ljava/lang/String;
    if-eqz v0, :cond_2

    .line 413
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    if-eqz v3, :cond_1

    .line 414
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/Facets;->getStyleTagsFacets()Ljava/util/List;

    move-result-object v2

    .line 415
    .local v2, "tags":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    if-eqz v2, :cond_0

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 416
    invoke-static {v0}, Lcom/poshmark/db/DbApi;->getSubCategoriesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 417
    .local v1, "tagMetaItems":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-static {v1, v2}, Lcom/poshmark/utils/ListingsFilterUtils;->getScrubbedList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    .line 425
    .end local v1    # "tagMetaItems":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    .end local v2    # "tags":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    :goto_0
    return-object v3

    .line 419
    .restart local v2    # "tags":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    :cond_0
    invoke-static {v0}, Lcom/poshmark/db/DbApi;->getSubCategoriesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    goto :goto_0

    .line 422
    .end local v2    # "tags":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    :cond_1
    invoke-static {v0}, Lcom/poshmark/db/DbApi;->getSubCategoriesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    goto :goto_0

    .line 425
    :cond_2
    const/4 v3, 0x0

    goto :goto_0
.end method

.method private launchAvailabilitySelection()V
    .locals 7

    .prologue
    .line 172
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "filter_clicked"

    const-string v6, "inventory_status"

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 173
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 174
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "META_ITEM_MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->AVAILABILITY_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 175
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 176
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    const/16 v5, 0xb

    move-object v3, p0

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 177
    return-void
.end method

.method private launchBrandSelection()V
    .locals 8

    .prologue
    const/4 v7, 0x1

    .line 122
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "filter_clicked"

    const-string v6, "brand"

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 123
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 124
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "SEARCH_ENABLED"

    invoke-virtual {v1, v2, v7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 125
    const-string v2, "RETURN_RESULT"

    invoke-virtual {v1, v2, v7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 126
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->allowFilteringOnAllBrands()Z

    move-result v2

    if-nez v2, :cond_0

    .line 127
    const-string v2, "SHOW_ALL"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 129
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 130
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    const/4 v5, 0x6

    move-object v3, p0

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 131
    return-void
.end method

.method private launchCategorySelection()V
    .locals 8

    .prologue
    const/4 v7, 0x1

    .line 134
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "filter_clicked"

    const-string v6, "category"

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 135
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 136
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "DISPLAY_MODE"

    const-string v3, "CATEGORY"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->allowFilteringOnAllCategories()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 138
    const-string v2, "SHOW_ALL_VISIBLE"

    invoke-virtual {v1, v2, v7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 139
    const-string v2, "SET_SHOW_ALL"

    invoke-virtual {v1, v2, v7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 143
    :goto_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 144
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/CategoryListFragment;

    const/16 v5, 0x11

    move-object v3, p0

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 145
    return-void

    .line 141
    .end local v0    # "parent":Lcom/poshmark/ui/PMActivity;
    :cond_0
    const-string v2, "SHOW_ALL_VISIBLE"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_0
.end method

.method private launchColorSelection()V
    .locals 7

    .prologue
    .line 180
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "filter_clicked"

    const-string v6, "color"

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 181
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 182
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 183
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "COLOR_PICKER_MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_FILTER:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->ordinal()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 184
    const-class v2, Lcom/poshmark/ui/fragments/ColorPickerFragment;

    const/16 v5, 0xf

    move-object v3, p0

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 185
    return-void
.end method

.method private launchConditionSelection()V
    .locals 7

    .prologue
    .line 164
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "filter_clicked"

    const-string v6, "condition"

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 166
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "META_ITEM_MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->CONDITION_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 167
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 168
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    const/16 v5, 0xa

    move-object v3, p0

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 169
    return-void
.end method

.method private launchPriceSelection()V
    .locals 7

    .prologue
    .line 156
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "filter_clicked"

    const-string v6, "price"

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 158
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "META_ITEM_MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->PRICE_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 159
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 160
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/PricePickerFragment;

    const/16 v5, 0x9

    move-object v3, p0

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 161
    return-void
.end method

.method private launchSizeSelection()V
    .locals 7

    .prologue
    .line 148
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "filter_clicked"

    const-string v6, "size"

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 150
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->SEARCH_FILTER:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->ordinal()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 151
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 152
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MySizePickerFragment;

    const/16 v5, 0x8

    move-object v3, p0

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 153
    return-void
.end method

.method private launchStyleTagSelection()V
    .locals 0

    .prologue
    .line 194
    return-void
.end method


# virtual methods
.method public allowFilteringOnAllBrands()Z
    .locals 1

    .prologue
    .line 71
    const/4 v0, 0x1

    return v0
.end method

.method public allowFilteringOnAllCategories()Z
    .locals 1

    .prologue
    .line 75
    const/4 v0, 0x1

    return v0
.end method

.method public facetsAvailable()Z
    .locals 1

    .prologue
    .line 371
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    if-eqz v0, :cond_0

    .line 372
    const/4 v0, 0x1

    .line 374
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public filterContent()V
    .locals 0

    .prologue
    .line 467
    return-void
.end method

.method public getBrandsFacetList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 517
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getBrandMetaItemListFromFacetList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getBrandsMetaItemSelection()Lcom/poshmark/data_model/models/MetaItem;
    .locals 1

    .prologue
    .line 485
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentBrand()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    return-object v0
.end method

.method public getColorFacetList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;"
        }
    .end annotation

    .prologue
    .line 513
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getColorMetaItemListFromFacetList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getCurrentMetaItemSelection(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 2
    .param p1, "metaItemMode"    # Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    .prologue
    .line 470
    sget-object v0, Lcom/poshmark/ui/fragments/PMFilterableFragment$6;->$SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES:[I

    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 481
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 472
    :pswitch_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    goto :goto_0

    .line 474
    :pswitch_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentBrand()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    goto :goto_0

    .line 476
    :pswitch_2
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentCondition()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    goto :goto_0

    .line 478
    :pswitch_3
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentAvailability()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    goto :goto_0

    .line 470
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public getFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;
    .locals 2
    .param p1, "metaItemMode"    # Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 494
    sget-object v0, Lcom/poshmark/ui/fragments/PMFilterableFragment$6;->$SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES:[I

    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 509
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 496
    :pswitch_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getCategoryMetaItemListFromFacetList()Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 498
    :pswitch_1
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getSizeMetaItemListFromFacetList()Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 500
    :pswitch_2
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getBrandMetaItemListFromFacetList()Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 502
    :pswitch_3
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getConditionMetaItemListFromFacetList()Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 504
    :pswitch_4
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getAvailabilityMetaItemListFromFacetList()Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 506
    :pswitch_5
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getStyleTagsMetaItemListFromFacetList()Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 494
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_1
        :pswitch_5
    .end packed-switch
.end method

.method public getFilterManager()Lcom/poshmark/utils/FilterResultsManager;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    return-object v0
.end method

.method public getPriceList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PriceInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 546
    invoke-static {}, Lcom/poshmark/db/DbApi;->getCannedPriceRanges()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getUnscrubbedColorFacetList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Facets$FacetItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 538
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    if-eqz v0, :cond_0

    .line 539
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Facets;->getColorFacets()Ljava/util/List;

    move-result-object v0

    .line 541
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getUnscrubbedFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;
    .locals 2
    .param p1, "metaItemMode"    # Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Facets$FacetItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 522
    sget-object v0, Lcom/poshmark/ui/fragments/PMFilterableFragment$6;->$SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES:[I

    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 534
    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 524
    :pswitch_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    if-eqz v0, :cond_0

    .line 525
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Facets;->getSizeFacets()Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 529
    :pswitch_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    if-eqz v0, :cond_0

    .line 530
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Facets;->getStyleTagsFacets()Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 522
    nop

    :pswitch_data_0
    .packed-switch 0x5
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 10
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 79
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "com.poshmark.intents.FILTER_SELECTION_ACTION"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 80
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v7

    .line 81
    .local v7, "b":Landroid/os/Bundle;
    const-string v2, "RESULT"

    invoke-virtual {v7, v2}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v8

    .line 82
    .local v8, "result":Landroid/os/Bundle;
    if-eqz v8, :cond_0

    .line 83
    const-string v2, "FILTER_ACTION"

    invoke-virtual {v8, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v6

    .line 84
    .local v6, "action":I
    packed-switch v6, :pswitch_data_0

    .line 119
    .end local v6    # "action":I
    .end local v7    # "b":Landroid/os/Bundle;
    .end local v8    # "result":Landroid/os/Bundle;
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 86
    .restart local v6    # "action":I
    .restart local v7    # "b":Landroid/os/Bundle;
    .restart local v8    # "result":Landroid/os/Bundle;
    :pswitch_1
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->launchBrandSelection()V

    goto :goto_0

    .line 89
    :pswitch_2
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->launchSizeSelection()V

    goto :goto_0

    .line 92
    :pswitch_3
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->launchPriceSelection()V

    goto :goto_0

    .line 95
    :pswitch_4
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->launchCategorySelection()V

    goto :goto_0

    .line 98
    :pswitch_5
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->launchConditionSelection()V

    goto :goto_0

    .line 101
    :pswitch_6
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->launchAvailabilitySelection()V

    goto :goto_0

    .line 104
    :pswitch_7
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->launchColorSelection()V

    goto :goto_0

    .line 107
    :pswitch_8
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->launchStyleTagSelection()V

    goto :goto_0

    .line 110
    :pswitch_9
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "filter_clicked"

    const-string v9, "all"

    invoke-virtual {v2, v3, v4, v5, v9}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 111
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 112
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 113
    .local v1, "bundle":Landroid/os/Bundle;
    const-string v2, "IS_DRAWER"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 114
    const-class v2, Lcom/poshmark/ui/fragments/ListingFiltersFragment;

    const/4 v5, 0x5

    move-object v3, p0

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMContainerActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    goto :goto_0

    .line 84
    nop

    :pswitch_data_0
    .packed-switch 0x5
        :pswitch_9
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
        :pswitch_5
        :pswitch_6
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_7
        :pswitch_8
        :pswitch_4
    .end packed-switch
.end method

.method public hideFilterButtonsForSingleFacet()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 550
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    if-nez v2, :cond_1

    .line 562
    :cond_0
    :goto_0
    return-void

    .line 552
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getIsG2FiltersEnabled()Z

    move-result v2

    if-nez v2, :cond_0

    .line 553
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/Facets;->getCategoryFacets()Ljava/util/List;

    move-result-object v1

    .line 554
    .local v1, "categoryFacets":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    if-eqz v1, :cond_2

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-ne v2, v4, :cond_2

    .line 555
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CATEGORY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->hideButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)V

    .line 557
    :cond_2
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/Facets;->getBrandFacets()Ljava/util/List;

    move-result-object v0

    .line 558
    .local v0, "brandFacets":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-ne v2, v4, :cond_0

    .line 559
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->BRAND:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->hideButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)V

    goto :goto_0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 25
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 198
    invoke-super/range {p0 .. p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 199
    const-string v17, ""

    .line 200
    .local v17, "selectedFilterKey":Ljava/lang/String;
    const-string v18, ""

    .line 201
    .local v18, "selectedFilterValue":Ljava/lang/String;
    const/4 v6, 0x0

    .line 203
    .local v6, "fireSearch":Z
    const/16 v16, 0x0

    .line 204
    .local v16, "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    const/4 v8, 0x0

    .line 205
    .local v8, "jsonString":Ljava/lang/String;
    const/4 v3, 0x0

    .line 208
    .local v3, "b":Landroid/os/Bundle;
    if-eqz p2, :cond_3

    .line 209
    const-string v19, "RETURNED_RESULTS"

    move-object/from16 v0, p3

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v3

    .line 210
    const-string v19, "DATA_SELECTED"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 211
    if-eqz v8, :cond_0

    .line 212
    const-class v19, Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v0, v19

    invoke-static {v8, v0}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v16

    .end local v16    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    check-cast v16, Lcom/poshmark/data_model/models/MetaItem;

    .line 214
    .restart local v16    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    packed-switch p1, :pswitch_data_0

    .line 363
    :cond_1
    :goto_0
    :pswitch_0
    invoke-virtual/range {v17 .. v17}, Ljava/lang/String;->length()I

    move-result v19

    if-lez v19, :cond_2

    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->length()I

    move-result v19

    if-lez v19, :cond_2

    .line 364
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v19

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->viewNameForAnalytics:Ljava/lang/String;

    move-object/from16 v20, v0

    const-string v21, "listing"

    const-string v22, "filter_selected"

    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v23

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    const-string v24, "/"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    move-object/from16 v0, v23

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v19 .. v23}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 366
    :cond_2
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v19

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->viewNameForAnalytics:Ljava/lang/String;

    move-object/from16 v20, v0

    const-string v21, "listing"

    const-string v22, "filter_applied"

    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Lcom/poshmark/utils/SearchFilterModel;->getLabelForAnalytics()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v19 .. v23}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 368
    :cond_3
    return-void

    .line 216
    :pswitch_1
    const-string v17, "brand"

    .line 217
    if-eqz v16, :cond_4

    .line 218
    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v18

    .line 219
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/FilterResultsManager;->updateBrand(Lcom/poshmark/data_model/models/MetaItem;)V

    .line 221
    :cond_4
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->filterContent()V

    goto :goto_0

    .line 225
    :pswitch_2
    const-string v17, "category"

    .line 226
    if-eqz v16, :cond_6

    .line 227
    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v18

    .line 228
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/FilterResultsManager;->updateCategory(Lcom/poshmark/data_model/models/MetaItem;)V

    .line 233
    :goto_1
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/poshmark/utils/FilterResultsManager;->clearsubCategories()V

    .line 234
    const-string v19, "TAGS_LIST"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 235
    .local v2, "arrayListJson":Ljava/lang/String;
    if-eqz v2, :cond_5

    .line 236
    new-instance v9, Lcom/poshmark/ui/fragments/PMFilterableFragment$1;

    move-object/from16 v0, p0

    invoke-direct {v9, v0}, Lcom/poshmark/ui/fragments/PMFilterableFragment$1;-><init>(Lcom/poshmark/ui/fragments/PMFilterableFragment;)V

    .line 238
    .local v9, "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v2, v9}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/util/List;

    .line 239
    .local v12, "newCategoryTags":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v12}, Lcom/poshmark/utils/FilterResultsManager;->updateSubCatogories(Ljava/util/List;)V

    .line 241
    .end local v9    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    .end local v12    # "newCategoryTags":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_5
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/poshmark/utils/FilterResultsManager;->clearSizeSelection()V

    .line 242
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->filterContent()V

    goto/16 :goto_0

    .line 230
    .end local v2    # "arrayListJson":Ljava/lang/String;
    :cond_6
    const-string v18, "all"

    .line 231
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/poshmark/utils/SearchFilterModel;->clearCategory()V

    goto :goto_1

    .line 246
    :pswitch_3
    const-string v17, "size"

    .line 247
    const-string v19, "SIZE_CHANGED"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v7

    .line 248
    .local v7, "isDataChanged":Z
    const-string v19, "MYSIZE_SWITCH_STATE"

    const/16 v20, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v11

    .line 249
    .local v11, "mySizeSwitchState":Z
    const/4 v10, 0x0

    .line 251
    .local v10, "mySizeStateChanged":Z
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/poshmark/utils/FilterResultsManager;->isMySizeEnabled()Z

    move-result v19

    move/from16 v0, v19

    if-eq v0, v11, :cond_7

    .line 252
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/poshmark/utils/FilterResultsManager;->toggleMySize()V

    .line 253
    const/4 v6, 0x1

    .line 254
    const/4 v10, 0x1

    .line 257
    :cond_7
    if-eqz v16, :cond_8

    .line 258
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/FilterResultsManager;->updateCategory(Lcom/poshmark/data_model/models/MetaItem;)V

    .line 259
    const/4 v6, 0x1

    .line 262
    :cond_8
    if-eqz v7, :cond_9

    .line 263
    const-string v19, "SIZE_LIST"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 264
    .restart local v2    # "arrayListJson":Ljava/lang/String;
    if-eqz v2, :cond_9

    .line 265
    new-instance v9, Lcom/poshmark/ui/fragments/PMFilterableFragment$2;

    move-object/from16 v0, p0

    invoke-direct {v9, v0}, Lcom/poshmark/ui/fragments/PMFilterableFragment$2;-><init>(Lcom/poshmark/ui/fragments/PMFilterableFragment;)V

    .line 267
    .restart local v9    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v2, v9}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/util/List;

    .line 268
    .local v14, "newSizes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v14}, Lcom/poshmark/utils/FilterResultsManager;->updateSizes(Ljava/util/List;)V

    .line 269
    const/4 v6, 0x1

    .line 270
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->filterContent()V

    .line 273
    .end local v2    # "arrayListJson":Ljava/lang/String;
    .end local v9    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    .end local v14    # "newSizes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_9
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/poshmark/utils/SearchFilterModel;->getCommaSeparatedSizes()Ljava/lang/String;

    move-result-object v18

    .line 274
    if-eqz v10, :cond_a

    .line 275
    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v19

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, "My Size"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    .line 277
    :cond_a
    if-eqz v6, :cond_1

    .line 278
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->filterContent()V

    goto/16 :goto_0

    .line 284
    .end local v7    # "isDataChanged":Z
    .end local v10    # "mySizeStateChanged":Z
    .end local v11    # "mySizeSwitchState":Z
    :pswitch_4
    const-string v17, "style"

    .line 286
    if-eqz v16, :cond_b

    .line 287
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/FilterResultsManager;->updateCategory(Lcom/poshmark/data_model/models/MetaItem;)V

    .line 288
    const/4 v6, 0x1

    .line 291
    :cond_b
    const-string v19, "TAGS_LIST"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 292
    .restart local v2    # "arrayListJson":Ljava/lang/String;
    if-eqz v2, :cond_c

    .line 293
    new-instance v9, Lcom/poshmark/ui/fragments/PMFilterableFragment$3;

    move-object/from16 v0, p0

    invoke-direct {v9, v0}, Lcom/poshmark/ui/fragments/PMFilterableFragment$3;-><init>(Lcom/poshmark/ui/fragments/PMFilterableFragment;)V

    .line 295
    .restart local v9    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v2, v9}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/util/List;

    .line 296
    .restart local v12    # "newCategoryTags":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v12}, Lcom/poshmark/utils/FilterResultsManager;->updateSubCatogories(Ljava/util/List;)V

    .line 297
    const/4 v6, 0x1

    .line 298
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->filterContent()V

    .line 300
    .end local v9    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    .end local v12    # "newCategoryTags":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_c
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/poshmark/utils/SearchFilterModel;->getCommaSeparatedTags()Ljava/lang/String;

    move-result-object v18

    .line 301
    if-eqz v6, :cond_1

    .line 302
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->filterContent()V

    goto/16 :goto_0

    .line 307
    .end local v2    # "arrayListJson":Ljava/lang/String;
    :pswitch_5
    const-string v17, "condition"

    .line 308
    if-eqz v16, :cond_1

    .line 309
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/FilterResultsManager;->updateCondition(Lcom/poshmark/data_model/models/MetaItem;)V

    .line 310
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->filterContent()V

    .line 311
    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v18

    goto/16 :goto_0

    .line 316
    :pswitch_6
    const-string v17, "inventory_status"

    .line 317
    if-eqz v16, :cond_1

    .line 318
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/FilterResultsManager;->updateAvailability(Lcom/poshmark/data_model/models/MetaItem;)V

    .line 319
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->filterContent()V

    .line 320
    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v18

    goto/16 :goto_0

    .line 325
    :pswitch_7
    const-string v17, "price"

    .line 326
    const-string v19, "PRICE_CHANGED"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v7

    .line 327
    .restart local v7    # "isDataChanged":Z
    if-eqz v7, :cond_1

    .line 328
    const-string v19, "PRICE_LIST"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 329
    .local v15, "priceJson":Ljava/lang/String;
    if-eqz v15, :cond_1

    .line 330
    new-instance v9, Lcom/poshmark/ui/fragments/PMFilterableFragment$4;

    move-object/from16 v0, p0

    invoke-direct {v9, v0}, Lcom/poshmark/ui/fragments/PMFilterableFragment$4;-><init>(Lcom/poshmark/ui/fragments/PMFilterableFragment;)V

    .line 332
    .restart local v9    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v15, v9}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/util/List;

    .line 333
    .local v13, "newPrices":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PriceInfo;>;"
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v13}, Lcom/poshmark/utils/FilterResultsManager;->updatePrices(Ljava/util/List;)V

    .line 334
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/poshmark/utils/FilterResultsManager;->getCommaSeparatedPrices()Ljava/lang/String;

    move-result-object v18

    .line 335
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->filterContent()V

    goto/16 :goto_0

    .line 341
    .end local v7    # "isDataChanged":Z
    .end local v9    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    .end local v13    # "newPrices":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PriceInfo;>;"
    .end local v15    # "priceJson":Ljava/lang/String;
    :pswitch_8
    const-string v17, "color"

    .line 342
    const-string v19, "COLOR_CHANGED"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v7

    .line 343
    .restart local v7    # "isDataChanged":Z
    if-eqz v7, :cond_1

    .line 344
    const-string v19, "COLOR_LIST"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 345
    .local v4, "colorJson":Ljava/lang/String;
    if-eqz v4, :cond_1

    .line 346
    new-instance v9, Lcom/poshmark/ui/fragments/PMFilterableFragment$5;

    move-object/from16 v0, p0

    invoke-direct {v9, v0}, Lcom/poshmark/ui/fragments/PMFilterableFragment$5;-><init>(Lcom/poshmark/ui/fragments/PMFilterableFragment;)V

    .line 348
    .restart local v9    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v4, v9}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    .line 349
    .local v5, "colors":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v5}, Lcom/poshmark/utils/FilterResultsManager;->updateColors(Ljava/util/List;)V

    .line 350
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/poshmark/utils/FilterResultsManager;->getCommaSeparatedPrices()Ljava/lang/String;

    move-result-object v18

    .line 351
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->filterContent()V

    goto/16 :goto_0

    .line 357
    .end local v4    # "colorJson":Ljava/lang/String;
    .end local v5    # "colors":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    .end local v7    # "isDataChanged":Z
    .end local v9    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    :pswitch_9
    const-string v19, "FILTERS_CHANGED"

    const/16 v20, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v19

    if-eqz v19, :cond_1

    .line 358
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->filterContent()V

    goto/16 :goto_0

    .line 214
    :pswitch_data_0
    .packed-switch 0x5
        :pswitch_9
        :pswitch_1
        :pswitch_0
        :pswitch_3
        :pswitch_7
        :pswitch_5
        :pswitch_6
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_8
        :pswitch_4
        :pswitch_2
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 44
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 45
    if-eqz p1, :cond_0

    .line 46
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/FilterResultsManager;->pullFromBundle(Landroid/os/Bundle;)V

    .line 48
    :cond_0
    return-void
.end method

.method public onPMResume()V
    .locals 2

    .prologue
    .line 57
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 58
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.FILTER_SELECTION_ACTION"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 59
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    if-eqz v0, :cond_0

    .line 60
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->updateFilterWidget()V

    .line 62
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 66
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 67
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/FilterResultsManager;->saveToBundle(Landroid/os/Bundle;)V

    .line 68
    return-void
.end method

.method public saveFacetLists(Lcom/poshmark/data_model/models/Facets;)V
    .locals 0
    .param p1, "facets"    # Lcom/poshmark/data_model/models/Facets;

    .prologue
    .line 490
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PMFilterableFragment;->facetLists:Lcom/poshmark/data_model/models/Facets;

    .line 491
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 0

    .prologue
    .line 53
    return-void
.end method
