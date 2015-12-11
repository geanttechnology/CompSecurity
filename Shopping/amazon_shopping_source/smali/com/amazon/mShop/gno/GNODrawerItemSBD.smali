.class public Lcom/amazon/mShop/gno/GNODrawerItemSBD;
.super Lcom/amazon/mShop/gno/GNODrawerItemGroup;
.source "GNODrawerItemSBD.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;
    }
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "id"    # Ljava/lang/String;

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 25
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemSBD$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/gno/GNODrawerItemSBD$1;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemSBD;)V

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSBD;->mExpandableIconClickListener:Landroid/view/View$OnClickListener;

    .line 34
    return-void
.end method

.method public static builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            ")",
            "Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 20
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;

    invoke-direct {v0, p0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "convertView"    # Landroid/view/View;
    .param p2, "root"    # Landroid/view/ViewGroup;

    .prologue
    .line 38
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 40
    .local v2, "view":Landroid/view/View;
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->group_item_expandable_arrow:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 41
    .local v0, "arrowIcon":Landroid/widget/ImageView;
    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->action_bar_arrow_right:I

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 42
    iget-object v3, p0, Lcom/amazon/mShop/gno/GNODrawerItemSBD;->mExpandableIconClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 44
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->group_item_vertical_divider:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 45
    .local v1, "divider":Landroid/view/View;
    const/16 v3, 0x8

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 46
    return-object v2
.end method
