.class public Lcom/amazon/retailsearch/android/ui/results/ProductUtil;
.super Ljava/lang/Object;
.source "ProductUtil.java"


# static fields
.field public static final ACTION_ICON_RADIUS:I = 0x17


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static formatNumber(J)Ljava/lang/String;
    .locals 1
    .param p0, "count"    # J

    .prologue
    .line 166
    invoke-static {}, Ljava/text/NumberFormat;->getInstance()Ljava/text/NumberFormat;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Ljava/text/NumberFormat;->format(J)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static formatReviewCount(ILandroid/content/res/Resources;)Ljava/lang/String;
    .locals 6
    .param p0, "count"    # I
    .param p1, "resources"    # Landroid/content/res/Resources;

    .prologue
    const/4 v1, 0x1

    .line 149
    if-ge p0, v1, :cond_0

    .line 150
    const-string/jumbo v0, ""

    .line 155
    :goto_0
    return-object v0

    .line 151
    :cond_0
    if-ne p0, v1, :cond_1

    .line 152
    sget v0, Lcom/amazon/retailsearch/R$string;->product_review_single:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 155
    :cond_1
    sget v0, Lcom/amazon/retailsearch/R$string;->product_review_count:I

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {}, Ljava/text/NumberFormat;->getInstance()Ljava/text/NumberFormat;

    move-result-object v3

    int-to-long v4, p0

    invoke-virtual {v3, v4, v5}, Ljava/text/NumberFormat;->format(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {p1, v0, v1}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getFkmrProductCount(Lcom/amazon/searchapp/retailsearch/model/FKMR;)I
    .locals 1
    .param p0, "fkmr"    # Lcom/amazon/searchapp/retailsearch/model/FKMR;

    .prologue
    .line 88
    if-eqz p0, :cond_0

    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getImageGallery(Lcom/amazon/searchapp/retailsearch/model/Product;)Ljava/util/List;
    .locals 1
    .param p0, "product"    # Lcom/amazon/searchapp/retailsearch/model/Product;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/model/Product;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Image;",
            ">;"
        }
    .end annotation

    .prologue
    .line 193
    if-nez p0, :cond_0

    .line 194
    const/4 v0, 0x0

    .line 197
    :goto_0
    return-object v0

    :cond_0
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Product;->getImageGallery()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Product;->getImageGallery()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Product;->getImageGallery()Ljava/util/List;

    move-result-object v0

    goto :goto_0

    :cond_1
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Product;->getAltImages()Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public static getPrimeProgramBadgeId(Lcom/amazon/searchapp/retailsearch/model/Shipping;)Ljava/lang/String;
    .locals 3
    .param p0, "shippingInfo"    # Lcom/amazon/searchapp/retailsearch/model/Shipping;

    .prologue
    .line 122
    if-eqz p0, :cond_2

    .line 124
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getPrime()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getPrime()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;->getHasBadge()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 126
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getPrime()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;->getBadgeAssetId()Ljava/lang/String;

    move-result-object v2

    .line 139
    :goto_0
    return-object v2

    .line 128
    :cond_0
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getAdditionalStatus()Ljava/util/List;

    move-result-object v2

    if-eqz v2, :cond_2

    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getAdditionalStatus()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_2

    .line 130
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getAdditionalStatus()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    .line 132
    .local v1, "shippingStatus":Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;
    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;->getHasBadge()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 134
    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;->getBadgeAssetId()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 139
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "shippingStatus":Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;
    :cond_2
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public static getShipping(Lcom/amazon/searchapp/retailsearch/model/Prices;Lcom/amazon/searchapp/retailsearch/model/Shipping;)Lcom/amazon/searchapp/retailsearch/model/Shipping;
    .locals 2
    .param p0, "prices"    # Lcom/amazon/searchapp/retailsearch/model/Prices;
    .param p1, "shipping"    # Lcom/amazon/searchapp/retailsearch/model/Shipping;

    .prologue
    .line 105
    if-eqz p0, :cond_0

    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getEditions()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getEditions()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 108
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getEditions()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getShipping()Lcom/amazon/searchapp/retailsearch/model/Shipping;

    move-result-object p1

    .line 111
    .end local p1    # "shipping":Lcom/amazon/searchapp/retailsearch/model/Shipping;
    :cond_0
    return-object p1
.end method
