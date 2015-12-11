.class public Lcom/amazon/mShop/gno/GNOItemAdapter;
.super Landroid/widget/BaseAdapter;
.source "GNOItemAdapter.java"

# interfaces
.implements Ljava/lang/Iterable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;,
        Lcom/amazon/mShop/gno/GNOItemAdapter$DividerViewHolder;,
        Lcom/amazon/mShop/gno/GNOItemAdapter$HideableItem;,
        Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/BaseAdapter;",
        "Ljava/lang/Iterable",
        "<",
        "Lcom/amazon/mShop/gno/GNODrawerItem;",
        ">;"
    }
.end annotation


# instance fields
.field private mCoins:Ljava/lang/String;

.field private final mDrawerItems:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;"
        }
    .end annotation
.end field

.field private mExpandedGroupId:Ljava/lang/String;

.field private mFakeExpandCollapseItem:Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;

.field private volatile mIsAnimating:Z

.field private final mItemTypes:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawerItem$Type;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final mVisibleItems:Lcom/amazon/mShop/collect/BiMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/collect/BiMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 85
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-direct {p0, v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;-><init>(Ljava/util/Collection;)V

    .line 86
    return-void
.end method

.method public constructor <init>(Ljava/util/Collection;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 88
    .local p1, "items":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 71
    const-string/jumbo v0, "DISABLED"

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mCoins:Ljava/lang/String;

    .line 89
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mDrawerItems:Ljava/util/Map;

    .line 90
    new-instance v0, Lcom/amazon/mShop/collect/BiMap;

    invoke-direct {v0}, Lcom/amazon/mShop/collect/BiMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mVisibleItems:Lcom/amazon/mShop/collect/BiMap;

    .line 91
    invoke-static {}, Lcom/amazon/mShop/gno/GNOItemAdapter;->buildItemTypes()Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mItemTypes:Ljava/util/Map;

    .line 93
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->setItems(Ljava/util/Collection;)V

    .line 94
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/gno/GNOItemAdapter;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNOItemAdapter;

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mDrawerItems:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/gno/GNOItemAdapter;Ljava/util/Collection;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNOItemAdapter;
    .param p1, "x1"    # Ljava/util/Collection;

    .prologue
    .line 33
    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->addItems(Ljava/util/Collection;)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/gno/GNOItemAdapter;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNOItemAdapter;

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->collectVisibleItems()V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/mShop/gno/GNOItemAdapter;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNOItemAdapter;

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mExpandedGroupId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$402(Lcom/amazon/mShop/gno/GNOItemAdapter;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNOItemAdapter;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mExpandedGroupId:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$602(Lcom/amazon/mShop/gno/GNOItemAdapter;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNOItemAdapter;
    .param p1, "x1"    # Z

    .prologue
    .line 33
    iput-boolean p1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mIsAnimating:Z

    return p1
.end method

.method static synthetic access$900(Lcom/amazon/mShop/gno/GNOItemAdapter;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNOItemAdapter;

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mCoins:Ljava/lang/String;

    return-object v0
.end method

.method private addItems(Ljava/util/Collection;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 190
    .local p1, "items":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItem;

    .line 191
    .local v1, "item":Lcom/amazon/mShop/gno/GNODrawerItem;
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mDrawerItems:Ljava/util/Map;

    invoke-interface {v1}, Lcom/amazon/mShop/gno/GNODrawerItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 192
    invoke-interface {v1}, Lcom/amazon/mShop/gno/GNODrawerItem;->getChildren()Ljava/util/Collection;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/amazon/mShop/gno/GNOItemAdapter;->addItems(Ljava/util/Collection;)V

    goto :goto_0

    .line 194
    .end local v1    # "item":Lcom/amazon/mShop/gno/GNODrawerItem;
    :cond_0
    return-void
.end method

.method private static buildItemTypes()Ljava/util/Map;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawerItem$Type;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 100
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 101
    .local v2, "itemTypes":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/mShop/gno/GNODrawerItem$Type;Ljava/lang/Integer;>;"
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->values()[Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/mShop/gno/GNODrawerItem$Type;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v3, :cond_0

    aget-object v4, v0, v1

    .line 102
    .local v4, "type":Lcom/amazon/mShop/gno/GNODrawerItem$Type;
    invoke-interface {v2}, Ljava/util/Map;->size()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 101
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 105
    .end local v4    # "type":Lcom/amazon/mShop/gno/GNODrawerItem$Type;
    :cond_0
    return-object v2
.end method

.method private collectVisibleItems()V
    .locals 6

    .prologue
    .line 169
    iget-object v3, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mVisibleItems:Lcom/amazon/mShop/collect/BiMap;

    invoke-virtual {v3}, Lcom/amazon/mShop/collect/BiMap;->clear()V

    .line 171
    iget-object v3, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mDrawerItems:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_4

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItem;

    .line 172
    .local v1, "item":Lcom/amazon/mShop/gno/GNODrawerItem;
    instance-of v3, v1, Lcom/amazon/mShop/gno/GNOItemAdapter$HideableItem;

    if-eqz v3, :cond_1

    move-object v3, v1

    check-cast v3, Lcom/amazon/mShop/gno/GNOItemAdapter$HideableItem;

    invoke-interface {v3}, Lcom/amazon/mShop/gno/GNOItemAdapter$HideableItem;->isHidden()Z

    move-result v3

    if-nez v3, :cond_0

    .line 173
    :cond_1
    invoke-interface {v1}, Lcom/amazon/mShop/gno/GNODrawerItem;->getParent()Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v2

    .line 177
    .local v2, "parent":Lcom/amazon/mShop/gno/GNODrawerItem;
    if-eqz v2, :cond_2

    iget-boolean v3, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mIsAnimating:Z

    if-nez v3, :cond_3

    invoke-interface {v2}, Lcom/amazon/mShop/gno/GNODrawerItem;->getId()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mExpandedGroupId:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 178
    :cond_2
    iget-object v3, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mVisibleItems:Lcom/amazon/mShop/collect/BiMap;

    iget-object v4, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mVisibleItems:Lcom/amazon/mShop/collect/BiMap;

    invoke-virtual {v4}, Lcom/amazon/mShop/collect/BiMap;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v1}, Lcom/amazon/mShop/gno/GNODrawerItem;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/amazon/mShop/collect/BiMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 182
    :cond_3
    iget-boolean v3, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mIsAnimating:Z

    if-eqz v3, :cond_0

    invoke-interface {v1}, Lcom/amazon/mShop/gno/GNODrawerItem;->getId()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mExpandedGroupId:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 183
    iget-object v3, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mVisibleItems:Lcom/amazon/mShop/collect/BiMap;

    iget-object v4, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mVisibleItems:Lcom/amazon/mShop/collect/BiMap;

    invoke-virtual {v4}, Lcom/amazon/mShop/collect/BiMap;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    const-string/jumbo v5, "GNOItemAdapter.FakeExpandCollapseItem"

    invoke-virtual {v3, v4, v5}, Lcom/amazon/mShop/collect/BiMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 187
    .end local v1    # "item":Lcom/amazon/mShop/gno/GNODrawerItem;
    .end local v2    # "parent":Lcom/amazon/mShop/gno/GNODrawerItem;
    :cond_4
    return-void
.end method

.method public static getAdapterPosition(I)I
    .locals 1
    .param p0, "listViewPosition"    # I

    .prologue
    .line 531
    div-int/lit8 v0, p0, 0x2

    return v0
.end method

.method private getDivider(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v5, 0x0

    .line 484
    if-eqz p2, :cond_0

    .line 485
    move-object v3, p2

    .line 486
    .local v3, "view":Landroid/view/View;
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerViewHolder;

    .line 498
    .local v4, "viewHolder":Lcom/amazon/mShop/gno/GNOItemAdapter$DividerViewHolder;
    :goto_0
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getItem(I)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v1

    .line 499
    .local v1, "itemBelowDivider":Lcom/amazon/mShop/gno/GNODrawerItem;
    add-int/lit8 v6, p1, -0x2

    invoke-virtual {p0, v6}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getItem(I)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v0

    .line 501
    .local v0, "itemAboveDivider":Lcom/amazon/mShop/gno/GNODrawerItem;
    if-eqz v0, :cond_3

    invoke-interface {v0}, Lcom/amazon/mShop/gno/GNODrawerItem;->allowDividers()Z

    move-result v6

    if-eqz v6, :cond_3

    if-eqz v1, :cond_3

    invoke-interface {v1}, Lcom/amazon/mShop/gno/GNODrawerItem;->allowDividers()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 505
    iget-object v6, v4, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerViewHolder;->dividerLine:Landroid/view/View;

    invoke-virtual {v6, v5}, Landroid/view/View;->setVisibility(I)V

    .line 509
    :goto_1
    return-object v3

    .line 488
    .end local v0    # "itemAboveDivider":Lcom/amazon/mShop/gno/GNODrawerItem;
    .end local v1    # "itemBelowDivider":Lcom/amazon/mShop/gno/GNODrawerItem;
    .end local v3    # "view":Landroid/view/View;
    .end local v4    # "viewHolder":Lcom/amazon/mShop/gno/GNOItemAdapter$DividerViewHolder;
    :cond_0
    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getDividerType(I)Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    move-result-object v6

    sget-object v7, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;->SUB_DIVIDER:Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    if-ne v6, v7, :cond_1

    const/4 v2, 0x1

    .line 489
    .local v2, "shouldUseIndentedDivider":Z
    :goto_2
    invoke-virtual {p3}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v7

    if-eqz v2, :cond_2

    sget v6, Lcom/amazon/mShop/android/lib/R$layout;->gno_drawer_sub_item_divider:I

    :goto_3
    invoke-virtual {v7, v6, p3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 492
    .restart local v3    # "view":Landroid/view/View;
    new-instance v4, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerViewHolder;

    const/4 v6, 0x0

    invoke-direct {v4, p0, v6}, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerViewHolder;-><init>(Lcom/amazon/mShop/gno/GNOItemAdapter;Lcom/amazon/mShop/gno/GNOItemAdapter$1;)V

    .line 493
    .restart local v4    # "viewHolder":Lcom/amazon/mShop/gno/GNOItemAdapter$DividerViewHolder;
    sget v6, Lcom/amazon/mShop/android/lib/R$id;->gno_drawer_item_divider:I

    invoke-virtual {v3, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    iput-object v6, v4, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerViewHolder;->dividerLine:Landroid/view/View;

    .line 495
    invoke-virtual {v3, v4}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    goto :goto_0

    .end local v2    # "shouldUseIndentedDivider":Z
    .end local v3    # "view":Landroid/view/View;
    .end local v4    # "viewHolder":Lcom/amazon/mShop/gno/GNOItemAdapter$DividerViewHolder;
    :cond_1
    move v2, v5

    .line 488
    goto :goto_2

    .line 489
    .restart local v2    # "shouldUseIndentedDivider":Z
    :cond_2
    sget v6, Lcom/amazon/mShop/android/lib/R$layout;->gno_drawer_item_divider:I

    goto :goto_3

    .line 507
    .end local v2    # "shouldUseIndentedDivider":Z
    .restart local v0    # "itemAboveDivider":Lcom/amazon/mShop/gno/GNODrawerItem;
    .restart local v1    # "itemBelowDivider":Lcom/amazon/mShop/gno/GNODrawerItem;
    .restart local v3    # "view":Landroid/view/View;
    .restart local v4    # "viewHolder":Lcom/amazon/mShop/gno/GNOItemAdapter$DividerViewHolder;
    :cond_3
    iget-object v5, v4, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerViewHolder;->dividerLine:Landroid/view/View;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1
.end method

.method private getDividerType(I)Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 455
    if-lez p1, :cond_0

    .line 456
    add-int/lit8 v2, p1, -0x2

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getItem(I)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v0

    .line 457
    .local v0, "itemAboveDivider":Lcom/amazon/mShop/gno/GNODrawerItem;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getItem(I)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v1

    .line 460
    .local v1, "itemBelowDivider":Lcom/amazon/mShop/gno/GNODrawerItem;
    invoke-interface {v1}, Lcom/amazon/mShop/gno/GNODrawerItem;->getParent()Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Lcom/amazon/mShop/gno/GNODrawerItem;->getParent()Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 462
    sget-object v2, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;->SUB_DIVIDER:Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    .line 466
    .end local v0    # "itemAboveDivider":Lcom/amazon/mShop/gno/GNODrawerItem;
    .end local v1    # "itemBelowDivider":Lcom/amazon/mShop/gno/GNODrawerItem;
    :goto_0
    return-object v2

    :cond_0
    sget-object v2, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;->DIVIDER:Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    goto :goto_0
.end method

.method public static getListViewPosition(I)I
    .locals 1
    .param p0, "adapterPosition"    # I

    .prologue
    .line 521
    mul-int/lit8 v0, p0, 0x2

    add-int/lit8 v0, v0, 0x1

    return v0
.end method

.method private isDivider(I)Z
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 447
    rem-int/lit8 v0, p1, 0x2

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setupFakeExpandCollapseAnimation(ZZLjava/lang/Runnable;)V
    .locals 1
    .param p1, "expanding"    # Z
    .param p2, "shouldShowExpandingArea"    # Z
    .param p3, "endAction"    # Ljava/lang/Runnable;

    .prologue
    .line 653
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mFakeExpandCollapseItem:Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;

    if-nez v0, :cond_0

    .line 654
    new-instance v0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;-><init>(Lcom/amazon/mShop/gno/GNOItemAdapter;)V

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mFakeExpandCollapseItem:Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;

    .line 657
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mFakeExpandCollapseItem:Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->setAnimationType(ZZLjava/lang/Runnable;)V

    .line 658
    return-void
.end method


# virtual methods
.method public clearItems()V
    .locals 1

    .prologue
    .line 200
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mVisibleItems:Lcom/amazon/mShop/collect/BiMap;

    invoke-virtual {v0}, Lcom/amazon/mShop/collect/BiMap;->clear()V

    .line 201
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mDrawerItems:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 202
    return-void
.end method

.method public collapseExpandedGroup()V
    .locals 1

    .prologue
    .line 396
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->collapseExpandedGroup(Z)V

    .line 397
    return-void
.end method

.method public collapseExpandedGroup(Z)V
    .locals 3
    .param p1, "animate"    # Z

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 404
    if-eqz p1, :cond_0

    .line 405
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mIsAnimating:Z

    .line 408
    invoke-direct {p0, v1, v1, v2}, Lcom/amazon/mShop/gno/GNOItemAdapter;->setupFakeExpandCollapseAnimation(ZZLjava/lang/Runnable;)V

    .line 419
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->updateVisibleItems()V

    .line 420
    return-void

    .line 414
    :cond_0
    iput-object v2, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mExpandedGroupId:Ljava/lang/String;

    goto :goto_0
.end method

.method public collapseGroup(Ljava/lang/String;Z)Z
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "animate"    # Z

    .prologue
    .line 384
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mExpandedGroupId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 385
    invoke-virtual {p0, p2}, Lcom/amazon/mShop/gno/GNOItemAdapter;->collapseExpandedGroup(Z)V

    .line 386
    const/4 v0, 0x1

    .line 389
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public contains(Ljava/lang/String;)Z
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 209
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mDrawerItems:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public createAppstoreCoinTabCallable()Ljava/util/concurrent/Callable;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/concurrent/Callable",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .prologue
    .line 665
    new-instance v0, Lcom/amazon/mShop/gno/GNOItemAdapter$6;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/gno/GNOItemAdapter$6;-><init>(Lcom/amazon/mShop/gno/GNOItemAdapter;)V

    return-object v0
.end method

.method public expandGroup(Ljava/lang/String;)Z
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 300
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->expandGroup(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public expandGroup(Ljava/lang/String;Z)Z
    .locals 5
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "animate"    # Z

    .prologue
    const/4 v2, 0x1

    .line 309
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->contains(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 310
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mExpandedGroupId:Ljava/lang/String;

    .line 311
    invoke-static {}, Lcom/amazon/mShop/AmazonActivity;->getTopMostBaseActivity()Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    .line 312
    .local v0, "activity":Lcom/amazon/mShop/AmazonActivity;
    if-eqz p2, :cond_0

    .line 313
    iput-boolean v2, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mIsAnimating:Z

    .line 318
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mExpandedGroupId:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawer;->isLastVisibleItem(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 319
    const/4 v1, 0x1

    .line 322
    .local v1, "shouldShowExpandingArea":Z
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawer;->getListView()Landroid/widget/ListView;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/widget/ListView;->setTranscriptMode(I)V

    .line 328
    :goto_0
    new-instance v3, Lcom/amazon/mShop/gno/GNOItemAdapter$4;

    invoke-direct {v3, p0, v1, v0}, Lcom/amazon/mShop/gno/GNOItemAdapter$4;-><init>(Lcom/amazon/mShop/gno/GNOItemAdapter;ZLcom/amazon/mShop/AmazonActivity;)V

    invoke-direct {p0, v2, v1, v3}, Lcom/amazon/mShop/gno/GNOItemAdapter;->setupFakeExpandCollapseAnimation(ZZLjava/lang/Runnable;)V

    .line 343
    .end local v1    # "shouldShowExpandingArea":Z
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->updateVisibleItems()V

    .line 349
    if-eqz p2, :cond_1

    .line 350
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    new-instance v4, Lcom/amazon/mShop/gno/GNOItemAdapter$5;

    invoke-direct {v4, p0, v0}, Lcom/amazon/mShop/gno/GNOItemAdapter$5;-><init>(Lcom/amazon/mShop/gno/GNOItemAdapter;Lcom/amazon/mShop/AmazonActivity;)V

    invoke-interface {v3, v4}, Lcom/amazon/mShop/platform/Platform;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 364
    .end local v0    # "activity":Lcom/amazon/mShop/AmazonActivity;
    :cond_1
    :goto_1
    return v2

    .line 324
    .restart local v0    # "activity":Lcom/amazon/mShop/AmazonActivity;
    :cond_2
    const/4 v1, 0x0

    .restart local v1    # "shouldShowExpandingArea":Z
    goto :goto_0

    .line 364
    .end local v0    # "activity":Lcom/amazon/mShop/AmazonActivity;
    .end local v1    # "shouldShowExpandingArea":Z
    :cond_3
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public getCoinValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 661
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mCoins:Ljava/lang/String;

    return-object v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 218
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mVisibleItems:Lcom/amazon/mShop/collect/BiMap;

    invoke-virtual {v0}, Lcom/amazon/mShop/collect/BiMap;->size()I

    move-result v0

    mul-int/lit8 v0, v0, 0x2

    return v0
.end method

.method public getItem(I)Lcom/amazon/mShop/gno/GNODrawerItem;
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 223
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mVisibleItems:Lcom/amazon/mShop/collect/BiMap;

    invoke-static {p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getAdapterPosition(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/collect/BiMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 227
    .local v0, "itemId":Ljava/lang/String;
    const-string/jumbo v1, "GNOItemAdapter.FakeExpandCollapseItem"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 228
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mFakeExpandCollapseItem:Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;

    .line 231
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mDrawerItems:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItem;

    goto :goto_0
.end method

.method public getItem(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItem;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 291
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mDrawerItems:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItem;

    return-object v0
.end method

.method public bridge synthetic getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 33
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getItem(I)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 236
    int-to-long v0, p1

    return-wide v0
.end method

.method public getItemViewType(I)I
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 256
    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->isDivider(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 257
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mItemTypes:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getDividerType(I)Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    move-result-object v1

    # getter for: Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;->mValue:I
    invoke-static {v1}, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;->access$300(Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;)I

    move-result v1

    add-int/2addr v0, v1

    .line 259
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mItemTypes:Ljava/util/Map;

    invoke-virtual {p0, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getItem(I)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/gno/GNODrawerItem;->getType()Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    goto :goto_0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 241
    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->isDivider(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 242
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getDivider(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 244
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getItem(I)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v0

    invoke-interface {v0, p2, p3}, Lcom/amazon/mShop/gno/GNODrawerItem;->getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    goto :goto_0
.end method

.method public getViewTypeCount()I
    .locals 2

    .prologue
    .line 251
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->values()[Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    move-result-object v0

    array-length v0, v0

    invoke-static {}, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;->values()[Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    move-result-object v1

    array-length v1, v1

    add-int/2addr v0, v1

    return v0
.end method

.method public getVisibleItemPosition(Ljava/lang/String;)I
    .locals 2
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 281
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mVisibleItems:Lcom/amazon/mShop/collect/BiMap;

    invoke-virtual {v1}, Lcom/amazon/mShop/collect/BiMap;->inverse()Lcom/amazon/mShop/collect/BiMap;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/collect/BiMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 282
    .local v0, "pos":Ljava/lang/Integer;
    if-nez v0, :cond_0

    const/4 v1, -0x1

    :goto_0
    return v1

    :cond_0
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    goto :goto_0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 272
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mDrawerItems:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public isGroupExpanded(Ljava/lang/String;)Z
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 428
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mExpandedGroupId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public iterator()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 265
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mDrawerItems:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method

.method public setAppstoreCoinsCount(Ljava/lang/String;)V
    .locals 2
    .param p1, "coinNum"    # Ljava/lang/String;

    .prologue
    .line 132
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mCoins:Ljava/lang/String;

    .line 133
    const-string/jumbo v0, "0"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 134
    const-string/jumbo v0, "DISABLED"

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter;->mCoins:Ljava/lang/String;

    .line 136
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/gno/GNOItemAdapter$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/gno/GNOItemAdapter$2;-><init>(Lcom/amazon/mShop/gno/GNOItemAdapter;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 151
    return-void
.end method

.method public setItems(Ljava/util/Collection;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 114
    .local p1, "items":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/gno/GNOItemAdapter$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter$1;-><init>(Lcom/amazon/mShop/gno/GNOItemAdapter;Ljava/util/Collection;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 123
    return-void
.end method

.method public updateVisibleItems()V
    .locals 2

    .prologue
    .line 156
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/gno/GNOItemAdapter$3;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/gno/GNOItemAdapter$3;-><init>(Lcom/amazon/mShop/gno/GNOItemAdapter;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 163
    return-void
.end method
