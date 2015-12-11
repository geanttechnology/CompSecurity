.class public Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;
.super Landroid/app/Fragment;
.source "BrowseFilterCategoriesPanel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$CategoryOnClickListener;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;

.field public static final TAG:Ljava/lang/String;


# instance fields
.field private categoriesContainer:Landroid/view/ViewGroup;

.field private category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

.field private downloadableCheckbox:Landroid/widget/CheckBox;

.field private final filterChangeListener:Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener",
            "<",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;",
            ">;"
        }
    .end annotation
.end field

.field private filterEventListener:Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;

.field private inflater:Landroid/view/LayoutInflater;

.field private isDualPanel:Z

.field private selectedCategoryView:Landroid/view/View;

.field private subscriptionOnlyCheckbox:Landroid/widget/CheckBox;

.field private tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->LOG:Lorg/slf4j/Logger;

    .line 25
    const-class v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 58
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 31
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->GENRE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .line 39
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$1;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->filterChangeListener:Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;

    .line 58
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;)Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->filterEventListener:Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;)Landroid/widget/CheckBox;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->downloadableCheckbox:Landroid/widget/CheckBox;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;)Landroid/widget/CheckBox;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->subscriptionOnlyCheckbox:Landroid/widget/CheckBox;

    return-object v0
.end method

.method public static newInstance(Z)Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;
    .locals 3
    .param p0, "isDualPanel"    # Z

    .prologue
    .line 49
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 50
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "isDualPanel"

    invoke-virtual {v0, v2, p0}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 52
    new-instance v1, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    invoke-direct {v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;-><init>()V

    .line 53
    .local v1, "browseFilterCategoriesPanel":Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;
    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->setArguments(Landroid/os/Bundle;)V

    .line 55
    return-object v1
.end method

.method private updateSelectedCount(Ljava/util/Map;Landroid/view/View;)V
    .locals 9
    .param p2, "categoryView"    # Landroid/view/View;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Landroid/view/View;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "currentFilters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 221
    sget v3, Lcom/xfinity/playerlib/R$id;->filterCountContainer:I

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 222
    .local v0, "filterCountContainer":Landroid/view/View;
    sget v3, Lcom/xfinity/playerlib/R$id;->filterCount:I

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 223
    .local v1, "filterCountView":Landroid/widget/TextView;
    invoke-interface {p1}, Ljava/util/Map;->size()I

    move-result v2

    .line 226
    .local v2, "size":I
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$plurals;->content_description_filter_items_count:I

    new-array v5, v8, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-virtual {v3, v4, v2, v5}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 225
    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 228
    if-lez v2, :cond_0

    .line 229
    sget-object v3, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v4, "%d"

    new-array v5, v8, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v3, v4, v5}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 230
    invoke-virtual {v0, v7}, Landroid/view/View;->setVisibility(I)V

    .line 235
    :goto_0
    return-void

    .line 233
    :cond_0
    const/4 v3, 0x4

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method protected addNetworkCategoryView(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V
    .locals 6
    .param p1, "filter"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .prologue
    .line 165
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    invoke-interface {v2}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getNetworks()Ljava/util/List;

    move-result-object v0

    .line 166
    .local v0, "networkList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/Network;>;"
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    const/4 v3, 0x1

    if-le v2, v3, :cond_0

    .line 167
    sget-object v2, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->NETWORK:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentNetworkFilters()Ljava/util/HashMap;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->categoriesContainer:Landroid/view/ViewGroup;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {p0, v2, v3, v4, v5}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->createCategoryView(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;Ljava/util/Map;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)Landroid/view/View;

    move-result-object v1

    .line 169
    .local v1, "view":Landroid/view/View;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->categoriesContainer:Landroid/view/ViewGroup;

    invoke-virtual {v2, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 171
    .end local v1    # "view":Landroid/view/View;
    :cond_0
    return-void
.end method

.method public createCategoryView(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;Ljava/util/Map;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)Landroid/view/View;
    .locals 5
    .param p1, "category"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
    .param p3, "parent"    # Landroid/view/ViewGroup;
    .param p4, "selectedCategory"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Landroid/view/ViewGroup;",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;",
            ")",
            "Landroid/view/View;"
        }
    .end annotation

    .prologue
    .line 176
    .local p2, "currentFilters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->inflater:Landroid/view/LayoutInflater;

    sget v3, Lcom/xfinity/playerlib/R$layout;->filter_dialog_category_item:I

    const/4 v4, 0x0

    invoke-virtual {v2, v3, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 178
    .local v0, "categoryView":Landroid/view/View;
    invoke-virtual {v0, p1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 180
    sget v2, Lcom/xfinity/playerlib/R$id;->label:I

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 182
    .local v1, "label":Landroid/widget/TextView;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {p1, v2}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->getLabel(Landroid/content/Context;)Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 183
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {p1, v2}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->getContentDescription(Landroid/content/Context;)Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 185
    new-instance v2, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$CategoryOnClickListener;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v3}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$CategoryOnClickListener;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$1;)V

    invoke-virtual {v0, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 187
    invoke-virtual {v0, p1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 189
    if-ne p4, p1, :cond_0

    .line 190
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->setSelectedCategoryView(Landroid/view/View;)V

    .line 193
    :cond_0
    invoke-direct {p0, p2, v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->updateSelectedCount(Ljava/util/Map;Landroid/view/View;)V

    .line 195
    return-object v0
.end method

.method public getFilterChangeListener()Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener",
            "<",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;",
            ">;"
        }
    .end annotation

    .prologue
    .line 238
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->filterChangeListener:Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;

    return-object v0
.end method

.method public initializeCategoriesList(Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V
    .locals 4
    .param p1, "tagsRoot"    # Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    .param p2, "filter"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .param p3, "category"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .prologue
    .line 141
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .line 143
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->selectedCategoryView:Landroid/view/View;

    if-eqz v1, :cond_0

    .line 144
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->selectedCategoryView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object p3

    .end local p3    # "category":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
    check-cast p3, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .line 147
    .restart local p3    # "category":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->categoriesContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 149
    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->GENRE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {p2}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentGenreFilters()Ljava/util/HashMap;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->categoriesContainer:Landroid/view/ViewGroup;

    invoke-virtual {p0, v1, v2, v3, p3}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->createCategoryView(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;Ljava/util/Map;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)Landroid/view/View;

    move-result-object v0

    .line 152
    .local v0, "view":Landroid/view/View;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->categoriesContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 154
    invoke-virtual {p0, p2}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->addNetworkCategoryView(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V

    .line 156
    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->ALPHA:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {p2}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentAlphaFilters()Ljava/util/HashMap;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->categoriesContainer:Landroid/view/ViewGroup;

    invoke-virtual {p0, v1, v2, v3, p3}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->createCategoryView(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;Ljava/util/Map;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)Landroid/view/View;

    move-result-object v0

    .line 159
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->categoriesContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 161
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->filterEventListener:Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;

    invoke-interface {v1, p3}, Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;->onCategoryChanged(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    .line 162
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 116
    invoke-super {p0, p1}, Landroid/app/Fragment;->onAttach(Landroid/app/Activity;)V

    .line 119
    check-cast p1, Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->filterEventListener:Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;

    .line 120
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 62
    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 63
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 64
    .local v0, "args":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 65
    const-string v1, "isDualPanel"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->isDualPanel:Z

    .line 67
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->inflater:Landroid/view/LayoutInflater;

    .line 73
    sget v3, Lcom/xfinity/playerlib/R$layout;->filter_dialog_main:I

    const/4 v4, 0x0

    invoke-virtual {p1, v3, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 75
    .local v2, "view":Landroid/view/View;
    sget v3, Lcom/xfinity/playerlib/R$id;->categoriesContainer:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup;

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->categoriesContainer:Landroid/view/ViewGroup;

    .line 77
    sget v3, Lcom/xfinity/playerlib/R$id;->subscription_only_checkbox:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/CheckBox;

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->subscriptionOnlyCheckbox:Landroid/widget/CheckBox;

    .line 78
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->subscriptionOnlyCheckbox:Landroid/widget/CheckBox;

    new-instance v4, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$2;

    invoke-direct {v4, p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$2;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;)V

    invoke-virtual {v3, v4}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 85
    sget v3, Lcom/xfinity/playerlib/R$id;->downloadable_checkbox:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/CheckBox;

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->downloadableCheckbox:Landroid/widget/CheckBox;

    .line 86
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->downloadableCheckbox:Landroid/widget/CheckBox;

    new-instance v4, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$3;

    invoke-direct {v4, p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$3;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;)V

    invoke-virtual {v3, v4}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 93
    sget v3, Lcom/xfinity/playerlib/R$id;->downloadable_checkbox_container:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 95
    .local v0, "downloadableCheckboxContainer":Landroid/view/View;
    new-instance v3, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$4;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$4;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;)V

    invoke-virtual {v0, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 102
    sget v3, Lcom/xfinity/playerlib/R$id;->subscription_only_checkbox_container:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 104
    .local v1, "subscriptionOnlyCheckboxContainer":Landroid/view/View;
    new-instance v3, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$5;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$5;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;)V

    invoke-virtual {v1, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 111
    return-object v2
.end method

.method protected setSelectedCategoryView(Landroid/view/View;)V
    .locals 2
    .param p1, "categoryView"    # Landroid/view/View;

    .prologue
    .line 200
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->selectedCategoryView:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 201
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->selectedCategoryView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setSelected(Z)V

    .line 204
    :cond_0
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->selectedCategoryView:Landroid/view/View;

    .line 206
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->isDualPanel:Z

    if-eqz v0, :cond_1

    .line 207
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->selectedCategoryView:Landroid/view/View;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/View;->setSelected(Z)V

    .line 209
    :cond_1
    return-void
.end method

.method public updateCategoriesList(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V
    .locals 5
    .param p1, "filter"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .prologue
    .line 123
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->selectedCategoryView:Landroid/view/View;

    if-eqz v1, :cond_0

    .line 124
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->selectedCategoryView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .line 127
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->categoriesContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 128
    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->GENRE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentGenreFilters()Ljava/util/HashMap;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->categoriesContainer:Landroid/view/ViewGroup;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {p0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->createCategoryView(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;Ljava/util/Map;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)Landroid/view/View;

    move-result-object v0

    .line 130
    .local v0, "view":Landroid/view/View;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->categoriesContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 132
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->addNetworkCategoryView(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V

    .line 134
    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->ALPHA:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentAlphaFilters()Ljava/util/HashMap;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->categoriesContainer:Landroid/view/ViewGroup;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {p0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->createCategoryView(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;Ljava/util/Map;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)Landroid/view/View;

    move-result-object v0

    .line 137
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->categoriesContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 138
    return-void
.end method

.method public updateDownloadableCheckbox(Z)V
    .locals 1
    .param p1, "checked"    # Z

    .prologue
    .line 212
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->downloadableCheckbox:Landroid/widget/CheckBox;

    invoke-virtual {v0, p1}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 213
    return-void
.end method

.method public updateHideLockedCheckbox(Z)V
    .locals 1
    .param p1, "checked"    # Z

    .prologue
    .line 216
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->subscriptionOnlyCheckbox:Landroid/widget/CheckBox;

    invoke-virtual {v0, p1}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 217
    return-void
.end method
