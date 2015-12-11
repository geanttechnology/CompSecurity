.class public Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;
.super Landroid/widget/TableLayout;
.source "AmazonPointsSummaryView.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 18
    invoke-direct {p0, p1, p2}, Landroid/widget/TableLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 19
    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;->setColumnShrinkable(IZ)V

    .line 20
    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;->setColumnStretchable(IZ)V

    .line 21
    return-void
.end method

.method private addRow(Landroid/view/LayoutInflater;Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;I)V
    .locals 5
    .param p1, "layoutInflater"    # Landroid/view/LayoutInflater;
    .param p2, "pair"    # Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;
    .param p3, "color"    # I

    .prologue
    .line 41
    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->amazonpoints_summary_row:I

    const/4 v4, 0x0

    invoke-virtual {p1, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    .line 42
    .local v2, "row":Landroid/view/ViewGroup;
    invoke-virtual {v2, p3}, Landroid/view/ViewGroup;->setBackgroundColor(I)V

    .line 43
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->amazonpoints_summary_row_name:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 44
    .local v1, "name":Landroid/widget/TextView;
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 45
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->amazonpoints_summary_row_amount:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 46
    .local v0, "amount":Landroid/widget/TextView;
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 47
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;->addView(Landroid/view/View;)V

    .line 48
    return-void
.end method


# virtual methods
.method public update(Ljava/util/List;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p1, "amazonPointsSummary":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;->removeAllViews()V

    .line 25
    if-eqz p1, :cond_0

    .line 26
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v4

    .line 27
    .local v4, "inflater":Landroid/view/LayoutInflater;
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$color;->transparent:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    .line 28
    .local v0, "colorRowCurrent":I
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$color;->background_gray_light:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    .line 29
    .local v1, "colorRowNext":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v5

    if-ge v3, v5, :cond_0

    .line 30
    invoke-interface {p1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;

    invoke-direct {p0, v4, v5, v0}, Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;->addRow(Landroid/view/LayoutInflater;Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;I)V

    .line 33
    move v2, v0

    .line 34
    .local v2, "colorSaved":I
    move v0, v1

    .line 35
    move v1, v2

    .line 29
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 38
    .end local v0    # "colorRowCurrent":I
    .end local v1    # "colorRowNext":I
    .end local v2    # "colorSaved":I
    .end local v3    # "i":I
    .end local v4    # "inflater":Landroid/view/LayoutInflater;
    :cond_0
    return-void
.end method
