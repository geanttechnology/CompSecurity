.class Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;
.super Lcom/amazon/mShop/gno/GNODrawerItemBase;
.source "GNOItemAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/gno/GNOItemAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FakeExpandCollapseDrawerItem"
.end annotation


# instance fields
.field private mEndActionRunnable:Ljava/lang/Runnable;

.field private mIsExpanding:Z

.field private mShouldShowExpandingArea:Z

.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/gno/GNOItemAdapter;)V
    .locals 0

    .prologue
    .line 569
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemBase;-><init>()V

    return-void
.end method

.method static synthetic access$700(Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;

    .prologue
    .line 551
    iget-boolean v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->mIsExpanding:Z

    return v0
.end method

.method static synthetic access$800(Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;)Ljava/lang/Runnable;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;

    .prologue
    .line 551
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->mEndActionRunnable:Ljava/lang/Runnable;

    return-object v0
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 626
    const-string/jumbo v0, "GNOItemAdapter.FakeExpandCollapseItem"

    return-object v0
.end method

.method public getType()Lcom/amazon/mShop/gno/GNODrawerItem$Type;
    .locals 1

    .prologue
    .line 618
    sget-object v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->FAKE_GROUP_ANIMATION:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    return-object v0
.end method

.method public getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8
    .param p1, "convertView"    # Landroid/view/View;
    .param p2, "root"    # Landroid/view/ViewGroup;

    .prologue
    .line 574
    if-nez p1, :cond_2

    .line 575
    new-instance v1, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;

    invoke-virtual {p2}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {v1, v5}, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;-><init>(Landroid/content/Context;)V

    .line 581
    .local v1, "groupWrapper":Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;
    :goto_0
    iget-object v5, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    iget-object v6, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    # getter for: Lcom/amazon/mShop/gno/GNOItemAdapter;->mExpandedGroupId:Ljava/lang/String;
    invoke-static {v6}, Lcom/amazon/mShop/gno/GNOItemAdapter;->access$400(Lcom/amazon/mShop/gno/GNOItemAdapter;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getItem(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v4

    .line 582
    .local v4, "parent":Lcom/amazon/mShop/gno/GNODrawerItem;
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 585
    .local v0, "children":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    invoke-interface {v4}, Lcom/amazon/mShop/gno/GNODrawerItem;->getChildren()Ljava/util/Collection;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/gno/GNODrawerItem;

    .line 586
    .local v3, "item":Lcom/amazon/mShop/gno/GNODrawerItem;
    instance-of v5, v3, Lcom/amazon/mShop/gno/GNODrawerItemHideable;

    if-eqz v5, :cond_1

    move-object v5, v3

    check-cast v5, Lcom/amazon/mShop/gno/GNOItemAdapter$HideableItem;

    invoke-interface {v5}, Lcom/amazon/mShop/gno/GNOItemAdapter$HideableItem;->isHidden()Z

    move-result v5

    if-nez v5, :cond_0

    .line 587
    :cond_1
    invoke-interface {v0, v3}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .end local v0    # "children":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    .end local v1    # "groupWrapper":Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "item":Lcom/amazon/mShop/gno/GNODrawerItem;
    .end local v4    # "parent":Lcom/amazon/mShop/gno/GNODrawerItem;
    :cond_2
    move-object v1, p1

    .line 577
    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;

    .restart local v1    # "groupWrapper":Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;
    goto :goto_0

    .line 591
    .restart local v0    # "children":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    .restart local v2    # "i$":Ljava/util/Iterator;
    .restart local v4    # "parent":Lcom/amazon/mShop/gno/GNODrawerItem;
    :cond_3
    invoke-virtual {v1, v0}, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->setItems(Ljava/util/Collection;)V

    .line 594
    iget-boolean v5, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->mIsExpanding:Z

    iget-boolean v6, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->mShouldShowExpandingArea:Z

    new-instance v7, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem$1;

    invoke-direct {v7, p0}, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem$1;-><init>(Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;)V

    invoke-virtual {v1, v5, v6, v7}, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->startExpandCollapseAnimation(ZZLjava/lang/Runnable;)V

    .line 613
    return-object v1
.end method

.method public setAnimationType(ZZLjava/lang/Runnable;)V
    .locals 0
    .param p1, "expanding"    # Z
    .param p2, "shouldShowExpandingArea"    # Z
    .param p3, "endAction"    # Ljava/lang/Runnable;

    .prologue
    .line 638
    iput-boolean p1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->mIsExpanding:Z

    .line 639
    iput-boolean p2, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->mShouldShowExpandingArea:Z

    .line 640
    iput-object p3, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->mEndActionRunnable:Ljava/lang/Runnable;

    .line 641
    return-void
.end method
