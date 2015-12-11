.class public Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "BrandsMetaItemListViewFragment.java"


# instance fields
.field adapter:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

.field allBrandsTextView:Landroid/widget/TextView;

.field bReturnResults:Z

.field bShowAllOption:Z

.field backoutFlag:Z

.field brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

.field itemClick:Z

.field metaItem:Lcom/poshmark/data_model/models/MetaItem;

.field parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

.field recentItems:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field recentItemsCount:I

.field searchEditText:Lcom/poshmark/ui/customviews/PMEditText;

.field searchText:Ljava/lang/String;

.field stickyListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 42
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 55
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->bShowAllOption:Z

    .line 56
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->bReturnResults:Z

    .line 57
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->backoutFlag:Z

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->resetBrandsList()V

    return-void
.end method

.method private getMetaItemListFromFilter()Ljava/util/List;
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
    .line 102
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getBrandsFacetList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method private resetBrandsList()V
    .locals 3

    .prologue
    .line 340
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->adapter:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->clear()V

    .line 341
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->adapter:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->notifyDataSetChanged()V

    .line 342
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->allBrandsTextView:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 343
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->allBrandsTextView:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 345
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->adapter:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    iget-object v0, v0, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->allItems:Ljava/util/List;

    check-cast v0, Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->recentItems:Ljava/util/ArrayList;

    invoke-static {v0, v2}, Lcom/poshmark/data_model/models/IndexedMetaItem;->convertRecentBrandsToIndexMetaItemList(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v1, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    .line 346
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->adapter:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    iget-object v0, v0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->recentBrandsList:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->recentItems:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 347
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->adapter:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->notifyDataSetChanged()V

    .line 348
    return-void
.end method

.method private restoreState(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 163
    return-void
.end method

.method private setupAdapter()V
    .locals 5

    .prologue
    .line 90
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    if-eqz v0, :cond_0

    .line 91
    new-instance v0, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    invoke-direct {v0}, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    .line 92
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getMetaItemListFromFilter()Ljava/util/List;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->allItems:Ljava/util/List;

    .line 93
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getBrandsMetaItemSelection()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    .line 96
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getFilteredRecentBrandsList()V

    .line 97
    new-instance v0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f03008a

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->recentItems:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;-><init>(Landroid/content/Context;ILcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;Ljava/util/ArrayList;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->adapter:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    .line 98
    return-void
.end method

.method private setupListItemClickListener()V
    .locals 2

    .prologue
    .line 219
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->stickyListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    new-instance v1, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;-><init>(Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;)V

    invoke-virtual {v0, v1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 286
    return-void
.end method

.method private setupSearchListener()V
    .locals 3

    .prologue
    .line 351
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchEditText:Lcom/poshmark/ui/customviews/PMEditText;

    if-nez v0, :cond_0

    .line 395
    :goto_0
    return-void

    .line 354
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchEditText:Lcom/poshmark/ui/customviews/PMEditText;

    new-instance v1, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$3;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-direct {v1, p0, v2}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$3;-><init>(Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;Landroid/widget/EditText;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMEditText;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 371
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchEditText:Lcom/poshmark/ui/customviews/PMEditText;

    new-instance v1, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$4;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$4;-><init>(Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMEditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    goto :goto_0
.end method


# virtual methods
.method public getFilteredRecentBrandsList()V
    .locals 8

    .prologue
    .line 108
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    iput-object v6, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->recentItems:Ljava/util/ArrayList;

    .line 109
    const/4 v6, 0x0

    iput v6, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->recentItemsCount:I

    .line 111
    new-instance v5, Ljava/util/HashSet;

    invoke-direct {v5}, Ljava/util/HashSet;-><init>()V

    .line 112
    .local v5, "set":Ljava/util/Set;, "Ljava/util/Set<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v6, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    iget-object v6, v6, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->allItems:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/MetaItem;

    .line 113
    .local v4, "obj":Lcom/poshmark/data_model/models/MetaItem;
    invoke-interface {v5, v4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 118
    .end local v4    # "obj":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/controllers/GlobalDbController;->getRecentBrandsAndFollowingBrands()Ljava/util/List;

    move-result-object v0

    .line 119
    .local v0, "allRecents":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 120
    .local v3, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 121
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/MetaItem;

    .line 122
    .local v2, "item":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v2, :cond_1

    invoke-interface {v5, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 123
    iget-object v6, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->recentItems:Ljava/util/ArrayList;

    invoke-virtual {v6, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 124
    iget v6, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->recentItemsCount:I

    add-int/lit8 v6, v6, 0x1

    iput v6, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->recentItemsCount:I

    .line 125
    iget v6, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->recentItemsCount:I

    const/16 v7, 0x32

    if-lt v6, v7, :cond_1

    .line 130
    .end local v2    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_2
    return-void
.end method

.method public handleBack()Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 326
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchText:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchText:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 327
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->itemClick:Z

    if-eqz v1, :cond_1

    .line 328
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->itemClick:Z

    .line 335
    :cond_0
    :goto_0
    return v0

    .line 331
    :cond_1
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->resetBrandsList()V

    .line 332
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 142
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 143
    if-nez p1, :cond_1

    .line 144
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0206

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->stickyListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    .line 145
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    iget-object v0, v0, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->allItems:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 146
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->setupHeaderView()V

    .line 147
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->stickyListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->adapter:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    invoke-virtual {v0, v1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 148
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->setupListItemClickListener()V

    .line 150
    :cond_1
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x1

    .line 61
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 62
    if-nez p1, :cond_0

    .line 63
    const-class v0, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    .line 64
    const-class v0, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    .line 65
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "SHOW_ALL"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->bShowAllOption:Z

    .line 66
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "RETURN_RESULT"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->bReturnResults:Z

    .line 67
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->setupAdapter()V

    .line 71
    :goto_0
    return-void

    .line 69
    :cond_0
    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->backoutFlag:Z

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 135
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 136
    const v1, 0x7f030089

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 137
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onPMResume()V
    .locals 1

    .prologue
    .line 75
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 76
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->backoutFlag:Z

    if-nez v0, :cond_0

    .line 77
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->adapter:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->notifyDataSetChanged()V

    .line 81
    :goto_0
    return-void

    .line 79
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->onBackPressed()V

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 155
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 159
    return-void
.end method

.method public returnData()V
    .locals 11

    .prologue
    const/4 v10, -0x1

    .line 187
    iget-boolean v8, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->bReturnResults:Z

    if-eqz v8, :cond_2

    .line 188
    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    .line 189
    .local v2, "i":Landroid/content/Intent;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 190
    .local v1, "b":Landroid/os/Bundle;
    iget-object v8, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    const-class v9, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v8, v9}, Lcom/poshmark/utils/StringUtils;->toJson(Lcom/poshmark/data_model/models/MetaItem;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v3

    .line 192
    .local v3, "json":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v7

    check-cast v7, Lcom/poshmark/ui/fragments/PMFragment;

    .line 193
    .local v7, "targetFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v7, :cond_1

    .line 194
    const-string v8, "DATA_SELECTED"

    invoke-virtual {v1, v8, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 195
    const-string v8, "RETURNED_RESULTS"

    invoke-virtual {v2, v8, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 196
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getTargetRequestCode()I

    move-result v5

    .line 197
    .local v5, "requestCode":I
    invoke-virtual {v7, v5, v10, v2}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 198
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    .line 199
    .local v4, "parent":Landroid/app/Activity;
    if-eqz v4, :cond_0

    .line 200
    invoke-virtual {v4}, Landroid/app/Activity;->onBackPressed()V

    .line 215
    .end local v1    # "b":Landroid/os/Bundle;
    .end local v2    # "i":Landroid/content/Intent;
    .end local v3    # "json":Ljava/lang/String;
    .end local v4    # "parent":Landroid/app/Activity;
    .end local v5    # "requestCode":I
    .end local v7    # "targetFragment":Lcom/poshmark/ui/fragments/PMFragment;
    :cond_0
    :goto_0
    return-void

    .line 203
    .restart local v1    # "b":Landroid/os/Bundle;
    .restart local v2    # "i":Landroid/content/Intent;
    .restart local v3    # "json":Ljava/lang/String;
    .restart local v7    # "targetFragment":Lcom/poshmark/ui/fragments/PMFragment;
    :cond_1
    const-string v8, "DATA_SELECTED"

    invoke-virtual {v2, v8, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 204
    invoke-virtual {p0, v10, v2}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    goto :goto_0

    .line 208
    .end local v1    # "b":Landroid/os/Bundle;
    .end local v2    # "i":Landroid/content/Intent;
    .end local v3    # "json":Ljava/lang/String;
    .end local v7    # "targetFragment":Lcom/poshmark/ui/fragments/PMFragment;
    :cond_2
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 209
    .local v0, "activity":Lcom/poshmark/ui/PMContainerActivity;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/poshmark/ui/PMContainerActivity;->isActivityInForeground()Z

    move-result v8

    if-eqz v8, :cond_0

    .line 210
    new-instance v6, Landroid/os/Bundle;

    invoke-direct {v6}, Landroid/os/Bundle;-><init>()V

    .line 211
    .local v6, "searchTrigger":Landroid/os/Bundle;
    const-string v8, "NAME"

    iget-object v9, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v9}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v8, v9}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 212
    const-class v8, Lcom/poshmark/ui/fragments/BrandFragment;

    const/4 v9, 0x0

    invoke-virtual {v0, v6, v8, v9}, Lcom/poshmark/ui/PMContainerActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public setTitle()V
    .locals 2

    .prologue
    .line 84
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060061

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->setTitle(Ljava/lang/String;)V

    .line 85
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 400
    const-string v0, "listing_select_brand_filter_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 401
    return-void
.end method

.method public setupActionBar()V
    .locals 4

    .prologue
    .line 167
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getUserVisibleHint()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 168
    const v2, 0x7f030001

    invoke-super {p0, v2}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar(I)V

    .line 169
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 170
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v1

    .line 171
    .local v1, "customView":Landroid/view/View;
    if-eqz v1, :cond_1

    .line 172
    const v2, 0x7f0c0030

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchEditText:Lcom/poshmark/ui/customviews/PMEditText;

    .line 173
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchText:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 174
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchEditText:Lcom/poshmark/ui/customviews/PMEditText;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchText:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMEditText;->setText(Ljava/lang/CharSequence;)V

    .line 175
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditText;->requestFocus()Z

    .line 176
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->showKeyboard()V

    .line 179
    :cond_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->setupSearchListener()V

    .line 182
    .end local v0    # "actionBar":Landroid/app/ActionBar;
    .end local v1    # "customView":Landroid/view/View;
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->setTitle()V

    .line 183
    return-void
.end method

.method public setupHeaderView()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x0

    .line 289
    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->bShowAllOption:Z

    if-eqz v2, :cond_0

    .line 290
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 291
    .local v1, "inflater":Landroid/view/LayoutInflater;
    const v2, 0x7f030013

    invoke-virtual {v1, v2, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 292
    .local v0, "headerView":Landroid/view/View;
    const v2, 0x7f0c0072

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->allBrandsTextView:Landroid/widget/TextView;

    .line 293
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->allBrandsTextView:Landroid/widget/TextView;

    const v3, 0x7f06003c

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(I)V

    .line 294
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->allBrandsTextView:Landroid/widget/TextView;

    invoke-virtual {v2, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 296
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    if-nez v2, :cond_1

    .line 298
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->allBrandsTextView:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f09003c

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 299
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->allBrandsTextView:Landroid/widget/TextView;

    const/4 v3, 0x1

    invoke-virtual {v2, v5, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 300
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->allBrandsTextView:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f02007e

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v2, v5, v5, v3, v5}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 306
    :goto_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->stickyListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    invoke-virtual {v2, v0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->addHeaderView(Landroid/view/View;)V

    .line 308
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->allBrandsTextView:Landroid/widget/TextView;

    new-instance v3, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$2;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$2;-><init>(Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;)V

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 321
    .end local v0    # "headerView":Landroid/view/View;
    .end local v1    # "inflater":Landroid/view/LayoutInflater;
    :cond_0
    return-void

    .line 302
    .restart local v0    # "headerView":Landroid/view/View;
    .restart local v1    # "inflater":Landroid/view/LayoutInflater;
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->allBrandsTextView:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f090035

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 303
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->allBrandsTextView:Landroid/widget/TextView;

    invoke-virtual {v2, v5, v6}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    goto :goto_0
.end method
