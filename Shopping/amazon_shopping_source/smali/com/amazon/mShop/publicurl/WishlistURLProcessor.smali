.class public Lcom/amazon/mShop/publicurl/WishlistURLProcessor;
.super Lcom/amazon/mShop/publicurl/PublicURLProcessor;
.source "WishlistURLProcessor.java"


# direct methods
.method public constructor <init>(Landroid/net/Uri;)V
    .locals 0
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 14
    invoke-direct {p0, p1}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;-><init>(Landroid/net/Uri;)V

    .line 15
    return-void
.end method


# virtual methods
.method protected doProcess(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 20
    sget-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_NOTIFICATION:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/mShop/publicurl/WishlistURLProcessor;->getOrigin()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 21
    const-string/jumbo v0, "pn_wishlist_t"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 23
    :cond_0
    sget-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_PUBLIC_URL:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/mShop/publicurl/WishlistURLProcessor;->getParams()Ljava/util/Map;

    move-result-object v1

    const/high16 v2, 0x80000

    invoke-static {p1, v0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->startWishListActivity(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;I)Z

    .line 24
    return-void
.end method

.method public getMetricIdentity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    const-string/jumbo v0, "WL"

    return-object v0
.end method
