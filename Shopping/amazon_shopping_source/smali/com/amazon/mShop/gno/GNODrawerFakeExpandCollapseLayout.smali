.class public Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;
.super Landroid/widget/FrameLayout;
.source "GNODrawerFakeExpandCollapseLayout.java"


# instance fields
.field private mContext:Landroid/content/Context;

.field private mGNOChildrenCount:I

.field private mHeight:I

.field private mLayoutDelegate:Landroid/widget/LinearLayout;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 31
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 32
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mContext:Landroid/content/Context;

    .line 33
    new-instance v0, Landroid/widget/LinearLayout;

    invoke-direct {v0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mLayoutDelegate:Landroid/widget/LinearLayout;

    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mLayoutDelegate:Landroid/widget/LinearLayout;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 35
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mLayoutDelegate:Landroid/widget/LinearLayout;

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$color;->gno_menu_sub_item_background:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundColor(I)V

    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mLayoutDelegate:Landroid/widget/LinearLayout;

    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    invoke-static {}, Lcom/amazon/mShop/util/LayoutUtils;->fillWidthWrapHeight()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/widget/LinearLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 37
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mLayoutDelegate:Landroid/widget/LinearLayout;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->addView(Landroid/view/View;)V

    .line 39
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout$1;-><init>(Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 46
    return-void
.end method


# virtual methods
.method public setItems(Ljava/util/Collection;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<+",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "items":Ljava/util/Collection;, "Ljava/util/Collection<+Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    const/4 v9, 0x0

    const/4 v8, 0x0

    .line 49
    iget-object v6, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mLayoutDelegate:Landroid/widget/LinearLayout;

    invoke-virtual {v6}, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    const/4 v7, -0x2

    iput v7, v6, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 50
    iget-object v6, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mLayoutDelegate:Landroid/widget/LinearLayout;

    invoke-virtual {v6}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 52
    const/4 v2, 0x1

    .line 53
    .local v2, "isFirstItem":Z
    const/4 v4, 0x1

    .line 54
    .local v4, "itemBeforeAllowsDividers":Z
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/gno/GNODrawerItem;

    .line 56
    .local v3, "item":Lcom/amazon/mShop/gno/GNODrawerItem;
    if-nez v2, :cond_0

    if-eqz v4, :cond_0

    invoke-interface {v3}, Lcom/amazon/mShop/gno/GNODrawerItem;->allowDividers()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 57
    iget-object v6, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mContext:Landroid/content/Context;

    sget v7, Lcom/amazon/mShop/android/lib/R$layout;->gno_drawer_sub_item_divider:I

    invoke-static {v6, v7, v9}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 58
    .local v0, "divider":Landroid/view/View;
    iget-object v6, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mLayoutDelegate:Landroid/widget/LinearLayout;

    invoke-virtual {v6, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 61
    .end local v0    # "divider":Landroid/view/View;
    :cond_0
    invoke-interface {v3, v9, p0}, Lcom/amazon/mShop/gno/GNODrawerItem;->getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    .line 62
    .local v5, "subItem":Landroid/view/View;
    iget-object v6, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mLayoutDelegate:Landroid/widget/LinearLayout;

    invoke-virtual {v6, v5}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 64
    const/4 v2, 0x0

    .line 65
    invoke-interface {v3}, Lcom/amazon/mShop/gno/GNODrawerItem;->allowDividers()Z

    move-result v4

    .line 66
    goto :goto_0

    .line 68
    .end local v3    # "item":Lcom/amazon/mShop/gno/GNODrawerItem;
    .end local v5    # "subItem":Landroid/view/View;
    :cond_1
    invoke-static {v8, v8}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v6

    invoke-static {v8, v8}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v7

    invoke-virtual {p0, v6, v7}, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->measure(II)V

    .line 71
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->getMeasuredHeight()I

    move-result v6

    iput v6, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mHeight:I

    .line 73
    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v6

    iput v6, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mGNOChildrenCount:I

    .line 74
    return-void
.end method

.method public startExpandCollapseAnimation(ZZLjava/lang/Runnable;)V
    .locals 10
    .param p1, "expand"    # Z
    .param p2, "showExpandingArea"    # Z
    .param p3, "endAction"    # Ljava/lang/Runnable;

    .prologue
    const/4 v7, 0x1

    .line 78
    new-instance v0, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;

    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mLayoutDelegate:Landroid/widget/LinearLayout;

    if-eqz p1, :cond_1

    move v2, v7

    :goto_0
    iget v3, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mHeight:I

    iget v4, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mGNOChildrenCount:I

    int-to-long v4, v4

    iget-object v6, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mContext:Landroid/content/Context;

    invoke-static {v6, p1}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->getAnimationDurationMillis(Landroid/content/Context;Z)J

    move-result-wide v8

    mul-long v5, v4, v8

    move v4, p2

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;-><init>(Landroid/view/View;IIZJ)V

    .line 85
    .local v0, "animation":Lcom/amazon/mShop/anim/ExpandCollapseAnimation;
    if-eqz p1, :cond_0

    .line 92
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mLayoutDelegate:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    iput v7, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 97
    invoke-virtual {v0, v7}, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->setMinHeight(I)V

    .line 100
    :cond_0
    new-instance v1, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout$2;

    invoke-direct {v1, p0, p3}, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout$2;-><init>(Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;Ljava/lang/Runnable;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/anim/ExpandCollapseAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 115
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->mLayoutDelegate:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 116
    return-void

    .line 78
    .end local v0    # "animation":Lcom/amazon/mShop/anim/ExpandCollapseAnimation;
    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method
