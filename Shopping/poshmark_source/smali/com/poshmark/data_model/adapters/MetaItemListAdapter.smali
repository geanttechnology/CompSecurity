.class public Lcom/poshmark/data_model/adapters/MetaItemListAdapter;
.super Landroid/widget/ArrayAdapter;
.source "MetaItemListAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/adapters/MetaItemListAdapter$BrandSearchFilter;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/poshmark/data_model/models/IndexedMetaItem;",
        ">;"
    }
.end annotation


# instance fields
.field allowCustomStringEnabled:Z

.field context:Landroid/content/Context;

.field currentSelection:Lcom/poshmark/data_model/models/MetaItem;

.field customOptionEnabled:Z

.field data:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/IndexedMetaItem;",
            ">;"
        }
    .end annotation
.end field

.field filter:Lcom/poshmark/data_model/adapters/MetaItemListAdapter$BrandSearchFilter;

.field filteredData:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/IndexedMetaItem;",
            ">;"
        }
    .end annotation
.end field

.field layoutResourceId:I

.field searchEnabled:Z

.field searchTerm:Ljava/lang/String;

.field showBrandFollowButton:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;ILcom/poshmark/utils/meta_data/MetaItemPickerInfo;ZZZZ)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "layoutResourceId"    # I
    .param p3, "data"    # Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;
    .param p4, "search"    # Z
    .param p5, "customOption"    # Z
    .param p6, "allowCutomString"    # Z
    .param p7, "showBrandFollowButton"    # Z

    .prologue
    .line 57
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v0}, Lcom/poshmark/data_model/models/IndexedMetaItem;->convertToIndexMetaItemList(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-direct {p0, p1, p2, v0}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 58
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->context:Landroid/content/Context;

    .line 59
    if-nez p3, :cond_0

    .line 60
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->data:Ljava/util/ArrayList;

    .line 65
    :goto_0
    iput p2, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->layoutResourceId:I

    .line 66
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    .line 67
    new-instance v0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter$BrandSearchFilter;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/adapters/MetaItemListAdapter$BrandSearchFilter;-><init>(Lcom/poshmark/data_model/adapters/MetaItemListAdapter;)V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filter:Lcom/poshmark/data_model/adapters/MetaItemListAdapter$BrandSearchFilter;

    .line 68
    iput-boolean p4, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->searchEnabled:Z

    .line 69
    iput-boolean p5, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->customOptionEnabled:Z

    .line 70
    iput-boolean p6, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->allowCustomStringEnabled:Z

    .line 71
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v0}, Lcom/poshmark/data_model/models/IndexedMetaItem;->convertToIndexMetaItemList(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    .line 72
    iput-boolean p7, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->showBrandFollowButton:Z

    .line 73
    return-void

    .line 63
    :cond_0
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v0}, Lcom/poshmark/data_model/models/IndexedMetaItem;->convertToIndexMetaItemList(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->data:Ljava/util/ArrayList;

    goto :goto_0
.end method

.method private constructor <init>(Landroid/content/Context;ILjava/util/ArrayList;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "layoutResourceId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/IndexedMetaItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 76
    .local p3, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/data_model/models/IndexedMetaItem;>;"
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 78
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 81
    iget-boolean v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->allowCustomStringEnabled:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->searchEnabled:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->searchTerm:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->searchTerm:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 82
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    .line 87
    :goto_0
    return v0

    .line 84
    :cond_0
    iget-boolean v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->customOptionEnabled:Z

    if-eqz v0, :cond_1

    .line 85
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 87
    :cond_1
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    goto :goto_0
.end method

.method public getFilter()Landroid/widget/Filter;
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filter:Lcom/poshmark/data_model/adapters/MetaItemListAdapter$BrandSearchFilter;

    if-nez v0, :cond_0

    .line 192
    new-instance v0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter$BrandSearchFilter;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/adapters/MetaItemListAdapter$BrandSearchFilter;-><init>(Lcom/poshmark/data_model/adapters/MetaItemListAdapter;)V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filter:Lcom/poshmark/data_model/adapters/MetaItemListAdapter$BrandSearchFilter;

    .line 195
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filter:Lcom/poshmark/data_model/adapters/MetaItemListAdapter$BrandSearchFilter;

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 14
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 92
    move-object/from16 v8, p2

    .line 93
    .local v8, "row":Landroid/view/View;
    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->context:Landroid/content/Context;

    check-cast v10, Landroid/app/Activity;

    invoke-virtual {v10}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v4

    .line 94
    .local v4, "inflater":Landroid/view/LayoutInflater;
    if-nez v8, :cond_0

    .line 95
    iget v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->layoutResourceId:I

    const/4 v11, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v4, v10, v0, v11}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v8

    .line 98
    :cond_0
    const v10, 0x7f0c0207

    invoke-virtual {v8, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RelativeLayout;

    .line 99
    .local v3, "container":Landroid/widget/RelativeLayout;
    const v10, 0x7f0c0209

    invoke-virtual {v8, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 100
    .local v2, "buttonContainer":Landroid/widget/LinearLayout;
    const v10, 0x7f0c0208

    invoke-virtual {v8, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    .line 102
    .local v9, "textView":Landroid/widget/TextView;
    const/4 v1, 0x0

    .line 103
    .local v1, "brandLayout":Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;
    iget-boolean v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->showBrandFollowButton:Z

    if-eqz v10, :cond_1

    .line 104
    const/4 v10, 0x0

    invoke-virtual {v2, v10}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 105
    const v10, 0x7f0c0066

    invoke-virtual {v8, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .end local v1    # "brandLayout":Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;
    check-cast v1, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    .line 106
    .restart local v1    # "brandLayout":Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;
    const v10, 0x7f020009

    const v11, 0x7f090039

    invoke-virtual {v1, v10, v11}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setFollowingButtonColor(II)V

    .line 110
    :cond_1
    iget-boolean v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->allowCustomStringEnabled:Z

    if-eqz v10, :cond_4

    iget-boolean v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->searchEnabled:Z

    if-eqz v10, :cond_4

    .line 113
    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->searchTerm:Ljava/lang/String;

    if-eqz v10, :cond_3

    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->searchTerm:Ljava/lang/String;

    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v10

    if-lez v10, :cond_3

    .line 114
    if-nez p1, :cond_2

    .line 115
    invoke-virtual {p0}, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->getContext()Landroid/content/Context;

    move-result-object v10

    invoke-virtual {v10}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    const v11, 0x7f020065

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v10

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    invoke-virtual {v9, v10, v11, v12, v13}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 116
    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->searchTerm:Ljava/lang/String;

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 156
    :goto_0
    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->context:Landroid/content/Context;

    const/high16 v11, 0x41f00000    # 30.0f

    invoke-static {v10, v11}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v10

    float-to-int v6, v10

    .line 157
    .local v6, "marginTop":I
    move v5, v6

    .line 158
    .local v5, "marginBottom":I
    invoke-virtual {v3}, Landroid/widget/RelativeLayout;->getPaddingTop()I

    move-result v7

    .line 185
    .local v7, "padding":I
    return-object v8

    .line 118
    .end local v5    # "marginBottom":I
    .end local v6    # "marginTop":I
    .end local v7    # "padding":I
    :cond_2
    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    invoke-virtual {v9, v10, v11, v12, v13}, Landroid/widget/TextView;->setCompoundDrawables(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 119
    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    add-int/lit8 v11, p1, -0x1

    invoke-virtual {v10, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/poshmark/data_model/models/IndexedMetaItem;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/IndexedMetaItem;->getMetaItem()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v10

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 120
    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    add-int/lit8 v11, p1, -0x1

    invoke-virtual {v10, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/poshmark/data_model/models/IndexedMetaItem;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/IndexedMetaItem;->getIndex()I

    move-result v10

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v8, v10}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    goto :goto_0

    .line 123
    :cond_3
    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    invoke-virtual {v9, v10, v11, v12, v13}, Landroid/widget/TextView;->setCompoundDrawables(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 124
    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    invoke-virtual {v10, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/poshmark/data_model/models/IndexedMetaItem;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/IndexedMetaItem;->getMetaItem()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v10

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 125
    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    invoke-virtual {v10, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/poshmark/data_model/models/IndexedMetaItem;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/IndexedMetaItem;->getIndex()I

    move-result v10

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v8, v10}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    goto :goto_0

    .line 128
    :cond_4
    iget-boolean v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->customOptionEnabled:Z

    if-eqz v10, :cond_5

    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    invoke-virtual {v10}, Ljava/util/ArrayList;->size()I

    move-result v10

    if-ne p1, v10, :cond_5

    .line 129
    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    invoke-virtual {v9, v10, v11, v12, v13}, Landroid/widget/TextView;->setCompoundDrawables(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 130
    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->context:Landroid/content/Context;

    const v11, 0x7f060032

    invoke-virtual {v10, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 133
    :cond_5
    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    invoke-virtual {v9, v10, v11, v12, v13}, Landroid/widget/TextView;->setCompoundDrawables(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 135
    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    invoke-virtual {v10, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/poshmark/data_model/models/IndexedMetaItem;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/IndexedMetaItem;->getMetaItem()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v10

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 136
    if-eqz v1, :cond_6

    .line 137
    const-string v10, "listing_select_brand_screen"

    invoke-virtual {v1, v10}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setParentScreenNameForAnalytics(Ljava/lang/String;)V

    .line 138
    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    invoke-virtual {v10, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/poshmark/data_model/models/IndexedMetaItem;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/IndexedMetaItem;->getMetaItem()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v10

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v10}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setBrand(Ljava/lang/String;)V

    .line 141
    :cond_6
    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v10, :cond_7

    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    invoke-virtual {v10, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/poshmark/data_model/models/IndexedMetaItem;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/IndexedMetaItem;->getMetaItem()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v10

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v10

    iget-object v11, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v11}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_7

    .line 143
    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->context:Landroid/content/Context;

    invoke-virtual {v10}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    const v11, 0x7f09003c

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getColor(I)I

    move-result v10

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setTextColor(I)V

    .line 144
    const/4 v10, 0x0

    const/4 v11, 0x1

    invoke-virtual {v9, v10, v11}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 145
    const/4 v10, 0x0

    const/4 v11, 0x0

    iget-object v12, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->context:Landroid/content/Context;

    invoke-virtual {v12}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v12

    const v13, 0x7f02007e

    invoke-virtual {v12, v13}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v12

    const/4 v13, 0x0

    invoke-virtual {v9, v10, v11, v12, v13}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 152
    :goto_1
    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    invoke-virtual {v10, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/poshmark/data_model/models/IndexedMetaItem;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/IndexedMetaItem;->getIndex()I

    move-result v10

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v8, v10}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 149
    :cond_7
    iget-object v10, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->context:Landroid/content/Context;

    invoke-virtual {v10}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    const v11, 0x7f090035

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getColor(I)I

    move-result v10

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setTextColor(I)V

    .line 150
    const/4 v10, 0x0

    const/4 v11, 0x0

    invoke-virtual {v9, v10, v11}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    goto :goto_1
.end method
