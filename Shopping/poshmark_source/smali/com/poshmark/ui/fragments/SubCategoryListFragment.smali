.class public Lcom/poshmark/ui/fragments/SubCategoryListFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "SubCategoryListFragment.java"


# instance fields
.field allOptionVisible:Z

.field allowMultiSelect:Z

.field backoutFlag:Z

.field currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

.field currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

.field isListingFlowMode:Z

.field listHeaderView:Landroid/view/View;

.field listView:Landroid/widget/ListView;

.field parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

.field selectAllOptionForNoSelections:Z

.field selectedCategory:Lcom/poshmark/data_model/models/MetaItem;

.field showAllAsNone:Z

.field subCategoryAdapter:Lcom/poshmark/data_model/adapters/SubCategoryAdapter;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 33
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 38
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->allowMultiSelect:Z

    .line 40
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->allOptionVisible:Z

    .line 41
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->selectAllOptionForNoSelections:Z

    .line 42
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->showAllAsNone:Z

    .line 43
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->isListingFlowMode:Z

    .line 46
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->backoutFlag:Z

    return-void
.end method

.method private setupAdapter()V
    .locals 5

    .prologue
    .line 178
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    if-eqz v1, :cond_1

    .line 179
    new-instance v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-direct {v1}, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;-><init>()V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    .line 180
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->CATEGORY_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->categoryFacetList:Ljava/util/List;

    .line 181
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->STYLE_TAGS:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getUnscrubbedFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->subCategoryFacetList:Ljava/util/List;

    .line 182
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/PMFilterableFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 183
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v1, :cond_1

    .line 184
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/poshmark/db/DbApi;->getSubCategoriesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 185
    .local v0, "allTagsForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->STYLE_TAGS:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getUnscrubbedFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/poshmark/utils/ListingsFilterUtils;->getScrubbedList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    .line 186
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    if-nez v1, :cond_0

    .line 187
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    .line 189
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    .line 190
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentSubCategories()Ljava/util/List;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 194
    .end local v0    # "allTagsForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    if-eqz v1, :cond_2

    .line 195
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-static {v1}, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->clone(Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;)Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    .line 197
    :cond_2
    new-instance v1, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f03008a

    iget-object v4, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-direct {v1, v2, v3, v4, p0}, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;-><init>(Landroid/content/Context;ILcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;Lcom/poshmark/ui/fragments/SubCategoryListFragment;)V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->subCategoryAdapter:Lcom/poshmark/data_model/adapters/SubCategoryAdapter;

    .line 198
    return-void
.end method


# virtual methods
.method public allItemSelected()V
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v0, v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 255
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->returnData()V

    .line 256
    return-void
.end method

.method public getListHeaderView()Landroid/view/View;
    .locals 1

    .prologue
    .line 250
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->listHeaderView:Landroid/view/View;

    return-object v0
.end method

.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 208
    const-string v0, "sct"

    return-object v0
.end method

.method public itemSelected(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 1
    .param p1, "selection"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 259
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v0, v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 260
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v0, v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 261
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->returnData()V

    .line 262
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 76
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 77
    if-nez p1, :cond_0

    .line 78
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0205

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->listView:Landroid/widget/ListView;

    .line 79
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->setupHeaderView()V

    .line 80
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->listView:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->subCategoryAdapter:Lcom/poshmark/data_model/adapters/SubCategoryAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 81
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->subCategoryAdapter:Lcom/poshmark/data_model/adapters/SubCategoryAdapter;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->listView:Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->setListView(Landroid/widget/ListView;)V

    .line 82
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->isListingFlowMode:Z

    if-eqz v0, :cond_1

    .line 83
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060245

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->setTitle(Ljava/lang/String;)V

    .line 88
    :cond_0
    :goto_0
    return-void

    .line 85
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v0, v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->setTitle(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x0

    .line 51
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 52
    if-nez p1, :cond_0

    .line 53
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "MULTI_SELECT_ENABLED"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->allowMultiSelect:Z

    .line 54
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "SHOW_ALL_VISIBLE"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->allOptionVisible:Z

    .line 55
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "SET_SHOW_ALL"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->selectAllOptionForNoSelections:Z

    .line 57
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "SHOW_ALL_AS_NONE"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->showAllAsNone:Z

    .line 58
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "LISTING_FLOW_MODE"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->isListingFlowMode:Z

    .line 59
    const-class v0, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    .line 60
    const-class v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    .line 61
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->setupAdapter()V

    .line 65
    :goto_0
    return-void

    .line 63
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->backoutFlag:Z

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 69
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 70
    const v1, 0x7f0300c1

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 71
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onFragmentResult(Landroid/os/Bundle;I)V
    .locals 4
    .param p1, "b"    # Landroid/os/Bundle;
    .param p2, "requestCode"    # I

    .prologue
    .line 130
    const/16 v2, 0x11

    if-ne p2, v2, :cond_0

    .line 131
    if-eqz p1, :cond_1

    .line 132
    const-string v2, "DATA_SELECTED"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 133
    .local v1, "jsonString":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 134
    const-class v2, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v1, v2}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/MetaItem;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->selectedCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 136
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->selectedCategory:Lcom/poshmark/data_model/models/MetaItem;

    iput-object v3, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 137
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->selectedCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/poshmark/db/DbApi;->getSubCategoriesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 138
    .local v0, "allTagsForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v3, v3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->subCategoryFacetList:Ljava/util/List;

    invoke-static {v0, v3}, Lcom/poshmark/utils/ListingsFilterUtils;->getScrubbedList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    iput-object v3, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    .line 139
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    if-nez v2, :cond_0

    .line 140
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, v2, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    .line 150
    .end local v0    # "allTagsForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    .end local v1    # "jsonString":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 147
    :cond_1
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->backoutFlag:Z

    goto :goto_0
.end method

.method public onPMResume()V
    .locals 1

    .prologue
    .line 92
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 93
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->backoutFlag:Z

    if-eqz v0, :cond_0

    .line 94
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->onBackPressed()V

    .line 97
    :cond_0
    return-void
.end method

.method public returnData()V
    .locals 11

    .prologue
    const/4 v10, -0x1

    .line 153
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v7

    check-cast v7, Lcom/poshmark/ui/fragments/PMFragment;

    .line 154
    .local v7, "targetFragment":Lcom/poshmark/ui/fragments/PMFragment;
    iget-object v8, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v8, v8, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    const-class v9, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v8, v9}, Lcom/poshmark/utils/StringUtils;->toJson(Lcom/poshmark/data_model/models/MetaItem;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    .line 155
    .local v2, "json":Ljava/lang/String;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 156
    .local v0, "b":Landroid/os/Bundle;
    const-string v8, "DATA_SELECTED"

    invoke-virtual {v0, v8, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    new-instance v8, Lcom/poshmark/ui/fragments/SubCategoryListFragment$2;

    invoke-direct {v8, p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment$2;-><init>(Lcom/poshmark/ui/fragments/SubCategoryListFragment;)V

    invoke-virtual {v8}, Lcom/poshmark/ui/fragments/SubCategoryListFragment$2;->getType()Ljava/lang/reflect/Type;

    move-result-object v3

    .line 158
    .local v3, "listOfObjectType":Ljava/lang/reflect/Type;
    iget-object v8, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v8, v8, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-static {v8, v3}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/util/List;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v6

    .line 159
    .local v6, "tagsJson":Ljava/lang/String;
    const-string v8, "TAGS_LIST"

    invoke-virtual {v0, v8, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 160
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 161
    .local v1, "i":Landroid/content/Intent;
    const-string v8, "RETURNED_RESULTS"

    invoke-virtual {v1, v8, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 164
    if-eqz v7, :cond_1

    .line 165
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getTargetRequestCode()I

    move-result v5

    .line 166
    .local v5, "requestCode":I
    invoke-virtual {v7, v5, v10, v1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 167
    invoke-virtual {v7}, Lcom/poshmark/ui/fragments/PMFragment;->getParentActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v4

    .line 168
    .local v4, "parent":Landroid/app/Activity;
    if-eqz v4, :cond_0

    .line 169
    invoke-virtual {v4}, Landroid/app/Activity;->onBackPressed()V

    .line 175
    .end local v4    # "parent":Landroid/app/Activity;
    .end local v5    # "requestCode":I
    :cond_0
    :goto_0
    return-void

    .line 173
    :cond_1
    invoke-virtual {p0, v10, v1}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    goto :goto_0
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 203
    const-string v0, "listing_select_subcategory_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 204
    return-void
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 101
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 102
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->allowMultiSelect:Z

    if-eqz v0, :cond_0

    .line 103
    const-string v0, "DONE"

    new-instance v1, Lcom/poshmark/ui/fragments/SubCategoryListFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment$1;-><init>(Lcom/poshmark/ui/fragments/SubCategoryListFragment;)V

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 110
    :cond_0
    return-void
.end method

.method public setupHeaderView()V
    .locals 10

    .prologue
    const/16 v9, 0x8

    const/4 v8, 0x0

    const/4 v7, 0x0

    .line 212
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-static {v5}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    .line 213
    .local v2, "inflater":Landroid/view/LayoutInflater;
    const v5, 0x7f03005b

    invoke-virtual {v2, v5, v8, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v5

    iput-object v5, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->listHeaderView:Landroid/view/View;

    .line 215
    iget-object v5, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->listHeaderView:Landroid/view/View;

    const v6, 0x7f0c0072

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    .line 216
    .local v1, "clearAllTextBox":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->listHeaderView:Landroid/view/View;

    const v6, 0x7f0c0166

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/LinearLayout;

    .line 217
    .local v4, "searchBoxLayout":Landroid/widget/LinearLayout;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->listHeaderView:Landroid/view/View;

    const v6, 0x7f0c0071

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 218
    .local v0, "allItemsLayout":Landroid/widget/LinearLayout;
    invoke-virtual {v4, v9}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 221
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v5, -0x1

    const/4 v6, -0x2

    invoke-direct {v3, v5, v6}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 223
    .local v3, "params":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    const/high16 v6, 0x41f00000    # 30.0f

    invoke-static {v5, v6}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v5

    float-to-int v5, v5

    invoke-virtual {v3, v7, v7, v7, v5}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 224
    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 229
    iget-boolean v5, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->allOptionVisible:Z

    if-eqz v5, :cond_2

    .line 230
    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 231
    iget-boolean v5, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->showAllAsNone:Z

    if-eqz v5, :cond_1

    .line 232
    const-string v5, "None"

    invoke-virtual {v1, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 236
    :goto_0
    iget-boolean v5, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->selectAllOptionForNoSelections:Z

    if-eqz v5, :cond_0

    iget-object v5, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-virtual {v5}, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->selectionsPresent()Z

    move-result v5

    if-nez v5, :cond_0

    .line 237
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f09003c

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v1, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 238
    const/4 v5, 0x1

    invoke-virtual {v1, v8, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 239
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f02007e

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v1, v8, v8, v5, v8}, Lcom/poshmark/ui/customviews/PMTextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 246
    :cond_0
    :goto_1
    iget-object v5, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->listView:Landroid/widget/ListView;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->listHeaderView:Landroid/view/View;

    invoke-virtual {v5, v6}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 247
    return-void

    .line 234
    :cond_1
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f06003c

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->currentSelectionModel_copy:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v6, v6, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 243
    :cond_2
    invoke-virtual {v0, v9}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_1
.end method
