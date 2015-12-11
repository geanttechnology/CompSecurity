.class public Lcom/amazon/retailsearch/android/ui/results/views/price/PriceSplit;
.super Lcom/amazon/retailsearch/android/ui/results/views/price/Price;
.source "PriceSplit.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 21
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 22
    return-void
.end method


# virtual methods
.method protected postInflate()V
    .locals 2

    .prologue
    .line 30
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceSplit;->priceLineList:Ljava/util/List;

    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_price_line0:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceSplit;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 31
    return-void
.end method
