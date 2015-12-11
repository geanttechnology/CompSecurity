.class public Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;
.super Landroid/widget/Filter;
.source "BrandsMetaItemListAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "BrandSearchFilter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;)V
    .locals 0

    .prologue
    .line 148
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;->this$0:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    invoke-direct {p0}, Landroid/widget/Filter;-><init>()V

    return-void
.end method


# virtual methods
.method protected performFiltering(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;
    .locals 7
    .param p1, "charSequence"    # Ljava/lang/CharSequence;

    .prologue
    .line 153
    new-instance v4, Landroid/widget/Filter$FilterResults;

    invoke-direct {v4}, Landroid/widget/Filter$FilterResults;-><init>()V

    .line 154
    .local v4, "result":Landroid/widget/Filter$FilterResults;
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 155
    .local v1, "filteredData":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/data_model/models/IndexedMetaItem;>;"
    iget-object v5, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;->this$0:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->searchTerm:Ljava/lang/String;

    .line 156
    iget-object v5, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;->this$0:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    iget-object v5, v5, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->data:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 159
    .local v3, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/IndexedMetaItem;>;"
    :cond_0
    :goto_0
    :try_start_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 160
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/IndexedMetaItem;

    .line 163
    .local v2, "item":Lcom/poshmark/data_model/models/IndexedMetaItem;
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/IndexedMetaItem;->getMetaItem()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;->this$0:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    iget-object v6, v6, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->searchTerm:Ljava/lang/String;

    invoke-virtual {v6}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 164
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 168
    .end local v2    # "item":Lcom/poshmark/data_model/models/IndexedMetaItem;
    :catch_0
    move-exception v0

    .line 170
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 172
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v5

    iput v5, v4, Landroid/widget/Filter$FilterResults;->count:I

    .line 173
    iput-object v1, v4, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    .line 174
    return-object v4
.end method

.method protected publishResults(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;)V
    .locals 2
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "results"    # Landroid/widget/Filter$FilterResults;

    .prologue
    .line 180
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;->this$0:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    iget-object v0, p2, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, v1, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    .line 181
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;->this$0:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->recentBrandsList:Ljava/util/ArrayList;

    .line 182
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter$BrandSearchFilter;->this$0:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->notifyDataSetChanged()V

    .line 183
    return-void
.end method
