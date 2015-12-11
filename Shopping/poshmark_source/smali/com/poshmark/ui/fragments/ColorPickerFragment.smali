.class public Lcom/poshmark/ui/fragments/ColorPickerFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "ColorPickerFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;
    }
.end annotation


# instance fields
.field MAX_COUNT:I

.field adapter:Lcom/poshmark/data_model/adapters/ColorListAdapter;

.field colorDataChanged:Z

.field dataChanged:Z

.field defaultAllTextColor:I

.field headerView:Landroid/view/View;

.field info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

.field isAllSelected:Z

.field listView:Landroid/widget/ListView;

.field mode:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

.field parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

.field returnResult:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 35
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 38
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->colorDataChanged:Z

    .line 42
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->dataChanged:Z

    .line 43
    const/4 v0, 0x2

    iput v0, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->MAX_COUNT:I

    .line 45
    sget-object v0, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_FILTER:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->mode:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    .line 46
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->isAllSelected:Z

    .line 49
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->returnResult:Z

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/ColorPickerFragment;ZLandroid/view/View;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ColorPickerFragment;
    .param p1, "x1"    # Z
    .param p2, "x2"    # Landroid/view/View;

    .prologue
    .line 35
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->setAllOption(ZLandroid/view/View;)V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/ColorPickerFragment;Lcom/poshmark/data_model/models/PMColor;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ColorPickerFragment;
    .param p1, "x1"    # Lcom/poshmark/data_model/models/PMColor;

    .prologue
    .line 35
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->fireBrowseWithColor(Lcom/poshmark/data_model/models/PMColor;)V

    return-void
.end method

.method private fireBrowseWithColor(Lcom/poshmark/data_model/models/PMColor;)V
    .locals 8
    .param p1, "color"    # Lcom/poshmark/data_model/models/PMColor;

    .prologue
    .line 168
    new-instance v1, Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {v1}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    .line 169
    .local v1, "model":Lcom/poshmark/utils/SearchFilterModel;
    const-string v3, "available"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    .line 170
    const-string v3, "clr"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 172
    const-string v3, "brand"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 173
    const-string v3, "category_v2"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 174
    const-string v3, "category_feature"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 175
    const-string v3, "size"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 177
    iget-object v3, p1, Lcom/poshmark/data_model/models/PMColor;->name:Ljava/lang/String;

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->addColor(Ljava/lang/String;)V

    .line 178
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 179
    .local v2, "searchTrigger":Landroid/os/Bundle;
    const-string v3, "SEARCH_TRIGGER"

    const-string v4, "clr"

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 180
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 181
    .local v0, "activity":Lcom/poshmark/ui/PMContainerActivity;
    const-class v3, Lcom/poshmark/ui/fragments/SearchResultsFragment;

    invoke-virtual {v0, v2, v3, v1}, Lcom/poshmark/ui/PMContainerActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 182
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v5, "listing"

    const-string v6, "browse_listings_by_color_shop_tab"

    const/4 v7, 0x0

    invoke-virtual {v3, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 183
    return-void
.end method

.method private setAllOption(ZLandroid/view/View;)V
    .locals 5
    .param p1, "checked"    # Z
    .param p2, "headerView"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 148
    const v2, 0x7f0c00d3

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 149
    .local v0, "checkMark":Landroid/widget/ImageView;
    const v2, 0x7f0c00d2

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 150
    .local v1, "label":Landroid/widget/TextView;
    if-eqz p1, :cond_0

    .line 151
    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 152
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f09003c

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 153
    const/4 v2, 0x1

    invoke-virtual {v1, v4, v2}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 159
    :goto_0
    return-void

    .line 155
    :cond_0
    const/4 v2, 0x4

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 156
    iget v2, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->defaultAllTextColor:I

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 157
    invoke-virtual {v1, v4, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    goto :goto_0
.end method

.method private setupItemSelectionHandler()V
    .locals 2

    .prologue
    .line 83
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->listView:Landroid/widget/ListView;

    new-instance v1, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ColorPickerFragment$1;-><init>(Lcom/poshmark/ui/fragments/ColorPickerFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 143
    return-void
.end method


# virtual methods
.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    const-string v0, "clr"

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x1

    .line 187
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 188
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getView()Landroid/view/View;

    move-result-object v2

    const v3, 0x7f0c00d0

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ListView;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->listView:Landroid/widget/ListView;

    .line 189
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->mode:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    sget-object v3, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_FILTER:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    if-ne v2, v3, :cond_2

    .line 190
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 191
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v2, 0x7f03002d

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->headerView:Landroid/view/View;

    .line 192
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c00d2

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 193
    .local v1, "label":Landroid/widget/TextView;
    const v2, 0x7f06003f

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 194
    invoke-virtual {v1}, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v2

    iput v2, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->defaultAllTextColor:I

    .line 195
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->selectedColors:Ljava/util/List;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->selectedColors:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 196
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->headerView:Landroid/view/View;

    invoke-direct {p0, v4, v2}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->setAllOption(ZLandroid/view/View;)V

    .line 197
    iput-boolean v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->isAllSelected:Z

    .line 199
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->listView:Landroid/widget/ListView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->headerView:Landroid/view/View;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 201
    .end local v0    # "inflater":Landroid/view/LayoutInflater;
    .end local v1    # "label":Landroid/widget/TextView;
    :cond_2
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->listView:Landroid/widget/ListView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->adapter:Lcom/poshmark/data_model/adapters/ColorListAdapter;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 202
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->setupItemSelectionHandler()V

    .line 203
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x1

    .line 53
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 54
    const-class v1, Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    .line 55
    const-class v1, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    .line 56
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 57
    .local v0, "b":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 58
    invoke-static {}, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->values()[Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    move-result-object v1

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "COLOR_PICKER_MODE"

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v2

    aget-object v1, v1, v2

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->mode:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    .line 59
    const-string v1, "RETURN_RESULT"

    invoke-virtual {v0, v1, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->returnResult:Z

    .line 62
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    if-nez v1, :cond_2

    .line 63
    new-instance v1, Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    invoke-direct {v1}, Lcom/poshmark/utils/meta_data/ColorPickerInfo;-><init>()V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    .line 64
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getColorFacetList()Ljava/util/List;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->allItems:Ljava/util/List;

    .line 65
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->allItems:Ljava/util/List;

    if-nez v1, :cond_1

    .line 66
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->allItems:Ljava/util/List;

    .line 68
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->selectedColors:Ljava/util/List;

    .line 69
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->selectedColors:Ljava/util/List;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentColorSelections()Ljava/util/List;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 70
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getUnscrubbedColorFacetList()Ljava/util/List;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->colorFacetList:Ljava/util/List;

    .line 73
    :cond_2
    new-instance v1, Lcom/poshmark/data_model/adapters/ColorListAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f03002e

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    invoke-direct {v1, v2, v3, v4}, Lcom/poshmark/data_model/adapters/ColorListAdapter;-><init>(Landroid/content/Context;ILcom/poshmark/utils/meta_data/ColorPickerInfo;)V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->adapter:Lcom/poshmark/data_model/adapters/ColorListAdapter;

    .line 74
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 162
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 163
    const v1, 0x7f03002c

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 164
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public returnData()Z
    .locals 11

    .prologue
    const/4 v10, 0x0

    const/4 v9, -0x1

    .line 208
    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    .line 209
    .local v2, "intent":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 210
    .local v0, "b":Landroid/os/Bundle;
    iget-boolean v7, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->dataChanged:Z

    if-eqz v7, :cond_1

    .line 211
    const-string v7, "COLOR_CHANGED"

    const/4 v8, 0x1

    invoke-virtual {v0, v7, v8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 212
    new-instance v7, Lcom/poshmark/ui/fragments/ColorPickerFragment$2;

    invoke-direct {v7, p0}, Lcom/poshmark/ui/fragments/ColorPickerFragment$2;-><init>(Lcom/poshmark/ui/fragments/ColorPickerFragment;)V

    invoke-virtual {v7}, Lcom/poshmark/ui/fragments/ColorPickerFragment$2;->getType()Ljava/lang/reflect/Type;

    move-result-object v4

    .line 214
    .local v4, "listOfObjectType":Ljava/lang/reflect/Type;
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->info:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    iget-object v7, v7, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->selectedColors:Ljava/util/List;

    invoke-static {v7, v4}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/util/List;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v3

    .line 215
    .local v3, "json":Ljava/lang/String;
    const-string v7, "COLOR_LIST"

    invoke-virtual {v0, v7, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 220
    .end local v3    # "json":Ljava/lang/String;
    .end local v4    # "listOfObjectType":Ljava/lang/reflect/Type;
    :goto_0
    const-string v7, "RETURNED_RESULTS"

    invoke-virtual {v2, v7, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 221
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFragment;

    .line 222
    .local v1, "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v1, :cond_2

    .line 223
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getTargetRequestCode()I

    move-result v6

    .line 224
    .local v6, "requestCode":I
    invoke-virtual {v1, v6, v9, v2}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 225
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    .line 226
    .local v5, "parent":Landroid/app/Activity;
    if-eqz v5, :cond_0

    .line 227
    invoke-virtual {v5}, Landroid/app/Activity;->onBackPressed()V

    .line 233
    .end local v5    # "parent":Landroid/app/Activity;
    .end local v6    # "requestCode":I
    :cond_0
    :goto_1
    return v10

    .line 217
    .end local v1    # "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    :cond_1
    const-string v7, "COLOR_CHANGED"

    invoke-virtual {v0, v7, v10}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_0

    .line 230
    .restart local v1    # "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    :cond_2
    invoke-virtual {p0, v9, v2}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    goto :goto_1
.end method

.method public setViewNameForAnalytics()V
    .locals 2

    .prologue
    .line 253
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->mode:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_LISTING_FLOW:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    if-ne v0, v1, :cond_0

    .line 254
    const-string v0, "listing_select_color_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 261
    :goto_0
    return-void

    .line 255
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->mode:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_FILTER:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    if-ne v0, v1, :cond_1

    .line 256
    const-string v0, "listing_select_color_filter_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 259
    :cond_1
    const-string v0, "listing_select_color_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 238
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 239
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment;->mode:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_LISTING_FLOW:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    if-ne v0, v1, :cond_0

    .line 240
    const v0, 0x7f060242

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->setTitle(Ljava/lang/String;)V

    .line 241
    const v0, 0x7f0600bf

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/fragments/ColorPickerFragment$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ColorPickerFragment$3;-><init>(Lcom/poshmark/ui/fragments/ColorPickerFragment;)V

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 250
    :goto_0
    return-void

    .line 248
    :cond_0
    const v0, 0x7f060241

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->setTitle(Ljava/lang/String;)V

    goto :goto_0
.end method
