.class public Lcom/poshmark/ui/fragments/PricePickerFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "PricePickerFragment.java"


# instance fields
.field dataChanged:Z

.field info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

.field isG2FiltersEnabled:Z

.field parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

.field sizeButtonListener:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 29
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 32
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->dataChanged:Z

    .line 34
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->isG2FiltersEnabled:Z

    .line 185
    new-instance v0, Lcom/poshmark/ui/fragments/PricePickerFragment$3;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/PricePickerFragment$3;-><init>(Lcom/poshmark/ui/fragments/PricePickerFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->sizeButtonListener:Landroid/view/View$OnClickListener;

    return-void
.end method

.method private setupSizeGrid()V
    .locals 14

    .prologue
    .line 117
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PricePickerFragment;->getView()Landroid/view/View;

    move-result-object v12

    const v13, 0x7f0c015d

    invoke-virtual {v12, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 118
    .local v1, "containerLayout":Landroid/widget/LinearLayout;
    iget-object v12, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/PricePickerInfo;->allItems:Ljava/util/List;

    invoke-interface {v12}, Ljava/util/List;->size()I

    move-result v12

    div-int/lit8 v8, v12, 0x3

    .line 119
    .local v8, "numRows":I
    iget-object v12, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/PricePickerInfo;->allItems:Ljava/util/List;

    invoke-interface {v12}, Ljava/util/List;->size()I

    move-result v12

    rem-int/lit8 v9, v12, 0x3

    .line 121
    .local v9, "partialRowCount":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v8, :cond_0

    .line 122
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PricePickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v12

    invoke-static {v12}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    .line 123
    .local v3, "inflater":Landroid/view/LayoutInflater;
    const v12, 0x7f030058

    const/4 v13, 0x0

    invoke-virtual {v3, v12, v13}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v11

    .line 124
    .local v11, "v":Landroid/view/View;
    invoke-virtual {v1, v11}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 125
    mul-int/lit8 v10, v2, 0x3

    .line 126
    .local v10, "startPos":I
    iget-object v12, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/PricePickerInfo;->allItems:Ljava/util/List;

    invoke-interface {v12, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/poshmark/data_model/models/PriceInfo;

    .line 127
    .local v5, "item1":Lcom/poshmark/data_model/models/PriceInfo;
    iget-object v12, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/PricePickerInfo;->allItems:Ljava/util/List;

    add-int/lit8 v13, v10, 0x1

    invoke-interface {v12, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/poshmark/data_model/models/PriceInfo;

    .line 128
    .local v6, "item2":Lcom/poshmark/data_model/models/PriceInfo;
    iget-object v12, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/PricePickerInfo;->allItems:Ljava/util/List;

    add-int/lit8 v13, v10, 0x2

    invoke-interface {v12, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/poshmark/data_model/models/PriceInfo;

    .line 130
    .local v7, "item3":Lcom/poshmark/data_model/models/PriceInfo;
    const v12, 0x7f0c015f

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 131
    .local v0, "button":Landroid/widget/Button;
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/PriceInfo;->getDisplay()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v0, v12}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 132
    invoke-virtual {p0, v0, v5, v10}, Lcom/poshmark/ui/fragments/PricePickerFragment;->setupButton(Landroid/widget/Button;Lcom/poshmark/data_model/models/PriceInfo;I)V

    .line 135
    const v12, 0x7f0c0160

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 136
    .restart local v0    # "button":Landroid/widget/Button;
    invoke-virtual {v6}, Lcom/poshmark/data_model/models/PriceInfo;->getDisplay()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v0, v12}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 137
    add-int/lit8 v12, v10, 0x1

    invoke-virtual {p0, v0, v6, v12}, Lcom/poshmark/ui/fragments/PricePickerFragment;->setupButton(Landroid/widget/Button;Lcom/poshmark/data_model/models/PriceInfo;I)V

    .line 140
    const v12, 0x7f0c0161

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 141
    .restart local v0    # "button":Landroid/widget/Button;
    invoke-virtual {v7}, Lcom/poshmark/data_model/models/PriceInfo;->getDisplay()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v0, v12}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 142
    add-int/lit8 v12, v10, 0x2

    invoke-virtual {p0, v0, v7, v12}, Lcom/poshmark/ui/fragments/PricePickerFragment;->setupButton(Landroid/widget/Button;Lcom/poshmark/data_model/models/PriceInfo;I)V

    .line 121
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 146
    .end local v0    # "button":Landroid/widget/Button;
    .end local v3    # "inflater":Landroid/view/LayoutInflater;
    .end local v5    # "item1":Lcom/poshmark/data_model/models/PriceInfo;
    .end local v6    # "item2":Lcom/poshmark/data_model/models/PriceInfo;
    .end local v7    # "item3":Lcom/poshmark/data_model/models/PriceInfo;
    .end local v10    # "startPos":I
    .end local v11    # "v":Landroid/view/View;
    :cond_0
    if-lez v9, :cond_2

    .line 147
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PricePickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v12

    invoke-static {v12}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    .line 148
    .restart local v3    # "inflater":Landroid/view/LayoutInflater;
    const v12, 0x7f030058

    const/4 v13, 0x0

    invoke-virtual {v3, v12, v13}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v11

    .line 149
    .restart local v11    # "v":Landroid/view/View;
    invoke-virtual {v1, v11}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 151
    mul-int/lit8 v10, v8, 0x3

    .line 153
    .restart local v10    # "startPos":I
    iget-object v12, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/PricePickerInfo;->allItems:Ljava/util/List;

    invoke-interface {v12, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/PriceInfo;

    .line 154
    .local v4, "item":Lcom/poshmark/data_model/models/PriceInfo;
    const v12, 0x7f0c015f

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 155
    .restart local v0    # "button":Landroid/widget/Button;
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PriceInfo;->getDisplay()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v0, v12}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 156
    invoke-virtual {p0, v0, v4, v10}, Lcom/poshmark/ui/fragments/PricePickerFragment;->setupButton(Landroid/widget/Button;Lcom/poshmark/data_model/models/PriceInfo;I)V

    .line 159
    const/4 v12, 0x1

    if-le v9, v12, :cond_1

    .line 160
    iget-object v12, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/PricePickerInfo;->allItems:Ljava/util/List;

    add-int/lit8 v13, v10, 0x1

    invoke-interface {v12, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    .end local v4    # "item":Lcom/poshmark/data_model/models/PriceInfo;
    check-cast v4, Lcom/poshmark/data_model/models/PriceInfo;

    .line 161
    .restart local v4    # "item":Lcom/poshmark/data_model/models/PriceInfo;
    const v12, 0x7f0c0160

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 162
    .restart local v0    # "button":Landroid/widget/Button;
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PriceInfo;->getDisplay()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v0, v12}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 163
    add-int/lit8 v12, v10, 0x1

    invoke-virtual {p0, v0, v4, v12}, Lcom/poshmark/ui/fragments/PricePickerFragment;->setupButton(Landroid/widget/Button;Lcom/poshmark/data_model/models/PriceInfo;I)V

    .line 166
    :cond_1
    const/4 v12, 0x2

    if-le v9, v12, :cond_2

    .line 167
    iget-object v12, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/PricePickerInfo;->allItems:Ljava/util/List;

    add-int/lit8 v13, v10, 0x2

    invoke-interface {v12, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    .end local v4    # "item":Lcom/poshmark/data_model/models/PriceInfo;
    check-cast v4, Lcom/poshmark/data_model/models/PriceInfo;

    .line 168
    .restart local v4    # "item":Lcom/poshmark/data_model/models/PriceInfo;
    const v12, 0x7f0c0161

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 169
    .restart local v0    # "button":Landroid/widget/Button;
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PriceInfo;->getDisplay()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v0, v12}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 170
    add-int/lit8 v12, v10, 0x2

    invoke-virtual {p0, v0, v4, v12}, Lcom/poshmark/ui/fragments/PricePickerFragment;->setupButton(Landroid/widget/Button;Lcom/poshmark/data_model/models/PriceInfo;I)V

    .line 173
    .end local v0    # "button":Landroid/widget/Button;
    .end local v3    # "inflater":Landroid/view/LayoutInflater;
    .end local v4    # "item":Lcom/poshmark/data_model/models/PriceInfo;
    .end local v10    # "startPos":I
    .end local v11    # "v":Landroid/view/View;
    :cond_2
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 60
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 61
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PricePickerFragment;->setupSizeGrid()V

    .line 62
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 38
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 39
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FeatureManager;->isFilterBarv2FeatureEnabled()Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->isG2FiltersEnabled:Z

    .line 40
    const-class v0, Lcom/poshmark/utils/meta_data/PricePickerInfo;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PricePickerFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    .line 41
    const-class v0, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PricePickerFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    .line 42
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    if-nez v0, :cond_0

    .line 43
    new-instance v0, Lcom/poshmark/utils/meta_data/PricePickerInfo;

    invoke-direct {v0}, Lcom/poshmark/utils/meta_data/PricePickerInfo;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    .line 44
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getPriceList()Ljava/util/List;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/PricePickerInfo;->allItems:Ljava/util/List;

    .line 45
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/PricePickerInfo;->selectedItems:Ljava/util/List;

    .line 46
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iget-object v0, v0, Lcom/poshmark/utils/meta_data/PricePickerInfo;->selectedItems:Ljava/util/List;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentPriceSelections()Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 49
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 53
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 54
    const v1, 0x7f030057

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 55
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public returnData()Z
    .locals 11

    .prologue
    const/4 v10, 0x0

    const/4 v9, -0x1

    .line 66
    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    .line 67
    .local v2, "intent":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 68
    .local v0, "b":Landroid/os/Bundle;
    iget-boolean v7, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->dataChanged:Z

    if-eqz v7, :cond_1

    .line 69
    const-string v7, "PRICE_CHANGED"

    const/4 v8, 0x1

    invoke-virtual {v0, v7, v8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 70
    new-instance v7, Lcom/poshmark/ui/fragments/PricePickerFragment$1;

    invoke-direct {v7, p0}, Lcom/poshmark/ui/fragments/PricePickerFragment$1;-><init>(Lcom/poshmark/ui/fragments/PricePickerFragment;)V

    invoke-virtual {v7}, Lcom/poshmark/ui/fragments/PricePickerFragment$1;->getType()Ljava/lang/reflect/Type;

    move-result-object v4

    .line 71
    .local v4, "listOfObjectType":Ljava/lang/reflect/Type;
    iget-object v7, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iget-object v7, v7, Lcom/poshmark/utils/meta_data/PricePickerInfo;->selectedItems:Ljava/util/List;

    invoke-static {v7, v4}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/util/List;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v3

    .line 72
    .local v3, "json":Ljava/lang/String;
    const-string v7, "PRICE_LIST"

    invoke-virtual {v0, v7, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 77
    .end local v3    # "json":Ljava/lang/String;
    .end local v4    # "listOfObjectType":Ljava/lang/reflect/Type;
    :goto_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PricePickerFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFragment;

    .line 78
    .local v1, "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v1, :cond_2

    .line 79
    const-string v7, "RETURNED_RESULTS"

    invoke-virtual {v2, v7, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 80
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PricePickerFragment;->getTargetRequestCode()I

    move-result v6

    .line 81
    .local v6, "requestCode":I
    invoke-virtual {v1, v6, v9, v2}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 82
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PricePickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    .line 83
    .local v5, "parent":Landroid/app/Activity;
    if-eqz v5, :cond_0

    .line 84
    invoke-virtual {v5}, Landroid/app/Activity;->onBackPressed()V

    .line 91
    .end local v5    # "parent":Landroid/app/Activity;
    .end local v6    # "requestCode":I
    :cond_0
    :goto_1
    return v10

    .line 75
    .end local v1    # "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    :cond_1
    const-string v7, "PRICE_CHANGED"

    invoke-virtual {v0, v7, v10}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_0

    .line 87
    .restart local v1    # "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    :cond_2
    invoke-virtual {v2, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 88
    invoke-virtual {p0, v9, v2}, Lcom/poshmark/ui/fragments/PricePickerFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    goto :goto_1
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 113
    const-string v0, "listing_select_price_filter_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 114
    return-void
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 96
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 98
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->isG2FiltersEnabled:Z

    if-eqz v1, :cond_0

    .line 99
    const v1, 0x7f06004a

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/PricePickerFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 103
    .local v0, "buttonText":Ljava/lang/String;
    :goto_0
    new-instance v1, Lcom/poshmark/ui/fragments/PricePickerFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/PricePickerFragment$2;-><init>(Lcom/poshmark/ui/fragments/PricePickerFragment;)V

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/PricePickerFragment;->setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 109
    const v1, 0x7f060219

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/PricePickerFragment;->setTitle(I)V

    .line 110
    return-void

    .line 101
    .end local v0    # "buttonText":Ljava/lang/String;
    :cond_0
    const v1, 0x7f0600bf

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/PricePickerFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "buttonText":Ljava/lang/String;
    goto :goto_0
.end method

.method public setupButton(Landroid/widget/Button;Lcom/poshmark/data_model/models/PriceInfo;I)V
    .locals 2
    .param p1, "button"    # Landroid/widget/Button;
    .param p2, "item"    # Lcom/poshmark/data_model/models/PriceInfo;
    .param p3, "index"    # I

    .prologue
    .line 176
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setVisibility(I)V

    .line 177
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iget-object v0, v0, Lcom/poshmark/utils/meta_data/PricePickerInfo;->selectedItems:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 178
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PricePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f020015

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 179
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PricePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090040

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setTextColor(I)V

    .line 181
    :cond_0
    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 182
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PricePickerFragment;->sizeButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 183
    return-void
.end method
