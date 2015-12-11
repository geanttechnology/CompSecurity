.class public Lcom/poshmark/data_model/adapters/SubCategoryAdapter;
.super Landroid/widget/ArrayAdapter;
.source "SubCategoryAdapter.java"


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

.field fragment:Lcom/poshmark/ui/fragments/SubCategoryListFragment;

.field info:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

.field isAllSelected:Z

.field layoutResourceId:I

.field parentListView:Landroid/widget/ListView;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;Lcom/poshmark/ui/fragments/SubCategoryListFragment;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "layoutResourceId"    # I
    .param p3, "info"    # Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;
    .param p4, "fragment"    # Lcom/poshmark/ui/fragments/SubCategoryListFragment;

    .prologue
    const/4 v1, 0x0

    .line 43
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    invoke-direct {p0, p1, p2, v0}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 37
    iput-boolean v1, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->isAllSelected:Z

    .line 38
    iput-boolean v1, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->defaultColorSet:Z

    .line 45
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->context:Landroid/content/Context;

    .line 46
    iput p2, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->layoutResourceId:I

    .line 47
    iput-object p4, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->fragment:Lcom/poshmark/ui/fragments/SubCategoryListFragment;

    .line 49
    iput-object p3, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->info:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    .line 51
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentGlobalStyleTagsSelection:Ljava/util/List;

    if-nez v0, :cond_0

    .line 52
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentGlobalStyleTagsSelection:Ljava/util/List;

    .line 54
    :cond_0
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    if-nez v0, :cond_1

    .line 55
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p3, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    .line 57
    :cond_1
    invoke-virtual {p3}, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->selectionsPresent()Z

    move-result v0

    if-nez v0, :cond_2

    .line 58
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->isAllSelected:Z

    .line 60
    :cond_2
    return-void
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

    .line 74
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 37
    iput-boolean v0, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->isAllSelected:Z

    .line 38
    iput-boolean v0, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->defaultColorSet:Z

    .line 75
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
    .line 63
    .local p0, "tags":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    .local p1, "styles":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 64
    .local v0, "combinedList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    if-eqz p0, :cond_0

    .line 65
    invoke-interface {v0, p0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 67
    :cond_0
    if-eqz p1, :cond_1

    .line 68
    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 70
    :cond_1
    return-object v0
.end method

.method private removeAllSelections()V
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->info:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-virtual {v0}, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->removeAllSelections()V

    .line 159
    return-void
.end method

.method private selectRowItem(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 190
    const v2, 0x7f0c0097

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 191
    .local v0, "checkMark":Landroid/widget/ImageView;
    const v2, 0x7f0c0208

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 192
    .local v1, "textView":Landroid/widget/TextView;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 193
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f09003c

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 194
    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 195
    return-void
.end method

.method private setAllItemsRowState(Landroid/view/View;Z)V
    .locals 7
    .param p1, "view"    # Landroid/view/View;
    .param p2, "selected"    # Z

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x0

    .line 162
    const v3, 0x7f0c0072

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    .line 163
    .local v1, "allTextBox":Lcom/poshmark/ui/customviews/PMTextView;
    const v3, 0x7f0c0071

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 164
    .local v0, "allItemsLayout":Landroid/widget/LinearLayout;
    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 165
    const-string v3, "All"

    invoke-virtual {v1, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 167
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v3, -0x1

    const/4 v4, -0x2

    invoke-direct {v2, v3, v4}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 169
    .local v2, "params":Landroid/widget/LinearLayout$LayoutParams;
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->context:Landroid/content/Context;

    const/high16 v4, 0x41f00000    # 30.0f

    invoke-static {v3, v4}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v3

    float-to-int v3, v3

    invoke-virtual {v2, v6, v6, v6, v3}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 170
    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 171
    if-eqz p2, :cond_0

    .line 172
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f09003c

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v1, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 173
    const/4 v3, 0x1

    invoke-virtual {v1, v5, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 174
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f02007e

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v1, v5, v5, v3, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 180
    :goto_0
    return-void

    .line 176
    :cond_0
    iget v3, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->defaultColor:I

    invoke-virtual {v1, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 177
    invoke-virtual {v1, v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 178
    invoke-virtual {v1, v5, v5, v5, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setCompoundDrawables(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method private setItemState(Landroid/view/View;Lcom/poshmark/data_model/models/MetaItem;Ljava/util/List;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;
    .param p2, "metaItem"    # Lcom/poshmark/data_model/models/MetaItem;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/View;",
            "Lcom/poshmark/data_model/models/MetaItem;",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 126
    .local p3, "currentSelections":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-interface {p3}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 127
    const/4 v1, 0x0

    invoke-interface {p3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/MetaItem;

    .line 128
    .local v0, "selectionItem":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 129
    invoke-direct {p0, p1}, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->selectRowItem(Landroid/view/View;)V

    .line 136
    .end local v0    # "selectionItem":Lcom/poshmark/data_model/models/MetaItem;
    :goto_0
    return-void

    .line 131
    .restart local v0    # "selectionItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    invoke-direct {p0, p1}, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->unselectRowItem(Landroid/view/View;)V

    goto :goto_0

    .line 134
    .end local v0    # "selectionItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_1
    invoke-direct {p0, p1}, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->unselectRowItem(Landroid/view/View;)V

    goto :goto_0
.end method

.method private setupListItemClickListener()V
    .locals 2

    .prologue
    .line 101
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->parentListView:Landroid/widget/ListView;

    new-instance v1, Lcom/poshmark/data_model/adapters/SubCategoryAdapter$1;

    invoke-direct {v1, p0}, Lcom/poshmark/data_model/adapters/SubCategoryAdapter$1;-><init>(Lcom/poshmark/data_model/adapters/SubCategoryAdapter;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 122
    return-void
.end method

.method private toggleItem(Landroid/view/View;Lcom/poshmark/data_model/models/MetaItem;Ljava/util/List;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;
    .param p2, "metaItem"    # Lcom/poshmark/data_model/models/MetaItem;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/View;",
            "Lcom/poshmark/data_model/models/MetaItem;",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 139
    .local p3, "currentSelections":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-interface {p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 140
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 141
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/MetaItem;

    .line 142
    .local v1, "selectionItem":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 143
    invoke-direct {p0, p1}, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->unselectRowItem(Landroid/view/View;)V

    .line 144
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    .line 154
    .end local v1    # "selectionItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_1
    :goto_0
    return-void

    .line 148
    :cond_2
    invoke-direct {p0, p1}, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->selectRowItem(Landroid/view/View;)V

    .line 149
    invoke-interface {p3, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 150
    iget-boolean v2, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->isAllSelected:Z

    if-eqz v2, :cond_1

    .line 151
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->isAllSelected:Z

    .line 152
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->fragment:Lcom/poshmark/ui/fragments/SubCategoryListFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/SubCategoryListFragment;->getListHeaderView()Landroid/view/View;

    move-result-object v2

    iget-boolean v3, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->isAllSelected:Z

    invoke-direct {p0, v2, v3}, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->setAllItemsRowState(Landroid/view/View;Z)V

    goto :goto_0
.end method

.method private unselectRowItem(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 182
    const v2, 0x7f0c0097

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 183
    .local v0, "checkMark":Landroid/widget/ImageView;
    const v2, 0x7f0c0208

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 184
    .local v1, "textView":Landroid/widget/TextView;
    iget v2, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->defaultColor:I

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 185
    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 186
    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 187
    return-void
.end method


# virtual methods
.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 7
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v6, 0x0

    .line 79
    move-object v2, p2

    .line 80
    .local v2, "row":Landroid/view/View;
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->context:Landroid/content/Context;

    check-cast v4, Landroid/app/Activity;

    invoke-virtual {v4}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    .line 81
    .local v0, "inflater":Landroid/view/LayoutInflater;
    if-nez v2, :cond_0

    .line 82
    iget v4, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->layoutResourceId:I

    const/4 v5, 0x0

    invoke-virtual {v0, v4, p3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 85
    :cond_0
    const v4, 0x7f0c0208

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 86
    .local v3, "textView":Landroid/widget/TextView;
    iget-boolean v4, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->defaultColorSet:Z

    if-nez v4, :cond_1

    .line 87
    const/4 v4, 0x1

    iput-boolean v4, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->defaultColorSet:Z

    .line 88
    invoke-virtual {v3}, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v4

    iput v4, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->defaultColor:I

    .line 92
    :cond_1
    invoke-virtual {v3, v6, v6, v6, v6}, Landroid/widget/TextView;->setCompoundDrawables(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 93
    invoke-virtual {p0, p1}, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 94
    invoke-virtual {p0, p1}, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/MetaItem;

    .line 95
    .local v1, "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->info:Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    iget-object v4, v4, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-direct {p0, v2, v1, v4}, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->setItemState(Landroid/view/View;Lcom/poshmark/data_model/models/MetaItem;Ljava/util/List;)V

    .line 96
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 97
    return-object v2
.end method

.method public setListView(Landroid/widget/ListView;)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;

    .prologue
    .line 198
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->parentListView:Landroid/widget/ListView;

    .line 199
    invoke-direct {p0}, Lcom/poshmark/data_model/adapters/SubCategoryAdapter;->setupListItemClickListener()V

    .line 200
    return-void
.end method
