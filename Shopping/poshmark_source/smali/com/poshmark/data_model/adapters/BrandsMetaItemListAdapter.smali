.class public Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;
.super Landroid/widget/ArrayAdapter;
.source "BrandsMetaItemListAdapter.java"

# interfaces
.implements Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersAdapter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/poshmark/data_model/models/IndexedMetaItem;",
        ">;",
        "Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersAdapter;"
    }
.end annotation


# instance fields
.field brandsMetaInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

.field context:Landroid/content/Context;

.field currentSelection:Lcom/poshmark/data_model/models/MetaItem;

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

.field filter:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;

.field filterEnabled:Z

.field public filteredData:Ljava/util/ArrayList;
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

.field public recentBrandsList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field searchTerm:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;Ljava/util/ArrayList;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "layoutResourceId"    # I
    .param p3, "brandsMetaInfo"    # Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 42
    .local p4, "recentBrands":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->allItems:Ljava/util/List;

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v0}, Lcom/poshmark/data_model/models/IndexedMetaItem;->convertToIndexMetaItemList(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-direct {p0, p1, p2, v0}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 44
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->context:Landroid/content/Context;

    .line 45
    iput p2, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->layoutResourceId:I

    .line 46
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->data:Ljava/util/ArrayList;

    if-nez v0, :cond_1

    .line 47
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->data:Ljava/util/ArrayList;

    .line 50
    :goto_0
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v0, :cond_0

    .line 51
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    .line 52
    :cond_0
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->allItems:Ljava/util/List;

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v0, p4}, Lcom/poshmark/data_model/models/IndexedMetaItem;->convertRecentBrandsToIndexMetaItemList(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    .line 53
    new-instance v0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;-><init>(Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;)V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->filter:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;

    .line 54
    iput-object p4, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->recentBrandsList:Ljava/util/ArrayList;

    .line 55
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->allItems:Ljava/util/List;

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v0}, Lcom/poshmark/data_model/models/IndexedMetaItem;->convertToIndexMetaItemList(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->data:Ljava/util/ArrayList;

    .line 56
    return-void

    .line 49
    :cond_1
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->allItems:Ljava/util/List;

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v0, p4}, Lcom/poshmark/data_model/models/IndexedMetaItem;->convertRecentBrandsToIndexMetaItemList(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->data:Ljava/util/ArrayList;

    goto :goto_0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getFilter()Landroid/widget/Filter;
    .locals 1

    .prologue
    .line 130
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->filterEnabled:Z

    .line 131
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->filter:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;

    if-nez v0, :cond_0

    .line 132
    new-instance v0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;-><init>(Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;)V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->filter:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;

    .line 135
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->filter:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;

    return-object v0
.end method

.method public getHeaderId(I)J
    .locals 2
    .param p1, "i"    # I

    .prologue
    .line 122
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->recentBrandsList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->recentBrandsList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lt p1, v0, :cond_0

    .line 123
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->recentBrandsList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    int-to-long v0, v0

    .line 125
    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0
.end method

.method public getHeaderView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "i"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "viewGroup"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v5, 0x0

    .line 92
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->context:Landroid/content/Context;

    check-cast v4, Landroid/app/Activity;

    invoke-virtual {v4}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v1

    .line 93
    .local v1, "inflater":Landroid/view/LayoutInflater;
    if-nez p2, :cond_0

    .line 94
    new-instance v3, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;

    invoke-direct {v3}, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;-><init>()V

    .line 95
    .local v3, "viewHolder":Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;
    const v4, 0x7f0300c4

    invoke-virtual {v1, v4, p3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 96
    const v4, 0x7f0c0130

    invoke-virtual {p2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, v3, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;->titleView:Landroid/widget/TextView;

    .line 97
    invoke-virtual {p2, v3}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 102
    :goto_0
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->recentBrandsList:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-lt p1, v4, :cond_1

    .line 103
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->context:Landroid/content/Context;

    const v5, 0x7f06003c

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v0

    .line 104
    .local v0, "allString":Ljava/lang/String;
    iget-object v4, v3, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;->titleView:Landroid/widget/TextView;

    invoke-virtual {v4, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 115
    .end local v0    # "allString":Ljava/lang/String;
    :goto_1
    return-object p2

    .line 99
    .end local v3    # "viewHolder":Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;

    .restart local v3    # "viewHolder":Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;
    goto :goto_0

    .line 106
    :cond_1
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->recentBrandsList:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-lez v4, :cond_2

    .line 107
    iget-object v4, v3, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;->titleView:Landroid/widget/TextView;

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 108
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->context:Landroid/content/Context;

    const v5, 0x7f060221

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v2

    .line 109
    .local v2, "recentString":Ljava/lang/String;
    iget-object v4, v3, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;->titleView:Landroid/widget/TextView;

    invoke-virtual {v4, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1

    .line 111
    .end local v2    # "recentString":Ljava/lang/String;
    :cond_2
    iget-object v4, v3, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;->titleView:Landroid/widget/TextView;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 7
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 60
    move-object v1, p2

    .line 61
    .local v1, "row":Landroid/view/View;
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->context:Landroid/content/Context;

    check-cast v3, Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    .line 62
    .local v0, "inflater":Landroid/view/LayoutInflater;
    if-nez v1, :cond_0

    .line 63
    iget v3, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->layoutResourceId:I

    invoke-virtual {v0, v3, p3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 66
    :cond_0
    const v3, 0x7f0c0208

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 67
    .local v2, "textView":Landroid/widget/TextView;
    invoke-virtual {v2, v4, v4, v4, v4}, Landroid/widget/TextView;->setCompoundDrawables(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 70
    :try_start_0
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/IndexedMetaItem;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/IndexedMetaItem;->getMetaItem()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 72
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/IndexedMetaItem;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/IndexedMetaItem;->getMetaItem()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 73
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f09003c

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 74
    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v4}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 75
    const/4 v3, 0x0

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->context:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f02007e

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v2, v3, v4, v5, v6}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 80
    :goto_0
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/IndexedMetaItem;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/IndexedMetaItem;->getIndex()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 85
    :goto_1
    return-object v1

    .line 77
    :cond_1
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f090035

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 78
    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 81
    :catch_0
    move-exception v3

    goto :goto_1
.end method
