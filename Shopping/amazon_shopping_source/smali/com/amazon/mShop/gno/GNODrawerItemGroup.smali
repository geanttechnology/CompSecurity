.class public Lcom/amazon/mShop/gno/GNODrawerItemGroup;
.super Lcom/amazon/mShop/gno/GNODrawerItemHideable;
.source "GNODrawerItemGroup.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;
    }
.end annotation


# instance fields
.field protected mExpandableIconClickListener:Landroid/view/View$OnClickListener;

.field private volatile mIsAnimating:Z

.field private mIsExpanding:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "id"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 41
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemHideable;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 26
    iput-boolean v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->mIsAnimating:Z

    .line 38
    iput-boolean v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->mIsExpanding:Z

    .line 43
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemGroup;)V

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->mExpandableIconClickListener:Landroid/view/View$OnClickListener;

    .line 78
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/gno/GNODrawerItemGroup;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    .prologue
    .line 17
    iget-boolean v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->mIsExpanding:Z

    return v0
.end method

.method static synthetic access$002(Lcom/amazon/mShop/gno/GNODrawerItemGroup;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNODrawerItemGroup;
    .param p1, "x1"    # Z

    .prologue
    .line 17
    iput-boolean p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->mIsExpanding:Z

    return p1
.end method

.method static synthetic access$102(Lcom/amazon/mShop/gno/GNODrawerItemGroup;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNODrawerItemGroup;
    .param p1, "x1"    # Z

    .prologue
    .line 17
    iput-boolean p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->mIsAnimating:Z

    return p1
.end method

.method public static builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            ")",
            "Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 82
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    invoke-direct {v0, p0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "convertView"    # Landroid/view/View;
    .param p2, "root"    # Landroid/view/ViewGroup;

    .prologue
    .line 87
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 93
    .local v2, "view":Landroid/view/View;
    iget-boolean v3, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->mIsAnimating:Z

    if-eqz v3, :cond_1

    iget-boolean v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->mIsExpanding:Z

    .line 95
    .local v1, "isExpanded":Z
    :goto_0
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->group_item_expandable_arrow:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 97
    .local v0, "arrowIcon":Landroid/widget/ImageView;
    if-eqz v1, :cond_2

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->action_bar_arrow_up:I

    :goto_1
    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 100
    iget-object v3, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->mExpandableIconClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 103
    iget-boolean v3, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->mIsAnimating:Z

    if-nez v3, :cond_0

    .line 104
    invoke-virtual {v0}, Landroid/widget/ImageView;->clearAnimation()V

    .line 107
    :cond_0
    return-object v2

    .line 93
    .end local v0    # "arrowIcon":Landroid/widget/ImageView;
    .end local v1    # "isExpanded":Z
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNOItemAdapter;->isGroupExpanded(Ljava/lang/String;)Z

    move-result v1

    goto :goto_0

    .line 97
    .restart local v0    # "arrowIcon":Landroid/widget/ImageView;
    .restart local v1    # "isExpanded":Z
    :cond_2
    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->action_bar_arrow_down:I

    goto :goto_1
.end method
