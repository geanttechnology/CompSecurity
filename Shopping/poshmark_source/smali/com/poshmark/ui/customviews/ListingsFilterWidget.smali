.class public Lcom/poshmark/ui/customviews/ListingsFilterWidget;
.super Landroid/widget/HorizontalScrollView;
.source "ListingsFilterWidget.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/customviews/ListingsFilterWidget$2;,
        Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;,
        Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;
    }
.end annotation


# instance fields
.field final SEPARATOR:Ljava/lang/String;

.field final STANDARD_STYLE:I

.field buttons:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;",
            "Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;",
            ">;"
        }
    .end annotation
.end field

.field isEnhancedFilter:Z

.field isG2FiltersEnabled:Z

.field layoutType:I

.field ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

.field styleTagClickListener:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 52
    invoke-direct {p0, p1, p2}, Landroid/widget/HorizontalScrollView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 43
    iput v6, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->STANDARD_STYLE:I

    .line 44
    const-string v3, ", "

    iput-object v3, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->SEPARATOR:Ljava/lang/String;

    .line 45
    iput-boolean v6, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->isEnhancedFilter:Z

    .line 46
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    iput-object v3, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    .line 50
    iput-boolean v5, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->isG2FiltersEnabled:Z

    .line 285
    new-instance v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$1;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$1;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;)V

    iput-object v3, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->styleTagClickListener:Landroid/view/View$OnClickListener;

    .line 54
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getContext()Landroid/content/Context;

    move-result-object v3

    sget-object v4, Lcom/poshmark/app/R$styleable;->ListingsFilterWidget:[I

    invoke-virtual {v3, p2, v4}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 55
    .local v0, "array":Landroid/content/res/TypedArray;
    invoke-virtual {v0, v5, v6}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    iput v3, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->layoutType:I

    .line 57
    invoke-virtual {p0, v5}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->setHorizontalScrollBarEnabled(Z)V

    .line 59
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    .line 61
    .local v2, "inflater":Landroid/view/LayoutInflater;
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/FeatureManager;->isFilterBarv2FeatureEnabled()Z

    move-result v3

    iput-boolean v3, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->isG2FiltersEnabled:Z

    .line 63
    iget-boolean v3, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->isG2FiltersEnabled:Z

    if-eqz v3, :cond_0

    .line 64
    const v3, 0x7f03007d

    invoke-virtual {v2, v3, v7, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 68
    .local v1, "filterBar":Landroid/view/View;
    :goto_0
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->addView(Landroid/view/View;)V

    .line 70
    iget v3, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->layoutType:I

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->setupButtonLayout(I)V

    .line 71
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->updateFilterWidget()V

    .line 73
    return-void

    .line 66
    .end local v1    # "filterBar":Landroid/view/View;
    :cond_0
    const v3, 0x7f03007c

    invoke-virtual {v2, v3, v7, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .restart local v1    # "filterBar":Landroid/view/View;
    goto :goto_0
.end method

.method private getFilterCount()Ljava/lang/String;
    .locals 9

    .prologue
    .line 373
    const/4 v0, 0x0

    .local v0, "count":I
    const/4 v6, 0x0

    .line 374
    .local v6, "totalCount":I
    iget-object v7, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    invoke-interface {v7}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v5

    .line 375
    .local v5, "keyset":Ljava/util/Set;, "Ljava/util/Set<Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;>;"
    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .line 378
    .local v4, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;>;"
    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 379
    iget-object v7, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    .line 380
    .local v3, "info":Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;
    iget-object v7, v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->layout:Landroid/widget/LinearLayout;

    invoke-virtual {v7}, Landroid/widget/LinearLayout;->getVisibility()I

    move-result v7

    if-nez v7, :cond_0

    .line 381
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 385
    .end local v3    # "info":Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;
    :cond_1
    add-int/lit8 v6, v6, -0x1

    .line 387
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v2

    .line 388
    .local v2, "filters":Lcom/poshmark/utils/SearchFilterModel$SearchFilters;
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentBrand()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v7

    if-eqz v7, :cond_2

    add-int/lit8 v0, v0, 0x1

    .line 389
    :cond_2
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v7

    if-eqz v7, :cond_3

    add-int/lit8 v0, v0, 0x1

    .line 390
    :cond_3
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentAvailability()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v7

    const-string v8, "all_items"

    if-eq v7, v8, :cond_4

    add-int/lit8 v0, v0, 0x1

    .line 391
    :cond_4
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentCondition()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v7

    const-string v8, "not_nwt"

    if-eq v7, v8, :cond_5

    add-int/lit8 v0, v0, 0x1

    .line 392
    :cond_5
    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->isMySizeEnabled()Z

    move-result v7

    if-nez v7, :cond_6

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getSizeList()Ljava/util/List;

    move-result-object v7

    if-eqz v7, :cond_7

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getSizeList()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v7

    if-lez v7, :cond_7

    :cond_6
    add-int/lit8 v0, v0, 0x1

    .line 393
    :cond_7
    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getColorList()Ljava/util/List;

    move-result-object v7

    if-eqz v7, :cond_8

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getColorList()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v7

    if-lez v7, :cond_8

    add-int/lit8 v0, v0, 0x1

    .line 394
    :cond_8
    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getPriceRangeDisplayList()Ljava/util/List;

    move-result-object v7

    if-eqz v7, :cond_9

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getPriceRangeDisplayList()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v7

    if-lez v7, :cond_9

    add-int/lit8 v0, v0, 0x1

    .line 397
    :cond_9
    if-lez v0, :cond_a

    .line 398
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "/"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 402
    .local v1, "displayString":Ljava/lang/String;
    :goto_1
    return-object v1

    .line 400
    .end local v1    # "displayString":Ljava/lang/String;
    :cond_a
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ""

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .restart local v1    # "displayString":Ljava/lang/String;
    goto :goto_1
.end method

.method private getFilteredAvailabilityString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 448
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getAvailabilityAsMetaItem()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    .line 449
    .local v0, "currentAvailability":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v2

    const-string v3, "available"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 450
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v3, 0x7f060050

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 457
    .local v1, "displayString":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 451
    .end local v1    # "displayString":Ljava/lang/String;
    :cond_0
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v2

    const-string v3, "sold_out"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 452
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v3, 0x7f060286

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    .restart local v1    # "displayString":Ljava/lang/String;
    goto :goto_0

    .line 454
    .end local v1    # "displayString":Ljava/lang/String;
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v3, 0x7f06003c

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    .restart local v1    # "displayString":Ljava/lang/String;
    goto :goto_0
.end method

.method private getFilteredBrandsDisplayString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 405
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentBrand()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getFilteredCategoryDisplayString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 409
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getFilteredColorsDisplayString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 461
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->getColorList()Ljava/util/List;

    move-result-object v0

    const-string v1, ", "

    invoke-static {v0, v1}, Lcom/poshmark/utils/StringUtils;->join(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getFilteredConditionsDisplayString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 435
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentCondition()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    .line 437
    .local v1, "id":Ljava/lang/String;
    const-string v2, "ret"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 438
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v3, 0x7f06022d

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 444
    .local v0, "displayString":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 439
    .end local v0    # "displayString":Ljava/lang/String;
    :cond_0
    const-string v2, "nwt"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 440
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v3, 0x7f0601d7

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "displayString":Ljava/lang/String;
    goto :goto_0

    .line 442
    .end local v0    # "displayString":Ljava/lang/String;
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v3, 0x7f06003c

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "displayString":Ljava/lang/String;
    goto :goto_0
.end method

.method private getFilteredPricesDisplayString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 432
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getPriceRangeDisplayList()Ljava/util/List;

    move-result-object v0

    const-string v1, ", "

    invoke-static {v0, v1}, Lcom/poshmark/utils/StringUtils;->join(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getFilteredSizesDisplayString()Ljava/lang/String;
    .locals 8

    .prologue
    .line 413
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    .line 414
    .local v0, "category":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->isMySizeEnabled()Z

    move-result v4

    .line 415
    .local v4, "mySizeEnabled":Z
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getSizeList()Ljava/util/List;

    move-result-object v5

    .line 416
    .local v5, "sizes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 417
    .local v1, "displayString":Ljava/lang/StringBuilder;
    if-eqz v4, :cond_0

    .line 418
    iget-object v6, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v7, 0x7f0601ba

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 419
    if-eqz v0, :cond_0

    if-eqz v5, :cond_0

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v6

    if-lez v6, :cond_0

    const-string v6, ", "

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 421
    :cond_0
    if-eqz v0, :cond_2

    if-eqz v5, :cond_2

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v6

    if-lez v6, :cond_2

    .line 422
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 423
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-static {v7, v6}, Lcom/poshmark/db/DbApi;->getSizeForCategoryFromLabel(Ljava/lang/String;Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v3

    .line 424
    .local v3, "longSize":Lcom/poshmark/data_model/models/MetaItem;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ", "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 427
    .end local v3    # "longSize":Lcom/poshmark/data_model/models/MetaItem;
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v6

    add-int/lit8 v6, v6, -0x2

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->deleteCharAt(I)Ljava/lang/StringBuilder;

    .line 429
    .end local v2    # "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_2
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    return-object v6
.end method

.method private updateFilterView()V
    .locals 14

    .prologue
    const/16 v13, 0xe6

    const/16 v12, 0xe2

    const/16 v11, 0xdf

    const/16 v10, 0x7d

    const/4 v9, 0x0

    .line 221
    sget-object v7, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CATEGORY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {p0, v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    move-result-object v1

    .line 222
    .local v1, "buttonInfo":Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v7

    if-nez v7, :cond_4

    .line 223
    iget-object v7, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    invoke-virtual {v7, v9}, Landroid/widget/Button;->setBackgroundColor(I)V

    .line 229
    :goto_0
    sget-object v7, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->BRAND:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {p0, v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    move-result-object v1

    .line 230
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentBrand()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v7

    if-nez v7, :cond_5

    .line 231
    iget-object v7, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    invoke-virtual {v7, v9}, Landroid/widget/Button;->setBackgroundColor(I)V

    .line 237
    :goto_1
    sget-object v7, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->SIZE:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {p0, v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    move-result-object v1

    .line 238
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getSizeList()Ljava/util/List;

    move-result-object v4

    .line 239
    .local v4, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->isMySizeEnabled()Z

    move-result v5

    .line 240
    .local v5, "mySizeEnabled":Z
    if-nez v5, :cond_6

    if-eqz v4, :cond_0

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v7

    if-nez v7, :cond_6

    .line 241
    :cond_0
    iget-object v7, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    invoke-virtual {v7, v9}, Landroid/widget/Button;->setBackgroundColor(I)V

    .line 247
    :goto_2
    sget-object v7, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->PRICE:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {p0, v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    move-result-object v1

    .line 248
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getPriceRangeList()Ljava/util/List;

    move-result-object v6

    .line 249
    .local v6, "priceInfoList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PriceInfo;>;"
    if-eqz v6, :cond_1

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v7

    if-nez v7, :cond_7

    .line 250
    :cond_1
    iget-object v7, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    invoke-virtual {v7, v9}, Landroid/widget/Button;->setBackgroundColor(I)V

    .line 256
    :goto_3
    sget-object v7, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CONDITION:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {p0, v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    move-result-object v1

    .line 257
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getConditionList()Ljava/util/List;

    move-result-object v4

    .line 258
    if-eqz v4, :cond_2

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v7

    if-nez v7, :cond_8

    .line 259
    :cond_2
    iget-object v7, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    invoke-virtual {v7, v9}, Landroid/widget/Button;->setBackgroundColor(I)V

    .line 265
    :goto_4
    sget-object v7, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->AVAILABILITY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {p0, v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    move-result-object v1

    .line 266
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/SearchFilterModel;->getAvailabilityAsMetaItem()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v3

    .line 267
    .local v3, "currentAvailability":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v3, :cond_3

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v7

    const-string v8, "all_items"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_9

    .line 268
    :cond_3
    iget-object v7, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    invoke-virtual {v7, v9}, Landroid/widget/Button;->setBackgroundColor(I)V

    .line 274
    :goto_5
    sget-object v7, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->COLOR:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {p0, v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    move-result-object v1

    .line 275
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/SearchFilterModel;->getColorList()Ljava/util/List;

    move-result-object v2

    .line 276
    .local v2, "colorList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez v2, :cond_a

    .line 277
    iget-object v7, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    invoke-virtual {v7, v9}, Landroid/widget/Button;->setBackgroundColor(I)V

    .line 282
    :goto_6
    return-void

    .line 225
    .end local v2    # "colorList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v3    # "currentAvailability":Lcom/poshmark/data_model/models/MetaItem;
    .end local v4    # "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v5    # "mySizeEnabled":Z
    .end local v6    # "priceInfoList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PriceInfo;>;"
    :cond_4
    invoke-static {v10, v13, v12, v11}, Landroid/graphics/Color;->argb(IIII)I

    move-result v0

    .line 226
    .local v0, "bgColorGray":I
    iget-object v7, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    invoke-virtual {v7, v0}, Landroid/widget/Button;->setBackgroundColor(I)V

    goto/16 :goto_0

    .line 233
    .end local v0    # "bgColorGray":I
    :cond_5
    invoke-static {v10, v13, v12, v11}, Landroid/graphics/Color;->argb(IIII)I

    move-result v0

    .line 234
    .restart local v0    # "bgColorGray":I
    iget-object v7, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    invoke-virtual {v7, v0}, Landroid/widget/Button;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 243
    .end local v0    # "bgColorGray":I
    .restart local v4    # "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v5    # "mySizeEnabled":Z
    :cond_6
    invoke-static {v10, v13, v12, v11}, Landroid/graphics/Color;->argb(IIII)I

    move-result v0

    .line 244
    .restart local v0    # "bgColorGray":I
    iget-object v7, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    invoke-virtual {v7, v0}, Landroid/widget/Button;->setBackgroundColor(I)V

    goto/16 :goto_2

    .line 252
    .end local v0    # "bgColorGray":I
    .restart local v6    # "priceInfoList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PriceInfo;>;"
    :cond_7
    invoke-static {v10, v13, v12, v11}, Landroid/graphics/Color;->argb(IIII)I

    move-result v0

    .line 253
    .restart local v0    # "bgColorGray":I
    iget-object v7, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    invoke-virtual {v7, v0}, Landroid/widget/Button;->setBackgroundColor(I)V

    goto :goto_3

    .line 261
    .end local v0    # "bgColorGray":I
    :cond_8
    invoke-static {v10, v13, v12, v11}, Landroid/graphics/Color;->argb(IIII)I

    move-result v0

    .line 262
    .restart local v0    # "bgColorGray":I
    iget-object v7, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    invoke-virtual {v7, v0}, Landroid/widget/Button;->setBackgroundColor(I)V

    goto :goto_4

    .line 270
    .end local v0    # "bgColorGray":I
    .restart local v3    # "currentAvailability":Lcom/poshmark/data_model/models/MetaItem;
    :cond_9
    invoke-static {v10, v13, v12, v11}, Landroid/graphics/Color;->argb(IIII)I

    move-result v0

    .line 271
    .restart local v0    # "bgColorGray":I
    iget-object v7, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    invoke-virtual {v7, v0}, Landroid/widget/Button;->setBackgroundColor(I)V

    goto :goto_5

    .line 279
    .end local v0    # "bgColorGray":I
    .restart local v2    # "colorList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_a
    invoke-static {v10, v13, v12, v11}, Landroid/graphics/Color;->argb(IIII)I

    move-result v0

    .line 280
    .restart local v0    # "bgColorGray":I
    iget-object v7, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    invoke-virtual {v7, v0}, Landroid/widget/Button;->setBackgroundColor(I)V

    goto :goto_6
.end method


# virtual methods
.method public getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;
    .locals 2
    .param p1, "buttonType"    # Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    .prologue
    .line 328
    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    .line 329
    .local v0, "info":Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;
    if-eqz v0, :cond_0

    .line 332
    .end local v0    # "info":Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;
    :goto_0
    return-object v0

    .restart local v0    # "info":Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getFilterManager()Lcom/poshmark/utils/FilterResultsManager;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    if-eqz v0, :cond_0

    .line 94
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    check-cast v0, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    .line 96
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getIsG2FiltersEnabled()Z
    .locals 1

    .prologue
    .line 76
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->isG2FiltersEnabled:Z

    return v0
.end method

.method public getSearchModel()Lcom/poshmark/utils/SearchFilterModel;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    if-eqz v0, :cond_0

    .line 86
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    check-cast v0, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    .line 88
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hideButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)V
    .locals 5
    .param p1, "buttonType"    # Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    .prologue
    const/16 v4, 0x8

    .line 109
    const/4 v1, 0x0

    .line 110
    .local v1, "separatorView":Landroid/view/View;
    invoke-virtual {p0, p1}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    move-result-object v0

    .line 111
    .local v0, "buttonInfo":Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;
    if-eqz v0, :cond_0

    .line 112
    iget-boolean v2, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->isG2FiltersEnabled:Z

    if-eqz v2, :cond_2

    .line 113
    iget-object v2, v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->layout:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 120
    :cond_0
    :goto_0
    sget-object v2, Lcom/poshmark/ui/customviews/ListingsFilterWidget$2;->$SwitchMap$com$poshmark$ui$customviews$ListingsFilterWidget$FILTER_BUTTON:[I

    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 132
    :goto_1
    if-eqz v1, :cond_1

    .line 133
    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 135
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->updateFilterWidget()V

    .line 136
    return-void

    .line 115
    :cond_2
    iget-object v2, v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    invoke-virtual {v2, v4}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_0

    .line 122
    :pswitch_0
    const v2, 0x7f0c01e0

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 123
    goto :goto_1

    .line 125
    :pswitch_1
    const v2, 0x7f0c01de

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 126
    goto :goto_1

    .line 128
    :pswitch_2
    const v2, 0x7f0c01e2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->findViewById(I)Landroid/view/View;

    move-result-object v1

    goto :goto_1

    .line 120
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public hideWidget()V
    .locals 1

    .prologue
    .line 101
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->setVisibility(I)V

    .line 102
    return-void
.end method

.method public setOwnerFragment(Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 0
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 82
    return-void
.end method

.method public setupButtonLayout(I)V
    .locals 14
    .param p1, "layoutStyle"    # I

    .prologue
    const/16 v13, 0xa

    const/16 v12, 0x9

    const/16 v11, 0x8

    const/4 v10, 0x6

    const/4 v4, 0x5

    .line 295
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->isG2FiltersEnabled:Z

    if-eqz v0, :cond_0

    .line 296
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->FILTER:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060121

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->FILTER:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const v5, 0x7f0c01e9

    const v6, 0x7f0c01dc

    const v7, 0x7f0c01ea

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 297
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->BRAND:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06011d

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->BRAND:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const v5, 0x7f0c01ec

    const v6, 0x7f0c01dd

    const v7, 0x7f0c01ed

    move-object v1, p0

    move v4, v10

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 298
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CATEGORY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06011e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CATEGORY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const/16 v4, 0x11

    const v5, 0x7f0c01ee

    const v6, 0x7f0c01df

    const v7, 0x7f0c01ef

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 299
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CONDITION:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060120

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CONDITION:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const v5, 0x7f0c01f0

    const v6, 0x7f0c01e1

    const v7, 0x7f0c01f1

    move-object v1, p0

    move v4, v13

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 300
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->COLOR:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06011f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->COLOR:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const/16 v4, 0xf

    const v5, 0x7f0c01f2

    const v6, 0x7f0c01e3

    const v7, 0x7f0c01f3

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 301
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->SIZE:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060123

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->SIZE:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const v5, 0x7f0c01f4

    const v6, 0x7f0c01e5

    const v7, 0x7f0c01f5

    move-object v1, p0

    move v4, v11

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 302
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->PRICE:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060122

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->PRICE:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const v5, 0x7f0c01f6

    const v6, 0x7f0c01e7

    const v7, 0x7f0c01f7

    move-object v1, p0

    move v4, v12

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 303
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->AVAILABILITY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06011c

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->AVAILABILITY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const/16 v4, 0xb

    const v5, 0x7f0c01f8

    const v6, 0x7f0c01e8

    const v7, 0x7f0c01f9

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 325
    :goto_0
    return-void

    .line 305
    :cond_0
    const/4 v0, 0x1

    if-ne p1, v0, :cond_1

    .line 306
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->FILTER:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060121

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->FILTER:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const v5, 0x7f0c01e9

    const v6, 0x7f0c01dc

    const v7, 0x7f0c01ea

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 307
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->BRAND:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06011d

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->BRAND:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const v5, 0x7f0c01ec

    const v6, 0x7f0c01dd

    const v7, 0x7f0c01ed

    move-object v1, p0

    move v4, v10

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 308
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CATEGORY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06011e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CATEGORY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const/16 v4, 0x11

    const v5, 0x7f0c01ee

    const v6, 0x7f0c01df

    const v7, 0x7f0c01ef

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 309
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->COLOR:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06011f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->COLOR:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const/16 v4, 0xf

    const v5, 0x7f0c01f0

    const v6, 0x7f0c01e1

    const v7, 0x7f0c01f1

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 310
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->SIZE:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060123

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->SIZE:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const v5, 0x7f0c01f2

    const v6, 0x7f0c01e3

    const v7, 0x7f0c01f3

    move-object v1, p0

    move v4, v11

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 311
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->PRICE:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060122

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->PRICE:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const v5, 0x7f0c01f4

    const v6, 0x7f0c01e5

    const v7, 0x7f0c01f5

    move-object v1, p0

    move v4, v12

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 312
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CONDITION:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060120

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CONDITION:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const v5, 0x7f0c01f6

    const v6, 0x7f0c01e7

    const v7, 0x7f0c01f7

    move-object v1, p0

    move v4, v13

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 313
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->AVAILABILITY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06011c

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->AVAILABILITY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const/16 v4, 0xb

    const v5, 0x7f0c01f8

    const v6, 0x7f0c01e8

    const v7, 0x7f0c01f9

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 315
    :cond_1
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->FILTER:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060121

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->FILTER:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const v5, 0x7f0c01e9

    const v6, 0x7f0c01dc

    const v7, 0x7f0c01ea

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 316
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->BRAND:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06011d

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->BRAND:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const v5, 0x7f0c01ec

    const v6, 0x7f0c01dd

    const v7, 0x7f0c01ed

    move-object v1, p0

    move v4, v10

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 317
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CATEGORY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06011e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CATEGORY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const/16 v4, 0x11

    const v5, 0x7f0c01ee

    const v6, 0x7f0c01df

    const v7, 0x7f0c01ef

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 318
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->AVAILABILITY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06011c

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->AVAILABILITY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const/16 v4, 0xb

    const v5, 0x7f0c01f0

    const v6, 0x7f0c01e1

    const v7, 0x7f0c01f1

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 319
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->PRICE:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060122

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->PRICE:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const v5, 0x7f0c01f2

    const v6, 0x7f0c01e3

    const v7, 0x7f0c01f3

    move-object v1, p0

    move v4, v12

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 320
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->COLOR:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06011f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->COLOR:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const/16 v4, 0xf

    const v5, 0x7f0c01f4

    const v6, 0x7f0c01e5

    const v7, 0x7f0c01f5

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 321
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->SIZE:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060123

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->SIZE:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const v5, 0x7f0c01f6

    const v6, 0x7f0c01e7

    const v7, 0x7f0c01f7

    move-object v1, p0

    move v4, v11

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 322
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->buttons:Ljava/util/Map;

    sget-object v9, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CONDITION:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060120

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CONDITION:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    const v5, 0x7f0c01f8

    const v6, 0x7f0c01e8

    const v7, 0x7f0c01f9

    move-object v1, p0

    move v4, v13

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V

    invoke-interface {v8, v9, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0
.end method

.method public showWidget()V
    .locals 1

    .prologue
    .line 105
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->setVisibility(I)V

    .line 106
    return-void
.end method

.method public updateEnhancedFilterView()V
    .locals 12

    .prologue
    const v11, 0x7f09003c

    .line 150
    iget-object v8, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v9, 0x7f06003c

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 151
    .local v0, "all":Ljava/lang/String;
    sget-object v8, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->FILTER:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {p0, v8}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    move-result-object v1

    .line 152
    .local v1, "buttonInfo":Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "("

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-direct {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterCount()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ")"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 154
    sget-object v8, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CATEGORY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {p0, v8}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    move-result-object v1

    .line 155
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v8

    if-nez v8, :cond_4

    .line 156
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v8, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 166
    :goto_0
    sget-object v8, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->BRAND:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {p0, v8}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    move-result-object v1

    .line 167
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentBrand()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v8

    if-nez v8, :cond_6

    .line 168
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v8, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 174
    :goto_1
    sget-object v8, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->SIZE:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {p0, v8}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    move-result-object v1

    .line 175
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getSizeList()Ljava/util/List;

    move-result-object v5

    .line 176
    .local v5, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->isMySizeEnabled()Z

    move-result v6

    .line 177
    .local v6, "mySizeEnabled":Z
    if-nez v6, :cond_7

    if-eqz v5, :cond_0

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v8

    if-nez v8, :cond_7

    .line 178
    :cond_0
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v8, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 184
    :goto_2
    sget-object v8, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->PRICE:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {p0, v8}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    move-result-object v1

    .line 185
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getPriceRangeList()Ljava/util/List;

    move-result-object v7

    .line 186
    .local v7, "priceInfoList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PriceInfo;>;"
    if-eqz v7, :cond_1

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v8

    if-nez v8, :cond_8

    .line 187
    :cond_1
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v8, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 193
    :goto_3
    sget-object v8, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->CONDITION:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {p0, v8}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    move-result-object v1

    .line 194
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getConditionList()Ljava/util/List;

    move-result-object v5

    .line 195
    if-eqz v5, :cond_2

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v8

    if-nez v8, :cond_9

    .line 196
    :cond_2
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v8, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 202
    :goto_4
    sget-object v8, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->AVAILABILITY:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {p0, v8}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    move-result-object v1

    .line 203
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/SearchFilterModel;->getAvailabilityAsMetaItem()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v4

    .line 204
    .local v4, "currentAvailability":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v4, :cond_3

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v8

    const-string v9, "all_items"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_a

    .line 205
    :cond_3
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v8, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 211
    :goto_5
    sget-object v8, Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;->COLOR:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    invoke-virtual {p0, v8}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getButton(Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;)Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    move-result-object v1

    .line 212
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/SearchFilterModel;->getColorList()Ljava/util/List;

    move-result-object v3

    .line 213
    .local v3, "colorList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez v3, :cond_b

    .line 214
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v8, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 219
    :goto_6
    return-void

    .line 158
    .end local v3    # "colorList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v4    # "currentAvailability":Lcom/poshmark/data_model/models/MetaItem;
    .end local v5    # "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v6    # "mySizeEnabled":Z
    .end local v7    # "priceInfoList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PriceInfo;>;"
    :cond_4
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilteredCategoryDisplayString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v2, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 159
    .local v2, "category":Ljava/lang/StringBuilder;
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentSubCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v8

    if-eqz v8, :cond_5

    .line 160
    const-string v8, " | "

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v9

    invoke-virtual {v9}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentSubCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v9

    invoke-virtual {v9}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 162
    :cond_5
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 163
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    invoke-virtual {v9, v11}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    goto/16 :goto_0

    .line 170
    .end local v2    # "category":Ljava/lang/StringBuilder;
    :cond_6
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-direct {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilteredBrandsDisplayString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 171
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    invoke-virtual {v9, v11}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    goto/16 :goto_1

    .line 180
    .restart local v5    # "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v6    # "mySizeEnabled":Z
    :cond_7
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-direct {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilteredSizesDisplayString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 181
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    invoke-virtual {v9, v11}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    goto/16 :goto_2

    .line 189
    .restart local v7    # "priceInfoList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PriceInfo;>;"
    :cond_8
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-direct {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilteredPricesDisplayString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 190
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    invoke-virtual {v9, v11}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    goto/16 :goto_3

    .line 198
    :cond_9
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-direct {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilteredConditionsDisplayString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 199
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    invoke-virtual {v9, v11}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    goto/16 :goto_4

    .line 207
    .restart local v4    # "currentAvailability":Lcom/poshmark/data_model/models/MetaItem;
    :cond_a
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-direct {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilteredAvailabilityString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 208
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    invoke-virtual {v9, v11}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    goto/16 :goto_5

    .line 216
    .restart local v3    # "colorList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_b
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-direct {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getFilteredColorsDisplayString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 217
    iget-object v8, v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    invoke-virtual {v9, v11}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    goto/16 :goto_6
.end method

.method public updateFilterWidget()V
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    if-nez v0, :cond_0

    .line 148
    :goto_0
    return-void

    .line 141
    :cond_0
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->isG2FiltersEnabled:Z

    if-eqz v0, :cond_1

    .line 142
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->updateEnhancedFilterView()V

    goto :goto_0

    .line 144
    :cond_1
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->updateFilterView()V

    goto :goto_0
.end method
