.class public Lcom/poshmark/ui/fragments/CategoryListFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "CategoryListFragment.java"


# instance fields
.field allOptionVisible:Z

.field allowMultiSelect:Z

.field backoutFlag:Z

.field categoryAdapter:Lcom/poshmark/data_model/adapters/CategoryAdapter;

.field currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

.field currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

.field isBrowseMode:Z

.field isListingMode:Z

.field listHeaderView:Landroid/view/View;

.field listView:Landroid/widget/ListView;

.field parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

.field returnResult:Z

.field selectAllOptionForNoSelections:Z

.field selectedCategory:Lcom/poshmark/data_model/models/MetaItem;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 38
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 43
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->allowMultiSelect:Z

    .line 45
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->allOptionVisible:Z

    .line 46
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->selectAllOptionForNoSelections:Z

    .line 49
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->backoutFlag:Z

    .line 51
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->returnResult:Z

    .line 52
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->isBrowseMode:Z

    .line 53
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->isListingMode:Z

    return-void
.end method

.method private setupAdapter()V
    .locals 5

    .prologue
    .line 235
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    if-eqz v1, :cond_2

    .line 236
    new-instance v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-direct {v1}, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;-><init>()V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    .line 237
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->CATEGORY_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->categoryFacetList:Ljava/util/List;

    .line 238
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->STYLE_TAGS:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getUnscrubbedFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->subCategoryFacetList:Ljava/util/List;

    .line 239
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/PMFilterableFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 240
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v1, :cond_1

    .line 241
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/poshmark/db/DbApi;->getSubCategoriesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 242
    .local v0, "allTagsForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->STYLE_TAGS:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getUnscrubbedFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/poshmark/utils/ListingsFilterUtils;->getScrubbedList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    .line 243
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    if-nez v1, :cond_0

    .line 244
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    .line 246
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    .line 247
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentSubCategories()Ljava/util/List;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 253
    .end local v0    # "allTagsForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_1
    :goto_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-static {v1}, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->clone(Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;)Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    .line 254
    new-instance v1, Lcom/poshmark/data_model/adapters/CategoryAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f03001f

    iget-object v4, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-direct {v1, v2, v3, v4, p0}, Lcom/poshmark/data_model/adapters/CategoryAdapter;-><init>(Landroid/content/Context;ILcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;Lcom/poshmark/ui/fragments/CategoryListFragment;)V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->categoryAdapter:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    .line 255
    return-void

    .line 249
    :cond_2
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    if-nez v1, :cond_1

    .line 250
    new-instance v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-direct {v1}, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;-><init>()V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    .line 251
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-static {}, Lcom/poshmark/db/DbApi;->getAllCategories()Ljava/util/List;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->categoryFacetList:Ljava/util/List;

    goto :goto_0
.end method


# virtual methods
.method public allItemSelected()V
    .locals 7

    .prologue
    .line 325
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    const/4 v6, 0x0

    iput-object v6, v5, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 326
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v5, v5, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->clear()V

    .line 327
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v5, v5, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    const-class v6, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v5, v6}, Lcom/poshmark/utils/StringUtils;->toJson(Lcom/poshmark/data_model/models/MetaItem;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    .line 328
    .local v2, "json":Ljava/lang/String;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 329
    .local v0, "b":Landroid/os/Bundle;
    const-string v5, "DATA_SELECTED"

    invoke-virtual {v0, v5, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 330
    new-instance v5, Lcom/poshmark/ui/fragments/CategoryListFragment$4;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/CategoryListFragment$4;-><init>(Lcom/poshmark/ui/fragments/CategoryListFragment;)V

    invoke-virtual {v5}, Lcom/poshmark/ui/fragments/CategoryListFragment$4;->getType()Ljava/lang/reflect/Type;

    move-result-object v3

    .line 331
    .local v3, "listOfObjectType":Ljava/lang/reflect/Type;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v5, v5, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-static {v5, v3}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/util/List;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v4

    .line 332
    .local v4, "tagsJson":Ljava/lang/String;
    const-string v5, "TAGS_LIST"

    invoke-virtual {v0, v5, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 333
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 334
    .local v1, "i":Landroid/content/Intent;
    const-string v5, "RETURNED_RESULTS"

    invoke-virtual {v1, v5, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 335
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/CategoryListFragment;->returnResult(Landroid/content/Intent;)V

    .line 336
    return-void
.end method

.method public getListHeaderView()Landroid/view/View;
    .locals 1

    .prologue
    .line 301
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->listHeaderView:Landroid/view/View;

    return-object v0
.end method

.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    const-string v0, "ct"

    return-object v0
.end method

.method public isListingFlow()Z
    .locals 1

    .prologue
    .line 374
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->isListingMode:Z

    return v0
.end method

.method public itemSelected(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 8
    .param p1, "selection"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 339
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iput-object p1, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 340
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/poshmark/db/DbApi;->getSubCategoriesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 341
    .local v6, "allTagsForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v3, v3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->subCategoryFacetList:Ljava/util/List;

    invoke-static {v6, v3}, Lcom/poshmark/utils/ListingsFilterUtils;->getScrubbedList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    iput-object v3, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    .line 342
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    if-nez v2, :cond_0

    .line 343
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    .line 345
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v3, v3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 346
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 353
    :goto_0
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/poshmark/db/DbApi;->OTHER_ID:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 354
    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->returnResult:Z

    if-eqz v2, :cond_3

    .line 355
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->returnData()V

    .line 371
    :cond_1
    :goto_1
    return-void

    .line 348
    :cond_2
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 349
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v3, v3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-interface {v2, v3}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 357
    :cond_3
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->propogateResult()V

    goto :goto_1

    .line 360
    :cond_4
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 361
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "SHOW_ALL_VISIBLE"

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 362
    const-string v2, "SET_SHOW_ALL"

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->showSubCategoryAllChecked()Z

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 363
    const-string v2, "SHOW_ALL_AS_NONE"

    iget-boolean v3, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->isListingMode:Z

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 364
    const-string v2, "LISTING_FLOW_MODE"

    iget-boolean v3, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->isListingMode:Z

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 365
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 366
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/SubCategoryListFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    const/4 v5, 0x7

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 367
    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->isBrowseMode:Z

    if-eqz v2, :cond_1

    .line 368
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "browse_listings_by_category_shop_tab"

    const/4 v7, 0x0

    invoke-virtual {v2, v3, v4, v5, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 87
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 88
    if-nez p1, :cond_0

    .line 89
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0205

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->listView:Landroid/widget/ListView;

    .line 90
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->setupHeaderView()V

    .line 91
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->listView:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->categoryAdapter:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 92
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->categoryAdapter:Lcom/poshmark/data_model/adapters/CategoryAdapter;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->listView:Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->setListView(Landroid/widget/ListView;)V

    .line 94
    :cond_0
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 5
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 141
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 142
    if-eqz p2, :cond_1

    .line 143
    const-string v3, "RETURNED_RESULTS"

    invoke-virtual {p3, v3}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 144
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "TAGS_LIST"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 145
    .local v2, "sizeJson":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 146
    new-instance v1, Lcom/poshmark/ui/fragments/CategoryListFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/CategoryListFragment$2;-><init>(Lcom/poshmark/ui/fragments/CategoryListFragment;)V

    .line 148
    .local v1, "listOfObject":Lcom/google/gson/reflect/TypeToken;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-static {v2, v1}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    iput-object v3, v4, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    .line 151
    .end local v1    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    :cond_0
    iget-boolean v3, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->returnResult:Z

    if-eqz v3, :cond_2

    .line 152
    invoke-virtual {p0, p3}, Lcom/poshmark/ui/fragments/CategoryListFragment;->returnResult(Landroid/content/Intent;)V

    .line 159
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v2    # "sizeJson":Ljava/lang/String;
    :cond_1
    :goto_0
    return-void

    .line 155
    .restart local v0    # "b":Landroid/os/Bundle;
    .restart local v2    # "sizeJson":Ljava/lang/String;
    :cond_2
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->propogateResult()V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 57
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 58
    if-nez p1, :cond_0

    .line 59
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "MULTI_SELECT_ENABLED"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->allowMultiSelect:Z

    .line 60
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "SHOW_ALL_VISIBLE"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->allOptionVisible:Z

    .line 61
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "SET_SHOW_ALL"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->selectAllOptionForNoSelections:Z

    .line 62
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ENABLE_BROWSE_MODE"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->isBrowseMode:Z

    .line 63
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ENABLE_LISTING_MODE"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->isListingMode:Z

    .line 64
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "RETURN_RESULT"

    invoke-virtual {v0, v1, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->returnResult:Z

    .line 65
    const-class v0, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    .line 66
    const-class v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    .line 67
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->setupAdapter()V

    .line 71
    :goto_0
    return-void

    .line 69
    :cond_0
    iput-boolean v3, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->backoutFlag:Z

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 80
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 81
    const v1, 0x7f0300c1

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 82
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onFragmentResult(Landroid/os/Bundle;I)V
    .locals 4
    .param p1, "b"    # Landroid/os/Bundle;
    .param p2, "requestCode"    # I

    .prologue
    .line 163
    const/16 v2, 0x11

    if-ne p2, v2, :cond_0

    .line 164
    if-eqz p1, :cond_1

    .line 165
    const-string v2, "DATA_SELECTED"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 166
    .local v1, "jsonString":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 167
    const-class v2, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v1, v2}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/MetaItem;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->selectedCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 169
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->selectedCategory:Lcom/poshmark/data_model/models/MetaItem;

    iput-object v3, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 170
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->selectedCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/poshmark/db/DbApi;->getSubCategoriesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 171
    .local v0, "allTagsForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v3, v3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->subCategoryFacetList:Ljava/util/List;

    invoke-static {v0, v3}, Lcom/poshmark/utils/ListingsFilterUtils;->getScrubbedList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    iput-object v3, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    .line 172
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    if-nez v2, :cond_0

    .line 173
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    .line 183
    .end local v0    # "allTagsForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    .end local v1    # "jsonString":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 180
    :cond_1
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->backoutFlag:Z

    goto :goto_0
.end method

.method public onPMResume()V
    .locals 1

    .prologue
    .line 98
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 99
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->backoutFlag:Z

    if-eqz v0, :cond_0

    .line 100
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->onBackPressed()V

    .line 103
    :cond_0
    return-void
.end method

.method public propogateResult()V
    .locals 9

    .prologue
    .line 200
    new-instance v1, Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {v1}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    .line 201
    .local v1, "model":Lcom/poshmark/utils/SearchFilterModel;
    const-string v4, "available"

    invoke-virtual {v1, v4}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    .line 202
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/controllers/UserStateSummaryController;->getUserStateSummary()Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v3

    .line 203
    .local v3, "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    if-eqz v3, :cond_0

    iget-object v4, v3, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->isMySizeAvailable()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 204
    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Lcom/poshmark/utils/SearchFilterModel;->enableMySizeFilter(Z)V

    .line 206
    :cond_0
    const-string v4, "ct"

    invoke-virtual {v1, v4}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 207
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v4, v4, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/poshmark/utils/SearchFilterModel;->setCategory(Ljava/lang/String;)V

    .line 208
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v4, v4, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-virtual {v1, v4}, Lcom/poshmark/utils/SearchFilterModel;->setSubCategories(Ljava/util/List;)V

    .line 209
    const-string v4, "brand"

    invoke-virtual {v1, v4}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 210
    const-string v4, "size"

    invoke-virtual {v1, v4}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 211
    const-string v4, "color"

    invoke-virtual {v1, v4}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 212
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 213
    .local v2, "searchTrigger":Landroid/os/Bundle;
    const-string v4, "SEARCH_TRIGGER"

    const-string v5, "ct"

    invoke-virtual {v2, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 214
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 215
    .local v0, "activity":Lcom/poshmark/ui/PMContainerActivity;
    const-class v4, Lcom/poshmark/ui/fragments/SearchResultsFragment;

    invoke-virtual {v0, v2, v4, v1}, Lcom/poshmark/ui/PMContainerActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 216
    iget-boolean v4, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->isBrowseMode:Z

    if-eqz v4, :cond_1

    .line 218
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v6, "listing"

    const-string v7, "browse_listings_by_subcategory_shop_tab"

    const/4 v8, 0x0

    invoke-virtual {v4, v5, v6, v7, v8}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 220
    :cond_1
    return-void
.end method

.method public returnData()V
    .locals 7

    .prologue
    .line 223
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v5, v5, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    const-class v6, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v5, v6}, Lcom/poshmark/utils/StringUtils;->toJson(Lcom/poshmark/data_model/models/MetaItem;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    .line 224
    .local v2, "json":Ljava/lang/String;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 225
    .local v0, "b":Landroid/os/Bundle;
    const-string v5, "DATA_SELECTED"

    invoke-virtual {v0, v5, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 226
    new-instance v5, Lcom/poshmark/ui/fragments/CategoryListFragment$3;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/CategoryListFragment$3;-><init>(Lcom/poshmark/ui/fragments/CategoryListFragment;)V

    invoke-virtual {v5}, Lcom/poshmark/ui/fragments/CategoryListFragment$3;->getType()Ljava/lang/reflect/Type;

    move-result-object v3

    .line 227
    .local v3, "listOfObjectType":Ljava/lang/reflect/Type;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v5, v5, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-static {v5, v3}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/util/List;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v4

    .line 228
    .local v4, "tagsJson":Ljava/lang/String;
    const-string v5, "TAGS_LIST"

    invoke-virtual {v0, v5, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 229
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 230
    .local v1, "i":Landroid/content/Intent;
    const-string v5, "RETURNED_RESULTS"

    invoke-virtual {v1, v5, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 231
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/CategoryListFragment;->returnResult(Landroid/content/Intent;)V

    .line 232
    return-void
.end method

.method public returnResult(Landroid/content/Intent;)V
    .locals 4
    .param p1, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v3, -0x1

    .line 186
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFragment;

    .line 187
    .local v1, "targetFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v1, :cond_1

    .line 188
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getTargetRequestCode()I

    move-result v2

    invoke-virtual {v1, v2, v3, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 189
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 190
    .local v0, "parent":Landroid/app/Activity;
    if-eqz v0, :cond_0

    .line 191
    invoke-virtual {v0}, Landroid/app/Activity;->onBackPressed()V

    .line 197
    .end local v0    # "parent":Landroid/app/Activity;
    :cond_0
    :goto_0
    return-void

    .line 195
    :cond_1
    invoke-virtual {p0, v3, p1}, Lcom/poshmark/ui/fragments/CategoryListFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    goto :goto_0
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 259
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->isListingMode:Z

    if-eqz v0, :cond_0

    .line 260
    const-string v0, "listing_select_category_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 270
    :goto_0
    return-void

    .line 263
    :cond_0
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->allOptionVisible:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->allowMultiSelect:Z

    if-eqz v0, :cond_2

    .line 264
    :cond_1
    const-string v0, "listing_select_category_filter_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 267
    :cond_2
    const-string v0, "listing_select_category_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 107
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 108
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->allowMultiSelect:Z

    if-eqz v0, :cond_0

    .line 109
    const-string v0, "DONE"

    new-instance v1, Lcom/poshmark/ui/fragments/CategoryListFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/CategoryListFragment$1;-><init>(Lcom/poshmark/ui/fragments/CategoryListFragment;)V

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/CategoryListFragment;->setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 116
    :cond_0
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->isListingMode:Z

    if-eqz v0, :cond_1

    .line 117
    const v0, 0x7f060240

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->setTitle(I)V

    .line 121
    :goto_0
    return-void

    .line 119
    :cond_1
    const v0, 0x7f060073

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->setTitle(I)V

    goto :goto_0
.end method

.method public setupHeaderView()V
    .locals 9

    .prologue
    const/16 v8, 0x8

    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 273
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-static {v4}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    .line 274
    .local v2, "inflater":Landroid/view/LayoutInflater;
    const v4, 0x7f03005b

    invoke-virtual {v2, v4, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    iput-object v4, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->listHeaderView:Landroid/view/View;

    .line 276
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->listHeaderView:Landroid/view/View;

    const v5, 0x7f0c0072

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    .line 277
    .local v1, "clearAllTextBox":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->listHeaderView:Landroid/view/View;

    const v5, 0x7f0c0166

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    .line 278
    .local v3, "searchBoxLayout":Landroid/widget/LinearLayout;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->listHeaderView:Landroid/view/View;

    const v5, 0x7f0c0071

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 279
    .local v0, "allItemsLayout":Landroid/widget/LinearLayout;
    invoke-virtual {v3, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 284
    iget-boolean v4, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->allOptionVisible:Z

    if-eqz v4, :cond_1

    .line 285
    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 286
    const-string v4, "All"

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 287
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->showAllChecked()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 288
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f09003c

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 289
    const/4 v4, 0x1

    invoke-virtual {v1, v6, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 290
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f02007e

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v1, v6, v6, v4, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 297
    :cond_0
    :goto_0
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->listView:Landroid/widget/ListView;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->listHeaderView:Landroid/view/View;

    invoke-virtual {v4, v5}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 298
    return-void

    .line 294
    :cond_1
    invoke-virtual {v0, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public showAllChecked()Z
    .locals 1

    .prologue
    .line 305
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->selectAllOptionForNoSelections:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-virtual {v0}, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->selectionsPresent()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v0, v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    if-nez v0, :cond_0

    .line 306
    const/4 v0, 0x1

    .line 308
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public showSubCategoryAllChecked()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 313
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    if-nez v1, :cond_1

    .line 319
    :cond_0
    :goto_0
    return v0

    .line 316
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 317
    const/4 v0, 0x1

    goto :goto_0
.end method
