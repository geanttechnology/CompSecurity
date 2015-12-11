.class public Lcom/amazon/mShop/search/SearchItemViewForTwoResults;
.super Lcom/amazon/mShop/ItemView;
.source "SearchItemViewForTwoResults.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 14
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/ItemView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 15
    return-void
.end method


# virtual methods
.method public update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;Landroid/graphics/drawable/Drawable;I)V
    .locals 3
    .param p1, "adapter"    # Lcom/amazon/mShop/ObjectSubscriberAdapter;
    .param p2, "obj"    # Ljava/lang/Object;
    .param p3, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p4, "index"    # I

    .prologue
    .line 19
    invoke-super {p0, p1, p2, p3, p4}, Lcom/amazon/mShop/ItemView;->update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;Landroid/graphics/drawable/Drawable;I)V

    move-object v0, p2

    .line 23
    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 24
    .local v0, "searchResult":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/search/SearchItemViewForTwoResults;->showBadgeImageTogetherWithPrice(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V

    .line 25
    return-void
.end method
