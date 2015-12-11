.class Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;
.super Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;
.source "PhoneNetworkCollectionsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CategoryAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter",
        "<",
        "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
        "Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field private genres:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end field

.field private programCounts:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;Landroid/view/LayoutInflater;)V
    .locals 1
    .param p2, "inflator"    # Landroid/view/LayoutInflater;

    .prologue
    .line 154
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    .line 155
    invoke-direct {p0, p2}, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;-><init>(Landroid/view/LayoutInflater;)V

    .line 151
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->genres:Ljava/util/ArrayList;

    .line 152
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->programCounts:Ljava/util/Map;

    .line 156
    return-void
.end method


# virtual methods
.method protected bindItem(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;Lcom/xfinity/playerlib/model/tags/OrderedTag;)V
    .locals 3
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;
    .param p2, "item"    # Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .prologue
    .line 172
    iget-object v1, p1, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;->title:Landroid/widget/TextView;

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 173
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->programCounts:Ljava/util/Map;

    invoke-interface {v1, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    .line 174
    .local v0, "countString":Ljava/lang/String;
    iget-object v1, p1, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;->count:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 175
    return-void
.end method

.method protected bridge synthetic bindItem(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 150
    check-cast p1, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;

    check-cast p2, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->bindItem(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;Lcom/xfinity/playerlib/model/tags/OrderedTag;)V

    return-void
.end method

.method protected createViewHolder()Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;
    .locals 2

    .prologue
    .line 160
    new-instance v0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;-><init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$1;)V

    return-object v0
.end method

.method protected bridge synthetic createViewHolder()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 150
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->createViewHolder()Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;

    move-result-object v0

    return-object v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->genres:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Lcom/xfinity/playerlib/model/tags/OrderedTag;
    .locals 1
    .param p1, "i"    # I

    .prologue
    .line 189
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->genres:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    return-object v0
.end method

.method public bridge synthetic getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 150
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->getItem(I)Lcom/xfinity/playerlib/model/tags/OrderedTag;

    move-result-object v0

    return-object v0
.end method

.method protected getViewLayoutId()I
    .locals 1

    .prologue
    .line 179
    sget v0, Lcom/xfinity/playerlib/R$layout;->network_collections_item:I

    return v0
.end method

.method protected initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "viewGroup"    # Landroid/view/ViewGroup;
    .param p3, "holder"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;

    .prologue
    .line 165
    sget v0, Lcom/xfinity/playerlib/R$id;->title:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;->title:Landroid/widget/TextView;

    .line 166
    sget v0, Lcom/xfinity/playerlib/R$id;->count:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;->count:Landroid/widget/TextView;

    .line 168
    return-void
.end method

.method protected bridge synthetic initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 150
    check-cast p3, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;

    invoke-virtual {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryViewHolder;)V

    return-void
.end method

.method public setData(Lcom/xfinity/playerlib/model/tags/Network;Lcom/xfinity/playerlib/model/dibic/DibicResource;)V
    .locals 6
    .param p1, "network"    # Lcom/xfinity/playerlib/model/tags/Network;
    .param p2, "dibicResource"    # Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .prologue
    .line 193
    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->genres:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 194
    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->programCounts:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->clear()V

    .line 196
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/tags/Network;->getCategories()Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2, p1}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramsMatchingGenresAndNetwork(Ljava/util/List;Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/Map;

    move-result-object v1

    .line 197
    .local v1, "map":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/tags/OrderedTag;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    invoke-interface {v1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 198
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Lcom/xfinity/playerlib/model/tags/OrderedTag;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->genres:Ljava/util/ArrayList;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 199
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->programCounts:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v4, v5, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 202
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Lcom/xfinity/playerlib/model/tags/OrderedTag;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->notifyDataSetChanged()V

    .line 203
    return-void
.end method
