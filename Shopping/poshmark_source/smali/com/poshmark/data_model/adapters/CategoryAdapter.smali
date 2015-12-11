.class public Lcom/poshmark/data_model/adapters/CategoryAdapter;
.super Landroid/widget/ArrayAdapter;
.source "CategoryAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/poshmark/data_model/models/MetaItem;",
        ">;"
    }
.end annotation


# instance fields
.field context:Landroid/content/Context;

.field defaultColor:I

.field defaultColorSet:Z

.field fragment:Lcom/poshmark/ui/fragments/CategoryListFragment;

.field info:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

.field isAllSelected:Z

.field layoutResourceId:I

.field parentListView:Landroid/widget/ListView;

.field selectedCategory:Lcom/poshmark/data_model/models/MetaItem;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;Lcom/poshmark/ui/fragments/CategoryListFragment;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "layoutResourceId"    # I
    .param p3, "info"    # Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;
    .param p4, "fragment"    # Lcom/poshmark/ui/fragments/CategoryListFragment;

    .prologue
    const/4 v1, 0x0

    .line 42
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->categoryFacetList:Ljava/util/List;

    invoke-direct {p0, p1, p2, v0}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 35
    iput-boolean v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->isAllSelected:Z

    .line 37
    iput-boolean v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->defaultColorSet:Z

    .line 44
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->context:Landroid/content/Context;

    .line 45
    iput p2, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->layoutResourceId:I

    .line 46
    iput-object p4, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->fragment:Lcom/poshmark/ui/fragments/CategoryListFragment;

    .line 48
    iput-object p3, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->info:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    .line 50
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    if-nez v0, :cond_0

    .line 51
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->isAllSelected:Z

    .line 55
    :goto_0
    return-void

    .line 53
    :cond_0
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->selectedCategory:Lcom/poshmark/data_model/models/MetaItem;

    goto :goto_0
.end method

.method private constructor <init>(Landroid/content/Context;ILjava/util/ArrayList;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "layoutResourceId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p3, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/data_model/models/MetaItem;>;"
    const/4 v0, 0x0

    .line 69
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 35
    iput-boolean v0, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->isAllSelected:Z

    .line 37
    iput-boolean v0, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->defaultColorSet:Z

    .line 70
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/data_model/adapters/CategoryAdapter;Landroid/view/View;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/data_model/adapters/CategoryAdapter;
    .param p1, "x1"    # Landroid/view/View;
    .param p2, "x2"    # Z

    .prologue
    .line 28
    invoke-direct {p0, p1, p2}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->setAllItemsRowState(Landroid/view/View;Z)V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/data_model/adapters/CategoryAdapter;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/data_model/adapters/CategoryAdapter;

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->removeAllSelections()V

    return-void
.end method

.method private static getCompleteList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 58
    .local p0, "tags":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    .local p1, "styles":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 59
    .local v0, "combinedList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    if-eqz p0, :cond_0

    .line 60
    invoke-interface {v0, p0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 62
    :cond_0
    if-eqz p1, :cond_1

    .line 63
    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 65
    :cond_1
    return-object v0
.end method

.method private removeAllSelections()V
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->info:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-virtual {v0}, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->removeAllSelections()V

    .line 169
    return-void
.end method

.method private removeCheckMark(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 188
    const v1, 0x7f0c0097

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 189
    .local v0, "checkMark":Landroid/widget/ImageView;
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 190
    return-void
.end method

.method private setAllItemsRowState(Landroid/view/View;Z)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;
    .param p2, "selected"    # Z

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 172
    const v2, 0x7f0c0072

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    .line 173
    .local v1, "allTextBox":Lcom/poshmark/ui/customviews/PMTextView;
    const v2, 0x7f0c0071

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 174
    .local v0, "allItemsLayout":Landroid/widget/LinearLayout;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 175
    const-string v2, "All"

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 176
    if-eqz p2, :cond_0

    .line 177
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f09003c

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 178
    invoke-virtual {v1, v4, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 179
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f02007e

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v4, v4, v2, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 185
    :goto_0
    return-void

    .line 181
    :cond_0
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090039

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 182
    invoke-virtual {v1, v4, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 183
    invoke-virtual {v1, v4, v4, v4, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setCompoundDrawables(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method private setItemState(Landroid/view/View;Lcom/poshmark/data_model/models/MetaItem;Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 8
    .param p1, "view"    # Landroid/view/View;
    .param p2, "metaItem"    # Lcom/poshmark/data_model/models/MetaItem;
    .param p3, "currentCategory"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    const/4 v7, 0x0

    const/16 v6, 0x8

    const/4 v5, 0x0

    .line 126
    const v3, 0x7f0c0099

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 127
    .local v1, "divider":Landroid/view/View;
    const v3, 0x7f0c009a

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 128
    .local v2, "subCat":Landroid/widget/TextView;
    const v3, 0x7f0c0098

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 130
    .local v0, "category":Landroid/widget/TextView;
    if-eqz p3, :cond_2

    invoke-virtual {p3}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 131
    invoke-direct {p0, p1}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->showCheckMark(Landroid/view/View;)V

    .line 132
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f09003c

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 133
    const/4 v3, 0x1

    invoke-virtual {v0, v7, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 134
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->info:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v3, v3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->info:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v3, v3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_1

    .line 135
    invoke-virtual {v1, v5}, Landroid/view/View;->setVisibility(I)V

    .line 136
    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 137
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->info:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v3, v3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-interface {v3, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 150
    :cond_0
    :goto_0
    return-void

    .line 138
    :cond_1
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->fragment:Lcom/poshmark/ui/fragments/CategoryListFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/CategoryListFragment;->isListingFlow()Z

    move-result v3

    if-nez v3, :cond_0

    .line 139
    invoke-virtual {v1, v5}, Landroid/view/View;->setVisibility(I)V

    .line 140
    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 141
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f06003c

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 144
    :cond_2
    invoke-direct {p0, p1}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->removeCheckMark(Landroid/view/View;)V

    .line 145
    iget v3, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->defaultColor:I

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 146
    invoke-virtual {v0, v7, v5}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 147
    invoke-virtual {v1, v6}, Landroid/view/View;->setVisibility(I)V

    .line 148
    invoke-virtual {v2, v6}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method private setupListItemClickListener()V
    .locals 2

    .prologue
    .line 95
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->parentListView:Landroid/widget/ListView;

    new-instance v1, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;

    invoke-direct {v1, p0}, Lcom/poshmark/data_model/adapters/CategoryAdapter$1;-><init>(Lcom/poshmark/data_model/adapters/CategoryAdapter;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 123
    return-void
.end method

.method private showCheckMark(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 193
    const v1, 0x7f0c0097

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 194
    .local v0, "checkMark":Landroid/widget/ImageView;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 195
    return-void
.end method

.method private toggleItem(Landroid/view/View;Lcom/poshmark/data_model/models/MetaItem;Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "metaItem"    # Lcom/poshmark/data_model/models/MetaItem;
    .param p3, "currentSelection"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 153
    if-eqz p3, :cond_1

    invoke-virtual {p3}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 154
    invoke-direct {p0, p1}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->removeCheckMark(Landroid/view/View;)V

    .line 160
    :goto_0
    iget-boolean v0, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->isAllSelected:Z

    if-eqz v0, :cond_0

    .line 161
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->isAllSelected:Z

    .line 162
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->fragment:Lcom/poshmark/ui/fragments/CategoryListFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->getListHeaderView()Landroid/view/View;

    move-result-object v0

    iget-boolean v1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->isAllSelected:Z

    invoke-direct {p0, v0, v1}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->setAllItemsRowState(Landroid/view/View;Z)V

    .line 164
    :cond_0
    return-void

    .line 156
    :cond_1
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->info:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iput-object p2, v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 157
    invoke-direct {p0, p1}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->showCheckMark(Landroid/view/View;)V

    goto :goto_0
.end method


# virtual methods
.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 7
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v6, 0x0

    .line 74
    move-object v2, p2

    .line 75
    .local v2, "row":Landroid/view/View;
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->context:Landroid/content/Context;

    check-cast v4, Landroid/app/Activity;

    invoke-virtual {v4}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    .line 76
    .local v0, "inflater":Landroid/view/LayoutInflater;
    if-nez v2, :cond_0

    .line 77
    iget v4, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->layoutResourceId:I

    const/4 v5, 0x0

    invoke-virtual {v0, v4, p3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 80
    :cond_0
    const v4, 0x7f0c0098

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 81
    .local v3, "textView":Landroid/widget/TextView;
    iget-boolean v4, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->defaultColorSet:Z

    if-nez v4, :cond_1

    .line 82
    const/4 v4, 0x1

    iput-boolean v4, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->defaultColorSet:Z

    .line 83
    invoke-virtual {v3}, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v4

    iput v4, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->defaultColor:I

    .line 86
    :cond_1
    invoke-virtual {v3, v6, v6, v6, v6}, Landroid/widget/TextView;->setCompoundDrawables(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 87
    invoke-virtual {p0, p1}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 88
    invoke-virtual {p0, p1}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/MetaItem;

    .line 89
    .local v1, "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->info:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v4, v4, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-direct {p0, v2, v1, v4}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->setItemState(Landroid/view/View;Lcom/poshmark/data_model/models/MetaItem;Lcom/poshmark/data_model/models/MetaItem;)V

    .line 90
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 91
    return-object v2
.end method

.method public setListView(Landroid/widget/ListView;)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;

    .prologue
    .line 198
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/CategoryAdapter;->parentListView:Landroid/widget/ListView;

    .line 199
    invoke-direct {p0}, Lcom/poshmark/data_model/adapters/CategoryAdapter;->setupListItemClickListener()V

    .line 200
    return-void
.end method
