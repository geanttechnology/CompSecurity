.class public Lcom/amazon/mShop/search/SearchItemView;
.super Lcom/amazon/mShop/ItemView;
.source "SearchItemView.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 17
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/ItemView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 18
    return-void
.end method


# virtual methods
.method protected onFinishInflate()V
    .locals 2

    .prologue
    .line 22
    invoke-super {p0}, Lcom/amazon/mShop/ItemView;->onFinishInflate()V

    .line 24
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->search_results_sub_header:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/SearchItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 25
    .local v0, "subHeader":Landroid/widget/TextView;
    new-instance v1, Lcom/amazon/mShop/search/SearchItemView$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/SearchItemView$1;-><init>(Lcom/amazon/mShop/search/SearchItemView;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 33
    return-void
.end method

.method public update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;Landroid/graphics/drawable/Drawable;I)V
    .locals 3
    .param p1, "adapter"    # Lcom/amazon/mShop/ObjectSubscriberAdapter;
    .param p2, "obj"    # Ljava/lang/Object;
    .param p3, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p4, "index"    # I

    .prologue
    .line 37
    invoke-super {p0, p1, p2, p3, p4}, Lcom/amazon/mShop/ItemView;->update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;Landroid/graphics/drawable/Drawable;I)V

    move-object v0, p2

    .line 41
    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 42
    .local v0, "searchResult":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/search/SearchItemView;->showBadgeImageTogetherWithPrice(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V

    .line 43
    return-void
.end method
