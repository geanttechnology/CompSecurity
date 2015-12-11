.class public Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader;
.super Lcom/amazon/mShop/gno/GNODrawerItemGroup;
.source "GNODrawerItemAppstoreHeader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;
    }
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "id"    # Ljava/lang/String;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 26
    return-void
.end method

.method public static builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            ")",
            "Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 21
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    invoke-direct {v0, p0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8
    .param p1, "convertView"    # Landroid/view/View;
    .param p2, "root"    # Landroid/view/ViewGroup;

    .prologue
    const/16 v7, 0x8

    const/4 v6, 0x0

    .line 30
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v4

    .line 31
    .local v4, "view":Landroid/view/View;
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getCoinValue()Ljava/lang/String;

    move-result-object v0

    .line 32
    .local v0, "coin":Ljava/lang/String;
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->drawer_item_coin_text:I

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 33
    .local v3, "coinText":Landroid/widget/TextView;
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->drawer_item_coin_number:I

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 34
    .local v1, "coinNum":Landroid/widget/TextView;
    const-string/jumbo v5, "DISABLED"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 35
    invoke-virtual {v1, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 36
    invoke-virtual {v3, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 37
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 41
    const/4 v2, 0x2

    .line 42
    .local v2, "coinPlural":I
    const-string/jumbo v5, "1"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 43
    const/4 v2, 0x1

    .line 45
    :cond_0
    iget-object v5, p0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader;->mContext:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$plurals;->gno_appstore_coin:I

    invoke-virtual {v5, v6, v2}, Landroid/content/res/Resources;->getQuantityText(II)Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 50
    .end local v2    # "coinPlural":I
    :goto_0
    return-object v4

    .line 47
    :cond_1
    invoke-virtual {v1, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 48
    invoke-virtual {v3, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method
