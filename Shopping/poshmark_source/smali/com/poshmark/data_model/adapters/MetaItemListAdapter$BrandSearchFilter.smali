.class public Lcom/poshmark/data_model/adapters/MetaItemListAdapter$BrandSearchFilter;
.super Landroid/widget/Filter;
.source "MetaItemListAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/adapters/MetaItemListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "BrandSearchFilter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/data_model/adapters/MetaItemListAdapter;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/adapters/MetaItemListAdapter;)V
    .locals 0

    .prologue
    .line 200
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter$BrandSearchFilter;->this$0:Lcom/poshmark/data_model/adapters/MetaItemListAdapter;

    invoke-direct {p0}, Landroid/widget/Filter;-><init>()V

    return-void
.end method


# virtual methods
.method protected performFiltering(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;
    .locals 6
    .param p1, "charSequence"    # Ljava/lang/CharSequence;

    .prologue
    .line 205
    new-instance v3, Landroid/widget/Filter$FilterResults;

    invoke-direct {v3}, Landroid/widget/Filter$FilterResults;-><init>()V

    .line 206
    .local v3, "result":Landroid/widget/Filter$FilterResults;
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 207
    .local v0, "filteredData":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/data_model/models/IndexedMetaItem;>;"
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter$BrandSearchFilter;->this$0:Lcom/poshmark/data_model/adapters/MetaItemListAdapter;

    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->searchTerm:Ljava/lang/String;

    .line 209
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter$BrandSearchFilter;->this$0:Lcom/poshmark/data_model/adapters/MetaItemListAdapter;

    iget-object v4, v4, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->data:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 210
    .local v2, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/IndexedMetaItem;>;"
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 211
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/IndexedMetaItem;

    .line 212
    .local v1, "item":Lcom/poshmark/data_model/models/IndexedMetaItem;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/IndexedMetaItem;->getMetaItem()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 213
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 217
    .end local v1    # "item":Lcom/poshmark/data_model/models/IndexedMetaItem;
    :cond_1
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v4

    iput v4, v3, Landroid/widget/Filter$FilterResults;->count:I

    .line 218
    iput-object v0, v3, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    .line 219
    return-object v3
.end method

.method protected publishResults(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;)V
    .locals 2
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "results"    # Landroid/widget/Filter$FilterResults;

    .prologue
    .line 224
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter$BrandSearchFilter;->this$0:Lcom/poshmark/data_model/adapters/MetaItemListAdapter;

    iget-object v0, p2, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, v1, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->filteredData:Ljava/util/ArrayList;

    .line 225
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter$BrandSearchFilter;->this$0:Lcom/poshmark/data_model/adapters/MetaItemListAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->notifyDataSetChanged()V

    .line 226
    return-void
.end method
