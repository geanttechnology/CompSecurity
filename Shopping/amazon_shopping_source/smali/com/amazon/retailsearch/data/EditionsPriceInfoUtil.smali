.class public Lcom/amazon/retailsearch/data/EditionsPriceInfoUtil;
.super Ljava/lang/Object;
.source "EditionsPriceInfoUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static toPriceInfo(Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;)Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .locals 3
    .param p0, "epi"    # Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;

    .prologue
    .line 18
    new-instance v0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;

    invoke-direct {v0}, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;-><init>()V

    .line 19
    .local v0, "pi":Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getAudienceRating()Lcom/amazon/searchapp/retailsearch/model/AudienceRating;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->setAudienceRating(Lcom/amazon/searchapp/retailsearch/model/AudienceRating;)V

    .line 20
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getAvailability()Lcom/amazon/searchapp/retailsearch/model/Availability;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->setAvailability(Lcom/amazon/searchapp/retailsearch/model/Availability;)V

    .line 21
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getIssuePrice()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->setIssuePrice(Ljava/lang/String;)V

    .line 22
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->setLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V

    .line 23
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getListPrice()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->setListPrice(Ljava/lang/String;)V

    .line 24
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getMap()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->setMap(Lcom/amazon/searchapp/retailsearch/model/Link;)V

    .line 25
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getMarketplaceLabel()Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->setMarketplaceLabel(Ljava/util/List;)V

    .line 26
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getOfferCount()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->setOfferCount(J)V

    .line 27
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getPostLinkText()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->setPostLinkText(Ljava/lang/String;)V

    .line 28
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getPreLinkText()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->setPreLinkText(Ljava/lang/String;)V

    .line 29
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getPrice()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->setPrice(Ljava/lang/String;)V

    .line 30
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getRatings()Lcom/amazon/searchapp/retailsearch/model/Ratings;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->setRatings(Lcom/amazon/searchapp/retailsearch/model/Ratings;)V

    .line 31
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getShipping()Lcom/amazon/searchapp/retailsearch/model/Shipping;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->setShipping(Lcom/amazon/searchapp/retailsearch/model/Shipping;)V

    .line 32
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getUnitPrice()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->setUnitPrice(Ljava/lang/String;)V

    .line 33
    return-object v0
.end method
