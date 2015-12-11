.class public Lcom/amazon/mShop/recommendations/RecommendationsItemView;
.super Lcom/amazon/mShop/ItemView;
.source "RecommendationsItemView.java"


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
.method protected dispatchSetPressed(Z)V
    .locals 0
    .param p1, "pressed"    # Z

    .prologue
    .line 35
    return-void
.end method

.method public shouldShowItemBadge(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z
    .locals 1
    .param p1, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    .line 40
    const/4 v0, 0x0

    return v0
.end method
